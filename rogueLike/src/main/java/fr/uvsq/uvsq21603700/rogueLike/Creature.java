package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;


public class Creature {
	
	private World world;

    public int x;
    public int y;

    private char _symbole;
    private Color _couleur;
	private String _nom;
    
    private CreatureAi _ai;
    
    private int maxVie;
    private int vie;
    private int attackValue; //valeur d'attaque
    private int defenseValue; //valeur de défense
    
    public Creature(World world, char glyph, String nom, Color couleur, int maxVie, int attack, int defense){
        this.world = world;
        this._symbole = glyph;
        this._couleur = couleur;
        this._nom = nom;
        this.maxVie = maxVie;
        this.vie = maxVie;
        this.attackValue = attack;
        this.defenseValue = defense;
    }
    
	
	public char symbole() { return _symbole; }
	public Color color() { return _couleur; }
    public String name() { return _nom; }
	public int getMaxVie() { return maxVie; }
	public int getVie() { return vie; }
	public int attackValue() { return attackValue; }
	public int defenseValue() { return defenseValue; }
	public void setCreatureAi(CreatureAi ai) { _ai = ai; }
	public void setMaxVie(int maxvie) { maxVie = maxvie; }
	public void setVie(int vie) { maxVie = vie; }
	public void setAttackValue(int attackvalue) { attackValue = attackvalue; }
	public void setDefenseValue(int defensevalue) { defenseValue = defensevalue; }

}
