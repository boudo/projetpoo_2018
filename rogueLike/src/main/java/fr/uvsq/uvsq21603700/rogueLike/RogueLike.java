package fr.uvsq.uvsq21603700.rogueLike;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;
import fr.uvsq.uvsq21603700.rogueLike.ecrants.*;



public class RogueLike extends JFrame implements KeyListener {

	/**
	 * serialVersionUID = 1L
	 */
	private static final long serialVersionUID = 1L;
	
	private AsciiPanel _terminal;
	private Ecrant _ecrant;
	
	/**
	 * Constructeur
	 */
	public RogueLike() {
              
	    //Instanciation d'un objet JPanel
	    _terminal = new AsciiPanel();
        add(_terminal);
        pack();
        _ecrant = new Menu();
        addKeyListener(this);
        repaint();
    }
	/**
	 * dessiner à nouveau l'univers de jeu
	 */
    public void repaint(){
        _terminal.clear();
        _ecrant.afficher(_terminal);
        super.repaint();
    }
    /**
     * fait appel aux evenements liés à un clic touche sur le clavier
     */
    public void keyPressed(KeyEvent e) {
        _ecrant = _ecrant.saisieUtilisateur(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
}
