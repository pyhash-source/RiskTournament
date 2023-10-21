/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskGame;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 * Classe qui lance une partie.
 * Point d'entree du jeu.
 */
import riskGame.controler.AbstractControler;
import riskGame.model.AbstractModel;
import riskGame.vue.Vue;

public class RiskGame {

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
				choixMancheGUI();			
			} else if(resultatConfirmation == 1) {
				//ERREUR: retour au choix de la competition
				choixCompetitionGUI();
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
		        "Choix de la manche:",
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        manchesToChoseFrom,
		        manchesToChoseFrom[0]);
		
		if(manche == null) {
			System.out.println("Quitting app...");
		} else {
			int confirmationManche = JOptionPane.showConfirmDialog(null, "Vous allez lancer une partie dans le cadre de la manche: "+ manche);
			
			if(confirmationManche == 0) {
				//Logique de la manche confirmee ici:
		        lancerManche();
		         			
			} else if(confirmationManche == 1) {
				//ERREUR: retour au choix de la manche
				choixMancheGUI();
			}
		}
		
	}

	private static void lancerManche() {
		AbstractModel model = null; //à instancier
		AbstractControler controler = null; //à instancier
		Vue v = new Vue(model,controler);
		model.addObservateur(v);
		v.setVisible(true);
		while(!model.partieTerminer()){
		    controler.calculerStepSuivant();
		}
	}
    	
    }
    

