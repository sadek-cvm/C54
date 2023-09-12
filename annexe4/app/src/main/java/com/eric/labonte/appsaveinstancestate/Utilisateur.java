package com.eric.labonte.appsaveinstancestate;

import java.io.Serializable;

public class Utilisateur implements Serializable {

    private String prenom, nom;

    public Utilisateur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
