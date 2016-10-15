package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.Ecosystem;
import edu.ncsu.csc216.simulation.environment.utils.Location;

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
	
	/**
	 * Validates that act works.
	 */
	@Test
	public void actTest() {
		EcoGrid e = new Ecosystem(2, 2);
		Location r0c0 = new Location(0, 0);
		Location r0c1 = new Location(0, 1);
		Location r1c0 = new Location(1, 0);
		Location r1c1 = new Location(1, 1);
		Animal p = new PredatorPrey('x');
		Animal prey = new PurePrey('y');
		
		e.add(p, r0c0);
		e.add(p, r0c1);
		e.add(prey, r1c0);
		e.add(null, r1c1);
		
		e.getItemAt(r0c0).enable();
		
		for (int i = 0; i < 100; i++) {
			e.getItemAt(r0c0).incrementTimeSinceLastBreed();
			e.getItemAt(r0c0).incrementTimeSinceLastMeal();
		}
		
		assertEquals('x', e.getItemAt(r0c0).getSymbol());
		
	}
}
