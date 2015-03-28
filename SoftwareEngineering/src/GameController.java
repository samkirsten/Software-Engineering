import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface GameController {

    public boolean changeRedBrain();

    public boolean changeBlackBrain();

    public void generateNewMap();

    public Colour beginSingleGame(File brain1, File brain2);

    public HashMap<File,Integer> beginTournametGame(File brain1, File brain2, Tournament t);

    public List<List<File>> createFixtures(File brains);


}
