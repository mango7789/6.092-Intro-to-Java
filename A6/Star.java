package A6;

import java.awt.*;

public class Star implements Sprite{
    private int width;
    private int height;
    private Color color;

    public Star(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics surface, int leftX, int topY) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        double angle = Math.PI / 2;
        double increment = Math.PI / 5;

        for (int i = 0; i < 10; i++) {
            int radius = (i % 2 == 0) ? width / 2 : width / 4;
            xPoints[i] = leftX + (int) (Math.cos(angle) * radius);
            yPoints[i] = topY - (int) (Math.sin(angle) * radius);
            angle += increment;
        }

        surface.setColor(color);
        surface.fillPolygon(xPoints, yPoints, 10);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
