import java.io.PrintStream;
import java.util.List;

public class DisplayMovieAction extends Action {
    private List<Movie> movies;
    private PrintStream printStream;

    DisplayMovieAction(List<Movie> movies, PrintStream printStream) {
        this.movies = movies;
        this.printStream = printStream;
    }

    @Override
    public Boolean performAction() {

        for (Movie movie : movies) {
            printStream.println(movie.toString());
        }
        return false;
    }

    DisplayMovieAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
