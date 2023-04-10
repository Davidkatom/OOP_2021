package Ass2src;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

/**
 * @author David Shnaiderov - 209198308
 * Ass2src.BallsCreator
 * Controlls Ball creation
 * User ID - shnaidd1
 */
public class BallsCreator {
    public static final int MAX_RGB = 255;
    private static final double DEFAULT_SPEED = 50.0;
    private static final int SAFE_BOUNDARY = 1;

    /**
     * Creates an array of Balls from a String array.
     *
     * @param args  - Received String array
     * @param space - Line representing the diagonal size of the given frame
     * @return Balls array
     */
    public Ball[] createBallsArray(String[] args, Line space) {
        Ball[] balls = new Ball[args.length];
        int i = 0;
        for (String arg : args) {
            int radius = Integer.parseInt(arg);
            //Checks if a Ball is too large
            if (radius >= (space.end().getX() - space.start().getX()) / 2
                    || radius >= (space.end().getY() - space.start().getY()) / 2) {
                balls = Arrays.copyOf(balls, balls.length - 1);
                continue;
            }
            balls[i] = createBall(radius, space);
            i++;
        }
        return balls;
    }

    /**
     * Creates a single Ball instance.
     *
     * @param radius - given ball radius
     * @param space  - frame size
     * @return Ball instance
     */
    public Ball createBall(int radius, Line space) {
        Random rnd = new Random();
        double dx;
        double dy;
        //Normalize speed
        if (radius >= DEFAULT_SPEED) {
            dx = SAFE_BOUNDARY;
            dy = SAFE_BOUNDARY;
        } else {
            dx = DEFAULT_SPEED / radius;
            dy = DEFAULT_SPEED / radius;
        }
        //Create random starting point
        int x = (int) (radius + space.start().getX() + SAFE_BOUNDARY
                + rnd.nextInt((int) ((int) space.end().getX() - 2 * radius - space.start().getX())));
        int y = (int) (radius + space.start().getY() + SAFE_BOUNDARY
                + rnd.nextInt((int) ((int) space.end().getY() - 2 * radius - space.start().getY())));


        Velocity velocity = new Velocity(dx, dy);
        Color color = new Color(rnd.nextInt(MAX_RGB), rnd.nextInt(MAX_RGB), rnd.nextInt(MAX_RGB));
        Ball ball = new Ball(x, y, radius, color);
        ball.setVelocity(velocity);
        return ball;
    }
}
