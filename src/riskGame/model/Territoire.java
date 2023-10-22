package riskGame.model;

public class Territoire {
    private String nom;
    private String couleur;
    private int x;
    private int y;
    private String proprietaire;
    private int nbrRegiment;
    
    public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Territoire(String nom, String couleur, int x, int y) {
        this.nom = nom;
        this.couleur = couleur;
        this.x = x;
        this.y = y;
        this.proprietaire = "sans";
        this.nbrRegiment = 0;
    }

    public int getNbrRegiment() {
		return nbrRegiment;
	}

	public void setNbrRegiment(int nbrRegiment) {
		this.nbrRegiment = nbrRegiment;
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