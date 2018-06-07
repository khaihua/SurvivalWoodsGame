package com.example.khai.survivalwoods;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.khai.survivalwoods.R.id.NameInput;

public class StartScreen extends AppCompatActivity {
    private Button play;
    EditText inputtedName;
    MediaPlayer startSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        startSound = MediaPlayer.create(StartScreen.this, R.raw.startbackgroundmusic);
        startSound.start();
        startSound.setLooping(true);
        play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayScreen();
            }
        });
    }
    public void openPlayScreen() {
        inputtedName = (EditText) findViewById(NameInput);
        Intent intent = new Intent(this, PlayScreen.class);
        String name = inputtedName.getText().toString();
        intent.putExtra("Name", name);
        startActivity(intent);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        startSound.stop();
    }
    @Override
    protected void onPause(){
        super.onPause();
       startSound.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        startSound.start();
        startSound.setLooping(true);
    }

}
