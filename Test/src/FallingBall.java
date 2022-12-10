import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FallingBall extends JFrame {

    MyPanel myPanel = new MyPanel();
    Thread ballThread = new BallThread();
    Boolean flag = false;
    int x = 100, y = 30;

    public FallingBall() {
        setTitle("Falling Ball");
        setSize(300, 300);

        setContentPane(myPanel);
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!flag) {
                    x = 100;
                    y = 30;
                } else {
                    removeMouseListener(this);
                    System.out.println(1);
                }
                flag = !flag;
            }
        });
        ballThread.start();
    }

    public static void main(String[] args) {
        new FallingBall();
    }

    class BallThread extends Thread {

        @Override
        public void run() {
            while (true) {
                y += 10;
                if (flag) {
                    repaint();
                }
                try {
                    sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    class MyPanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            if (flag) {
                g.fillOval(x, y, 20, 20);
            }
        }
    }
}

