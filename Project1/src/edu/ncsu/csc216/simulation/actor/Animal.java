package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;
import java.util.Random;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.Ecosystem;
import edu.ncsu.csc216.simulation.environment.utils.Location;

public abstract class Animal {

	/** Steps that have passed since the animal's last meal */
	private int timeSinceLastMeal;
	/** Steps that have passed since the animal bred */
	private int timeSinceLastBreed;
	/** Indicates whether or not an animal is disabled for the coming step */
	private boolean canActThisStep;
	/** Symbol that represents the animal */
	private char symbol;
	/** Indicates whether the animal is dead or alive */
	private boolean alive;
	/** A seed for the randomGenerator*/
	private static int seed = 500;
	/** A randomGenerator that produces a number 1-4 using seed to choose where the animal looks first*/
	private static Random randomGenerator = new Random();
	
	/**
	 * Constructor for an animal object
	 * @param c the symbol to represent this animal
	 */
	public Animal(char c) {
		symbol = c;
		randomGenerator.setSeed(seed);
	}
	
	/**
	 * Sets a new seed for the randomGenerator.
	 * @param seed The seed for the randomGenerator
	 */
	public static void setRandomSeed(int newSeed) {
		randomGenerator.setSeed(newSeed);
	}
	
	/**
	 * retrieves animal's symbol
	 * @return symbol representing the animal
	 */
	public char getSymbol() {
		return symbol;
	}
	
	/**
	 * Retrieves value for animal's dead or alive status.
	 * @return alive representing alive or dead
	 */
	public boolean isAlive() {
		return alive;
	}
	
	/**
	 * When called, enables the animal.
	 */
	public void enable() {
		canActThisStep = true;
	}
	
	/**
	 * When called, disables the animal.
	 */
	public void disable() {
		canActThisStep = false;
	}
	
	/**
	 * When called, puts the animal out of its misery.
	 */
	protected void die() {
		alive = false;
	}
	
	/**
	 * Indicates whether an animal can act in the next step or not.
	 * @return canActThisStep True if the animal can act in the next step.
	 */
	protected boolean canAct() {
		return canActThisStep;
	}
	
	/**
	 * Retrieves amount of time since the animal last bred. 
	 * @return timeSinceLastBreed Steps since the animal last bred.
	 */
	protected int getTimeSinceLastBreed() {
		return timeSinceLastBreed;
	}
	
	/**
	 * Retrieves amount of time since the animal last ate. 
	 * @return timeSinceLastMeal Steps since the animal last had a meal.
	 */
	protected int getTimeSinceLastMeal() {
		return timeSinceLastMeal;
	}
	
	/**
	 * When called, increments the time since an animal ate by 1.
	 */
	protected void incrementTimeSinceLastMeal() {
		timeSinceLastMeal++;
	}
	
	/**
	 * When called, increments the time since an animal bred by 1.
	 */
	protected void incrementTimeSinceLastBreed() {
		timeSinceLastBreed++;
	}
	
	/**
	 * Parent animal looks for empty cells around it starting west and looking clockwise.
	 * Pops an infant into the first empty cell.
	 * @param l The location of the parent.
	 * @param e The ecosystem to make babies in.
	 * @return True if the animal has bred, false if it failed.
	 */
	protected boolean breed(Location l, EcoGrid e) {
		Location babyLocation;
		Animal baby = this.makeNewBaby();
		
		babyLocation = e.dueWest(l);
		if (e.isEmpty(babyLocation)) {
			e.add(baby, babyLocation);
			timeSinceLastBreed = 0;
			return true;
		}
			
		babyLocation = e.dueNorth(l);
		if (e.isEmpty(babyLocation)) {
			e.add(baby, babyLocation);
			timeSinceLastBreed = 0;
			return true;
		}
			
		babyLocation = e.dueEast(l);
		if (e.isEmpty(babyLocation)) {
			e.add(baby, babyLocation);
			timeSinceLastBreed = 0;
			return true;
		}
			
		babyLocation = e.dueSouth(l);
		if (e.isEmpty(babyLocation)) {
			e.add(baby, babyLocation);
			timeSinceLastBreed = 0;
			return true;
		}
		
		timeSinceLastBreed++;
		
		return false;
	}
	
