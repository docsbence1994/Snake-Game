package object;

import component.Tile;

import java.awt.*;

public class SnakeBody {
    public Tile tile;
    private Colour randomColour =Colour.RED.getRandomColour();

    public SnakeBody(int x, int y) {
        this.tile = new Tile(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(randomColour.toAwtColor());
        g.fillRect(tile.getX() * tile.getTileSize(), tile.getY() * tile.getTileSize(), tile.getTileSize(), tile.getTileSize());
    }
}
