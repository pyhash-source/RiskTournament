package riskGame.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;


/**
 * @author Jean, elisa(ou svrs), Fitia

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
	
	public void mettreAJourClassement(Joueur joueur) {
		this.classement.add(0, joueur);
	}
	
	public int calculerScore(Joueur joueur) {
		int positionJoueur=0;
		for(Joueur joueurListe : this.classement) {
			if(joueurListe == joueur) {
				break; 
			}
			positionJoueur++;
			
		}
		//calcul en fonction de la position du joueur
		switch(positionJoueur) {
		case 0: 
			return 10;
		case 1: 
			return 8;
		case 2: 
			return 6;
		case 3:
			return 4;
		case 4:
			return 1;
		case 5: 
			return 0;
			
		}
		return 0;
	}
	
	public int getNumeroManche() {
		return numeroManche;
	}


	public Date getDebutPartie() {
		return debutPartie;
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

	public EtatManche getEtatManche() {
		return etatManche;
	}

	public int recupererClassementJoueur(Joueur joueur) {
		return (this.classement.indexOf(joueur)+1);
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
	 * Cette fonction permet de d�terminer le premier joueur d'un jeu en utilisant un lancer de d� pour chaque joueur
	 */
	
	public Joueur determinerPremierJoueur() {
		
		Random random = new Random();
		HashMap <Joueur, Integer> resultatLancementDe = new HashMap<>();
		
		// G�n�rer des nombres al�atoires pour chaque joueur 
		for (Joueur joueur : this.joueursManche) {
		    int randomNumber = random.nextInt(6) + 1;
		    resultatLancementDe.put(joueur, randomNumber);
		}
				
		// Rechercher le premier joueur en le recherchant dans mon HashMap resultatLancementDe
        Joueur premierJoueur = null;
        int maxNumber = 0;
        
        Iterator it;
        it = resultatLancementDe.keySet().iterator();
        StringBuilder message = new StringBuilder("R�sultats du lancement de d� : \n");
		        
        while(it.hasNext()) {
        	Joueur joueurActuel = (Joueur) it.next(); 
        	Integer number = resultatLancementDe.get(joueurActuel);
        	
        	//Afficher le nom du joueur et son score
        	message.append(joueurActuel.getPrenomJoueur()).append(" : ").append(number).append("\n");
        	if (number>maxNumber) {
        		maxNumber=number;
        		//D�terminer premier joueur
        		premierJoueur = joueurActuel;
        	}
        }
		        
        message.append("\nLe premier joueur � jouer est ").append(premierJoueur.getPrenomJoueur());
       
        // Affichage popup
        JOptionPane.showMessageDialog(null, message.toString());
		return premierJoueur;

	}
		public boolean deplacerRegiments(Joueur joueur, Territoire territoireDepart, Territoire territoireArrive, int nbrADeplacer) {
		if(territoireDepart.getProprietaire().equals(joueur)&&territoireArrive.getProprietaire().equals(joueur)) {
			boolean supprime = territoireDepart.supprimerRegiments(nbrADeplacer);
			if(supprime) {
				territoireArrive.ajouterRegiments(nbrADeplacer);
				joueur.setNombreDeplacement(joueur.getNombreDeplacement()+nbrADeplacer);
				return true;
			}
		}
		
		return false;
}
