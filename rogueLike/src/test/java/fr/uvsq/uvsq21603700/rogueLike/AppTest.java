package fr.uvsq.uvsq21603700.rogueLike;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.Color;

public class AppTest {
	private Terrain[][] t ;
	private  World w1;
	private  Creature c1 ;
	private  Creature c2 ;
	  @Before
		public void creationObjets(){
		  	t = new Terrain[800][600] ;
		  	w1 = new World(t);
			c1 = new Creature(w1,'f',"adversaire",Color.BLUE,60,20,50);
			c2 = new Creature(w1,'y',"adversaire",Color.YELLOW,40,30,50);
		}
  @Test
  public void testApp() {
    assertTrue(true);
	  assertNotNull(c1);
	  
  }
  @Test
  public void testMaxVie() {
	  assertEquals(60,c1.getMaxVie());
  }
  @Test
  public void testDeplacement() {
	  c1.x=10;c1.y=20;
	 c1.deplacer(100, 50);
	 assertEquals(100,c1.x);
	 assertEquals(50,c1.y);
  }
  @Test
  public void testColor() {
	 
	 assertSame(Color.YELLOW,c2.getColor());
  }
}
