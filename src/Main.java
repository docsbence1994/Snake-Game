import engine.GamePanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int boardWidth = 800;
        int boardHeight = 1280;

        JFrame frame = new JFrame("Snake Game");

        GamePanel gp = new GamePanel();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(gp);
        frame.pack();
        gp.requestFocus();
    }
}