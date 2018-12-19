package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;


public class MesObjets {
	
	private World _world;
	
	public MesObjets(World world)
	{
		_world = world;
	}
	
	public Objet newPioche()
	{
		Objet pioche = new Objet(_world, '?', new Color(128,0,128), "PIOCHE");
        _world.emplacementObjet(pioche);
        return pioche;
	}
	
	public Objet newPomme()
	{
		Objet pomme = new Objet(_world, 'o', new Color(0,128,128), "POMME");
        _world.emplacementObjet(pomme);
        return pomme;
	}
	public Objet newEpe()
	{
		Objet epe = new Objet(_world, '!', new Color(128,128,0), "EPE");
        _world.emplacementObjet(epe);
        return epe;
	}

}
