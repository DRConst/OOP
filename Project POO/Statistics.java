
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
        cacheTypes.add("None");

        return cacheTypes;
    }

    public static int[][] getTop(User user, GregorianCalendar startDate, GregorianCalendar endDate) {
        ArrayList<String> types = getCacheTypes();
        int t[] = new int[6];
        int i;
        
        for(i=0 ;i<7; i++) t[i]=0;
        
        for (Cache act : user.nCaches(startDate, endDate)) {
            if (act.getClass().getSimpleName().equals(types.get(0))) t[0]++;
            if (act.getClass().getSimpleName().equals(types.get(1))) t[1]++;
            if (act.getClass().getSimpleName().equals(types.get(2))) t[2]++;
            if (act.getClass().getSimpleName().equals(types.get(3))) t[3]++;
            if (act.getClass().getSimpleName().equals(types.get(4))) t[4]++;
            if (act.getClass().getSimpleName().equals(types.get(5))) t[5]++;
            if (act.getClass().getSimpleName().equals(types.get(6))) t[6]++;  
        }
        
        int fst = 7;
        int ifst = 0;
        int snd = 7;
        int isnd = 0;
        int trd = 7;
        int itrd = 0;
        
        for(i=0;i<7;i++){
            if (ifst <= t[i]){
                itrd = isnd;
                trd = snd;
                isnd = ifst;
                snd = fst;
                ifst = t[i];
                fst = i;
            }else if (isnd <= t[i]){
                itrd = isnd;
                trd = snd;
                isnd = t[i];
                snd = i;
            }else{
                itrd = t[i];
                trd = i;
            }
        }
        
        int top[][] = new int [3][2];
        
        top[0][0]=fst;
        top[0][1]=ifst;
        top[0][0]=snd;
        top[0][1]=isnd;
        top[0][0]=trd;
        top[0][1]=itrd;
        
        return top;
    }

}
