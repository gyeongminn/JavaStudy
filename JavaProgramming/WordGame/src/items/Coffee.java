package items;

import javax.swing.*;

public class Coffee extends Item {
    public Coffee(double x, double y, double speed) {
        super(x, y, speed);
        icon = new ImageIcon("images/coffee.png");
        label = new JLabel(icon);
    }
}
