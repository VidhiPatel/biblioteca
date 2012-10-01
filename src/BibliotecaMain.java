import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BibliotecaMain {

    private final Biblioteca biblioteca;
    private static Session session = new Session(null);
    private static Input input = new Input();
    public BibliotecaMain(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void run() {
        biblioteca.displayWelcome();
        Boolean continueLoop = true;
        while (continueLoop) {
            biblioteca.displayMenu();
            continueLoop = !biblioteca.performMenuSelection();
        }
    }

    public static void main(String[] args) {

        new BibliotecaMain(new Biblioteca(System.out, input, menu())).run();
    }


    private static List<User> users() {
        List<User> users = new ArrayList<User>();
        users.add(new User("111", "abc", "xyz", "abc@xyz.com", "123456", System.out));
        users.add(new User("112", "aaa", "bbb", "aaa@bbb.com", "123789", System.out));

        return users;
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "Alice in Wonderland", false));
        books.add(new Book(2, "Da Vinci Code", false));
        books.add(new Book(3, "Angels and Demons", false));
        books.add(new Book(4, "Chambers of Secret", false));
        books.add(new Book(5, "Deathly Hallows", false));
        return books;
    }

    private static List<Movie> movies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Sholay", "Ramesh Sippy", "1975", 8));
        movies.add(new Movie("abc", "xyz", "1970", -1));
        return movies;
    }

    private static HashMap<String, Action> menu() {
        HashMap<String, Action> menu = new HashMap<String, Action>();
        menu.put("1", new DisplayBooksAction(System.out, books()));
        menu.put("2", new ReserveBookAction(session, System.out, input, books()));
        menu.put("3", new DisplayMovieAction(movies(), System.out));
        menu.put("4", new DisplayLibraryDetailsAction(session, System.out));
        menu.put("5", new LoginAction(System.out, input, users(), session));
        menu.put("6", new LogoutAction(session, System.out));
        menu.put("0", new ExitAction());
        return menu;

    }
}




