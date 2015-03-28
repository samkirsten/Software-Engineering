import java.io.File;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class TournamentImpl implements Tournament {

    private HashMap<File,Integer> resultsTable = new HashMap<File, Integer>();
    private Game game = new GameImpl();

    @Override
    public List<List<File>> createFixtures(List<File> brains) {
        List<List<File>> fixtures = new ArrayList<List<File>>();
        if (brains.size() == 4) {
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        List<File> f1 = new ArrayList<File>();
                        f1.add(brains.get(0));
                        f1.add(brains.get(1));
                        fixtures.add(f1);
                        break;
                    case 1:
                        List<File> f2 = new ArrayList<File>();
                        f2.add(brains.get(0));
                        f2.add(brains.get(2));
                        fixtures.add(f2);
                        break;
                    case 2:
                        List<File> f3 = new ArrayList<File>();
                        f3.add(brains.get(0));
                        f3.add(brains.get(3));
                        fixtures.add(f3);
                        break;
                    case 3:
                        List<File> f4 = new ArrayList<File>();
                        f4.add(brains.get(1));
                        f4.add(brains.get(2));
                        fixtures.add(f4);
                        break;
                    case 4:
                        List<File> f5 = new ArrayList<File>();
                        f5.add(brains.get(1));
                        f5.add(brains.get(3));
                        fixtures.add(f5);
                        break;
                    default:
                        List<File> f6 = new ArrayList<File>();
                        f6.add(brains.get(2));
                        f6.add(brains.get(3));
                        fixtures.add(f6);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        List<File> f1 = new ArrayList<File>();
                        f1.add(brains.get(0));
                        f1.add(brains.get(1));
                        fixtures.add(f1);
                        break;
                    case 1:
                        List<File> f2 = new ArrayList<File>();
                        f2.add(brains.get(0));
                        f2.add(brains.get(2));
                        fixtures.add(f2);
                        break;
                    default:
                        List<File> f3 = new ArrayList<File>();
                        f3.add(brains.get(1));
                        f3.add(brains.get(2));
                        fixtures.add(f3);
                }
            }
        }

        return fixtures;

    }


    @Override
    public HashMap<File,Integer> startTournamentGame(File brain1, File brain2) {
        HashMap<File,Integer> currentResults = new HashMap<File, Integer>();
        game.loadBrain(brain1,Colour.RED);
        game.loadBrain(brain2,Colour.BLACK);
        Colour winner = game.start();
        if(winner == null){
            resultsTable.put(brain1,resultsTable.get(brain1)+1);
            resultsTable.put(brain2,resultsTable.get(brain2)+1);
            currentResults.put(brain1,currentResults.get(brain1)+1);
            currentResults.put(brain2,currentResults.get(brain2)+1);

        }
        else if(winner == Colour.RED){
            resultsTable.put(brain1,resultsTable.get(brain1)+2);
            currentResults.put(brain1,currentResults.get(brain1)+2);

        }
        else{
            resultsTable.put(brain2,resultsTable.get(brain2)+2);
            currentResults.put(brain2,currentResults.get(brain2)+2);

        }

        game.loadBrain(brain1,Colour.BLACK);
        game.loadBrain(brain2,Colour.RED);
        winner = game.start();

        if(winner == null){
            resultsTable.put(brain1,resultsTable.get(brain1)+1);
            resultsTable.put(brain2,resultsTable.get(brain2)+1);
            currentResults.put(brain1,currentResults.get(brain1)+1);
            currentResults.put(brain2,currentResults.get(brain2)+1);
        }
        else if(winner == Colour.RED){
            resultsTable.put(brain2,resultsTable.get(brain2)+2);
            currentResults.put(brain2,currentResults.get(brain2)+2);

        }
        else{
            resultsTable.put(brain1,resultsTable.get(brain1)+2);
            currentResults.put(brain1,currentResults.get(brain1)+2);

        }

        return currentResults;
    }

    @Override
    public HashMap<File, Integer> getResults() {
        return resultsTable;
    }

}