package edu.ncsu.csc216.simulation.simulator;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.actor.Configs;
import edu.ncsu.csc216.simulation.actor.PredatorPrey;
import edu.ncsu.csc216.simulation.actor.PurePredator;
import edu.ncsu.csc216.simulation.actor.PurePrey;
import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.utils.Location;
import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

/**The AutomataSimulator receives the input files.
 * @author NBoar
 *
 */
public class AutomataSimulator implements SimulatorInterface {

	
	//PLACEHOLDER VALUES FOR THE FINALS.  WHAT ARE THE REAL ONES?
	private static final int SIZE = 20;
	private static final int THRESHOLD = 2;
	private static final String SIZE_ERROR_MESSAGE = "";
	private static final String THRESHOLD_ERROR_MESSAGE = "";
	private String[] names;
	private int numberOfNames;
	private char[] symbol;
	private static final char EMPTY = '.';
	private EcoGrid simpleSystem;
	
	
	/**Constructor for the AutomataSimulator using default configurations.
	 * @param file The name of the initial population file.
	 */
	public AutomataSimulator(String file) {
		File init = new File(file);
		Location l;
		Animal[] a = {};
		char[] gridLine;
		
		try {
			Scanner initScan = new Scanner(init);

			for (int i = 0; i < numberOfNames; i++) {
				symbol[i] = initScan.next().charAt(0);
				names[i] = initScan.next();
				
				if (i == 0) {
					a[i] = new PurePredator(symbol[i]);
				}
				else if (i > 0 && i < numberOfNames) {
					a[i] = new PredatorPrey(symbol[i]);
				}
				else if (i == numberOfNames - 1) {
					a[i] = new PurePrey(symbol[i]);
				}
			}
			
			for (int i = 0; i < SIZE; i++) {
				gridLine = initScan.nextLine().toCharArray();
				
				for (int j = 0; j < gridLine.length; j++) {
					if (gridLine[j] == '.') {
						l = new Location(i, j);
					}
					else {
						l = new PaintedLocation(i, j, Color.black, '.');
					}
				}
			}
			
			initScan.close();
			
		} catch (FileNotFoundException e) {
			
		}
		
		
		
	}
	
	/**Constructor for the AutomataSimulator with read-in configurations.
	 * @param file The name of the initial population file.
	 * @param config The name of the configuration file.
	 */
	public AutomataSimulator(String file, String configFile) {
		this(file);
		
		File conFile = new File(configFile);
		Color[] colorConfigs = {null, null, null};
		int[] starveConfigs = new int[3];
		int[] breedConfigs = new int[3];
		
		try {
			Scanner configScan = new Scanner(conFile);
			
			int intValue ;
			intValue = Integer.parseInt(configScan.next(), 16);
			colorConfigs[0] = new Color(intValue);
			intValue = Integer.parseInt(configScan.next(), 16);
			colorConfigs[1] = new Color(intValue);
			intValue = Integer.parseInt(configScan.next(), 16);
			colorConfigs[2] = new Color(intValue);
			
			configScan.nextLine();
			
			starveConfigs[0] = configScan.nextInt();
			starveConfigs[1] = configScan.nextInt();
			starveConfigs[2] = configScan.nextInt();
			
			configScan.nextInt();
			
			breedConfigs[0] = configScan.nextInt();
			breedConfigs[1] = configScan.nextInt();
			breedConfigs[2] = configScan.nextInt();
			
			configScan.close();
			
			Configs.initConfigs(colorConfigs, starveConfigs, breedConfigs);
			
		} catch(FileNotFoundException e) {
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.simulator.SimulatorInterface#step()
	 */
	@Override
	public void step() {
		Animal[][] creature = simpleSystem.getMap();
		simpleSystem.enableTheLiving();
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
		return names;
	}
}
