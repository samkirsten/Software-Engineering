package com.model;

import java.util.*;
import com.model.exceptions.*;

public class MapImpl implements Map{

    private CellImpl[][] map = new CellImpl[150][150];
    private CellImpl[][] spairMap = new CellImpl[150][150];
    private ArrayList<Position> RED = new ArrayList<>();
    private ArrayList<Position> BLACK = new ArrayList<>();
    private ArrayList<CellImpl> REDHILL = new ArrayList<>();
    private ArrayList<CellImpl> BLACKHILL = new ArrayList<>();
    private ArrayList<CellImpl> Foodblob = new ArrayList<>();
    private ArrayList<CellImpl> Rocky = new ArrayList<>();
    public  List<Position> dirtyList = new ArrayList<>();

    public MapImpl(){
        emptyMap();

    }
    
    private Position createPosition(int x, int y) throws PositionOutOfBoundsException {
        if((x < 0 || x > 149) || (y < 0 || y > 149)){
            throw new PositionOutOfBoundsException("The position is out of bound");
        }
        Position result = new Position(x,y);
        return result;
        
    }

    public void emptyMap(){
        for(int y = 0; y < 150; y++) {
            for (int x = 0; x < 150; x++) {
                map[x][y] = new CellImpl();


            }
        }
    }
    
    @Override
    public void generateMap() {
        for(int y = 0; y < 150; y++){
            for(int x = 0; x < 150; x++){
                dirtyList.add(new Position(x,y));
             //   map[x][y].setDirty();
                if( x == 0 || x == 149 || y == 0 || y == 149 ){
                    map[x][y] = new CellImpl(Content.ROCKY);                      // The edge of com.model.Map
                    Rocky.add(map[x][y]);
                    spairMap[x][y] = new CellImpl();
                }else{
                    map[x][y] = new CellImpl();
                    spairMap[x][y] = new CellImpl();
                }
            }
        }   // Setting a map.

        Random ran = new Random();

        //div1
        int x = (ran.nextInt(66)+5)*2 - 1;
        int div1 = (ran.nextInt(30)+5)*2 - 1;

        //div2
        int x1 = (ran.nextInt(66)+5)*2 - 1;
        int div2 = (ran.nextInt(30)+42)*2 - 1;

        int color = ran.nextInt(2);
        if(color == 0){
            generateAntHill(x,div1, Colour.BLACK);
            generateAntHill(x1,div2, Colour.RED);
        }
        if(color == 1) {
            generateAntHill(x, div1, Colour.RED);
            generateAntHill(x1, div2, Colour.BLACK);
        } // setting anthill;

        //
        int foodblob = 0;
        while(foodblob != 11){
            int foodX = 0, foodY = 0;
            int food = ran.nextInt(2);
            if(food == 0){  // x , y  are even
                foodX = (ran.nextInt(71) + 1) * 2;
                foodY = (ran.nextInt(71) + 1) * 2;
            }
            else if(food == 1){  // x , y  are odd
                foodX = (ran.nextInt(71) + 2) * 2 + 1;
                foodY = (ran.nextInt(71) + 1) * 2 + 1;
            }

            if(checkCell(foodX,foodY,food)){
                generateFoodBlob(foodX,foodY,food);
                foodblob++;
            }
        }

        int rock = 0;
        while(rock != 14){
            int X = (ran.nextInt(149) + 1);
            int Y = (ran.nextInt(149) + 1);
            if(map[X][Y].getContents() == Content.EMPTY){
                map[X][Y].setContents(Content.ROCKY);
                Rocky.add(map[X][Y]);
                rock++;
            }
        }

        for(int xx = 0; xx < 150; xx++) {
            for (int yy = 0; yy < 150; yy++) {
                spairMap[xx][yy].setContents(map[xx][yy].getContents());
            }
        }


    }

