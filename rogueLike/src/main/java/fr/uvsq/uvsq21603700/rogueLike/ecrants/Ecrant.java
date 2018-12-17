package fr.uvsq.uvsq21603700.rogueLike.ecrants;


import java.awt.event.KeyEvent;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;

public interface Ecrant {
	
	public void afficher(AsciiPanel terminal);
	public Ecrant saisieUtilisateur(KeyEvent saisie);
}
