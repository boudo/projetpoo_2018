package fr.uvsq.uvsq21603700.rogueLike;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.uvsq.uvsq21603700.rogueLike.ecrants.*;

public class EcrantTest {

	@Test
	public void test() {
		Ecrant e = new ecrantJouer();
		assertNotNull(e);
	}

}
