import com.sun.org.apache.xpath.internal.operations.Mult;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Diogo on 09/05/2015.
 */
public class MultiCache extends Cache {

    ArrayList<Objective> objectives; /*Kept as array list in case the cache requires ordered completion*/
    TraditionalCache cache;
    boolean inOrder;

    public MultiCache()
    {
        super();
        this.objectives = new ArrayList<Objective>();
        this.cache = new TraditionalCache();
        inOrder = false;
    }
    public MultiCache(ArrayList<Objective> objectives, boolean inOrder, TraditionalCache cache)
    {
        super();
        this.objectives = new ArrayList<Objective>();
        for(Objective o : objectives)
            this.objectives.add((Objective)o.clone());
        this.cache = cache.clone();
        this.inOrder = inOrder;
    }
    public MultiCache(MultiCache c)
    {
        super();
        this.objectives = new ArrayList<Objective>();
        for(Objective o : c.getObjectives())
            this.objectives.add((Objective)o.clone());
        this.cache = c.getCache().clone();
        this.inOrder = c.isInOrder();
    }



    /*TODO: All the normal methods such as checking for completion etc*/











    public MultiCache clone()
    {
       return new MultiCache(this);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("MultiCache{ ");
        sb.append(objectives.size());
        sb.append(" Objectivos: { ");
        for(Objective o : objectives)
        {
            sb.append(o.toString());
            sb.append(";");
        }
        sb.append("}");
        sb.append("Cache: ");
        sb.append(this.cache.toString());

        return sb.toString();
    }

    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(this.getClass() != o.getClass())
            return false;
        MultiCache c = (MultiCache)o;
        if(c.isInOrder() != this.isInOrder() || !c.getCache().equals(this.getCache()) || c.getObjectives().size() != this.getObjectives().size())
            return false;
        for(Objective obj : c.getObjectives())
        {
            if(!this.getObjectives().contains(obj))
                return false;
        }
        return false;
    }
    public ArrayList<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(ArrayList<Objective> objectives) {
        this.objectives = objectives;
    }

    public boolean isInOrder() {
        return inOrder;
    }

    public void setInOrder(boolean inOrder) {
        this.inOrder = inOrder;
    }

    public TraditionalCache getCache() {
        return cache;
    }

    public void setCache(TraditionalCache cache) {
        this.cache = cache;
    }
}
