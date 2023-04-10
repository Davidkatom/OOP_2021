/**
 * @author David Shnaiderov - 209198308
 * Task 1
 * User ID - shnaidd1
 */
public class SumDiv {
    public static final int MAX_PARAM = 3;

    /**
     * @param args - Received arguments.
     *             Receives 3 positive Integers as arguments and prints
     *             out the numbers between 1 and 'a' that are divisible by b or c.
     *             and the sum of all these numbers.
     */
    public static void main(String[] args) {
        //If Input is Invalid, exit the program.
        if (!checkInput(args)) {
            return;
        }
        //Stores integers from args
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int sum = 0;
        //prints each divisible number and calculates the sum.
        for (int i = 1; i <= a; i++) {
            if (i % b == 0 || i % c == 0) {
                System.out.println(i);
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }

    /**
     * @param args Received arguments.
     *             Checks input format
     * @return false if Input format is invalid
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

