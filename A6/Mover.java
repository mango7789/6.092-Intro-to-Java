package A6;

import java.awt.*;

public interface Mover {
    /**
     * The interface of the Bouncer and StraightMover
     */
    void setMovementVector(int xIncrement, int yIncrement);

    void draw(Graphics graphics);
}
