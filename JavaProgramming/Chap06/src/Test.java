import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class MileageManager {
    private HashMap<String, Integer> map;

    public MileageManager() {
        map = new HashMap<String, Integer>();
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("이름과 마일리지 입력 >> ");
            String name = scanner.next();
            if (name.equals("그만")) break;
            int mileage = scanner.nextInt();
            scanner.nextLine();
            map.put(name, mileage);
        }
        scanner.close();
    }

    private void printAll() {
        Set<String> keys = map.keySet();
        for (String name : keys) {
            System.out.print("(" + name + "," + map.get(name) + ")");
        }
        System.out.println();
    }

    private String findMax() {
        Set<String> keys = map.keySet();
        int max = 0;
        String maxName = "";
        for (String name : keys) {
            if (max < map.get(name)) {
                max = map.get(name);
                maxName = name;
            }
        }
        return maxName;
    }


    private void run() {
        System.out.println("*** 한성항공마일리지 관리 프로그램입니다. ***");
        input();
        printAll();
        System.out.println("마일리지가 가장 높은 고객은 " + findMax() + "입니다.");
        System.out.println("*** 프로그램을 종료합니다 ***");
    }

    public static void main(String[] args) {
        MileageManager m = new MileageManager();
        m.run();
    }
}