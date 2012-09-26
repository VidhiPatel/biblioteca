public class LogoutAction extends Action {
    @Override
    public Boolean performAction() {
        if (biblioteca.currentUser != null) {
            biblioteca.currentUser.logout();
            biblioteca.currentUser = null;
        }
        biblioteca.loggedIn = false;
        biblioteca.printStream.println("You are logged out.");
        return false;
    }

    LogoutAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
