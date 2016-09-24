package edu.ncsu.csc216.simulation.environment.utils;

public class Location {

	private int row;
	private int column;
	
	Location(int r, int c) {
		this.row = r;
		this.column = c;
	}
	
	int getRow() {
		return row;
	}
	
	int getColumn() {
		return column;
	}
}
