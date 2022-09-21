import java.util.Scanner;

public class PP0316 {
    public static void main(String[] args) {
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        System.out.print("가위 바위 보! >> ");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("그만")) {
            return;
        }

        String str[] = {"가위", "바위", "보"};
        int n = (int) (Math.random() * 3);

        System.out.print("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", ");
        if (str[n].equals("가위")) {
            if (s.equals("가위")) {
                System.out.println("비겼습니다.");
            } else if (s.equals("바위")) {
                System.out.println("사용자가 이겼습니다.");
            } else if (s.equals("보")) {
                System.out.println("컴퓨터가 이겼습니다.");
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        } else if (str[n].equals("바위")) {
            if (s.equals("바위")) {
                System.out.println("비겼습니다.");
            } else if (s.equals("보")) {
                System.out.println("사용자가 이겼습니다.");
            } else if (s.equals("가위")) {
                System.out.println("컴퓨터가 이겼습니다.");
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        } else if (str[n].equals("보")) {
            if (s.equals("보")) {
                System.out.println("비겼습니다.");
            } else if (s.equals("가위")) {
                System.out.println("사용자가 이겼습니다.");
            } else if (s.equals("바위")) {
                System.out.println("컴퓨터가 이겼습니다.");
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
