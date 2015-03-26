import java.io.File;
import java.util.List;

public class GameImpl implements Game, Tournament {

    Colony red;
    Colony black;
    Map map;


    @Override
    public boolean loadBrain(File brain, Colour colour) {

        Brain brainClass = new BrainImpl();
        boolean passed = true;

        if(colour == Colour.RED){
            passed = brainClass.loadBrain(brain);
            if(passed){
                red.setBrain(brainClass);
            }
        }
        else{
            passed = brainClass.loadBrain(brain);
            if(passed){
                black.setBrain(brainClass);
            }
        }

        return passed;
    }

    @Override
    public void setColony(Colony colony) {
        if(colony.getColonyColour()==Colour.RED){
            red = colony;
        }
        else{
            black = colony;
        }
    }

    @Override
    public Colony getColony(Colour colour) {
        if(colour==Colour.RED){
            return red;
        }
        else{
            return black;
        }
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public void start() {
        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
            next();
        }
    }

    @Override
    public void next() {
        for(int i=0;i<red.getNumberOfAnts();i++){
            red.getBrain().step(i);
        }
        for (int i=0;i<black.getNumberOfAnts();i++){
            black.getBrain().step(i);
        }
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
        if(red.getFoodInColony()>black.getFoodInColony()){
            return 'R';
        }
        else if(black.getFoodInColony()>red.getFoodInColony()){
            return 'B';
        }
        else
            return 'D';
    }

    @Override
    public void beginTournament(List<File> brains) {

    }

    @Override
    public List<Result> getResults() {
        return null;
    }
}
