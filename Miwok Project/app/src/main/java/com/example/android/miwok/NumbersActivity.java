package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> numbersArray = new ArrayList<Word>();
        numbersArray.add(new Word("lutti", "one"));
        numbersArray.add(new Word("lutti", "two"));
        numbersArray.add(new Word("lutti", "three"));
        numbersArray.add(new Word("lutti", "four"));
        numbersArray.add(new Word("lutti", "five"));
        numbersArray.add(new Word("lutti", "six"));
        numbersArray.add(new Word("lutti", "seven"));
        numbersArray.add(new Word("lutti", "eight"));
        numbersArray.add(new Word("lutti", "nine"));
        numbersArray.add(new Word("lutti", "ten"));



        String numbersTAG = "NumbersActivity";
        for(int i=0; i < numbersArray.size(); i++) Log.v(numbersTAG, "Word at position " + i + " is " + numbersArray.get(i));

        WordAdapter itemsAdapter = new WordAdapter(this, numbersArray);

        ListView listView = (ListView) findViewById(R.id.numbers_list);

        listView.setAdapter(itemsAdapter);

    }
}
