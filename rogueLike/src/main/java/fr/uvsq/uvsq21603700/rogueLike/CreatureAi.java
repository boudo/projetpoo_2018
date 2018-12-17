package fr.uvsq.uvsq21603700.rogueLike;

public class CreatureAi {
	
	protected Creature creature;

    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }
    
    

}
