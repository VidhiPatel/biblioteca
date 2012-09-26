import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class ReserveBookActionTest extends TestCase {
    private Biblioteca mockBiblioteca;
    private PrintStream mockPrintStream;
    private ReserveBookAction reserveBookAction;
    private Input mockInput;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockInput = mock(Input.class);
        mockBiblioteca = mock(Biblioteca.class);
        mockBiblioteca.books = books();
        mockBiblioteca.printStream = mockPrintStream;
        mockBiblioteca.input = mockInput;
        reserveBookAction = new ReserveBookAction(mockBiblioteca);
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
    public void testPerformActionNotLoggedIn() throws Exception {
        mockBiblioteca.loggedIn = false;
        reserveBookAction.performAction();
        verify(mockPrintStream).println("You need to Login to use this service.");

    }
    public void testPerformActionCorrectBook() throws Exception {
        mockBiblioteca.loggedIn = true;
        when(mockInput.getSelection()).thenReturn(3,3);
        reserveBookAction.performAction();
        verify(mockPrintStream).println("Thank you! Enjoy the book Angels and Demons.");
        reserveBookAction.performAction();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");


    }
    public void testPerformActionIncorrectBook() throws Exception {
        mockBiblioteca.loggedIn = true;
        when(mockInput.getSelection()).thenReturn(6);
        reserveBookAction.performAction();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");


    }
}
