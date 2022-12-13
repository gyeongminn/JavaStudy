package app;

import items.*;
import words.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

public class GamePanel extends JPanel {

    private final int MAX = 30;
    private final int LABEL_WIDTH = 150;
    private final int LABEL_HEIGHT = 40;

    private WordList wordList;
    private Vector<Word> currentWords;
    private Vector<Item> currentItems;
    private GroundPanel groundPanel;
    private ScorePanel scorePanel;
    private JLabel comboLabel;
    private JLabel gameOverLabel;

    private GameThread gameThread = null;
    private ItemThread itemThread = null;
    private JProgressBar healthBar;

    private double divDelay = 2;
    private int combo = 1;
    private int boost = 1;
    private Color recentColor = null;
    private int healthPoint = 0;
    private boolean paused = false;

    private boolean coffeeFlag = false;
    private boolean energyDrinkFlag = false;
    private boolean googleFlag = false;
    private boolean napFlag = false;

    public GamePanel(WordList wordList, ScorePanel scorePanel) {
        this.wordList = wordList;
        this.scorePanel = scorePanel;

        currentWords = new Vector<>(MAX);
        currentItems = new Vector<>(MAX);
        gameOverLabel = new JLabel("GAME OVER");

        groundPanel = new GroundPanel();
        initGroundPanel();

        JPanel inputPanel = new JPanel();
        add(inputPanel, BorderLayout.SOUTH);

        comboLabel = new JLabel("Combo");
        initComboLabel(comboLabel);

        initInputField(scorePanel, inputPanel, comboLabel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(71, 71, 71));
        g.drawRect(0, 572, 700, 1);
    }

