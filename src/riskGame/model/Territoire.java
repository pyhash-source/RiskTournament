package riskGame.model;

public class Territoire {
    private String nom;
    private String couleur;

    public Territoire(String nom, String couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    public String getNom() {
        return nom;
    }

    public String getCouleur() {
        return couleur;
    }
}