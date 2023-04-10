import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author David Shnaiderov - 209198308
 * Handles files.
 * User ID - shnaidd1
 */
public class ReadAndSave {
    /**
     * Finds Hypernyms.
     *
     * @param database database
     * @param corpus   corpus location
     */
    public void makeConnections(HypernymDatabase database, String corpus) {

        try {
            File folder = new File(corpus);
            File[] files = folder.listFiles();

            assert files != null;
            for (final File fileEntry : files) {
                Scanner myReader = new Scanner(fileEntry);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    PatternFinder finder = new PatternFinder();
                    finder.findPattern(data, database);
                }
                myReader.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
