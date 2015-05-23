/**
 * Created by Diogo on 27/04/2015.
 */

import javax.print.DocFlavor; //não sei se o professor vai gostar deste import
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public boolean authenticateUser(String userName, String password) throws IOException, NoSuchAlgorithmException {

        byte[] salt;
        byte[] hash;

        if(!salts.containsKey(userName) || !hashes.containsKey(userName))
            return false;

        salt = salts.get(userName);
        hash = genHash(salt, password);

        if(Arrays.equals(hashes.get(userName), hash))
            return true;
        else
            return false;
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

        if(o == null || this.getClass() != o.getClass() ) {
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

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Salts-");
        for(Map.Entry<String, byte[]> entry : salts.entrySet())
        {
            sb.append(entry.getKey());
	        sb.append(":");
            sb.append(entry.getValue());
	        sb.append(";");
        }
        sb.append("\nHashes-");
        for(Map.Entry<String, byte[]> entry : hashes.entrySet())
        {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
	        sb.append(";");
        }

        return sb.toString();
    }

	public Login clone(Login l)
	{
		return new Login(l);
	}
}

