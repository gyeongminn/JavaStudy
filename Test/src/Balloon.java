import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Vector;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Balloon extends JFrame {

    ImageIcon img = new ImageIcon("balloon.png");
    Vector<JLabel> vector = new Vector<>(10);

    public Balloon() {
        setTitle("BALLOON");
        setSize(400, 400);
        setLayout(null);

        Container c = getContentPane();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JLabel label = new JLabel(img);
                label.setSize(50, 50);
                label.setLocation(e.getX(), e.getY());
                c.add(label);
                vector.add(label);
                repaint();
            }
        });

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (JLabel label : vector) {
                        int x = label.getX();
                        int y = label.getY() - 5;
                        if (y < 0) {
                            c.remove(label);
                        } else {
                            label.setLocation(x, y);
                        }
                    }
                    repaint();
                    try {
                        sleep(20);
                    } catch (InterruptedException e) {
                        System.out.println();
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        new Balloon();
    }
}
