package edu.ncsu.csc216.simulation.environment.utils;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * @author NBoar
 * Test class for the PaintedLocation class.
 */
public class PaintedLocationTest {

	/**
	 * Tests the PaintedLocation constructor.
	 * Also tests the getter methods for PaintedLocation.
	 */
	@Test
	public void paintedLocationTest() {
		PaintedLocation l = new PaintedLocation(2, 3, Color.MAGENTA, '@');
		
		assertEquals(2, l.getRow());
		assertEquals(3, l.getCol());
		assertEquals(Color.MAGENTA, l.getColor());
		assertEquals('@', l.getSymbol());
	}
	
	
}
