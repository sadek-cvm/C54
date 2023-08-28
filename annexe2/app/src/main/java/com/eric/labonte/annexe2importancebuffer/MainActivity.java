package com.eric.labonte.annexe2importancebuffer;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    Button bouton;
    TextView texteDuree, texteNom;
    ActivityResultLauncher<Intent> lanceur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.bouton);
        texteDuree = findViewById(R.id.texteDuree);
        texteNom = findViewById(R.id.texteNom);
        Ecouteur ec = new Ecouteur();
        bouton.setOnClickListener(ec);

        // création du lanceur de boomerang, objet sera appelé au retour du boomerang dans cette classe
        lanceur = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new CallBackMusic());
    }


    private class CallBackMusic implements ActivityResultCallback<ActivityResult> {


        // appelé quand je reviens du choix de fichiers sur le téléphone dans cette activité, retour du boomerang
        @Override
        public void onActivityResult(ActivityResult result) {


            if (result.getData() != null) {
                Uri uri = result.getData().getData(); // données retournées par l'Intent
                ContentResolver resolver = getContentResolver();// objet permettant d'accéder aux données sur le téléphones ( méthodes CRUD ), présente les données sous forme de tables

                //nom du fichier
                Cursor cursor = resolver.query(uri, new String[]{OpenableColumns.DISPLAY_NAME}, null, null, null);
                cursor.moveToFirst();
                texteNom.setText(cursor.getString(0));


                try {
                    // ouvrir un flux de données vers l'URI choisi
                    InputStream stream = resolver.openInputStream(uri); //c'est un stream d'octets

                    texteDuree.setText("durée : " + tempsDeLecture(stream));
                } catch (Exception fnf) {
                    fnf.printStackTrace();
                }
            }

        }
    }


    private class Ecouteur implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            rechercherFichiers();
        }
    }


    public void rechercherFichiers() {
        // intent vers le téléphone
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("audio/*");  // ou text/* // fichiers musciaux
        lanceur.launch(intent);  // lance l'intent différemment qu'avec startActivity car on attend un résultat dans cette activité, affiche les fichiers musicaux
    }


    public String tempsDeLecture(InputStream chemin){
        //à faire
        // InputStream est la super classe abstraite des flux binaires en lecture
        // Le boomerang est le fait de demarer le system de fichier d'android pour choisir le fichier et ramener le fichier dans notre fichier
        // On a utiliser FileInputStream et BufferedInputStream parce qu'on travaille avec un fichier non texte.

        FileInputStream fis;
        BufferedInputStream bis = null;
        long temps =0;

        try {
            fis = (FileInputStream) chemin;
            bis = new BufferedInputStream(fis);
            long debut = System.currentTimeMillis();

            while (bis.read() != -1);
            long fin = System.currentTimeMillis();
            temps = fin - debut;
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return String.valueOf(temps);

    }

}