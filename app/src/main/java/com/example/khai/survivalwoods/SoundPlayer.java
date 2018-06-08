package com.example.khai.survivalwoods;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPlayer {
    private AudioAttributes audioAttributes;
    final int SOUND_POOL_MAX = 2;

    private static SoundPool soundPool;
    private static int drinkSound;
    private static int eatSound;
    private static int restSound;

    public SoundPlayer(Context context){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOUND_POOL_MAX)
                    .build();
        }else {

            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        }
        drinkSound = soundPool.load(context, R.raw.drink,1);
        eatSound = soundPool.load(context, R.raw.eat,1);
        restSound = soundPool.load(context, R.raw.sleep,1);
    }

    public void playDrinkSound(){
        soundPool.play(drinkSound, 1.0f,1.0f,1,0,1.0f);
    }
    public void playEatSound(){
        soundPool.play(eatSound,1.0f,1.0f,1,0,1.0f);
    }
    public void playRestSound(){
        soundPool.play(restSound,1.0f,1.0f,1,0,1.0f);
    }

}
