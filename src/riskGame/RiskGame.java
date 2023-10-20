/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskGame;

import javax.swing.JOptionPane;

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
        /*
        AbstractModel model = null; //à instancier
        AbstractControler controler = null; //à instancier
        Vue v = new Vue(model,controler);
        model.addObservateur(v);
        v.setVisible(true);
        while(!model.partieTerminer()){
            controler.calculerStepSuivant();
        }
         */
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
        	choice ="noAction";//permet au bouton cancel de fonctionnner
        } else if(choice == "Lancer une partie") {
        	//LOGIQUE DE LANCEMENT DE PARTIE ICI
        	System.out.println("Coucou");
        }
	}
    	
    }
    

