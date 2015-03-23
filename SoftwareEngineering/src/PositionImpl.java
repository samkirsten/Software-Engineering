
public class PositionImpl implements Position  {

    private int x;
    private int y;

    PositionImpl(int x, int y) throws PositionOutOfBoundsException {
        if((x < 0 || x > 149) || (y < 0 || x > 149)){
            throw new PositionOutOfBoundsException("The position is out of bound");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws PositionOutOfBoundsException {
        if(x < 0 || x > 149){
            throw new PositionOutOfBoundsException("The position of X is out of bound");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws PositionOutOfBoundsException {
        if(y < 0 || y > 149){
            throw new PositionOutOfBoundsException("The position of Y is out of bound");
        }
        this.y = y;
    }
}
