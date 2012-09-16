import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/16/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTest extends TestCase {
    public void testGetName()
    {

        assertEquals("abc",new User("abc","111").getName());

    }
    public void testGetLibNumber()
    {
        assertEquals("111",new User("abc","111").getLibNumber());
    }

}

