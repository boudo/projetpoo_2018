package fr.uvsq.uvsq21603700.rogueLike;

import java.util.ArrayList;
import java.util.List;


public class World {
	
	private Terrain[][] _terrain;
    private int _largeur;
    private int _hauteur;
    private List<Creature> creatures;
    
    public World(Terrain[][] terrain){
		this._terrain = terrain;
		this._largeur = terrain.length;
		this._hauteur = terrain[0].length;
		this.creatures = new ArrayList<Creature>();
	}
    
    public Terrain elemenTerrain(int x, int y){
		if (x < 0 || x >= _largeur || y < 0 || y >= _hauteur)
			return Terrain.VIDE;
		else
			return _terrain[x][y];
	}
}
