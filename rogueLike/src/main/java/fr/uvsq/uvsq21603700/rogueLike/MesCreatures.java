package fr.uvsq.uvsq21603700.rogueLike;

import java.util.ArrayList;
import java.util.List;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;
/**
 * Classe représentant un personnage joueur
 *
 */

public class MesCreatures {
	
	private World world;

    public MesCreatures(World world){
        this.world = world;
    }
    
    public Creature newJoueur(List<String> messages, List<Objet> objets){
        Creature player = new Creature(world, '@',"Player", AsciiPanel.brightGreen,100, 20, 5);
        world.emplacementVide(player);
        new JoueurAi(player, messages, objets);
        return player;
    }
    
	public Creature newDragon(){
		Creature dragon = new Creature(world, 'f',"Fungus", AsciiPanel.brightRed, 10, 0, 0);
		world.emplacementVide(dragon);
		new DragonAi(dragon, this);
		return dragon;
	}
	
	public Creature newSoldat(){
	    Creature soldat = new Creature(world, 'b', "bat", AsciiPanel.brightYellow, 15, 5, 0);
	    world.emplacementVide(soldat);
	    new SoldaAi(soldat);
	    return soldat;
	}

}
