/**
 * Classe que implementa um comparador para a classe Cache
 *
 * @version (2015.04.29)
 */

import java.util.*;
import java.io.Serializable;

public class CacheComparator implements Comparator<Cache>, Serializable
{
	/**
	 * Compara 2 caches 
	 *
	 * @param c1 primeira cache
	 * @param c2 segunda cache
	 * @return -1 se c1 menor que c2, 0 se iguais, 1 se c1 maior que c2
	 */
	public int compare(Cache c1, Cache c2)
	{
		if (c1.getDate().before(c2.getDate()))
			return -1;
		if (c1.getDate().after(c2.getDate()))
			return 1;
		return 0;
	}
}

