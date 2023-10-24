package riskGame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
//import java.util.Scanner;

import javax.swing.JOptionPane; 

/**
 * @author Jean;Zhuo
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
	
	// fonction pour confronter
	//todo supprimer les rgts perdus de l'attaquant + check si c'est possible d'attaquer du territoire
	public int confronterManche(Joueur joueurAttaque, Territoire territoire) {
		
		// get nombre régiments defence
		Joueur joueurDefense = territoire.getProprietaire();
		int nbrRegimentsDefense = territoire.getNbrRegiment();
	    
		// get nombre attaque
	    String nombreAttaque = (String) JOptionPane.showInputDialog("Combien de régiments voulez-vous attaquer ? ");
	    int nbrAttaque =  Integer.parseInt(nombreAttaque);
	    
	    // stocker resultat pour lance les des
	    int[] resultAttaque = new int[nbrAttaque];
	      
	    //  lance les dés
	    for (int i = 0; i < nbrAttaque; i++) {
	        resultAttaque[i] = lancerUnDe(); 
	    }
	    
	    int[] resultDefense;
	    if(nbrRegimentsDefense>=2) {
	    	resultDefense = new int[2];
	    	for (int i = 0; i < 2; i++) {
		    	resultDefense[i] = lancerUnDe(); 
		    }
	    }else {
	    	resultDefense = new int[1];
	    	resultDefense[0] = lancerUnDe(); 
		    
	    }
	    
	    // Trier les résultats du plus grand au plus petit
	    Arrays.sort(resultAttaque);
	    Arrays.sort(resultDefense);
	    
	    // Comparer les résultats des dés un par un
	    // gagne: ajouter regiment
	    // perdu: supprimer regiment
	    int nbrRegimentASupprimerAtt = 0;
	    int nbrRegimentASupprimerDef = 0;
	    
	    for (int i = 0; i < Math.min(nbrAttaque, nbrRegimentsDefense); i++) {
	        if (resultAttaque[i] > resultDefense[i]) {
	            System.out.println("Pour valeur"+ (i+1)+ "Joueur Attaque gagne !");
	            nbrRegimentASupprimerDef +=1;
	        } else{
	            System.out.println("Pour valeur"+ (i+1)+ "Joueur Defense gagne !");
	            nbrRegimentASupprimerAtt +=1;
	        }
	    }
	    territoire.supprimerRegiments(nbrRegimentASupprimerDef);
	    return nbrRegimentASupprimerAtt;
	    
	}
	
	public int lancerUnDe() {
	    Random random = new Random();
	    int min = 1; 
	    int max = 6; 
	    // obtenir entier [1,6[
	    int deResult = random.nextInt(6) + min;
	    return deResult;
	}
	
}
