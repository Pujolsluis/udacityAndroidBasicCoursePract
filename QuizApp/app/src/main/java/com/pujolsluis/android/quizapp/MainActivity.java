package com.pujolsluis.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View v){

        RadioButton correctAnswer1 = (RadioButton) findViewById(R.id.radioButton_group1_op3);
        RadioButton correctAnswer2 = (RadioButton) findViewById(R.id.radioButton_group2_op2);

        RadioButton preg1Op1 = (RadioButton) findViewById(R.id.radioButton_group1_op1);
        RadioButton preg1Op2 = (RadioButton) findViewById(R.id.radioButton_group1_op2);
        RadioButton preg1Op3 = (RadioButton) findViewById(R.id.radioButton_group1_op3);
        RadioButton preg2Op1 = (RadioButton) findViewById(R.id.radioButton_group2_op1);
        RadioButton preg2Op2 = (RadioButton) findViewById(R.id.radioButton_group2_op2);
        RadioButton preg2Op3 = (RadioButton) findViewById(R.id.radioButton_group2_op3);

        if(correctAnswer1.isChecked()) correctAnswers++;
        if(correctAnswer2.isChecked()) correctAnswers++;

        Toast.makeText(this, "You had " + correctAnswers.toString() + " Correct answers", Toast.LENGTH_SHORT).show();
        correctAnswers = 0;

        preg1Op1.setChecked(false);
        preg1Op2.setChecked(false);
        preg1Op3.setChecked(false);
        preg2Op1.setChecked(false);
        preg2Op2.setChecked(false);
        preg2Op3.setChecked(false);

    }
}
