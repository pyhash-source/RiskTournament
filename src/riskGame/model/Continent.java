package riskGame.model;

import java.util.ArrayList;
/**
 * @author: Yasmine
 */

public class Continent {
	//attributs
	private String nomContinent;
	private ArrayList territoires = new ArrayList();
	//constructeur
	public Continent(String nomContinent, ArrayList territoires) {
		super();
		this.nomContinent = nomContinent;
		this.territoires = territoires;
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
