package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class creatureTest {

	@Test
	public void constructeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertNotNull(c);
	}
	
	@Test
	public void getSymboleTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertTrue(c.getSymbole() == 'z');
	}
	
	@Test
	public void getNomTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertTrue(c.getName() == "zède");
	}
	
	@Test
	public void getColorTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Color col = new  Color(124,25,65);
		Creature c = new Creature(w, 'z', "zède", col, 50, 10, 5);
		assertTrue(c.getColor() == col);
	}
	
	@Test
	public void getVieMaxTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertTrue(c.getMaxVie() == 50);
	}
	
	@Test
	public void getAttackTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertTrue(c.getAttackValue() == 10);
	}
	
	@Test
	public void getDefenseTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		assertTrue(c.getDefenseValue() == 5);
	}

}
