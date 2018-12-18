package fr.uvsq.uvsq21603700.rogueLike;

import java.util.List;


public class JoueurAi extends CreatureAi{
	
	private List<String> _messages;

    public JoueurAi(Creature creature, List<String> messages) {
    super(creature);
    _messages = messages;
    }
    
    public void deplacer(int i, int j, Terrain[][] terrain)
    {
    	int x = _creature.x+i;
    	int y =_creature.y+j;
    	if(0 > x || x >= terrain.length || 0 > y ||  y >= terrain[0].length)
    	{
    		return;
    	}
    	
    	if(!attacker(x, y) && terrain[x][y].estSol())
    	{
    		//attacker(x, y);
    		_creature.x = x;
        	_creature.y = y;
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
			ennemi.setVie(ennemi.defenseValue() - (int)(Math.random() * _creature.attackValue()+1));
			ennemi.estMort();
			_creature.setVie(_creature.getVie() - 1);
			return true;
		}
		return false;
		
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
