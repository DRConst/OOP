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
    private String cacheCode;
    private int nLimit;
    private Location location;
    private GregorianCalendar dateLimit;
    private TreeSet<String> participants;

    public Event()
    {
    	this.active = true;
    	this.nameEvent = "";
    	this.cacheCode = "";
    	this.nLimit = 0;
    	this.location = new Location();
    	this.dateLimit = new GregorianCalendar();
    	this.participants = new TreeSet<>();
    }

    public Event(String nameEvent, String cacheCode, int nLimit, double latitude, 
    				double longitude, GregorianCalendar dateLimit)
    {
    	this.active = true;
    	this.nameEvent = nameEvent;
    	this.cacheCode = cacheCode;
    	this.nLimit = nLimit;
    	this.location = new Location(latitude, longitude);
    	this.dateLimit = new GregorianCalendar(dateLimit.get(Calendar.YEAR), dateLimit.get(Calendar.MONTH),
                dateLimit.get(Calendar.DAY_OF_MONTH));
    	this.participants = new TreeSet<>();
    }

    public Event(String nameEvent, String cacheCode, int nLimit, double latitude, 
    				double longitude, int year, int month, int dayOfMonth)
    {
    	this.active = true;
    	this.nameEvent = nameEvent;
    	this.cacheCode = cacheCode;
    	this.nLimit = nLimit;
    	this.location = new Location(latitude, longitude);
    	this.dateLimit = new GregorianCalendar(year, month, dayOfMonth);
    	this.participants = new TreeSet<>();
    }

    public Event(Event e)
    {
    	this.active = e.isActive();
    	this.nameEvent = e.getNameEvent();
    	this.cacheCode = e.getCacheCode();
    	this.nLimit = e.getNLimit();
    	this.location = new Location(e.getLatitude(), e.getLongitude());
    	this.dateLimit = new GregorianCalendar(e.getYear(), e.getMonth(), e.getDayOfMonth());
    	this.participants = new TreeSet<>(e.getParticipants());
    }

    public String getNameEvent() {
    	return this.nameEvent;
    }

    public String getCacheCode() {
    	return this.cacheCode;
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

    public Set<String> getParticipants()
    {
    	TreeSet<String> aux = new TreeSet<>();

    	for (String s : this.participants)
    		aux.add(s);

    	return aux;
    }

    public void setNameEvent(String nameEvent) {
    	this.nameEvent = nameEvent;
    }

    public void setCacheCode(String cacheCode) {
    	this.cacheCode = cacheCode;
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
    	this.participants = new TreeSet<>();

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
        if (this.isActive())
        {
            int i=0;
            int item = new Random().nextInt(this.participants.size());
            Iterator<String> it = this.participants.iterator();
            String winner = null;

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

    public String simulateStatisticWinner() throws NotActiveEventException
    {
        String winner = null;

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
    		
	    	if (!this.cacheCode.equals(e.getCacheCode()))
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

        s.append("-----------------Multi Cache-----------------\n\n");

        s.append("Nome: ");
        s.append(this.nameEvent);
        s.append("\n");

        s.append("Cache: ");
        s.append(this.cacheCode);
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

        s.append("---------------------------------------------");

        return s.toString();
    }

    public Event clone() { 
        return new Event(this); 
    }
}

