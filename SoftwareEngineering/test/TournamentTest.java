import com.model.*;
import com.view.*;
import com.model.exceptions.CellAlreadyOccupiedException;
import com.model.exceptions.InvalidContentCharacterException;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


public class TournamentTest {

   @Test
   public void testCreateFixtures(){

       HashMap<String,File> test = new HashMap<>();
       List<Game> testList;

       File file1 = new File("brains/file.txt");
       File file2 = new File("brains/file1.txt");
       File file3 = new File("brains/file2.txt");
    //   File file4 = new File("brains/file3.txt");
       test.put("1",file1);
       test.put("2",file2);
       test.put("3",file3);
      // test.put("4",file4);

    //   GameGUI testGui = new GameGUI();



       Tournament testT = new TournamentImpl();

       testList= testT.createFixtures(test);

       assertEquals("1",testList.get(0).getRedPlayerName());



   }



}
