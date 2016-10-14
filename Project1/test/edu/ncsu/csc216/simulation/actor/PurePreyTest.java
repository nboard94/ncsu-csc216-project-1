package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.Ecosystem;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Tests the PurePrey class that extends Animal.
 * @author NBoar
 */
public class PurePreyTest {

	/**
	 * Tests the construction of the PurePrey object.
	 */
	@Test
	public void purePreytest() {
		PurePrey p = new PurePrey('f');
		Configs.setToDefaults();
		
		assertEquals('f', p.getSymbol());
		assertTrue(p.isAlive());
		assertEquals(Color.GREEN, p.getColor());
	}
	
	/**
	 * Validates that pastBreedTime returns the correct value.
	 */
	@Test
	public void pastBreedTimeTest() {
		PurePrey p = new PurePrey('f');
		Configs.setToDefaults();
		
		assertFalse(p.pastBreedTime(0));
		assertFalse(p.pastBreedTime(1));
		assertTrue(p.pastBreedTime(2));
	}
	
	/**
	 * Validates that makeBaby does indeed make a baby correctly.
	 */
	@Test
	public void makeNewBaby() {
		PurePrey parent = new PurePrey('x');
		Animal baby = parent.makeNewBaby();
		
		assertEquals(parent.getSymbol(), baby.getSymbol());
		assertEquals(parent.getClass(), baby.getClass());
		
		}
	
	/**
	 * Validates that foodChainRank is return properly.
	 */
	@Test
	public void getFoodChainRankTest() {
		PurePrey p = new PurePrey('x');
		assertEquals(0, p.getFoodChainRank());
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
		Animal p = new PurePrey('x');
		
		e.add(p, r0c0);
		e.add(p, r0c1);
		
		p.enable();
		
		p.act(r0c0, e);
	}
}
