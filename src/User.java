/**
 * Created with IntelliJ IDEA.
 * User: vidhi
 * Date: 9/16/12
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String name;
    private String libNumber;

    User(String name, String libNumber)
    {

        this.name = name;
        this.libNumber = libNumber;
    }

    public String getName() {

        return this.name;
    }

    public String getLibNumber() {

        return this.libNumber;
    }
}
