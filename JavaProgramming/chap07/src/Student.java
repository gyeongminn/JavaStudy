import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

class Student {
    private int id;
    private String name;
    private String tel;

    public Student(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + tel;
    }
}

class StudentManagement {
    private void search(Vector<Student> students) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만")) return;

            boolean isFound = false;
            for (Student student : students) {
                if (name.equals(student.getName())) {
                    System.out.println(student);
                    isFound = true;
                }
            }
            if (isFound) System.out.println("찾을 수 없습니다.");
        }
    }

    private void search(HashMap<String, Student> map) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("검색할 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만")) return;

            Student student = map.get(name);
            if (student == null) {
                System.out.println("찾을 수 없습니다.");
            } else {
                System.out.println(student);
            }
        }
    }

    private void run() {
        Vector<Student> students = new Vector<>();
        students.add(new Student(1, "황기태", "1111"));
        students.add(new Student(2, "이재문", "2222"));
        students.add(new Student(2, "장재영", "3333"));

        HashMap<String, Student> map = new HashMap<>();
        map.put("황기태", new Student(1, "황기태", "1111"));
        map.put("이재문", new Student(2, "이재문", "2222"));
        map.put("장재영", new Student(2, "장재영", "3333"));

        //search(students);
        search(map);
    }

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.run();
    }
}