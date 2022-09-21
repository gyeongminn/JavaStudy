/**
 * 과제 1 2-3장 연습 과제 2번
 * 2171333 이경민
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 학생 리스트 클래스
 */
class StudentList {
    final int SIZE = 10; // 배열 사이즈 상수
    private static int[] idList; // 학번 배열
    private static int[] scoreList; // 점수 배열

    /**
     * 생성자 함수
     */
    public StudentList() {
        idList = new int[SIZE];
        scoreList = new int[SIZE];
        init();
    }

    /**
     * 배열에 값 넣는 함수
     * <p>Scanner로 int값을 받는다.
     * @throws InputMismatchException
     */
    private void init() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " >> ");
            try {
                idList[i] = scanner.nextInt();
                scoreList[i] = scanner.nextInt();
            } catch (InputMismatchException e) { // 입력값이 정수가 아닐 경우
                scanner.nextLine();
                System.out.println("경고!! 정수를 입력하세요.");
                i -= 1; // 다시 입력받기
            }
        }
        scanner.close();
    }

    /**
     * 학번 배열 반환 함수
     * @return idList
     */
    public int[] getIdList() {
        return idList;
    }

    /**
     * 점수 배열 반환 함수
     * @return scoreList
     */
    public int[] getScoreList() {
        return scoreList;
    }

    /**
     * 학번으로 학생을 찾아 점수를 출력하는 함수
     * @param id 찾고자 하는 학생의 학번
     */
    public static void searchWithId(int id) {
        for (int i = 0; i < idList.length; i++) {
            if (idList[i] == id) {
                System.out.println("학번이 " + id + "인 학생의 점수는 " + scoreList[i] + "입니다.");
                return;
            }
        }
        System.out.println("학번이 " + id + "인 학생은 없습니다.");
    }

    /**
     * 점수로 학생을 찾아 학번을 출력하는 함수
     * @param score 찾고자 하는 학생의 점수
     */
    public static void searchWithScore(int score) {
        System.out.print("점수가 " + score + "인 학생은 ");
        boolean isFound = false; // 탐색에 성공했는지 여부
        for (int i = 0; i < scoreList.length; i++) {
            if (scoreList[i] == score) {
                isFound = true;
                System.out.print(idList[i] + " ");
            }
        }
        if (isFound) { // 탐색에 성공한 경우
            System.out.println("입니다.");
        } else { // 탐색에 실패한 경우
            System.out.println("없습니다.");
        }
    }
}

/**
 * 실행 클래스
 */
class Process {
    /**
     * 실제 실행 함수
     * @param studentList 학생리스트 클래스
     */
    public static void run(StudentList studentList) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3 >> ");
            try {
                switch (scanner.nextInt()) {
                    case 1 -> { // 학번으로 검색
                        System.out.print("학번 >> ");
                        studentList.searchWithId(scanner.nextInt());
                    }

                    case 2 -> { // 점수로 검색
                        System.out.print("점수 >> ");
                        studentList.searchWithScore(scanner.nextInt());
                    }

                    case 3 -> { // 프로그램 종료
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }

                    default -> { // 잘못 입력한 경우
                        System.out.println("잘못 입력하셨습니다.");
                    }
                }
                scanner.close();
            } catch (InputMismatchException e) {
                System.out.println("경고!! 정수를 입력하세요.");
                scanner.nextLine();
            }
        }
    }

    /**
     * 메인 함수
     * @param args
     */
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        run(studentList);
    }
}