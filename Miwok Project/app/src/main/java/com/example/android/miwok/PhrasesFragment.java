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
public class PhrasesFragment extends Fragment {

    MediaPlayer rootMediaPlayer;
    AudioManager audioManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> phrasesArray = new ArrayList<Word>();
        phrasesArray.add(new Word("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going));
        phrasesArray.add(new Word("tinnә oyaase'nә", "What is your name?", R.raw.phrase_what_is_your_name));
        phrasesArray.add(new Word("oyaaset...", "My name is...", R.raw.phrase_my_name_is));
        phrasesArray.add(new Word("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        phrasesArray.add(new Word("kuchi achit", "I’m feeling good.", R.raw.phrase_im_feeling_good));
        phrasesArray.add(new Word("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming));
        phrasesArray.add(new Word("hәә’ әәnәm", "Yes, I’m coming.", R.raw.phrase_yes_im_coming));
        phrasesArray.add(new Word("әәnәm", "I’m coming.", R.raw.phrase_im_coming));
        phrasesArray.add(new Word("yoowutis", "Let’s go.", R.raw.phrase_lets_go));
        phrasesArray.add(new Word("әnni'nem", "Come here.", R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(getActivity(), phrasesArray, R.color.category_phrases);


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
                    rootMediaPlayer = MediaPlayer.create(getActivity(), phrasesArray.get(position).getAudioResourceId());
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
