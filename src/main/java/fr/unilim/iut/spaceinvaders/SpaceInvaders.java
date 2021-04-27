 package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;

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

		public void positionnerUnNouveauVaisseau(int x, int y) {
			
			if (  !estDansEspaceJeu(x, y) )
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");
		
			vaisseau = new Vaisseau(x, y); 

		}

		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}

	    @Override
		public String toString() {
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
	    
   }