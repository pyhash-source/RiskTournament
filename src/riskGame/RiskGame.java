package riskGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//import riskGame.model.AbstractModel;
import riskGame.vue.PlanispherePanel;

public class RiskGame {
	static String tournoiChoisi = "";
	static String competitionChoisie = "";
	static String mancheChoisie = "";

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		mainMenuGUI();

	}

	private static void mainMenuGUI() {
		String[] optionsToChoose = { "Lancer une partie", "Autres options ?..." };
		String choice = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ", "Risk e-sport [MENU]",
				JOptionPane.PLAIN_MESSAGE, null, optionsToChoose, optionsToChoose[0]);
		if (choice == null) {
			System.out.println("Quitting app...");
		} else if (choice == "Lancer une partie") {
			choixCompetitionGUI();
		}
	}

	private static void choixCompetitionGUI() {
		// ----------debut logique recuperation des competitions--------------
		ArrayList<String> bufferTableau = new ArrayList<String>();
		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/si_risk";
			Connection con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			ResultSet resultat = stmt.executeQuery("SELECT c.nomCompetition FROM competition c");
			
			//processing the data:
			while(resultat.next()) {
				bufferTableau.add(resultat.getString("nomCompetition"));
				System.out.println(resultat.getString("nomCompetition"));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String[] competitionToChoseFrom = new String[bufferTableau.size()];
		for(int i=0;i<bufferTableau.size();i++) {
			competitionToChoseFrom[i] = bufferTableau.get(i);
		}

		// -----------fin de bloc de recuperation des competition-------------
		String competition = (String) JOptionPane.showInputDialog(null, "Que voulez vous faire ? ",
				"Choix de la competition", JOptionPane.PLAIN_MESSAGE, null, competitionToChoseFrom,
				competitionToChoseFrom[0]);

		if (competition == null) {
			System.out.println("Quitting app...");
		} else {
			int resultatConfirmation = JOptionPane.showConfirmDialog(null,
					"Vous allez lancer une partie dans le cadre de la competition: " + competition);
			if (resultatConfirmation == 0) {
				competitionChoisie = competition;
				choixTournoiGUI();
			} else if (resultatConfirmation == 1) {
				// ERREUR: retour au choix de la competition
				choixCompetitionGUI();
			}
		}

	}

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
				bufferTableau.add(resultat.getString("numeroManche"));
				System.out.println(resultat.getString("numeroManche"));
				
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
				lancerManche();

			} else if (confirmationManche == 1) {
				// ERREUR: retour au choix de la manche
				choixMancheGUI();
			}
		}

	}

	private static void lancerManche() {

		// on a initialise la vue
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Risk");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			PlanispherePanel planispherePanel = new PlanispherePanel();
			frame.add(planispherePanel);
			frame.setSize(800, 600);
			frame.setVisible(true);
		});

		// Initialisation des objets
	}

}
