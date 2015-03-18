
public interface Cell {

    /**
     * If a Cell is rocky, an ant cannot move into it
     * @return true if cell is rocky, false otherwise
     */
    public boolean isRocky();

    /**
     * Returns the scent mark at the given cell.
     * (1-7) are black colony scents (7-13) are red. 0 if no
     * scent marker has been placed.
     * @return int representing given scent mark
     */
    public int getScentMark();

    /**
     * Returns the contents of the Cell.
     * The return type is a char and can be later parsed to int
     * if the cell contains food.
     * @return char representing contents of cell
     */
    public char getContents();

    /**
    * Returns the ID of the ant in the current Cell.
    * @return int representing ID of ant, -1 if no ant present
    */
    public int getAnt();

    /**
     * Set rocky on the cell
     * @param bol rocky or not.
     */
    public void setRocky(boolean rocky);

    /**
     * Set Scent mark on the cell
     * @param int mark.
     */
    public void setScentMark(int mark);

    /**
     * Set content on the cell
     * @param char content
     */
    public void setContents(char content);

    /**
     * Set ant id on the cell
     * @param int ant id.
     */
    public void setAnt(int ant);

}
