import java.util.Scanner;

public class Order {
    private int number;
    private final int TIME = 3;

    public Order() {
        this.number = 0;
    }

    protected void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("주문자 성함을 말씀해주세요 >> ");
        Person person = new Person(scanner.next());

        System.out.print("주문하실 메뉴를 말씀해주세요 >> ");
        Drink drink = new Drink(scanner.next());

        for (int i = TIME; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
        System.out.println(++number + "번 " + person.getName() + "님 주문하신 " + drink.getName() + " 나왔습니다~");
    }
}
