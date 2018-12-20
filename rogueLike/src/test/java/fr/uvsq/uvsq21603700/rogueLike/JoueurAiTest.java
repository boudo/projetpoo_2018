package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JoueurAiTest {
	
	@Test
	public void constructeurTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertNotNull(j);
	}
	
	@Test
	public void getMessageTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertNotNull(j.get_messages());
	}
	
	@Test
	public void getObjetTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertNotNull(j.get_objets());
	}
	
	@Test
	public void getPiocheTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertFalse(j.get_pioche() != ' ');
	}
	
	@Test
	public void getEpeTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertTrue(j.get_pioche() == ' ');
	}
	
	@Test
	public void getPommeTest() {
		Terrain[][] terrain = new Terrain[10][10];
		World w = new World(terrain);
		Creature c = new Creature(w, 'z', "zède", new  Color(124,25,65), 50, 10, 5);
		List<String> messages = new ArrayList<String>();
		List<Objet> objets = new ArrayList<Objet>();
		JoueurAi j = new JoueurAi(c, messages, objets);
		assertFalse(j.get_pomme() != ' ');
	}

}
