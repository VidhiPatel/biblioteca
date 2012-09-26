import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;

public class Biblioteca {
    public List<Book> books;
    public List<Movie> movies;
    public List<User> users;
    public PrintStream printStream;
    public Input input;
    public User currentUser;
    public boolean loggedIn;
    private final HashMap<String,Action> menu;



    public Biblioteca(PrintStream printStream, Input input, List<Book> books, List<Movie> movies, List<User> users, User currentUser, boolean loggedIn) {
        this.printStream = printStream;
        this.input = input;
        this.books = books;
        this.movies = movies;
        this.users = users;
        this.currentUser = currentUser;
        this.loggedIn = loggedIn;
        menu = createMenu();

    }
    private HashMap<String, Action> createMenu() {
        HashMap<String,Action> menu = new HashMap<String, Action>();
        menu.put("1",new DisplayBooksAction(printStream,books));
        menu.put("2",new ReserveBookAction(this));
        menu.put("3",new DisplayMovieAction(this));
        menu.put("4",new DisplayLibraryDetailsAction(this));
        menu.put("5",new LoginAction(this));
        menu.put("6",new LogoutAction(this));
        menu.put("0",new ExitAction(this));
        return menu;

    }

    public void displayWelcome() {
        printStream.println("Welcome to Biblioteca!");
    }

    public void displayMenu() {
        printStream.println("Please select option from the menu:");
        printStream.println("1. View all books.");
        printStream.println("2. Reserve a book");
        printStream.println("3. View movies");
        printStream.println("4. Check details");
        printStream.println("5. Login");
        printStream.println("6. Logout");
        printStream.println("0. Exit");
        printStream.println("Enter your choice:");
    }

    public boolean performMenuSelection() {

        String selection = input.getString();
        if(menu.containsKey(selection))
        {
        return menu.get(selection).performAction();
        }
        else
        {
            printStream.println("Invalid Option.");
            return false;
        }

    }


}
