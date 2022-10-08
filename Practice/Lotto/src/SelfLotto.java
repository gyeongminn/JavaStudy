import java.util.Scanner;

public class SelfLotto extends Lotto{
    @Override
    public int[] generate() {
        int[] lotto = new int[SIZE];
        Scanner scanner = new Scanner(System.in);
        System.out.print("로또 번호를 입력해 주세요 >> ");
        for (int i = 0; i < SIZE; i++) {
            lotto[i] = scanner.nextInt();
        }
        return lotto;
    }
}
