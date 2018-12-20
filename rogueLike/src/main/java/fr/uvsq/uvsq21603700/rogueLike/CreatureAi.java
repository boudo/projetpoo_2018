package fr.uvsq.uvsq21603700.rogueLike;

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
     * @param i un entier
     * @param j un entier
     * @param terrain le terrain
     */
	public void deplacer(int i, int j, Terrain[][] terrain) { }
	
	/**
	 * miseAjour
	 */
	public void miseAjour() { }
	
	/**
	 * ramasser
	 */
	public void ramasser() { }
	
	/**
	 * utiliser
	 * @param c un caratère
	 */
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
