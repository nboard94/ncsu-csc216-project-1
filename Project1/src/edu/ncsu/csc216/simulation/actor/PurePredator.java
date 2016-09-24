package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

public class PurePredator extends Animal{

	PurePredator(char c) {
		super(c);
	}

	@Override
	Color getColor() {
		return null;
	}

	@Override
	void act(Location l, EcoGrid e) {
		
	}

	@Override
	protected boolean pastBreedTime(int i) {
		return false;
	}

	@Override
	protected Animal makeNewBaby() {
		return null;
	}

	@Override
	protected int getFoodChainRank() {
		return 0;
	}

}
