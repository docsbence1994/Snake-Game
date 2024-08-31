//package engine;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class GameFrame extends JFrame {
//    private MenuPanel mainMenuPanel;
//    private GamePanel gamePanel;
//
//    public GameFrame() {
//        setTitle("Snake Game");
//        setSize(1280, 800);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        mainMenuPanel = new MenuPanel(this);
//        gamePanel = new GamePanel(this);
//
//        add(mainMenuPanel);
//        setVisible(true);
//    }
//
//    public void showGamePanel() {
//        remove(mainMenuPanel);
//        add(gamePanel);
//        revalidate();
//        repaint();
//        gamePanel.requestFocusInWindow();
//    }
//
//    public void showMainMenu() {
//        remove(gamePanel);
//        add(mainMenuPanel);
//        revalidate();
//        repaint();
//        mainMenuPanel.requestFocusInWindow();
//    }
//}
