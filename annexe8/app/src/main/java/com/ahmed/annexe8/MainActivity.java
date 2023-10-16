package com.ahmed.annexe8;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.imageContainer);
        ObjectAnimator obj = ObjectAnimator.ofFloat(layout, View.TRANSLATION_Y, 0);


        layout.setOnClickListener(v -> {
            if(!click)
                obj.start();
            else
                obj.reverse();
            click = !click;
        });

    }
}