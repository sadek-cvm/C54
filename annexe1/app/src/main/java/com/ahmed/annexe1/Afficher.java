package com.ahmed.annexe1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Afficher extends AppCompatActivity {

    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher);

        liste = findViewById(R.id.listView1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recupererMemos());
        liste.setAdapter(adapter);
    }

    public ArrayList<String> recupererMemos(){

        ArrayList<String> temp = new ArrayList<String>();
        BufferedReader br = null;
        // 3 flux de donnes en lecture

        try{
            FileInputStream fis = openFileInput("memo.txt"); // stream du fichier
            InputStreamReader isr = new InputStreamReader(fis); // stream du fichier en charactere
            br = new BufferedReader(isr); // buffer du stream en charactere
            String line = br.readLine(); // lire la premierr line
            while(line != null){
                temp.add(line);
                line = br.readLine();
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return temp;
    }
}