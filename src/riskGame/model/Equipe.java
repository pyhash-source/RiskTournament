package riskGame.model;

import java.util.ArrayList;

/**
*
* @author fitia
*/

public class Equipe {
	private int numeroEquipe;
	private ArrayList<Joueur> Joueurs;
	
	//Constructors
	public Equipe(int numeroEquipe) {
		super();
		this.numeroEquipe = numeroEquipe;
		this.Joueurs = new ArrayList<Joueur>();
	}

	//Getters and setters
	public int getNumeroEquipe() {
		return numeroEquipe;
	}

	public void setNumeroEquipe(int numeroEquipe) {
		this.numeroEquipe = numeroEquipe;
	}

	public ArrayList<Joueur> getJoueurs() {
		return Joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		Joueurs = joueurs;
	}
	
	
}
