package com.ahmed.annexe6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ChoisirPlaylistActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_playlist);

        playlists = new ArrayList<String>();
        playlists.add("Essentiels Égyptiens");
        playlists.add("Pop Égyptien");
        playlists.add("Mahraganat");
        playlists.add("Rap Égyptien");
        playlists.add("Romance Égyptienne");
        playlists.add("Classiques Égyptiens");

        list = findViewById(R.id.List);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom_list_item, playlists);

        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent i = new Intent();
            i.putExtra("chosenPlaylist", position);
            setResult(Activity.RESULT_OK, i);
            finish();
        });
    }
}