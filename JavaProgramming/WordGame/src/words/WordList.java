package words;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public String getWord() {
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }
}