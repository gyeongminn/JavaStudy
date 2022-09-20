import java.util.Scanner;

public class EX0204 {
    public static void main(String[] args) {
        System.out.println("이름 도시 나이 체중 독신여부 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        String city = scanner.next();
        int age = scanner.nextInt();
        double weight = scanner.nextDouble();
        boolean isSingle = scanner.nextBoolean();
        scanner.close();

        System.out.println("이름은 " + name +"이고, 사는 곳은 " + city + "이며, 나이는 " + age + "살입니다.");
        System.out.println("체중은 " + weight + " 이며, 독신 여부는 " + isSingle + "입니다.");
    }
}
