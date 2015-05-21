import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Diogo on 21/05/2015.
 */
public class ReportDB implements Serializable {
    private HashMap<String, Report> reportedCaches;

    public ReportDB()
    {
        reportedCaches = new HashMap<>();
    }

    public ReportDB(HashMap<String, Report> db)
    {
        reportedCaches = new HashMap<>();
        for(Report r : db.values())
        {
            reportedCaches.put(r.getCache().getCode(), r.clone());
        }
    }

    public void addReport(Cache c, String desc)
    {
        Report r = new Report();
        if(reportedCaches.containsKey(c.getCode()))
        {
            r = reportedCaches.get(c.getCode());
            r.setDesc(r.getDesc() + "\n " + desc);
        }else
        {
            r = new Report(c, desc);
            reportedCaches.put(c.getCode(), r);
        }
    }

    public Report getReport(String code)
    {
        return reportedCaches.get(code);
    }
}
