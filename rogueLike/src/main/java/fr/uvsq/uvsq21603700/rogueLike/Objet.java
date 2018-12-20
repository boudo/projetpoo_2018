package fr.uvsq.uvsq21603700.rogueLike;

import java.awt.Color;


public class Objet {
	
	/**
	 * identifier la position d'un objet
	 */
	public int x;
	public int y;
	/**
	 * symbole ascii qui represente l'objet
	 */
	private char _symbole;
	/**
	 * Couleur de l'objet
	 */
	private Color _couleur;
	/**
	 * Nom d'objet
	 */
	private String _nom;
	/**
	 * l'univers dont appartient l'objet
	 */
	private World _world;
	/**
	 * Constructeur
	 * @param world
	 * @param symbole
	 * @param couleur
	 * @param nom
	 */
	public Objet(World world, char symbole, Color couleur, String nom)
	{
		_world = world;
		_symbole = symbole;
		_couleur = couleur;
		_nom = nom;
	}
	/**
	 * @return le symbole de l'objet
	 */
	public char getSymbole()
	{
		return _symbole;
	}
	/**
	 * 
	 * @return la couleur de l'objet
	 */
	public Color getCouleur()
	{
		return _couleur;
	}
	/**
	 * @return le nom de l'objet
	 */
	public String getNom()
	{
		return _nom;
	}
	/**
	 * @return l'univers de l'objet
	 */
	public World getWorld()
	{
		return _world;
	}

}
