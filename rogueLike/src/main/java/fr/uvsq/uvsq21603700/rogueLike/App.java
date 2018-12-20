package fr.uvsq.uvsq21603700.rogueLike;

import javax.swing.JFrame;

/**
 * classe principale 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	RogueLike app = new RogueLike();
		app.setTitle("Rogue-Like (* + *)");
	    app.setSize(4000, 1060);
	    app.setLocationRelativeTo(null); 
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
