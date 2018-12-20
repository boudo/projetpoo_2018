package fr.uvsq.uvsq21603700.rogueLike.ecrants;


import java.awt.event.KeyEvent;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;
/**
 * 
 * L'interface qui permet d'interagir entre l'utilisateur et l'univers de jeu
 *
 */
public interface Ecrant {
	
	public void afficher(AsciiPanel terminal);
	public Ecrant saisieUtilisateur(KeyEvent saisie);
}
