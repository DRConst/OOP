import java.io.*;

/**
 * Created by Diogo on 14/05/2015.
 */
public class Serializer {

	public void writeObject(Object o)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(o.getClass().getName()));
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object readObject(String name)
	{
		Object toRet = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));
			toRet = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toRet;
	}
}
