package edu.ncsu.csc216.simulation.simulator;

import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

/**Interface that ensures the SimulatorInterface implements important features.
 * @author NBoar
 *
 */
public interface SimulatorInterface {

	/**
	 * Classes implementing SimulatorInterface must implement step.
	 */
	void step();
	
	/**
	 * Classes implementing SimulatorInterface must implement getView.
	 * @return The view according to color and symbol.
	 */
	PaintedLocation[][] getView();
	
	/**
	 * Classes implementing SimulatorInterface must implement getNames.
	 * @return The names of the animals from the input file.
	 */
	String[] getNames();
}
