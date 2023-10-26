package riskGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import riskGame.model.EtatJoueur;
import riskGame.model.EtatManche;
import riskGame.model.Joueur;
import riskGame.model.Manche;
import riskGame.model.TypeCouleur;
//import riskGame.model.AbstractModel;
import riskGame.vue.PlanispherePanel;


public class RiskGame {
	static String tournoiChoisi = "";
	static String competitionChoisie = "";
	static String mancheChoisie = "";
	static ArrayList<Joueur> listeJoueurs = new ArrayList<>();
	static Manche manche;
	static PlanispherePanel planisphere;

	/**
	 * lance la premiere fenetre
	 */
	public static void main(String[] args) {
		mainMenuGUI();
	}
	
/**
 * propose de lancer une partie, ou autre
 */
	private static void mainMenuGUI() {
		//options proposees
		String[] optionsToChoose = { "Lancer une partie", "Consulter trophées" };
		//question affichee
		String choice = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ", "Risk e-sport [MENU]",
				JOptionPane.PLAIN_MESSAGE, null, optionsToChoose, optionsToChoose[0]);
		if (choice == null) {
			System.out.println("Quitting app...");
		} else if (choice == "Lancer une partie") {
			choixCompetitionGUI();
		} else if(choice == "Consulter trophées") {
			afficherTrophees();
		}
	}

	/**
	 * permet de choisir une competition
	 */
	private static void choixCompetitionGUI() {
		// ----------debut logique recuperation des competitions--------------
		//recuperer les noms des competitions
		ArrayList<String> bufferTableau = new ArrayList<String>();
		try {
			//connection a la bd
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			//execution de la requete
			ResultSet resultat = stmt.executeQuery("SELECT c.nomCompetition FROM competition c");
			
			//processing the data:
			while(resultat.next()) {
				//recupere pour chaque ligne le nom de la competition
				bufferTableau.add(resultat.getString("nomCompetition"));
				
			}
			//fermer le connexion
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//il faut un tableau pour la boite de dialogue
		//conversion de l'arraylist en list
		String[] competitionToChoseFrom = new String[bufferTableau.size()];
		for(int i=0;i<bufferTableau.size();i++) {
			competitionToChoseFrom[i] = bufferTableau.get(i);
		}

		// -----------fin de bloc de recuperation des competition-------------
		//pose la question et affiche le competitions qu'il est possible de choisir
		String competition = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ",
				"Choix de la competition", JOptionPane.PLAIN_MESSAGE, null, competitionToChoseFrom,
				competitionToChoseFrom[0]);

		
		if (competition == null) {
			System.out.println("Quitting app...");
		} else {
			//afficher le choix fait
			int resultatConfirmation = JOptionPane.showConfirmDialog(null,
					"Vous allez lancer une partie dans le cadre de la competition: " + competition);
			if (resultatConfirmation == 0) {
				//lance le choix pour le tournoi
				competitionChoisie = competition;
				choixTournoiGUI();
			} else if (resultatConfirmation == 1) {
				// ERREUR: retour au choix de la competition
				choixCompetitionGUI();
			}
		}

	}
