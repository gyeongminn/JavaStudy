/**
 * 자바 스터디 과제
 * 끝말잇기 프로그램
*/
import java.util.InputMismatchException;
import java.util.Scanner;

class Player {
    private String name;
    private String word;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean checkSuccess(String previousWord) {
        int lastIdx = previousWord.length() - 1;
        if (previousWord.charAt(lastIdx) == this.word.charAt(0)) {
            return true;
        } else {
            return false;
        }
    }
}


class WorldGameApp {
    private int nPlayer;
    private final static Scanner scanner = new Scanner(System.in);

    private void run() {
        try {
            System.out.println("끝말잇기 게임을 시작합니다...");
            System.out.print("게임에 참가하는 인원은 몇 명입니까 >> ");

            this.nPlayer = scanner.nextInt();
            Player[] players = new Player[nPlayer];

            for (int i = 0; i < nPlayer; i++) {
                System.out.print("참가자의 이름을 입력하세요 >> ");
                players[i] = new Player(scanner.next());
            }

            System.out.println("시작하는 단어는 아버지 입니다.");
            players[nPlayer - 1].setWord("아버지");

            while (true) {
                for (int i = 0; i < nPlayer; i++) {
                    System.out.print(players[i].getName() + " >> ");
                    players[i].setWord(scanner.next());
                    if (!players[i].checkSuccess(players[(i + nPlayer - 1) % nPlayer].getWord())) {
                        System.out.println(players[i].getName() + "이(가) 졌습니다.");
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("게임을 재실행 합니다.");
            scanner.nextLine();
            run();
        }
    }

    public static void main(String[] args) {
        WorldGameApp game = new WorldGameApp();
        game.run();
    }
}