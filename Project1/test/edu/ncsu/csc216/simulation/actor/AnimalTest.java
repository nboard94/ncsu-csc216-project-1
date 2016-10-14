package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class AnimalTest {
	
	@Test
	public void animalTest() {
		Animal p1 = new PurePrey('x');
		assertEquals('x', p1.getSymbol());
		assertEquals(Color.GREEN, p1.getColor());
		
		Animal p2 = new PredatorPrey('y');
		assertEquals('y', p2.getSymbol());
		assertEquals(Color.ORANGE, p2.getColor());
		
		Animal p3 = new PurePredator('z');
		assertEquals('z', p3.getSymbol());
		assertEquals(Color.RED, p3.getColor());
	}
	
	@Test
	public void  isAliveTest() {
		Animal p1 = new PurePrey('x');
		assertTrue(p1.isAlive());
		
		Animal p2 = new PredatorPrey('y');
		assertTrue(p2.isAlive());
		
		Animal p3 = new PurePredator('z');
		assertTrue(p3.isAlive());
	}
	
	@Test
	public void enableTest() {
		Animal p1 = new PurePrey('x');
		p1.enable();
		assertTrue(p1.canAct());
		
		Animal p2 = new PredatorPrey('y');
		p2.enable();
		assertTrue(p2.canAct());
		
		Animal p3 = new PurePredator('z');
		p3.enable();
		assertTrue(p3.canAct());
	}
	
	@Test
	public void disableTest() {
		Animal p1 = new PurePrey('x');
		p1.disable();
		assertFalse(p1.canAct());
		
		Animal p2 = new PredatorPrey('y');
		p2.disable();
		assertFalse(p2.canAct());
		
		Animal p3 = new PurePredator('z');
		p3.disable();
		assertFalse(p3.canAct());
	}
	
	@Test
	public void dieTest() {
		Animal p1 = new PurePrey('x');
		p1.die();
		assertFalse(p1.isAlive());
		
		Animal p2 = new PredatorPrey('y');
		p2.die();
		assertFalse(p2.isAlive());
		
		Animal p3 = new PurePredator('z');
		p3.die();
		assertFalse(p3.isAlive());
	}
	
	@Test
	public void testIncrementTimeSincelastMeal() {
		Animal p1 = new PurePrey('x');
		assertEquals(0, p1.getTimeSinceLastMeal());
		p1.incrementTimeSinceLastMeal();
		assertEquals(1, p1.getTimeSinceLastMeal());
		
		Animal p2 = new PredatorPrey('y');
		assertEquals(0, p2.getTimeSinceLastMeal());
		p2.incrementTimeSinceLastMeal();
		assertEquals(1, p2.getTimeSinceLastMeal());
		
		Animal p3 = new PurePredator('z');
		assertEquals(0, p3.getTimeSinceLastMeal());
		p3.incrementTimeSinceLastMeal();
		assertEquals(1, p3.getTimeSinceLastMeal());
	}
	
	@Test
	public void testIncrementTimeSincelastBreed() {
		Animal p1 = new PurePrey('x');
		assertEquals(0, p1.getTimeSinceLastBreed());
		p1.incrementTimeSinceLastBreed();
		assertEquals(1, p1.getTimeSinceLastBreed());
		
		Animal p2 = new PredatorPrey('y');
		assertEquals(0, p2.getTimeSinceLastBreed());
		p2.incrementTimeSinceLastBreed();
		assertEquals(1, p2.getTimeSinceLastBreed());
		
		Animal p3 = new PurePredator('z');
		assertEquals(0, p3.getTimeSinceLastBreed());
		p3.incrementTimeSinceLastBreed();
		assertEquals(1, p3.getTimeSinceLastBreed());
	}
}
