package PracticeProblem;

import java.util.Scanner;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};
    public static String kor2Eng(String word) {
        for(int i = 0; i < kor.length; i++) {
            if (word.equals(kor[i])) {
                return eng[i];
            }
        }
        return null;
    }
}

class DicApp {
    Dictionary dictionary;
    private void search() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("한글 단어 >> ");
            String kor = scanner.nextLine();
            if (kor.equals("그만")) return;
            String eng = dictionary.kor2Eng(kor);
            if (eng == null) System.out.println(kor + "는 저의 사전에 없습니다.");
            else System.out.println(kor + "은(는) " + eng);
        }
    }

    private void run() {
        System.out.println("한영 단어 검색 프로그램입니다.");
        search();
    }

    public static void main(String[] args) {
        DicApp dicApp = new DicApp();
        dicApp.run();
    }
}
