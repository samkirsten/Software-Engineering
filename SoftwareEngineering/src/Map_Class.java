
public class Map implements Map{

	private final Cell[][] getMap;
	private final int mapSize = 150;
	private final Colony black;
	private final Colony red;

	/**
     * Construct a new map, initialising default data for cells.
     */
	public Map(){
		getMap = new Cell[mapSize][mapSize];

		for(int x=0; x < mapSize; y++){
			for(int y = 0; y < height; y++){
				setCell(x,y, false);
			}
		}
	}

	/**
     * Set the given cell to rocky, or not.
     * @param x coordinate
     * @param y coordinate
     * @param rocky
     * @return True if successful, false if the attempted cell is out of bound
     */
	public boolean setCell(int x,int y,boolean isContents){
		if((x >= mapSize) || (y >= mapSize) || (x < 0) || (y < 0)){
			return false;
		}
		setCell(x,y,Cell.cellFactory(isContents));
		return true;
	}

	public void setCell(int x,int y,Cell c){
		getMap[x][y] = c;
	}

	/**
     * Get the Cell object at a given location
     * @param x coordinate
     * @param y coordinate
     * @return the Cell object
     */
	public Cell getCell(int x , int y){
		return getMap[x][y];
	}

	/**
     * @return the whether the cell at (x,y) is Rocky or not.
     */
	public boolean getCellIsRocky(int x,int y){
		return getMap[x][y].isRocky();
	}

	/**
     * Set the Cell at (x,y) to be Rocky
     */
	public void setRocky(int x,int y){
		getMap[x][y].setRocky(true);
	}

	/**
     * @return the whether the cell at (x,y) is Anthill or not.
     */
	public boolean getCellIsAntHill(int x,int y){
		return getMap[x][y].getAnt_Hill();
	}

//  public void setAntHill(int x,int y,Colony col){
//	
//  }

	/**
     * @return black ant hill
     */
	public Colony getBlack(){
		return black;
	}

	/**
     * @return red ant hill
     */
	public Colony getRed(){
		return red;
	}

	/**
     * set the Cell at (x,y) on food
     */
	public void setCellFood(int x,int y,int food){
		getMap[x][y].setFood(food);
	}

	/**
     * When a ant take a food from the Cell at (x,y)
     */
	public void takeFood(int x,int y){
		getMap[x][y].getFood() - 1;
	}
}















