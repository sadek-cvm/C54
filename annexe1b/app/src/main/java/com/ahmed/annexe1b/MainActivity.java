package com.ahmed.annexe1b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);



        text.setText(String.valueOf(compteurLigne()));
        text2.setText(String.valueOf(compteurCharacter()));

    }

    private int compteurLigne(){
        BufferedReader br = null;
        // 3 flux de donnes en lecture

        int nbLigne = 0;

        try{
            FileInputStream fis = openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null){
                nbLigne++;
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

        return nbLigne;
    }

    private int compteurMots(){
        int compteur = 0;
        Scanner sc = null;
        try {
            FileInputStream fis = openFileInput("test.txt");

            sc = new Scanner(fis);
            while (sc.hasNext()) {
                System.out.println(sc.next());
                compteur++;
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }

    }

    private int compteurCharacter(){
        BufferedReader br = null;
        // 3 flux de donnes en lecture

        int nbCharacter = 0;

        try{
            FileInputStream fis = openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = br.readLine();
            while(line != null){
                nbCharacter += line.length();
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

        return nbCharacter;
    }
}
