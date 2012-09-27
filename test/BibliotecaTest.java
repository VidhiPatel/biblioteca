import junit.framework.TestCase;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

public class BibliotecaTest extends TestCase {

    private Input mockInput;
    private PrintStream mockPrintStream;
    private Biblioteca biblioteca;
    private Biblioteca bibliotecaLoggedIn;
    private User mockCurrentUser;
    private String libraryNumber1 = "111";
    private Session mockSession;
    private Action mockAction1;
    private Action mockAction2;
    private Biblioteca bibliotecaMockMenu;


    protected void setUp() throws Exception {
        super.setUp();
        mockInput = mock(Input.class);
        mockPrintStream = mock(PrintStream.class);
        mockCurrentUser = mock(User.class);
        mockSession = mock(Session.class);
        mockAction1 = mock(Action.class);
        mockAction2 = mock(Action.class);
        biblioteca = new Biblioteca(mockPrintStream, mockInput, menu());
        bibliotecaMockMenu = new Biblioteca(mockPrintStream,mockInput,menuWithMockActions());
        bibliotecaLoggedIn = new Biblioteca(mockPrintStream, mockInput, menu());
    }

    private List<User> users() {
        List<User> users = new ArrayList<User>();

        users.add(new User(libraryNumber1, "abc", "xyz", "abc@xyz.com", "123456", mockPrintStream));
        users.add(new User("112", "aaa", "bbb", "aaa@bbb.com", "123789", mockPrintStream));
        return users;
    }

