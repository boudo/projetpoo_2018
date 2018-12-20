package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoguLikeTest {

	  @Test
	  public void constructeurTest() {
	    RogueLike r = new RogueLike();
	    
	    assertNotNull(r);
	  }
	  
	  @Test
	  public void terminalTest() {
	    RogueLike r = new RogueLike();
	    
	    assertNotNull(r.getTerminal());
	  }
	  
	  @Test
	  public void ecrantTest() {
	    RogueLike r = new RogueLike();
	    
	    assertNotNull(r.getEcrant());
	  }

}
