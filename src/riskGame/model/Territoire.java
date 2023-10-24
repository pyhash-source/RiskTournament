package riskGame.model;
import java.util.ArrayList;

/**
 * @author elisa as SVRS
 */
public class Territoire {
	
    private String nomTerritoire;
    private Joueur proprietaire;
    private String couleur;
    private int coordonneeX;
    private int coordonneeY;
    private ArrayList<Territoire> territoiresAccessibles;
    private int nbrRegiment;
    
    public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Territoire(String nomTerritoire, String couleur, int coordonneeX, int coordonneeY) {
        this.nomTerritoire = nomTerritoire;
        this.couleur = couleur;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.proprietaire = null;
        this.nbrRegiment = 0;
        this.territoiresAccessibles = new ArrayList<>();
    }

    public int getNbrRegiment() {
		return nbrRegiment;
	}

	public void setNbrRegiment(int nbrRegiment) {
		this.nbrRegiment = nbrRegiment;
	}
	
	public void ajouterRegiments(int nbrRegimentAAjouter) {
		this.nbrRegiment += nbrRegimentAAjouter;
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