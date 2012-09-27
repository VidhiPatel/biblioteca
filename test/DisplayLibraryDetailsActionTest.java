import junit.framework.TestCase;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayLibraryDetailsActionTest extends TestCase {

    private PrintStream mockPrintStream;
    private DisplayLibraryDetailsAction displayLibraryDetailsActionLoggedIn;
    private DisplayLibraryDetailsAction displayLibraryDetailsActionNotLoggedIn;
    private Session session;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);

        session = new Session(new User("111", "abc", "xyz", "abc@xyz.com", "123456", mockPrintStream));
        displayLibraryDetailsActionLoggedIn = new DisplayLibraryDetailsAction(session, mockPrintStream);
        displayLibraryDetailsActionNotLoggedIn = new DisplayLibraryDetailsAction(new Session(null), mockPrintStream);
    }

    public void testPerformActionLoggedIn() throws Exception {


        displayLibraryDetailsActionLoggedIn.performAction();
        verify(mockPrintStream).println("Name : abc");
        verify(mockPrintStream).println("Email : abc@xyz.com");
        verify(mockPrintStream).println("Phone Number : 123456");

    }

    public void testPerformActionNotLoggedIn() throws Exception {


        displayLibraryDetailsActionNotLoggedIn.performAction();
        verify(mockPrintStream).println("Please talk to Librarian. Thank you.");
    }
}
