import java.util.List;

public interface Colony {

    public enum Colour {RED,BLACK}

    public Colour colonyColour = null;
    public Brain brain = null;
    public List<Ant> ants = null;
    public int food = 0;
    public List<Position> hill = null;


    public Ant getAnt(Position pos);

    public Ant getAnt(int id);

    public boolean loadBrain(Brain brain);

    public Colour getColonyColour();







}
