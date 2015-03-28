

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
* Created by Jacob on 28/03/2015.
*/
public class ControllerImpl implements GameController {

    @Override
    public Colour beginSingleGame(File brain1, File brain2, Game game) {
        game.loadBrain(brain1,Colour.RED);
        game.loadBrain(brain2,Colour.BLACK);
        return game.start();
    }

    @Override
    public HashMap<File, Integer> beginTournametGame(File brain1, File brain2, Tournament t) {



        return t.startTournamentGame(brain1,brain2);
    }

    @Override
    public List<List<File>> createFixtures(File brains, Tournament t) {
        return null;
    }
}

