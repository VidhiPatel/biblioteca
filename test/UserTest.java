import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/16/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTest extends TestCase {
    @Test
    public void testGetName()
    {

        assertEquals("abc",new User("abc","111").getName());

    }
    @Test
    public void testGetLibNumber()
    {
        assertEquals("111",new User("abc","111").getLibNumber());
    }

}

