package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PurePreyTest {

	
	@Test
	public void purePreyTest() {
		PurePrey p = new PurePrey('f');
		
		assertEquals(Color.GREEN, p.getColor());
		
	}
}
