/**
 * Created by Diogo on 21/05/2015.
 */
public class Report {

    private Cache cache;
    private String desc;

    public Report(Cache cache, String desc) {
        this.cache = cache.clone();
        this.desc = desc;
    }
    public Report(Report r) {
        this.cache = r.getCache().clone();
        this.desc = r.getDesc();
    }
    public Report() {}

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

    public Report clone()
    {
        return new Report(this);
    }
}
