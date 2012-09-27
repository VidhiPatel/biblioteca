import java.io.PrintStream;
import java.util.HashMap;

public class Biblioteca {
    public PrintStream printStream;
    public Input input;
    private final HashMap<String, Action> menu;


    public Biblioteca(PrintStream printStream, Input input, HashMap<String, Action> menu) {
        this.printStream = printStream;
        this.input = input;
        this.menu = menu;


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
        if (menu.containsKey(selection)) {
            return menu.get(selection).performAction();
        } else {
            printStream.println("Invalid Option.");
            return false;
        }

    }


}
