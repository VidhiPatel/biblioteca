public class LoginAction extends Action {
    @Override
    public Boolean performAction() {

        biblioteca.printStream.println("Enter your Username :");
        String username = biblioteca.input.getString();
        biblioteca.printStream.println("Enter your Password :");
        String password = biblioteca.input.getString();
        if (tryLogin(username, password)) {
            biblioteca.loggedIn = true;
            biblioteca.printStream.println("You have successfully logged in.");
        } else {
            biblioteca.printStream.println("Invalid username or password.");
        }
        return false;
    }
    private boolean tryLogin(String username, String password) {
        for (User user : biblioteca.users) {
            if (user.tryLogin(username, password)) {
                biblioteca.currentUser = user;
                return true;
            }

        }
        return false;
    }


    LoginAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
