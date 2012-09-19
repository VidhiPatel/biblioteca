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

    public boolean performMenuSelection() {
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
                return true;
            default:
               printStream.println("Invalid option");
        }
        return false;
    }

    private void reserveBook() {
        int bookNumber = input.getSelection();
        Book requestedBook = getRequestedBook(bookNumber);
        if (requestedBook != null) {
            requestedBook.reserved = true;
            printStream.println("Thank you! Enjoy the book " + requestedBook.name +".");
        } else {
           printStream.println("Sorry! We do not have that book yet.");
        }
    }

    private Book getRequestedBook(int bookNumber) {
        for (Book book : books) {
            if (book.checkNumber(bookNumber) && book.isAvailable()) {
                return book;                       }
        }
        return null;
    }

    private void checkDetails() {
        printStream.println("Please talk to Librarian. Thank you.");
    }

    private void displayBooks() {
        for (Book book : books) {
            printStream.println(book.toString());
        }

    }
}
