package items;

import javax.swing.*;

public class Nap extends Item {
    public Nap(double x, double y, double speed) {
        super(x, y, speed);
        icon = new ImageIcon("images/nap.png");
        label = new JLabel(icon);
    }
}
