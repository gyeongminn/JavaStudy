import java.util.Scanner;


//public class WordGameApp {
class WordGameApp {
    //필드
    private final Scanner sc = new Scanner(System.in);
    private Player[] player;
    private String startWord = "아버지";
    private String lastWord;


    //메소드
    public void run() {
        System.out.print("참가인원은 몇 명? ");
        int np = sc.nextInt();
        Player[] player = new Player[np];

        for (int i = 0; i < np; i++) {
            System.out.print("참가자의 이름을 입력: ");
            String name = sc.next();
            player[i] = new Player(name);
        }

        System.out.println("게임을 시작합니다...");
        lastWord = "아버지";

        int i = 0;
        while (true) {
            startWord = player[i].getWordFromUser(); // 마지막 단어를 참가자의 단어로 변경
            if (!(player[i].checkSuccess(lastWord))) { // 성공 판별(실패: false)
                System.out.println(player[i].getName() + "이(가) 졌습니다.");
                break;
            }
            lastWord = startWord;

            i++; // 다음 참가자
            if (i == np) // 마지막 참가자 순서 이후 첫번째 참가자로 돌아감
                i = 0;
        }
    }

    public static void main(String[] args) {
        //객체 생성
        WordGameApp game = new WordGameApp();
        game.run();
    }
}

class Player {
    //필드+메소드+생성자
    //필드-특성, 상태 관련 변수
    private Scanner sc;
    private String name;
    private String word;

    //생성자
    Player(String name) {
        this.name = name;
        sc = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordFromUser() { //단어 받기
        sc = new Scanner(System.in);

        System.out.print(name + ">> ");
        this.word = sc.next();

        return word;
    }

    //메소드-객체기 할 수 있는 동작(기능, 함수)
    public boolean checkSuccess(String lastWord) {  //끝말잇기 성공여부
        int lastIndex = lastWord.length() - 1; // 마지막 문자에 대한 인덱스
        char lastChar = lastWord.charAt(lastIndex); // 마지막 문자
        char firstChar = this.word.charAt(0); // 첫번째 문자

        if (lastChar == firstChar) // 성공: true
            return true;
        else
            return false;
    }
}