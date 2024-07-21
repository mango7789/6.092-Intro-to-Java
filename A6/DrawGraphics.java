package A6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class DrawGraphics {
    List<Sprite> Sprites;
    List<Mover> Moves;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        /* Add sprites */
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Star star = new Star(20, 20, Color.ORANGE);

        Sprites = new ArrayList<Sprite>();
        Sprites.add(box);
        Sprites.add(star);

        /* Add movers */
        Moves = new ArrayList<Mover>();
        for (Sprite sprite : Sprites) {

            StraightMover StraightMove = new StraightMover(150, 150, sprite);
            StraightMove.setMovementVector(-1, 1);

            Bouncer Bounce = new Bouncer(150, 150, sprite);
            Bounce.setMovementVector(1, -2);

            Moves.add(StraightMove);
            Moves.add(Bounce);
        }
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for (Mover move : Moves) {
            move.draw(surface);
        }
    }
}
