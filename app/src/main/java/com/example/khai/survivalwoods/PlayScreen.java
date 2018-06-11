package com.example.khai.survivalwoods;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayScreen extends AppCompatActivity {
    private ImageView mImageView;
    private TextView mTextView;
    TextView displayName;
    TextView healthValue;
    TextView hungerValue;
    TextView thirstValue;
    TextView itemChange;

    Boolean inventoryButtonPressed;
    int currentPage;

    private Button itemClick;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private Button eat;
    private Button drink;
    private Button rest;

    Player player = new Player();
    private Story mStory = new Story();
    private Page mCurrentPage;

    private SoundPlayer sound;
    MediaPlayer gameSound, deathSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        String name = getIntent().getStringExtra("Name");
        displayName = findViewById(R.id.Name);
        displayName.setText(name);
        player.setName(name);
        addBeginningItems();
        int health = player.getHealth();
        int hunger = player.getHunger();
        int thirst = player.getThirst();
        healthValue = findViewById(R.id.healthvalue);
        hungerValue = findViewById(R.id.hungervalue);
        thirstValue = findViewById(R.id.thirstvalue);
        String healthS = Integer.toString(health);
        String hungerS = Integer.toString(hunger);
        String thirstS = Integer.toString(thirst);
        healthValue.setText(healthS);
        hungerValue.setText(hungerS);
        thirstValue.setText(thirstS);
        itemChange = findViewById(R.id.itemChange);
        inventoryButtonPressed = false;
        currentPage = 0;

        gameSound = MediaPlayer.create(PlayScreen.this, R.raw.creepythemesong);
        gameSound.start();
        gameSound.setLooping(true);

        deathSound = MediaPlayer.create(PlayScreen.this, R.raw.death);
    }
    protected void onResume() {
        super.onResume();
        sound = new SoundPlayer(this);
        gameSound.start();
        gameSound.setLooping(true);
        mImageView = findViewById(R.id.storyImageView);
        mTextView = findViewById((R.id.storyTextView));
        choice1 = findViewById(R.id.choice1);
        choice2 = findViewById(R.id.choice2);
        choice3 = findViewById(R.id.choice3);
        choice4 = findViewById(R.id.choice4);
        eat = findViewById(R.id.eatButton);
        drink = findViewById(R.id.drinkButton);
        rest = findViewById(R.id.restButton);
        itemClick = findViewById(R.id.itemButton);
        itemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInventoryScreen();
            }
        });
        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.inventory.items[0].Count() > 0){
                    player.changeThirst(50);
                    player.inventory.items[0].changeCount(-1);
                    int thirst = player.getThirst();
                    String thirstS = Integer.toString(thirst);
                    thirstValue.setText(thirstS);
                    sound.playDrinkSound();
                }
            }
        });
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.inventory.items[1].Count() > 0){
                    player.changeHunger(25);
                    player.inventory.items[1].changeCount(-1);
                    int hunger = player.getHunger();
                    String hungerS = Integer.toString(hunger);
                    hungerValue.setText(hungerS);
                    sound.playEatSound();
                }
            }
        });

        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.getThirst() > 0 || player.getHunger() > 0) {
                    player.changeHealth(5);
                    decreaseStats();
                    int health = player.getHealth();
                    String healthS = Integer.toString(health);
                    healthValue.setText(healthS);
                    sound.playRestSound();
                }
            }
        });
        loadPage(currentPage);
    }
    public void openInventoryScreen() {
        Intent intent = new Intent(this, InventoryScreen.class);
        intent.putExtra("player_data", player);
        startActivity(intent);
    }
    private void decreaseStats(){
        int hungerDecrease = -10;
        int thirstDecrease = -7 ;
        int healthDecrease = -5;
        if(player.getHunger() > 0 ) {
            player.changeHunger(hungerDecrease);
        }
        else{
            player.changeHealth(healthDecrease);
        }
        if(player.getThirst() > 0) {
            player.changeThirst(thirstDecrease);
        }
        else{
            player.changeHealth(healthDecrease * 2);
        }
        int hunger = player.getHunger();
        int thirst = player.getThirst();
        int health = player.getHealth();
        String hungerS = Integer.toString(hunger);
        String thirstS = Integer.toString(thirst);
        String healthS = Integer.toString(health);
        hungerValue.setText(hungerS);
        thirstValue.setText(thirstS);
        healthValue.setText(healthS);
    }
    public void addBeginningItems(){
        Item juice = new Item("juice", 5);
        Item candybar = new Item("candybar",5);
        player.inventory.addItem(juice);
        player.inventory.addItem(candybar);
    }
    public void changeItemAmount(int juiceGained, int candybarGained){
        player.inventory.items[0].changeCount(juiceGained);
        player.inventory.items[1].changeCount(candybarGained);
        String juiceS = null;
        String candyS = null;
        String text;
        itemChange.setVisibility(View.INVISIBLE);
        if (juiceGained > 0 && candybarGained > 0){
            juiceS = Integer.toString(juiceGained);
            candyS = Integer.toString(candybarGained);
        }
        else if(juiceGained > 0 && candybarGained == 0){
            juiceS = Integer.toString(juiceGained);
        }
        else if(juiceGained == 0 && candybarGained > 0){
            candyS = Integer.toString(candybarGained);
        }
        else{
            return;
        }

        if(juiceS == null && candyS == null){
            return;
        }
        else if(juiceS != null && candyS == null){
            itemChange.setVisibility(View.VISIBLE);
            if (juiceGained == 1) {
                text = "You've acquired 1 juice";
                itemChange.setText(text);
                return;
            }
            else{
                text = "You've acquired" + juiceS + "juices";
                return;
            }
        }
        else if(juiceS == null && candyS != null){
            itemChange.setVisibility(View.VISIBLE);
            if (candybarGained == 1) {
                text = "You've acquired 1 candybar";
                itemChange.setText(text);
                return;
            }
            else{
                text = "You've acquired" + candyS + "candybars";
                itemChange.setText(text);
                return;
            }
        }
        else if (juiceS != null && candyS != null){
            itemChange.setVisibility(View.VISIBLE);
            if (juiceGained == 1) {
                text = "You've acquired 1 juice";
            }
            else{
                text = "You've acquired " + juiceS + " juices";
            }
            if (candybarGained == 1) {
                text = text +" and 1 candybar";
                itemChange.setText(text);
                return;
            }
            else{
                text = text +" and " + candyS+ " candybars";
                itemChange.setText(text);
                return;
            }
        }
        else{
            itemChange.setVisibility(View.INVISIBLE);
            return;
        }
    }
    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);
        currentPage = choice;
        boolean hasChoice1 = true;
        boolean hasChoice2 = true;
        boolean hasChoice3 = true;
        boolean hasChoice4 = true;
        choice1.setVisibility(View.INVISIBLE);
        choice3.setVisibility(View.INVISIBLE);
        choice4.setVisibility(View.INVISIBLE);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText = mCurrentPage.getText();
        mTextView.setText(pageText);
        player.changeHealth(mCurrentPage.getHealthLost() * -1);
        int health = player.getHealth();
        String healthS = Integer.toString(health);
        healthValue.setText(healthS);
        if(mCurrentPage.isFinal()) {
            choice1.setVisibility(View.INVISIBLE);
            choice3.setVisibility(View.INVISIBLE);
            choice4.setVisibility(View.INVISIBLE);
            choice2.setText("PLAY AGAIN");
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            if(mCurrentPage.isDead()){
                gameSound.stop();
                deathSound.start();
                deathSound.setLooping(true);
                int hunger = 0;
                int thirst = 0;
                health = 0;
                String hungerS = Integer.toString(hunger);
                String thirstS = Integer.toString(thirst);
                healthS = Integer.toString(health);
                hungerValue.setText(hungerS);
                thirstValue.setText(thirstS);
                healthValue.setText(healthS);
            }
        }
        else if(player.getHealth() <= 0){
            choice3.setVisibility(View.INVISIBLE);
            choice4.setVisibility(View.INVISIBLE);
            mTextView.setVisibility(View.INVISIBLE);
            mImageView.setImageResource(R.drawable.died);
            choice1.setText("YOU RAN OUT OF HEALTH!");
            choice2.setText("PLAY AGAIN");
            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openStartScreen();
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openStartScreen();
                }
            });
            deathSound.start();
            deathSound.setLooping(true);
        }
        else {
            try {
                choice1.setText(mCurrentPage.getChoice1().getText());
                choice1.setVisibility(View.VISIBLE);
            }
            catch(NullPointerException e)
            {
                hasChoice1 = false;
            }
            try {
                choice2.setText(mCurrentPage.getChoice2().getText());
                choice2.setVisibility(View.VISIBLE);
            }
            catch(NullPointerException e)
            {
                hasChoice2 = false;
                choice2.setVisibility(View.INVISIBLE);
            }
            try {
                choice3.setText(mCurrentPage.getChoice3().getText());
                choice3.setVisibility(View.VISIBLE);
            }
            catch(NullPointerException e)
            {
                hasChoice3 = false;
            }
            try {
                choice4.setText(mCurrentPage.getChoice4().getText());
                choice4.setVisibility(View.VISIBLE);
            }
            catch(NullPointerException e)
            {
                hasChoice4 = false;
            }
            if (hasChoice1 == true){
                choice1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice1().getNextPage();
                        decreaseStats();
                        changeItemAmount(mCurrentPage.getChoice1().getJuiceGained(),
                                mCurrentPage.getChoice1().getCandybarGained());
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice2 == true){
                choice2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice2().getNextPage();
                        decreaseStats();
                        changeItemAmount(mCurrentPage.getChoice2().getJuiceGained(),
                                mCurrentPage.getChoice2().getCandybarGained());
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice3 == true){
                choice3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice3().getNextPage();
                        decreaseStats();
                        changeItemAmount(mCurrentPage.getChoice3().getJuiceGained(),
                                mCurrentPage.getChoice3().getCandybarGained());
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice4 == true){
                choice4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice4().getNextPage();
                        decreaseStats();
                        changeItemAmount(mCurrentPage.getChoice4().getJuiceGained(),
                                mCurrentPage.getChoice4().getCandybarGained());
                        loadPage(nextPage);
                    }
                });
            }
        }
    }
    public void openStartScreen() {
        Intent intent = new Intent( this, StartScreen.class );
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        gameSound.stop();
        deathSound.stop();
    }
    @Override
    protected void onPause(){
        super.onPause();
        gameSound.pause();
    }
}
