 

import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Classe de criacao de comparator de actividades por data de realizacao.
 * 
 */
public class CacheComparatorByDate implements Comparator<Cache>,Serializable{
   
	public int compare(Cache c1, Cache c2){
        GregorianCalendar d1 = c1.getDate();
        GregorianCalendar d2 = c2.getDate();
        if(d1.after(d2)) return 1;
        else if(d1.before(d2)) return -1;
        else return 0;
    }
}
