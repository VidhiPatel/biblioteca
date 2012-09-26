import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutActionTest extends TestCase {
    private Biblioteca mockBiblioteca;
    private PrintStream mockPrintStream;
    private LogoutAction logoutAction;
    private Input mockInput;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockInput = mock(Input.class);
        mockBiblioteca = mock(Biblioteca.class);
        mockBiblioteca.printStream = mockPrintStream;
        mockBiblioteca.input = mockInput;
        mockBiblioteca.users = users();
        logoutAction = new LogoutAction(mockBiblioteca);

    }
    private List<User> users() {
        List<User> users = new ArrayList<User>();

        users.add(new User("111", "abc", "xyz", "abc@xyz.com", "123456", false, mockPrintStream));
        users.add(new User("112", "aaa", "bbb", "aaa@bbb.com", "123789", false, mockPrintStream));
        return users;
    }
    public void testPerformAction() throws Exception {
        logoutAction.performAction();
        verify(mockPrintStream).println("You are logged out.");
    }
}
