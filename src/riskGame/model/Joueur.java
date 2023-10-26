package riskGame.model;

import java.util.ArrayList;
import java.util.Objects;

/**
*
* @author fitia, elisa(or svrs),yasmineV, Jean
* 
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
		private int nombreAttaquesLancees;
		private int nombreDeplacement;
		private int nombreLancerDeDes;
		private int nombreDesUn;
		private int nombreDefensesReussies;
		private int nombreTerritoiresConquis;
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
	        this.nombreAttaquesLancees = 0;
	        this.nombreDeplacement = 0;
	        this.nombreLancerDeDes = 0;
	        this.nombreDesUn = 0;
	        this.nombreDefensesReussies = 0;
	        this.nombreTerritoiresConquis=0;
	        this.mesCartes = new ArrayList<>();
	    }
		/**
		 * Retourne le nom du joueur
		 * @return String
		 */
		public String getNomJoueur() {
			return nomJoueur;
		}
		
		/**
		 * Definit le nom du joueur
		 */
		public void setNomJoueur(String nomJoueur) {
			this.nomJoueur = nomJoueur;
		}

		/**
		 * Retourne la date de naissance du joueur
		 * @return String
		 */
		public String getDateNaissance() {
			return dateNaissance;
		}

		/**
		 * Definit la date de naissance du joueur
		 */
		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		/**
		 * Retourne le nombre de lancer de des effectues par le joueur au cours de la partie
		 * @return int
		 */
		public int getNombreLancerDeDes() {
			return nombreLancerDeDes;
		}

		/**
		 * Definit le nombre de lancers de des effectues par le joueur
		 */
		public void setNombreLancerDeDes(int nombreLancerDeDes) {
			this.nombreLancerDeDes = nombreLancerDeDes;
		}

		/**
		 * Retourne le prenom du joueur
		 * @return String
		 */
		public String getPrenomJoueur() {
			return prenomJoueur;
		}

		/**
		 * Definit le prenom du joueur
		 */
		public void setPrenomJoueur(String prenomJoueur) {
			this.prenomJoueur = prenomJoueur;
		}

		/**
		 * Retourne la couleur du joueur
		 * @return TypeCouleur
		 */
		public TypeCouleur getCouleurJoueur() {
			return this.couleurJoueur;
		}

		/**
		 * Definit la couleur du joueur
		 */
		public void setCouleurJoueur(TypeCouleur couleurJoueur) {
			this.couleurJoueur = couleurJoueur;
		}

		/**
		 * Retourne les cartes du joueur
		 * @return ArrayList<Carte>
		 */
		public ArrayList<Carte> getMesCartes() {
			return mesCartes;
		}

		/**
		 * Definit les cartes dont dispose d'un joueur
		 */
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

		public int getNombreDeplacement() {
			return nombreDeplacement;
		}
		public void setNombreDeplacement(int nombreDeplacement) {
			this.nombreDeplacement = nombreDeplacement;
		}
		
		public void ajouterCarte(Carte carte) {
			this.mesCartes.add(carte);
		}


		public int getNombreAttaquesLancees() {
			return nombreAttaquesLancees;
		}
		public void setNombreAttaquesLancees(int nombreAttaquesLancees) {
			this.nombreAttaquesLancees = nombreAttaquesLancees;
		}
		public int getNombreDesUn() {
			return nombreDesUn;
		}
		public void setNombreDesUn(int nombreDesUn) {
			this.nombreDesUn = nombreDesUn;
		}
		public int getNombreDefensesReussies() {
			return nombreDefensesReussies;
		}
		public void setNombreDefensesReussies(int nombreDefensesReussies) {
			this.nombreDefensesReussies = nombreDefensesReussies;
		}
		public int getNombreTerritoiresConquis() {
			return nombreTerritoiresConquis;
		}
		public void setNombreTerritoiresConquis(int nombreTerritoiresConquis) {
			this.nombreTerritoiresConquis = nombreTerritoiresConquis;
		}
		@Override
		public int hashCode() {
			return Objects.hash(couleurJoueur, dateNaissance, etatJoueur, mesCartes, nomJoueur, nombreAttaquesLancees,
					nombreCartesEchangees, nombreCartesTirees, nombreDefensesReussies, nombreDeplacement, nombreDesUn,
					nombreLancerDeDes, nombreRegimentsElimines, nombreRegimentsRecuperes, nombreTerritoiresConquis,
					numeroJoueur, prenomJoueur);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Joueur other = (Joueur) obj;
			return couleurJoueur == other.couleurJoueur && Objects.equals(dateNaissance, other.dateNaissance)
					&& etatJoueur == other.etatJoueur && Objects.equals(mesCartes, other.mesCartes)
					&& Objects.equals(nomJoueur, other.nomJoueur)
					&& nombreAttaquesLancees == other.nombreAttaquesLancees
					&& nombreCartesEchangees == other.nombreCartesEchangees
					&& nombreCartesTirees == other.nombreCartesTirees
					&& nombreDefensesReussies == other.nombreDefensesReussies
					&& nombreDeplacement == other.nombreDeplacement && nombreDesUn == other.nombreDesUn
					&& nombreLancerDeDes == other.nombreLancerDeDes
					&& nombreRegimentsElimines == other.nombreRegimentsElimines
					&& nombreRegimentsRecuperes == other.nombreRegimentsRecuperes
					&& nombreTerritoiresConquis == other.nombreTerritoiresConquis && numeroJoueur == other.numeroJoueur
					&& Objects.equals(prenomJoueur, other.prenomJoueur);
		}

		
}