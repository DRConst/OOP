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
    private ArrayList<String> participants;

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

    public Set<String> getParticipants() {
        return new ArrayList<>(this.participants);
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

    public void setParticipants(Set<String> participants)
    {
        this.participants = new ArrayList<>();

        for (String s : this.participants)
            this.participants.add(s);
    }

    public boolean isActive() {
        return this.active;
    }

    public void archive() {
        this.active = false;
    }

    public void registerParticipant(String user) throws NotActiveEventException
    {
        if (this.isActive() && !this.participants.contains(user))
            this.participants.add(user);
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public void registerParticipant(User user) throws NotActiveEventException
    {
        if (this.isActive() && !this.participants.contains(user.getEmail()))
            this.participants.add(user.getEmail()); 
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public String simulateRandomWinner() throws NotActiveEventException
    {
        String winner;

        if (this.isActive())
        {
            int i=0;
            int item = new Random().nextInt(this.participants.size());
            Iterator<String> it = this.participants.iterator();

            while(i<item && it.hasNext())
            {
                winner = it.next();

                if (i==item)
                    break;

                i++;
            }
            
            return winner;
        }
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public String simulateStatisticWinner(Statistics s) throws NotActiveEventException
    {
        String winner;

        if (!this.isActive())
        {
            // ...
            // adicionar verificação de estatísticas
            // ...

            return winner;
        }
        else
            throw new NotActiveEventException("Evento já está arquivado");
    }

    public int[] simulatePunctuation(Statistics s) throws NotActiveEventException
    {
        int[] points;

        if (!this.isActive())
        {
            int i=0;
            points = new int[this.participants.size()];

            for (String p : this.participants)
            {
                s.
            }

            return points;
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
            
            for (String s : e.getParticipants())
                if (!this.participants.contains(s))
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
        
        for (String p : this.participants)
        {
            s.append("\t");
            s.append(p);
            s.append("\n");
        }

        s.append("------------------------------------------");

        return s.toString();
    }

    public Event clone() { 
        return new Event(this); 
    }
}

