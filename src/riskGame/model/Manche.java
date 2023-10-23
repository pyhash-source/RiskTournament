package riskGame.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Jean
 **/

public class Manche {
	private int numeraManche;
	private Date debutPartie;
	private Date finPartie;
	private EtatManche etatManche;
	private ArrayList<Joueur> classement;
	private ArrayList<Joueur> joueursManche;
	
	public void ajouterJoueur(Joueur joueur) {
		this.joueursManche.add(joueur);
	}
	
}
