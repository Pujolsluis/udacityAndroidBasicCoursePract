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
        colorsArray.add(new Word("weṭeṭṭi", "red"));
        colorsArray.add(new Word("chokokki", "green"));
        colorsArray.add(new Word("ṭakaakki", "brown"));
        colorsArray.add(new Word("ṭopoppi", "gray"));
        colorsArray.add(new Word("kululli", "black"));
        colorsArray.add(new Word("kelelli", "white"));
        colorsArray.add(new Word("ṭopiisә", "dusty yellow"));
        colorsArray.add(new Word("chiwiiṭә", "mustard yellow"));


        WordAdapter itemsAdapter = new WordAdapter(this, colorsArray);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
