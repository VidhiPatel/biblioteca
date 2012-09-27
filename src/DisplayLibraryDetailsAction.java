import java.io.PrintStream;

public class DisplayLibraryDetailsAction extends Action {
    private Session session;
    private PrintStream printStream;

    @Override
    public Boolean performAction() {
        if (!session.isLoggedIn()) {
            printStream.println("Please talk to Librarian. Thank you.");
        } else {
            session.getCurrentUser().printDetails();
        }
        return false;

    }

    DisplayLibraryDetailsAction(Session session, PrintStream printStream) {

        this.session = session;
        this.printStream = printStream;
    }
}
