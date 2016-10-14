package edu.ncsu.csc216.simulation.environment;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * Class representing an ecosystem.  Implements the EcoGrid interface.
 * Contains behavior for constructing, controlling, and navigating the ecosystem.
 * @author NBoar
 */
public class Ecosystem implements EcoGrid {

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
	
	/**
	 * Is the grid cell empty?
	 * @param l location of the cell on the grid
	 * @return true if there is no item in that cell.
	 */
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
	
	/**
	 * What is the Animal at a particular grid cell?
	 * @param l location of the cell on the grid
	 * @return the Animal at the given cell or null if the cell is empty
	 */
	public Animal getItemAt(Location l) {
		Animal a = map[l.getRow()][l.getCol()];
		return a;
	}
	
	/**
	 * Make a particular grid cell empty.
	 * @param l location of the cell on the grid
	 */
	public void remove(Location l) {
		map[l.getRow()][l.getCol()] = null;
	}
	
	/**
	 * Add an Animal to a particular grid cell.
	 * @param a Item to add
	 * @param l location of the cell on the grid
	 */
	public void add(Animal a, Location l) {
		map[l.getRow()][l.getCol()] = a;
	}
	
	/**
	 * Find the first cell in the grid that shares a border with the cell at
	 * the given position and that contains no Animal. Start looking in the
	 * given direction and continue clockwise around the cell.
	 * @param l The position to add the animal in.
	 * @param i Direction to start: 0 = west, 1 = north, 2 = east, 3 = south.
	 * @return the location for the first empty neighbor found, or null if none are found.
	 */
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
	
	/**
	 * What cell is due north of the given cell?
	 * @param l The given cell
	 * @return The cell due north
	 */
	public Location dueNorth(Location l) {
		int currentRow = l.getRow();
		int newRow = currentRow - 1;
		
		if (newRow == -1) {
			newRow = 19;
		}
		
		Location northCell = new Location(newRow, l.getCol());
		return northCell;
	}
	
	/**
	 * What cell is due south of the given cell?
	 * @param l The given cell
	 * @return The cell due south
	 */
	public Location dueSouth(Location l) {
		int currentRow = l.getRow();
		int newRow = currentRow + 1;
		
		if (newRow == 20) {
			newRow = 0;
		}
		
		Location southCell = new Location(newRow, l.getCol());
		return southCell;
	}
	
	/**
	 * What cell is due east of the given cell?
	 * @param l The given cell
	 * @return The cell due east
	 */
	public Location dueEast(Location l) {
		int currentCol = l.getCol();
		int newCol = currentCol + 1;
		
		if (newCol == 20) {
			newCol = 0;
		}
		
		Location eastCell = new Location(l.getRow(), newCol);
		return eastCell;
	}
	
	/**
	 * What cell is due west of the given cell?
	 * @param l The given cell
	 * @return The cell due west
	 */
	public Location dueWest(Location l) {
		int currentCol = l.getCol();
		int newCol = currentCol - 1;
		
		if (newCol == -1) {
			newCol = 19;
		}
		
		Location westCell = new Location(l.getRow(), newCol);
		return westCell;
	}
	
	/**
	 * What is in the grid?
	 * @return a snapshot of the grid, showing
	 *   the contents of each grid cell.
	 */
	public Animal[][] getMap() {
		return map;
	}
	
	/**
	 * Enable all live animals in the grid.
	 */
	public void enableTheLiving() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (map[i][j].isAlive()) {
					map[i][j].enable();
				}
			}
		}
	}
	
	/**
	 * Remove all dead animals from the grid.
	 */
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
