package com.eric.appannexe7;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnLivre, btnAppel, btnVille, btnPhoto, btnMessage;
    ImageView image;
    ActivityResultLauncher<Intent> lanceur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLivre = findViewById(R.id.boutonLivre);
        btnAppel = findViewById(R.id.boutonAppel);
        btnVille = findViewById(R.id.boutonVille);
        btnPhoto = findViewById(R.id.boutonPhoto);

        image = findViewById(R.id.imageView);

        btnLivre.setOnClickListener(source -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.leslibrairies.fr"));
            startActivity(i);
        });

        btnAppel.setOnClickListener(source -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+123456789"));
            startActivity(i);
        });

        btnVille.setOnClickListener(source -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:?q=Hawkesbury, ON"));
            startActivity(i);
        });

        btnPhoto.setOnClickListener(source -> {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            lanceur.launch(i);
        });

        lanceur = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Bundle bundle = result.getData().getExtras();
            Bitmap photo = ( Bitmap) bundle.get("data");
            image.setImageBitmap(photo);
        });

    }
}