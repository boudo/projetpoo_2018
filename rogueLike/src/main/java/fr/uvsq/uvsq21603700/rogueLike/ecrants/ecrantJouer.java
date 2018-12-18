package fr.uvsq.uvsq21603700.rogueLike.ecrants;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import fr.uvsq.uvsq21603700.rogueLike.*;
import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;



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
    			.construireTerrain()
    			.construire();
    	
    	MesCreatures creatures = new MesCreatures(_world);
    	creerCreature(creatures);
    }

	public void afficher(AsciiPanel terminal) {
		
		afficherTerrain(terminal);
		terminal.write(" "+_player.x +" / "+_player.y+" ",  _world.getLargeur()+2, 2, AsciiPanel.brightBlue, AsciiPanel.brightWhite);
        String stats = String.format(" %3d/%3d Vie", _player.getVie(), _player.getMaxVie());
        terminal.write(stats, _world.getLargeur()+2, 1,Color.red,Color.white);
        //displayMessages(terminal, messages);
        String save = "-- press U pour sauvegarger la partie --";
        String charger = "-- press N pour charger une nouvelle partie --";
        terminal.write(save, _largeur - save.length()-5, 28+ _hauteur/2);
        terminal.write(charger, _largeur - save.length()-10, 30+ _hauteur/2);
		
	}
	
	public void afficherTerrain(AsciiPanel terminal) {
		
		for(int i=0; i<_largeur-30; i++)
		{
			for(int j=0; j<_hauteur-10; j++)
			{
				terminal.write(_world.elemenTerrain(i, j).getSymbole(), i, j, new Color(255,255,255));
			}
		}
		for(Creature c : _world.getListCreature())
		{
			terminal.write(c.getSymbole(), c.x, c.y, c.getColor());
		}
		
		terminal.write("JOUER", 1, 1, new Color(0,0,255));
		
	}
	
	public void creerCreature(MesCreatures creatures)
	{
		_player = creatures.newJoueur(messages);
		
		int soldat = (int)(Math.random() * 30)+5;
		int dragon = (int)(Math.random() * 10)+3;
		
		for(int i=0; i<soldat; i++)
		{
			creatures.newSoldat();
		}
		for(int j=0; j<dragon; j++)
		{
			creatures.newDragon();
		}
	}

	public Ecrant saisieUtilisateur(KeyEvent saisie) {
		switch (saisie.getKeyCode()){
//      case KeyEvent.VK_ESCAPE: return new LoseScreen();
      case KeyEvent.VK_ENTER: return new ecrantJouer();
//      case KeyEvent.VK_U: save("moha.txt"); break;
//      case KeyEvent.VK_N: save("moha.txt"); return new MenuScreen();
      case KeyEvent.VK_LEFT:
      case KeyEvent.VK_Q: _player.deplacer(-1, 0); break;
      case KeyEvent.VK_RIGHT:
      case KeyEvent.VK_D: _player.deplacer( 1, 0); break;
      case KeyEvent.VK_UP:
      case KeyEvent.VK_Z: _player.deplacer( 0,-1); break;
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_S: _player.deplacer( 0, 1); break;
      case KeyEvent.VK_A: _player.deplacer(-1,-1); break;
      case KeyEvent.VK_E: _player.deplacer( 1,-1); break;
      case KeyEvent.VK_W: _player.deplacer(-1, 1); break;
      case KeyEvent.VK_X: _player.deplacer( 1, 1); break;
      
      default : return this;
      }
		_world.miseAjour();
		if(_player.getVie() <= 0)
		{
			return new Menu();
		}
		return this;
		
	}
	

}
