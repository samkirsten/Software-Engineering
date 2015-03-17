
public class Cell_Class implements Cell {
	
	private boolean rocky;
	private boolean ant_hill;
	private boolean ant; //  boolean or Ant type.
	private int food;
	private int sentMark; // (0-6) Black, (6-12) Red

	public Cell(){
		rocky = false;
		ant_hill = false;
		ant = false;
		food = 0;
		sentMark = 0;
	}

	/**
     * Set a cell rocky
     * @param rocky
     */
	public void setRocky(boolean rocky){
		rocky = b;
	}

	/**
     * @return whether this cell is rocky
     */
	public boolean isRocky(){
		return rocky;
	}

	/**
     * Set a cell to anthill
     * @param ant_hill
     */
	public void setAnt_Hill(boolean ant_hill){
		this.ant_hill = ant_hill;
	}

	/**
     * @return whether this cell is anthill
     */
	public boolean getAnt_Hill(){
		return ant_hill;
	}
	
	/**
     * Create a Cell with the relevant rocky characteristic
     * @param rocky
     * @return c    // new cell
     */
	public static Cell cellFactory(boolean rocky){
		Cell c = new Cell();
		c.setRocky(rocky);
		return c;
	} 

	/**
     * @return food
     */
	public int getFood(){
		return food;
	}

	/**
 	 * Set food
     * @param food
     */
	public void setFood(int food){
		this.food = food;
	}

	/**
     * return the integer of makring (0-6) : block, (6-12) : Red
     * @return sentMark
     */
	public int getMark(){
		return sentMark;
	}

	/**
     *	set mark
     *	@param mark;
     */
	public void setMark(int mark){
		sentMark = mark;
	}
}