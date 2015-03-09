/**
 * Created by Jacob on 09/03/2015.
 */
public interface Ant {

    public int id = 0;
    public int state = 0;
    public int resting = 0;
    public int direction = 0;
    public boolean hasFood = false;

    public int getDirection();
    public int getState();
    public boolean isResting();
    public int getRemainingRest();
    public boolean hasFood();

}
