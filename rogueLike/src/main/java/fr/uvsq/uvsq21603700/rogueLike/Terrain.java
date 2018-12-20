package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;
/** 
 *Enumeration qui implémente les differents elements d'un terrain
 */

public enum Terrain {
	/**
	 * les éléments du terrain
	 */
	SOL('.', AsciiPanel.brightBlack),
    MUR('#', AsciiPanel.brightMagenta),
    VIDE('|', AsciiPanel.black);//white);
    
    private char _symbole;
    private Color _couleur;
    
    Terrain(char symbole, Color couleur)
    {
    	_symbole = symbole;
    	_couleur = couleur;
    }
    /**
     * @return le symbole du terrain
     */
    public char getSymbole()
    {
    	return _symbole;
    }
    /**
     * @return le couleur du terrain
     */
    public Color getColor()
    {
    	return _couleur;
    }
    /**
     * @return 1 si la position dans terrain est sol et 0 sinon
     */
	public boolean estSol()
	{
		return this == Terrain.SOL;
	}
	/**
     * @return 1 si la position dans terrain est sol et 0 sinon
     */
	public boolean estMur() {
		return this == Terrain.MUR;
	}
}
