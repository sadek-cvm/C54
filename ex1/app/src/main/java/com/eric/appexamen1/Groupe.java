package com.eric.appexamen1;

public class Groupe {
    String nomCours;
    int adresseImage;

    public Groupe(String nomCours, int adresseImage) {
        this.nomCours = nomCours;
        this.adresseImage = adresseImage;
    }

    public String getNomCours() {
        return nomCours;
    }

    public int getAdresseImage() {
        return adresseImage;
    }
}
