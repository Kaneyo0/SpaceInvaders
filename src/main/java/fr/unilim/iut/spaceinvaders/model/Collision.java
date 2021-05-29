package fr.unilim.iut.spaceinvaders.model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
        return this.detecterContactSprite(sprite1, sprite2);
    }
	
	private boolean detecterContactSprite(Sprite sprite1, Sprite sprite2) {
        return (this.contactVertical(sprite1, sprite2) && this.contactHorizontal(sprite1, sprite2));
    }

    private boolean contactVertical(Sprite sprite1, Sprite sprite2) {
        return this.contactBas(sprite1, sprite2) || this.contactHaut(sprite1, sprite2);
    }

    private boolean contactHorizontal(Sprite sprite1, Sprite sprite2) {
        return this.contactGauche(sprite1, sprite2) || this.contactDroit(sprite1, sprite2);
    }

    private boolean contactDroit(Sprite sprite1, Sprite sprite2) {
        return sprite1.abscisseLaPlusADroite() >= sprite2.abscisseLaPlusAGauche() && sprite2.abscisseLaPlusADroite() >= sprite1.abscisseLaPlusAGauche();
    }

    private boolean contactGauche(Sprite sprite1, Sprite sprite2) {
        return sprite1.abscisseLaPlusAGauche() <= sprite2.abscisseLaPlusADroite() && sprite2.abscisseLaPlusAGauche() <= sprite1.abscisseLaPlusADroite();
    }

    private boolean contactBas(Sprite sprite1, Sprite sprite2) {
        return sprite1.ordonneeLaPlusHaute() >= sprite2.ordonneeLaPlusBasse() && sprite2.ordonneeLaPlusHaute() >= sprite1.ordonneeLaPlusBasse();
    }

    private boolean contactHaut(Sprite sprite1, Sprite sprite2) {
        return sprite1.ordonneeLaPlusBasse() <= sprite2.ordonneeLaPlusHaute() && sprite2.ordonneeLaPlusBasse() <= sprite1.ordonneeLaPlusHaute();
    }
	
}
