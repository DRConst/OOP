/**
 * Created by Diogo on 05/06/2015.
 */
public class UserAlreadyRegisteredException extends Exception {
    UserAlreadyRegisteredException()
    {
        super();
    }

    UserAlreadyRegisteredException(String s)
    {
        super(s);
    }
}
