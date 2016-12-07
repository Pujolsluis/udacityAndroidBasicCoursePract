package com.pujolsluis.android.basketballcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView teamAScoreTextView = (TextView) findViewById(R.id.textView_score_teamA);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.textView_score_teamB);
        teamAScoreTextView.setText("5");
    }

    //void addOnePoint
}
