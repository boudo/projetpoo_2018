package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class ObjetTest {

	@Test
	public void constructeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Color couleur = new Color(41, 4, 6);
		Objet o = new Objet(w, '!', couleur, "nom");
		assertNotNull(o);
	}
	
	@Test
	public void getWorldTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Color couleur = new Color(41, 4, 6);
		Objet o = new Objet(w, '!', couleur, "nom");
		assertTrue(o.getWorld() != null);
	}
	
	@Test
	public void getSymboleTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Color couleur = new Color(41, 4, 6);
		Objet o = new Objet(w, '!', couleur, "nom");
		assertTrue(o.getSymbole() == '!');
	}
	
	@Test
	public void getColeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Color couleur = new Color(41, 4, 6);
		Objet o = new Objet(w, '!', couleur, "nom");
		assertTrue(o.getCouleur() == couleur);
	}

}
