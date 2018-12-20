package fr.uvsq.uvsq21603700.rogueLike;

import java.util.*;


public class JoueurAi extends CreatureAi{
	
	private List<String> _messages;
	protected List<Objet> _objets;
	private char _pioche;
	private char _pomme;
	private char _epe;

    public JoueurAi(Creature creature, List<String> messages, List<Objet> objets) {
    super(creature);
    _messages = messages;
    _objets = objets;
    _pioche = ' ';
	_pomme = ' ';
	_epe = ' ';
    }
    
    public void deplacer(int i, int j, Terrain[][] terrain)
    {
    	int x = _creature.x+i;
    	int y =_creature.y+j;
    	if(0 > x || x >= terrain.length || 0 > y ||  y >= terrain[0].length)
    	{
    		return;
    	}
    	
    	if(terrain[x][y].estMur())
    	{
    		creuser(x,y, terrain);
    	}
    	
    	if(!attacker(x, y) && terrain[x][y].estSol())
    	{
    		//attacker(x, y);
    		_creature.x = x;
        	_creature.y = y;
    	}
    	
    	
    }
    

//
//	private boolean estObjet(int x, int y) {
//		World world = _creature.getWorld();
//		Objet objet = world.getObjet(x, y);
//		if(objet != null)
//		{
//			return true;
//		}
//		return false;
//	}

	private void creuser(int x, int y, Terrain[][] terrain)
	{
		terrain[x][y] = Terrain.SOL;
		if(_pioche != '?')
		{
			_creature.setVie(_creature.getVie()-1);
		}
		
	}

	/**
     * Activer inteligence AI
     * @param x
     * @param y
     * @return vrai ou faux
     */
	public boolean attacker(int x, int y)
	{
		Creature ennemi = null;
		ennemi = _creature.getWorld().creature(x, y);
		if(ennemi != null)
		{
			ennemi.setVie(ennemi.getDefenseValue() - (int)(Math.random() * _creature.getAttackValue()+1));
			ennemi.estMort();
			_creature.setVie(_creature.getVie() - 1);
			return true;
		}
		return false;
		
	}
	
	public void ramasser()
	{
		Objet o = null;
		o = _creature.getWorld().getObjet(_creature.x , _creature.y);
		if( o != null)
		{
			_objets.add(o);
    		_creature.getWorld().ramasser(o);
		}
	}
	
	public void utiliser(char c)
	{
		if(estDansleSac(c))
		{
			_creature.getWorld().utiliser(c);
			supprimerObjet(c);
			if(c == '?') { _pioche = '?';}
			else if(c == '!') { _epe = '!'; _creature.setAttackValue(_creature.getAttackValue()+25);
											_creature.setDefenseValue(_creature.getDefenseValue()+10);}
			else if(c == 'o') { _pomme = 'o'; _creature.setVie(_creature.getVie()+25);}
		}
	}
	
	public void supprimerObjet(char c)
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
	
	public boolean estDansleSac(char c)
	{
		for(Objet o : _objets)
		{
			if(o.getSymbole() == c)
			{
				_objets.remove(o);
				return true;
			}
		}
		return false;
	}
	
	
	public List<String> get_messages() {
		return _messages;
	}

	public void set_messages(List<String> _messages) {
		this._messages = _messages;
	}

	public List<Objet> get_objets() {
		return _objets;
	}

	public void set_objets(List<Objet> _objets) {
		this._objets = _objets;
	}

	public char get_pioche() {
		return _pioche;
	}

	public void set_pioche(char _pioche) {
		this._pioche = _pioche;
	}

	public char get_pomme() {
		return _pomme;
	}

	public void set_pomme(char _pomme) {
		this._pomme = _pomme;
	}

	public char get_epe() {
		return _epe;
	}

	public void set_epe(char _epe) {
		this._epe = _epe;
	}

	
	
//    
//    /**
//     * Message
//     * @param message
//     */
//    public void onNotify(String message){
//        messages.add(message);
//    }

}
