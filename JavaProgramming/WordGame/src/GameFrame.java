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
        JMenu editMenu = new JMenu("Edit");

        initGameMenu(gameMenu);
        bar.add(gameMenu);

        initEditMenu(editMenu);
        bar.add(editMenu);
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
        horizontalPane.setBorder(new LineBorder(Color.GRAY));

        JSplitPane verticalPane = new JSplitPane();
        verticalPane.setDividerSize(0);
        verticalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        verticalPane.setDividerLocation(300);
        verticalPane.setBorder(new LineBorder(Color.GRAY));

        getContentPane().add(horizontalPane, BorderLayout.CENTER);
        horizontalPane.setLeftComponent(verticalPane);
        horizontalPane.setRightComponent(gamePanel);
        verticalPane.setTopComponent(scorePanel);
        verticalPane.setBottomComponent(editPanel);
    }
}
