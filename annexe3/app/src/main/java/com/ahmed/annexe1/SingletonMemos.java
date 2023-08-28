package com.ahmed.annexe1;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SingletonMemos {

    private static SingletonMemos instance;
    private Context context;
    private ArrayList<String> listMemos;

    public static SingletonMemos getInstance(Context context){
        if (instance == null)
            instance = new SingletonMemos(context);
        return instance;
    }

    private SingletonMemos(Context context){

        this.context = context;
        listMemos = new ArrayList<String>();
    }

    public void ajouterMemo(String memo){
        listMemos.add(memo);
    }

    public ArrayList<String> getListMemos() {
        return listMemos;
    }
    // Serialisation: conserver l'etat d'un objet en donnees binaire que peuvent etre recuperees par la suite
    // Pour nos propre classes : class Maison implements Serialisable (s'assurer que tous les variables de la class le soie aussi)

    public void serialiserListe(){
        ObjectOutputStream oss = null;
        try{
            FileOutputStream fos = context.openFileOutput("fichier.ser", Context.MODE_PRIVATE);
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listMemos);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if (oss!= null)
                    oss.close();

            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
