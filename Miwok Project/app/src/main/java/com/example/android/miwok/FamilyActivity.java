package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

        MediaPlayer rootMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> familyArray = new ArrayList<Word>();
        familyArray.add(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father));
        familyArray.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        familyArray.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        familyArray.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        familyArray.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyArray.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyArray.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyArray.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyArray.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyArray.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, familyArray, R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                rootMediaPlayer = null;
                rootMediaPlayer = MediaPlayer.create(view.getContext(), familyArray.get(position).getAudioResourceId());
                rootMediaPlayer.start();
                rootMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        rootMediaPlayer.release();
                        rootMediaPlayer = null;
                    }
                });
            }
        });
    }

    public void releaseMediaPlayer(){
        if(rootMediaPlayer != null){
            rootMediaPlayer.release();
            rootMediaPlayer = null;
        }
    }

}
