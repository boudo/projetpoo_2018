package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;
import java.util.*;
/**
 * Classe représentant un personnage
 */

public class Creature {
	/**
	 * le monde qui contient tous le personnage et le terrain
	 */
	private World _world;
	/**
	 * la position de la creature dans la fenetre
	 */
    public int x;
    public int y;
    /**
	 * le symbole ascii pour représenter l'univers de jeu
	 */
    private char _symbole;
    /**
	 * la couleur d'un element de la creature
	 */
    private Color _couleur;
    /**
	 * le nom de la creature
	 */
	private String _nom;
	/**
	 * creatureAi de la creature
	 */
    private CreatureAi _ai;
    
    private int _maxVie;
    /**
	 * les points de vie de la creature
	 */
    private int _vie;
    /**
     * les points d'attaque d'une creature
     */
    private int _attackValue; //valeur d'attaque
    /**
     * les points de defense d'une creature
     */
    private int _defenseValue; //valeur de défense
    /**
	 * le constructeur
	 */
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

    
    /**
     * la methode qui permet de déplacer une creature
     * @param i
     * @param j
     */
    public void deplacer(int i, int j) {
		_ai.deplacer(i,j, _world.getTerrain());
		
	}
    
    /**
     * mise a jour des puissances 
     */
	public void miseAjour() {
		
			_ai.miseAjour();
		
	}
	/**
	 * methode qui vérifie si la creature a autant de points pour vivre 
	 */
	public void estMort() 
	{
		if(_vie < 1)
		{
			_world.mort(this);
		}

	}
	/**
	 * les getters et les setters
	 */
	public char getSymbole() { return _symbole; }
	public Color getColor() { return _couleur; }
    public String getName() { return _nom; }
	public int getMaxVie() { return _maxVie; }
	public int getVie() { return _vie; }
	public CreatureAi getAi() { return _ai; }
	public Terrain[][] getTerWorld() {return _world.getTerrain();}
	public World getWorld() { return _world; }
	public int attackValue() { return _attackValue; }
	public int defenseValue() { return _defenseValue; }
	public void setCreatureAi(CreatureAi ai) { _ai = ai; }
	public void setMaxVie(int maxvie) { _maxVie = maxvie; }
	public void setVie(int vie) { _vie = vie; }
	public void setAttackValue(int attackvalue) { _attackValue = attackvalue; }
	public void setDefenseValue(int defensevalue) { _defenseValue = defensevalue; }
	/**
	 * permet à un creature de ramasser des objets dans le terrain
	 */
	public void ramasser1() {
		_ai.ramasser1();
		
	}
	/**
	 * permet d'enregistrer l'utilisation d'une arme ou puissance
	 */
	public void utiliser(char c) {
		_ai.utiliser(c);
		
	}



}
