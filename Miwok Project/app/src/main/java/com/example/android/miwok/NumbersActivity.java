package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
        MediaPlayer rootMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> numbersArray = new ArrayList<Word>();

        numbersArray.add(new Word("lutti", "one", R.drawable.number_one, R.raw.number_one));
        numbersArray.add(new Word("otiiko", "two", R.drawable.number_two, R.raw.number_two));
        numbersArray.add(new Word("tolookosu", "three", R.drawable.number_three, R.raw.number_three));
        numbersArray.add(new Word("oyyisa", "four", R.drawable.number_four, R.raw.number_four));
        numbersArray.add(new Word("massokka", "five", R.drawable.number_five, R.raw.number_five));
        numbersArray.add(new Word("temmokka", "six", R.drawable.number_six, R.raw.number_six));
        numbersArray.add(new Word("kenekaku", "seven", R.drawable.number_seven, R.raw.number_seven));
        numbersArray.add(new Word("kawinta", "eight", R.drawable.number_eight, R.raw.number_eight));
        numbersArray.add(new Word("wo’e", "nine", R.drawable.number_nine, R.raw.number_nine));
        numbersArray.add(new Word("na’aacha", "ten", R.drawable.number_ten, R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this, numbersArray, R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                rootMediaPlayer = MediaPlayer.create(view.getContext(), numbersArray.get(position).getAudioResourceId());
                rootMediaPlayer.start();
                rootMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
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

