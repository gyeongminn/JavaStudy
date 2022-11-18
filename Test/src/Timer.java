import static java.lang.Thread.sleep;

public class Timer {

    private void run() {
        int time = 10;
//        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            int cnt = 0;
            try {
                while (cnt < time) {
                    System.out.printf("\r%d", time - cnt);
                    cnt++;
                    sleep(1000);
                }
                System.out.println("\r타이머 종료!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public static void main(String[] args) {
        new Timer().run();
    }
}
