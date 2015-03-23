import tokens.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BrainImpl implements Brain {

    List<Token> brain[];
    public List<Token> lexedList = new ArrayList<>();


    BrainImpl(){

    }
    public List<Token> getLexedList(){ return lexedList;}

    private boolean lexBrain(String brain) {

        int length = brain.length();
        int i = 0;
        String tokenAsString = "";
        String delimiter = ";";
        if(brain.length()==0)
            return false;

        while(i<length){

            if(!Character.isWhitespace(brain.charAt(i))&&!brain.substring(i,i+1).equals(";")) {
                tokenAsString = tokenAsString + brain.substring(i, i + 1);
            }
            if(brain.substring(i,i+1).equals(";")&&!tokenAsString.isEmpty()) {
                try {
                    int n = Integer.parseInt(tokenAsString);
                    lexedList.add(new Int(n));
                    tokenAsString = "";
                } catch (NumberFormatException e) {
                    try {
                        lexedList.add(chooseToken(tokenAsString));
                        tokenAsString = "";
                    } catch (BrainSyntaxIncorrectException e1) {
                        System.out.println(e1);
                        return false;
                    }
                }
                lexedList.add(new Delimiter());
            }
            else if(Character.isWhitespace(brain.charAt(i))&&!tokenAsString.isEmpty()) {
                try {
                    int n = Integer.parseInt(tokenAsString);
                    lexedList.add(new Int(n));
                    tokenAsString = "";
                } catch (NumberFormatException e) {
                    try {
                        lexedList.add(chooseToken(tokenAsString));
                        tokenAsString = "";
                    } catch (BrainSyntaxIncorrectException e1) {
                        System.out.println(e1);
                        return false;
                    }
                }
            }
            i++;
        }


        return true;
    }

    private Token chooseToken(String tokenAsString) throws BrainSyntaxIncorrectException{
        Token token = null;
        switch (tokenAsString){
            case "Ahead": token = new Ahead();
                break;
            case "Drop": token = new Drop();
                break;
            case "Flip": token = new Flip();
                break;
            case "Foe": token = new Foe();
                break;
            case "FoeHome": token = new FoeHome();
                break;
            case "FoeWithFood": token = new FoeWithFood();
                break;
            case "FoeMarker": token = new FoeMarker();
                break;
            case "Food": token = new Food();
                break;
            case "Friend": token = new Friend();
                break;
            case "FriendWithFood": token = new FriendWithFood();
                break;
            case "Here": token = new Here();
                break;
            case "Home": token = new Home();
                break;
            case "Left": token = new Left();
                break;
            case "LeftAhead": token = new LeftAhead();
                break;
            case "Mark": token = new Mark();
                break;
            case "Marker": token = new Marker();
                break;
            case "Move": token = new Move();
                break;
            case "Right": token = new Right();
                break;
            case "RightAhead": token = new RightAhead();
                break;
            case "Rock": token = new Rock();
                break;
            case "Sense": token = new Sense();
                break;
            case "Turn": token = new Turn();
                break;
            case "Unmark": token = new Move();
                break;
            case "PickUp": token = new PickUp();
        }
        if(token!=null) {
            return token;
        }
        else
            throw new BrainSyntaxIncorrectException("Invalid Token!");
    }



    private boolean parseBrain() {

        try {
            List<Token> parsedList = parseInstruction(lexedList);
            if(parsedList.isEmpty())
                return true;
        } catch (BrainSyntaxIncorrectException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    private List<Token> parseInstruction(List<Token> tokens) throws BrainSyntaxIncorrectException {

        if (tokens.isEmpty()) {

        }
        else if (tokens.get(0) instanceof Sense){
            tokens.remove(0);
            tokens = parseSenseDir(tokens);
            tokens = parseSt(tokens);
            tokens = parseSt(tokens);
            tokens = parseCond(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Mark){
            tokens.remove(0);
            tokens = parseI(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Unmark){
            tokens.remove(0);
            tokens = parseI(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof PickUp){
            tokens.remove(0);
            tokens = parseSt(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Drop){
            tokens.remove(0);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Turn){
            tokens.remove(0);
            tokens = parseLr(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Move){
            tokens.remove(0);
            tokens = parseSt(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else if(tokens.get(0) instanceof Flip) {
            tokens.remove(0);
            tokens = parseP(tokens);
            tokens = parseSt(tokens);
            tokens = parseSt(tokens);
            tokens = parseDelim(tokens);
        }
        else
            throw new BrainSyntaxIncorrectException("Ill-formed Instruction");

        return tokens;

    }

    private List<Token> parseSenseDir(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if (tokens.get(0) instanceof Here){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Ahead){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof LeftAhead){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof RightAhead){
            tokens.remove(0);
        }
        else
            throw new BrainSyntaxIncorrectException("Ill-formed sensedir");

        return tokens;
    }

    private List<Token> parseCond(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if (tokens.get(0) instanceof Friend){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Foe){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof FriendWithFood){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof FoeWithFood){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Food){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Rock){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Marker){
            tokens.remove(0);
            tokens = parseI(tokens);
        }
        else if(tokens.get(0) instanceof FoeMarker){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Home){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof FoeHome){
            tokens.remove(0);
        }
        else
            throw new BrainSyntaxIncorrectException("Ill-formed cond");

        return tokens;
    }

    private List<Token> parseLr(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if(tokens.get(0) instanceof Left){
            tokens.remove(0);
        }
        else if(tokens.get(0) instanceof Right){
            tokens.remove(0);
        }
        else
            throw new BrainSyntaxIncorrectException("Ill-formed direction");

        return tokens;
    }

    private List<Token> parseSt(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if(tokens.get(0) instanceof Int){
            int x = ((Int) tokens.get(0)).n;
            if(x>= 0 && x <10000){
                tokens.remove(0);
            }
            else
                throw new BrainSyntaxIncorrectException("State out of range");
        }
        else
            throw new BrainSyntaxIncorrectException("State not found");

        return tokens;
    }

    private List<Token> parseI(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if(tokens.get(0) instanceof Int){
            int x = ((Int) tokens.get(0)).n;
            if(x >=0 && x <6){
                tokens.remove(0);
            }
            else
                throw new BrainSyntaxIncorrectException("I out of range");
        }
        else
            throw new BrainSyntaxIncorrectException("I not found");

        return tokens;
    }

    private List<Token> parseP(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if(tokens.get(0) instanceof Int){
            int x = ((Int) tokens.get(0)).n;
            if(x >0){
                tokens.remove(0);
            }
            else
                throw new BrainSyntaxIncorrectException("P out of range");
        }
        else
            throw new BrainSyntaxIncorrectException("P not found");

        return tokens;
    }

    private List<Token> parseDelim(List<Token> tokens) throws BrainSyntaxIncorrectException{
        if(tokens.get(0) instanceof Delimiter){
            tokens.remove(0);
            tokens = parseInstruction(tokens);
        }
        else
            throw new BrainSyntaxIncorrectException("No delimiter found");

        return tokens;
    }



    @Override
    public boolean loadBrain(File brain) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(String.valueOf(brain)));
            if(lexBrain(new String(encoded, StandardCharsets.UTF_8))){

                boolean passed =  parseBrain();
                System.out.println(passed);
                return passed;
            }
            else
                return false;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public void step(int id) {

    }

//
//
//    public static void main(String args[]) {
//        BrainImpl brain = new BrainImpl();
//        brain.loadBrain(new File("../brains/brain1.txt"));
//        for (Token t : brain.lexedList ){
//            System.out.println(t.getClass().toString());
//        }
//
//
//    }



}
