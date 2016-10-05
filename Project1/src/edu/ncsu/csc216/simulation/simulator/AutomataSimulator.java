package edu.ncsu.csc216.simulation.simulator;

import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

/**The AutomataSimulator receives the input files.
 * @author NBoar
 *
 */
public class AutomataSimulator implements SimulatorInterface {

	
	//PLACEHOLDER VALUES FOR THE FINALS.  WHAT ARE THE REAL ONES?
	private static final int SIZE = 0;
	private static final int THRESHOLD = 0;
	private static final String SIZE_ERROR_MESSAGE = "";
	private static final String THRESHOLD_ERROR_MESSAGE = "";
	private String[] names;
	private int numberOfNames;
	private char[] symbol;
	private static final char EMPTY = ' ';
	
	
	/**Constructor for the AutomataSimulator using default configurations.
	 * @param file The name of the initial population file.
	 */
	public AutomataSimulator(String file) {
		
	}
	
	/**Constructor for the AutomataSimulator with read-in configurations.
	 * @param file The name of the initial population file.
	 * @param config The name of the configuration file.
	 */
	public AutomataSimulator(String file, String config) {
		
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.simulator.SimulatorInterface#step()
	 */
	@Override
	public void step() {
		
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.simulator.SimulatorInterface#getView()
	 */
	@Override
	public PaintedLocation[][] getView() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.simulator.SimulatorInterface#getNames()
	 */
	@Override
	public String[] getNames() {
		return null;
	}
}
