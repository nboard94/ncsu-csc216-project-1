package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;

public class PurePrey extends Animal {

	int age = 0;
	
	PurePrey(char c) {
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
