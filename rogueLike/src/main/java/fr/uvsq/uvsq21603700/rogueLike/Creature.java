package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;
import java.util.*;


public class Creature {
	
	private World _world;

    public int x;
    public int y;

    private char _symbole;
    private Color _couleur;
	private String _nom;
    
    private CreatureAi _ai;
    
    private int _maxVie;
    private int _vie;
    private int _attackValue; //valeur d'attaque
    private int _defenseValue; //valeur de défense
    
    public Creature(World world, char glyph, String nom, Color couleur, int maxVie, int attack, int defense){
        _world = world;
        _symbole = glyph;
        _couleur = couleur;
        _nom = nom;
        _maxVie = maxVie;
        _vie = maxVie;
        _attackValue = attack;
        _defenseValue = defense;
    }
    
    public void deplacer(int i, int j) {
		_ai.deplacer(i,j, _world.getTerrain());
		
	}
    
	public void miseAjour() {
		
			_ai.miseAjour();
		
	}
    
	
	public void estMort() 
	{
		if(_vie < 0)
		{
			_world.mort(this);
		}

	}

	public char getSymbole() { return _symbole; }
	public Color getColor() { return _couleur; }
    public String getName() { return _nom; }
	public int getMaxVie() { return _maxVie; }
	public int getVie() { return _vie; }
	public Terrain[][] getTerWorld() {return _world.getTerrain();}
	public World getWorld() { return _world; }
	public int attackValue() { return _attackValue; }
	public int defenseValue() { return _defenseValue; }
	public void setCreatureAi(CreatureAi ai) { _ai = ai; }
	public void setMaxVie(int maxvie) { _maxVie = maxvie; }
	public void setVie(int vie) { _vie = vie; }
	public void setAttackValue(int attackvalue) { _attackValue = attackvalue; }
	public void setDefenseValue(int defensevalue) { _defenseValue = defensevalue; }



}
