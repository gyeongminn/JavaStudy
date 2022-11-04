import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyApp extends JFrame {
    public MyApp() {
        super("액션");
        setSize(300, 300);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("액션");
        b1.addActionListener(new MyAction());
        c.add(b1);
        JButton b2 = new JButton("액션");
        b2.addActionListener(new MyAction());
        c.add(b2);

        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new MyApp();
    }
}

class MyAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("액션")) {
            b.setText("빔");
        } else {
            b.setText("액션");
        }
    }
}
