package component;

import java.awt.*;

public class Tile {
    private int x;
    private int y;
    private int tileSize = 25;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void grid(Graphics g){
        //Grid lines to help with debugging
        for (int i = 0; i < 1280 / tileSize; i++) {
            g.setColor(Color.DARK_GRAY);
            g.drawLine(i * tileSize, 0, i * tileSize, 800);
            g.drawLine(0, i * tileSize, 1280, i * tileSize);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getTileSize() {
        return tileSize;
    }
}
