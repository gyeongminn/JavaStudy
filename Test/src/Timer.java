import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

class PaintCanvas extends JFrame {
    static final int WIDTH = 50;
    static final int HEIGHT = 50;

    ArrayList<Point> pointList = new ArrayList<Point>();
    int dragId = -1;

    PaintCanvas() {
        super("PaintCanvas");

        registerEventListener();

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void registerEventListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pointList.add(e.getPoint());
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
//                getContentPane().setBackground(Color.WHITE);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    public void paint(Graphics g) {
        Color c = new Color(255, 0, 0);
        g.setColor(c);
        for (int i = 0; i < pointList.size(); i++) {
            g.fillOval((int) pointList.get(i).getX() - 25, (int) pointList.get(i).getY() - 25, WIDTH, HEIGHT);
        }
    }

    public static void main(String[] args) {
        new PaintCanvas();
    }
}
