package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite spriteToucheur, Sprite spriteTouche) {
        return this.detecterContactSprite(spriteToucheur, spriteTouche);
    }
	
	private boolean detecterContactSprite(Sprite spriteToucheur, Sprite spriteTouche) {
        return (this.contactVertical(spriteToucheur, spriteTouche) && this.contactHorizontal(spriteToucheur, spriteTouche));
    }

    private boolean contactVertical(Sprite spriteToucheur, Sprite spriteTouche) {
        return this.contactBas(spriteToucheur, spriteTouche) || this.contactHaut(spriteToucheur, spriteTouche);
    }

    private boolean contactHorizontal(Sprite spriteToucheur, Sprite spriteTouche) {
        return this.contactGauche(spriteToucheur, spriteTouche) || this.contactDroit(spriteToucheur, spriteTouche);
    }

    private boolean contactDroit(Sprite spriteToucheur, Sprite spriteTouche) {
        return spriteToucheur.abscisseLaPlusADroite() >= spriteTouche.abscisseLaPlusAGauche() && spriteTouche.abscisseLaPlusADroite() >= spriteToucheur.abscisseLaPlusAGauche();
    }

    private boolean contactGauche(Sprite spriteToucheur, Sprite spriteTouche) {
        return spriteToucheur.abscisseLaPlusAGauche() <= spriteTouche.abscisseLaPlusADroite() && spriteTouche.abscisseLaPlusAGauche() <= spriteToucheur.abscisseLaPlusADroite();
    }

    private boolean contactBas(Sprite spriteToucheur, Sprite spriteTouche) {
        return spriteToucheur.ordonneeLaPlusHaute() >= spriteTouche.ordonneeLaPlusBasse() && spriteTouche.ordonneeLaPlusHaute() >= spriteToucheur.ordonneeLaPlusBasse();
    }

    private boolean contactHaut(Sprite spriteToucheur, Sprite spriteTouche) {
        return spriteToucheur.ordonneeLaPlusBasse() <= spriteTouche.ordonneeLaPlusHaute() && spriteTouche.ordonneeLaPlusBasse() <= spriteToucheur.ordonneeLaPlusHaute();
    }
	
}
