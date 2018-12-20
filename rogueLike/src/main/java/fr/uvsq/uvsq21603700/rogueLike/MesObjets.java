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
	 * @param world le monde
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
		Objet pioche = new Objet(_world, '?', new Color(249, 66, 158), "PIOCHE");
        _world.emplacementObjet(pioche);
        return pioche;
	}
	/**
	 * @return Objet de type Pomme qui sert à ajouter des points de vie pour le joueur
	 */
	public Objet newPomme()
	{
		Objet pomme = new Objet(_world, 'o', new Color(194, 247, 50), "POMME");
        _world.emplacementObjet(pomme);
        return pomme;
	}
	/**
	 * @return Objet de type epe qui sert comme arme
	 */
	public Objet newEpe()
	{
		Objet epe = new Objet(_world, '!', new Color(247, 227, 95), "EPE");
        _world.emplacementObjet(epe);
        return epe;
	}
	
	/**
	 * 
	 * @return un objet
	 */
	public Objet newPorte() {
		Objet porte = new Objet(_world, 'P', new Color(43, 250, 250), "PORTE");
        _world.emplacementObjet(porte);
        return porte;
	}

}
