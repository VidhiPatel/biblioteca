import junit.framework.TestCase;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayLibraryDetailsActionTest extends TestCase {
    private Biblioteca mockBiblioteca;
    private PrintStream mockPrintStream;
    private DisplayLibraryDetailsAction displayLibraryDetailsAction;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockBiblioteca = mock(Biblioteca.class);
        mockBiblioteca.printStream = mockPrintStream;
        displayLibraryDetailsAction = new DisplayLibraryDetailsAction(mockBiblioteca);
    }
    public void testPerformActionLoggedIn() throws Exception {
        mockBiblioteca.loggedIn = true;
        User currentUser = new User("111", "abc", "xyz", "abc@xyz.com", "123456", true, mockPrintStream);
        mockBiblioteca.currentUser = currentUser;
        displayLibraryDetailsAction.performAction();
        verify(mockPrintStream).println("Name : abc");
        verify(mockPrintStream).println("Email : abc@xyz.com");
        verify(mockPrintStream).println("Phone Number : 123456");

    }
    public void testPerformActionNotLoggedIn() throws Exception {
        mockBiblioteca.loggedIn = false;
        displayLibraryDetailsAction.performAction();
        verify(mockPrintStream).println("Please talk to Librarian. Thank you.");
    }
}
