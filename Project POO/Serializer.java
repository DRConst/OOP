import java.io.*;

/**
 * Created by Diogo on 14/05/2015.
 */
public class Serializer {

	public static void writeObject(Object o)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(o.getClass().getName() + ".saved"));
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object readObject(String name)
	{
		Object toRet = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".saved"));
			toRet = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toRet;
	}
}
