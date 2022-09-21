/**
 * 객체지향언어2 8반
 * 과제2. 4장 클래스 만들기 - 2번
 * 2171333 이경민
 */
import java.util.InputMismatchException;
import java.util.Scanner;

class Song {
    private String name;
    private String composer;
    private String singer;

    public Song(String name, String composer, String singer) {
        this.name = name;
        this.composer = composer;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public String getComposer() {
        return composer;
    }

    public String getSinger() {
        return singer;
    }
}

public class Album {
    Song[] songs = null;

    public void search(String name) {
        for (Song song : songs) {
            if (song.getName().equals(name)) {
                System.out.println(song.getName() + ", " + song.getSinger() +", " + song.getComposer());
                return;
            }
        }
        System.out.println(name + " 곡은 없습니다.");
        return;
    }

    private void run() {
        System.out.println("한성 축제 앨범의 곡을 저장합니다.");
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        System.out.print("곡 개수는? ");

        try {
            num = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("잘못 입력하셨습니다.");
            run();
            return;
        }

        songs = new Song[num];

        for (int i = 0; i < num; i++) {
            System.out.print("곡명? ");
            String name = scanner.nextLine();
            System.out.print("작곡가? ");
            String composer = scanner.nextLine();
            System.out.print("가수명? ");
            String singer = scanner.nextLine();

            songs[i] = new Song(name, composer, singer);
        }

        while (true) {
            System.out.print("검색할 곡명을 입력하세요 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만")) {
                break;
            } else {
                search(name);
            }
        }
    }

    public static void main(String[] args) {
        Album album = new Album();
        album.run();
    }
}
