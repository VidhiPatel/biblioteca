import junit.framework.TestCase;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutActionTest extends TestCase {

    private PrintStream mockPrintStream;
    private LogoutAction logoutAction;


    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);

        logoutAction = new LogoutAction(new Session(null), mockPrintStream);

    }

    public void testPerformAction() throws Exception {
        logoutAction.performAction();
        verify(mockPrintStream).println("You are logged out.");
    }
}
