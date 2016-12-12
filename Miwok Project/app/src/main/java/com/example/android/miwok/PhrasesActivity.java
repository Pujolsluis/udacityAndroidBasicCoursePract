package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> phrasesArray = new ArrayList<Word>();
        phrasesArray.add(new Word("minto wuksus", "Where are you going?"));
        phrasesArray.add(new Word("tinnә oyaase'nә", "What is your name?"));
        phrasesArray.add(new Word("oyaaset...", "My name is..."));
        phrasesArray.add(new Word("michәksәs?", "How are you feeling?"));
        phrasesArray.add(new Word("kuchi achit", "I’m feeling good."));
        phrasesArray.add(new Word("әәnәs'aa?", "Are you coming?"));
        phrasesArray.add(new Word("hәә’ әәnәm", "Yes, I’m coming."));
        phrasesArray.add(new Word("әәnәm", "I’m coming."));
        phrasesArray.add(new Word("yoowutis", "Let’s go."));
        phrasesArray.add(new Word("әnni'nem", "Come here."));


        WordAdapter itemsAdapter = new WordAdapter(this, phrasesArray, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
