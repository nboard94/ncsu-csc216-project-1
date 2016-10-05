package edu.ncsu.csc216.simulation.environment.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	
	@Test
	public void LocationTest() {
		Location l = new Location(12,15);
		
		assertEquals(12, l.getRow());
		assertEquals(15, l.getCol());
	}
	
}
