import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

public class GamePanel extends JPanel {

    private final int MAX_WORDS = 30;
    private final int LABEL_WIDTH = 150;
    private final int LABEL_HEIGHT = 40;

    private JTextField inputField = new JTextField(MAX_WORDS);
    private WordList wordList;
    private Vector<Word> currentWords = new Vector<>(MAX_WORDS);
    private GroundPanel groundPanel = new GroundPanel();
    private GameThread gameThread = null;

    private int healthPoint = 0;
    private JProgressBar healthBar = new JProgressBar(JProgressBar.HORIZONTAL, 0,100);


    public GamePanel(WordList wordList, ScorePanel scorePanel) {
        this.wordList = wordList;

        setLayout(new BorderLayout());
        add(groundPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GRAY);
        inputPanel.add(inputField, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.SOUTH);

        inputField.addActionListener(e -> {
            JTextField textField = (JTextField) e.getSource();
            for (Word word : currentWords) {
                if (textField.getText().equals(word.getName())) {
                    scorePanel.increase();
                    word.setY(10000);
                    break;
                }
            }
            textField.setText("");
        });
    }

    public void startGame() {
        groundPanel.initHealthBar();
        if (gameThread == null) {
            gameThread = new GameThread();
            gameThread.start();
        }
    }

    private void addWord() {
        int x = (int) (Math.random() * (groundPanel.getWidth() - LABEL_WIDTH / 2));
        Word word = new Word(wordList.getWord(), x, 0, Math.random() / 20 + 0.1);
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
                if (label.getY() < 10000) {
                    healthPoint -= 10;
                }
                groundPanel.remove(label);
                iterator.remove();
            }
        }
    }

    class GroundPanel extends JPanel {

        public GroundPanel() {
            setLayout(null);
            setBackground(Color.GRAY);
        }

        public void initHealthBar() {
            healthPoint = 100;
            healthBar.setForeground(Color.RED);
            healthBar.setLocation(100, 10);
            healthBar.setSize(500,30);
            add(healthBar);
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
                if (count % 1000 == 0) {
                    addWord();
                }
                healthBar.setValue(healthPoint);
                setWords();
                count++;
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
