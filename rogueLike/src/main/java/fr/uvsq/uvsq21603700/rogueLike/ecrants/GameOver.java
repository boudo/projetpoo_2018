package fr.uvsq.uvsq21603700.rogueLike.ecrants;

import java.awt.Color;
import java.awt.event.KeyEvent;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;

public class GameOver implements Ecrant {

	public void afficher(AsciiPanel terminal) {
		terminal.writeCenter("GAME OVER", 20, new Color(247, 35, 12));
        terminal.writeCenter("-- press [enter] to Menu --", 22);
		
	}

	public Ecrant saisieUtilisateur(KeyEvent saisie) {
		return saisie.getKeyCode() == KeyEvent.VK_ENTER ? new Menu() : this;
	}
}
