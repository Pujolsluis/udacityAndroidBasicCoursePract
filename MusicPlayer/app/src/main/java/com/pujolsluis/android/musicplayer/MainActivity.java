package com.pujolsluis.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer currSong = new MediaPlayer().create(this, R.raw.give_me_love);
        final Button playButton = (Button) findViewById(R.id.button_Play);
        final Button pauseButton = (Button) findViewById(R.id.button_Pause);
        final Button resetButton = (Button) findViewById(R.id.button_reset);
        final Button estatusButton = (Button) findViewById(R.id.button_estatus);

        // Setting the onClickListener for the play button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currSong.start();
                currSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(playButton.getContext(), "Im done!", Toast.LENGTH_SHORT).show();
                    }
                });
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

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currSong.seekTo(0);
            }
        });

        estatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPositionM,currentPositionS;
                currentPositionM = currentPositionS = currSong.getCurrentPosition();
                int durationTotalM, durationTotalS, durationTotalTemp;
                durationTotalM = durationTotalS = currSong.getDuration();

                currentPositionM /= 1000;
                currentPositionM /= 60;
                currentPositionS /= 1000;
                currentPositionS %= 60;

                durationTotalM /= 1000;
                durationTotalM /= 60;
                durationTotalS /= 1000;
                durationTotalS %= 60;

                String displayStatus = "Current Position: " + currentPositionM + " min, " + currentPositionS
                                        + " sec\nTotal Duration: " + durationTotalM + " min, " + durationTotalS + "sec";
                Toast.makeText(view.getContext(), displayStatus, Toast.LENGTH_SHORT).show();

                Log.v("MainActivity", String.format("Current Position: %d min, %d sec\nTotal Duration: %d min, %d sec ",
                                                     currentPositionM, currentPositionS, durationTotalM, durationTotalS));

            }
        });
    }

}
