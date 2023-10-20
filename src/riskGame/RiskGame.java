/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskGame;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe qui lance une partie.
 * Point d'entr�e du jeu.
 */
import riskGame.controler.AbstractControler;
import riskGame.model.AbstractModel;
import riskGame.vue.Vue;

public class RiskGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//Cet endroit est le point d'entree du programme, on va commencer par faire un Menu pour le lancer de partie    	
    	String[] optionsToChoose = {"Lancer une partie", "Autres options ?..."};
        String niveauChoisi = (String) JOptionPane.showInputDialog(
                null,
                "Que voulez vous faire ? ",
                "Risk e-sport [MENU]",
                JOptionPane.PLAIN_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[0]);
        if(niveauChoisi == null)
        {
        	niveauChoisi ="noAction";//permet au bouton cancel de fonctionnner
        	//le bouton cancel affecte null et casse le switch. donc on le rename en une valeur valide
        } else if(niveauChoisi == "Lancer une partie") {
        	//LOGIQUE DE LANCEMENT DE PARTIE ICI
        	System.out.println("Coucou");
        }
    }
    	
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
    