    private void initGroundPanel() {
        groundPanel.setBackground(new Color(30, 30, 30));
        groundPanel.setBorder(BorderFactory.createEmptyBorder());
        setLayout(new BorderLayout());
        add(groundPanel, BorderLayout.CENTER);
        groundPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                for (Item item : currentItems) {
                    if ((e.getX() <= item.getX() + 50 && item.getX() < e.getX() + 25) &&
                            (e.getY() <= item.getY() + 50 && item.getY() < e.getY() + 25)) {
                        if (item instanceof Coffee) {
                            coffeeFlag = true;
                        } else if (item instanceof EnergyDrink) {
                            energyDrinkFlag = true;
                        } else if (item instanceof Google) {
                            googleFlag = true;
                        } else if (item instanceof Nap) {
                            napFlag = true;
                        }
                        item.setY(10000);
                        scorePanel.addItemCount();
                        break;
                    }
                }
            }
        });

    }

    private void initInputField(ScorePanel scorePanel, JPanel inputPanel, JLabel comboLabel) {
        inputPanel.setLayout(null);
        inputPanel.setBackground(new Color(30, 30, 30));
        inputPanel.setBorder(BorderFactory.createEmptyBorder());
        inputPanel.setPreferredSize(new Dimension(30, 150));

        JLabel terminalLabel = new JLabel("Terminal");
        terminalLabel.setFont(new Font("consolas", Font.PLAIN, 16));
        terminalLabel.setBounds(20, 4, 100, 40);
        terminalLabel.setForeground(Color.WHITE);

        JLabel dirLabel = new JLabel("C:\\Users> ");
        dirLabel.setFont(new Font("consolas", Font.PLAIN, 18));
        dirLabel.setBounds(20, 4, 130, 100);
        dirLabel.setForeground(Color.WHITE);

        JTextField inputField = new JTextField();
        inputField.setFont(new Font("consolas", Font.PLAIN, 18));
        inputField.setBounds(120, 4, 500, 100);
        inputField.setBackground(new Color(30, 30, 30));
        inputField.setBorder(BorderFactory.createEmptyBorder());
        inputField.setForeground(Color.YELLOW);

        inputPanel.add(terminalLabel);
        inputPanel.add(dirLabel);
        inputPanel.add(inputField);

        inputField.addActionListener(e -> {
            JTextField textField = (JTextField) e.getSource();
            command(textField.getText());
            for (Word word : currentWords) {
                if (textField.getText().equals(word.getName())) {
                    if (recentColor == word.getColor()) {
                        combo++;
                        if (combo > 1) {
                            comboLabel.setText("Combo " + combo + "x!");
                            comboLabel.setVisible(true);
                        }
                    } else {
                        combo = 1;
                        comboLabel.setVisible(false);
                    }
                    recentColor = word.getColor();
                    scorePanel.addScore(10 * combo * boost);
                    scorePanel.addWordCount();
                    word.setY(10000);
                    break;
                }
            }
            textField.setText("");
        });


    }

    private void command(String command) {
        if (command.equals("start")) {
            startGame();
        } else if (command.equals("pause")) {
            pauseGame();
        } else if (command.equals("stop")) {
            gameOver();
        } else if (command.equals("exit")) {
            System.exit(1);
        }
    }

    private void initComboLabel(JLabel comboLabel) {
        comboLabel.setFont(new Font("consolas", Font.PLAIN, 20));
        comboLabel.setForeground(Color.WHITE);
        comboLabel.setLocation(550, 50);
        comboLabel.setSize(150, 20);
        comboLabel.setVisible(false);
        groundPanel.add(comboLabel);
    }

    public void startGame() {
        gameOverLabel.setVisible(false);
        groundPanel.initHealthBar();
        gameThread = new GameThread();
        gameThread.start();
        itemThread = new ItemThread();
        itemThread.start();
        paused = false;
    }

    public void pauseGame() {
        paused = true;
    }

    private void addItem() {
        int x = (int) (Math.random() * (groundPanel.getWidth() - LABEL_WIDTH / 2));
        double speed = Math.random() / 20 + 0.1;
        Item item;
        switch ((int) (Math.random() * 4)) {
            case 0 -> item = new Coffee(x, 0, speed);
            case 1 -> item = new EnergyDrink(x, 0, speed);
            case 2 -> item = new Google(x, 0, speed);
            case 3 -> item = new Nap(x, 0, speed);
            default -> throw new IllegalStateException();
        }
        currentItems.add(item);

        JLabel label = item.getLabel();
        label.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        label.setLocation(getX(), 0);
        groundPanel.add(label);
    }

    private void addWord() {
        int x = (int) (Math.random() * (groundPanel.getWidth() - LABEL_WIDTH / 2));
        double speed = Math.random() / 20 + 0.1;
        Word word = new Word(wordList.getWord(), x, 0, speed);
        currentWords.add(word);

        JLabel label = word.getLabel();
        label.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        label.setLocation(getX(), 0);
        label.setFont(new Font("consolas", Font.PLAIN, 20));
        label.setForeground(word.getColor());
        groundPanel.add(label);
    }

    public void setItems() {
        Iterator<Item> iterator = currentItems.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            item.setY(item.getY() + (item.getSpeed() / divDelay));
            JLabel label = item.getLabel();
            label.setSize(50, 50);
            label.setLocation((int) (item.getX()), (int) item.getY());
            if (label.getY() >= groundPanel.getHeight()) {
                groundPanel.remove(label);
                iterator.remove();
            }
        }
    }

    public void setWords() {
        Iterator<Word> iterator = currentWords.iterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            word.setY(word.getY() + (word.getSpeed() / divDelay));
            JLabel label = word.getLabel();
            label.setLocation((int) word.getX(), (int) word.getY());
            if (label.getY() >= groundPanel.getHeight()) {
                if (label.getY() < 10000) {
                    healthPoint -= 10;
                }
                groundPanel.remove(label);
                iterator.remove();
            }
        }
    }

    public void gameOver() {
        if (gameThread == null) {
            return;
        }
        pauseGame();
        gameThread.interrupt();
        itemThread.interrupt();
        for (Word word : currentWords) {
            word.getLabel().setVisible(false);
            groundPanel.remove(word.getLabel());
        }
        currentWords.removeAllElements();
        for (Item item : currentItems) {
            item.getLabel().setVisible(false);
            groundPanel.remove(item.getLabel());
        }
        currentItems.removeAllElements();
        healthBar.setVisible(false);
        comboLabel.setVisible(false);

        gameOverLabel.setFont(new Font("consolas", Font.PLAIN, 100));
        gameOverLabel.setForeground(Color.WHITE);
        gameOverLabel.setBounds(100, 100, 500, 300);
        groundPanel.add(gameOverLabel);
        gameOverLabel.setVisible(true);
    }

    class GroundPanel extends JPanel {

        public GroundPanel() {
            setLayout(null);
            setBackground(Color.GRAY);
        }

        public void initHealthBar() {
            healthBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
            healthPoint = 100;
            healthBar.setForeground(Color.RED);
            healthBar.setLocation(100, 20);
            healthBar.setSize(500, 20);
            add(healthBar);
        }
    }

    class GameThread extends Thread {

        public GameThread() {
            super("GameThread");
        }

        @Override
        public void run() {
            long count = 0;
            while (true) {
                try {
                    if (paused) {
                        sleep(1000);
                        continue;
                    } else {
                        sleep(1);
                    }
                } catch (InterruptedException e) {
                    return;
                }
                if (count % 1000 == 0) {
                    healthPoint--;
                    addWord();
                }
                count++;
                if (count % 10000 == 0) {
                    addItem();
                }
                setWords();
                setItems();
                healthBar.setValue(healthPoint);
                if (healthPoint <= 0) {
                    gameOver();
                }
            }
        }
    }

    class ItemThread extends Thread {

        @Override
        public void run() {
            long count = 1;
            while (true) {
                try {
                    if (coffeeFlag) {
                        boost = 2;
                        if (count % 100 == 0) {
                            coffeeFlag = false;
                            boost = 1;
                            count = 1;
                        }
                    }
                    if (energyDrinkFlag) {
                        boost = 3;
                        if (count % 100 == 0) {
                            boost = 1;
                            energyDrinkFlag = false;
                            count = 1;
                        }
                    }
                    if (googleFlag) {
                        for (Word word : currentWords) {
                            word.setY(10000);
                            scorePanel.addScore((int) (10 * boost * 0.5));
                        }
                        googleFlag = false;
                    }
                    if (napFlag) {
                        healthPoint += 20;
                        if (healthPoint > 100) healthPoint = 100;
                        divDelay = 10;
                        if (count % 50 == 0) {
                            divDelay = 2;
                            napFlag = false;
                            count = 1;
                        }
                    }
                    count++;
                    sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
