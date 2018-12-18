package fr.uvsq.uvsq21603700.rogueLike;

import java.util.ArrayList;
import java.util.List;


public class World {
	
	private Terrain[][] _terrain;
    private int _largeur;
    private int _hauteur;
    private List<Creature> _creatures;
    
    public World(Terrain[][] terrain){
		_terrain = terrain;
		_largeur = terrain.length;
		_hauteur = terrain[0].length;
		_creatures = new ArrayList<Creature>();
	}
    
    public Terrain elemenTerrain(int x, int y){
		if (x < 0 || x >= _largeur || y < 0 || y >= _hauteur)
			return Terrain.VIDE;
		else
			return _terrain[x][y];
	}

	public void emplacementVide(Creature creature) {
		int x;
		int y;
		
		do {
			x = (int)(Math.random() * _largeur);
			y = (int)(Math.random() * _hauteur);
		} 
		while (!elemenTerrain(x,y).estSol() || creature(x,y) != null);
		
		creature.x = x;
		creature.y = y;
		_creatures.add(creature);
		
	}

	public Creature creature(int x, int y) {
		for(Creature c : _creatures)
		{
			if(c.x == x && c.y == y)
			{
				return c;
			}
		}
		return null;
	}
	
	public void mort(Creature creature)
	{
//		for(Creature c : _creatures)
//		{
//			if(c == creature)
//			{
				_creatures.remove(creature);
//			}
//		}
	}
	
	public List<Creature> getListCreature()
	{
		return _creatures;
	}

	public void miseAjour()
	{	
		for(Creature c : _creatures)
		{

			c.miseAjour();
			
		}
	}

	public Terrain[][] getTerrain() {
		return _terrain;
	}
	public int getLargeur()
	{
		return _largeur;
	}
	
	public int getHauteur()
	{
		return _hauteur;
	}

	

}
