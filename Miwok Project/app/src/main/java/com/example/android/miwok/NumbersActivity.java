package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbersArray = new ArrayList<Word>();

        numbersArray.add(new Word("lutti", "one", R.drawable.number_one));
        numbersArray.add(new Word("otiiko", "two", R.drawable.number_two));
        numbersArray.add(new Word("tolookosu", "three", R.drawable.number_three));
        numbersArray.add(new Word("oyyisa", "four", R.drawable.number_four));
        numbersArray.add(new Word("massokka", "five", R.drawable.number_five));
        numbersArray.add(new Word("temmokka", "six", R.drawable.number_six));
        numbersArray.add(new Word("kenekaku", "seven", R.drawable.number_seven));
        numbersArray.add(new Word("kawinta", "eight", R.drawable.number_eight));
        numbersArray.add(new Word("wo’e", "nine", R.drawable.number_nine));
        numbersArray.add(new Word("na’aacha", "ten", R.drawable.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this, numbersArray);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
