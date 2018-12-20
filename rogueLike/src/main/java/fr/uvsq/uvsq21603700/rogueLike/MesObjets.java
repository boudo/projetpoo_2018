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
		Objet pioche = new Objet(_world, '?', new Color(249, 66, 158), "PIOCHE");
        _world.emplacementObjet(pioche);
        return pioche;
	}
	
	public Objet newPomme()
	{
		Objet pomme = new Objet(_world, 'o', new Color(194, 247, 50), "POMME");
        _world.emplacementObjet(pomme);
        return pomme;
	}
	public Objet newEpe()
	{
		Objet epe = new Objet(_world, '!', new Color(247, 227, 95), "EPE");
        _world.emplacementObjet(epe);
        return epe;
	}

	public Objet newPorte() {
		Objet porte = new Objet(_world, 'P', new Color(43, 250, 250), "PORTE");
        _world.emplacementObjet(porte);
        return porte;
	}

}
