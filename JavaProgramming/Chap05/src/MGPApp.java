import java.util.Scanner;

abstract class Player {
    protected String name; // 선수 이름
    protected String[] bet = {"묵", "찌", "빠"};
    protected int lastBet = 0; // 선수가 최근에 낸 값 (묵:0, 찌:1, 빠:2)

    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name; // 선수 이름을 리턴한다.
    }

    public String getBet() {
        return bet[lastBet]; // 선수가 낸 값을 문자열로 가져온다.
    }

    abstract public void next(); // 이 메소드가 호출되면 선수가 묵, 찌, 빠 중에서 1개를 결정하여 리턴한다.
}

class Human extends Player {
    protected Human(String name) {
        super(name); // 부모 클래스 생성자 호출
    }

    // 추상 함수 구현 메소드. 사람에게 묵,찌,빠를 입력받는다.
    @Override
    public void next() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(name + " >> ");
        String opt = scanner.nextLine(); // 묵,찌,빠 입력받기
        scanner.close();

        // 입력받은 값을 int로 바꿔 lastbet에 저장한다.
        for (int i = 0; i < bet.length; i++) {
            if (opt.equals(bet[i])) {
                lastBet = i;
                return;
            }
        }

        // 잘못 입력한 경우 다시 입력받는다.
        System.out.println("묵, 찌, 빠 중에서 입력하세요.");
        next();
    }
}

class Computer extends Player {
    protected Computer(String name) {
        super(name); // 부모 클래스 생성자 호출
    }

    // 추상 함수 구현 메소드. 컴퓨터가 묵,찌,빠를 결정한다.
    @Override
    public void next() {
        // Math.random()을 이용해 랜덤하게 결정한다.
        lastBet = (int) (Math.random() * 3);
        System.out.println(name + " >> 결정하였습니다.");
    }
}

class Game {
    private Player[] players;
    private int owner; // 현재 오너가 누구인지 나타낸다. (0~1)
    private final Scanner scanner = new Scanner(System.in);

    private int[][] result = { // 승패를 판별하기 위한 테이블 (2는 비김)
            {2, 0, 1},
            {1, 2, 0},
            {0, 1, 2}};

    // Game 클래스 생성자
    public Game() {
        players = new Player[2];
        owner = 0;
    }

    // 선수를 생성하는 메소드
    private void init() {
        System.out.print("선수 이름 입력 >> ");
        players[0] = new Human(scanner.nextLine());

        System.out.print("컴퓨터 이름 입력 >> ");
        players[1] = new Computer(scanner.nextLine());

        System.out.println("2명의 선수를 생성 완료 했습니다.\n");
    }

    // 가위바위보 진행하는 메소드
    private void action() {
        // 오너가 먼저 시작한다.
        for (int i = 0; i < players.length; i++) {
            players[owner].next();
            owner = (owner + 1) % players.length;
        }

        // 결정한 값을 출력한다.
        for (int i = 0; i < players.length; i++) {
            System.out.print(players[i].getName() + " : " + players[i].getBet() + ", ");
        }
        System.out.println("\n");
    }

    // 가위바위보 승, 패, 비김 판별하는 메소드
    private int judgment() {
        return result[players[0].lastBet][players[1].lastBet];
    }

    // 묵찌빠 진행하는 메소드
    private void start() {
        while (true) { // 묵찌빠 승패가 결정될 때까지 반복한다.
            action(); // 가위바위보를 진행한다.
            if (judgment() == 2) { // 가위바위보를 비겼으면, 묵찌빠 승패가 결정되었으니 종료한다.
                System.out.println(players[owner].getName() + "이(가) 이겼습니다.");
                return;
            } else {
                owner = judgment(); // 가위바위보 규칙에 따라 오너를 변경한다.
            }
        }
    }

    protected void run() {
        System.out.println("묵찌빠 게임을 시작합니다.\n");
        init(); // 선수를 생성한다.
        start(); // 게임을 시작한다.
        System.out.println("게임을 종료합니다.");
    }
}

public class MGPApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}