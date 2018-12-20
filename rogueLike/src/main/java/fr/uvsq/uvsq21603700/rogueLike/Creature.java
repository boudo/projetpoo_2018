package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;
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
     * Constructeur
     * @param world le monde
     * @param glyph le symbole
     * @param nom le nom
     * @param couleur la color
     * @param maxVie la vie max
     * @param attack son attck
     * @param defense sa defense
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
     * @param i un entier
     * @param j un entier
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
	 * 
	 * @return le caractère
	 */
	public char getSymbole() { return _symbole; }
	
	/**
	 * 
	 * @return symbole
	 */
	public Color getColor() { return _couleur; }
	/**
	 * 
	 * @return couleur
	 */
    public String getName() { return _nom; }
    /**
     * 
     * @return vie max
     */
	public int getMaxVie() { return _maxVie; }
	/**
	 * 
	 * @return vie 
	 */
	public int getVie() { return _vie; }
	/**
	 * 
	 * @return CreatureAi de creature
	 */
	public CreatureAi getAi() { return _ai; }
	/**
	 * 
	 * @return Terrain[][] de terrain
	 */
	public Terrain[][] getTerWorld() {return _world.getTerrain();}
	/**
	 * 
	 * @return world le monde
	 */
	public World getWorld() { return _world; }
	/**
	 * 
	 * @return attack value
	 */
	public int getAttackValue() { return _attackValue; }
	public int getDefenseValue() { return _defenseValue; }
	public void setCreatureAi(CreatureAi ai) { _ai = ai; }
	public void setMaxVie(int maxvie) { _maxVie = maxvie; }
	public void setVie(int vie) { if(vie > _maxVie) {_vie = _maxVie;} else {_vie =  vie;} }
	public void setAttackValue(int attackvalue) { _attackValue = attackvalue; }
	public void setDefenseValue(int defensevalue) { _defenseValue = defensevalue; }

	/**
	 * permet à un creature de ramasser des objets dans le terrain
	 */
	public void ramasser() {
		_ai.ramasser();
		
	}
	/**
	 * permet d'enregistrer l'utilisation d'une arme ou puissance
	 * @param c un char
	 */
	public void utiliser(char c) {
		_ai.utiliser(c);
		
	}

	public String description() {
		return x+" "+y+" "+_symbole+" "+_nom+" "+_couleur.getRed()+
				" "+_couleur.getGreen()+" "+_couleur.getBlue()+" "+_maxVie+" "+_vie+" "+_attackValue+" "+_defenseValue;
	}





}
