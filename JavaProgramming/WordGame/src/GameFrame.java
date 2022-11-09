import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JButton startBtn = new JButton("Start");
    private JButton pauseBtn = new JButton("Pause");
    private ScorePanel scorePanel = new ScorePanel();

    public GameFrame() {
        initMenuBar();
        initToolBar();
        initSplitPane();
        initFrame();
    }

    private void initFrame() {
        setTitle("단어 게임");
        setSize(800, 600);
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
        verticalPane.setTopComponent(scorePanel);

        horizontalPane.setRightComponent(verticalPane);
    }
}
