public class Book {
    private String name;
    private int number;

    Book(int number, String name) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return this.number + " : " + this.name;
    }
}
