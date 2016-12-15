package com.pujolsluis.android.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", "On Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", "On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", "On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", "On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "On Destroy");
    }
}
