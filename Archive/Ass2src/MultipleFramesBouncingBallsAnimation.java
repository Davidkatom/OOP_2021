package Ass2src;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Ass2src.MultipleFramesBouncingBallsAnimation
 * Controlls Multiple Balls and Frame Animation
 * User ID - shnaidd1
 */
public class MultipleFramesBouncingBallsAnimation {
    public static final int LARGE_START = 50;
    public static final int LARGE_END = 500;
    public static final int SMALL_START = 450;
    public static final int SMALL_END = 600;
    public static final int SCREEN_SIZE_SIZE_X = 700;
    public static final int SCREEN_SIZE_SIZE_Y = 700;

    /**
     * Starts Animation sequence.
     *
     * @param args - User Input
     */
    public static void main(String[] args) {
        MultipleFramesBouncingBallsAnimation ballsAnimation = new MultipleFramesBouncingBallsAnimation();
        ballsAnimation.prepareFrame(args);
    }

    /**
     * Prepares two frames for the animation.
     *
     * @param args - User Input
     */
    private void prepareFrame(String[] args) {
        BallsCreator ballsCreator = new BallsCreator();
        String[] largeFrameBallsStr = new String[args.length / 2];
        String[] smallFrameBallsStr = new String[args.length - largeFrameBallsStr.length];
        System.arraycopy(args, 0, largeFrameBallsStr, 0, largeFrameBallsStr.length);
        if (smallFrameBallsStr.length >= 0) {
            System.arraycopy(args, largeFrameBallsStr.length, smallFrameBallsStr, 0, smallFrameBallsStr.length);
        }
        Line largeScreen = new Line(LARGE_START, LARGE_START, LARGE_END, LARGE_END);
        Line smallScreen = new Line(SMALL_START, SMALL_START, SMALL_END, SMALL_END);
        Ball[] largeFrameBalls = ballsCreator.createBallsArray(largeFrameBallsStr, largeScreen);
        Ball[] smallFrameBalls = ballsCreator.createBallsArray(smallFrameBallsStr, smallScreen);
        runFrame(smallFrameBalls, largeFrameBalls);
    }

    /**
     * Loops animation.
     *
     * @param smallFrameBalls - Balls contained in the small frame
     * @param largeFrameBalls - Balls contained in the large frame
     */
    private void runFrame(Ball[] smallFrameBalls, Ball[] largeFrameBalls) {
        GUI gui = new GUI("title", SCREEN_SIZE_SIZE_X, SCREEN_SIZE_SIZE_Y);
        Sleeper sleeper = new Sleeper();

        //noinspection InfiniteLoopStatement
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(LARGE_START, LARGE_START, LARGE_END - LARGE_START, LARGE_END - LARGE_START);
            d.setColor(Color.YELLOW);
            d.fillRectangle(SMALL_START, SMALL_START, SMALL_END - SMALL_START, SMALL_END - SMALL_START);

            for (Ball ball : largeFrameBalls) {
                ball.moveOneStep(LARGE_START, LARGE_START, LARGE_END, LARGE_END);
                ball.drawOn(d);
            }
            for (Ball ball : smallFrameBalls) {
                ball.moveOneStep(SMALL_START, SMALL_START, SMALL_END, SMALL_END);
                ball.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(10);  // wait for 50 milliseconds.


        }
    }
}
