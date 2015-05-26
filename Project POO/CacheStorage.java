
import java.io.Serializable;
import java.util.TreeMap;

/**
 * Created by Diogo on 14/05/2015.
 */
public class CacheStorage implements Serializable {
	private TreeMap<String, Cache> db;

	public CacheStorage()
	{
		db = new TreeMap<>();
	}

	public CacheStorage(TreeMap<String, Cache> tM)
	{
		db = new TreeMap<>();
		for(Cache c : tM.values())
		{
			db.put(c.getCode(), c);
		}
	}


	public void saveCache(Cache c)
	{
		db.put(c.getCode(), c);
	}

	public Cache getCache(String code)
	{
		return db.get(code);
	}
}
