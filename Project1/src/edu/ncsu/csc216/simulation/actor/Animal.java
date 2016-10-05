package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;
import java.util.Random;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
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
	/** */
	private static int seed;
	/** */
	private static Random randomGenerator;
	
	/**
	 * Constructor for an animal object
	 * @param c the symbol to represent this animal
	 */
	public Animal(char c) {
		symbol = c;
	}
	
	//not yet implemented
	public static void setRandomSeed(int seed) {
		
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
	
	//NYI
	protected boolean breed(Location l, EcoGrid e) {
		return false;
	}
	
	//NYI
	protected void move(Location l, EcoGrid e) {
		
	}
	
	//NYI
	protected boolean eat(Location l, EcoGrid e) {
		return false;
	}
	
	public abstract Color getColor();
	
	public abstract void act(Location l, EcoGrid e);
	
	protected abstract boolean pastBreedTime(int i);
	
	protected abstract Animal makeNewBaby();
	
	protected abstract int getFoodChainRank();
}
