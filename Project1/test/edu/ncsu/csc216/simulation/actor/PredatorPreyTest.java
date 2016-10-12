package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PredatorPreyTest {

	
	@Test
	public void testPredatorPrey () {
		PurePredator p = new PurePredator('Y');
		
		assertEquals('Y', p.getSymbol());
		assertEquals(Color.ORANGE, p.getColor());
		assertEquals(10, p.getFoodChainRank());
	}
	
	@Test
	public void testAct() {
		
	}
	
	@Test
	public void testPastBreedTime() {
		
	}
	
	@Test
	public void testMakeBaby() {
		PredatorPrey p = new PredatorPrey('Y');
		Animal b = p.makeNewBaby();
		assertEquals(p.getSymbol(), b.getSymbol());
	}
}
