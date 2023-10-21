package riskGame.model;

public class Territoire {
    private String nom;
    private String couleur;
    private int x;
    private int y;

    public Territoire(String nom, String couleur, int x, int y) {
        this.nom = nom;
        this.couleur = couleur;
        this.x = x;
        this.y = y;
    }

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
        return nom;
    }

    public String getCouleur() {
        return couleur;
    }
}