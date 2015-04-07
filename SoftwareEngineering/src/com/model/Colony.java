package com.model;

import com.model.exceptions.AntNotFoundException;

public interface Colony {

    /**
     * Get an Ant object from the list of Ants stored in the given colony.
     * @param pos The cell position of the ant to be found
     * @return The Ant at indicated position
     */
    public Ant getAnt(Position pos) throws AntNotFoundException;

    /**
     * Get an Ant object from the list of Ants stored in the given colony.
     * @param id the id of the ant to be found
     * @return The Ant with given id
     */
    public Ant getAnt(int id) throws AntNotFoundException;

    /**
     * Get the number of ants currently alive belonging to the colony
     * @return Number of ants still alive
     */
    public int getNumberOfAnts();

    /**
     * When given an ant id, will return true if specified ant is alive
     * @param id ant id to check whether alive
     * @return true if ant alive, false otherwise
     */
    public boolean isAntAlive(int id);

    /**
     * Get the total amount of food held by the colony. This does not include food held by individual ants
     * belonging to the colony.
     * @return Amount of food in colony
     */
    public int getFoodInColony();

    /**
     * Increments the total amount of food belonging to the colony by 1.
     * Invoked when an ant returns to the colony with food as it can only carry one particle at a time
     */
    public void incrementFood();

    /**
     * Load the colony with the given brain. This controls the behaviour of every ant in the colony.
     * The brain is fundamental to the operation of the colony and this method must be invoked before the game begins
     * @param brain
     */
    public void setBrain(Brain brain);


    /**
     * Returns the brain which has been loaded into the colony
     * @return the colony brain
     */
    public Brain getBrain();

    /**
     * Returns the colony colour, allowing differentiation between the two competing teams
     * @return RED or BLACK
     */
    public Colour getColonyColour();

    /**
     * Set the color of the colony
     * @param colour
     */
    public void setColonyColour(Colour colour);

    /**
     * Removes ant belonging to this objects colony by removing it from the list of ants.
     * When an ant is killed it turns into 3 particles of food.
     * This method is invoked from the killEnemyAnt method in an Ant object
     * @param id position of the ant to be killed
     */
    public void remove(int id) throws AntNotFoundException;

    /**
     * Add an Ant to the ant list
     * @param ant
     */
    public void addAnt(Ant ant);

    /**
     * Resets the states of an ant
     */
    public void reset();

}



