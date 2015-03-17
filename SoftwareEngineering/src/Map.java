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

    public int getAntAtCell(Position pos);

    public void setAntAtCell(Position pos, int antId);

    public void setCellIsRocky(Position pos, boolean rocky);

    public void setCellContents(Position pos, char contents);

    public void setCellScentMarker(Position pos, int marker);





}


