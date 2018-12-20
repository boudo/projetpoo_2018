package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldTest {

	@Test
	public void constructeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		assertNotNull(w);
	}
	
	@Test
	public void getTerrainTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		assertTrue(w.getTerrain() == terrain);
	}
	
	@Test
	public void getLargeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		assertTrue(w.getLargeur() == 10);
	}
	
	@Test
	public void getHauteurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		assertTrue(w.getHauteur() == 10);
	}

}
