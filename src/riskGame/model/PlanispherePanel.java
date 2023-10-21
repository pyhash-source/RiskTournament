package riskGame.model;

import javax.imageio.ImageIO;
import javax.swing.*;

import riskGame.vue.RessourcesImages;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public class PlanispherePanel extends JPanel implements MouseListener {
	private BufferedImage planisphereImage;
	private BufferedImage planisphereColour;
	private ArrayList<Territoire> territoires;

	public PlanispherePanel() {
		// chargement de l'image qui represente le plateau
		Image carteImage = RessourcesImages.CARTE;
		this.planisphereImage = toBufferedImage(carteImage);
		
		//carte identique mais coloree
		Image carteColoreeImage = RessourcesImages.CARTECOULEUR;
		this.planisphereColour = toBufferedImage(carteColoreeImage);

		// ajout du listener pour capter les cliques de la souris
		addMouseListener(this);

		//ajout des territoires
		territoires = new ArrayList<>();
		
		Territoire alaska = new Territoire("Alaska", "#CC7D3B");
		territoires.add(alaska);
		
		Territoire argentine = new Territoire("Argentine", "#027C67");
		territoires.add(argentine);
		
		Territoire peru = new Territoire("Peru", "#3AA287");
		territoires.add(peru);
		
		Territoire brazil = new Territoire("Brazil", "#009778");
		territoires.add(brazil);
		
		Territoire venezuela = new Territoire("Venezuela", "#82BAAD");
		territoires.add(venezuela);
		
		Territoire central = new Territoire("Central America", "#6D3E38");
		territoires.add(central);
		
		Territoire westusa = new Territoire("Western USA", "#A04D3D");
		territoires.add(westusa);
		
		Territoire eastusa = new Territoire("Eastern USA", "#7D4137");
		territoires.add(eastusa);
		
		Territoire quebec = new Territoire("Quebec", "#A0543D");
		territoires.add(quebec);
		
		Territoire ontario = new Territoire("Ontario", "#7A3D38");
		territoires.add(ontario);
		
		Territoire alberta = new Territoire("Alberta", "#AF6A43");
		territoires.add(alberta);
		
		Territoire northwestterritory = new Territoire("Northwest Territory", "#D2842F");
		territoires.add(northwestterritory);
		
		Territoire groenland = new Territoire("Groenland", "#FFC90D");
		territoires.add(groenland);
		
		Territoire iceland = new Territoire("Iceland", "#5BACC9");
		territoires.add(iceland);
		
		Territoire scandinavia = new Territoire("Scandinavia ", "#018DB0");
		territoires.add(scandinavia );
		
		Territoire ukraine = new Territoire("Ukraine", "#1081AB");
		territoires.add(ukraine);
		
		Territoire greatbritain = new Territoire("Great Britain", "#206D9B");
		territoires.add(greatbritain);
		
		Territoire westerneurope = new Territoire("Western Europe", "#1F709F");
		territoires.add(westerneurope);
		
		Territoire southerneurope = new Territoire("Southern Europe", "#0187AA");
		territoires.add(southerneurope);
		
		Territoire northerneurope = new Territoire("Northern Europe", "#1B6C99");
		territoires.add(northerneurope);
		
		
		
		
		Territoire northAfrica = new Territoire("North Africa", "#C03D35");
		territoires.add(northAfrica);
	
		
	}

	//transforme une image en bufferedImage
	private BufferedImage toBufferedImage(Image image) {
		//regarde si cest deja une instance de bufferedImage
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		//si cela ne l est pas transformation en bufferedImage
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = bufferedImage.createGraphics();
		bGr.drawImage(image, 0, 0, null);
		bGr.dispose();

		return bufferedImage;
	}

	// fonction permettant de dessiner l'image
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.planisphereImage != null) {
			g.drawImage(this.planisphereImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// fonction qui permet de savoir ou on a clique
	//note pour plus tard: faudrait deux maps: une pour recup la couleur et 
	//une pour mettre les pions et dire a quel joueur et la map
	//en gros on cliquerait sur la deuxieme mais ca irait recup le pixel de lautre
	//ca permet de pouvoir mettre des pions par ex sur la carte
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//recuperation des coordonne
		int x = e.getX();
		int y = e.getY();

		int componentWidth = getWidth();
		int componentHeight = getHeight();
		int imageWidth = this.planisphereImage.getWidth();
		int imageHeight = this.planisphereImage.getHeight();


		int realX = x * imageWidth / componentWidth;
		int realY = y * imageHeight / componentHeight;


		//recupere la couleur de la ou on a clique
		Color clickedColor = new Color(this.planisphereColour.getRGB(realX, realY));

		//transforme la couleur en hexcode
		int red = clickedColor.getRed();
		int green = clickedColor.getGreen();
		int blue = clickedColor.getBlue();
		String rvbHexCode = String.format("#%02X%02X%02X", red, green, blue);
		
		//print le nom du territoire ou il y a le clique
		for (Territoire t : territoires) {
			if (isTerritoireColor(rvbHexCode, t)) {
				System.out.println(t.getNom());
			}
		}
	}

	private boolean isTerritoireColor(String couleur, Territoire t) {
		if(couleur.equals(t.getCouleur())){
			return true;
		}
		return false;
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
