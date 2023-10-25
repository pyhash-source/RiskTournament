package riskGame.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

import riskGame.vue.PlanispherePanel;

import java.util.Arrays;

/**
 * @author Jean, elisa/SVRS, Fitia, Zhuo, YasmineV
 * 
 **/

public class Manche {
	private int numeroManche;
	private Date debutPartie;
	private Date finPartie;

	private EtatManche etatManche;
	private ArrayList<Joueur> classement;
	private ArrayList<Joueur> joueursManche;
	private int nbEchanges;
	private PlanispherePanel planispherePanel;
	private boolean mancheFinie;

	public Manche(int numeroManche, Date debutPartie, EtatManche etatManche, PlanispherePanel planispherePanel) {
		this.numeroManche = numeroManche;
		this.debutPartie = debutPartie;
		this.etatManche = etatManche;
		this.nbEchanges = 0;
		this.planispherePanel = planispherePanel;
		this.mancheFinie = false;
	}

	public boolean placerRegimentTerritoire(Joueur joueur, Territoire territoire, int nbrRegiment) {
		boolean existeTerritoireVide = false;
		for (Territoire t : this.planispherePanel.getTerritoires()) {
			if (t.getProprietaire() == null) {
				existeTerritoireVide = true;
				break;
			}

		}
		if (existeTerritoireVide) {
			if (territoire.getProprietaire()!=null) {

				System.out.println(territoire.getNomTerritoire()+" "
						+territoire.getProprietaire().getPrenomJoueur());

				return false;
			} else {
				territoire.setProprietaire(joueur);
				territoire.ajouterRegiments(nbrRegiment);
				
				return true;
			}

		} else {
			// on force le joueur a ajouter des regiments dans ses territoires actuels si
			// tous les territoires actuels sont deja
			// occupes

			// on verfie que pour le joueur courant on est dans un territoire qui lui
			// appartient
			if (territoire.getProprietaire().equals(joueur)) {
				territoire.ajouterRegiments(nbrRegiment);
				return true;
			} else {
				return false;
			}
		}
	}