	/**
	 * Animal scouts the locations around it starting randomly and looking clockwise and moves to the first empty one.
	 * @param location The current location of the animal
	 * @param e The Ecosystem to interact with
	 */
	protected void move(Location location, EcoGrid e) {
		Location newLocation;
		int lookDir = randomGenerator.nextInt((4));
		int numDirectionsLooked = 0;
		
		
		while (numDirectionsLooked < 4) {
			if (lookDir == 0) {
				newLocation = e.dueNorth(location);
				
				if (e.isEmpty(newLocation)) {
					e.add(this, newLocation);
					e.remove(location);
				}
				
				numDirectionsLooked++;
			}
			
			if (lookDir == 1) {
				newLocation = e.dueEast(location);
				
				if (e.isEmpty(newLocation)) {
					e.add(this, newLocation);
					e.remove(location);
				}
				
				numDirectionsLooked++;
			}
			
			if (lookDir == 2) {
				 newLocation = e.dueSouth(location);
				 
				if (e.isEmpty(newLocation)) {
					e.add(this, newLocation);
					e.remove(location);
				 }
				 
				numDirectionsLooked++;
			}
			
			if (lookDir == 3) {
				newLocation = e.dueWest(location);
				
				if (e.isEmpty(newLocation)) {
					e.add(this, newLocation);
					e.remove(location);
				}
				
				numDirectionsLooked++;
			}
		}
	}
	

	protected boolean eat(Location l, EcoGrid e) {
		Location preyLocation;
		Animal prey;
		
		preyLocation = e.dueWest(l);
		prey = e.getMap()[preyLocation.getRow()][preyLocation.getCol()];
		if (prey.getFoodChainRank() < this.getFoodChainRank()) {
			e.remove(preyLocation);
			timeSinceLastMeal = 0;
			return true;
		}
		
		preyLocation = e.dueNorth(l);
		prey = e.getMap()[preyLocation.getRow()][preyLocation.getCol()];
		if (prey.getFoodChainRank() < this.getFoodChainRank()) {
			e.remove(preyLocation);
			timeSinceLastMeal = 0;
			return true;
		}
		
		preyLocation = e.dueEast(l);
		prey = e.getMap()[preyLocation.getRow()][preyLocation.getCol()];
		if (prey.getFoodChainRank() < this.getFoodChainRank()) {
			e.remove(preyLocation);
			timeSinceLastMeal = 0;
			return true;
		}
		
		preyLocation = e.dueSouth(l);
		prey = e.getMap()[preyLocation.getRow()][preyLocation.getCol()];
		if (prey.getFoodChainRank() < this.getFoodChainRank()) {
			e.remove(preyLocation);
			timeSinceLastMeal = 0;
			return true;
		}
		
		timeSinceLastMeal++;
		return false;
	}
	  
	
	/**
	 * Retrieves the animal's color.
	 * @return Color The animal's color.
	 */
	public abstract Color getColor();
	
	/**
	 * An animal acts according it the behavior of its type.
	 * @param l The location of the animal that will act.
	 * @param e The ecosystem containing the animal.
	 */
	public abstract void act(Location l, EcoGrid e);
	
	/**
	 * Compares a given time to pastBreedTime.
	 * @param i The amount of time to compare to pastBreedTime.
	 * @return True if it is past breed time, false if it is not.
	 */
	protected abstract boolean pastBreedTime(int i);
	
	/**
	 * Creates a wonderful little miracle from the parent's type.
	 * @return Animal A new animal of the same type as the parent.
	 */
	protected abstract Animal makeNewBaby();
	
	/**
	 * Retrieves the animals' food chain rank.
	 * @return foodChainRank The rank of the animal in the food chain.
	 */
	protected abstract int getFoodChainRank();
}
