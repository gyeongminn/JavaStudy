package app;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {

    private int score = 0;
    private int wordCount = 0;
    private int itemCount = 0;
    private JLabel scoreLabel;
    private JLabel wordCountLabel;
    private JLabel itemCountLabel;

    public ScorePanel() {
        setLayout(new GridLayout(20,1));
        setBackground(new Color(37, 37, 37));
        initLabels();
    }

    private void initLabels() {
        score = 0;
        scoreLabel = new JLabel("0G");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(scoreLabel);

        wordCount = 0;
        wordCountLabel = new JLabel("Entered Word : 0");
        wordCountLabel.setForeground(Color.WHITE);
        wordCountLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(wordCountLabel);

        itemCount = 0;
        itemCountLabel = new JLabel("Used item : 0");
        itemCountLabel.setForeground(Color.WHITE);
        itemCountLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        add(itemCountLabel);
    }

    private void setScore(int score) {
        this.score = score;
        scoreLabel.setText(score + "G");
    }

    public void addScore(int point) {
        setScore(score + point);
    }

    public void addWordCount() {
        wordCountLabel.setText("Entered Word : " + ++wordCount);
    }

    public void addItemCount() {
        itemCountLabel.setText("Used item : " + ++itemCount);
    }
}
