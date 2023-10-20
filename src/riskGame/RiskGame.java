/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskGame;

/**
 * Classe qui lance une partie
 */
import riskGame.controler.AbstractControler;
import riskGame.model.AbstractModel;
import riskGame.vue.Vue;

public class RiskGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
