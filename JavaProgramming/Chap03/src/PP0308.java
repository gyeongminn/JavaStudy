import java.util.Scanner;

public class PP0308 {
    public static void main(String[] args) {
        System.out.print("정수 몇개?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 99)+ 1;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
