package edu.ncsu.csc216.simulation.environment.utils;

/**Class that represents a location object.
 * @author NBoar
 */
public class Location {

	/** The row where the location is located.*/
	private int row;
	/** The column where the location is located.*/
	private int column;
	
	/**
	 * Constructor for a location.  Sets the row and column of the location.
	 * @param r The row that the location should be set to.
	 * @param c The column that the location should be set to.
	 */
	public Location(int r, int c) {
		this.row = r;
		this.column = c;
	}
	
	/**
	 * Retrieves the row that the location is located.
	 * @return row The row where the location is located.
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Retrieves the column that the location is located.
	 * @return column The column where the location is located.
	 */
	public int getCol() {
		return column;
	}
}
