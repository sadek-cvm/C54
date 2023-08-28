package com.ahmed.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAjouter, buttonAfficher, buttonQuitter;
    Ecouteur ec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAjouter = findViewById(R.id.button);
        buttonAfficher = findViewById(R.id.button2);
        buttonQuitter = findViewById(R.id.button3);

        ec = new Ecouteur();

        buttonAjouter.setOnClickListener(ec);
        buttonAfficher.setOnClickListener(ec);
        buttonQuitter.setOnClickListener(ec);
    }

    private class Ecouteur implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            Intent i;

            if((Button)view == buttonAjouter){
                i = new Intent(MainActivity.this, Ajouter.class);
                startActivity(i);
            }
            else if((Button)view == buttonAfficher){
                i = new Intent(MainActivity.this, Afficher.class);
                startActivity(i);

            }
            else if((Button)view == buttonQuitter){
                finish();
            }

        }
    }
}