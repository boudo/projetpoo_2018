package fr.uvsq.uvsq21603700.rogueLike;

import java.util.*;


public class JoueurAi extends CreatureAi{
	
	private List<String> _messages;
	protected List<Objet> _objets;

    public JoueurAi(Creature creature, List<String> messages, List<Objet> objets) {
    super(creature);
    _messages = messages;
    _objets = objets;
    }
    
    public void deplacer(int i, int j, Terrain[][] terrain)
    {
    	int x = _creature.x+i;
    	int y =_creature.y+j;
    	if(0 > x || x >= terrain.length || 0 > y ||  y >= terrain[0].length)
    	{
    		return;
    	}
    	
//    	if(estObjet(x, y))
//    	{
//    		ramasser(x,y);
//    	}
    	
    	if(!attacker(x, y) && terrain[x][y].estSol())
    	{
    		//attacker(x, y);
    		_creature.x = x;
        	_creature.y = y;
    	}
    	
    	
    }
    
//    private void ramasser(int x, int y) {
//    	Objet o = _creature.getWorld().getObjet(x, y);
//    	if(o != null)
//    	{
//    		_objets.add(o);
//    		_creature.getWorld().ramasser(o);
//    	}
//		
//	}
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

	/**
     * Activer inteligence AI
     * @param x
     * @param y
     * @return vrai si le joueur a reaussi d'attaquer un adversaire et faux sinon
     */
	public boolean attacker(int x, int y)
	{
		Creature ennemi = null;
		ennemi = _creature.getWorld().creature(x, y);
		if(ennemi != null)
		{
			ennemi.setVie(ennemi.defenseValue() - (int)(Math.random() * _creature.attackValue()+1));
			ennemi.estMort();
			_creature.setVie(_creature.getVie() - 1);
			return true;
		}
		return false;
		
	}
	/**
	 * permet à un creature de ramasser des objets dans le terrain
	 */
	public void ramasser1()
	{
		Objet o = null;
		o = _creature.getWorld().getObjet(_creature.x , _creature.y);
		if( o != null)
		{
			_objets.add(o);
    		_creature.getWorld().ramasser(o);
		}
	}
	/**
	 * permet d'enregistrer l'utilisation d'une arme ou puissance
	 */
	public void utiliser(char c)
	{
		_creature.getWorld().utiliser(c);
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
