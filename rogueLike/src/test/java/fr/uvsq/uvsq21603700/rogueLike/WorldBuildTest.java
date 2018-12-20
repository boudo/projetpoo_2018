package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldBuildTest {

	@Test
	public void constucteurTest() {
		WorldBuilder w = new WorldBuilder(54, 32);
		assertNotNull(w);
	}
	
	@Test
	public void construireTest() {
		WorldBuilder w = new WorldBuilder(54, 32);
		assertNotNull(w.construire());
	}
	
	@Test
	public void construireTerrainTest() {
		WorldBuilder w = new WorldBuilder(54, 32);
		Object o;
		o = w.construireTerrain();
		assertTrue(o instanceof WorldBuilder);
	}

}
