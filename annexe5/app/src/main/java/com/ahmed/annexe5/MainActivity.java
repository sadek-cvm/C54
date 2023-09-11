package com.ahmed.annexe5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

//    TextView rating, song_title, release_date;
//    ImageView cover;
    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = findViewById(R.id.liste);

        SimpleAdapter adapter = new SimpleAdapter(this,
                remplirVecteurAvecDeserialisation(getResources().openRawResource(R.raw.palmares)),
                R.layout.un_item,
                new String[]{"position", "nom", "date", "image"},
                new int[]{R.id.ranking, R.id.song_title, R.id.release_date, R.id.cover}
                );

        liste.setAdapter(adapter);

    }

    public Vector<HashMap<String, Object>> remplirVecteurAvecDeserialisation(InputStream i){
        Vector<HashMap<String, Object>> v = new Vector();
        try(ObjectInputStream ois = new ObjectInputStream(i)){
            HashMap< String, Object> h;
            while((h = (HashMap<String, Object>) ois.readObject()) != null){
                v.add(h);
            }
        }catch(Exception e){
            e.printStackTrace();;
        }
        return v;
    }
}