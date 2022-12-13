package words;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class WordList {

    private Vector<String> words = new Vector<>(26000);

    public WordList() {
        loadWordFile("clang.txt");
    }

    public void loadWordFile(String file) {
        words.removeAllElements(); // 단어 리스트 초기화
        try {
            Scanner scanner = new Scanner(new FileReader(file));
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("cannot load file");
            System.exit(1);
        }
    }

    public Vector<String> getAllWords() {
        return words;
    }

    public String getWord() {
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }

    public void addWord(String word) {
        words.add(word.trim());
        try {
            FileWriter fw = new FileWriter("java.txt", true);
            fw.write(word.trim() + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}