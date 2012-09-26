import java.util.ArrayList;
import java.util.List;

public class BibliotecaMain {

    private final Biblioteca biblioteca;

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
        User currentUser = null;
        boolean loggedIn = false;
        new BibliotecaMain(new Biblioteca(System.out, new Input(), books(), movies(), users(), currentUser, loggedIn)).run();
    }



    private static List<User> users() {
        List<User> users = new ArrayList<User>();
        users.add(new User("111", "abc", "xyz", "abc@xyz.com", "123456", false, System.out));
        users.add(new User("112", "aaa", "bbb", "aaa@bbb.com", "123789", false, System.out));

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
}




