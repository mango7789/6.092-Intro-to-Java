package A6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {
    Bouncer movingSprite;
    List<Bouncer> Sprites;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        movingSprite = new Bouncer(100, 170, box);
        movingSprite.setMovementVector(3, 1);

        Sprites = new ArrayList<Bouncer>();

    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        movingSprite.draw(surface);
    }
}
