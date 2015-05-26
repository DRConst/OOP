
import java.io.Serializable;

/**
 * Created by Diogo on 21/05/2015.
 */
public class Report implements Serializable{

    private Cache cache;
    private String desc;


    private int numReports;

    public Report(Cache cache, String desc) {
        this.cache = cache.clone();
        this.desc = desc;
        this.numReports = 0;
    }
    public Report(Report r) {
        this.cache = r.getCache().clone();
        this.desc = r.getDesc();
        this.numReports = r.getNumReports();
    }
    public Report() {
        this.numReports = 0;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
    }

    public Report clone()
    {
        return new Report(this);
    }

    @Override
    public String toString() {
        return ".Report{" +
                "cache='" + cache.getName() + "\'"  +
                ", codigo='"+ cache.getCode() + "\'"  +
                ", desc='" + desc + '\'' +
                ", numReports=" + numReports +
                '}';
    }
}
