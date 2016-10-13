package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Class for an animal in the middle of the food chain.  Not the top predator or
 * the bottom prey.  Contains behavioral information specific to this animal type.
 * @author NBoar
 */
public class PredatorPrey extends Animal {

	/**
	 * Constructor for a middle animal.  Calls the super constructor in Animal.
	 * @param c The character representing this animal's symbol.
	 */
	public PredatorPrey(char c) {
		super(c);
	}

	@Override
	public Color getColor() {
		return Configs.getMiddleColor();
	}

	@Override
	public void act(Location l, EcoGrid e) {
	//	this.breed(l, e);
	}

	@Override
	protected boolean pastBreedTime(int i) {
		return false;
	}

	@Override
	protected Animal makeNewBaby() {
		PredatorPrey baby = new PredatorPrey(this.getSymbol());
		return baby;
	}

	@Override
	protected int getFoodChainRank() {
		return Configs.getMiddleFoodChainRank();
	}

}
