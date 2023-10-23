package com.eric.appexamen1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner spinner;
    int positionCourrante;

    Groupe[] liste = {new Groupe ("c23", R.drawable.c23),new Groupe("c34", R.drawable.c34),new Groupe("c44", R.drawable.c44)  };

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        spinner = findViewById(R.id.spinner);

        // on cherche la position
        try {
            ObjectInputStream ois = null;
            FileInputStream fis = openFileInput("fichier.ser");
            ois = new ObjectInputStream(fis);

            positionCourrante = (int)ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Vector<String> vec = new Vector<>();
        for ( Groupe g : liste)
        {
            vec.add(g.getNomCours());
        }


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,vec );
        spinner.setAdapter(adapter);

        Ecouteur ec = new Ecouteur();
        spinner.setOnItemSelectedListener(ec);

        // on set la position (par defaut elle est à zero)
        spinner.setSelection(positionCourrante);

    }
    private class Ecouteur implements AdapterView.OnItemSelectedListener
    {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            index = position;

            imageView.setImageResource(liste[position].getAdresseImage());

            // on enregistre la position
            ObjectOutputStream oos = null;
            try {

                FileOutputStream fos = openFileOutput("fichier.ser", Context.MODE_PRIVATE);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(position);

            } catch (Exception e) {
                e.printStackTrace();

            } finally {

                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}