    private void generateAntHill(int x,int y, Colour colour){
        Content team;
        CellImpl cell, cell1;
        int aa = 0;
        if(colour == Colour.BLACK){
            team = Content.BLACKHILL;
        }else{
            team = Content.REDHILL;
        }
        for(int a = 0; a < 7; a++){
            for(int i = 0; i < 7 + a; i++){
                if(a != 6){
                    cell = map[x+i-(a/2)][y-6+a];
                    cell.setContents(team);
                    cell1 = map[x+i-(a/2)][y+6-a];
                    cell1.setContents(team);
                    if(team == Content.BLACKHILL){
                        try {
                            BLACK.add(createPosition(x+i-(a/2),y-6+a));
                            BLACK.add(createPosition(x+i-(a/2),y+6-a));
                            BLACKHILL.add(cell);
                            BLACKHILL.add(cell1);
                            cell.setColonyCell(Content.BLACKHILL);
                            cell1.setColonyCell(Content.BLACKHILL);
                            System.out.println(aa++);
                            System.out.println(aa++);
                        } catch (PositionOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }else if(team == Content.REDHILL){
                        try {
                            RED.add(createPosition(x+i-(a/2),y-6+a));
                            RED.add(createPosition(x+i-(a/2),y+6-a));
                            REDHILL.add(cell);
                            REDHILL.add(cell1);
                            cell.setColonyCell(Content.REDHILL);
                            cell1.setColonyCell(Content.REDHILL);
                        } catch (PositionOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }else{  // a == 6
                    cell = map[x+i-(a/2)][y-6+a];
                    cell.setContents(team);
                    if(team == Content.BLACKHILL){
                        try {
                            BLACK.add(createPosition(x+i-(a/2),y-6+a));
                            BLACKHILL.add(cell);
                            System.out.println(aa++);
                            cell.setColonyCell(Content.BLACKHILL);
                        } catch (PositionOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }else if(team == Content.REDHILL){
                        try {
                            RED.add(createPosition(x+i-(a/2),y-6+a));
                            REDHILL.add(cell);
                            cell.setColonyCell(Content.REDHILL);
                        } catch (PositionOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void generateFoodBlob(int x, int y, int Case){
        if(Case == 1){
            for(int a = 0; a < 5 ; a++){
                for(int b = 0; b < 5; b++){
                    map[x+b-(a/2)][y+a].setContents(Content.FIVE);
                    Foodblob.add(map[x+b-(a/2)][y+a]);
                }
            }
        }

        if(Case == 0){
            for(int a = 0; a < 5 ; a++){
                for(int b = 0; b < 5; b++){
                    map[x+b+(a/2)][y+a].setContents(Content.FIVE);
                    Foodblob.add(map[x+b+(a/2)][y+a]);
                }
            }
        }
    }

    private boolean checkCell(int x, int y, int Case){
        boolean result = true;

        if(Case == 1){  // left side
            for(int a = 0; a < 5; a ++) {
                for (int b = 0; b < 5; b++) {
                    if(map[x+b-(a/2)][y+a].getContents() != Content.EMPTY || Foodblob.contains(map[x+b-(a/2)][y+a]) || REDHILL.contains(map[x+b-(a/2)][y+a]) || BLACKHILL.contains(map[x+b-(a/2)][y+a])){
                        result = false;
                        break;
                    }
                }
            }
        }

        else if(Case == 0){
            for(int a = 0; a < 5; a ++) {
                for (int b = 0; b < 5; b++) {
                    if(map[x+b+(a/2)][y].getContents() != Content.EMPTY || Foodblob.contains(map[x+b+(a/2)][y+a])|| REDHILL.contains(map[x+b+(a/2)][y+a]) || BLACKHILL.contains(map[x+b+(a/2)][y+a]) ){
                        result = false;
                        break;
                    }
                }
            }            // right side
        }

        return result;
    }


    @Override
    public void clearMap() {
        map = spairMap;
    }

    @Override
    public boolean getCellIsRocky(Position pos) {
        return map[pos.getX()][pos.getY()].isRocky();
    }

    @Override
    public Content getCellContents(Position pos) {
        return map[pos.getX()][pos.getY()].getContents();
    }

    @Override
    public int getCellScentMarker(Colour colourOfQueryingAnt, Position pos) { // swapped it around
        int value = 0;

        if(colourOfQueryingAnt == Colour.RED && map[pos.getX()][pos.getY()].getScentMark() < 7 ){
            value = map[pos.getX()][pos.getY()].getScentMark();
        }

         if(colourOfQueryingAnt == Colour.RED && map[pos.getX()][pos.getY()].getScentMark() > 6 ){

            value = -1;
        }

         if(colourOfQueryingAnt == Colour.BLACK && map[pos.getX()][pos.getY()].getScentMark() < 7 ){

                 value = -1;

        }

         if(colourOfQueryingAnt == Colour.BLACK && map[pos.getX()][pos.getY()].getScentMark() > 6 ){
            value = map[pos.getX()][pos.getY()].getScentMark();
        }
        if(map[pos.getX()][pos.getY()].getScentMark() == 0){
            value =0;
        }

        return value;
    }

    @Override
    public Ant getAntAtCell(Position pos) {
        return map[pos.getX()][pos.getY()].getAnt();
    }

    @Override
    public int getAdjacentEnemyAnts(Position pos, Colour colour) {
        int number = 0;
        if(pos.getY() % 2 == 1){
            if(map[pos.getX()][pos.getY()-1].getAnt() == null){
            }
            else if(map[pos.getX()][pos.getY()-1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()+1][pos.getY()-1].getAnt() == null){
            }
            else if(map[pos.getX()+1][pos.getY()-1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()- 1][pos.getY()].getAnt() == null) {
            }
            else if(map[pos.getX()-1][pos.getY()].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()+1][pos.getY()].getAnt() == null){
            }
            else if(map[pos.getX()+1][pos.getY()].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()][pos.getY()+1].getAnt() == null ){
            }
            else if(map[pos.getX()][pos.getY()+1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()+1][pos.getY()+1].getAnt() == null){
            }
            else if(map[pos.getX()+1][pos.getY()+1].getAnt().getColour() == colour){
                number++;
            }

        }

        if(pos.getY() % 2 == 0){
            if(map[pos.getX()-1][pos.getY()-1].getAnt() == null){
            }
            else if(map[pos.getX()-1][pos.getY()-1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()][pos.getY()-1].getAnt() == null){
            }
            else if(map[pos.getX()][pos.getY()-1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()-1][pos.getY()].getAnt() == null){
            }
            else if(map[pos.getX()-1][pos.getY()].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()+1][pos.getY()].getAnt() == null){
            }
            else if(map[pos.getX()+1][pos.getY()].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()-1][pos.getY()+1].getAnt() == null){
            }
            else if(map[pos.getX()-1][pos.getY()+1].getAnt().getColour() == colour){
                number++;
            }
            if(map[pos.getX()][pos.getY()+1].getAnt() == null){
            }
            else if(map[pos.getX()][pos.getY()+1].getAnt().getColour() == colour){
                number++;
            }
        }


        return number;
    }

    @Override
    public List<Position> getAntHill(Colour colour) {
        if(colour == Colour.BLACK){
            return BLACK;
        }
        return RED;
    }

    @Override
    public void setAntAtCell(Position pos, Ant ant) throws CellAlreadyOccupiedException {

        if(map[pos.getX()][pos.getY()].getAnt() != null){
            throw new CellAlreadyOccupiedException("There is com.model.Ant already.");
        }else{
            map[pos.getX()][pos.getY()].setAnt(ant);
            ant.setPosition(pos);
          //  setDirty(pos);

            map[pos.getX()][pos.getX()].setDirty();


        }

    }

    @Override
    public void setCellContents(Position pos, Content contents) throws InvalidContentCharacterException {
        if(contents == Content.EMPTY ||
                contents == Content.ROCKY ||
                contents == Content.REDHILL ||
                contents == Content.BLACKHILL ||
                contents == Content.ONE ||
                contents == Content.TWO ||
                contents == Content.THREE ||
                contents == Content.FOUR ||
                contents == Content.FIVE ||
                contents == Content.SIX ||
                contents == Content.SEVEN ||
                contents == Content.EIGHT ||
                contents == Content.NINE){
            map[pos.getX()][pos.getY()].setContents(contents);
            setDirty(pos);
            map[pos.getX()][pos.getY()].setDirty();
        }else{
            throw new InvalidContentCharacterException(contents + " is not available contents");
        }
    }

    @Override
    public void setCellScentMarker(Position pos, int marker) {

        map[pos.getX()][pos.getY()].setScentMark(marker);
    }

    @Override
    public Cell[][] getMap() {
        return map;
    }

    @Override
    public void clearAnt(Position pos){

        map[pos.getX()][pos.getY()].setAnt(null);
        setDirty(pos);
        map[pos.getX()][pos.getY()].setDirty();

    }

    @Override
    public void setDirty(Position p) {

        dirtyList.add(p);

    }

    @Override
    public List<Position> getDirty() {

        return dirtyList;
    }


    //For test
    public int getArray(String name){
        if(name == "food"){
            return Foodblob.size();
        }else if(name == "red"){
            return REDHILL.size();
        }else if(name == "rocky"){
            return Rocky.size();
        }
        return BLACKHILL.size();
    }


}
