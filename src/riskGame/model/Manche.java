package riskGame.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jean, elisa(ou svrs),
 **/

public class Manche {
	private int numeroManche;
	private Date debutPartie;
	private Date finPartie;

	private EtatManche etatManche;
	private ArrayList<Joueur> classement;
	private ArrayList<Joueur> joueursManche;
	
	public Manche(int numeroManche, Date debutPartie, EtatManche etatManche) {
		super();
		this.numeroManche = numeroManche;
		this.debutPartie = debutPartie;
		this.etatManche = etatManche;
	}
	
	public boolean placerRegimentTerritoire(Joueur joueur, Territoire territoire, int nbrRegiment) {
		if(territoire.getProprietaire() == joueur) {
			territoire.ajouterRegiments(nbrRegiment);
			System.out.println("Regiments places avec succes sur le territoire choisi.");
			return true;
		} else {
			System.out.println("Vous ne pouvez pas ajouter des regiments dans un territoire que vous ne possedez pas...");
			return false;
		}
	}
	
	public int getNumeroManche() {
		return numeroManche;
	}


	public Date getDebutPartie() {
		return debutPartie;
	}


	public EtatManche getEtatManche() {
		return etatManche;
	}


	public ArrayList<Joueur> getClassement() {
		return classement;
	}


	public ArrayList<Joueur> getJoueursManche() {
		return joueursManche;
	}


	public void setFinPartie(Date finPartie) {
		this.finPartie = finPartie;
	}


	public void ajouterJoueur(Joueur joueur) {
		this.joueursManche.add(joueur);
	}
	
	public boolean deplacerRegiments(Joueur joueur, Territoire territoireDepart, Territoire territoireArrive, int nbrADeplacer) {
		if(territoireDepart.getProprietaire().equals(joueur)&&territoireArrive.getProprietaire().equals(joueur)) {
			boolean supprime = territoireDepart.supprimerRegiments(nbrADeplacer);
			if(supprime) {
				territoireArrive.ajouterRegiments(nbrADeplacer);
				return true;
			}
		}
		
		return false;
	}
	
}
