import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyApp extends JFrame {
    private JLabel text1 = new JLabel("0");
    private JLabel text2 = new JLabel("0");

    public MyApp() {
        super("스레드 연습");
        Container c = getContentPane();
        c.setLayout(null);

        text1.setSize(100, 40);
        text2.setSize(100, 40);
        text1.setLocation(50, 50);
        text2.setLocation(150, 50);
        text1.setFont(new Font("Gothic", Font.ITALIC, 30));
        text2.setFont(new Font("Gothic", Font.ITALIC, 30));

        c.add(text1);
        c.add(text2);

        setSize(300, 300);
        setVisible(true);

        TimerThread thread1 = new TimerThread("lee", text1, 100);
        thread1.start();
        TimerThread thread2 = new TimerThread("kim", text2, 1000);
        thread2.start();

        text1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (thread1.isAlive()) {
                    thread1.interrupt();
                } else {
                    System.out.println(thread1.getName() + "는 종료하였습니다." + thread1.count);
                }
            }
        });
    }

    class TimerThread extends Thread {
        private JLabel text = null;
        private int delay = 0;
        private int count = 0;

        public TimerThread(String name, JLabel text, int delay) {
            super(name);
            this.text = text;
            this.delay = delay;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(delay);
                    count++;
                    text.setText(Integer.toString(count));
//                    if (currentThread().getName().equals("lee")) {
//                        int x = (int) (Math.random() * text.getParent().getWidth());
//                        int y = (int) (Math.random() * text.getParent().getHeight());
//                        text.setLocation(x, y);
//                    }
                } catch (InterruptedException e) {
                    System.out.println("RETURN");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
        new MyApp();
    }
}
