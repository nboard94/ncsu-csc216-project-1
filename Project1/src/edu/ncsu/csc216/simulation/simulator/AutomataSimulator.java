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
import edu.ncsu.csc216.simulation.environment.Ecosystem;
import edu.ncsu.csc216.simulation.environment.utils.Location;
import edu.ncsu.csc216.simulation.environment.utils.PaintedLocation;

/**
 * The AutomataSimulator receives the input files.
 * @author NBoar
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
	 * @param filePath The name of the initial population file.
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
				names[i] = symbol[i] + ": " + fileScan.nextLine().trim();
			}
			
			for (int i = 0; i < SIZE; i++) {
				line = fileScan.nextLine();
				
				if (line.length() != SIZE) {
					fileScan.close();
					throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
				}
				
				for (int j = 0; j < SIZE; j++) {
					Animal a;
					
					Location l = new Location(i, j);

					if (line.charAt(j) == symbol[0]) {
						a = new PurePredator(line.charAt(j));
					}
					else if (line.charAt(j) == '.') {
						a = null;
					}
					else if (line.charAt(j) == symbol[numberOfNames - 1]) {
						a = new PurePrey(line.charAt(j));
					}
					else {
						a = new PredatorPrey(line.charAt(j));
					}
					
					
					simpleSystem.add(a, l);
				}	
			}
				
			fileScan.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Configs.setToDefaults();
		
		
	}
	
	/**Constructor for the AutomataSimulator with read-in configurations.
	 * @param filePath The name of the initial population file.
	 * @param configFilePath The name of the configuration file.
	 */
	public AutomataSimulator(String filePath, String configFilePath) {
		this(filePath);
		
		Color[] colorSet = new Color[3];
		int[] starveTimeSet = new int[3];
		int[] breedTimeSet = new int[3];
		
		try {
			Scanner configScan = new Scanner(new File(configFilePath));
			
			colorSet[0] = Color.decode(configScan.next());
			colorSet[1] = Color.decode(configScan.next());
			colorSet[2] = Color.decode(configScan.next());
			
			starveTimeSet[0] = configScan.nextInt();
			starveTimeSet[1] = configScan.nextInt();
			starveTimeSet[2] = configScan.nextInt();
			
			breedTimeSet[0] = configScan.nextInt();
			breedTimeSet[1] = configScan.nextInt();
			breedTimeSet[2] = configScan.nextInt();

			configScan.close();
			
		} catch (FileNotFoundException e) {
			//TODO
			//LEFT BLANK
		}
		
		Configs.initConfigs(colorSet, starveTimeSet, breedTimeSet);
		
	}
	
	@Override
	public void step() {
		Animal[][] creature = simpleSystem.getMap();
		
		//Traverse the grid and enable all living animals
		for (int i = 0; i < SIZE; i++) {
			
			for (int j = 0; j < SIZE; j++) {
				
				if (creature[i][j] != null && creature[i][j].isAlive()) {
					creature[i][j].enable();
				}
			}
		}
		
		Location currentLoc;
		//Traverse the grid second time
		for (int i = 0; i < SIZE; i++) {
			
			for (int j = 0; j < SIZE; j++) {
				
				currentLoc = new Location(i, j);
				if (!simpleSystem.isEmpty(currentLoc)) {
					creature[i][j].act(currentLoc, simpleSystem);
				}
			}
		}
		
		//Traverse the grid and remove all dead animals
		simpleSystem.buryTheDead();
		
		
	}
	
	@Override
	public PaintedLocation[][] getView() {
		Animal[][] map = simpleSystem.getMap();
		Animal currentAnimal;
		PaintedLocation[][] view = new PaintedLocation[SIZE][SIZE];
		PaintedLocation currentLocToPaint;
		
		for (int i = 0; i < SIZE; i++) {
			
			for (int j = 0; j < SIZE; j++) {
				
				currentAnimal = map[i][j];
				
				if (currentAnimal == null) {
					currentLocToPaint = new PaintedLocation(i, j, Color.BLACK, EMPTY);
					view[i][j] = currentLocToPaint;
				}
				else if (currentAnimal != null && currentAnimal.getSymbol() != '.'){
					currentLocToPaint = new PaintedLocation(i, j, currentAnimal.getColor(), currentAnimal.getSymbol());
					view[i][j] = currentLocToPaint;
				}
			}
		}
		
		return view;
	}
	
	@Override
	public String[] getNames() {
		return names;
	}
}
