package edu.ncsu.csc216.simulation.simulator;

import static org.junit.Assert.*;

import org.junit.Test;

/**Tests the AutomataSimulator class
 * @author NBoar
 *
 */
public class AutomataSimulatorTest {

	@Test
	public void automataSimulatorTest() {

		try {
			AutomataSimulator as = new AutomataSimulator("/Project1/test-files/testFile");
			assertEquals(4, as.getNames().length);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	public void automataSimulatorConfigTest() {

		try {
			AutomataSimulator as = new AutomataSimulator("/Project1/test-files/testFile", "/Project1/test-files/configTest");
			assertEquals(4, as.getNames().length);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}
}
