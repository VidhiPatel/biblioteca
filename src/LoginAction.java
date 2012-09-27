import java.io.PrintStream;
import java.util.List;

public class LoginAction extends Action {
    private PrintStream printStream;
    private Input input;
    private List<User> users;
    private Session session;

    @Override
    public Boolean performAction() {

        printStream.println("Enter your Username :");
        String username = input.getString();
        printStream.println("Enter your Password :");
        String password = input.getString();
        if (tryLogin(username, password)) {

            printStream.println("You have successfully logged in.");
        } else {
            printStream.println("Invalid username or password.");
        }
        return false;
    }

    private boolean tryLogin(String username, String password) {
        for (User user : users) {
            if (user.tryLogin(username, password)) {

                session.setCurrentUser(user);
                return true;
            }

        }
        return false;
    }


    LoginAction(PrintStream printStream, Input input, List<User> users, Session session) {

        this.printStream = printStream;
        this.input = input;
        this.users = users;
        this.session = session;
    }
}
