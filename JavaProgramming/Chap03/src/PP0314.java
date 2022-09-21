import java.util.Scanner;

public class PP0314 {
    public static String[] course = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
    public static int[] score = {95, 88, 76, 62, 55};

    private static boolean searchByCourseName(String name) {
        for (int i = 0; i < course.length; i++) {
            if (course[i].equals(name)) {
                System.out.println(name + "의 점수는 " + score[i]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("과목 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만"))
                return;
            if (!searchByCourseName(name)) {
                System.out.println("없는 과목입니다.");
            }
        }
    }
}
