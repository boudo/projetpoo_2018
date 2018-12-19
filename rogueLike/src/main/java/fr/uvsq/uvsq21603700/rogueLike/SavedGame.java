package fr.uvsq.uvsq21603700.rogueLike;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class SavedGame {
	public World world;
	public int centerX;
	public int centerY;
	public int width;
	public int getWidth() { return width; }
	public int height;
	public int getHeight() { return height; }
	public SavedGame(World world, int centerX, int centerY, int width, int height) {
		this.world = world;
		this.centerX = centerX;
		this.centerY = centerY;
		this.width = width;
		this.height = height;
	}
		public SavedGame() {
			this.world = null;
			this.centerX = 0;
			this.centerY = 0;
			this.width = 0;
			this.height = 0;
		}
	

}
