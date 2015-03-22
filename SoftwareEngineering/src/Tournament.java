import java.io.File;
import java.util.List;

public interface Tournament {

    public void beginTournament(List<File> brains);

    public List<Result> getResults();
}
