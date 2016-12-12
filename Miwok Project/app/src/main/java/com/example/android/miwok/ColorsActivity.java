package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colorsArray = new ArrayList<Word>();
        colorsArray.add(new Word("weṭeṭṭi", "red", R.drawable.color_red));
        colorsArray.add(new Word("chokokki", "green", R.drawable.color_green));
        colorsArray.add(new Word("ṭakaakki", "brown", R.drawable.color_brown));
        colorsArray.add(new Word("ṭopoppi", "gray", R.drawable.color_gray));
        colorsArray.add(new Word("kululli", "black", R.drawable.color_black));
        colorsArray.add(new Word("kelelli", "white", R.drawable.color_white));
        colorsArray.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow));
        colorsArray.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this, colorsArray);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
