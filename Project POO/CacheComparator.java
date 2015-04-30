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
	 * @return -1 se c1 menor que c2, 
	 * 0 se iguais, 
	 * 1 se c1 maior que c2
	 */
	public int compare(Cache c1, Cache c2)
	{
		if (c1.getCurrentLatitude() < c2.getCurrentLatitude())
			return -1;
		if (c1.getCurrentLatitude() > c2.getCurrentLatitude())
			return 1;

		else
		{
			if (c1.getCurrentLongitude() < c2.getCurrentLongitude())
				return -1;
			if (c1.getCurrentLongitude() > c2.getCurrentLongitude())
				return 1;
		}

		return 0;
	}
}

