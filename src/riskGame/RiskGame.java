package riskGame;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 * Classe qui lance une partie.
 * Point d'entree du jeu.
 */
import riskGame.controler.AbstractControler;
//import riskGame.model.AbstractModel;
import riskGame.vue.PlanispherePanel;
import riskGame.vue.Vue;
import javax.swing.*;

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
		String[] optionsToChoose = {"Lancer une partie", "Autres options ?..."};
        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Que voulez vous faire ? ",
                "Risk e-sport [MENU]",
                JOptionPane.PLAIN_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[0]);
        if(choice == null)
        {
        	System.out.println("Quitting app...");
        } else if(choice == "Lancer une partie") {
        	choixCompetitionGUI(); 
        } 
	}

	private static void choixCompetitionGUI() {
		//----------debut logique recuperation des competitions--------------
		
		//-----------fin de bloc de recuperation des competition-------------
		String[] competitionToChoseFrom = {"Competition1", "Competition2..."};
		String competition = (String) JOptionPane.showInputDialog(
		        null,
		        "Que voulez vous faire ? ",
		        "Choix de la competition",
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        competitionToChoseFrom,
		        competitionToChoseFrom[0]);
		
		if(competition == null) {
			System.out.println("Quitting app...");
		} else {
			int resultatConfirmation = JOptionPane.showConfirmDialog(null, "Vous allez lancer une partie dans le cadre de la competition: "+ competition);
			if(resultatConfirmation == 0) {
				competitionChoisie = competition;
				choixTournoiGUI();			
			} else if(resultatConfirmation == 1) {
				//ERREUR: retour au choix de la competition
				choixCompetitionGUI();
			} 
		}
		
	}
	
	
	
	private static void choixTournoiGUI() {
		//----------debut logique recuperation des Tournois--------------
		
		//-----------fin de bloc de recuperation des Tournois-------------
		String[] tournoisToChooseFrom = {"Tournoi1", "Tournoi2..."};
		String tournoi = (String) JOptionPane.showInputDialog(
		        null,
		        "Que voulez vous faire ? ",
		        "Choix du Tournoi pour la competition " + competitionChoisie + "",
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        tournoisToChooseFrom,
		        tournoisToChooseFrom[0]);
		
		if(tournoi == null) {
			System.out.println("Quitting app...");
		} else {
			int resultatConfirmation = JOptionPane.showConfirmDialog(null, "Vous allez lancer une manche dans le cadre du tournoi: "+ tournoi);
			if(resultatConfirmation == 0) {
				tournoiChoisi = tournoi;
				choixMancheGUI();			
			} else if(resultatConfirmation == 1) {
				//ERREUR: retour au choix de la competition
				choixTournoiGUI();
			} 
		}
		
	}
	
	

	private static void choixMancheGUI() {
		//-----recuperation des infos des manches de la bd------
		
		//----fin de la recuperation des infos dans la bd--------
		
		String[] manchesToChoseFrom = {"Manche1", "Manche2..."};
		String manche = (String) JOptionPane.showInputDialog(
		        null,
		        "Que voulez vous faire ? ",
		        "Choix de la manche pour le tournoi: " + tournoiChoisi,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        manchesToChoseFrom,
		        manchesToChoseFrom[0]);
		
		if(manche == null) {
			System.out.println("Quitting app...");
		} else {
			int confirmationManche = JOptionPane.showConfirmDialog(null, "Recapitulatif de vos choix: \n"
					+ "Vous allez lancer une partie pour la manche: " + manche 
					+"\n Dans le cadre du tournoi : "+ tournoiChoisi 
					+"\n Dans le cadre de la competition: " + competitionChoisie);
			
			if(confirmationManche == 0) {
				//Logique de la manche confirmee ici:
				mancheChoisie = manche;
		        lancerManche();
		         			
			} else if(confirmationManche == 1) {
				//ERREUR: retour au choix de la manche
				choixMancheGUI();
			}
		}
		
	}

	private static void lancerManche() {
		
    SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Risk");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PlanispherePanel planispherePanel = new PlanispherePanel();
            frame.add(planispherePanel);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
 
}
