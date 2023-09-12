package com.ahmed.annexe3c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("create");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("destroy");
    }
}