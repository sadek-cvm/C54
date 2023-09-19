package com.eric.accompagnementatelier2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Singleton {

    private static Singleton instance;
    private ArrayList<Oeuvre> liste;

    public static Singleton getInstance ()
    {
        if ( instance == null)
            instance = new Singleton();
        return instance;
    }

    private Singleton()
    {
        liste = new ArrayList<>();
        liste.add(new Oeuvre ( "Le déjeuner des canotiers", "Auguste Renoir", 1880));
        liste.add ( new Oeuvre("Nighthawks", "Edward Hopper", 1942));
        liste.add( new Oeuvre ( "Un enterrement à Ornans", "Gustave Courbet", 1850 ));
        liste.add ( new Oeuvre ( "Les époux Andrews", "Thomas Gainsborough", 1750));
        liste.add( new Oeuvre( "American Gothic", "Grant Wood", 1930));
    }

    // 2. Utiliser une expression lambda afin de filtrer la liste pour obtenir une List de seulement les oeuvres créées
    // après 1900 (API Stream )
    public List<Oeuvre> filtre ()
    {
//        ArrayList<Oeuvre> sousListe = new ArrayList<>();

        List<Oeuvre> sousListe = liste
                .stream()
                .filter(elem -> elem.getAnnee() > 1900)
                .collect(Collectors.toList());

        return sousListe;
    }


    public ArrayList<Oeuvre> getListe() {
        return liste;
    }
}
