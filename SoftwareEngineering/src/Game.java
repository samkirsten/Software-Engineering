import java.io.File;
import java.util.List;

public interface Game {

    int NUMBER_OF_ROUNDS = 300000;


    public boolean loadBrain(File brain, Colour colour);

    public void setColony(Colony colony);

    public Colony getColony(Colour colour);

    public void setMap(Map map);

    public Map getMap();

    public void start();



    /**
     * R = Red win
     * B = Black win
     * D = Draw
     * @return R, B or D, depending on the outcome of the game.
     */
    public char getWinner();



}
