package object;

import component.Tile;

import java.awt.*;
import java.util.Random;

public class Food {
    private Tile tile;
    private Random random = new Random();
    private int boardWidth, boardHeight;

    public Food(int startX, int startY, int boardWidth, int boardHeight) {
        this.tile = new Tile(startX, startY);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(tile.getX() * tile.getTileSize(), tile.getY() * tile.getTileSize(), tile.getTileSize(), tile.getTileSize());
    }

    public void placeFoodRandomly() {
        int x = random.nextInt(boardWidth / tile.getTileSize());
        int y = random.nextInt(boardHeight / tile.getTileSize());
        tile.setX(x);
        tile.setY(y);
    }

    public Tile getTile() {
        return tile;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }
}
