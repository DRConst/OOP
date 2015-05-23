import java.io.*;

/**
 * Created by Diogo on 14/05/2015.
 */
public class Serializer {

	public static void writeObject(Object o) throws IOException {

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(o.getClass().getName() + ".saved"));
			oos.writeObject(o);
			oos.close();
	}

	public static Object readObject(String name) throws IOException, ClassNotFoundException {
		Object toRet = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name + ".saved"));
		toRet = ois.readObject();
		ois.close();
		return toRet;
	}
}
