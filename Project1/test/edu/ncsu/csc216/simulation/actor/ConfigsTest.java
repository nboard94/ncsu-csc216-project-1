package edu.ncsu.csc216.simulation.actor;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * Test class for the static Configs class
 * @author NBoar
 */
public class ConfigsTest {

	/**
	 * Tests to make sure a Configs object is constructed successfully.
	 */
	@Test
	public void configsTest() {
		Configs c = new Configs();
		
		// TODO
		//How to make this a better test?
		assertSame(c, c);
		assertEquals(0, Configs.getPreyFoodChainRank());
		assertEquals(10, Configs.getMiddleFoodChainRank());
		assertEquals(20, Configs.getPredatorFoodChainRank());
	}
	
	/**
	 * Tests initConfigs to make sure that configuration settings are properly set.
	 * Also tests the getter methods for PLAYER_COLORS, STARVE_TIME, BREED_TIME.
	 */
	@Test
	public void initConfigsTest() {
		Color[] c = {Color.BLUE, Color.GREEN, Color.MAGENTA};
		int[] sT = {100, 200, 300};
		int[] bT = {50, 100, 150};
		
		Configs.initConfigs(c, sT, bT);
		
		assertEquals(Color.BLUE, Configs.getPreyColor());
		assertEquals(Color.GREEN, Configs.getMiddleColor());
		assertEquals(Color.MAGENTA, Configs.getPredatorColor());
		
		assertEquals(100, Configs.getPreyStarveTime());
		assertEquals(200, Configs.getMiddleStarveTime());
		assertEquals(300, Configs.getPredatorStarveTime());

		assertEquals(50, Configs.getPreyBreedTime());
		assertEquals(100, Configs.getMiddleBreedTime());
		assertEquals(150, Configs.getPredatorBreedTime());
	}
	
	/**
	 * Tests to make sure that setToDefaults successfully sets configurations to default.
	 * Also tests the getter methods for PLAYER_COLORS, STARVE_TIME, BREED_TIME.
	 */
	@Test
	public void setToDefaultsTest() {
		Configs.setToDefaults();
		
		assertEquals(Color.GREEN, Configs.getPreyColor());
		assertEquals(Color.ORANGE, Configs.getMiddleColor());
		assertEquals(Color.RED, Configs.getPredatorColor());
		
		assertEquals(10, Configs.getPreyStarveTime());
		assertEquals(6, Configs.getMiddleStarveTime());
		assertEquals(5, Configs.getPredatorStarveTime());
		
		assertEquals(1, Configs.getPreyBreedTime());
		assertEquals(7, Configs.getMiddleBreedTime());
		assertEquals(15, Configs.getPredatorBreedTime());
	}
	
}

