package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

        MediaPlayer rootMediaPlayer;
        AudioManager audioManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.word_list, container, false);

            audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

            final ArrayList<Word> colorsArray = new ArrayList<Word>();
            colorsArray.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
            colorsArray.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
            colorsArray.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
            colorsArray.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
            colorsArray.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
            colorsArray.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
            colorsArray.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
            colorsArray.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

            WordAdapter itemsAdapter = new WordAdapter(getActivity(), colorsArray, R.color.category_colors);

            ListView listView = (ListView) rootView.findViewById(R.id.list);

            listView.setAdapter(itemsAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    releaseMediaPlayer();

                    int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            AudioManager.STREAM_MUSIC,
                            AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                        rootMediaPlayer = MediaPlayer.create(getActivity(), colorsArray.get(position).getAudioResourceId());
                        rootMediaPlayer.start();
                        rootMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                releaseMediaPlayer();
                            }
                        });
                    }
                }
            });

        return rootView;
    }

    public void releaseMediaPlayer(){
        if(rootMediaPlayer != null){
            rootMediaPlayer.release();
            rootMediaPlayer = null;
            audioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
                rootMediaPlayer.pause();
                rootMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                rootMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };
}
