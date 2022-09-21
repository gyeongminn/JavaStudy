import java.util.InputMismatchException;
import java.util.Scanner;

public class PP0315 {
    private static void mul() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("곱하고자 하는 두 수 입력 >> ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(n + "x" + m + " = " + n * m);
        scanner.close();
    }
    public static void main(String[] args) {
        try {
            mul();
        } catch (InputMismatchException e) {
            System.out.println("실수는 입력하면 안 됩니다.");
            mul();
        }
    }
}
