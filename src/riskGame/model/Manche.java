package riskGame.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 * @author Jean, Fitia
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
	
	// Methods
	
	/*
	 * Cette fonction permet de déterminer le premier joueur d'un jeu en utilisant un lancer de dé pour chaque joueur
	 */
	
	public Joueur determinerPremierJoueur() {
		
		Random random = new Random();
		HashMap <Joueur, Integer> resultatLancementDe = new HashMap<>();
		
		// Générer des nombres aléatoires pour chaque joueur 
		for (Joueur joueur : this.joueursManche) {
		    int randomNumber = random.nextInt(6) + 1;
		    resultatLancementDe.put(joueur, randomNumber);
		}
				
		// Rechercher le premier joueur en le recherchant dans mon HashMap resultatLancementDe
        Joueur premierJoueur = null;
        int maxNumber = 0;
        
        Iterator it;
        it = resultatLancementDe.keySet().iterator();
        StringBuilder message = new StringBuilder("Résultats du lancement de dé : \n");
		        
        while(it.hasNext()) {
        	Joueur joueurActuel = (Joueur) it.next(); 
        	Integer number = resultatLancementDe.get(joueurActuel);
        	
        	//Afficher le nom du joueur et son score
        	message.append(joueurActuel.getPrenomJoueur()).append(" : ").append(number).append("\n");
        	if (number>maxNumber) {
        		maxNumber=number;
        		//Déterminer premier joueur
        		premierJoueur = joueurActuel;
        	}
        }
		        
        message.append("\nLe premier joueur à jouer est ").append(premierJoueur.getPrenomJoueur());
       
        // Affichage popup
        JOptionPane.showMessageDialog(null, message.toString());
		return premierJoueur;
	}
	
}
