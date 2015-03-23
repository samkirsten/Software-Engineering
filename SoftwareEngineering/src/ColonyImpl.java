import java.io.File;
import java.util.HashMap;

/**
 * Created by Tina on 3/23/2015.
 */
public class ColonyImpl implements Colony {

    Colour colour ;
    HashMap<Integer,Ant> antList ;
    Brain brain ;
    int food ;
    int maxAnts ;

    public ColonyImpl(Colour colour, Brain brain){

        this.colour = colour ;
        this.brain = brain ;

        food = 0 ;
        maxAnts = 49 ;

        //initialize ants
        if (colour == Colour.BLACK) {
            for (int i=1;i<=maxAnts;i++){
                //******need anthill for position*****
                AntImpl ant = new AntImpl(i, colour, new Position(1,1));
                antList
            }
        }

    }


     /**
     * Get an Ant object from the list of Ants stored in the given colony.
     *
     * @param pos The cell position of the ant to be found
     * @return The Ant at indicated position
     */
    @Override
    public Ant getAnt(Position pos) throws AntNotFoundException {
        return null;
    }

    /**
     * Get an Ant object from the list of Ants stored in the given colony.
     *
     * @param id the id of the ant to be found
     * @return The Ant with given id
     */
    @Override
    public Ant getAnt(int id) throws AntNotFoundException {
        return null;
    }

    /**
     * Get the number of ants currently alive belonging to the colony
     *
     * @return Number of ants still alive
     */
    @Override
    public int getNumberOfAnts() {
        return 0;
    }

    /**
     * When given an ant id, will return true if specified ant is alive
     *
     * @param id ant id to check whether alive
     * @return true if ant alive, false otherwise
     */
    @Override
    public boolean isAntAlive(int id) {
        return false;
    }

    /**
     * Get the total amount of food held by the colony. This does not include food held by individual ants
     * belonging to the colony.
     *
     * @return Amount of food in colony
     */
    @Override
    public int getFoodInColony() {
        return 0;
    }

    /**
     * Increments the total amount of food belonging to the colony by 1.
     * Invoked when an ant returns to the colony with food as it can only carry one particle at a time
     */
    @Override
    public void incrementFood() {

    }

    /**
     * Load the colony with the given brain. This controls the behaviour of every ant in the colony.
     * The brain is fundamental to the operation of the colony and this method must be invoked before the game begins
     *
     * @param brain
     * @return true if brain successfully loaded into colony, false otherwise.
     */
    @Override
    public boolean loadBrain(File brain) {
        return false;
    }

    /**
     * Returns the brain which has been loaded into the colony
     *
     * @return the colony brain
     */
    @Override
    public File getBrain() {
        return null;
    }

    /**
     * Returns the colony colour, allowing differentiation between the two competing teams
     *
     * @return RED or BLACK
     */
    @Override
    public Colour getColonyColour() {
        return null;
    }

    /**
     * Removes ant belonging to this objects colony by removing it from the list of ants.
     * When an ant is killed it turns into 3 particles of food.
     * This method is invoked from the killEnemyAnt method in an Ant object
     *
     * @param p position of the ant to be killed
     */
    @Override
    public void remove(Position p) {

    }
}
