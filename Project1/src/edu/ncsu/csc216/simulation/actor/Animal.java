package edu.ncsu.csc216.simulation.actor;

import java.awt.Color;
import java.util.Random;

public abstract class Animal {

	private int timeSinceLastMeal;
	private int timeSinceLastBreed;
	private boolean canActThisStep;
	private char symbol;
	private boolean alive;
	private static int seed;
	private static Random randomGenerator;
	
	Animal(char c) {
		
	}
	
	//not yet implemented
	static void setRandomSeed(int s) {
		
	}
	
	char getSymbol() {
		return symbol;
	}
	
	boolean isAlive() {
		return alive;
	}
	
	void enable() {
		canActThisStep = true;
	}
	
	void disable() {
		canActThisStep = false;
	}
	
	protected void die() {
		alive = false;
	}
	
	protected boolean canAct() {
		return canActThisStep;
	}
	
	protected int getTimeSinceLastBreed() {
		return timeSinceLastBreed;
	}
	
	protected int getTimeSinceLastMeal() {
		return timeSinceLastMeal;
	}
	
	protected void incrementTimeSinceLastMeal() {
		timeSinceLastMeal++;
	}
	
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
	
	abstract Color getColor();
	
	abstract void act(Location l, EcoGrid e);
	
	protected abstract boolean pastBreedTime(int i);
	
	protected abstract Animal makeNewBaby();
	
	protected abstract int getFoodChainRank();
}
