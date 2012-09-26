public class DisplayMovieAction extends Action {
    @Override
    public Boolean performAction() {

        for (Movie movie : biblioteca.movies) {
            biblioteca.printStream.println(movie.toString());
        }
        return false;
    }

    DisplayMovieAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
