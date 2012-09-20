import junit.framework.TestCase;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserTest extends TestCase {
    private PrintStream mockPrintStream;

    protected void setUp() throws Exception {
        super.setUp();
        mockPrintStream = mock(PrintStream.class);
    }

    public void testTryLogin() throws Exception {
        assertTrue(new User("111", "vidhi", "abc", "vkp.987", "123", false, mockPrintStream).tryLogin("111", "abc"));
        assertFalse(new User("111", "vidhi", "abc", "vkp.987", "123", false, mockPrintStream).tryLogin("111", "xyz"));
        assertFalse(new User("111", "vidhi", "abc", "vkp.987", "123", false, mockPrintStream).tryLogin("112", "abc"));

    }

    public void testPrintDetails() throws Exception {
        new User("111", "vidhi", "abc", "vkp.987", "123", false, mockPrintStream).printDetails();
        verify(mockPrintStream).println("Name : vidhi");
        verify(mockPrintStream).println("Email : vkp.987");
        verify(mockPrintStream).println("Phone Number : 123");

    }
}
