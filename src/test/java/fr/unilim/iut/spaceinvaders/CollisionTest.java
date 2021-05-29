package fr.unilim.iut.spaceinvaders;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.model.Collision;

public class CollisionTest {
	
	private SpaceInvaders spaceinvaders;
	private Collision collision;

	@Before
	public void initialisation() {
		spaceinvaders = new SpaceInvaders(15, 10);
		collision = new Collision();
	}
	
	@Test
	public void test_collisionNonDetectee() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(2, 2), new Position(7, 1), 1);
		assertEquals(false, collision.detecterCollision(spaceinvaders.recupererEnvahisseur(), spaceinvaders.recupererVaisseau()));
	}

	@Test
	public void test_collisionDetectee() {
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(5,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(2, 2), new Position(7, 8), 1);
		assertEquals(true, collision.detecterCollision(spaceinvaders.recupererEnvahisseur(), spaceinvaders.recupererVaisseau()));
	}
	
}
