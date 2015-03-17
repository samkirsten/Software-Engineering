/**
 * The concrete map class implementation will have Cell getters and setters
 * but these are not public as they are not necessary to know from the
 * outside world and are therefore omitted from the interface API.
 */

public interface Map {

    /**
     * Generates a pseudo-random map which is 150x150 in size
     */
    public void generateMap();

    /**
     * Returns whether the cell at a given position is Rocky.
     * Ants cannot traverse rocky cells
     * @param pos the position of the cell
     * @return true if the cell is rocky, false otherwise.
     */
    public boolean getCellIsRocky(Position pos);

    /**
     * Gets the contents of a cell at a given position.
     * @param pos the position of the cell
     * @return char representing the contents of the cell
     */
    public char getCellContents(Position pos);

    /**
     * Gets the scent marker of a cell at a given position.
     * If the scent marker is
     * @param colourOfQueryingAnt the colour of the colony the querying ant belongs to
     * @param pos the position of the cell
     * @return The scent marker at the given cell. (1-7) are black colony scents
     * (7-13) are red. 0 if no scent marker has been placed.
     *
     * IF THE COLOUR OF THE QUERYING ANT IS ENEMY TO THE SCENT MARKER STORED IN THE CELL,
     * THEN THIS METHOD WILL RETURN -1
     */
    public int getCellScentMarker(Colour colourOfQueryingAnt, Position pos);

    /**
     * Gets the ant at the cell with given position. Returns 0 if cell contains no ant.
     * @param pos the position of the cell
     * @return id of ant at given position
     */
    public int getAntAtCell(Position pos);

    /**
     * Sets the given cell to contain an ant specified with an ant id.
     * @param pos the position of the cell
     * @param antId the id of the ant
     * @throws CellAlreadyOccupiedException if the cell already contains an ant.
     */
    public void setAntAtCell(Position pos, int antId) throws CellAlreadyOccupiedException;

    /**
     * Sets given cell to be rocky, if a cell is rocky it cannot be traversed by an ant.
     * @param pos the position of the cell
     * @param rocky set to true if cell is to be rocky, false otherwise
     */
    public void setCellIsRocky(Position pos, boolean rocky);

    /**
     * Sets the contents of a cell, requires a single character which specifies the contents
     * @param pos the position of the cell
     * @param contents the character representing contents of the cell
     */
    public void setCellContents(Position pos, char contents) throws InvalidContentCharacterException;

    /**
     * Sets the scent marker of a cell
     * @param pos the position of the cell
     * @param marker the value representing the scent mark. int between 1 (inclusive) and 13 (exclusive). Use 0 to remove the scent
     */
    public void setCellScentMarker(Position pos, int marker);

}


