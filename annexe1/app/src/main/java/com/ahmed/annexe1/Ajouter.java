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

    private class Ecouteur implements View.OnClickListener{

        @Override
        public void onClick(View view) {

            FileOutputStream fos = null; // flux d'octets
            BufferedWriter bw = null;

            try {
                fos = openFileOutput("memo.txt", Context.MODE_APPEND); // append, ecrit a la fin de fichier
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                bw = new BufferedWriter(osw);
                bw.write(champ.getText().toString());
                bw.newLine();
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                fermerFlux(bw);
                finish();
            }


        }

        public void fermerFlux(Writer bw){
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}