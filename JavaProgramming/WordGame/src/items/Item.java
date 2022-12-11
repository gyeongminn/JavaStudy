package items;

import javax.swing.*;
import java.awt.*;

public abstract class Item {

    protected double x;
    protected double y;
    protected double speed;
    protected ImageIcon icon;
    protected JLabel label;

    public Item(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public JLabel getLabel() {
        return label;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }
}
