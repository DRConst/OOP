/**
 * Abstract class Physical - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class Physical extends Cache
{
    private Location currentL;
    private TreeSet<Treasure> treasures;

    public Physical() 
    { 
        super();
        this(0.0, 0.0);
    }

    public Physical(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);
        this.currentL = new Location(defaultLatitude, defaultLongitude);
    }

    public Physical(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, double currentLatitude, double currentLongitude)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty);
        this.currentL = new Location(defaultLatitude, defaultLongitude);
    }

    public Physical(Physical p)
    {
        super(p);
        this.currentL = new Location(c.getCurrentLocation());
    }

    /**
     * Devolve a localização atual da cache
     *
     * @return a localização atual da cache
     */
    public Location getCurrentLocation() { return this.currentL.clone(); }

    /**
     * Devolve o valor da latitude no momento da cache
     * Não pode estar distanciada mais de 10 metros da
     * localização inicial
     *
     * @return a latitude no momento da cache
     */
    public double getCurrentLatitude() { return this.currentL.getCurrentLatitude(); }

    /**
     * Devolve o valor da longitude no momento da cache
     * Não pode estar distanciada mais de 10 metros da
     * localização inicial
     *
     * @return a longitude no momento da cache
     */
    public double getCurrentLongitude() { return this.currentL.getCurrentLongitude(); }

    /**
     * Muda a latitude no momento da cache
     *
     * @param currentLatitude a latitude no momento da cache
     */
    public void setCurrentLatitude(double currentLatitude) { this.currentL.setLatitude(currentLatitude); }  // adicionar verificador de distancia

    /**
     * Muda a longitude no momento da cache
     *
     * @param currentLongitude a longitude no momento da cache
     */
    public void setCurrentLongitude(double currentLongitude) { this.currentL.setLongitude(currentLongitude); }  // adicionar verificador de distancia

    /**
     * Verifica se 2 cache são iguais
     *
     * @return true se iguais, false caso contrário
     */
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else
        {
            Physical p = (Physical) o;

            if (!super.equals(p))
                return false;

            if (this.location.equals(p.getCurrentLocation))
                
            return true;
        }
    }
}

