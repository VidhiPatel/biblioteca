public class Book {
    public final String name;
    public final int number;
    public boolean reserved;

    Book(int number, String name,Boolean reserved) {
        this.name = name;
        this.number = number;
        this.reserved = reserved;
    }

    public String toString() {
        return this.number + " : " + this.name;
    }

    public Boolean checkNumber(int number) {
        return this.number == number;
    }

    public boolean checkReserved() {
        return this.reserved;
    }

    boolean isAvailable() {
        return !reserved;
    }
}
