import words.WordList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class GameFrame extends JFrame {

    private ScorePanel scorePanel = new ScorePanel();
    private EditPanel editPanel = new EditPanel();

    private WordList wordList = new WordList();
    private GamePanel gamePanel = new GamePanel(wordList, scorePanel);
    private MenuPanel menuPanel = new MenuPanel(this);

    private JSplitPane menuSplitPane = new JSplitPane();

    public GameFrame() {
        initMenuBar();
        initSplitPane();
        initFrame();
    }

    private void initFrame() {
        setTitle("VSCode Typing Game");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/vscode.png"));
        setResizable(false);
        setVisible(true);
    }

    private void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        bar.setBackground(new Color(60,60,60));
        bar.setBorder(BorderFactory.createEmptyBorder());
        this.setJMenuBar(bar);

        JMenu gameMenu = new JMenu("Game");
        initGameMenu(gameMenu);
        bar.add(gameMenu);

        JMenu editMenu = new JMenu("Edit");
        initEditMenu(editMenu);
        bar.add(editMenu);

        JMenu languageMenu = new JMenu("Language");
        initLanguageMenu(languageMenu);
        bar.add(languageMenu);
    }

    private void initLanguageMenu(JMenu languageMenu) {
        languageMenu.setForeground(Color.WHITE);
        JMenuItem clang = new JMenuItem("C/C++");
        languageMenu.add(clang);
        JMenuItem java = new JMenuItem("Java");
        languageMenu.add(java);
        JMenuItem python = new JMenuItem("Python");
        languageMenu.add(python);
    }

    private void initEditMenu(JMenu editMenu) {
        editMenu.setForeground(Color.WHITE);
        JMenuItem show = new JMenuItem("show");
        show.addActionListener(e -> gamePanel.startGame());
        editMenu.add(show);
    }

    private void initGameMenu(JMenu gameMenu) {
        gameMenu.setForeground(Color.WHITE);
        JMenuItem startGame = new JMenuItem("Start Game");
        startGame.addActionListener(e -> gamePanel.startGame());
        JMenuItem pauseGame = new JMenuItem("Pause Game");
        pauseGame.addActionListener(e -> gamePanel.pauseGame());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(1));
        gameMenu.add(startGame);
        gameMenu.add(pauseGame);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);
    }

    private void initSplitPane() {
        JSplitPane horizontalPane = new JSplitPane();
        horizontalPane.setDividerSize(0);
        horizontalPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        horizontalPane.setDividerLocation(300);
        horizontalPane.setBorder(BorderFactory.createEmptyBorder());

        menuSplitPane.setDividerSize(0);
        menuSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        menuSplitPane.setDividerLocation(50);
        menuSplitPane.setBorder(BorderFactory.createEmptyBorder());

        getContentPane().add(horizontalPane, BorderLayout.CENTER);
        horizontalPane.setLeftComponent(menuSplitPane);
        horizontalPane.setRightComponent(gamePanel);
        menuSplitPane.setLeftComponent(menuPanel);
        menuSplitPane.setRightComponent(scorePanel);
    }

    public void setScorePanel() {
        menuSplitPane.setRightComponent(scorePanel);
        menuSplitPane.setDividerLocation(50);
    }

    public void setEditPanel() {
        menuSplitPane.setRightComponent(editPanel);
        menuSplitPane.setDividerLocation(50);
    }
}
