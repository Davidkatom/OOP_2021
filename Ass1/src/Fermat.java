/**
 * @author David Shnaiderov - 209198308
 * User ID - shnaidd1
 * Task 2
 */
public class Fermat {
    public static final int MAX_PARAM = 2;

    /**
     * @param args - Received arguments.
     *             Searches for Pythagorean triplets
     */
    public static void main(String[] args) {
        //If Input is Invalid, exit the program.
        if (!checkInput(args)) {
            return;
        }
        //n - Power
        int n = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        boolean hasPrinted = false;
        double temp;

        /*
         * for each 2 numbers less than
         * max, check is the respective third is an integer.
         */
        if (n > MAX_PARAM || n <= 0) {
            System.out.println("no");
        } else {
            for (int i = 1; i < max; i++) {
                for (int j = i; j < max; j++) {
                    temp = Math.pow((Math.pow(i, n) + Math.pow(j, n)), 1.0 / n);
                    if (temp % 1 == 0 && temp < max) {
                        System.out.println(i + "," + j + "," + (int) temp);
                        hasPrinted = true;
                    }
                }
            }
            if (!hasPrinted) {
                System.out.println("no");
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
        for (String str : args) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return false;
            }
            if (Integer.parseInt(str) <= 0) {
                System.out.println("Invalid input");
                return false;
            }
        }
        return true;
    }
}