    private List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Sholay", "Ramesh Sippy", "1975", 8));
        movies.add(new Movie("abc", "xyz", "1970", -1));
        return movies;
    }
    private HashMap<String, Action> menuWithMockActions() {
        HashMap<String, Action> menu = new HashMap<String, Action>();
        menu.put("1", mockAction1);
        menu.put("2", mockAction2);
        return menu;

    }
    private HashMap<String, Action> menu() {
        HashMap<String, Action> menu = new HashMap<String, Action>();
        menu.put("1", new DisplayBooksAction(mockPrintStream, books()));
        menu.put("2", new ReserveBookAction(mockSession, mockPrintStream, mockInput, books()));
        menu.put("3", new DisplayMovieAction(movies(), mockPrintStream));
        menu.put("4", new DisplayLibraryDetailsAction(mockSession, mockPrintStream));
        menu.put("5", new LoginAction(mockPrintStream, mockInput, users(), mockSession));
        menu.put("6", new LogoutAction(mockSession, mockPrintStream));
        menu.put("0", new ExitAction());
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
        bibliotecaMockMenu.performMenuSelection();
        verify(mockAction1).performAction();
        when(mockInput.getString()).thenReturn("2");
        bibliotecaMockMenu.performMenuSelection();
        verify(mockAction2).performAction();

    }
    @Test
    public void testPerformMenuSelectionInValid(){
        when(mockInput.getString()).thenReturn("3");
        bibliotecaMockMenu.performMenuSelection();
        verify(mockPrintStream).println("Invalid Option.");


    }

    @Test
    public void testPerformMenuSelectionForOption1() {
        when(mockInput.getString()).thenReturn("1");

        biblioteca.performMenuSelection();

        verify(mockPrintStream).println("1 : Alice in Wonderland");
        verify(mockPrintStream).println("2 : Da Vinci Code");
        verify(mockPrintStream).println("3 : Angels and Demons");
        verify(mockPrintStream).println("4 : Chambers of Secret");
        verify(mockPrintStream).println("5 : Deathly Hallows");
    }

    @Test
    public void testPerformMenuSelectionForOption2NotLoggedIn() {

        when(mockInput.getString()).thenReturn("2");

        biblioteca.performMenuSelection();

        verify(mockPrintStream).println("You need to Login to use this service.");

    }

    @Test
    public void testPerformMenuSelectionForOption2CorrectBook() {
        when(mockInput.getString()).thenReturn("2", "2");
        when(mockInput.getSelection()).thenReturn(3, 3);
        when(mockSession.isLoggedIn()).thenReturn(true);
        bibliotecaLoggedIn.performMenuSelection();

        verify(mockPrintStream).println("Thank you! Enjoy the book Angels and Demons.");
        bibliotecaLoggedIn.performMenuSelection();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");


    }

    @Test
    public void testPerformMenuSelectionForOption2IncorrectBook() {
        when(mockInput.getString()).thenReturn("2");
        when(mockInput.getSelection()).thenReturn(8);
        when(mockSession.isLoggedIn()).thenReturn(true);
        new Biblioteca(mockPrintStream, mockInput, menu()).performMenuSelection();
        verify(mockPrintStream).println("Sorry! We do not have that book yet.");
    }

    @Test
    public void testPerformMenuSelectionForOption3() {
        when(mockInput.getString()).thenReturn("3");

        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Sholay : 1975 : Ramesh Sippy : ********");
        verify(mockPrintStream).println("abc : 1970 : xyz : rating not available");
    }

    @Test
    public void testPerformMenuSelectionForOption0() {
        when(mockInput.getString()).thenReturn("0");

        assertTrue(biblioteca.performMenuSelection());
    }

    @Test
    public void testPerformMenuSelectionForOption4() {
        when(mockInput.getString()).thenReturn("4");

        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Please talk to Librarian. Thank you.");
        when(mockSession.isLoggedIn()).thenReturn(true);
        User currentUser = new User("111", "abc", "xyz", "abc@xyz.com", "123456", mockPrintStream);
        when(mockSession.getCurrentUser()).thenReturn(currentUser);
        new Biblioteca(mockPrintStream, mockInput, menu()).performMenuSelection();
        verify(mockPrintStream).println("Name : abc");
        verify(mockPrintStream).println("Email : abc@xyz.com");
        verify(mockPrintStream).println("Phone Number : 123456");

    }

    @Test
    public void testPerformMenuSelectionForOption4WithLoginLogout() {
        //without Login
        when(mockInput.getString()).thenReturn("4");
        biblioteca.performMenuSelection();
        verify(mockPrintStream, atLeastOnce()).println("Please talk to Librarian. Thank you.");
        //Login

        when(mockInput.getString()).thenReturn("5", "111", "xyz");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Enter your Username :");
        verify(mockPrintStream).println("Enter your Password :");
        verify(mockPrintStream).println("You have successfully logged in.");
        //After Login
        when(mockInput.getString()).thenReturn("4");
        when(mockSession.isLoggedIn()).thenReturn(true);
        when(mockSession.getCurrentUser()).thenReturn(new User(libraryNumber1, "abc", "xyz", "abc@xyz.com", "123456", mockPrintStream));
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Name : abc");
        verify(mockPrintStream).println("Email : abc@xyz.com");
        verify(mockPrintStream).println("Phone Number : 123456");
        //Logout
        when(mockInput.getString()).thenReturn("6");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("You are logged out.");
        //After Logout
        when(mockInput.getString()).thenReturn("4");
        biblioteca.performMenuSelection();
        verify(mockPrintStream, atLeastOnce()).println("Please talk to Librarian. Thank you.");

    }

    @Test
    public void testPerformMenuSelectionForOption5Valid() {


        when(mockInput.getString()).thenReturn("5", "111", "xyz");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Enter your Username :");
        verify(mockPrintStream).println("Enter your Password :");
        verify(mockPrintStream).println("You have successfully logged in.");

    }

    @Test
    public void testPerformMenuSelectionForOption5Invalid() {

        when(mockInput.getString()).thenReturn("5", "112", "xyz");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Enter your Username :");
        verify(mockPrintStream).println("Enter your Password :");
        verify(mockPrintStream).println("Invalid username or password.");

    }

    @Test
    public void testPerformMenuSelectionForOption6() {
        when(mockInput.getString()).thenReturn("6");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("You are logged out.");
    }


    @Test
    public void testPerformMenuSelectionForInvalidOption() {
        when(mockInput.getString()).thenReturn("8");
        biblioteca.performMenuSelection();
        verify(mockPrintStream).println("Invalid Option.");
    }


    private List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Alice in Wonderland", false));
        books.add(new Book(2, "Da Vinci Code", false));
        books.add(new Book(3, "Angels and Demons", false));
        books.add(new Book(4, "Chambers of Secret", false));
        books.add(new Book(5, "Deathly Hallows", false));
        return books;
    }
}
