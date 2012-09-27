import java.io.PrintStream;

public class User {
    private String libraryNumber;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private final PrintStream printStream;

    public User(String libraryNumber, String name, String password, String email, String phoneNumber, PrintStream printStream) {
        this.libraryNumber = libraryNumber;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.printStream = printStream;
    }

    public boolean tryLogin(String libraryNumber, String password) {
        return this.libraryNumber.equals(libraryNumber) && this.password.equals(password);
    }

    public void printDetails() {
        printStream.println("Name : " + name);
        printStream.println("Email : " + email);
        printStream.println("Phone Number : " + phoneNumber);
    }


}
