package edu.ncsu.csc216.simulation.environment;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.actor.PurePrey;
import edu.ncsu.csc216.simulation.environment.utils.Location;
import edu.ncsu.csc216.simulation.simulator.AutomataSimulator;

/**
 * Class that tests the methods within Ecosystem class.
 * @author NBoar
 */
public class EcosystemTest {

	private final static String TEST_FILE = "test-files/testFile";
	
	AutomataSimulator sim = new AutomataSimulator(TEST_FILE);
	
	@Test
	public void testIsEmpty() {
		Ecosystem e = new Ecosystem(20, 20);
		Location emptyLoc = new Location(1, 6);
		Location animalLoc = new Location(1, 5);
		Animal a = new PurePrey('x');
		e.add(a, animalLoc);

		assertTrue(e.isEmpty(emptyLoc));
		assertFalse(e.isEmpty(animalLoc));
		
	}
	
	@Test
	public void testRemove() {
		Ecosystem e = new Ecosystem(20, 20);
		Location animalLoc = new Location(1, 6);
		e.remove(animalLoc);
		assertTrue(e.isEmpty(animalLoc));
	}
	
	@Test
	public void dueNorthTest() {
		Ecosystem e = new Ecosystem(20, 20);
		Location testLoc;
		Location wantedLoc;
		
		Location topRow = new Location(0, 5);
		testLoc = e.dueNorth(topRow);
		wantedLoc = new Location(19, 5);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
		
		Location bottomRow = new Location(19, 5);
		testLoc = e.dueNorth(bottomRow);
		wantedLoc = new Location(18, 5);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
	}
	
	@Test
	public void dueSouthTest() {
		Ecosystem e = new Ecosystem(20, 20);
		Location testLoc;
		Location wantedLoc;
		
		Location bottomRow = new Location(19, 5);
		testLoc = e.dueSouth(bottomRow);
		wantedLoc = new Location(0, 5);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
		
		Location topRow = new Location(0, 5);
		testLoc = e.dueSouth(topRow);
		wantedLoc = new Location(1, 5);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
	}
	
	@Test
	public void dueEastTest() {
		Ecosystem e = new Ecosystem(20, 20);
		Location testLoc;
		Location wantedLoc;
		
		Location rightCol = new Location(5, 19);
		testLoc = e.dueEast(rightCol);
		wantedLoc = new Location(5, 0);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
		
		Location leftCol = new Location (5, 0);
		testLoc = e.dueEast(leftCol);
		wantedLoc = new Location(5, 1);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
	}
	
	@Test
	public void dueWestTest() {
		Ecosystem e =  new Ecosystem(20, 20);
		Location testLoc;
		Location wantedLoc;
		
		Location leftCol = new Location(5, 0);
		testLoc = e.dueWest(leftCol);
		wantedLoc = new Location(5, 19);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
		
		Location rightCol = new Location(5, 19);
		testLoc = e.dueWest(rightCol);
		wantedLoc = new Location(5, 18);
		assertEquals(wantedLoc.getRow(), testLoc.getRow());
		assertEquals(wantedLoc.getCol(), testLoc.getCol());
	}

}
