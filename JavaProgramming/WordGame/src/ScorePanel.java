import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private int score = 0;
    private JLabel scoreLabel = new JLabel(Integer.toString(score));

    public ScorePanel() {
        add(new JLabel("점수"));
        add(scoreLabel);
    }

    private void setScore(int score) {
        this.score = score;
        scoreLabel.setText(Integer.toString(score));
    }

    public void increase() {
        setScore(score + 10);
    }

    public void decrease() {
        setScore(score - 5);
    }
}
