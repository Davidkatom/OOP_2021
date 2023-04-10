package Ass2src;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author David Shnaiderov - 209198308
 * Ass2src.MultipleBouncingBallsAnimation
 * Controlls Multiple Balls Animation
 * User ID - shnaidd1
 */
public class MultipleBouncingBallsAnimation {
    public static final int SCREEN_SIZE_X_LARGE = 600;
    public static final int SCREEN_SIZE_Y_LARGE = 600;

    /**
     * Main Animation.
     *
     * @param args - User Input
     */
    public static void main(String[] args) {
        MultipleBouncingBallsAnimation animation = new MultipleBouncingBallsAnimation();
        animation.loopAnimation(args);
    }

    /**
     * Loops animation.
     *
     * @param args - User Input
     */
    private void loopAnimation(String[] args) {
        BallsCreator ballsCreator = new BallsCreator();
        Line screen = new Line(0, 0, SCREEN_SIZE_X_LARGE, SCREEN_SIZE_Y_LARGE);
        GUI gui = new GUI("title", SCREEN_SIZE_X_LARGE, SCREEN_SIZE_Y_LARGE);
        Sleeper sleeper = new Sleeper();

        Ball[] balls = ballsCreator.createBallsArray(args, screen);

        //noinspection InfiniteLoopStatement
        while (true) {
            DrawSurface d = gui.getDrawSurface();

            for (Ball ball : balls) {
                ball.moveOneStep(0, 0, SCREEN_SIZE_X_LARGE, SCREEN_SIZE_Y_LARGE);
                ball.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(10);  // wait for 10 milliseconds.

        }
    }

}

