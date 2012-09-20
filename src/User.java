import java.io.PrintStream;

public class User {
    private String libraryNumber;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean loggedIn;
    private final PrintStream printStream;

    public User(String libraryNumber, String name, String password, String email, String phoneNumber, boolean loggedIn, PrintStream printStream) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loggedIn = loggedIn;
        this.printStream = printStream;
    }

    public boolean tryLogin(String libraryNumber, String password) {
        if (this.libraryNumber.equals(libraryNumber) && this.password.equals(password)) {
            this.loggedIn = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void printDetails() {
        printStream.println("Name : " + name);
        printStream.println("Email : " + email);
        printStream.println("Phone Number : " + phoneNumber);
    }

    public void logout() {
        loggedIn = false;
    }
}
