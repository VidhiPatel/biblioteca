import junit.framework.TestCase;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest extends TestCase {

    private Input mockInput;
    private PrintStream mockPrintStream;
    private Biblioteca biblioteca;

    protected void setUp() throws Exception {
        super.setUp();
        mockInput = mock(Input.class);
        mockPrintStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(mockPrintStream, mockInput, books(), movies());
    }

    private List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Sholay", "Ramesh Sippy", "1975", 8));
        movies.add(new Movie("abc", "xyz", "1970", -1));
        return movies;
    }

    @Test
    public void testDisplayWelcome() {

        biblioteca.displayWelcome();

        verify(mockPrintStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void testDisplayMenu() {

        biblioteca.displayMenu();

        verify(mockPrintStream).println("Please select option from the menu:");
        verify(mockPrintStream).println("1. View all books.");
        verify(mockPrintStream).println("2. Reserve a book");
        verify(mockPrintStream).println("3. View movies");
        verify(mockPrintStream).println("4. Check details");
        verify(mockPrintStream).println("0. Exit");
        verify(mockPrintStream).println("Enter your choice:");
    }

    @Test
    public void testPerformMenuSelectionForOption1() {
        when(mockInput.getSelection()).thenReturn(1);

        biblioteca.performMenuSelection();

        verify(mockPrintStream).println("1 : Alice in Wonderland");
        verify(mockPrintStream).println("2 : Da Vinci Code");
        verify(mockPrintStream).println("3 : Angels and Demons");
        verify(mockPrintStream).println("4 : Chambers of Secret");
        verify(mockPrintStream).println("5 : Deathly Hallows");
    }

    @Test
    public void testPerformMenuSelectionForOption2CorrectBook() {
        when(mockInput.getSelection()).thenReturn(2, 3, 2, 3);

        biblioteca.performMenuSelection();

        verify(mockPrintStream).println("Thank you! Enjoy the book Angels and Demons.");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");

    }

    @Test
    public void testPerformMenuSelectionForOption2IncorrectBook() {
        when(mockInput.getSelection()).thenReturn(2, 6);

        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");
    }

    @Test
    public void testPerformMenuSelectionForOption3() {
        when(mockInput.getSelection()).thenReturn(3);

        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Sholay : 1975 : Ramesh Sippy : 8");
        verify(mockPrintStream).println("abc : 1970 : xyz : rating not available");
    }

    @Test
    public void testPerformMenuSelectionForOption0() {
        when(mockInput.getSelection()).thenReturn(0);

        assertTrue(biblioteca.performMenuSelection());
    }

    @Test
    public void testPerformMenuSelectionForInvalidOption() {
        when(mockInput.getSelection()).thenReturn(6);
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Invalid option");
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
}
