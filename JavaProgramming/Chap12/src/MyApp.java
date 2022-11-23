import javax.swing.*;
import java.awt.*;

public class MyApp extends JFrame {

    private Image img = new ImageIcon("snowback.jpg").getImage();

    public MyApp() {
        setTitle("그래픽");
        setContentPane(new MyPanel());
        setSize(600, 600);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public MyPanel() {
            this.setBackground(Color.GRAY);
//            setLayout(null);
//            ImageIcon icon = new ImageIcon("son.png");
//            JLabel myImage = new JLabel(icon);
//            myImage.setSize(icon.getIconWidth(), icon.getIconHeight());
//            myImage.setLocation(10, 10);
//            add(myImage);
            add(new JButton(("hello")));
        }

        @Override
        public void paint(Graphics graphics) {
            super.paintComponent(graphics);
            graphics.setClip(200, 200, 100, 100);
            graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);

//            graphics.setColor(Color.BLUE);
//            graphics.fillRect(10, 10, 100, 100);
//            graphics.setColor(Color.MAGENTA);
//            graphics.setFont(new Font("Arial", Font.ITALIC, 50));
//            graphics.drawString("Java is Fantastic", 150, 150);
//            graphics.setColor(Color.YELLOW);
//            graphics.drawLine(0, 0, this.getWidth(), this.getHeight());
//            for (int i = 0; i < 10; i++) {
//                graphics.drawOval(10 * i + 100, 10 * i + 100, 10 * i + 100, 10 + i + 100);
//            }
        }
    }

    public static void main(String[] args) {
        new MyApp();
    }
}
