package edu.ncsu.csc216.simulation.environment.utils;

public class Location {

	private int row;
	private int column;
	
	public Location(int r, int c) {
		this.row = r;
		this.column = c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return column;
	}
}
