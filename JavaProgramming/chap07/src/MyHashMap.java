import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MyHashMap {
    private static void searchHashMap(HashMap<String, String> dic) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("입력하세요 >> ");
            String eng = scanner.nextLine();
            if (eng.equals("exit")) return;
            String kor = dic.get(eng);
            if (kor == null) System.out.println(eng + "는 없는 단어입니다.");
            else System.out.println(eng + "는 한글로 " + kor);
        }
    }

    private static void fillHashMap(HashMap<String, String> dic, int n) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("영어 입력하세요 >> ");
            String eng = scanner.nextLine();
            System.out.print("한글 입력하세요 >> ");
            String kor = scanner.nextLine();
            dic.put(eng, kor);
            System.out.println();
        }
    }

    private static void printHashMap(HashMap<String, String> dic) {
        System.out.println("용량은 " + dic.size());

        Set<String> keys = dic.keySet();
        for (String s : keys) {
            System.out.print(s + " " + dic.get(s) + " ");
        }

//        Iterator<String> it = keys.iterator();
//
//        while (it.hasNext()) {
//            System.out.print(dic.get(it.next()) + " ");
//        }
    }
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String, String>();
        fillHashMap(dic, 3);
        printHashMap(dic);
        searchHashMap(dic);
    }
}
