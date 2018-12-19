package fr.uvsq.uvsq21603700.rogueLike;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.awt.Color;

public class AppTest {
	Terrain[][] t = new Terrain[800][600] ;
	  World w1 = new World(t);
	  Creature c1 =new Creature(w1,'f',"adversaire",Color.BLUE,60,20,50);
	  Creature c2 =new Creature(w1,'y',"adversaire",Color.YELLOW,40,30,50);
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
	 assertEquals(110,c1.x);
	 assertEquals(70,c1.y);
  }
  /*
  @Test
  public void test1{
		  Terrain[][] t ;
	  World w1 = new World(t);
  Creature c=new Creature(w1,'f',"adversaire",Color.BLUE,60,20,50);
} */
}
