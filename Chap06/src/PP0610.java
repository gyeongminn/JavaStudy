import java.util.Scanner;

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean turn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("[" + name + "]:<Enter>");
        scanner.nextLine(); // 엔터키 입력 기다린다.

        int n[] = new int[3];
        for (int i = 0; i < n.length; i++) {
            n[i] = (int) (Math.random() * 3 + 1);
            System.out.print("\t" + n[i]);
        }

        for (int i = 1; i < n.length; i++) {
            if (n[0] != n[i]) {
                return false;
            }
        }
        return true;
    }
}

class Game {
    private final int nPlayer = 2;
    private Player players[] = new Player[nPlayer];
    private final Scanner scanner = new Scanner(System.in);

    private void makePlayers() {
        for (int i = 0; i < nPlayer; i++) {
            System.out.print((i + 1) + "번째 선수 이름 >> ");
            players[i] = new Player(scanner.nextLine());
        }
    }

    public void start() {
        int idx = 0;
        while (true) {
            if (players[idx].turn()) {
                System.out.println("\t" + players[idx].getName() + " 님이 이겼습니다!");
                return;
            } else {
                System.out.println("\t아쉽군요!");
            }
            idx++;
            idx %= nPlayer;
        }
    }

    private void run() {
        makePlayers();
        start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}