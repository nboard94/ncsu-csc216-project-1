package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

public class Configs {

	private static final int[] DEFAULT_FOOD_CHAIN_RANK = {0, 10, 20};
	private static final Color[] DEFAULT_COLORS = {Color.green, Color.orange, Color.red};
	private static Color[] PLAYER_COLORS = {};
	private static final int[] DEFAULT_STARVE_TIME = {10, 6, 5};
	private static int[] STARVE_TIME = {};
	private static final int[] DEFAULT_BREED_TIME = {1, 7, 15};
	private static int[] BREED_TIME = {};
	
	Configs() {
		
	}
	
	static void initConfigs(Color[] c, int[] s, int[] b) {
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
	
	static void setToDefaults() {
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
	
	static Color getPreyColor() {
		return PLAYER_COLORS[0];
	}
	
	static Color getMiddleColor() {
		return PLAYER_COLORS[1];
	}
	
	static Color getPredatorColor() {
		return PLAYER_COLORS[2];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	static int getPreyFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[0];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	static int getMiddleFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[1];
	}
	
//	CURRENTLY RETURNS ONLY THE DEFAULT VALUE
	static int getPredatorFoodChainRank() {
		return DEFAULT_FOOD_CHAIN_RANK[2];
	}
	
	static int getPreyStarveTime() {
		return STARVE_TIME[0];
	}
	
	static int getMediumStarveTime() {
		return STARVE_TIME[1];
	}
	
	static int getPredatorStarveTime() {
		return STARVE_TIME[2];
	}
	
	static int getPreyBreedTime() {
		return BREED_TIME[0];
	}
	
	static int getMediumBreedTime() {
		return BREED_TIME[1];
	}
	
	static int getPredatorBreedTime() {
		return BREED_TIME[2];
	}
}
