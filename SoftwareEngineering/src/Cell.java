
public interface Cell {

    public Position position = null;
    public byte contents = 0;
    public int scentMark = 0; // (0-6) black (6-12) red

    public Position getPosition();

    public boolean isRocky();










}
