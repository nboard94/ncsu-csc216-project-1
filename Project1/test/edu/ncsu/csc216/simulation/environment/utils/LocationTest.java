package edu.ncsu.csc216.simulation.environment.utils;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author NBoar
 * Test class for the Location class.
 */
public class LocationTest {

	
	/**
	 * Tests the Location constructor.
	 * Also tests the getter methods for Location.
	 */
	@Test
	public void locationTest() {
		Location l = new Location(12,15);
		
		assertEquals(12, l.getRow());
		assertEquals(15, l.getCol());
	}
	
}
