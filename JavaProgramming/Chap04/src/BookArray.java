import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

public class BookArray {
    Book[] books = null;
    private static Scanner scanner = new Scanner(System.in);

    public BookArray(int n) {
        books = new Book[n];
        for (int i = 0; i < books.length; i++) {
            System.out.print("제목을 입력해 주세요 >> ");
            String title = scanner.nextLine();
            System.out.print("저자를 입력해 주세요 >> ");
            String author = scanner.nextLine();

            books[i] = new Book(title, author);
        }
    }

    public void manage() {
        for (Book b : books) {
            System.out.println(b.getTitle() + ", " + b.getAuthor());
        }
    }

    public static void main(String[] args) {
        BookArray bookArray = new BookArray(2);
        bookArray.manage();
    }
}