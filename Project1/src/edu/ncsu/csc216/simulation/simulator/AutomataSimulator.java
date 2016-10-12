package edu.ncsu.csc216.simulation.simulator;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.IllegalFormatException;
import java.util.Scanner;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.actor.Configs;
import edu.ncsu.csc216.simulation.actor.PredatorPrey;
import edu.ncsu.csc216.simulation.actor.PurePredator;
import edu.ncsu.csc216.simulation.actor.PurePrey;
import edu.ncsu.csc216.simulation.environment.EcoGrid;
import edu.ncsu.csc216.simulation.environment.Ecosystem;
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
	private static final String SIZE_ERROR_MESSAGE = "Invalid Grid Size";
	private static final String THRESHOLD_ERROR_MESSAGE = "Invalid Number of Species";
	private String[] names;
	private int numberOfNames;
	private char[] symbol;
	private static final char EMPTY = '.';
	private EcoGrid simpleSystem;
	
	
	/**Constructor for the AutomataSimulator using default configurations.
	 * @param file The name of the initial population file.
	 */
	public AutomataSimulator(String filePath) {
		//A string to hold any line in the file
		String line;
		//Ecosystem initialized to be SIZExSIZE big
		simpleSystem = new Ecosystem(SIZE, SIZE);
		
		try {
			//Scans the input file
			Scanner fileScan = new Scanner(new File(filePath));
			
			//read in how many species there are
			numberOfNames = fileScan.nextInt();
			
			//initializes symbols and names array to the appropriate length
			symbol = new char[numberOfNames];
			names = new String[numberOfNames];
			
			//check to make sure there are more then two species
			if (numberOfNames < THRESHOLD) {
				fileScan.close();
				throw new IllegalArgumentException(THRESHOLD_ERROR_MESSAGE);
			}
			
			for (int i = 0; i < numberOfNames; i++) {
				symbol[i] = fileScan.next().charAt(0);
				names[i] = fileScan.nextLine();
			}
			
			for (int i = 0; i < SIZE; i++) {
				line = fileScan.nextLine();
				
				if (line.length() != SIZE) {
					fileScan.close();
					throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
				}
				
				for (int j = 0; j < SIZE; j++) {
					Animal a;
					Location l = new Location(i,j);
	
					if (line.charAt(j) == symbol[0]) {
						a = new PurePredator(line.charAt(j));
					}
					else if (line.charAt(j) == symbol[numberOfNames - 1]) {
						a = new PurePrey(line.charAt(j));
					}
					else {
						a = new PredatorPrey(line.charAt(j));
					}
					
					simpleSystem.add(a, l);
				}
				
				fileScan.close();
				
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Configs.setToDefaults();
		
		
	}
	
	/**Constructor for the AutomataSimulator with read-in configurations.
	 * @param file The name of the initial population file.
	 * @param config The name of the configuration file.
	 */
	public AutomataSimulator(String filePath, String configFilePath) {
		this(filePath);
		
		File configFile = new File(configFilePath);
		Color[] colorConfigs = {null, null, null};
		int[] starveConfigs = new int[3];
		int[] breedConfigs = new int[3];
		
		try {
			Scanner configScan = new Scanner(configFile);
			
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
