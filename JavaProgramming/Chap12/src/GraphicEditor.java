import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GraphicEditor extends JFrame {
    private MyPanel myPanel;
    private Point startPoint = null;
    private Point draggedPoint = null;

    public GraphicEditor() {
        setTitle("Graphic Editor");
        setContentPane(new MyPanel());
        setSize(500, 500);
        setVisible(true);

    }

    class MyPanel extends JPanel {
        private Vector<Point> startVector = new Vector<>(30);
        private Vector<Point> endVector = new Vector<>(30);

        public MyPanel() {
            MyMouse myMouse = new MyMouse();
            this.addMouseListener(myMouse);
            this.addMouseMotionListener(myMouse);
        }

        class MyMouse extends MouseAdapter {

            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                startVector.add(startPoint);
                endVector.add(e.getPoint());
                repaint();
            }

            public void mouseDragged(MouseEvent e) {
                draggedPoint = e.getPoint();
                repaint();
            }
        }
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setColor(Color.BLUE);
            if (startPoint != null) {
                graphics.drawLine(startPoint.x, startPoint.y, draggedPoint.x, draggedPoint.y);
            }
            for (int i = 0; i < endVector.size(); i++) {
                graphics.drawLine(startVector.get(i).x, startVector.get(i).y, endVector.get(i).x, endVector.get(i).y);
            }
        }
    }

    public static void main(String[] args) {
        new GraphicEditor();
    }
}
