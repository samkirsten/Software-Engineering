/**
 * Created by Tina on 3/15/2015.
 */
public class Ant implements Ant_interface {

    public  int ID;
    public Colour color;
    public int state;
    public int resting;
    public int direction ;
    public boolean has_Food;

    public Ant(){
        resting =0;
    }

    @java.lang.Override
    public int getDirection() {
        return 0;
    }

    @java.lang.Override
    public void setDirection(int direction) {

    }

    @java.lang.Override
    public int getState() {
        return 0;
    }

    @java.lang.Override
    public void setState(int state) {

    }

    @java.lang.Override
    public boolean isResting() {
        return false;
    }

    @java.lang.Override
    public int getRemainingRest() {
        return 0;
    }

    @java.lang.Override
    public void incrementRest() {

    }

    @java.lang.Override
    public void killEnemyAnt(Position p) throws EnemyAntNotFoundException {

    }

    @java.lang.Override
    public boolean hasFood() {
        return false;
    }
}
