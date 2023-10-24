package riskGame.model;

import java.util.ArrayList;

/**
*
* @author fitia,yasmineV
*/

public class Joueur {
		private String nomJoueur;
		private String prenomJoueur;
		private String dateNaissance;
		private int numeroJoueur; 
		private EtatJoueur etatJoueur;
		private TypeCouleur couleurJoueur;
		private int nombreCartesTirees;
		private int nombreCartesEchangees;
		private int nombreRegimentsRecuperes;
		private int nombreRegimentsElimines;
		private int nombreAttaques;
		private int nombreDeplacement;
		private ArrayList<Carte> mesCartes;
		
		//Constructor
		public Joueur(String nomJoueur, String prenomJoueur, String dateNaissance, EtatJoueur etatJoueur,int numeroJoueur, TypeCouleur typeCouleur) {
	        this.nomJoueur = nomJoueur;
	        this.prenomJoueur = prenomJoueur;
	        this.dateNaissance = dateNaissance;
	        this.etatJoueur = etatJoueur;
	        this.couleurJoueur = typeCouleur;
	        this.nombreCartesTirees = 0;
	        this.nombreCartesEchangees = 0;
	        this.nombreRegimentsRecuperes = 0;
	        this.nombreRegimentsElimines = 0;
	        this.nombreAttaques = 0;
	        this.nombreDeplacement = 0;
	    }
		
		public String getPrenomJoueur() {
			return prenomJoueur;
		}

		public void setPrenomJoueur(String prenomJoueur) {
			this.prenomJoueur = prenomJoueur;
		}

		public TypeCouleur getCouleurJoueur() {
			return this.couleurJoueur;
		}

		public void setCouleurJoueur(TypeCouleur couleurJoueur) {
			this.couleurJoueur = couleurJoueur;
		}

		public ArrayList<Carte> getMesCartes() {
			return mesCartes;
		}

		public void setMesCartes(ArrayList<Carte> mesCartes) {
			this.mesCartes = mesCartes;
		}

		//Getters and setters
		public int getNumeroJoueur() {
			return numeroJoueur;
		}
		public void setNumeroJoueur(int numeroJoueur) {
			this.numeroJoueur = numeroJoueur;
		}
		public EtatJoueur getEtatJoueur() {
			return etatJoueur;
		}
		public void setEtatJoueur(EtatJoueur etatJoueur) {
			this.etatJoueur = etatJoueur;
		}
		public int getNombreCartesTirees() {
			return nombreCartesTirees;
		}
		public void setNombreCartesTirees(int nombreCartesTirees) {
			this.nombreCartesTirees = nombreCartesTirees;
		}
		public int getNombreCartesEchangees() {
			return nombreCartesEchangees;
		}
		public void setNombreCartesEchangees(int nombreCartesEchangees) {
			this.nombreCartesEchangees = nombreCartesEchangees;
		}
		public int getNombreRegimentsRecuperes() {
			return nombreRegimentsRecuperes;
		}
		public void setNombreRegimentsRecuperes(int nombreRegimentsRecuperes) {
			this.nombreRegimentsRecuperes = nombreRegimentsRecuperes;
		}
		public int getNombreRegimentsElimines() {
			return nombreRegimentsElimines;
		}
		public void setNombreRegimentsElimines(int nombreRegimentsElimines) {
			this.nombreRegimentsElimines = nombreRegimentsElimines;
		}
		public int getNombreAttaques() {
			return nombreAttaques;
		}
		public void setNombreAttaques(int nombreAttaques) {
			this.nombreAttaques = nombreAttaques;
		}
		public int getNombreDeplacement() {
			return nombreDeplacement;
		}
		public void setNombreDeplacement(int nombreDeplacement) {
			this.nombreDeplacement = nombreDeplacement;
		}
//[TODO] à tester 
//fonction pour l'échange de cartes
		public int echangerCarte(Manche manche) {
			int compteur = manche.getNbEchanges();
		    int nbrRegiments = 0;
		    //un compteur pour calculer le nb d'échanges
		    
		    ArrayList<Carte> infanterie = new ArrayList();
		    ArrayList<Carte> cavalerie =  new ArrayList() ;
		    ArrayList<Carte> artillerie =  new ArrayList();
		    //nombreCartesEchangees+=3;
			//nombreRegimentsRecuperes+=nbrRegiments;

		    //parcourir la liste de cartes du joueur
            for(Carte c: this.mesCartes) {
	            if(c.getTypeRegiment()==TypeRegiment.INFANTERIE) {
	            	infanterie.add(c);
	             }
	            if(c.getTypeRegiment()==TypeRegiment.CAVALERIE) {
		            cavalerie.add(c);
	             }
	            if(c.getTypeRegiment()==TypeRegiment.ARTILLERIE) {
		            artillerie.add(c);
	            }
	
}
            while (infanterie.size() >= 3 || cavalerie.size() >= 3 || artillerie.size() >= 3 ||
            	       (infanterie.size() >= 1 && cavalerie.size() >= 1 && artillerie.size() >= 1)) {
            	 this.nombreCartesEchangees+=3;
            	 manche.augmenterCompteur();
		    	if(compteur ==1){
		    		nbrRegiments += 4;
		    	}
		    	else if (compteur ==2) {
		    		nbrRegiments += 6;
		    	}
		    	else if (compteur ==3) {
		    		nbrRegiments += 8;
		    	}
		    	else if (compteur ==4) {
		    		nbrRegiments += 10;
		    	}
		    	else if (compteur ==5) {
		    		nbrRegiments += 12;
		    	}
		    	else if (compteur ==6) {
		    		nbrRegiments += 15;
		    	}
		    	else {
		    		nbrRegiments += 15 + (compteur - 5) * 5; // Gagnez 15 régiments au 6e échange, puis 5 de plus à chaque échange supplémentaire
		    		
		        }
		    	// Retirer les cartes échangées des listes
		    	
		    	if(infanterie.size() >= 3) {
		    		for (int i = 0; i < 3; i++) {
		                this.mesCartes.remove(infanterie.remove(0));
		    		}
		    	}
		    	
		    	else if(cavalerie.size() >= 3) {
		    		for (int i = 0; i < 3; i++) {
		                this.mesCartes.remove(cavalerie.remove(0));
		    		}
		    	}
		    	
		    	else if(artillerie.size() >= 3) {
		    		for (int i = 0; i < 3; i++) {
		                this.mesCartes.remove(artillerie.remove(0));
		    		}
		    	}
		    	else if(infanterie.size() >= 1 && cavalerie.size() >= 1 && artillerie.size() >= 1) {
		    		this.mesCartes.remove(infanterie.remove(0));
		    		this.mesCartes.remove(cavalerie.remove(0));
		    		this.mesCartes.remove(artillerie.remove(0));
		    	}
		    	
		       
		    }
            nombreRegimentsRecuperes+=nbrRegiments;	
		    return nbrRegiments;
		}

		
		
}