import java.util.ArrayList;
import java.util.List;

public class BibliotecaMain {
    public static void main(String[] args) {

        new BibliotecaMain().run();
    }
    private void run()
    {
        Biblioteca biblioteca = new Biblioteca(System.out,new Input(),books());
        biblioteca.displayWelcome();
        Boolean isExit = false;
        while (!isExit)
        {
            biblioteca.displayMenu();
            isExit = biblioteca.performMenuSelection();
        }
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




