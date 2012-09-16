import junit.framework.TestCase;


/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/16/12
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaMainTest extends TestCase {

    public void testDisplayWelcome()
     {


         assertEquals("Welcome to Biblioteca!",BibliotecaMain.displayWelcome());
     }
    public void testIsValidOption(){
         assertTrue(BibliotecaMain.isValidOption(1));
        assertTrue(BibliotecaMain.isValidOption(2));
        assertTrue(BibliotecaMain.isValidOption(3));
        assertFalse(BibliotecaMain.isValidOption(4));
    }
    public void testIsBookAvailable()
    {
        String s = "xxx";
        assertEquals(false,BibliotecaMain.isBookAvailable(s));
        s = "aaa";
        assertEquals(true,BibliotecaMain.isBookAvailable(s));
       // assertFalse(BibliotecaMain.isBookAvailable("xxx"));
    }



}
