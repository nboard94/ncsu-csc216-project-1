package edu.ncsu.csc216.simulation.environment;

import edu.ncsu.csc216.simulation.actor.Animal;
import edu.ncsu.csc216.simulation.environment.utils.Location;

/**
 * @author NBoar
 *
 */
public class Ecosystem implements EcoGrid{

	private int maxRows;
	private int maxColumns;
	Animal[][] map = new Animal[maxRows][maxColumns];
	
	public Ecosystem(int r, int c) {
		maxRows = r;
		maxColumns = c;
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#isEmpty(edu.ncsu.csc216.simulation.environment.utils.Location)
	 */
	public boolean isEmpty(Location l) {
		char symb = getItemAt(l).getSymbol();
		
		if (symb == '.') {
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#getItemAt(edu.ncsu.csc216.simulation.environment.utils.Location)
	 */
	public Animal getItemAt(Location l) {
		Animal a = map[l.getRow()][l.getCol()];
		return a;
	}
	
	//nyi
	public void remove(Location l) {
		map[l.getRow()][l.getCol()] = null;
	}
	
	//nyi
	public void add(Animal a, Location l) {
		map[l.getRow()][l.getCol()] = a;
	}
	
	//nyi
	public Location findFirstEmptyNeighbor(Location l, int i) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#dueNorth(edu.ncsu.csc216.simulation.environment.utils.Location)
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
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#dueSouth(edu.ncsu.csc216.simulation.environment.utils.Location)
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
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#dueEast(edu.ncsu.csc216.simulation.environment.utils.Location)
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
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#dueWest(edu.ncsu.csc216.simulation.environment.utils.Location)
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
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#getMap()
	 */
	public Animal[][] getMap() {
		return map;
	}
	
	/* (non-Javadoc)
	 * @see edu.ncsu.csc216.simulation.environment.EcoGrid#enableTheLiving()
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
	
	//nyi
	public void buryTheDead() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (!map[i][j].isAlive()) {
					//this.remove(map[i][j]);
				}
			}
		}
	}
}
