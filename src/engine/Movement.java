package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private int velX = 0;
    private int velY = 1;
    private long delay = 10;
    private long lastPressTime;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPressTime >= delay) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP && velY != 1) {
                velX = 0;
                velY = -1;
            }
            if (key == KeyEvent.VK_DOWN && velY != -1) {
                velX = 0;
                velY = 1;
            }
            if (key == KeyEvent.VK_LEFT && velX != 1) {
                velX = -1;
                velY = 0;
            }
            if (key == KeyEvent.VK_RIGHT && velX != -1) {
                velX = 1;
                velY = 0;
            }
            lastPressTime = currentTime;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public long getLastPressTime() {
        return lastPressTime;
    }
}
