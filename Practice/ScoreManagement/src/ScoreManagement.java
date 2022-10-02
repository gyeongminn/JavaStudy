import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScoreManagement {
    private final Scanner scanner = new Scanner(System.in);
    private Student student;
    private Subject[] subjects;

    @Override
    public String toString() {
        return "--- 학생 프로필 ---" + "\n" +
                "이름 : " + student.getName() + "\n" +
                "학번: " + student.getId() + "\n" +
                "학년 : " + student.getGrade();
    }

    private void init() {
        try {
            System.out.print("학생의 이름을 입력해주세요 >> ");
            String name = scanner.nextLine();

            System.out.print("학번을 입력해주세요 >> ");
            String id = scanner.nextLine();

            System.out.print("학년을 입력해주세요 >> ");
            int grade = scanner.nextInt();

            System.out.print("몇 개의 과목을 수강하셨나요? >> ");
            int subjectNum = scanner.nextInt();
            scanner.nextLine();

            student = new Student(id, name, grade, subjectNum);
            subjects = new Subject[subjectNum];
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
            scanner.nextLine();
            init();
            return;
        }
    }

    private void setSubjects() {
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + "번째 과목 입력");
            try {
                System.out.print("과목명 >> ");
                String name = scanner.nextLine();

                System.out.print("점수 >> ");
                int score = scanner.nextInt();
                scanner.nextLine();

                subjects[i] = new Subject(name, score);
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
                scanner.nextLine();
                setSubjects();
                return;
            }
        }
    }

    private void setAvg() {
        double avg = 0;

        for (Subject subject : subjects) {
            avg += subject.getScore();
        }
        avg /= subjects.length;

        GradeCard gradeCard = new GradeCard(avg);
        student.setGradeCard(gradeCard);
    }

    private void printStudentProfile() {
        System.out.println(toString());
        System.out.println(student.getGradeCard().getAvgScore());
    }

    protected void run() {
        init();
        setSubjects();
        setAvg();
        printStudentProfile();
    }
}
