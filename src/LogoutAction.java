import java.io.PrintStream;

public class LogoutAction extends Action {
    private Session session;
    private PrintStream printStream;

    @Override
    public Boolean performAction() {


        session.setCurrentUser(null);
        printStream.println("You are logged out.");
        return false;
    }

    LogoutAction(Session session, PrintStream printStream) {

        this.session = session;
        this.printStream = printStream;
    }
}
