import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("전화 상담원 할당 방식을 선택하세요");
        System.out.println("R : 한명씩 차례대로");
        System.out.println("L : 대기가 적은 상담원 우선");
        System.out.println("P : 우선순위가 높은 고객우선 숙련도 높은 상담원");

        Scheduler scheduler = null;

        switch (System.in.read()) {
            case 'R', 'r' -> scheduler = new RoundRobin();
            case 'L', 'l' -> scheduler = new LeastJob();
            case 'P', 'p' -> scheduler = new PriorityAllocation();
            default -> System.out.println("지원되지 않는 기능입니다");
        }
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}