package fr.uvsq.uvsq21603700.rogueLike;


public class SoldaAi extends CreatureAi {
	
	 public SoldaAi(Creature creature)
	 {
		 super(creature);
	 }

	 public void miseAjour()
	 {
		 seDeplacer();
//		 mort(_creature.getVie());

	 }

	private void seDeplacer() {
		int mx = 0;
		int my = 0;
		int x = 0;
		int y = 0;
		boolean bool = true;
		Terrain[][] terrain = _creature.getTerWorld();
		while(bool)
		{
			mx = (int)(Math.random() * 3) -1;
			my = (int)(Math.random() * 3) -1;
			x = _creature.x+mx;
	    	y = _creature.y+my;
	    	System.out.println(x+" et "+y);
	    	if(0 > x || x >= terrain.length || 0 > y ||  y >= terrain[0].length)
	    	{
	    		bool = false;
	    	}
	    	else if(bool == true)
	    	{
	    		if(terrain[x][y] == Terrain.SOL)
	    		{
	    			bool = false;
	    			System.out.println(terrain[x][y].getSymbole());
	    		}
	    	}
		}
			
			deplacer(mx, my, _creature.getTerWorld());
	}
		
	public void deplacer(int i, int j, Terrain[][] terrain)
    {
    	int x = _creature.x+i;
    	int y =_creature.y+j;
    	if(0 > x || x >= terrain.length || 0 > y ||  y >= terrain[0].length)
    	{
    		return;
    	}
    	if(!attacker(x, y) &&terrain[x][y].estSol())
    	{
    		_creature.x = x;
        	_creature.y = y;
    	}
    }
	
	public boolean attacker(int x, int y)
	{
		Creature ennemi = null;
		ennemi = _creature.getWorld().creature(x, y);
		if(ennemi != null && ennemi.getSymbole() == '@')
		{
			ennemi.setVie(ennemi.defenseValue() - (int)(Math.random() * _creature.attackValue()+1));
			ennemi.estMort();
			return true;
		}
		else if(ennemi != null && ennemi.getSymbole() != '@')
		{
			return true;
		}
		return false;
		
	}

}
