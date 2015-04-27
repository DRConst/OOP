import javax.print.DocFlavor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diogo on 27/04/2015.
 */
public class Login
{
    private HashMap<String, byte[]> hashes, salts;

    public Login()
    {
        hashes = new HashMap<String, byte[]>();
        salts = new HashMap<String, byte[]>();
    }

    public Login(Login l)
    {
        hashes = l.getHashes();
        salts = l.getSalts();
    }

    public void registerUser(String userName, String password) throws IOException, NoSuchAlgorithmException {
        byte[] salt = genSalt();
        byte[] hash = genHash(salt, password);
        registerSalt(userName, salt);
        registerPw(userName, hash);
    }

    private void registerPw(String userName, byte[] hash)
    {
        /*TODO: decide policy on multiple registrations*/
        /*Placehoder: Just replaces the old entry*/
        if(hashes.containsKey(userName))
        {
            hashes.replace(userName, hash);
        }
        else
            hashes.put(userName, hash);
    }
    private void registerSalt(String userName, byte [] salt)
    {
        /*TODO: decide policy on multiple registrations*/
        /*Placehoder: Just replaces the old entry*/
        if(salts.containsKey(userName))
        {
            salts.replace(userName, salt);
        }
        else
            salts.put(userName, salt);
    }

    private byte[] genHash(byte[] salt, String password) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        bStream.write(salt);
        bStream.write(password.getBytes());
        md.update(bStream.toByteArray());
        return md.digest();
    }

    private byte[] genSalt()
    {
        byte[] toRet = new byte[128];
        new SecureRandom().nextBytes(toRet);
        return toRet;
    }


    public boolean equals(Object o)
    {
        if(this == o)
            return true;

        if(o == NULL || this.getClass() != o.getClass() ) {
            return false;
        }
        else
        {
            Login toTest = (Login) o;
            for(Map.Entry<String, byte[]> entry : toTest.getHashes().entrySet())
            {
                if(!hashes.containsKey(entry.getKey()) || Arrays.equals(entry.getValue(), hashes.get(entry.getKey())))
                    return false;
            }
            for(Map.Entry<String, byte[]> entry : toTest.getSalts().entrySet())
            {
                if(!salts.containsKey(entry.getKey()) || Arrays.equals(entry.getValue(), salts.get(entry.getKey())))
                    return false;
            }
            return true;
        }
    }

    public HashMap<String, byte[]> getHashes() {
        return hashes;
    }

    public HashMap<String, byte[]> getSalts() {
        return salts;
    }


}
