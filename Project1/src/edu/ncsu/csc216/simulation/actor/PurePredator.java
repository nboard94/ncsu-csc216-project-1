package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Class for an animal at the top of the food chain.  
 * Contains behavioral information specific to this animal type.
 * @author NBoar
 */
public class PurePredator extends Animal {

	/**
	 * Constructor a predator.  Calls the super constructor in Animal.
	 * @param c The character representing this animal's symbol.
	 */
	public PurePredator(char c) {
		super(c);
	}

	@Override
	public Color getColor() {
		return Configs.getPredatorColor();
	}

	@Override
	public void act(Location l, EcoGrid e) {
		
		boolean wasAbleToEat = false;
		boolean wasAbleToBreed = false;
		
		wasAbleToEat = this.eat(l, e);
		
		if (!wasAbleToEat && this.pastBreedTime(Configs.getPredatorBreedTime())) {
			wasAbleToBreed = this.breed(l, e);
		}
		
		if (!wasAbleToEat && !wasAbleToBreed) {
			this.move(l, e);
		}
		
		if (this.getTimeSinceLastMeal() > Configs.getPredatorStarveTime()) {
			this.die();
		}
		
		this.disable();
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
