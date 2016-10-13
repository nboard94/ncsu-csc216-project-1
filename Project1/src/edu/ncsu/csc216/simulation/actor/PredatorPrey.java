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
		if (this.canAct()) {
			boolean wasAbleToBreed = false;
			boolean wasAbleToEat = false;
			
			if (this.pastBreedTime(Configs.getMiddleBreedTime())) {
				wasAbleToBreed = this.breed(l, e);
			}
			
			if (!wasAbleToBreed) {
				wasAbleToEat = this.eat(l, e);
			}
			
			if (!wasAbleToBreed && !wasAbleToEat) {
				this.move(l, e);
			}
			
			if (this.getTimeSinceLastMeal() > Configs.getMiddleStarveTime()) {
				this.die();
			}
			
			this.disable();
		}
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
		PredatorPrey baby = new PredatorPrey(this.getSymbol());
		return baby;
	}

	@Override
	protected int getFoodChainRank() {
		return Configs.getMiddleFoodChainRank();
	}

}
