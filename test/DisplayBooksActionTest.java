import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class DisplayBooksActionTest extends TestCase {
    private PrintStream mockPrintStream;
    private DisplayBooksAction displayBooksAction;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        displayBooksAction = new DisplayBooksAction(mockPrintStream,books());
    }
    private List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Alice in Wonderland", false));
        books.add(new Book(2, "Da Vinci Code", false));
        books.add(new Book(3, "Angels and Demons", false));
        books.add(new Book(4, "Chambers of Secret", false));
        books.add(new Book(5, "Deathly Hallows", false));
        return books;
    }
    public void testPerformAction() throws Exception {
        displayBooksAction.performAction();

        verify(mockPrintStream).println("1 : Alice in Wonderland");
        verify(mockPrintStream).println("2 : Da Vinci Code");
        verify(mockPrintStream).println("3 : Angels and Demons");
        verify(mockPrintStream).println("4 : Chambers of Secret");
        verify(mockPrintStream).println("5 : Deathly Hallows");

    }
}
