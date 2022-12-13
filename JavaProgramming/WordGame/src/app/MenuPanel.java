package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {

    private GameFrame gameFrame;

    public MenuPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        setLayout(new GridLayout(16, 1));
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

        JLabel edit = new JLabel(new ImageIcon("images/edit.png"));
        add(edit);
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gameFrame.setEditPanel();
            }
        });

        JLabel setting = new JLabel(new ImageIcon("images/setting.png"));
        add(setting);
        setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                gameFrame.setSettingPanel();
            }
        });
    }
}
