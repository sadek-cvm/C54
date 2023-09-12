package com.example.annexe3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2, seekBar3;
    private int sbValue1, sbValue2, sbValue3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);


        // Initialiser les seekbar dans le OnCreate quand le fichier "fichier.ser" n'est pas vide
        try {
            ObjectInputStream ois = null; // Aller chercher des objets
            FileInputStream fis = openFileInput("fichier.ser"); // Lire le fichier "fichier.txt"
            ois = new ObjectInputStream(fis); // Mettre la liste des objets lus dans fis dans ois qui recupère des objets

            seekBar1.setProgress((int) ois.readObject()); // Aller chercher les objets et les transtyper en (int)
            seekBar2.setProgress((int) ois.readObject());
            seekBar3.setProgress((int) ois.readObject());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dès qu'on ferme l'app on enregistre tout dans le fichier
    @Override
    protected void onStop() {
        super.onStop();

        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = openFileOutput("fichier.ser", Context.MODE_PRIVATE); // Ecrire dans le fichier "fichier.ser"
            oos = new ObjectOutputStream(fos); // Récupère les obejts à écrire

            sbValue1 = seekBar1.getProgress(); // SeekBar non Sérialisable donc transtyper en (int)
            sbValue2 = seekBar2.getProgress();
            sbValue3 = seekBar3.getProgress();

            oos.writeObject(sbValue1); // Ajouter au bouffeur d'objet
            oos.writeObject(sbValue2);
            oos.writeObject(sbValue3);

            //fos.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                oos.close(); // Toujours fermer tout
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}