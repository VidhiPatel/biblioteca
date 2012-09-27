import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class ReserveBookActionTest extends TestCase {

    private PrintStream mockPrintStream;
    private ReserveBookAction reserveBookActionLoggedIn;
    private ReserveBookAction reserveBookActionNotLoggedIn;
    private Input mockInput;
    private Session session;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockInput = mock(Input.class);
        session = new Session(new User("111", "abc", "xyz", "abc@xyz.com", "123", mockPrintStream));
        reserveBookActionLoggedIn = new ReserveBookAction(session, mockPrintStream, mockInput, books());
        reserveBookActionNotLoggedIn = new ReserveBookAction(new Session(null), mockPrintStream, mockInput, books());
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


        reserveBookActionNotLoggedIn.performAction();
        verify(mockPrintStream).println("You need to Login to use this service.");

    }

    public void testPerformActionCorrectBook() throws Exception {


        when(mockInput.getSelection()).thenReturn(3, 3);
        reserveBookActionLoggedIn.performAction();
        verify(mockPrintStream).println("Thank you! Enjoy the book Angels and Demons.");
        reserveBookActionLoggedIn.performAction();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");


    }

    public void testPerformActionIncorrectBook() throws Exception {


        when(mockInput.getSelection()).thenReturn(6);
        reserveBookActionLoggedIn.performAction();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");


    }
}
