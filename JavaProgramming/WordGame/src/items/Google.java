package items;

import javax.swing.*;

public class Google extends Item {
    public Google(double x, double y, double speed) {
        super(x, y, speed);
        icon = new ImageIcon("images/google.png");
        label = new JLabel(icon);
    }
}
