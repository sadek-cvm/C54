package com.ahmed.camera;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;


// add this "xmlns:tools="http://schemas.android.com/tools">" as a direct child in the manifest file
// change compileSDK from 33 to 34
public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView image;
    ActivityResultLauncher<Intent> lanceur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        image = findViewById(R.id.imageView);

        lanceur = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                        image.setImageBitmap(bitmap);
                    }
                }
        );

        btn.setOnClickListener(v -> {
            searchImage();
        });
    }

    public void searchImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        lanceur.launch(intent);
    }
}