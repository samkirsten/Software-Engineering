public class CellImpl implements Cell {

    private char content = '.';
    private int getScentMark = 0;
    private Ant ant = null;

    public CellImpl() {                 // need to talk

    }

    public CellImpl(char content){
        this.content = content;
    }

    @Override
    public boolean isRocky() {
        if(content == '#'){
            return true;
        }
        return false;
    }

    @Override
    public int getScentMark() {
        return getScentMark;
    }

    @Override
    public char getContents() {
        return content;
    }

    @Override
    public Ant getAnt() {
        return ant;
    }

    @Override
    public void setScentMark(int mark) {
        getScentMark = mark;
    }

    @Override
    public void setContents(char content) {
        this.content = content;
    }

    @Override
    public void setAnt(Ant ant) {
        this.ant = ant;
    }
}