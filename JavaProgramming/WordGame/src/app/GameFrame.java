package app;

import words.WordList;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private ScorePanel scorePanel = new ScorePanel();

    private WordList wordList = new WordList();
    private EditPanel editPanel = new EditPanel(wordList);
    private GamePanel gamePanel = new GamePanel(wordList, scorePanel);
    private MenuPanel menuPanel = new MenuPanel(this);
    private JPanel statusPanel = new JPanel();
    private SettingPanel settingPanel = new SettingPanel();
    private JSplitPane menuSplitPane = new JSplitPane();

    public GameFrame() {
        initMenuBar();
        initSplitPane();
        initStatusPane();
        initFrame();
    }

    private void initStatusPane() {
        statusPanel.setLayout(new BorderLayout());
        statusPanel.setBackground(new Color(62, 120, 201));

        JLabel nameLabel = new JLabel("2171333 이경민 ");
        nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        nameLabel.setForeground(Color.WHITE);
        statusPanel.add(nameLabel, BorderLayout.EAST);

        JLabel titleLabel = new JLabel(" VSCode Typing Game");
        titleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        titleLabel.setForeground(Color.WHITE);
        statusPanel.add(titleLabel, BorderLayout.WEST);
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

        JMenu viewMenu = new JMenu("View");
        initViewMenu(viewMenu);
        bar.add(viewMenu);

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

    private void initViewMenu(JMenu editMenu) {
        editMenu.setForeground(Color.WHITE);

        JMenuItem show = new JMenuItem("Score");
        show.addActionListener(e -> setScorePanel());
        editMenu.add(show);

        JMenuItem edit = new JMenuItem("Edit");
        edit.addActionListener(e -> setEditPanel());
        editMenu.add(edit);

        JMenuItem setting = new JMenuItem("Settings");
        setting.addActionListener(e -> setSettingPanel());
        editMenu.add(setting);
    }

    private void initGameMenu(JMenu gameMenu) {
        gameMenu.setForeground(Color.WHITE);

        JMenuItem startGame = new JMenuItem("Start Game");
        startGame.addActionListener(e -> gamePanel.startGame());
        gameMenu.add(startGame);

        JMenuItem pauseGame = new JMenuItem("Pause Game");
        pauseGame.addActionListener(e -> gamePanel.pauseGame());
        gameMenu.add(pauseGame);

        JMenuItem stopGame = new JMenuItem("Stop Game");
        stopGame.addActionListener(e -> gamePanel.gameOver());
        gameMenu.add(stopGame);
        gameMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(1));
        gameMenu.add(exitItem);
    }

    private void initSplitPane() {
        JSplitPane verticalPane = new JSplitPane();
        verticalPane.setDividerSize(0);
        verticalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        verticalPane.setDividerLocation(720);
        verticalPane.setBorder(BorderFactory.createEmptyBorder());

        JSplitPane horizontalPane = new JSplitPane();
        horizontalPane.setDividerSize(0);
        horizontalPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        horizontalPane.setDividerLocation(300);
        horizontalPane.setBorder(BorderFactory.createEmptyBorder());

        menuSplitPane.setDividerSize(0);
        menuSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        menuSplitPane.setDividerLocation(50);
        menuSplitPane.setBorder(BorderFactory.createEmptyBorder());

        getContentPane().add(verticalPane,BorderLayout.CENTER);
        verticalPane.setTopComponent(horizontalPane);
        verticalPane.setBottomComponent(statusPanel);
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

    public void setSettingPanel() {
        menuSplitPane.setRightComponent(settingPanel);
        menuSplitPane.setDividerLocation(50);
    }
}
