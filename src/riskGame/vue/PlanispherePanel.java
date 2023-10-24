package riskGame.vue;

/**
 * @author elisa as SVRS
 */

import javax.swing.*;

import riskGame.model.EtatJoueur;
import riskGame.model.Joueur;
import riskGame.model.Territoire;
import riskGame.model.TypeCouleur;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class PlanispherePanel extends JPanel implements MouseListener {
	// image affichée
	private BufferedImage planisphereImage;
	// image coloree
	private BufferedImage planisphereColour;
	// liste de tous les territoires
	private ArrayList<Territoire> territoires;

	public PlanispherePanel() {
		// chargement de l'image qui represente le plateau
		Image carteImage = RessourcesImages.CARTE;
		this.planisphereImage = toBufferedImage(carteImage);
		Joueur joueur1 = new Joueur("Messi", "Leo", "24/06/1984", EtatJoueur.VALIDE, 1, TypeCouleur.BLANC);

		// carte identique mais coloree
		Image carteColoreeImage = RessourcesImages.CARTECOULEUR;
		this.planisphereColour = toBufferedImage(carteColoreeImage);

		// ajout du listener pour capter les cliques de la souris
		addMouseListener(this);

		// ajout des territoires
		territoires = new ArrayList<>();

		Territoire alaska = new Territoire("Alaska", "#CC7D3B", 95, 160);
		territoires.add(alaska);

		Territoire argentine = new Territoire("Argentine", "#027C67", 400, 1465);
		argentine.setProprietaire(joueur1);
		territoires.add(argentine);

		Territoire peru = new Territoire("Peru", "#3AA287", 456, 1299);
		territoires.add(peru);

		Territoire brazil = new Territoire("Brazil", "#009778", 618, 1271);
		territoires.add(brazil);

		Territoire venezuela = new Territoire("Venezuela", "#82BAAD", 362, 1021);
		territoires.add(venezuela);

		Territoire central = new Territoire("Central America", "#6D3E38", 265, 750);
		territoires.add(central);

		Territoire westusa = new Territoire("Western USA", "#A04D3D", 248, 630);
		territoires.add(westusa);

		Territoire eastusa = new Territoire("Eastern USA", "#7D4137", 518, 607);
		territoires.add(eastusa);

		Territoire quebec = new Territoire("Quebec", "#A0543D", 704, 462);
		territoires.add(quebec);

		Territoire ontario = new Territoire("Ontario", "#7A3D38", 511, 329);
		territoires.add(ontario);

		Territoire alberta = new Territoire("Alberta", "#AF6A43", 288, 334);
		territoires.add(alberta);

		Territoire northwestterritory = new Territoire("Northwest Territory", "#D2842F", 286, 102);
		territoires.add(northwestterritory);

		Territoire groenland = new Territoire("Groenland", "#FFC90D", 1014, 81);
		territoires.add(groenland);

		Territoire iceland = new Territoire("Iceland", "#5BACC9", 1159, 181);
		territoires.add(iceland);

		Territoire scandinavia = new Territoire("Scandinavia ", "#018DB0", 1272, 409);
		territoires.add(scandinavia);

		Territoire ukraine = new Territoire("Ukraine", "#1081AB", 1471, 464);
		territoires.add(ukraine);

		Territoire greatbritain = new Territoire("Great Britain", "#206D9B", 1151, 580);
		territoires.add(greatbritain);

		Territoire westerneurope = new Territoire("Western Europe", "#1F709F", 1159, 722);
		territoires.add(westerneurope);

		Territoire southerneurope = new Territoire("Southern Europe", "#0187AA", 1345, 692);
		territoires.add(southerneurope);

		Territoire northerneurope = new Territoire("Northern Europe", "#1B6C99", 1241, 607);
		territoires.add(northerneurope);

		
		Territoire northafrica = new Territoire("North Africa", "#BB382E", 1128, 1024);
		territoires.add(northafrica);

		Territoire eastafrica = new Territoire("East Africa", "#C0766B", 1463, 1200);
		territoires.add(eastafrica);

		Territoire egypt = new Territoire("Egypt", "#BE2833", 1297, 962);
		territoires.add(egypt);

		
		Territoire madagascar = new Territoire("Madasgacar", "#9B4745", 1535, 1417);
		territoires.add(madagascar);

		Territoire congo = new Territoire("Congo", "#A52A2F", 1327, 1213);
		territoires.add(congo);

		Territoire southafrica = new Territoire("South Africa", "#963C3C", 1344, 1448);
		territoires.add(southafrica);

		Territoire indonesia = new Territoire("Indonesia", "#39447A", 2239, 964);
		territoires.add(indonesia);

		Territoire newguinea = new Territoire("New Guinea", "#283E70", 2394, 993);
		territoires.add(newguinea);

		Territoire easternaustralia = new Territoire("Eastern Australia", "#2F3B6F", 2410, 1170);
		territoires.add(easternaustralia);

		Territoire westernaustralia = new Territoire("Western Australia", "#485285", 2213, 1243);
		territoires.add(westernaustralia);

		Territoire ural = new Territoire("Ural", "#5F6F31", 1764, 309);
		territoires.add(ural);

		Territoire siberia = new Territoire("Siberia", "#485623", 1949, 312);
		territoires.add(siberia);

		Territoire yakutsk = new Territoire("Yakutsk", "#1D6236", 2246, 74);
		territoires.add(yakutsk);

		Territoire kamchatka = new Territoire("Kamchatka", "#0B4A2B", 2251, 421);
		territoires.add(kamchatka);

		Territoire irkutsk = new Territoire("Irkutsk", "#327D3C", 2107, 234);
		territoires.add(irkutsk);

		Territoire japan = new Territoire("Japan", "#10482F", 2321, 530);
		territoires.add(japan);

		Territoire mongolia = new Territoire("Mongolia", "#277E3A", 2152, 510);
		territoires.add(mongolia);

		Territoire india = new Territoire("India", "#5C6D36", 1807, 845);
		territoires.add(india);

		Territoire middleeast = new Territoire("Middle East", "#799D39", 1555, 902);
		territoires.add(middleeast);

		Territoire afghanistan = new Territoire("Afghanistan", "#8D9D45", 1654, 651);
		territoires.add(afghanistan);

		Territoire siam = new Territoire("Siam", "#266246", 2045, 843);
		territoires.add(siam);

		Territoire china = new Territoire("China", "#266B3C", 2058, 638);
		territoires.add(china);
	}

	// transforme une image en bufferedImage
	private BufferedImage toBufferedImage(Image image) {
		// regarde si cest deja une instance de bufferedImage
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// si cela ne l est pas transformation en bufferedImage
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

		// largeur de la fenetre
		int componentWidth = getWidth();

		// hauteur de la fenetre
		int componentHeight = getHeight();

		// largeur de l image
		int imageWidth = this.planisphereImage.getWidth();
		// hauteur de l image
		int imageHeight = this.planisphereImage.getHeight();

		// ajout des pions
		for (Territoire t : territoires) {
			// conversion des coordonnees de l image aux
			// coordonnees de la fenetre
			int realX = t.getCoordonneeX() * componentWidth / imageWidth;
			int realY = t.getCoordonneeY() * componentHeight / imageHeight;
//			if(t.getProprietaire()!=null) {
//				
//				if(t.getProprietaire().getCouleurJoueur()==TypeCouleur.BLANC) {
//					System.out.println(TypeCouleur.BLANC);
					g.drawImage(RessourcesImages.BLANC, realX, realY, 25, 25, this);
//				}
//			}
			
			

			
		}
	}

	// fonction qui permet de savoir ou on a clique
	@Override
	public void mouseClicked(MouseEvent e) {

		// x de la ou on clique
		int x = e.getX();
		// y de la ou on clique
		int y = e.getY();

		// largeur de la fenetre
		int componentWidth = getWidth();

		// hauteur de la fenetre
		int componentHeight = getHeight();

		// largeur de l image
		int imageWidth = this.planisphereImage.getWidth();
		// hauteur de l image
		int imageHeight = this.planisphereImage.getHeight();

		// conversion des coordonnees de la ou on a clique sur la fenetre aux
		// coordonnees de l image
		int realX = x * imageWidth / componentWidth;
		int realY = y * imageHeight / componentHeight;

		System.out.println(realX + "," + realY);
		// recupere la couleur de la ou on a clique
		Color clickedColor = new Color(this.planisphereColour.getRGB(realX, realY));

		// transforme la couleur en hexcode
		int red = clickedColor.getRed();
		int green = clickedColor.getGreen();
		int blue = clickedColor.getBlue();
		String rvbHexCode = String.format("#%02X%02X%02X", red, green, blue);

		// print le nom du territoire ou il y a le clique
		for (Territoire t : territoires) {
			if (isTerritoireColor(rvbHexCode, t)) {
				System.out.println(t.getNomTerritoire());
			}
		}
	}

	// regarde si la couleur correspond a la couleur du territoire
	private boolean isTerritoireColor(String couleur, Territoire t) {
		if (couleur.equals(t.getCouleur())) {
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
