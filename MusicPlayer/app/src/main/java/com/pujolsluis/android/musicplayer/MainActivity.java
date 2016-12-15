package com.pujolsluis.android.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AudioManager audioManager;
    MediaPlayer currSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        currSong = new MediaPlayer().create(this, R.raw.give_me_love);
        final Button playButton = (Button) findViewById(R.id.button_Play);
        final Button pauseButton = (Button) findViewById(R.id.button_Pause);
        final Button resetButton = (Button) findViewById(R.id.button_reset);
        final Button estatusButton = (Button) findViewById(R.id.button_estatus);


        // Setting the onClickListener for the play button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currSong = null;
                int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    currSong = MediaPlayer.create(view.getContext(), R.raw.give_me_love);
                    currSong.start();
                    currSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            Toast.makeText(playButton.getContext(), "Im done!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Log.d("MainActivity", "Play Song");
                }
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

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                float lowVolume = (float) 0.4;
                currSong.setVolume(lowVolume, lowVolume);

            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                float upVolume = (float) 1.0;
                currSong.setVolume(upVolume, upVolume);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    public void releaseMediaPlayer(){
        if(currSong != null){
            currSong.release();
            currSong = null;
        }
    }

}
