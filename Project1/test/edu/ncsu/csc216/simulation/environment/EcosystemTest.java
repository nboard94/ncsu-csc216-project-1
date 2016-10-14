package edu.ncsu.csc216.simulation.environment;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.simulation.environment.utils.Location;
import edu.ncsu.csc216.simulation.simulator.AutomataSimulator;

/**
 * Class that tests the methods within Ecosystem class.
 * @author NBoar
 */
public class EcosystemTest {

	private final static String TEST_FILE = "test-files/testFile.txt";
	
	AutomataSimulator sim = new AutomataSimulator(TEST_FILE);
	
	/**
	 * Tests construction of an ecosystem using different dimensions.
	 */
	@Test
	public void testEcosystem() {
		Ecosystem e = new Ecosystem(20, 20);
		
	}
	
	@Test
	public void testIsEmpty() {
		Ecosystem e = new Ecosystem(20, 20);
		Location emptyLoc = new Location(1, 6);

		assertTrue(e.isEmpty(emptyLoc));
		
	}
	
}
