import java.io.File;
import java.util.List;

public class GameImpl implements Game, Tournament {

    Colony red;
    Colony black;



    @Override
    public boolean loadBrain(File brain, Colour colour) {
        return false;
    }

    @Override
    public void setColony(Colony colony, List<Position> anthill) {

    }

    @Override
    public Colony getColony(Colour colour) {
        return null;
    }

    @Override
    public void setMap(Map map) {

    }

    @Override
    public Map getMap() {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void next() {

    }

    /**
     * R = Red win
     * B = Black win
     * D = Draw
     *
     * @return R, B or D, depending on the outcome of the game.
     */
    @Override
    public char getWinner() {
        return 0;
    }

    @Override
    public void beginTournament(List<File> brains) {

    }

    @Override
    public List<Result> getResults() {
        return null;
    }
}
