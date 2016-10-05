package edu.ncsu.csc216.simulation.environment.utils;

import java.awt.Color;

/**Identifies the location and paints the contents.
 * @author NBoar
 */
public class PaintedLocation extends Location {

	/** The color to paint the cell */
	private Color tint;
	/** The symbol for the location */
	private char symbol;
	
	/**
	 * Constructor for a PaintedLocation.  Sets the row, column, color, and symbol.
	 * @param r The row of the location to paint.
	 * @param c The column of the location to paint.
	 * @param t The color to paint the location.
	 * @param s The symbol to represent the location.
	 */
	public PaintedLocation(int r, int c, Color t, char s) {
		super(r, c);
		this.tint = t;
		this.symbol = s;
	}
	
	/**
	 * Retrieves the color that the  cell is painted.
	 * @return tint The color the cell is painted.
	 */
	public Color getColor() {
		return tint;
	}

	/**
	 * Retrieves the symbol that represents the location.
	 * @return symbol The symbol that represents the cell.
	 */
	public char getSymbol() {
		return symbol;
	}
}
