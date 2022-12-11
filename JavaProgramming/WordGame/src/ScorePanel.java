import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private JLabel scoreLabel;

    public ScorePanel() {
        setBackground(new Color(37, 37, 37));
        add(new JLabel(new ImageIcon("images/gold.png")));
        scoreLabel = new JLabel("0G");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(scoreLabel);
    }

    private void setScore(int score) {
        this.score = score;
        scoreLabel.setText(score + "G");
    }

    public void increase(int point) {
        setScore(score + point);
    }

    public void decrease() {
        setScore(score - 5);
    }
}
