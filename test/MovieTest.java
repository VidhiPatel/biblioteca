import junit.framework.TestCase;

public class MovieTest extends TestCase {
    public void testToString() throws Exception {
        assertEquals("abc : 1990 : xyz : *****", new Movie("abc", "xyz", "1990", 5).toString());
        assertEquals("abc : 1990 : xyz : rating not available", new Movie("abc", "xyz", "1990", -1).toString());
    }
}
