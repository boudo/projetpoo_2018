package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;


public class Objet {
	
	
	public int x;
	public int y;
	
	private char _symbole;
	private Color _couleur;
	private String _nom;
	private World _world;
	
	
	public Objet(World world, char symbole, Color couleur, String nom)
	{
		_world = world;
		_symbole = symbole;
		_couleur = couleur;
		_nom = nom;
	}
	
	public char getSymbole()
	{
		return _symbole;
	}
	
	public Color getCouleur()
	{
		return _couleur;
	}
	
	public String getNom()
	{
		return _nom;
	}
	
	public World getWorld()
	{
		return _world;
	}

}
