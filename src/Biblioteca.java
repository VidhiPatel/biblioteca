import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    private final List<Book> books;
    private final List<Movie> movies;
    private final List<User> users;
    private final PrintStream printStream;
    private final Input input;
    private User currentUser;
    private boolean loggedIn;

    public Biblioteca(PrintStream printStream, Input input, List<Book> books, List<Movie> movies, List<User> users, User currentUser, boolean loggedIn) {
        this.printStream = printStream;
        this.input = input;
        this.books = books;
        this.movies = movies;
        this.users = users;
        this.currentUser = currentUser;
        this.loggedIn = loggedIn;
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
        int selection = input.getSelection();

            switch (selection) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    reserveBook();
                    break;
                case 3:
                    displayMovies();
                    break;
                case 4:
                    checkDetails();
                    break;
                case 5:
                    login();
                    break;
                case 6:
                    logout();
                    break;
                case 0:
                    return true;
                default:
                    printStream.println("Invalid option");
            }

        return false;
    }

    private void logout() {
        if (currentUser != null) {
            currentUser.logout();
            currentUser = null;
        }
        loggedIn = false;
        printStream.println("You are logged out.");
    }

    private void login() {
        printStream.println("Enter your Username :");
        String username = input.getString();
        printStream.println("Enter your Password :");
        String password = input.getString();
        if (tryLogin(username, password)) {
            loggedIn = true;
            printStream.println("You have successfully logged in.");
        } else {
            printStream.println("Invalid username or password.");
        }
    }

    private boolean tryLogin(String username, String password) {
        for (User user : users) {
            if (user.tryLogin(username, password)) {
                currentUser = user;
                return true;
            }

        }
        return false;
    }

    private void displayMovies() {
        for (Movie movie : movies) {
            printStream.println(movie.toString());
        }
    }

    private void reserveBook() {
        if (!loggedIn) {
            printStream.println("You need to Login to use this service.");
        } else {
            int bookNumber = input.getSelection();
            Book requestedBook = getRequestedBook(bookNumber);
            if (requestedBook != null) {
                requestedBook.reserved = true;
                printStream.println("Thank you! Enjoy the book " + requestedBook.name + ".");
            } else {
                printStream.println("Sorry! We do not have that book yet.");
            }
        }
    }

    private Book getRequestedBook(int bookNumber) {
        for (Book book : books) {
            if (book.checkNumber(bookNumber) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }

    private void checkDetails() {
        if (!loggedIn) {
            printStream.println("Please talk to Librarian. Thank you.");
        } else {
            currentUser.printDetails();
        }
    }

    private void displayBooks() {
        for (Book book : books) {
            printStream.println(book.toString());
        }

    }


}
