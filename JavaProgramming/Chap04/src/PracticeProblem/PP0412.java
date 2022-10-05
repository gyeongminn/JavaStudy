package PracticeProblem;

import java.util.Scanner;

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BookingManager {
    Book[][] books;
    private Scanner scanner = new Scanner(System.in);

    private void printSeats(int grade) {
        System.out.print((char) (grade + 'A' - 1) + " >> ");
        for (int i = 0; i < 10; i++) {
            System.out.print((books[grade - 1][i].getName()) + " ");
        }
        System.out.println();
    }

    private void booking() {
        System.out.printf("좌석 구분 S(1) A(2) B(3) >> ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        printSeats(grade);

        System.out.print("이름 >> ");
        String name = scanner.nextLine();

        System.out.print("번호 >> ");
        int num = scanner.nextInt();

        scanner.nextLine();
        books[grade-1][num - 1].setName(name);
    }

    private void check() {
        for (int i = 0; i < 3; i++) {
            printSeats(i + 1);
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    private int search(int grade, String name) {
        for (int i = 0; i < 10; i++) {
            if (books[grade - 1][i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void cancel() {
        System.out.printf("좌석 S(1) A(2) B(3) >> ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("이름 >> ");
        String name = scanner.nextLine();

        int idx = search(grade, name);
        if (idx == -1) {
            System.out.println("잘못 입력하셨습니다.");
        } else {
            books[grade-1][idx].setName("---");
        }
    }

    private void init() {
        books = new Book[3][10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                books[i][j] = new Book("---");
            }
        }
    }

    private void run() {
        System.out.println("명품 콘서트홀 예약 시스템입니다.");
        init();
        while (true) {
            System.out.print("\n예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
            switch (scanner.nextInt()) {
                case 1 -> booking();
                case 2 -> check();
                case 3 -> cancel();
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        bookingManager.run();
    }
}
