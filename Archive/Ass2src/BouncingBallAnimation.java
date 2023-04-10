package Ass2src;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author David Shnaiderov - 209198308
 * Ass2src.BouncingBallAnimation
 * Controlls Ball creation
 * User ID - shnaidd1
 */
public class BouncingBallAnimation {

    public static final int MAX_PARAM = 4;
    public static final int RADIUS = 30;
    public static final int SCREEN_SIZE_X = 200;
    public static final int SCREEN_SIZE_Y = 200;

    /**
     * Runs the Ass2src.BouncingBallAnimation.
     *
     * @param args - Received arguments - x,y,angle,speed
     */
    public static void main(String[] args) {
        try {
            double[] doubleParams = checkInput(args);
            BouncingBallAnimation ballAnimation = new BouncingBallAnimation();

            Velocity v = Velocity.fromAngleAndSpeed(doubleParams[2], doubleParams[3]);
            Point start = new Point(doubleParams[0], doubleParams[1]);
            ballAnimation.drawAnimation(start, v.getDx(), v.getDy());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Loops Ball animation.
     *
     * @param start - Ball starting ball
     * @param dx    - starting velocity x value
     * @param dy    - starting velocity y value
     */
    private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", SCREEN_SIZE_X, SCREEN_SIZE_Y);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), RADIUS, java.awt.Color.BLACK);
        ball.setVelocity(dx, dy);
        //noinspection InfiniteLoopStatement
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(10);  // wait for 10 milliseconds.
        }
    }

    /**
     * Validates user input and parses as Double.
     *
     * @param args - Received input
     * @return - Parsed Array
     */
    private static double[] checkInput(String[] args) {
        double[] doubleParams = new double[4];
        if (args.length != MAX_PARAM) {
            throw new RuntimeException("Incorrect input");
        }
        int i = 0;
        for (String str : args) {
            try {
                doubleParams[i] = Double.parseDouble(str);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Incorrect input");
            }
            i++;
        }
        //In case Point outside screen, move to center
        if (doubleParams[0] <= RADIUS * 2 || doubleParams[0] >= SCREEN_SIZE_X - RADIUS) {
            doubleParams[0] = SCREEN_SIZE_X / 2.0;
        }
        if (doubleParams[1] <= RADIUS * 2 || doubleParams[1] >= SCREEN_SIZE_Y - RADIUS) {
            doubleParams[1] = SCREEN_SIZE_Y / 2.0;
        }

        return doubleParams;
    }
}
