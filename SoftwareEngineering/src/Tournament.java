import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface Tournament {

    public void beginTournament(List<File> brains);

    public HashMap<File,Integer> getResults();
}
