import java.io.FileWriter;
import java.io.IOException;

/**
 * @author David Shnaiderov - 209198308
 * Creates the Hypernym database:
 * args[0] - corpus location
 * args[1] - file output path
 * User ID - shnaidd1
 */
public class CreateHypernymDatabase {


    /**
     * Main function.
     *
     * @param args - args[0] - corpus location, args[1] - file output path
     */
    public static void main(String[] args) {
        String corpus = args[0];
        String output = args[1];
        CreateHypernymDatabase createHypernymDatabase = new CreateHypernymDatabase();
        HypernymDatabase database = createHypernymDatabase.createDatabase(corpus);
        int count = 0;


        database.sort();
        try {
            FileWriter myWriter = new FileWriter(output);
            for (Hypernym hypernym : database.getHypernyms().values()) {
                if (hypernym.getHyponymCount() < 3) {
                    count++;
                    continue;
                }
                myWriter.write(hypernym.getLemma() + ":" + hypernym.write() + "\n");
            }

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of Hypernyms: " + (database.getHypernyms().size() - count));
    }

    /**
     * Creates the database.
     *
     * @param corpus - corpus location
     * @return HypernymDatabase
     */
    public HypernymDatabase createDatabase(String corpus) {
        HypernymDatabase database = new HypernymDatabase();
        ReadAndSave readAndSave = new ReadAndSave();
        readAndSave.makeConnections(database, corpus);

        return database;
    }


}
