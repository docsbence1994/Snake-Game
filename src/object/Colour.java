package object;

import java.awt.Color;

public enum Colour {
    RED, GREEN, BLUE, YELLOW, ORANGE, PURPLE, PINK, CYAN, WHITE;

    public Colour getRandomColour() {
        return values()[(int) (Math.random() * values().length)];
    }

    public Color toAwtColor() {
        switch (this) {
            case RED:
                return Color.RED;
            case GREEN:
                return Color.GREEN;
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case ORANGE:
                return Color.ORANGE;
            case PURPLE:
                return new Color(128, 0, 128); // Java does not have a built-in Color for PURPLE
            case PINK:
                return Color.PINK;
            case CYAN:
                return Color.CYAN;
            case WHITE:
                return Color.WHITE;
            default:
                throw new IllegalArgumentException("Unknown color: " + this);
        }
    }
}