	// fonction pour le début du renfort
	public void placerRegimentsInitiaux() {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				Joueur joueurActuel = this.planispherePanel.getJoueurEnCours();
				
				boolean placerRegiment = false;
				while (!placerRegiment) {
				placerRegiment = this.placerRegimentTerritoire(joueurActuel,this.planispherePanel.getTerritoireSelectionne(), 1);	
				
				}
				this.planispherePanel.updateUI();
				this.changerJoueur();
				

			}
		}
		

	}

	public void boucleJeu() {
		while(!mancheFinie) {
			renforcer();
			attaquer();
			manoeuvrer();
			changerJoueur();
		}
	}

	
	public void renforcer() {
		//todo bonus continent
		System.out.println("debut phase renfort");
		System.out.println("joueur: "+this.planispherePanel.getJoueurEnCours().getNomJoueur());
		int nbrRegimentsCartes = this.planispherePanel.getJoueurEnCours().echangerCarte(this);
		System.out.println("echange carte: "+nbrRegimentsCartes);
		int nbrTerritoires = this.getListeTerritoiresPourUnJoueur(this.planispherePanel.getJoueurEnCours()).size();
		System.out.println("le joueur a : "+nbrTerritoires);
		int nbrRegimentsAdd = nbrTerritoires / 3;
		if(nbrRegimentsAdd<3) {
			nbrRegimentsAdd = 3;
		}
		this.planispherePanel.getJoueurEnCours().setNombreRegimentsRecuperes(nbrRegimentsAdd+nbrRegimentsCartes+this.planispherePanel.getJoueurEnCours().getNombreRegimentsRecuperes());
		int nombreAPlacer = nbrRegimentsAdd +nbrRegimentsCartes;
		System.out.println("nombre a placer: "+nombreAPlacer);
		while(nombreAPlacer!=0) {
			System.out.println("je rentre ds le while");
			System.out.println(this.planispherePanel.getTerritoireSelectionne().getNomTerritoire() + "EL FAMOSO valeur: " + this.planispherePanel.isaClique());
			System.out.println(this.planispherePanel.isaClique());
			if(this.planispherePanel.isaClique()) {
				System.out.println("je rentre dabs le if");
				boolean place = false;
				place = this.placerRegimentTerritoire(this.planispherePanel.getJoueurEnCours(), this.planispherePanel.getTerritoireSelectionne(), 1);
				this.planispherePanel.setaClique(false);
				if(place) {
					nombreAPlacer --;
				}
				//tout doux: faire ,nombre a placer -- ssi placer regiment renvoie true
				System.out.println("nbr a placer:" +nombreAPlacer);
				this.planispherePanel.updateUI();

			}
			
			
		}
		
	}
	private void attaquer() {
		System.out.println("debut phase attaque");
		// en boucle jusquua quil veut arreter
		
		//choisir dequel on attaque
		//choisir terriroire a att
		//choisir nbr regiment
		//lancer les des
		//supprimer les regiments
		//recuperer carte si je gagne un territoire
	}
	
	
	public void manoeuvrer() {
		System.out.println("debut phase manoeuvre");
		//en boucle
		//deplacer
		//joueur suivant
	}
	

	public ArrayList<Territoire> getListeTerritoires() {
		return this.planispherePanel.getTerritoires();
	}

	public ArrayList<Joueur> getListeJoueurs() {
		return this.planispherePanel.getJoueurs();
	}

	public ArrayList<Territoire> getListeTerritoiresPourUnJoueur(Joueur joueur) {
		ArrayList<Territoire> territoiresPossedes = new ArrayList<Territoire>();
		for (Territoire territoire : this.getListeTerritoires()) {
			if (territoire.getProprietaire() != null) {
				if (territoire.getProprietaire().equals(joueur)) {
					territoiresPossedes.add(territoire);
				}
			}
		}

		return territoiresPossedes;
	}

	public void mettreAJourClassement(Joueur joueur) {
		this.classement.add(0, joueur);
	}

	public int calculerScore(Joueur joueur) {
		int positionJoueur = 0;
		for (Joueur joueurListe : this.classement) {
			if (joueurListe == joueur) {
				break;
			}
			positionJoueur++;

		}
		// calcul en fonction de la position du joueur
		switch (positionJoueur) {
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
		return (this.classement.indexOf(joueur) + 1);
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

	// Methods

	/*
	 * Cette fonction permet de determiner le premier joueur d'un jeu en utilisant
	 * un lancer de de pour chaque joueur
	 */
	public void augmenterCompteur() {
		this.nbEchanges++;
	}

	public Joueur determinerPremierJoueur() {

		Random random = new Random();
		HashMap<Joueur, Integer> resultatLancementDe = new HashMap<>();

		// Gerer des nombres aletoires pour chaque joueur
		for (Joueur joueur : this.joueursManche) {
			int randomNumber = random.nextInt(6) + 1;
			resultatLancementDe.put(joueur, randomNumber);
		}

		// Rechercher le premier joueur en le recherchant dans mon HashMap
		// resultatLancementDe
		Joueur premierJoueur = null;
		int maxNumber = 0;

		Iterator it;
		it = resultatLancementDe.keySet().iterator();
		StringBuilder message = new StringBuilder("Resultats du lancement de dé : \n");

		while (it.hasNext()) {
			Joueur joueurActuel = (Joueur) it.next();
			Integer number = resultatLancementDe.get(joueurActuel);

			// Afficher le nom du joueur et son score
			message.append(joueurActuel.getPrenomJoueur()).append(" : ").append(number).append("\n");
			if (number > maxNumber) {
				maxNumber = number;
				// Determiner premier joueur
				premierJoueur = joueurActuel;
			}
		}

		message.append("\nLe premier joueur a jouer est ").append(premierJoueur.getPrenomJoueur());

		// Affichage popup
		JOptionPane.showMessageDialog(null, message.toString());
		return premierJoueur;

	}

	public boolean deplacerRegiments(Joueur joueur, Territoire territoireDepart, Territoire territoireArrive,
			int nbrADeplacer) {
		if (territoireDepart.getProprietaire().equals(joueur) && territoireArrive.getProprietaire().equals(joueur)) {
			boolean supprime = territoireDepart.supprimerRegiments(nbrADeplacer);
			if (supprime) {
				territoireArrive.ajouterRegiments(nbrADeplacer);
				joueur.setNombreDeplacement(joueur.getNombreDeplacement() + nbrADeplacer);
				return true;
			}
		}
		return false;
	}

	// fonction pour confronter
	// todo supprimer les rgts perdus de l'attaquant + check si c'est possible
	// d'attaquer du territoire
	public int confronterManche(Joueur joueurAttaque, Territoire territoire) {

		// get nombre régiments defence
		Joueur joueurDefense = territoire.getProprietaire();
		int nbrRegimentsDefense = territoire.getNbrRegiment();

		// get nombre attaque
		String nombreAttaque = (String) JOptionPane.showInputDialog("Combien de régiments voulez-vous attaquer ? ");
		int nbrAttaque = Integer.parseInt(nombreAttaque);

		// stocker resultat pour lance les des
		int[] resultAttaque = new int[nbrAttaque];

		// lance les dés
		for (int i = 0; i < nbrAttaque; i++) {
			resultAttaque[i] = lancerUnDe();
		}

		int[] resultDefense;
		if (nbrRegimentsDefense >= 2) {
			resultDefense = new int[2];
			for (int i = 0; i < 2; i++) {
				resultDefense[i] = lancerUnDe();
			}
		} else {
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
				System.out.println("Pour valeur" + (i + 1) + "Joueur Attaque gagne !");
				nbrRegimentASupprimerDef += 1;
			} else {
				System.out.println("Pour valeur" + (i + 1) + "Joueur Defense gagne !");
				nbrRegimentASupprimerAtt += 1;
			}
		}
		territoire.supprimerRegiments(nbrRegimentASupprimerDef);
		return nbrRegimentASupprimerAtt;

	}

	public int lancerUnDe() {
		Random random = new Random();
		// obtenir entier [1,6[
		int deResult = random.nextInt(6) + 1;
		return deResult;
	}

	// fonction pour changer de joueur
	public void changerJoueur() {
		Joueur joueurAcutel = this.planispherePanel.getJoueurEnCours();
		ArrayList<Joueur> listeJoueurs = this.planispherePanel.getJoueurs();
		int position = listeJoueurs.indexOf(joueurAcutel);
		if (position == listeJoueurs.size() - 1) {
			this.planispherePanel.setJoueurEnCours(listeJoueurs.get(0));
		} else {
			this.planispherePanel.setJoueurEnCours(listeJoueurs.get(position + 1));
		}
	}

	// fonction pour changer de tour
	public void changerTour() {

	}
}
