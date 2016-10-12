package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PurePredatorTest {

	
	@Test
	public void testPurePredator () {
		PurePredator p = new PurePredator('X');
		
		assertEquals('X', p.getSymbol());
		assertEquals(Color.RED, p.getColor());
		assertEquals(20, p.getFoodChainRank());
	}
	
	@Test
	public void testAct() {
		
	}
	
	@Test
	public void testPastBreedTime() {
		
	}
	
	@Test
	public void testMakeBaby() {
		PurePredator p = new PurePredator('X');
		Animal b = p.makeNewBaby();
		assertEquals(p.getSymbol(), b.getSymbol());
	}
}
