import junit.framework.TestCase;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginActionTest extends TestCase {
    private Biblioteca mockBiblioteca;
    private PrintStream mockPrintStream;
    private LoginAction loginAction;
    private Input mockInput;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
        mockInput = mock(Input.class);
        mockBiblioteca = mock(Biblioteca.class);
        mockBiblioteca.printStream = mockPrintStream;
        mockBiblioteca.input = mockInput;
        mockBiblioteca.users = users();
        loginAction = new LoginAction(mockBiblioteca);

    }
    private List<User> users() {
        List<User> users = new ArrayList<User>();

        users.add(new User("111", "abc", "xyz", "abc@xyz.com", "123456", false, mockPrintStream));
        users.add(new User("112", "aaa", "bbb", "aaa@bbb.com", "123789", false, mockPrintStream));
        return users;
    }
    public void testPerformActionValid() throws Exception {
        when(mockInput.getString()).thenReturn("111", "xyz");
        loginAction.performAction();
        verify(mockPrintStream).println("Enter your Username :");
        verify(mockPrintStream).println("Enter your Password :");
        verify(mockPrintStream).println("You have successfully logged in.");
    }
    public void testPerformActionInValid() throws Exception {
        when(mockInput.getString()).thenReturn("112", "xyz");
        loginAction.performAction();
        verify(mockPrintStream).println("Enter your Username :");
        verify(mockPrintStream).println("Enter your Password :");
        verify(mockPrintStream).println("Invalid username or password.");
    }
}
