package com.model;

public class CellImpl implements Cell {

    private Content content = Content.EMPTY;
    private int getScentMark = 0;
    private Ant ant = null;
    private boolean dirty = true;
    private Content colony = null;

    public CellImpl() {                 // need to talk

    }

    public CellImpl(Content content){
        this.content = content;
    }

    @Override
    public boolean isRocky() {
        if(content == Content.ROCKY){
            return true;
        }
        return false;
    }

    @Override
    public int getScentMark() {
        return getScentMark;
    }

    @Override
    public Content getContents() {
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
    public void setContents(Content content) {
            this.content = content;
    }

    @Override
    public void setAnt(Ant ant) {
        this.ant = ant;
    }

    @Override
    public void setColonyCell(Content content) {
        colony = content;
    }

    @Override
    public Content isColonyCell() {
        return colony;
    }

    public void setDirty(){

        dirty = true;

    }
    public void setClean(){

        dirty = false;

    }

    public boolean isDirty(){
        return dirty;
    }
}