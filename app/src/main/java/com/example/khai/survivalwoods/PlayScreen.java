package com.example.khai.survivalwoods;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PlayScreen extends AppCompatActivity {
    TextView displayName;
    TextView healthValue;
    TextView hungerValue;
    TextView thirstValue;
    private Button item;
    Player player = new Player();
    private Story mStory = new Story();
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private Page mCurrentPage;
    private ImageView mImageView;
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String name = getIntent().getStringExtra("Name");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        displayName = (TextView) findViewById(R.id.Name);
        displayName.setText(name);
        player.setName(name);
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
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById((R.id.storyTextView));
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);
        choice4 = (Button) findViewById(R.id.choice4);
        item = (Button) findViewById(R.id.itemButton);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInventoryScreen();
            }
        });

        loadPage(0);
    }
    public void openInventoryScreen() {
        Intent intent = new Intent(this, InventoryScreen.class);
        startActivity(intent);
    }
    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);
        boolean hasChoice1 = true;
        boolean hasChoice2 = true;
        boolean hasChoice3 = true;
        boolean hasChoice4 = true;
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText = mCurrentPage.getText();
        mTextView.setText(pageText);
        if(mCurrentPage.isFinal()) {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("PLAY AGAIN");
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            try {
                choice1.setText(mCurrentPage.getChoice1().getText());
            }
            catch(NullPointerException e)
            {
                hasChoice1 = false;
            }
            try {
                choice2.setText(mCurrentPage.getChoice2().getText());
            }
            catch(NullPointerException e)
            {
                hasChoice2 = false;
            }
            try {
                choice3.setText(mCurrentPage.getChoice3().getText());
            }
            catch(NullPointerException e)
            {
                hasChoice3 = false;
            }
            try {
                choice4.setText(mCurrentPage.getChoice4().getText());
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
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice2 == true){
                choice2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice2().getNextPage();
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice3 == true){
                choice3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice3().getNextPage();
                        loadPage(nextPage);
                    }
                });
            }
            if (hasChoice4 == true){
                choice4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int nextPage = mCurrentPage.getChoice4().getNextPage();
                        loadPage(nextPage);
                    }
                });
            }
        }
    }
}
