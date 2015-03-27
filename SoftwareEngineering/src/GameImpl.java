import java.io.File;
import java.util.List;

public class GameImpl implements Game {

    Colony red;
    Colony black;
    Map map;
    int redFood = 0;
    int blackFood = 0;



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

    private void generateAnts(Colour c){


        List<Position> hill = map.getAnthill(c);
        int smallestX = 150;
        int smallestY = 150;
        Colony colony = getColony(c);
        colony.clearAnts();
        int id = 1;
        if(c==Colour.BLACK)
            id = 164;

        for(Position p : hill){
            if(p.getY()<smallestY){
                smallestY = p.getY();
            }

            if(p.getY() == smallestY){
                if(p.getX()<smallestX){
                    smallestX = p.getX();
                }
            }
        }

        int start = 7;

        for(int i =0; i < 7; i++){
             for(int j=0; j<start; j++){
                 colony.addAnt(new AntImpl(id,c,new Position(smallestX,smallestY)));
                 id++;
                 smallestX++;
             }
            start = start +2;
            smallestY++;
        }


        for(int i =0; i < 6; i++){
            for(int j=0; j<start; j++){
                colony.addAnt(new AntImpl(id,c,new Position(smallestX,smallestY)));
                id++;
                smallestX++;
            }
            start = start -2;
            smallestY++;
        }





    }

    /**
     *
     * ADD IN GLOBAL RESET METHOD FOR COLONY
     * REMOVE COLONY HASHMAP LIST FROM CONSTRUCTOR PARAM
     * ADD CONSTRUCTOR PARAMS BACK TO ANT IMPL
     * FIX THE FUCKING GENERATE ANT METHOD
     */
    @Override
    public void start() {

        generateAnts(Colour.RED);
        generateAnts(Colour.BLACK);

        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
            next();
        }

        map.clearMap();
        black = red;
        black.setColonyColour(Colour.BLACK);
        red = black;
        red.setColonyColour(Colour.RED);

        generateAnts(Colour.RED);
        generateAnts(Colour.BLACK);

        for(int i = 0; i<Game.NUMBER_OF_ROUNDS;i++){
            next();
        }

        redFood = red.getFoodInColony();
        blackFood = black.getFoodInColony();



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


}
