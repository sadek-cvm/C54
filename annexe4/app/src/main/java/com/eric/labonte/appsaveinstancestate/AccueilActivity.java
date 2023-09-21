package com.eric.labonte.appsaveinstancestate;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

<<<<<<< HEAD
=======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad
public class AccueilActivity extends AppCompatActivity {

    Button boutonStartActivity;
    TextView texteSalutations ;
    ActivityResultLauncher<Intent> lanceur;
    Utilisateur util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonStartActivity = findViewById(R.id.boutonStartActivity);
        texteSalutations = findViewById(R.id.texteSalutations);

        Ecouteur ec = new Ecouteur();
        boutonStartActivity.setOnClickListener(ec);

        // creer le lanceur
        lanceur = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new RetourBoomerang());
        try {
            util = (Utilisateur) savedInstanceState.getSerializable("util");
            if (util != null) {
                texteSalutations.setText("Bonjour " + util.getPrenom() + " " + util.getNom() + "!");
            }
        } catch(NullPointerException npe) {
            npe.printStackTrace();
            texteSalutations.setText("Bonjour!");
        }

        // deserialization ici
<<<<<<< HEAD
    }

=======

        FileInputStream fis = null;
        try {
            fis = openFileInput("utilisateur.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            texteSalutations.setText("Bonjour " + (Utilisateur)ois.readObject(). + " " + util.getNom() + "!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stop");
    }
>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("util", util); // juste avant le onStop, on stock l'objet util dans le bundle et on le recupere dans le onCreate!
<<<<<<< HEAD
=======
        System.out.println("saveInstance");

>>>>>>> 30d95196b606480025afb0c9fd3e8bc8590e25ad
    }

    private class Ecouteur implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent i;
            if(view == boutonStartActivity){
//                i = new Intent(AccueilActivity.this, IdentificationActivity.class);   // on ne passe pas par intent, car ce n'est pas recommander pour rapporter de l'information vers notre actv. accueil
//                startActivity(i);
                lanceur.launch(new Intent(AccueilActivity.this, IdentificationActivity.class));
            }
        }
    }

    private class RetourBoomerang implements ActivityResultCallback<ActivityResult> {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                 util = (Utilisateur) result.getData().getSerializableExtra("util");
                 texteSalutations.setText("Bonjour " + util.getPrenom() + " " + util.getNom() + "!");
            }
        }
    }


}