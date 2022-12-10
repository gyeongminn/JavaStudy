import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setTitle("단어 게임");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("vscode.png"));
        setResizable(false);
        setVisible(true);
    }

    private void initMenuBar() {
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu sourceMenu = new JMenu("Source");

        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(sourceMenu);

        JMenuItem newItem = new JMenuItem("Start Game");
        newItem.addActionListener(e -> gamePanel.startGame());
        JMenuItem openItem = new JMenuItem("Open File");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    }

    private void initSplitPane() {
        JSplitPane horizontalPane = new JSplitPane();
        horizontalPane.setDividerSize(0);
        horizontalPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        horizontalPane.setDividerLocation(300);
        getContentPane().add(horizontalPane, BorderLayout.CENTER);

        JSplitPane verticalPane = new JSplitPane();
        verticalPane.setDividerSize(0);
        verticalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        verticalPane.setDividerLocation(300);

        horizontalPane.setLeftComponent(verticalPane);
        horizontalPane.setRightComponent(gamePanel);

        verticalPane.setTopComponent(scorePanel);
        verticalPane.setBottomComponent(editPanel);
    }
}
