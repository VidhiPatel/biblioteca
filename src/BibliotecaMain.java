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
            continueLoop = biblioteca.performMenuSelection();
        }
    }

    public static void main(String[] args) {
        new BibliotecaMain(new Biblioteca(System.out, new Input(), books())).run();
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
}




