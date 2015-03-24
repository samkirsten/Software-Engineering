import java.io.File;
import java.util.HashMap;

/**
 * Created by Tina on 3/23/2015.
 */
public class ColonyImpl implements Colony {

    Colour colour ;
    HashMap<Integer,AntImpl> antList ;
    Brain brain ;
    int food ;
    int maxAnts ;
    int starting_id_index ;


    public ColonyImpl(Colour colour, Brain brain){

        this.colour = colour ;
        this.brain = brain ;

        food = 0 ;
        maxAnts = 49 ;

        //initialize ants
        if (colour == Colour.BLACK) {
            starting_id_index = 1 ;
        }else{
            starting_id_index = maxAnts +1 ;
        }

        //put ants into ant list
        for (int i = starting_id_index ; i <= (starting_id_index + maxAnts) ; i++){

            //******need anthill for position D:*****

            AntImpl ant = null;
            try {
                ant = new AntImpl(i, colour, new Position(1,1));
            } catch (PositionOutOfBoundsException e) {
                e.printStackTrace();
            }
            antList.put(i ,ant);
                    }

    }


     /**
     * Get an Ant object from the list of Ants stored in the given colony.
     *
     * @param pos The cell position of the ant to be found
     * @return The Ant at indicated position
     */
    @Override
    public AntImpl getAnt(Position pos) throws AntNotFoundException {

        AntImpl result = null ;

        //try to search for every ant in antlist
            for (int i = starting_id_index; i<starting_id_index + maxAnts ; i++){
                AntImpl ant = antList.get(i) ;
                if (ant.getPosition() == pos){
                    result = ant ;
                }
            }
        //if not found, throw exception, otherwise return the ant foudn
            if (result == null){
                throw new AntNotFoundException("*** Ant not found ***");
            }else {
                return result;
            }
    }

    /**
     * Get an Ant object from the list of Ants stored in the given colony.
     *
     * @param id the id of the ant to be found
     * @return The Ant with given id
     */
    @Override
    public AntImpl getAnt(int id) throws AntNotFoundException {
        boolean found = antList.containsKey(id) ;

        // if id not found , throw exception, otherwise return ant
        if (!found){
            throw new AntNotFoundException("*** Ant not found ***");
        }else{
            return antList.get(id) ;
        }
    }

    /**
     * Get the number of ants currently alive belonging to the colony
     *
     * @return Number of ants still alive
     */
    @Override
    public int getNumberOfAnts() {
        return antList.size();
    }

    /**
     * When given an ant id, will return true if specified ant is alive
     *
     * @param id ant id to check whether alive
     * @return true if ant alive, false otherwise
     */
    @Override
    public boolean isAntAlive(int id) {
        return antList.containsKey(id) ;
    }

    /**
     * Get the total amount of food held by the colony. This does not include food held by individual ants
     * belonging to the colony.
     *
     * @return Amount of food in colony
     */
    @Override
    public int getFoodInColony() {
        return food;
    }

    /**
     * Increments the total amount of food belonging to the colony by 1.
     * Invoked when an ant returns to the colony with food as it can only carry one particle at a time
     */
    @Override
    public void incrementFood() {
        food ++ ;
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
        return colour ;
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
