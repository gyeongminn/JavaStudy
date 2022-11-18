import javax.swing.*;
import java.awt.*;

public class Word {
    private String name;
    private double x;
    private double y;
    private double speed;
    private Color color;

    JLabel label;

    public Word(String word, int x, int y, double speed) {
        this.name = word;
        this.x = x;
        this.y = y;
        this.speed = speed;
        label = new JLabel(word);
        color = getRandomColor();
    }

    private Color getRandomColor() {
        switch ((int) (Math.random() * 5)) {
            case 0 -> {
                return Color.RED;
            }
            case 1 -> {
                return Color.GREEN;
            }
            case 2 -> {
                return Color.BLUE;
            }
            default -> {
                return Color.BLACK;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setY(double y) {
        this.y = y;
    }
}
