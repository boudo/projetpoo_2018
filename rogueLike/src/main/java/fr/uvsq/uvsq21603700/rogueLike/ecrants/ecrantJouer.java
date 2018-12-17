package fr.uvsq.uvsq21603700.rogueLike.ecrants;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import fr.uvsq.uvsq21603700.rogueLike.*;
import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.AsciiPanel;



public class ecrantJouer implements Ecrant {
	private World _world;
	private Creature _player;
    private int _largeur;
    private int _hauteur;
    private List<String> messages;
    
    public ecrantJouer()
    {
    	_largeur = 206;
    	_hauteur = 64;
    	creerWorld();
    }
    
    public void creerWorld()
    {
    	_world = new WorldBuilder(_largeur-30, _hauteur-10)
    			.construire();
    }

	public void afficher(AsciiPanel terminal) {
		terminal.write("JOUER", 1, 1, new Color(0,0,255));
		for(int i=0; i<_largeur-30; i++)
		{
			for(int j=0; j<_hauteur-10; j++)
			{
				terminal.write(_world.elemenTerrain(i, j).getSymbole(), i, j, new Color(255,0,255));
			}
		}
		
	}

	public Ecrant saisieUtilisateur(KeyEvent saisie) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
