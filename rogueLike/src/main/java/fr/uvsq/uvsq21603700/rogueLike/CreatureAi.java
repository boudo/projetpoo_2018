package fr.uvsq.uvsq21603700.rogueLike;

import java.util.*;
/**
 * 
 * la classe qui implémente les effets d'intelligence des créatures
 *
 */
public class CreatureAi {
	
	protected Creature _creature;

    public CreatureAi(Creature creature){
        _creature = creature;
        _creature.setCreatureAi(this);
    }
/**
 * déplacer la creature dans le terrain
 * @param i
 * @param j
 * @param terrain
 */
	public void deplacer(int i, int j, Terrain[][] terrain) { }

	public void miseAjour() { }

	public void ramasser1() { }

	public void utiliser(char c) { }
	
//	public void attacker(int x, int y) { }

//	public void mort(int _vie)
//	{
//		if(_vie < 0)
//		{
//			_creature.getWorld().mort(_creature);
//		}
//	}
    
    

}
