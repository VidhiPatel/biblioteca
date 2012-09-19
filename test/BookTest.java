import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/18/12
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookTest extends TestCase {

    @Test
    public void testToString() throws Exception {
        assertEquals("1 : abc",new Book(1, "abc").toString());
    }
}
