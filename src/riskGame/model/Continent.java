package riskGame.model;

import java.util.ArrayList;
/**
 * @author: Yasmine
 */

public class Continent {
	//attributs
	private String nomContinent;
	private ArrayList territoires = new ArrayList();
	private int valeur;

	//constructeur
	public Continent(String nomContinent, ArrayList territoires, int valeur) {
		this.nomContinent = nomContinent;
		this.territoires = territoires;
		this.valeur = valeur;
	}
	public int getValeur() {
		return valeur;
	}
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	//getters and setters 
	public String getNomContinent() {
		return nomContinent;
	}
	public void setNomContinent(String nomContinent) {
		this.nomContinent = nomContinent;
	}
	public ArrayList getTerritoires() {
		return territoires;
	}
	public void setTerritoires(ArrayList territoires) {
		this.territoires = territoires;
	}
	
	
	

}
