 package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;

public class SpaceInvaders {

	    int longueur;
	    int hauteur;
	    Vaisseau vaisseau;

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	    }

		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}

		private boolean aUnVaisseau() {
			return vaisseau!=null;
		}

		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}
		
		public void deplacerVaisseauVersLaDroite() {
			if (vaisseau.abscisseLaPlusADroite() < (longueur - 1))
				vaisseau.seDeplacerVersLaDroite();
		}
		
		public void deplacerVaisseauVersLaGauche() {
			if (vaisseau.abscisseLaPlusAGauche() > (longueur - longueur + 1))
				vaisseau.seDeplacerVersLaGauche();
		}

	    @Override
		public String toString() {
			return recupererEspaceJeuDansChaineASCII();
		}

		public String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					char marque;
				    if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
					      marque='V';
				    else
					      marque='.';
				    
				    espaceDeJeu.append(marque);
				}
				espaceDeJeu.append('\n');
			}
			return espaceDeJeu.toString();
		}

		public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
			if (!estDansEspaceJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			if ( !estDansEspaceJeu(x+longueur-1,y))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
			if (!estDansEspaceJeu(x,y-hauteur+1))
				throw new DebordementEspaceJeuException("Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

			vaisseau = new Vaisseau(longueur, hauteur);
			vaisseau.positionner(x, y);
		}
	    
   }