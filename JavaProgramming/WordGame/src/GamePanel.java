import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private JTextField inputField = new JTextField(20);
    private JLabel wordLabel = new JLabel("이곳에 단어가 등장합니다.");

    // wordLabel 은 groundPanel 보다 먼저 생성되어야 한다.
    private GroundPanel groundPanel = new GroundPanel();

    private WordList wordList = null;
    private ScorePanel scorePanel = null;

    public GamePanel(WordList wordList, ScorePanel scorePanel) {
        this.wordList = wordList;
        this.scorePanel = scorePanel;

        setLayout(new BorderLayout());
        add(groundPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GRAY);
        inputPanel.add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = (JTextField) e.getSource();
                if (textField.getText().equals(wordLabel.getText())) {
                    scorePanel.increase();
                    setWord(wordList.getWord());
                } else {
                    scorePanel.decrease();
                }
                textField.setText("");
            }
        });
        add(inputPanel, BorderLayout.SOUTH);
    }

    public void setWord(String word) {
        wordLabel.setText(word);
    }

    class GroundPanel extends JPanel {

        public GroundPanel() {
            add(wordLabel);
        }
    }
}
