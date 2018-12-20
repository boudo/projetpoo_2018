package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;
/**
 * classe qui implémente tous les objets qui sert à faire un combat 
 *
 */

public class MesObjets {
	
	private World _world;
	/**
	 * Constructeur
	 * @param world
	 */
	public MesObjets(World world)
	{
		_world = world;
	}
	/**
	 * @return Objet de type Pioche
	 */
	public Objet newPioche()
	{
		Objet pioche = new Objet(_world, '?', new Color(128,0,128), "PIOCHE");
        _world.emplacementObjet(pioche);
        return pioche;
	}
	/**
	 * @return Objet de type Pomme qui sert à ajouter des points de vie pour le joueur
	 */
	public Objet newPomme()
	{
		Objet pomme = new Objet(_world, 'o', new Color(0,128,128), "POMME");
        _world.emplacementObjet(pomme);
        return pomme;
	}
	/**
	 * @return Objet de type epe qui sert comme arme
	 */
	public Objet newEpe()
	{
		Objet epe = new Objet(_world, '!', new Color(128,128,0), "EPE");
        _world.emplacementObjet(epe);
        return epe;
	}

}
