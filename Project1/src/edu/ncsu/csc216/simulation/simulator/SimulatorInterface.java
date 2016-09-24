package edu.ncsu.csc216.simulation.simulator;

import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

public interface SimulatorInterface {

	void step();
	
	PaintedLocation[][] getView();
	
	String[] getNames();
}
