
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Diogo on 21/05/2015.
 */
public class ReportDB implements Serializable {

    private HashMap<String, Report> reports;

    public ReportDB()
    {
        reports = new HashMap<>();
    }

    public ReportDB(HashMap<String, Report> db)
    {
        reports = new HashMap<>();
        for(Report r : db.values())
        {
            reports.put(r.getCache().getCode(), r.clone());
        }
    }

    public void addReport(Cache c, String desc)
    {
        Report r = new Report();
        if(reports.containsKey(c.getCode()))
        {
            r = reports.get(c.getCode());
            r.setDesc(r.getDesc() + "\n " + desc);
        }else
        {
            r = new Report(c, desc);
            reports.put(c.getCode(), r);
        }
        r.setNumReports(r.getNumReports() + 1);
    }

    public boolean removeReport(String code)
    {
        return reports.remove(code) != null;
    }
    public Report getReport(String code)
    {
        return reports.get(code);
    }

    public int getReportCount()
    {
        return reports.size();
    }
    public HashMap<String, Report> getReports()
    {
        HashMap<String, Report> toRet = new HashMap<>(reports.size());
        for(Report rep : reports.values())
        {
            toRet.put(rep.getCache().getCode(), rep.clone());
        }
        return toRet;
    }

    @Override
    public String toString() {
        return ".ReportDB{" +
                "reports=" + reports +
                '}';
    }
}
