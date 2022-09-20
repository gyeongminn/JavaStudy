import java.util.Scanner;

public class PP0305 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.print("양의 정수 10개를 입력하시오 >> ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("3의 배수는 ");
        for (int n : arr) {
            if (n %3 == 0) {
                System.out.print(n + " ");
            }
        }
    }
}
