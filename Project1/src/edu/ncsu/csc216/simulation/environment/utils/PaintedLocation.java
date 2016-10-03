package edu.ncsu.csc216.simulation.environment.utils;

import java.awt.Color;

public class PaintedLocation extends Location {

	private Color tint;
	private char symbol;
	
	public PaintedLocation(int r, int c, Color t, char s) {
		super(r, c);
		this.tint = t;
		this.symbol = s;
	}
	
	public Color getColor() {
		return tint;
	}

	public char getSymbol() {
		return symbol;
	}
}
