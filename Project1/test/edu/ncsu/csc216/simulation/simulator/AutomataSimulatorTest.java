package edu.ncsu.csc216.simulation.simulator;

import static org.junit.Assert.*;


import org.junit.Test;



/**Tests the AutomataSimulator class
 * @author NBoar
 *
 */
public class AutomataSimulatorTest {
	
		private static final String TEST_FILE = "test-files/testFile";
		private static final String CONFIG_TEST_FILE = "test-files/configFile";
		
	@Test
	public void automataSimulatorTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE);
		assertEquals(4, as.getNames().length);
		assertEquals("O: Great Gray Owl", as.getNames()[0]);
		assertEquals("M: Mouse", as.getNames()[1]);
		assertEquals("F: Frog", as.getNames()[2]);
		assertEquals("I: Insect", as.getNames()[3]);
	}

	@Test
	public void automataSimulatorConfigsTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE, CONFIG_TEST_FILE);
		assertEquals(4, as.getNames().length);
		assertEquals("O: Great Gray Owl", as.getNames()[0]);
		assertEquals("M: Mouse", as.getNames()[1]);
		assertEquals("F: Frog", as.getNames()[2]);
		assertEquals("I: Insect", as.getNames()[3]);
	}
}
