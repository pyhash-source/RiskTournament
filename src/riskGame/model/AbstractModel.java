/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riskGame.model;
/**
 * 
 */
import java.util.ArrayList;

import riskGame.vue.observer.Observable;
import riskGame.vue.observer.Observateur;

public abstract class AbstractModel implements Observable {
    private ArrayList<Observateur> observateurs;

    public AbstractModel() {
        observateurs = new ArrayList<>();
    }
    
    
    public abstract void faireSeDeplacerLesAnimaux();
    
    public abstract TypeTerritoire getTypeCase(int x, int y);
    public abstract void setTypeTerritoire(int x, int y,TypeTerritoire tc);

    public abstract boolean partieTerminer();

    @Override
    public void demandeMiseAjourVue(){
        for(Observateur o : observateurs){
            o.update();
        }
    }

    @Override
    public void removeObservateur(Observateur o){
        observateurs.remove(o);
    }

    @Override
    public void addObservateur(Observateur o){
        observateurs.add(o);
    }


	public int getHauteur() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getLargeur() {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
