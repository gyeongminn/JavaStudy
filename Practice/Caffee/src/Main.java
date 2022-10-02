import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("안녕하세요~ 난정 카페에 오신 걸 환영합니다 ^_^");
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("---------------\n" +
                    "1. 주문하기\n" +
                    "2. 종료하기\n" +
                    "---------------\n" +
                    "어떻게 하시겠어요? >> ");
            try {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        order.run();
                    }
                    case 2 -> {
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}