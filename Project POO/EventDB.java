
import java.io.Serializable;
import java.util.TreeMap;

public class EventDB implements Serializable 
{
    private TreeMap<String,Event> db;

    public EventDB() {
        db = new TreeMap<>();
    }

    public EventDB(TreeMap<String,Event> tM) 
    {
        db = new TreeMap<>();
        for (Event e : tM.values()) {
            db.put(e.getNameEvent(), e);
        }
    }

    public void deleteEvent(String c) throws EventNotFoundException
    {
        if((db.remove(c)) == null)
            throw new EventNotFoundException();
    }

    public void saveEvent(Event c) {
        db.put(c.getNameEvent(), c);
    }

    public Event getEvent(String code) throws EventNotFoundException 
    {
        Event r = db.get(code);
        
        if (r == null)
            throw new EventNotFoundException();
        else    
            return r;
    }

    public void archiveEvent(String code) {
        db.get(code).archive();
    }
}

