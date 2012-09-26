import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayMovieActionTest extends TestCase {
    private Biblioteca mockBiblioteca;
    private PrintStream mockPrintStream;
    private DisplayMovieAction displayMovieAction;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockBiblioteca = mock(Biblioteca.class);
        mockBiblioteca.movies= movies();
        mockBiblioteca.printStream = mockPrintStream;
        displayMovieAction = new DisplayMovieAction(mockBiblioteca);
    }
    private List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Sholay", "Ramesh Sippy", "1975", 8));
        movies.add(new Movie("abc", "xyz", "1970", -1));
        return movies;
    }
    public void testPerformAction() throws Exception {
        displayMovieAction.performAction();
        verify(mockPrintStream).println("Sholay : 1975 : Ramesh Sippy : ********");
        verify(mockPrintStream).println("abc : 1970 : xyz : rating not available");

    }
}