//	Le malchanceux : remis au joueur qui a obtenu le plus de 1 à ses lancés de
//	dès lors des phases d’attaque/défense
//	- Le belliqueux : remis au joueur qui a déclenché le plus grand nombre
//	d’attaques.
//	- Le bouclier : remis au joueur qui a réussis le plus de défenses.
//	- Le conquérant : remis au joueur qui a conquis le plus de territoires.
	
	private static void afficherTrophees() {
		StringBuilder message = new StringBuilder("Les trophées sont:");
		message.append("\nLe trophée Malchanceux est attribué à ").append("");
		message.append("\nLe trophée Belliqueux est attribué à ").append("");
		message.append("\nLe trophée Bouclier est attribué à ").append("");
		message.append("\nLe trophée Conquérant est attribué à ").append("");

		ArrayList<String> bufferTableau = new ArrayList<String>();
		try {
			//connection a la bd
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			//execution de la requete
			ResultSet resultat = stmt.executeQuery("SELECT j.nomJoueur FROM joueur j");
			
			//processing the data:
			while(resultat.next()) {
				//recupere pour chaque ligne le nom de la competition
				bufferTableau.add(resultat.getString("nomJoueur"));
				
			}
			//fermer le connexion
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		// Affichage popup
		JOptionPane.showMessageDialog(null, message.toString());
		mainMenuGUI();
	}
	
	/**
	 * permet de choisir un tournoi
	 */
	private static void choixTournoiGUI() {
		// ----------debut logique recuperation des Tournois--------------
		int tailleTableau = 0;
		ArrayList<String> bufferTableau = new ArrayList<String>();
		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			ResultSet resultat = stmt.executeQuery("SELECT * FROM tournoi, competition WHERE tournoi.numeroCompetition = competition.numeroCompetition AND competition.nomCompetition = '"+ competitionChoisie + "'");
			
			//processing the data:
			while(resultat.next()) {
				tailleTableau += 1;
				bufferTableau.add(resultat.getString("numeroTournoi"));
				System.out.println(resultat.getString("numeroTournoi"));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String[] tournoisToChooseFrom = new String[bufferTableau.size()];
		for(int i=0;i<bufferTableau.size();i++) {
			tournoisToChooseFrom[i] = bufferTableau.get(i);
		}

		// -----------fin de bloc de recuperation des Tournois-------------
		String tournoi = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ",
				"Choix du Tournoi pour la competition " + competitionChoisie + "", JOptionPane.PLAIN_MESSAGE, null,
				tournoisToChooseFrom, tournoisToChooseFrom[0]);

		if (tournoi == null) {
			System.out.println("Quitting app...");
		} else {
			int resultatConfirmation = JOptionPane.showConfirmDialog(null,
					"Vous allez lancer une manche dans le cadre du tournoi: " + tournoi);
			if (resultatConfirmation == 0) {
				tournoiChoisi = tournoi;
				choixMancheGUI();
			} else if (resultatConfirmation == 1) {
				// ERREUR: retour au choix de la competition
				choixTournoiGUI();
			}
		}

	}
	
	/**
	 * permet de choisir une manche
	 */
	private static void choixMancheGUI() {
		// -----recuperation des infos des manches de la bd------
		ArrayList<String> bufferTableau = new ArrayList<String>();
		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			ResultSet resultat = stmt.executeQuery("SELECT * FROM tournoi, competition, manche WHERE tournoi.numeroCompetition = competition.numeroCompetition AND tournoi.numeroTournoi = manche.numeroTournoi AND competition.nomCompetition = '"+ competitionChoisie + "'"+" AND tournoi.numeroTournoi = '"+ tournoiChoisi +"'");
			
			//processing the data:
			while(resultat.next()) {
				if(resultat.getString("etatManche").equals("Cree")) {
					bufferTableau.add(resultat.getString("numeroManche"));					
				}
								
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String[] manchesToChoseFrom = new String[bufferTableau.size()];
		for(int i=0;i<bufferTableau.size();i++) {
			manchesToChoseFrom[i] = bufferTableau.get(i);
		}
		

		// ----fin de la recuperation des infos dans la bd--------

		String manche = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ",
				"Choix de la manche pour le tournoi: " + tournoiChoisi, JOptionPane.PLAIN_MESSAGE, null,
				manchesToChoseFrom, manchesToChoseFrom[0]);

		if (manche == null) {
			System.out.println("Quitting app...");
		} else {
			int confirmationManche = JOptionPane.showConfirmDialog(null,
					"Recapitulatif de vos choix: \n" + "Vous allez lancer une partie pour la manche: " + manche
							+ "\n Dans le cadre du tournoi : " + tournoiChoisi + "\n Dans le cadre de la competition: "
							+ competitionChoisie);

			if (confirmationManche == 0) {
				// Logique de la manche confirmee ici:
				mancheChoisie = manche; 
				lancerManche(Integer.parseInt(mancheChoisie));

			} else if (confirmationManche == 1) {
				// ERREUR: retour au choix de la manche
				choixMancheGUI();
			}
		}

	}
	
	/**
	 * cloture une manche et insere les statistiques
	 */
	private static void cloturerManche() {
		insererStatistiques();
		manche.setEtatManche(EtatManche.FINIE);
	}
	
	/**
	 * inserer les statistiques de la partie dans la bd
	 */
	//TODO tester
	private static void insererStatistiques() {

			try {
				Statement stmt;
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/si_risk";
				Connection con = DriverManager.getConnection(url, "root", "");
				stmt = con.createStatement();
				for(Joueur joueur: listeJoueurs) {
					int numeroJoueur = joueur.getNumeroJoueur(); 
					int nombreCartesTirees = joueur.getNombreCartesTirees();
					int nombreCartesEchangees= joueur.getNombreCartesEchangees();
					int nombreRegimentsRecuperes = joueur.getNombreRegimentsRecuperes();
					int nombreRegimentsElimines = joueur.getNombreRegimentsElimines();
					int nombreAttaques = joueur.getNombreAttaquesLancees();
					int nombreDeplacement = joueur.getNombreDeplacement();
					int nombreLancerDeDes = joueur.getNombreLancerDeDes();
					int classement = manche.recupererClassementJoueur(joueur);
					int score = manche.calculerScore(joueur);
					int nbrDesUn = joueur.getNombreDesUn();
					int nbrDefensesReussies = joueur.getNombreDefensesReussies();
					int nbrTerritoiresConquis = joueur.getNombreTerritoiresConquis();
					
					stmt.executeUpdate("INSERT INTO `participer`(`classement`, `score`, `nbrCartesTirees`, "
							+ "`nbrLancerDeDes`, `nbrCartesEchangees`, `nbrAttaqueLancees`, `nbrDeplacement`, `nbrRegimentsElimines`, "
							+ "`nbrRegimentsRecuperes`, `nbrDesUn`, `nbrDefensesReussies`, `nbrTerritoiresConquis`,`numeroJoueur`, `numeroManche`) "
							+ "VALUES ('"+classement+"','"+score+"','"+nombreCartesTirees+"','"+nombreLancerDeDes+
							"','"+nombreCartesEchangees+"','"+nombreAttaques+"',"
							+ "'"+nombreDeplacement+"','"+nombreRegimentsElimines+"','"+nombreRegimentsRecuperes+
							"','"+nbrDesUn+"','"+
							"','"+nbrDefensesReussies+"','"+
							"','"+nbrTerritoiresConquis+"','"+
							"','"+numeroJoueur+"','"+manche.getNumeroManche()+"')");

				}

		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	

	
/**
 * lance la manche en la creant, en recuperant les joueurs et en creant la vue
 * @param numeroManche
 */
	private static void lancerManche(int numeroManche) {

		// R�cup�ration des joueurs
		try {
			Statement stmt;
			// Connection avec la db 
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			
			ResultSet resultat = stmt.executeQuery("SELECT *"
					+ "FROM joueur, tournoi, competition, manche, inscrire"
					+ " WHERE manche.numeroTournoi = tournoi.numeroTournoi"
					+ " AND tournoi.numeroCompetition = competition.numeroCompetition"
					+ " AND joueur.numeroJoueur = inscrire.numeroJoueur"
					+ " AND inscrire.numeroManche = manche.numeroManche"
					+ " AND tournoi.numeroTournoi = " + tournoiChoisi 
					+ " AND competition.nomCompetition = '" + competitionChoisie  +"'"
					+ " AND manche.numeroManche = " + mancheChoisie);
			
			// processing the data:
			ArrayList<TypeCouleur> couleurJoueur = new ArrayList<>();
			couleurJoueur.add(TypeCouleur.BLANC);
			couleurJoueur.add(TypeCouleur.BLEU);
			couleurJoueur.add(TypeCouleur.VERT);
			couleurJoueur.add(TypeCouleur.ROUGE);
			couleurJoueur.add(TypeCouleur.JAUNE);
			
			while(resultat.next()) {
				String nomJoueur = resultat.getString("nomJoueur");
				String prenomJoueur = resultat.getString("prenomJoueur");
				int  numeroJoueur = Integer.valueOf(resultat.getString("numeroJoueur"));
				String dateNaissanceJoueur = resultat.getString("dateNaissanceJoueur");
				String etatJoueurString = resultat.getString("etatJoueur");
				EtatJoueur etatJoueurEnum = EtatJoueur.VALIDE;
				
				if(etatJoueurString.equals("Valide")) {
					etatJoueurEnum = EtatJoueur.VALIDE;
				} else {
					etatJoueurEnum = EtatJoueur.ELIMINE;
				}
				
				TypeCouleur typeCouleurJoueur = couleurJoueur.get(0);
				couleurJoueur.remove(0);
				
				Joueur joueur = new Joueur(nomJoueur, prenomJoueur, dateNaissanceJoueur,  etatJoueurEnum, numeroJoueur,  typeCouleurJoueur);		
				listeJoueurs.add(joueur);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// Fin recuperation des joueurs
		
		// on a initialise la vue
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Risk");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PlanispherePanel planispherePanel = new PlanispherePanel(listeJoueurs);
			planisphere = planispherePanel;
			frame.add(planispherePanel);
			frame.setSize(800, 600);
			frame.setVisible(true);
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//creer manche
				long miliseconds = System.currentTimeMillis();
			    Date date = new Date(miliseconds);
			    
				manche = new Manche(numeroManche,date, EtatManche.EN_COURS, planisphere);
				manche.setJoueursManche(listeJoueurs);
				planisphere.setJoueurEnCours(manche.determinerPremierJoueur());  
				manche.placerRegimentsInitiaux();
				manche.boucleJeu();
	}

}
