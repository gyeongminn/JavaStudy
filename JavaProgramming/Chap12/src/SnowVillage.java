import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class SnowVillage extends JFrame {

    public SnowVillage() {
        setTitle("눈 내리는 샤갈의 마을");
        setContentPane(new MyPanel());
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class MyPanel extends JPanel {

        private final int SNOW_NUM = 50;
        private final int SNOW_SIZE = 10;

        private Image image = new ImageIcon("snowback.jpg").getImage();
        private Vector<Point> snowVector = new Vector<>(50);
        SnowThread snowThread = new SnowThread();

        public MyPanel() {
            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    makeSnow();
                    snowThread.start();
                    MyPanel.this.removeComponentListener(this);
                }
            });

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!snowThread.getStopFlag()) {
                        snowThread.stopSnow();
                    } else {
                        snowThread.resumeSnow();
                    }
                }
            });
        }

        private void makeSnow() {
            for (int i = 0; i < SNOW_NUM; i++) {
                int x = (int) (Math.random() * this.getWidth());
                int y = (int) (Math.random() * this.getHeight());
                snowVector.add(new Point(x, y));
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

            g.setColor(Color.WHITE);
            for (int i = 0; i < SNOW_NUM; i++) {
                g.fillOval(snowVector.get(i).x, snowVector.get(i).y, SNOW_SIZE, SNOW_SIZE);
            }
        }

        class SnowThread extends Thread {

            private boolean stopFlag = false;

            public boolean getStopFlag() {
                return stopFlag;
            }

            public void stopSnow() {
                stopFlag = true;
            }

            synchronized public void resumeSnow() {
                stopFlag = false;
                this.notify(); // 이 객체를 무한대기하는 쓰레드를 깨운다.
            }

            synchronized private void waitFlag() {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            private void changeSnowPosition() {
                for (Point point : snowVector) {
                    int dir = Math.random() > 0.5 ? 1 : -1;
                    point.setLocation((point.getX() + dir) % getWidth(), (point.getY() + 1) % getHeight());
                }
            }

            @Override
            public void run() {
                while (true) {
                    if (stopFlag) {
                        waitFlag(); // 무한 대기, notify()가 불려질 때까지.
                    }
                    changeSnowPosition();
                    repaint();
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new SnowVillage();
    }
}
