
public interface Map {

    public void generateMap();
    
    public Cell getCell(int x, int y);

    public void setCell(int x, int y, Cell cell);

    public Cell[][] getMap();



}


