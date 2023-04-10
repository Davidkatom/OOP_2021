package Ass2src;

import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Ass2src.AbstractArtDrawing
 * Paints random lines on screen and marks special points
 * User ID - shnaidd1
 */
public class AbstractArtDrawing {
    private static final int Y_SIZE = 600;
    private static final int X_SIZE = 800;
    private static final int CIRCLE_SIZE = 3;


    private final Line[] lines = new Line[10];

    /**
     * Generates a random line inside the frame
     * and finds the middle and intersection points.
     */
    public void generateRandomLine() {
        GUI gui = new GUI("Lines", X_SIZE, Y_SIZE);
        DrawSurface d = gui.getDrawSurface();
        drawLine(d);
        findMiddlePoints(d);
        findIntersectionPoint(d);
        gui.show(d);
    }

    /**
     * Draws a line inside the frame.
     *
     * @param d - surface to draw on
     */
    public void drawLine(DrawSurface d) {

        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            int x1 = rand.nextInt(X_SIZE) + 1;
            int y1 = rand.nextInt(Y_SIZE) + 1;
            int x2 = rand.nextInt(X_SIZE) + 1;
            int y2 = rand.nextInt(Y_SIZE) + 1;
            this.lines[i] = new Line(x1, y1, x2, y2);
            d.setColor(Color.BLACK);
            d.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * Finds the middle point for every line and paints them blue.
     *
     * @param d - Surface to draw on
     */
    public void findMiddlePoints(DrawSurface d) {
        for (Line line : lines) {
            Point mPoint = line.middle();
            drawPoint(mPoint, Color.BLUE, d);
        }
    }

    /**
     * Finds the intersection points for every line and paints them red.
     *
     * @param d - Surface to draw on
     */
    public void findIntersectionPoint(DrawSurface d) {
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                Point intersection;
                if (lines[i].isIntersecting(lines[j])) {
                    intersection = lines[i].intersectionWith(lines[j]);
                    drawPoint(intersection, Color.RED, d);
                }

            }
        }
    }

    /**
     * Draws a Point and colors it in a given color.
     *
     * @param point - Given Point
     * @param color - Color to paint the circle
     * @param d     - Surface to draw on
     */
    public void drawPoint(Point point, Color color, DrawSurface d) {
        d.setColor(color);
        d.fillCircle((int) point.getX(), (int) point.getY(), CIRCLE_SIZE);
    }

    /**
     * Main.
     *
     * @param args - Received args
     */
    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.generateRandomLine();
    }
}
