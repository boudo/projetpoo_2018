package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import org.junit.Test;

public class TerrainTest {

	@Test
	public void SolTest() {
		
		assertNotNull(Terrain.SOL);
	}
	
	@Test
	public void getSolTest() {
		
		assertTrue(Terrain.SOL.getSymbole() == '.');
	}
	
	@Test
	public void MurTest() {
		
		assertNotNull(Terrain.MUR);
	}
	
	@Test
	public void getMurTest() {
		
		assertTrue(Terrain.MUR.getSymbole() == '#');
	}
	
	@Test
	public void VideTest() {
		
		assertNotNull(Terrain.VIDE);
	}
	
	@Test
	public void getVideTest() {
		
		assertTrue(Terrain.VIDE.getSymbole() == '|');
	}

}
