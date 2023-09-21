package com.eric.labonte.appsaveinstancestate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
<<<<<<< HEAD
=======
import java.io.ObjectOutputStream;
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad

public class IdentificationActivity extends AppCompatActivity {

    Button boutonConfirmer;
    EditText champPrenom, champNom;
<<<<<<< HEAD
=======
    Utilisateur utilisateur;
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);
        boutonConfirmer = findViewById(R.id.boutonConfirmer);
        champPrenom = findViewById(R.id.champPrenom);
        champNom = findViewById(R.id.champNom);

        Ecouteur ec = new Ecouteur();
        boutonConfirmer.setOnClickListener(ec);
    }

    @Override
    protected void onStop() {   // serialization
        super.onStop();
        try {
            FileOutputStream fis = openFileOutput("utilisateur.ser", Context.MODE_PRIVATE);
<<<<<<< HEAD
=======
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(utilisateur);
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Ecouteur implements View.OnClickListener {

        @Override
        public void onClick(View view) {
//            if(view == boutonConfirmer){
//                try {
                    Intent retour = new Intent();
<<<<<<< HEAD
                    Utilisateur utilisateur = new Utilisateur(champPrenom.getText().toString(), champNom.getText().toString());
=======
                    utilisateur = new Utilisateur(champPrenom.getText().toString(), champNom.getText().toString());
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad
                    retour.putExtra("util", utilisateur);
                    setResult(RESULT_OK, retour);   // renvoie le boomerang a l'activite de depart, dans la methode onActivityResult
                    finish();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}