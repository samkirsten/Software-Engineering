
import java.io.File;
import java.util.List;

public class GameImpl implements Game {

    Colony red;
    Colony black;
    Map map;
    int redFood = 0;
    int blackFood = 0;
    int currentRound = 0;


    @Override
    public boolean loadBrain(File brain, Colour colour) {

        Brain brainClass = new BrainImpl(map,getColony(colour));
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
    public int getCurrentRound(){
        return currentRound;
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public Map getMap() {
        return map;
    }

    private void generateAnts(){


        List<Position> redHill = map.getAntHill(Colour.RED);
        List<Position> blackHill = map.getAntHill(Colour.BLACK);

        Colony redAnts = getColony(Colour.RED);
        Colony blackAnts = getColony(Colour.BLACK);
        redAnts.reset();
        blackAnts.reset();

        int id = 0;

        for(Position p : redHill){
           redAnts.addAnt(new Ant(id,p,Colour.RED));
            id++;
        }

        for(Position p : blackHill){
            blackAnts.addAnt(new Ant(id,p,Colour.BLACK));
            id++;
        }
    }


//    @Override
//    public void startTournamentGame() {
//
//
//        generateAnts();
//
//        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
//            next();
//        }
//
//        redFood = red.getFoodInColony();
//        blackFood = black.getFoodInColony();
//        map.clearMap();
//        Colony newBlack = red;
//        Colony newRed = black;
//        newBlack.setColonyColour(Colour.BLACK);
//        newRed.setColonyColour(Colour.RED);
//
//        generateAnts();
//
//        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
//            next();
//        }
//
//        redFood += newRed.getFoodInColony();
//        blackFood += newBlack.getFoodInColony();
//
//
//
//    }

    @Override
    public Colour start() {

        currentRound = 0;
        map.clearMap();

        generateAnts();

        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
            next();
            currentRound++;
        }

        redFood = red.getFoodInColony();
        blackFood = black.getFoodInColony();

        return getWinner();


    }

    private void next() {
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

    private Colour getWinner() {
        if(red.getFoodInColony()>black.getFoodInColony()){
            return Colour.RED;
        }
        else if(black.getFoodInColony()>red.getFoodInColony()){
            return Colour.BLACK;
        }
        else
            return null;
    }


}
