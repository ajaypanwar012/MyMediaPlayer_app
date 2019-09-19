package com.example.mymediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.closer);
        mediaPlayer.setLooping(true);
        Toast.makeText(this,"Service created !",Toast.LENGTH_LONG).show();
    }

    ///============================Media Player actions ================================================


    public void playSong(View view){
        mediaPlayer.start();
        Toast.makeText(this,"Playing song... :-)",Toast.LENGTH_LONG).show();
    }
    public void pauseSong(View view){
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            Toast.makeText(this," song paused... :-(",Toast.LENGTH_LONG).show();
        }
    }
    public void stopSong(View view){
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
            Toast.makeText(this," song stopped... :-(",Toast.LENGTH_LONG).show();

        }
    }

    // =============================services actions ====================================================


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Service started !",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
        Toast.makeText(this, "Service paused !", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        Toast.makeText(this,"Service destroyed !",Toast.LENGTH_LONG).show();
    }
}
