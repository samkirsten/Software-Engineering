
public interface Map {

    public int[][] Cell = null;
    public int sizeX = 0;
    public int sizeY = 0;

    public void generateMap();
    
    public Cell getCell(int x, int y);

    public void setCell(int x, int y, Cell cell);




}


