import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private ImageIcon normalIcon = new ImageIcon("normal.png");
    private ImageIcon overedIcon = new ImageIcon("overed.png");
    private ImageIcon pressedIcon = new ImageIcon("pressed.png");

    private JButton startBtn = new JButton(normalIcon);
    private JButton pauseBtn = new JButton("Pause");

    private ScorePanel scorePanel = new ScorePanel();
    private EditPanel editPanel = new EditPanel();

    private WordList wordList = new WordList();
    private GamePanel gamePanel = new GamePanel(wordList, scorePanel);

    public GameFrame() {
        initMenuBar();
        initToolBar();
        initSplitPane();
        initFrame();
    }

    private void initFrame() {
        setTitle("단어 게임");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        JMenuItem newItem = new JMenuItem("New File");
        JMenuItem openItem = new JMenuItem("Open File");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
    }

    private void initToolBar() {
        JToolBar toolBar = new JToolBar();

        toolBar.add(startBtn);
        toolBar.add(pauseBtn);

        startBtn.setPressedIcon(pressedIcon);
        startBtn.setRolloverIcon(overedIcon);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.startGame();
            }
        });

        toolBar.add(new JTextField(20));
        toolBar.add(new JLabel("점심"));
        toolBar.add(new JCheckBox());

        getContentPane().add(toolBar, BorderLayout.NORTH);
    }

    private void initSplitPane() {
        JSplitPane horizontalPane = new JSplitPane();
        horizontalPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        horizontalPane.setDividerLocation(500);
        getContentPane().add(horizontalPane, BorderLayout.CENTER);

        JSplitPane verticalPane = new JSplitPane();
        verticalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        verticalPane.setDividerLocation(300);

        horizontalPane.setLeftComponent(gamePanel);
        horizontalPane.setRightComponent(verticalPane);

        verticalPane.setTopComponent(scorePanel);
        verticalPane.setBottomComponent(editPanel);
    }
}
