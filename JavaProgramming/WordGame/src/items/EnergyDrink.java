package items;

import javax.swing.*;

public class EnergyDrink extends Item {
    public EnergyDrink(double x, double y, double speed) {
        super(x, y, speed);
        icon = new ImageIcon("images/redbull.png");
        label = new JLabel(icon);
    }
}
