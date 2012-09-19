public class Movie {
    private final String name;
    private final String director;
    private final String year;
    private int rating;

    Movie(String name, String director, String year, int rating) {

        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    private String rating() {
        if (this.rating > 0) {
            String res = "";
            for(int i=0; i<rating ;i++)
            {
                res += "*";
            }
            return res;
        }
        return "rating not available";
    }

    public String toString() {
        return name + " : " + year + " : " + director + " : " + rating();
    }
}

