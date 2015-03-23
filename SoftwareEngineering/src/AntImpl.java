/**
 * Created by Tina on 3/23/2015.
 */
public class AntImpl implements Ant {

    public AntImpl(){

    }

    @Override
    //1-49 black, other is red
    public int getID() {
        return 0;
    }

    @Override
    public void setID(int id) {

    }

    /**
     * Gets the current direction that the ant is facing
     *
     * @return int representing current direction between 0 and 5 (inclusive)
     */
    @Override
    public int getDirection() {
        return 0;
    }

    /**
     * Sets the direction that the ant is facing
     *
     * @param direction The direction to set the ant as facing towards, between 0 and 5 (inclusive)
     */
    @Override
    public void setDirection(int direction) {

    }

    /**
     * Gets the current brain state that the ant is in, used by the Brain to compute the ant's next move
     *
     * @return int representing the current brain state
     */
    @Override
    public int getState() {
        return 0;
    }

    @Override
    public void setColour(Colour colour) {

    }

    @Override
    public Colour getColour() {
        return null;
    }

    /**
     * Set the current brain state of the ant, invoked by the brain in order to update the ant's
     * behaviour for the next turn
     *
     * @param state an int representing the current state of the brain
     */
    @Override
    public void setState(int state) {

    }

    /**
     * Returns whether the ant is resting. After an ant performs an action, it rests for 14 turns.
     *
     * @return true if ant is resting, false otherwise (if 0)
     */
    @Override
    public boolean isResting() {
        return false;
    }

    /**
     * Sets rest to 1. Which begins the rest period which lasts 14 turns.
     */
    @Override
    public void startResting() {

    }

    /**
     * Marks a scent at a cell when given a position and scent marker
     *
     * @param pos    the position of the cell
     * @param marker the scent marker
     */
    @Override
    public void markScent(Position pos, int marker) {

    }

    /**
     * Returns the amount of rest that the ant still requires before its next move. An ant rests for 14 turns
     *
     * @return int representing number of turns that the ant still must rest for before its next movement
     */
    @Override
    public int getRemainingRest() {
        return 0;
    }

    /**
     * Increments the ant's rest counter by 1. The counter ranges from 0-14, looping back after it has reached it's max
     * range. An ant can only perform a movement on turn 0.
     */
    @Override
    public void incrementRest() {

    }

    /**
     * Returns whether the ant is currently carrying food
     *
     * @return true if carrying food, false otherwise.
     */
    @Override
    public boolean hasFood() {
        return false;
    }

    @Override
    public void setHasFood(Boolean food) {

    }
}
