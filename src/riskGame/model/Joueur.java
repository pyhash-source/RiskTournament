package riskGame.model;

import java.util.ArrayList;

/**
*
* @author fitia
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
			
		
}
