import junit.framework.TestCase;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class BibliotecaTest extends TestCase {

    private Input mockInput;
    private PrintStream mockPrintStream;
    private Action mockAction1;
    private Action mockAction2;
    private Biblioteca biblioteca;


    protected void setUp() throws Exception {
        super.setUp();
        mockInput = mock(Input.class);
        mockPrintStream = mock(PrintStream.class);
        mockAction1 = mock(Action.class);
        mockAction2 = mock(Action.class);

        biblioteca = new Biblioteca(mockPrintStream,mockInput,menuWithMockActions());

    }

    private HashMap<String, Action> menuWithMockActions() {
        HashMap<String, Action> menu = new HashMap<String, Action>();
        menu.put("1", mockAction1);
        menu.put("2", mockAction2);
        return menu;

    }
    @Test
    public void testDisplayWelcome() {

        biblioteca.displayWelcome();

        verify(mockPrintStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void testDisplayMenu() {

        biblioteca.displayMenu();

        verify(mockPrintStream).println("Please select option from the menu:");
        verify(mockPrintStream).println("1. View all books.");
        verify(mockPrintStream).println("2. Reserve a book");
        verify(mockPrintStream).println("3. View movies");
        verify(mockPrintStream).println("4. Check details");
        verify(mockPrintStream).println("5. Login");
        verify(mockPrintStream).println("6. Logout");
        verify(mockPrintStream).println("0. Exit");
        verify(mockPrintStream).println("Enter your choice:");
    }
    @Test
    public void testPerformMenuSelectionValid(){
        when(mockInput.getString()).thenReturn("1");
        biblioteca.performMenuSelection();
        verify(mockAction1).performAction();
        when(mockInput.getString()).thenReturn("2");
        biblioteca.performMenuSelection();
        verify(mockAction2).performAction();

    }
    @Test
    public void testPerformMenuSelectionInValid(){
        when(mockInput.getString()).thenReturn("3");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Invalid Option.");


    }

}
