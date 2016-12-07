package com.pujolsluis.android.basketballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer teamAScore = 0;
    Integer teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addOnePoint(View v){
        Button teamAFreePointButton = (Button) findViewById(R.id.button_teamA_freePoint);
        TextView teamAScoreTextView = (TextView) findViewById(R.id.textView_score_teamA);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.textView_score_teamB);

        Button buttonViewTeam = (Button) v;

        if(buttonViewTeam.equals(teamAFreePointButton)){
            teamAScore++;
            teamAScoreTextView.setText(teamAScore.toString());
        }else{
            teamBScore++;
            teamBScoreTextView.setText(teamBScore.toString());
        }
        return;
    }

    public void addTwoPoint(View v){
        Button teamATwoPointButton = (Button) findViewById(R.id.button_teamA_twoPoints);
        TextView teamAScoreTextView = (TextView) findViewById(R.id.textView_score_teamA);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.textView_score_teamB);

        Button buttonViewTeam = (Button) v;

        if(buttonViewTeam.equals(teamATwoPointButton)){
            teamAScore += 2;
            teamAScoreTextView.setText(teamAScore.toString());
        }else{
            teamBScore += 2;
            teamBScoreTextView.setText(teamBScore.toString());
        }
    }

    public void addThreePoint(View v){
        Button teamAThreePointButton = (Button) findViewById(R.id.button_teamA_threePoints);
        TextView teamAScoreTextView = (TextView) findViewById(R.id.textView_score_teamA);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.textView_score_teamB);

        Button buttonViewTeam = (Button) v;

        if(buttonViewTeam.equals(teamAThreePointButton)){
            teamAScore += 3;
            teamAScoreTextView.setText(teamAScore.toString());
        }else{
            teamBScore += 3;
            teamBScoreTextView.setText(teamBScore.toString());
        }
    }

    public void resetScore(View v){
        teamAScore = teamBScore = 0;
        TextView teamAScoreTextView = (TextView) findViewById(R.id.textView_score_teamA);
        TextView teamBScoreTextView = (TextView) findViewById(R.id.textView_score_teamB);
        teamAScoreTextView.setText("0");
        teamBScoreTextView.setText("0");
        Toast.makeText(this, "The score has been reset", Toast.LENGTH_SHORT).show();

    }
}
