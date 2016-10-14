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
		System.out.println(Configs.getPreyBreedTime());
		assertTrue(p.pastBreedTime(2));
	}
}
