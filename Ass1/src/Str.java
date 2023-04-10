
/**
 * @author David Shnaiderov - 209198308 *
 * Task 3
 * User ID - shnaidd1
 */
public class Str {
    public static final int MAX_PARAM = 2;
    public static final String DIVIDER = "_";

    /**
     * @param args - Received arguments.
     *             Prints any word the starts with the query.
     *             Then print any word the contains the query.
     */
    public static void main(String[] args) {
        //Validates input format
        if (!checkInput(args)) {
            return;
        }
        String query = args[0];
        String sentence = args[1];
        //arr of strings, split by the specified delimiter
        String[] arr = sentence.split(DIVIDER);

        /*
         * prints any word the starts with the query
         */
        for (String str : arr) {
            if (str.startsWith(query)) {
                System.out.println(str);
            }
        }

        //Prints any word that contains the query
        for (String str : arr) {
            if (str.contains(query) && !str.startsWith(query)) {
                System.out.println(str);
            }
        }
    }

    /**
     * @param args Received arguments.
     * @return false if Input format is invalid
     * Checks input format
     */
    public static boolean checkInput(String[] args) {
        if (args.length != MAX_PARAM) {
            System.out.println("Invalid input");
            return false;
        }
        return true;
    }
}