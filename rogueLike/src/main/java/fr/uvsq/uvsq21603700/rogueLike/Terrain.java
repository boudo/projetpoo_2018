package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;

import fr.uvsq.uvsq21603700.rogueLike.asciiPanel.*;


public enum Terrain {
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
    
    public char getSymbole()
    {
    	return _symbole;
    }
    
    public Color getColor()
    {
    	return _couleur;
    }

	public boolean estSol()
	{
		return this == Terrain.SOL;
	}

	public boolean estMur() {
		return this == Terrain.MUR;
	}
}
