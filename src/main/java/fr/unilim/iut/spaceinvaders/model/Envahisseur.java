package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Sprite {
	
	private boolean seDeplaceVersLaDroite;

	public Envahisseur(Dimension dimensionEnvahisseur, Position positionOriginelleEnvahisseur, int vitesseEnvahisseur) {
		super(dimensionEnvahisseur, positionOriginelleEnvahisseur, vitesseEnvahisseur);
	}
	
	public boolean seDeplaceVersLaDroite() {
		return this.seDeplaceVersLaDroite;
	}
	
	public void veutSeDeplacerVersLaDroite(boolean souhait) {
		this.seDeplaceVersLaDroite = souhait;
	}
	
}
