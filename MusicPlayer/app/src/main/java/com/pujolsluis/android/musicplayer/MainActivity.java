package com.pujolsluis.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer currSong = new MediaPlayer().create(this, R.raw.give_me_love);
        final Button playButton = (Button) findViewById(R.id.button_Play);
        final Button pauseButton = (Button) findViewById(R.id.button_Pause);

        // Setting the onClickListener for the play button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currSong.start();
                Log.d("MainActivity", "Play Song");
            }
        });

        // Setting onClickListener for the pause button
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currSong.isPlaying()) currSong.pause();
                Log.d("MainActivity", "Pause Song");
            }
        });
    }

}
