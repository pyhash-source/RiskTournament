package riskGame.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jean
 **/

public class Manche {
	private int numeroManche;
	private Date debutPartie;
	private Date finPartie;

	private EtatManche etatManche;
	private ArrayList<Joueur> classement;
	private ArrayList<Joueur> joueursManche;
	private int nbEchanges;
	
	public Manche(int numeroManche, Date debutPartie, EtatManche etatManche) {
		super();
		this.numeroManche = numeroManche;
		this.debutPartie = debutPartie;
		this.etatManche = etatManche;
		this.nbEchanges = 0 ; 
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


	public int getNbEchanges() {
		return nbEchanges;
	}


	public void setNbEchanges(int nbEchanges) {
		this.nbEchanges = nbEchanges;
	}


	public Date getFinPartie() {
		return finPartie;
	}


	public void setNumeroManche(int numeroManche) {
		this.numeroManche = numeroManche;
	}


	public void setDebutPartie(Date debutPartie) {
		this.debutPartie = debutPartie;
	}


	public void setEtatManche(EtatManche etatManche) {
		this.etatManche = etatManche;
	}


	public void setClassement(ArrayList<Joueur> classement) {
		this.classement = classement;
	}


	public void setJoueursManche(ArrayList<Joueur> joueursManche) {
		this.joueursManche = joueursManche;
	}
	
	public void augmenterCompteur() {
		this.nbEchanges++;
	}
}
