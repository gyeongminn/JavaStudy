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
        try {
            Scanner scanner = new Scanner(new FileReader("words.txt"));
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
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
            FileWriter fw = new FileWriter("words.txt", true);
            fw.write(word.trim() + "\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}