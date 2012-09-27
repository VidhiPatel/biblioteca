import java.io.PrintStream;
import java.util.List;

public class ReserveBookAction extends Action {
    private Session session;
    private PrintStream printStream;
    private Input input;
    private List<Book> books;

    @Override
    public Boolean performAction() {
        if (!session.isLoggedIn()) {
            printStream.println("You need to Login to use this service.");
        } else {
            int bookNumber = input.getSelection();
            Book requestedBook = getRequestedBook(bookNumber);
            if (requestedBook != null) {
                requestedBook.reserved = true;
                printStream.println("Thank you! Enjoy the book " + requestedBook.name + ".");
            } else {
                printStream.println("Sorry! We do not have that book yet.");
            }
        }
        return false;

    }

    ReserveBookAction(Session session, PrintStream printStream, Input input, List<Book> books) {

        this.session = session;
        this.printStream = printStream;
        this.input = input;
        this.books = books;
    }

    private Book getRequestedBook(int bookNumber) {
        for (Book book : books) {
            if (book.checkNumber(bookNumber) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}
