import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex02 extends JFrame {
    int x = 0, y = 0, diameter = 0;

    public Ex02() {
        setSize(400, 400);
        setTitle("원을 0.5초 간격으로 이동");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        panel.addMouseListener(new MyMouseListener());
        setContentPane(panel);

        setVisible(true);
    }

    class MyThread extends Thread {//랜덤한 (x, y) 생성해서 이 점을 중심으로 지름 50픽셀의 원을 만듬

        public void run() {
            while (true) {
                x = (int) (Math.random() * 400);
                y = (int) (Math.random() * 400);
                diameter = 50;
                repaint();
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    class MyPanel extends JPanel {//프레임에 원 그림

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(x, y, diameter, diameter);
        }

    }

    class MyMouseListener extends MouseAdapter {//마우스 클릭한 점의 x, y 좌표 읽음
        int num = 0;

        public void mouseClicked(MouseEvent e) {
            if (num == 0) {
                MyThread m = new MyThread();
                m.start();
            }
        }
    }

    public static void main(String[] args) {
        new Ex02();

    }
}

