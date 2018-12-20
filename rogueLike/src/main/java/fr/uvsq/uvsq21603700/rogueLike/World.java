package fr.uvsq.uvsq21603700.rogueLike;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe représentant l'univers de jeu
 * 
 *
 */
public class World {
	
	private Terrain[][] _terrain;
    private int _largeur;
    private int _hauteur;
    private List<Creature> _creatures;
    private List<Objet> _objets;
    /** 
     * Constructeur
     * @param terrain le Terrain[][]
     */
    public World(Terrain[][] terrain){
		_terrain = terrain;
		_largeur = terrain.length;
		_hauteur = terrain[0].length;
		_creatures = new ArrayList<Creature>();
		_objets = new ArrayList<Objet>();
	}
    /**
     * 
     * @param x abscice
     * @param y ordonnee
     * @return l'element de terrain à la position (x,y)
     */
    public Terrain elemenTerrain(int x, int y){
		if (x < 0 || x >= _largeur || y < 0 || y >= _hauteur)
			return Terrain.VIDE;
		else
			return _terrain[x][y];
	}
    /**
     * Ajouter une creature dans un emplacement vide et aleatoire du terrain
     * @param creature la creature
     */
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
	/**
	 * @param x abscise
	 * @param y ordonne
	 * @return la creature situé à (x,y) sinon null
	 */
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
	/**
	 * Enleve la creature du terrain le cas ou elle mort
	 * @param creature le creature
	 */
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
	/**
	 * 
	 * @return liste de tous les creatures dans le terrain
	 */
	public List<Creature> getListCreature()
	{
		return _creatures;
	}
	/**
	 * 
	 * @return liste de tous les objets dans le terrain
	 */
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
	/**
	 * permet d'ajouter un objet dans le terrain
	 * @param pioche  la pioche
	 */
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
	/**
	 * 
	 * @return largeur du terrain
	 */
	public int getLargeur()
	{
		return _largeur;
	}
	/**
	 * 
	 * @return la hauteur du terrain
	 */
	public int getHauteur()
	{
		return _hauteur;
	}
	/**
	 * 
	 * @param x abscise
	 * @param y ordonne
	 * @return un objet situe a (x,y) si y en a pas il renvoie null
	 */
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
	/**
	 * supprimer un objet utilisé
	 * @param c symbole d'un objet
	 */
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
