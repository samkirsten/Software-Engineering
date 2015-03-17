import java.io.File;

public interface Brain {

    /**
     * Loads a brain from file. This controls the behaviour of every ant in the colony.
     * The brain is fundamental to the operation of the colony and this method must be invoked before the game begins
     * @param brain the brain to be loaded
     * @return  true if brain successfully loaded into colony, false otherwise.
     */
    public void loadBrain(File brain) throws BrainSyntaxIncorrectException;

    /**
     * Executes the next instruction for an ant. Should be invoked by the game
     * @param id the id of the ant
     */
    public void step(int id);


}
