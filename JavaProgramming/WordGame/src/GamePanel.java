import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

public class GamePanel extends JPanel {

    private final int MAX_WORDS = 30;
    private final int LABEL_WIDTH = 150;
    private final int LABEL_HEIGHT = 40;

    private JTextField inputField = new JTextField(MAX_WORDS);
    WordList wordList;
    private Vector<Word> currentWords = new Vector<>(MAX_WORDS);
    private GroundPanel groundPanel = new GroundPanel();
    private GameThread gameThread = null;


    public GamePanel(WordList wordList, ScorePanel scorePanel) {
        this.wordList = wordList;

        setLayout(new BorderLayout());
        add(groundPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GRAY);
        inputPanel.add(inputField, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField textField = (JTextField) e.getSource();
                for (Word word : currentWords) {
                    if (textField.getText().equals(word.getName())) {
                        scorePanel.increase();
                        word.setY(groundPanel.getHeight());
                        break;
                    }
                }
                textField.setText("");
            }
        });
    }

    public void startGame() {
        if (gameThread == null) {
            gameThread = new GameThread();
            gameThread.start();
        }
    }

    private void addWord() {
        int x = (int) (Math.random() * (groundPanel.getWidth() - LABEL_WIDTH / 2));
        Word word = new Word(wordList.getWord(), x, 0, Math.random() / 20 + 0.05);
        currentWords.add(word);
        addLabel(word);
    }

    private void addLabel(Word word) {
        JLabel label = word.getLabel();
        label.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        label.setLocation(getX(), 0);
        label.setFont(new Font("Gothic", Font.PLAIN, 20));
        label.setForeground(word.getColor());
        groundPanel.add(label);
    }

    public void setWords() {
        Iterator<Word> iterator = currentWords.iterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            word.setY(word.getY() + word.getSpeed());
            JLabel label = word.getLabel();
            label.setLocation((int) (word.getX()), (int) word.getY());
            if (label.getY() >= groundPanel.getHeight()) {
                groundPanel.remove(label);
                iterator.remove();
            }
        }
    }

    class GroundPanel extends JPanel {

        public GroundPanel() {
            setBackground(Color.GRAY);
        }
    }


    class GameThread extends Thread {

        public GameThread() {
            super("GameThread");
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                try {
                    if (count % 1500 == 0) {
                        addWord();
                    }
                    setWords();
                    count++;
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
