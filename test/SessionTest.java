import junit.framework.TestCase;

public class SessionTest extends TestCase {
    public void testIsLoggedIn() throws Exception {
        assertFalse(new Session(null).isLoggedIn());
        User currentUser = new User("111", "abc", "xyz", "abc@xyz.com", "123", null);
        assertTrue(new Session(currentUser).isLoggedIn());
    }
}
