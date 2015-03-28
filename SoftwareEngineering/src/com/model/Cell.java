package com.model;

import com.model.Ant;
import com.model.exceptions.AntNotFoundException;

public interface

        Cell {

    /**
     * If a com.model.Cell is rocky, an ant cannot move into it
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
     * Returns the contents of the com.model.Cell.
     * The return type is a char and can be later parsed to int
     * if the cell contains food.
     * @return char representing contents of cell
     */
    public char getContents();

    /**
    * Returns ant in the current com.model.Cell.
    * @return ant in the current cell
    */
    public Ant getAnt() throws AntNotFoundException;

    /**
     * Set Scent mark on the cell
    */
    public void setScentMark(int mark);

    /**
     * Set content on the cell
     */
    public void setContents(char content);

    /**
     * Set ant id on the cell
     * @param ant the ant to set at cell, null if removing ant from cell
     */
    public void setAnt(Ant ant);

}
