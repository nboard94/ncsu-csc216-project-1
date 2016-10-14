package edu.ncsu.csc216.simulation.environment;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Class representing an ecosystem.  Implements the EcoGrid interface.
 * Contains behavior for constructing, controlling, and navigating the ecosystem.
 * @author NBoar
 */
public class Ecosystem implements EcoGrid{

	/** Amount of rows the ecosystem was constructed with.*/
	private int maxRows;
	/** Amount of columns the ecosystem was constructed with.*/
	private int maxColumns;
	/** Two-dimensional array that holds the location of animals within the ecosystem.*/
	Animal[][] map;
	
	/**
	 * Constructor to initialize the ecosystem.  Sets the rows
	 * and columns, as wells as initializes the map array to
	 * the correct dimensions.
	 * @param r Number of rows to initialize the ecosystem with.
	 * @param c Number of columns to initialize the ecosystem with.
	 */
	public Ecosystem(int r, int c) {
		maxRows = r;
		maxColumns = c;
		map = new Animal[maxRows][maxColumns];
	}
	
	public boolean isEmpty(Location l) {
		
		if (this.getItemAt(l) == null) {
			return true;
		}
		
		return false;
		
//		char symb = getItemAt(l).getSymbol();
//		
//		if (symb == '.') {
//			return true;
//		}
//		return false;
	}
	
	public Animal getItemAt(Location l) {
		Animal a = map[l.getRow()][l.getCol()];
		return a;
	}
	
	public void remove(Location l) {
		map[l.getRow()][l.getCol()] = null;
	}
	
	public void add(Animal a, Location l) {
		map[l.getRow()][l.getCol()] = a;
	}
	
	public Location findFirstEmptyNeighbor(Location l, int i) {
		Location emptyLoc;
		int numDirsLooked = 0;
		boolean elapsed = false;
		
		while (numDirsLooked < 4) {
			
			//look west
			if (i == 0 || elapsed) {
				emptyLoc = this.dueWest(l);
				if (this.isEmpty(emptyLoc)) {
					return emptyLoc;
				}
				numDirsLooked++;
			}
			
			//look north
			if (i == 1 || elapsed) {
				emptyLoc = this.dueNorth(l);
				if (this.isEmpty(emptyLoc)) {
					return emptyLoc;
				}
				numDirsLooked++;
			}
			
			//look east
			if (i == 2 || elapsed) {
				emptyLoc = this.dueEast(l);
				if (this.isEmpty(emptyLoc)) {
					return emptyLoc;
				}
				numDirsLooked++;
			}
			
			//look south
			if (i == 3 || elapsed) {
				emptyLoc = this.dueSouth(l);
				if (this.isEmpty(emptyLoc)) {
					return emptyLoc;
				}
				numDirsLooked++;
			}
			
			elapsed = true;
			
		}
		return null;
	}
	
	public Location dueNorth(Location l) {
		int currentRow = l.getRow();
		int newRow = currentRow - 1;
		
		if (newRow == -1) {
			newRow = 19;
		}
		
		Location northCell = new Location(newRow, l.getCol());
		return northCell;
	}
	
	public Location dueSouth(Location l) {
		int currentRow = l.getRow();
		int newRow = currentRow + 1;
		
		if (newRow == 20) {
			newRow = 0;
		}
		
		Location southCell = new Location(newRow, l.getCol());
		return southCell;
	}
	
	public Location dueEast(Location l) {
		int currentCol = l.getCol();
		int newCol = currentCol + 1;
		
		if (newCol == 20) {
			newCol = 0;
		}
		
		Location eastCell = new Location(l.getRow(), newCol);
		return eastCell;
	}
	
	public Location dueWest(Location l) {
		int currentCol = l.getCol();
		int newCol = currentCol - 1;
		
		if (newCol == -1) {
			newCol = 19;
		}
		
		Location westCell = new Location(l.getRow(), newCol);
		return westCell;
	}
	
	public Animal[][] getMap() {
		return map;
	}
	
	public void enableTheLiving() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (map[i][j].isAlive()) {
					map[i][j].enable();
				}
			}
		}
	}
	
	public void buryTheDead() {
		Location currentLoc;
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				
				currentLoc = new Location(i, j);
				if (map[i][j] != null && !map[i][j].isAlive()) {
					this.remove(currentLoc);
				}
			}
		}
	}
}
