package Ass2src;

import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;

public class ZLineTest2 {
    static final int WIDTH = 400;
    static final int HEIGHT = 400;
    //radius of a point
    static final int POINT_RADIUS = 2;
    //number of lines to present on the screen
    static final int NUMBER_OF_LINES = 20;


    public static void main(String[] args) {
        drawTestLines();


    }

    /**
     * asd.
     */
    @SuppressWarnings("checkstyle:AvoidNestedBlocks")
    public static void drawTestLines() {
        // Create a window with the title "Random Line", which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines", WIDTH, HEIGHT);
        DrawSurface d = gui.getDrawSurface();
        //an array for the lines we generate
        Line[] linesList = new Line[NUMBER_OF_LINES];
        //lines to indicate connection:
        //for (int i = 0; i < NUMBER_OF_LINES;i++) {
        //    linesList[i] = new Line(380, 380, 380, 380);
        //}


        //4 intersections, 4 reds:
        {
            linesList[0] = new Line(5, 5, 30, 30);
            linesList[1] = new Line(30, 30, 50, 30);

            linesList[2] = new Line(65, 10, 65, 40);
            linesList[3] = new Line(65, 40, 95, 65);


            linesList[4] = new Line(90, 10, 120, 10);
            linesList[5] = new Line(120, 10, 150, 10);

            linesList[6] = new Line(120, 30, 120, 60);
            linesList[7] = new Line(120, 60, 120, 110);


        }

        //box with 4 reds at edges:
        {
            linesList[8] = new Line(180, 20, 180, 70);
            linesList[9] = new Line(180, 70, 230, 70);
            linesList[10] = new Line(230, 70, 230, 20);
            linesList[11] = new Line(230, 20, 180, 20);
        }


        //triangle with 3 reds at edges:
        {
            linesList[12] = new Line(300, 10, 250, 70);
            //linesList[13] = new Line(250, 70, 320, 69);
            linesList[13] = new Line(320, 69, 250, 70);
            linesList[14] = new Line(320, 69, 300, 10);
        }




        //lines to middle other lines
        {
            linesList[15] = new Line(340, 10, 390, 10);
            linesList[16] = new Line(350, 10, 335, 40);
            linesList[17] = new Line(360, 10, 360, 40);
            linesList[18] = new Line(375, 10, 386, 40);
            linesList[19] = new Line(330, 40, 400, 40);
        }


        //linesList[15] = new Line(165, 40, 200, 40);


        //lines to indicate non connection:


        //loops through the lines and marker them
        for (int i = 0; i < NUMBER_OF_LINES; ++i) {
            d.setColor(Color.black);
            d.drawLine((int) linesList[i].start().getX(), (int) linesList[i].start().getY(),
                    (int) linesList[i].end().getX(), (int) linesList[i].end().getY());
            d.setColor(Color.blue);
            d.fillCircle((int) linesList[i].middle().getX(), (int) linesList[i].middle().getY(), POINT_RADIUS);
        }
        //show intersection points:
        d.setColor(Color.red);
        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            for (int j = i + 1; j < NUMBER_OF_LINES; j++) {
                Point p = linesList[i].intersectionWith(linesList[j]);
                if (p != null) {
                    d.fillCircle((int) p.getX(), (int) p.getY(), POINT_RADIUS);
                }
            }
        }
        gui.show(d);
    }

    public static void assertEquals() {

    }
}
