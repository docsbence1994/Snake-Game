package engine;

import component.Tile;
import object.Food;
import object.SnakeBody;
import object.SnakeHead;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    public int boardHeight = 800;
    public int boardWidth = 1280;
    private Tile tile;
    private Movement keyInput = new Movement();
    private SnakeHead snakeHead;
    private Food food;
    private int snakeStartX = 5;
    private int snakeStartY = 5;
    private int foodStartX = 15;
    private int foodStartY = 15;
    private Timer gameLoop = new Timer(100, this);

    public GamePanel() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        addKeyListener(keyInput);
        setFocusable(true); // This method is used to set the focusable state of the component to the specified value.
        setDoubleBuffered(true); // Double buffering is a technique used in computer graphics to provide a more smooth and efficient rendering of images.
        tile = new Tile(5, 5);
        food = new Food(foodStartX, foodStartY, boardWidth, boardHeight);
        snakeHead = new SnakeHead(keyInput, snakeStartX, snakeStartY, food);
        gameLoop.start();
        addKeyListener(keyInput);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        snakeHead.draw(g);
        food.draw(g);
        tile.grid(g);
    }

    public boolean collision(Tile tile1, Tile tile2) {
        return tile1.getX() == tile2.getX() && tile1.getY() == tile2.getY();
    }

    public void gameOver() {
        for (SnakeBody body : snakeHead.getSnakeBody()) {
            if (collision(snakeHead.tile, body.tile)) {
                gameLoop.stop();
                int option = JOptionPane.showConfirmDialog(this, "Game Over", "Game Over", JOptionPane.DEFAULT_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        }

        if (snakeHead.tile.getX() < 0 || snakeHead.tile.getX() >= boardWidth / tile.getTileSize() || snakeHead.tile.getY() < 0 || snakeHead.tile.getY() >= boardHeight / tile.getTileSize()) {
            gameLoop.stop();
            int option = JOptionPane.showConfirmDialog(this, "Game Over", "Game Over", JOptionPane.DEFAULT_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                System.exit(0);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is called by the Timer every 100 milliseconds
        snakeHead.move();
        repaint();
        gameOver();
    }
}
