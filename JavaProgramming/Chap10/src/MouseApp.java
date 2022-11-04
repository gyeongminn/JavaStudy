import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseApp extends JFrame {
    private JLabel textLabel = new JLabel("hello");

    public MouseApp() {
        super("마우스 이벤트");

        Container c = getContentPane();
        c.setLayout(null);

        textLabel.setSize(80, 20);
        textLabel.setLocation(10, 10);
        c.add(textLabel);

        MyMouse mouse = new MyMouse();
        c.addMouseListener(mouse);
        c.addMouseMotionListener(mouse);

        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = textLabel.getX();
                int y = textLabel.getY();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> y -= 10;
                    case KeyEvent.VK_DOWN -> y += 10;
                    case KeyEvent.VK_LEFT -> x -= 10;
                    case KeyEvent.VK_RIGHT -> x += 10;
                    case KeyEvent.VK_A -> {
                        Container c2 = (Container) e.getSource();
                        c2.add(textLabel);
                        c2.repaint();
                    }
                    case KeyEvent.VK_Q -> {
                        Container c = textLabel.getParent();
                        c.remove(textLabel);
                        c.repaint();
                    }
                }
                textLabel.setLocation(x, y);
            }
        });

        setSize(300, 300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    private void remove(KeyEvent e) {
        Container c = (Container) e.getSource();
        c.remove((Label) e.getSource());
    }

    public static void main(String[] args) {
        new MouseApp();
    }

    class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            textLabel.setLocation(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            textLabel.setLocation(e.getX(), e.getY());
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = (Component) e.getSource();
            component.setBackground(Color.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component component = (Component) e.getSource();
            component.setBackground(Color.GRAY);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            textLabel.setLocation(e.getX(), e.getY());
        }
    }
}
