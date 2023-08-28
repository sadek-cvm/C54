package com.ahmed.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Ajouter extends AppCompatActivity {

    Button buttonAjouter;
    EditText champ;
    Ecouteur ec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);


        buttonAjouter = findViewById(R.id.button4);
        champ = findViewById(R.id.editTextTextPersonName);


        ec = new Ecouteur();

        buttonAjouter.setOnClickListener(ec);
    }

    @Override
    protected void onStop(){
        super.onStop();
        SingletonMemos.getInstance(this).serialiserListe();
    }

    private class Ecouteur implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            SingletonMemos.getInstance(Ajouter.this).ajouterMemo(champ.getText().toString());
            finish();

        }
    }
}