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
	 */
	PaintedLocation[][] getView();
	
	/**
	 * Classes implementing SimulatorInterface must implement getNames.
	 */
	String[] getNames();
}
