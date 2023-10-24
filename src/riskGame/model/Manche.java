package riskGame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner; 

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
	
	// confronter(JoueurAttaque, JoueurDefense, nbrDeA, nbrDeD): void dans manche
	public void confronterManche(Joueur joueurAttaque, Joueur joueurDefense) {
		// get joueurInfo
		int nomJoueurAttaque = joueurAttaque.getNumeroJoueur();
	    int nomJoueurDefense = joueurDefense.getNumeroJoueur();
		
	    int[] resultAttaque = new int[3]; // maximum de trois fois
	    int[] resultDefense = new int[2]; // maximum de deux fois
	   
	    // resultat pour lance les dés 
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Combien de fois voulez-vous lancer les dés ?");
	    int nbDeAtt = scan.nextInt();
	    
	    System.out.println("Combien de régiments avez-vous ?");
	    int nbDeDef = scan.nextInt();
	    
	    //  lance les dés
	    for (int i = 0; i < nbDeAtt; i++) {
	        resultAttaque[i] = lancerUnDe(); 
	    }
	    for (int i = 0; i < nbDeDef; i++) {
	    	resultDefense[i] = lancerUnDe(); 
	    }
	    
	    // Trier les résultats du plus grand au plus petit
	    Arrays.sort(resultAttaque);
	    Arrays.sort(resultDefense);
	    
	    // Comparer les résultats des dés un par un
	    for (int i = 0; i < Math.min(nbDeAtt, nbDeDef); i++) {
	        if (resultAttaque[i] > resultDefense[i]) {
	            System.out.println("Pour valeur"+ (i+1)+ "Joueur Attaque gagne !");
	        } else{
	            System.out.println("Pour valeur"+ (i+1)+ "Joueur Defense gagne !");
	        }
	    }
	    
	}
	
	public int lancerUnDe() {
	    Random random = new Random();
	    int min = 1; 
	    int max = 6; 
	    // obtenir entier [1,6]
	    int deResult = random.nextInt(max - min + 1) + min;
	    return deResult;
	}
	
}
