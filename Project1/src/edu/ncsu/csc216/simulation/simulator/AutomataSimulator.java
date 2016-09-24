package edu.ncsu.csc216.simulation.simulator;

import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

public class AutomataSimulator implements SimulatorInterface {

	private static final int SIZE;
	private static final int THRESHOLD;
	private static final String SIZE_ERROR_MESSAGE;
	private static final String THRESHOLD_ERROR_MESSAGE;
	private String[] names;
	private int numberOfNames;
	private char[] symbol;
	private static final char EMPTY;
	private EcoGrid simpleSystem;


	
	public AutomataSimulator(String s) {
		
	}
	
	public AutomataSimulator(String s1, String s2) {
		
	}
	
	@Override
	public void step() {
		
	}
	
	@Override
	public PaintedLocation[][] getView() {
		return null;
	}
	
	@Override
	public String[] getNames() {
		return null;
	}
}
