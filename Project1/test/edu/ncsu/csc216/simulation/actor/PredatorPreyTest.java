package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests the PredatorPrey class that extends Animal.
 * @author NBoar
 */
public class PredatorPreyTest {

	
	/**
	 * Tests the construction of the PredatorPrey object.
	 */
	@Test
	public void testPredatorPrey () {
		PredatorPrey p = new PredatorPrey('Y');
		Configs.setToDefaults();
		
		assertEquals('Y', p.getSymbol());
		assertEquals(Color.ORANGE, p.getColor());
		assertEquals(10, p.getFoodChainRank());
	}
	
	/**
	 * Validates that pastBreedTime returns the correct value.
	 */
	@Test
	public void testPastBreedTime() {
		PredatorPrey p = new PredatorPrey('y');
		Configs.setToDefaults();
		
		assertFalse(p.pastBreedTime(6));
		assertFalse(p.pastBreedTime(7));
		assertTrue(p.pastBreedTime(8));
	}
	
	/**
	 * Validates that makeBaby does indeed make a baby correctly.
	 */
	@Test
	public void testMakeBaby() {
		PredatorPrey parent = new PredatorPrey('y');
		Animal baby = parent.makeNewBaby();
		
		assertEquals(parent.getSymbol(), baby.getSymbol());
		assertEquals(parent.getClass(), baby.getClass());
	}
	
	/**
	 * Validates that foodChainRank is return properly.
	 */
	@Test
	public void getFoodChainRankTest() {
		PredatorPrey p = new PredatorPrey('y');
		assertEquals(10, p.getFoodChainRank());
	}
}
