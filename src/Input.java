import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
    private final BufferedReader reader;

    public Input() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getSelection() {
        try {
            String s = reader.readLine();
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Invalid integer");
            return 0;
        }
    }
}
