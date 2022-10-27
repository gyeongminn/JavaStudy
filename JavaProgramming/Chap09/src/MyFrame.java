import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("300x300 스윙 프레임 만들기");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setBackground(Color.BLACK);
        c.add(new MyPanel(), BorderLayout.CENTER);
        c.add(new JButton("clear"), BorderLayout.SOUTH);
        setVisible(true);
    }

    private void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 5, 5, 5));

        contentPane.add(new JButton("7"));
        contentPane.add(new JButton("8"));
        contentPane.add(new JButton("9"));
        contentPane.add(new JButton("x"));
        contentPane.add(new JButton("4"));
        contentPane.add(new JButton("5"));
        contentPane.add(new JButton("6"));
        contentPane.add(new JButton("-"));
        contentPane.add(new JButton("1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("3"));
        contentPane.add(new JButton("+"));
        contentPane.add(new JButton("0"));
        contentPane.add(new JButton("00"));
        contentPane.add(new JButton("."));
        contentPane.add(new JButton("="));
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }

    static class MyPanel extends JPanel {
        public MyPanel() {
            setBackground(Color.BLUE);
            setLayout(null);

            for (int i = 0; i < 10; i++) {
                JButton b = new JButton(Integer.toString(i));
                b.setSize(50, 30);
                b.setLocation((i % 5) * 60, 50 + (i / 5) * 100);
                b.addActionListener(new MyAction());
                add(b);
            }
        }
    }

    static class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            b.setBackground(Color.RED);
            int w = b.getWidth() + 10;
            int h = b.getHeight() + 10;
            b.setSize(w, h);
            b.setLocation(b.getX()+50, b.getY());
            b.setEnabled(false);
            b.setVisible(false);
        }
    }
}
