import java.util.Scanner;

public class PP0306 {
    public static void main(String[] args) {
        System.out.print("금액을 입력하시오 >> ");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();

        System.out.println("50000원 짜리 : " + money / 50000 + "개");
        money %= 50000;
        System.out.println("10000원 짜리 : " + money / 10000 + "개");
        money %= 10000;
        System.out.println("1000원 짜리 : " + money / 1000 + "개");
        money %= 1000;
        System.out.println("100원 짜리 : " + money / 100 + "개");
        money %= 100;
        System.out.println("10원 짜리 : " + money / 10 + "개");
        money %= 10;
        System.out.println("1원 짜리 : " + money + "개");
    }
}
