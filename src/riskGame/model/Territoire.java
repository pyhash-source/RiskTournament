package riskGame.model;
import java.util.ArrayList;

/*
 * La classe representant un territoire
 */
public class Territoire {
	
    private String nomTerritoire;
    private String proprietaire;
    private String couleur;
    private int coordonneeX;
    private int coordonneeY;
    private ArrayList<Territoire> territoiresAccessibles;
    
    private int nbrRegiment;
    
    public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Territoire(String nomTerritoire, String couleur, int coordonneeX, int coordonneeY) {
        this.nomTerritoire = nomTerritoire;
        this.couleur = couleur;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.proprietaire = null;
        this.nbrRegiment = 0;
    }

    public int getNbrRegiment() {
		return nbrRegiment;
	}

	public void setNbrRegiment(int nbrRegiment) {
		this.nbrRegiment = nbrRegiment;
	}

	public String getNomTerritoire() {
		return nomTerritoire;
	}

	public void setNomTerritoire(String nomTerritoire) {
		this.nomTerritoire = nomTerritoire;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}

	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}

	public ArrayList<Territoire> getTerritoiresAccessibles() {
		return territoiresAccessibles;
	}

	public void setTerritoiresAccessibles(ArrayList<Territoire> territoiresAccessibles) {
		this.territoiresAccessibles = territoiresAccessibles;
	}

	
}