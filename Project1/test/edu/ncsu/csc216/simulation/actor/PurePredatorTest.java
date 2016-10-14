package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Tests the PurePredator class that extends Animal.
 * @author NBoar
 */
public class PurePredatorTest {

	/**
	 * Tests the construction of the PurePredator object.
	 */
	@Test
	public void testPurePredator () {
		PurePredator p = new PurePredator('X');
		
		assertEquals('X', p.getSymbol());
		assertEquals(Color.RED, p.getColor());
		assertEquals(20, p.getFoodChainRank());
	}
	
	/**
	 * Validates that pastBreedTime returns the correct value.
	 */
	@Test
	public void testPastBreedTime() {
		PurePredator p = new PurePredator('y');
		Configs.setToDefaults();
		
		assertFalse(p.pastBreedTime(14));
		assertFalse(p.pastBreedTime(15));
		assertTrue(p.pastBreedTime(16));
	}
	
	/**
	 * Validates that makeBaby does indeed make a baby correctly.
	 */
	@Test
	public void testMakeBaby() {
		PurePredator p = new PurePredator('X');
		Animal b = p.makeNewBaby();
		
		assertEquals(p.getSymbol(), b.getSymbol());
		assertEquals(p.getClass(), b.getClass());
	}
	
	/**
	 * Validates that foodChainRank is return properly.
	 */
	@Test
	public void getFoodChainRankTest() {
		PurePredator p = new PurePredator('y');
		assertEquals(20, p.getFoodChainRank());
	}
}
