package object;

import component.Tile;
import engine.Movement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeHead {
    private Movement keyInput;
    public Tile tile;
    private Food food;
    private List<SnakeBody> snakeBody;
    private Tile prevTile;

    public SnakeHead(Movement keyInput, int startX, int startY, Food food) {
        this.keyInput = keyInput;
        this.tile = new Tile(startX, startY);
        this.prevTile = new Tile(startX, startY);
        this.food = food;
        this.snakeBody = new ArrayList<>();
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(tile.getX() * tile.getTileSize(), tile.getY() * tile.getTileSize(), tile.getTileSize(), tile.getTileSize());

        for (SnakeBody body : snakeBody) {
            body.draw(g);
        }
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.getX() == tile2.getX() && tile1.getY() == tile2.getY();
    }

    public void move() {
        prevTile.setX(tile.getX());
        prevTile.setY(tile.getY());

        tile.setX(tile.getX() + keyInput.getVelX());
        tile.setY(tile.getY() + keyInput.getVelY());

        if (collision(tile, food.getTile())) {
            food.placeFoodRandomly();
            snakeBody.add(new SnakeBody(tile.getX(), tile.getY()));
        }

        for (int i = snakeBody.size()-1; i >= 0; i--) {
            if (i == 0) {
                snakeBody.get(i).tile.setX(prevTile.getX());
                snakeBody.get(i).tile.setY(prevTile.getY());
            } else {
                snakeBody.get(i).tile.setX(snakeBody.get(i-1).tile.getX());
                snakeBody.get(i).tile.setY(snakeBody.get(i-1).tile.getY());
            }
            
        }
    }

    public List<SnakeBody> getSnakeBody() {
        return snakeBody;
    }
}
