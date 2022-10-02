import java.util.Scanner;

public class Main {
    private void init() {
        private Scanner s = new Scanner(System.in);
        System.out.println("TV 이름을 정해주세요>> ");
        tv = new TV(s.next());
    }

    private void run() {
        init();
        tv.channelUp();
        tv.powerChange();
        tv.channelDown();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerChange();
    }

    public static void main(String[] args) {
        Main tv = new Main();
        tv.run();
    }
}