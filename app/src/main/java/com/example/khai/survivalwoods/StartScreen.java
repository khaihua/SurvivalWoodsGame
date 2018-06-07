package com.example.khai.survivalwoods;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.khai.survivalwoods.R.id.NameInput;

public class StartScreen extends AppCompatActivity {
    private Button play;
    EditText inputtedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

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

}
