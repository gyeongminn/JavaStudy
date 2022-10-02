import java.util.Scanner;

abstract class Player {
    protected String[] bet = {"묵", "찌", "빠"};
    protected String name; // 선수 이름
    protected String lastBet = null; // 선수가 최근에 낸 값

    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBet() {
        return lastBet;
    }

    abstract public String next(); // 이 메소드가 호출되면 선수가 묵, 찌, 빠 중에서 1개를 결정하여 리턴한다.
}

class Human extends Player {
    protected Human(String name) {
        super(name);
    }

    @Override
    public String next() {
        Scanner scanner = new Scanner(System.in);
        String opt = scanner.nextLine(); // 묵,찌,빠 입력받기

        // 잘못 입력한 경우 체크
        for (String b : bet) {
            if (!opt.equals(b)) {
                System.out.println("잘못 입력하셨습니다.");
                return null;
            }
        }
        return opt;
    }
}

class Computer extends Player {
    protected Computer(String name) {
        super(name);
    }

    @Override
    public String next() {
        return null;
    }
}

class Game {
    private Player[] players;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        players = new Player[2];
    }

    private void init() {
        System.out.print("선수 이름 입력 >> ");
        players[0] = new Human(scanner.nextLine());

        System.out.print("컴퓨터 이름 입력 >> ");
        players[1] = new Computer(scanner.nextLine());
    }

    private void action() {
        for (int owner = 0; owner < players.length; owner++) {
            System.out.print(players[owner].getName() + " >> ");
            players[owner].next();
        }
    }

    protected void run() {
        System.out.println("묵찌빠 게임을 시작합니다.");
        init();
        System.out.println("2명의 선수를 생성 완료 했습니다.");
        action();
    }
}

public class MGPApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}