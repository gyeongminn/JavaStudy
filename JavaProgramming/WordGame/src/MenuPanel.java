import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {

    private GameFrame gameFrame;

    public MenuPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setBackground(new Color(51, 51, 51));

        JLabel score = new JLabel(new ImageIcon("images/coin.png"));
        add(score);
        score.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gameFrame.setScorePanel();
            }
        });

        JLabel edit = new JLabel(new ImageIcon("images/coin.png"));
        add(edit);
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gameFrame.setEditPanel();
            }
        });
    }
}
