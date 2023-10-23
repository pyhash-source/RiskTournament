/**
 * 
 */
package riskGame.model;

/**
 * @author: Zhuo
 */
public class Regiment {
	private String nomRegiment;
	private int valeur;
	
	public Regiment (String nomRegiment, int valeur) {
		this.nomRegiment = nomRegiment;
		this.valeur = valeur;
	}
	
	public String getNomRegiment() {
		return nomRegiment;
	}
	
	public int getValeurRegiment() {
		return valeur;
	}
}
