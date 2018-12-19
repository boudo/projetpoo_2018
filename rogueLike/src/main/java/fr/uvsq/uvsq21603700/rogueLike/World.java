package fr.uvsq.uvsq21603700.rogueLike;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe représentant un personnage joueur
 * @author 
 *
 */
public class World {
	
	private Terrain[][] _terrain;
    private int _largeur;
    private int _hauteur;
    private List<Creature> _creatures;
    private List<Objet> _objets;
    
    public World(Terrain[][] terrain){
		_terrain = terrain;
		_largeur = terrain.length;
		_hauteur = terrain[0].length;
		_creatures = new ArrayList<Creature>();
		_objets = new ArrayList<Objet>();
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
	
	public List<Objet> getListObjet()
	{
		return _objets;
	}

	public void miseAjour()
	{	
		for(Creature c : _creatures)
		{

			c.miseAjour();
			
		}
	}
	
	public void emplacementObjet(Objet pioche) {
		int x;
		int y;
		
		do {
			x = (int)(Math.random() * _largeur);
			y = (int)(Math.random() * _hauteur);
		} 
		while (!elemenTerrain(x,y).estSol() || creature(x,y) != null);
		
		pioche.x = x;
		pioche.y = y;
		_objets.add(pioche);
		
	}
	
	public void ramasser(Objet o)
	{
		_objets.remove(o);
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

	public Objet getObjet(int x, int y) {
		for(Objet o : _objets)
		{
			if(o.x == x && o.y == y)
			{
				return o;
			}
		}
		return null;
	}

	public void utiliser(char c)
	{
		for(Objet o : _objets)
		{
			if(o.getSymbole() == c)
			{
				_objets.remove(o);
				break;
			}
		}
	}

	

}
