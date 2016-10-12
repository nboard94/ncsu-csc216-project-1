package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;

public class PurePredator extends Animal{

	public PurePredator(char c) {
		super(c);
	}

	@Override
	public Color getColor() {
		return Configs.getPredatorColor();
	}

	@Override
	public void act(Location l, EcoGrid e) {

	}

	@Override
	protected boolean pastBreedTime(int i) {
		if (this.getTimeSinceLastBreed() > i) {
			return true;
		}
		
		return false;
	}

	@Override
	protected Animal makeNewBaby() {
		PurePredator baby = new PurePredator(this.getSymbol());
		return baby;
	}

	@Override
	protected int getFoodChainRank() {
		return Configs.getPredatorFoodChainRank();
	}

}
