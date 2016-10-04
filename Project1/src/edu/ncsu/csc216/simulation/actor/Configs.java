package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

/**
 * @author NBoard
 *
 */
public class Configs {

	/**	Default rank values for animals on the food chain, from lowest to highest 	 */
	private static final int[] DEFAULT_FOOD_CHAIN_RANK = {0, 10, 20};
	/** Default color values for animals on the food chain, from lowest to highest */
	private static final Color[] DEFAULT_COLORS = {Color.green, Color.orange, Color.red};
	/** The set values for animals on the food chain, from lowest to highest */
	private static Color[] PLAYER_COLORS = {};
	/** Default values for turns it takes to starve for animals on the food chain, from lowest to highest */
	private static final int[] DEFAULT_STARVE_TIME = {10, 6, 5};
	/** The set values for turns it takes to starve for animals on the food chain, from lowest to highest*/
	private static int[] STARVE_TIME = {};
	/** Default values for turns it takes to breed for animals on the food chain, from lowest to highest */
	private static final int[] DEFAULT_BREED_TIME = {1, 7, 15};
	/** The set values for turns it takes to breed for animals on the food chain, from lowest to highest*/
	private static int[] BREED_TIME = {};
	
	/**
	 * Constructor for a Configs object
	 */
	public Configs() {
		
	}
	
	/**
	 * Sets the PLAYER_COLORS, STARVE_TIME, and BREED_TIME values based on the data passed in
	 * @param c Color array for setting the PLAYER_COLOR values
	 * @param s int array for setting the STARVE_TIME values
	 * @param b int array for setting the BREED_TIME values
	 */
	public static void initConfigs(Color[] c, int[] s, int[] b) {
		PLAYER_COLORS[0] = c[0];
		PLAYER_COLORS[1] = c[1];
		PLAYER_COLORS[2] = c[2];
		STARVE_TIME[0] = s[0];
		STARVE_TIME[1] = s[1];
		STARVE_TIME[2] = s[2];
		BREED_TIME[0] = s[0];
		BREED_TIME[1] = s[1];
		BREED_TIME[2] = s[2];
	}
	
	/**
	 * Sets the PLAYER_COLORS, STARVE_TIME, and BREED_TIME values based on the default values
	 */
	public static void setToDefaults() {
		PLAYER_COLORS[0] = DEFAULT_COLORS[0];
		PLAYER_COLORS[1] = DEFAULT_COLORS[1];
		PLAYER_COLORS[2] = DEFAULT_COLORS[2];
		STARVE_TIME[0] = DEFAULT_STARVE_TIME[0];
		STARVE_TIME[1] = DEFAULT_STARVE_TIME[1];
		STARVE_TIME[2] = DEFAULT_STARVE_TIME[2];
		BREED_TIME[0] = DEFAULT_BREED_TIME[0];
		BREED_TIME[1] = DEFAULT_BREED_TIME[1];
		BREED_TIME[2] = DEFAULT_BREED_TIME[2];
	}
	
	/**
	 * retrieves prey's color
	 * @return PLAYER_COLORS[0] the value for the prey's color
	 */
	public static Color getPreyColor() {
		return PLAYER_COLORS[0];
	}
	
	/**
	 * retrieves middle animal's color
	 * @return PLAYER_COLORS[1] the value for the middleanimal's color
	 */
	public static Color getMiddleColor() {
		return PLAYER_COLORS[1];
	}
	
	/**
	 * retrieves predator's color
	 * @return PLAYER_COLORS[2] the value for the predator's color
	 */
	public static Color getPredatorColor() {
		return PLAYER_COLORS[2];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	public static int getPreyFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[0];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	public static int getMiddleFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[1];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	public static int getPredatorFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[2];
	}
	
	/**
	 * retrieves prey's starve time
	 * @return STARVE_TIME[0] the value for the prey's starve time
	 */
	public static int getPreyStarveTime() {
		return STARVE_TIME[0];
	}
	
	/**
	 * retrieves medium animal's starve time
	 * @return STARVE_TIME[1] the value for the medium animal's starve time
	 */
	public static int getMiddleStarveTime() {
		return STARVE_TIME[1];
	}
	
	/**
	 * retrieves predator's starve time
	 * @return STARVE_TIME[2] the value for the predator's starve time
	 */
	public static int getPredatorStarveTime() {
		return STARVE_TIME[2];
	}
	
	/**
	 * retrieves prey's breed time
	 * @return BREED_TIME[0] the value for the prey's breed time
	 */
	public static int getPreyBreedTime() {
		return BREED_TIME[0];
	}
	
	/**
	 * retrieves medium animal's breed time
	 * @return BREED_TIME[1] the value for the medium animal's breed time
	 */
	public static int getMediumBreedTime() {
		return BREED_TIME[1];
	}
	
	/**
	 * retrieves predator's breed time
	 * @return BREED_TIME[2] the value for the predator's breed time
	 */
	public static int getPredatorBreedTime() {
		return BREED_TIME[2];
	}
}
