public class ReserveBookAction extends Action {
    @Override
    public Boolean performAction() {
        if (!biblioteca.loggedIn) {
            biblioteca.printStream.println("You need to Login to use this service.");
        } else {
            int bookNumber = biblioteca.input.getSelection();
            Book requestedBook = getRequestedBook(bookNumber);
            if (requestedBook != null) {
                requestedBook.reserved = true;
                biblioteca.printStream.println("Thank you! Enjoy the book " + requestedBook.name + ".");
            } else {
                biblioteca.printStream.println("Sorry! We do not have that book yet.");
            }
        }
        return false;

    }

    ReserveBookAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
    private Book getRequestedBook(int bookNumber) {
        for (Book book : biblioteca.books) {
            if (book.checkNumber(bookNumber) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}
