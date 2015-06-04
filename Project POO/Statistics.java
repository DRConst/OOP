
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Statistics {

    static public int getNCaches(User user, GregorianCalendar startDate, GregorianCalendar endDate) {
        int totalCaches = 0;
        for (Cache act : user.nCaches(startDate, endDate)) {
            totalCaches++;
        }
        return totalCaches;
    }

    static public long getNCaches(User user, GregorianCalendar startDate, GregorianCalendar endDate, TimeUnit timeUnit) {
        int totalCaches = 0;
        long cachesDay;

        for (Cache act : user.nCaches(startDate, endDate)) {
            totalCaches++;
        }

        cachesDay = totalCaches / getDateDiff(startDate, endDate, timeUnit);

        return cachesDay;
    }

    public static long getDateDiff(GregorianCalendar date1, GregorianCalendar date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTimeInMillis() - date1.getTimeInMillis();
        return timeUnit.convert(diffInMillies, timeUnit);
    }

    public static int[] getNTypeTotal(User user, GregorianCalendar startDate, GregorianCalendar endDate) {
        int[] totalCaches = new int[7];

        for (Cache act : user.nCaches(startDate, endDate)) {
            if (act instanceof TraditionalP) {
                totalCaches[0]++;
            }
            if (act instanceof TraditionalV) {
                totalCaches[1]++;
            }
            if (act instanceof MysteryP) {
                totalCaches[2]++;
            }
            if (act instanceof MysteryV) {
                totalCaches[3]++;
            }
            if (act instanceof Multi) {
                totalCaches[4]++;
            }
            if (act instanceof HQ) {
                totalCaches[5]++;
            }
            if (act instanceof Project) {
                totalCaches[6]++;
            }
        }
        return totalCaches;
    }

    static public int getNType(User user, GregorianCalendar startDate, GregorianCalendar endDate, String type) {
        int totalCaches = 0;

        for (Cache act : user.nCaches(startDate, endDate)) {
            if (act.getClass().getSimpleName().equals(type)) {
                totalCaches++;
            }
        }

        return totalCaches;
    }

    public static ArrayList<String> getCacheTypes() {
        ArrayList<String> cacheTypes;
        cacheTypes = new ArrayList<>();

        cacheTypes.add("TraditionalP");
        cacheTypes.add("TraditionalV");
        cacheTypes.add("MysteryP");
        cacheTypes.add("MysteryV");
        cacheTypes.add("Multi");
        cacheTypes.add("HQ");
        cacheTypes.add("Project");

        return cacheTypes;
    }
/*
    public static HashMap<String,Integer> getTop(User user, GregorianCalendar startDate, GregorianCalendar endDate) {
        HashMap<String,Integer> top = new HashMap<>();
        ArrayList
        int tTP, tTV, tMP, tMV, tM, tHQ, tP;
        
        tTP = tTV = tMP = tMV = tM = tHQ = tP = 0;
        
        for (Cache act : user.nCaches(startDate, endDate)) {
            if (act.getClass().getSimpleName().equals()) {
                
                totalCaches++;
            }
        }
    }
*/
}
