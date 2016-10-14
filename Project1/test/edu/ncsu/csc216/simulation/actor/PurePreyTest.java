package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PurePreyTest {

	
	@Test
	public void purePreytest() {
		PurePrey p = new PurePrey('f');
		Configs.setToDefaults();
		
		assertEquals('f', p.getSymbol());
		assertTrue(p.isAlive());
		assertEquals(Color.GREEN, p.getColor());
	}
	
	@Test
	public void pastBreedTimeTest() {
		PurePrey p = new PurePrey('f');
		Configs.setToDefaults();
		
		assertFalse(p.pastBreedTime(0));
		assertFalse(p.pastBreedTime(1));
		assertTrue(p.pastBreedTime(2));
	}
	
	@Test
	public void makeNewBaby() {
		PurePrey parent = new PurePrey('x');
		Animal baby = parent.makeNewBaby();
		
		assertEquals(parent.getSymbol(), baby.getSymbol());
		assertEquals(parent.getClass(), baby.getClass());
	}
	
	@Test
	public void getFoodChainRankTest() {
		PurePrey p = new PurePrey('x');
		assertEquals(0, p.getFoodChainRank());
	}
}
