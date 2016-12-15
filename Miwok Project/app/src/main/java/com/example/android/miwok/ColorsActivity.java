package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colorsArray = new ArrayList<Word>();
        colorsArray.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        colorsArray.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        colorsArray.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        colorsArray.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        colorsArray.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        colorsArray.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        colorsArray.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsArray.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this, colorsArray, R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer rootMediaPlayer = MediaPlayer.create(view.getContext(), colorsArray.get(position).getAudioResourceId());
                rootMediaPlayer.start();
            }
        });
    }
}
