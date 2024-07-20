package A5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    BouncingBox box;
    ArrayList<BouncingBox> boxes;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.RED);

        boxes = new ArrayList<BouncingBox>();
        boxes.add(new BouncingBox(150, 150, Color.RED, 1, 0));
        boxes.add(new BouncingBox(150, 150, Color.GREEN, 0, -2));
        boxes.add(new BouncingBox(150, 150, Color.BLUE, -2, 1));
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        /* Draw the graphics provided by the package */
        surface.drawLine(50, 50, 250, 250);
        surface.drawArc(50, 50, 200, 100, 0, 270);
        surface.drawRect(50, 50, 200, 100);
        surface.drawOval(100, 100, 100, 100);
        /* Draw the bouncing box with animation */
        for (BouncingBox box : boxes) {
            box.draw(surface);
        }
    }
} 