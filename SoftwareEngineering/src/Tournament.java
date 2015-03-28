import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface Tournament {

    public List<List<File>> createFixtures(List<File> brains);

    public HashMap<File,Integer> startTournamentGame(File brain1, File brain2);

    public HashMap<File,Integer> getResults();
}
