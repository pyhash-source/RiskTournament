package riskGame;

/**
 * Classe qui lance une partie.
 * Point d'entr�e du jeu.
 */
import riskGame.controler.AbstractControler;
import riskGame.model.AbstractModel;
import riskGame.model.PlanispherePanel;
import riskGame.vue.Vue;
import javax.swing.*;

public class RiskGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		/*
		 * AbstractModel model = null; //à instancier AbstractControler controler =
		 * null; //à instancier Vue v = new Vue(model,controler);
		 * model.addObservateur(v); v.setVisible(true); while(!model.partieTerminer()){
		 * controler.calculerStepSuivant(); }
		 */
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

