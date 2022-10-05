package PracticeProblem;

import java.util.Scanner;

class Day {
    private String work;
    public void set(String work) { this.work = work; }
    public String get() { return work; }
    public void show() {
        if (work == null) System.out.println("없습니다.");
        else System.out.println(work + "입니다.");
    }
}

class MonthSchedule {
    Day[] days;

    private void inputDay() {
        System.out.print("날짜(1~30) >> ");
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        System.out.print("할일(빈칸없이입력) >> ");
        String work = scanner.next();
        days[day] = new Day();
        days[day].set(work);
    }

    private void showWork() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("날짜(1~30) >> ");
        int day = scanner.nextInt();
        System.out.println(day + "일의 할 일은 ");
        days[day].show();
    }

    private void init() {
        days = new Day[31];
        for (int i = 0; i < days.length; i++) {
            days[i] = new Day();
        }
    }

    private void run() {
        System.out.println("이번달 스케쥴 관리 프로그램.");
        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >> ");
            switch (scanner.nextInt()) {
                case 1 -> inputDay();
                case 2 -> showWork();
                case 3 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public static void main(String[] args) {
        MonthSchedule april = new MonthSchedule();
        april.run();
    }
}
