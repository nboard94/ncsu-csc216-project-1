package edu.ncsu.csc216.simulation.simulator;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.environment.Ecosystem;
import edu.ncsu.csc216.simulation.environment.utils.Location;
import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;



/**Tests the AutomataSimulator class
 * @author NBoar
 *
 */
public class AutomataSimulatorTest {
	
		private static final String TEST_FILE = "test-files/testFile";
		private static final String CONFIG_TEST_FILE = "test-files/configFile";
		
	/**
	 * Tests the automataSimulator constructor with the initialization file
	 */
	@Test
	public void automataSimulatorTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE);
		assertEquals(4, as.getNames().length);
		assertEquals("O: Great Gray Owl", as.getNames()[0]);
		assertEquals("M: Mouse", as.getNames()[1]);
		assertEquals("F: Frog", as.getNames()[2]);
		assertEquals("I: Insect", as.getNames()[3]);
	}

	/**
	 * Tests the automataSimulator constructor with the initialization file and configuration file.
	 */
	@Test
	public void automataSimulatorConfigsTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE, CONFIG_TEST_FILE);
		assertEquals(4, as.getNames().length);
		assertEquals("O: Great Gray Owl", as.getNames()[0]);
		assertEquals("M: Mouse", as.getNames()[1]);
		assertEquals("F: Frog", as.getNames()[2]);
		assertEquals("I: Insect", as.getNames()[3]);
	}
	
	/**
	 * Validates that step works correctly.
	 */
	@Test
	public void stepTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE);
		Ecosystem e = new Ecosystem(20, 20);
		Location currentLoc;
		as.step();
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				currentLoc = new Location(i, j);
				if (!e.isEmpty(currentLoc)) {
					assertTrue(e.getItemAt(currentLoc).isAlive());
				}
			}
		}
	}
	
	/**
	 * Validates getView works correctly.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void getViewTest() {
		AutomataSimulator as = new AutomataSimulator(TEST_FILE);
		Ecosystem e = new Ecosystem(20, 20);
		Animal currentAnimal;
		PaintedLocation currentLocToPaint;
		PaintedLocation[][] view = new PaintedLocation[20][20];
		Animal[][] map = e.getMap();



		for (int i = 0; i < 20; i++) {
			
			for (int j = 0; j < 20; j++) {
				
				currentAnimal = map[i][j];
				
				if (currentAnimal == null) {
					currentLocToPaint = new PaintedLocation(i, j, Color.BLACK, '.');
					view[i][j] = currentLocToPaint;
				}
				else if (currentAnimal != null && currentAnimal.getSymbol() != '.'){
					currentLocToPaint = new PaintedLocation(i, j, currentAnimal.getColor(), currentAnimal.getSymbol());
					view[i][j] = currentLocToPaint;
				}
			}
		}
		
		assertEquals(as.getView(), view);
	}
}
