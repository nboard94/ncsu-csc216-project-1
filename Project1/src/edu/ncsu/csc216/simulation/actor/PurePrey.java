package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Class for an animal at the bottom of the food chain.  
 * Contains behavioral information specific to this animal type.
 * @author NBoar
 */
public class PurePrey extends Animal {

	/** Represents the animal's age.*/
	private int age = 0;
	
	/**
	 * Constructor a prey.  Calls the super constructor in Animal.
	 * @param c The character representing this animal's symbol.
	 */
	public PurePrey(char c) {
		super(c);
	}

	@Override
	public Color getColor() {
		return Configs.getPreyColor();
	}

	@Override
	public void act(Location l, EcoGrid e) {
		
		boolean hasBred = false;
		if (this.getTimeSinceLastBreed() >= Configs.getPreyBreedTime()) {
			this.breed(l, e);
			hasBred = true;
		}
		else {
			this.incrementTimeSinceLastBreed();
		}
		
		if (!hasBred) {
		//	this.move(l, e);
		}
		
		if (this.getTimeSinceLastMeal() >= Configs.getPreyStarveTime()) {
			this.die();
		}

		this.disable();
	}

	@Override
	protected boolean pastBreedTime(int i) {
		if (age > i) {
			return true;
		}
		return false;
	}

	@Override
	protected Animal makeNewBaby() {
		PurePrey baby = new PurePrey(this.getSymbol());
		return baby;
	}

	@Override
	protected int getFoodChainRank() {
		return Configs.getPreyFoodChainRank();
	}

}
