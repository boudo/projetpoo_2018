package fr.uvsq.uvsq21603700.rogueLike.ecrants;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import fr.uvsq.uvsq21603700.rogueLike.*;
import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;

/**
 * classe qui définit la fenetre permettant de visualiser l'univers de jeu
 *
 */

public class ecrantJouer implements Ecrant {
	private World _world;
	private SavedGame _save;
	private Creature _player;
	private Objet _porte;
    private int _largeur;
    private int _hauteur;
    private List<String> _messages;
    private List<Objet> _objets;
    /**
     * Constructeur
     */
    public ecrantJouer()
    {
    	_largeur = 205;
    	_hauteur = 64;
    	_save = null;
    	_messages = new ArrayList<String>();
    	_objets = new ArrayList<Objet>();
    	creerWorld();
    }
    /**
     * creer les elements de jeu 
     */
    public void creerWorld()
    {
    	_world = new WorldBuilder(_largeur-30, _hauteur-10)
    			.construireTerrain()
    			.construire();
    	
    	MesCreatures creatures = new MesCreatures(_world);
    	creerCreature(creatures);
    	MesObjets objets = new MesObjets(_world);
    	creerObjet(objets);
    }

	public void afficher(AsciiPanel terminal) {
		
		afficherTerrain(terminal);
		afficherObjet(terminal);
		terminal.write(" "+_player.x +" / "+_player.y+"                ",  _world.getLargeur()+2, 2, AsciiPanel.brightBlue,
				AsciiPanel.brightWhite);
		terminal.write(" Valeur attack "+_player.getAttackValue() +" points",  _world.getLargeur()+2, 3, AsciiPanel.brightBlue,
				AsciiPanel.brightWhite);
		terminal.write(" Valeur defense "+_player.getDefenseValue() +" points",  _world.getLargeur()+2, 4, AsciiPanel.brightBlue,
				AsciiPanel.brightWhite);
        String stats = String.format(" %3d/%3d Vie            ", _player.getVie(), _player.getMaxVie());
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
				terminal.write(_world.elemenTerrain(i, j).getSymbole(), i, j, new Color(180,180,180));
			}
		}
		for(Creature c : _world.getListCreature())
		{
			terminal.write(c.getSymbole(), c.x, c.y, c.getColor());
		}
		for(Objet o : _world.getListObjet())
		{
			terminal.write(o.getSymbole(), o.x, o.y, o.getCouleur());
		}
		
		//terminal.write("JOUER", 1, 1, new Color(0,0,255));
		
	}
	/**
	 * creer un creature dans la fenetre
	 * @param creatures les creature
	 */
	public void creerCreature(MesCreatures creatures)
	{
		_player = creatures.newJoueur(_messages, _objets);
		
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
	
	private void creerObjet(MesObjets objets)
	{
		_porte = objets.newPorte();
		
		int pomme = (int)(Math.random() * 3)+5;
		int epe = (int)(Math.random() * 2)+3;
		int pioche = (int)(Math.random() * 3)+2;
		
		for(int i=0; i<pomme; i++)
		{
			objets.newPomme();
		}
		for(int j=0; j<epe; j++)
		{
			objets.newEpe();
		}
		for(int t=0; t<pioche; t++)
		{
			objets.newPioche();
		}
		
	}

	

	
	
	public void save_world() throws FileNotFoundException, UnsupportedEncodingException {
		_save = new SavedGame(_world);
	    _save.SaveGame("Saved_game1");
	}
	
	/**
	 * creer un objet sur le terrain de jeu
	 * @param terminal le terminal
	 */
	public void afficherObjet(AsciiPanel terminal)
	{
		String listObjet = "";
		Objet o;
		for(int i=0; i<_objets.size();i++)
		{
			o = _objets.get(i);
			listObjet = String.format("%c : %s",o.getSymbole(), o.getNom());
	        terminal.write(listObjet, _world.getLargeur()+2, i+6, AsciiPanel.brightRed, AsciiPanel.brightWhite);
		}
	}

	
	private boolean entrerPort(Creature player) {
		return player.x == _porte.x && player.y == _porte.y;
	}

	/**
	 * permet de produire des reactions apres les saisies utilisateur
	 */
	public Ecrant saisieUtilisateur(KeyEvent saisie) {
		switch (saisie.getKeyCode()){
//      case KeyEvent.VK_ESCAPE: return new LoseScreen();
      case KeyEvent.VK_ENTER: 
    	  if(entrerPort(_player))
    		  {
    		  	return new ecrantJouer();
    		  }
    	  break;
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
      case KeyEvent.VK_R: _player.ramasser(); break;

	  case KeyEvent.VK_M: try {
				save_world();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} return this;

      
//      default : return this;
      }
		switch(saisie.getKeyChar())
		{
		case '!': _player.utiliser('!'); break;
		case 'o': _player.utiliser('o'); break;
		case '?': _player.utiliser('?'); break;
		}
		_world.miseAjour();
		if(_player.getVie() <= 0)
		{
			return new GameOver();
		}
		return this;
		
	}

	

}
