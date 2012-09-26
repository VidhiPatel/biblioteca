public class DisplayLibraryDetailsAction extends Action {
    @Override
    public Boolean performAction() {
        if (!biblioteca.loggedIn) {
            biblioteca.printStream.println("Please talk to Librarian. Thank you.");
        } else {
            biblioteca.currentUser.printDetails();
        }
        return false;

    }

    DisplayLibraryDetailsAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
