package riskGame.model;
/**
 * @author: Yasmine
 */
public class Carte {
	
	//attributs
	private Territoire territoire;
	private TypeRegiment typeRegiment;
	//constructeur
	public Carte(Territoire territoire, TypeRegiment typeRegiment) {
		super();
		this.territoire = territoire;
		this.typeRegiment = typeRegiment;
	}
	public Territoire getTerritoire() {
		return territoire;
	}
	public void setTerritoire(Territoire territoire) {
		this.territoire = territoire;
	}
	public TypeRegiment getTypeRegiment() {
		return typeRegiment;
	}
	public void setTypeRegiment(TypeRegiment typeRegiment) {
		this.typeRegiment = typeRegiment;
	}
	
	

}
