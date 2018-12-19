package fr.uvsq.uvsq21603700.rogueLike.ecrants;

import java.awt.Color;
import java.awt.event.KeyEvent;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;

public class Menu implements Ecrant {
	
	private int _selection = 0;

	public void afficher(AsciiPanel terminal) {
		terminal.write("MENU", 1, 1, new Color(0,0,255));
		if(_selection == 0) {
			terminal.write("JOUER",100,20, new Color(0, 225, 0));

	    } else {
	    	terminal.write("JOUER",100,20, new Color(255,255,255));

	   }
	    if(_selection == 1) {
	    	terminal.write("CHARGER",100,22, new Color(0, 255, 0));

	    } else {
	    	terminal.write("CHARGER",100,22, new Color(255,255,255));

	    }
	    if(_selection == 2) {
	    	terminal.write("GERER PERSONNAGE",100,24, new Color(0, 255, 0));

	    } else {
	    	terminal.write("GERER PERSONNAGE",100,24, new Color(255,255,255));

	    }
	     terminal.writeCenter("-- press [enter] to start --",terminal.getHeightInCharacters()-1,new Color(255,0,0));
	}
	
	public Ecrant saisieUtilisateur(KeyEvent saisie)
	{
		switch(saisie.getKeyCode())
		{
		case KeyEvent.VK_DOWN:
			_selection = (_selection + 1 ) % 3; return this;
		case KeyEvent.VK_UP:
			if(_selection > 0)
			{
				_selection = (_selection - 1 ) % 3; return this;
			}
			return this;
		
		case KeyEvent.VK_ENTER:
			switch(_selection)
			{
			case 0:
				return new ecrantJouer();
			case 1:
				return this;
			case 2:
				return this;
			default :
				return this;
			}
		default :
			return this;
		}
		
	}
	
}
