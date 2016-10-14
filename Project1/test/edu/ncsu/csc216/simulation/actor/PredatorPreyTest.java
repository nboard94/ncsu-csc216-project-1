package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PredatorPreyTest {

	
	@Test
	public void testPredatorPrey () {
		PredatorPrey p = new PredatorPrey('Y');
		Configs.setToDefaults();
		
		assertEquals('Y', p.getSymbol());
		assertEquals(Color.ORANGE, p.getColor());
		assertEquals(10, p.getFoodChainRank());
	}
	
	@Test
	public void testAct() {
		
	}
	
	@Test
	public void testPastBreedTime() {
		PredatorPrey p = new PredatorPrey('y');
		Configs.setToDefaults();
		
		assertFalse(p.pastBreedTime(6));
		assertFalse(p.pastBreedTime(7));
		assertTrue(p.pastBreedTime(8));
	}
	
	@Test
	public void testMakeBaby() {
		PredatorPrey parent = new PredatorPrey('y');
		Animal baby = parent.makeNewBaby();
		
		assertEquals(parent.getSymbol(), baby.getSymbol());
		assertEquals(parent.getClass(), baby.getClass());
	}
	
	@Test
	public void getFoodChainRankTest() {
		PredatorPrey p = new PredatorPrey('y');
		assertEquals(10, p.getFoodChainRank());
	}
}
