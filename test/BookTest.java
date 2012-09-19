import junit.framework.TestCase;
import org.junit.Test;

public class BookTest extends TestCase {

    @Test
    public void testToString() throws Exception {
        assertEquals("1 : abc", new Book(1, "abc", false).toString());
    }

    @Test
    public void testCheckNumber() {
        assertTrue(new Book(1, "abc", false).checkNumber(1));
        assertFalse(new Book(1, "abc", false).checkNumber(2));
    }

    @Test
    public void testCheckReserved() {
        assertTrue(new Book(1,"abc",true).checkReserved());
        assertFalse(new Book(1,"abc",false).checkReserved());
    }
}
