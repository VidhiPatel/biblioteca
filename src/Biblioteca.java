import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    private final List<Book> books;
    private final PrintStream printStream;
    private final Input input;

    public Biblioteca(PrintStream printStream, Input input, List<Book> books) {
        this.printStream = printStream;
        this.input = input;
        this.books = books;
    }

    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void displayMenu() {
        printStream.println("Please select option from the menu:");
        printStream.println("1. View all books.");
        printStream.println("2. Reserve a book");
        printStream.println("3. Check details");
        printStream.println("0. Exit");
        printStream.println("Enter your choice:");
    }

    public void performMenuSelection() {
        int selection = input.getSelection();
        switch (selection) {
            case 1:
                displayBooks();
                break;
            case 2:
                reserveBook();
                break;
            case 3:
                checkDetails();
                break;
            case 0:
                break;

            default:
                System.out.println("Invalid option");
        }
    }

    private void reserveBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            if (isBookAvailable(s)) {
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.println("Sorry! We do not have that book yet.");
            }

        } catch (IOException e) {
            System.out.println("Exception occurred");

        }


    }

    public boolean isBookAvailable(String s) {
        return false;
    }

    private void checkDetails() {
        System.out.println("Please talk to Librarian. Thank you.");
    }

    private void displayBooks() {
        for (Book book : books) {
            printStream.println(book.toString());
        }

    }
}
