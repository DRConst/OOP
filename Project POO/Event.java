/**
 * Classe Evento, que vai ser responsável pela organização 
 * e simulação dos eventos
 *
 * @version (2015.06.03)
 */

import java.util.*;
import java.io.Serializable;

public class Event implements Serializable
{
    private boolean active;
    private String nameEvent;
    private ArrayList<Cache> caches;
    private int nLimit;
    private Location location;
    private GregorianCalendar dateLimit;
    private ArrayList<User> participants;

    public Event()
    {
        this.active = true;
        this.nameEvent = "";
        this.caches = new ArrayList<>();
        this.nLimit = 0;
        this.location = new Location();
        this.dateLimit = new GregorianCalendar();
        this.participants = new ArrayList<>();
    }

    public Event(String nameEvent, ArrayList<Cache> caches, int nLimit, double latitude, 
                    double longitude, GregorianCalendar dateLimit)
    {
        this.active = true;
        this.nameEvent = nameEvent;
        this.nLimit = nLimit;
        this.location = new Location(latitude, longitude);
        this.dateLimit = new GregorianCalendar(dateLimit.get(Calendar.YEAR), dateLimit.get(Calendar.MONTH),
                dateLimit.get(Calendar.DAY_OF_MONTH));
        this.participants = new ArrayList<>();

        this.caches = new ArrayList<>();

        for (Cache c : caches)
            this.caches.add(c.clone());
    }

    public Event(String nameEvent, ArrayList<Cache> caches, int nLimit, double latitude, 
                    double longitude, int year, int month, int dayOfMonth)
    {
        this.active = true;
        this.nameEvent = nameEvent;
        this.nLimit = nLimit;
        this.location = new Location(latitude, longitude);
        this.dateLimit = new GregorianCalendar(year, month, dayOfMonth);
        this.participants = new ArrayList<>();

        this.caches = new ArrayList<>();

        for (Cache c : caches)
            this.caches.add(c.clone());
    }

    public Event(Event e)
    {
        this.active = e.isActive();
        this.nameEvent = e.getNameEvent();
        this.nLimit = e.getNLimit();
        this.location = new Location(e.getLatitude(), e.getLongitude());
        this.dateLimit = new GregorianCalendar(e.getYear(), e.getMonth(), e.getDayOfMonth());
        this.participants = new ArrayList<>(e.getParticipants());

        this.caches = new ArrayList<>();

        for (Cache c : e.getCaches())
            this.caches.add(c.clone());
    }

    public String getNameEvent() {
        return this.nameEvent;
    }

    public List<Cache> getCaches() 
    {
        ArrayList<Cache> aux = new ArrayList<>();

        for (Cache c : this.caches)
            aux.add(c.clone());

        return aux;
    }

    public int getNLimit() {
        return this.nLimit;
    }
    
    public Location getLocation() {
        return this.location;
    }

    public double getLatitude() {
        return this.location.getLatitude();
    }

    public double getLongitude() {
        return this.location.getLongitude();
    }
    
    public GregorianCalendar getDateLimit() {
        return this.dateLimit;
    }

    public int getYear() {
        return this.dateLimit.get(Calendar.YEAR);
    }

    public int getMonth() {
        return this.dateLimit.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {
        return this.dateLimit.get(Calendar.DAY_OF_MONTH);
    }

    public List<User> getParticipants() 
    {
        ArrayList<User> aux = new ArrayList<>();

        for (User u : this.participants)
            aux.add(u.clone());

        return aux;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public void setCaches(Collection<Cache> caches) 
    {
        this.caches = new ArrayList<>();

        for (Cache c : caches)
            this.caches.add(c.clone());
    }

    public void setNLimit(int nLimit) {
        this.nLimit = nLimit;
    }

    public void setLatitude(double latitude) {
        this.location.setLatitude(latitude);
    }

    public void setLongitude(double longitude) {
        this.location.setLongitude(longitude);
    }

    public void setDate(int year, int month, int dayOfMonth) {
        this.dateLimit = new GregorianCalendar(year, month, dayOfMonth);
    }

    public void setParticipants(Set<User> participants)
    {
        this.participants = new ArrayList<>();

        for (User u : this.participants)
            this.participants.add(u.clone());
    }

    public boolean isActive() {
        return this.active;
    }

    public void archive() {
        this.active = false;
    }

    public void registerParticipant(User user) throws NotActiveEventException
    {
        if (this.isActive() && !this.participants.contains(user))
            this.participants.add(user); 
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public String simulateRandomWinner() throws NotActiveEventException
    {
        String winner;

        if (this.isActive())
        {
            int i=0;
            winner = null;
            int item = new Random().nextInt(this.participants.size());
            Iterator<User> it = this.participants.iterator();

            while(i<item && it.hasNext())
            {
                winner = it.next().getEmail();

                if (i==item)
                    break;
                i++;
            }
            
            return winner;
        }
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public String simulateStatisticWinner() throws NotActiveEventException
    {
        if (!this.isActive())
        {
            int i=0, imax;
            int[] times = new int[this.participants.size()];

            for (User u : this.participants)
            {
                for (Cache c : this.caches)
                    times[i] += u.calcEstimatedTime(c.getClass().getSimpleName());
                i++;
            }

            imax=0;
            for (i=1; i<this.participants.size(); i++)
                if (times[i] > times[imax])
                    imax = i;

            return this.participants.get(imax).getEmail();
        }
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public Map<String,Integer> simulateTimes() throws NotActiveEventException
    {
        TreeMap<String,Integer> times;

        if (!this.isActive())
        {
            int i=0;
            times = new TreeMap<>();

            for (User u : this.participants)
            {
                int time=0;

                for (Cache c : this.caches)
                    time += u.calcEstimatedTime(c.getClass().getSimpleName());

                times.put(u.getEmail(), time);
            }  

            return times;          
        }
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public boolean equals(Object o)
    {
        if (this==o)
            return true;
        if (o==null || this.getClass() != o.getClass())
            return false;
        else
        {
            Event e = (Event) o;

            if (this.active != e.isActive())
                return false;

            if (!this.nameEvent.equals(e.getNameEvent()))
                return false;
            
            if (!this.caches.equals(e.getCaches()))
                return false;

            if (this.nLimit != e.getNLimit())
                return false;

            if (!this.location.equals(e.getLocation()))
                return false;
            
            if (!this.dateLimit.equals(e.getDateLimit()))
                return false;
            
            for (User u : e.getParticipants())
                if (!this.participants.contains(u))
                    return false;

            return true;
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append("----------------- Evento -----------------\n\n");

        s.append("Nome: ");
        s.append(this.nameEvent);
        s.append("\n");

        s.append("Caches: ");
        
        for (Cache c : this.caches)
        {
            s.append("\n\t");
            s.append(c.toString());
        }
        
        s.append("\n");

        s.append("Número Limite de Incrições: ");
        s.append(this.nLimit);
        s.append("\n");

        s.append("\nLocalização:\n");
        s.append(this.getLocation().toString());

        s.append("\nData: ");
        s.append(this.getYear()).append("/").append(this.getMonth()).append("/").append(this.getDayOfMonth());
        s.append("\n");

        s.append("Participantes:\n");
        
        for (User u : this.participants)
        {
            s.append("\t");
            s.append(u.getEmail());
            s.append("\n");
        }

        s.append("------------------------------------------");

        return s.toString();
    }

    public Event clone() { 
        return new Event(this); 
    }
}

