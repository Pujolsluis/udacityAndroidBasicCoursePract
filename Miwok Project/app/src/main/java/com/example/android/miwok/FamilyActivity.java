package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> familyArray = new ArrayList<Word>();
        familyArray.add(new Word("әpә", "father"));
        familyArray.add(new Word("әṭa", "mother"));
        familyArray.add(new Word("angsi", "son"));
        familyArray.add(new Word("tune", "daughter"));
        familyArray.add(new Word("taachi", "older brother"));
        familyArray.add(new Word("chalitti", "younger brother"));
        familyArray.add(new Word("teṭe", "older sister"));
        familyArray.add(new Word("kolliti", "younger sister"));
        familyArray.add(new Word("ama", "grandmother"));
        familyArray.add(new Word("paapa", "grandfather"));


        WordAdapter itemsAdapter = new WordAdapter(this, familyArray);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
