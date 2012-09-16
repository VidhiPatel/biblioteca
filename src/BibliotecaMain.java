import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/16/12
 * Time: 1:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class BibliotecaMain {

    static String[] Books = new String[10];
    static User u = new User("vidhi","1");
    public static void main(String[] args)
    {

        createBooks();
        System.out.println(displayWelcome());
        while (true)
        {
            displayMenu();
            performMenuSelection();
        }
    }

    private static void createBooks() {
        Books[0] = "aaa";
        Books[1] = "bbb";
        Books[2] = "ccc";
        Books[3] = "ddd";
        Books[4] = "fff";
        Books[5] = "eee";
        Books[6] = "ggg";
        Books[7] = "hhh";
        Books[8] = "iii";
        Books[9] = "jjj";


    }

    public static String displayWelcome() {
        return "Welcome to Biblioteca!";
    }
    public static void displayMenu()
    {
        System.out.println("Please select option from the menu:");
        System.out.println("1. View all books.");
        System.out.println("2. Reserve a book");
        System.out.println("3. Check details");
        System.out.println("Enter your choice:");
    }
    public static void performMenuSelection()
    {
        int selection = getSelection();
        switch (selection)
        {
            case 1 : displayBooks();
                    break;
            case 2 : reserveBook();
                    break;
            case 3 : checkDetails();
                    break;

            default:
                    System.out.println("Invalid option");
        }
    }

    private static void reserveBook() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            if(isBookAvailable(s))
            {
                  System.out.println("Thank you! Enjoy the book");
            }
            else
            {
                System.out.println("Sorry! We do not have that book yet.");
            }

        } catch (IOException e) {
            System.out.println("Exception occurred");

        }


    }
    public static boolean isBookAvailable(String s)
    {
        createBooks();
        for(int i=0 ; i< Books.length ; i++)
        {
            if(s.equals(Books[i]))
            {
                return true;
            }
        }
        return false;
    }
    private static void checkDetails() {
        System.out.println("User Name:" + u.getName());
        System.out.println("Library Number:" + u.getLibNumber());
        System.out.println("Please talk to Librarian. Thank you.");

    }

    private static void displayBooks() {
        for(int i=0; i<Books.length ; i++)
        {
            System.out.println(Books[i]);
        }


    }

    private static int getSelection() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = reader.readLine();
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Invalid integer");
            return 0;
        }





    }

    public static boolean isValidOption(int option) {

        return option == 1 || option == 2 || option == 3;
    }
}
