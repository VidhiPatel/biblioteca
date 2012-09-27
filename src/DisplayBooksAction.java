import java.io.PrintStream;
import java.util.List;

public class DisplayBooksAction extends Action {
    private PrintStream printStream;
    private List<Book> books;

    DisplayBooksAction(PrintStream printStream, List<Book> books) {
        this.printStream = printStream;
        this.books = books;
    }

    DisplayBooksAction(Biblioteca biblioteca) {
        super(biblioteca);
    }

    @Override
    public Boolean performAction() {
        for (Book book : books) {
            printStream.println(book.toString());
        }
        return false;

    }
}
