/** 
 * Classe que contem as informações de localização
 * 
 * @version (2015.04.30)
 */

import java.util.*;

public class Location
{
    private double latitude, longitude;
    
    public Location() { this(0.0, 0.0); }
    
    public Location(double la, double lo)
    {
        latitude = la;
        longitude = lo;
    }

    public Location(Location l)
    {
    	this.latitude = l.getLatitude();
    	this.longitude = l.getLongitude();
    }

	/**
     * Devolve o valor de latitude inicial da cache
     * 
     * @return a latitude inicial da cache
     */
	public double getLatitude() { return this.latitude; }

	/**
     * Devolve o valor da longitude inicial da cache
     *
     * @return a longitude inicial da cache
     */
	public double getLongitude() { return this.defaultLongitude; }

	/**
	 * Muda a latitude inicial da cache
	 * Como não se pode alterar a latitude inicial depois 
	 * de criada a cache, o método é privado
	 *
	 * @param latitude a latitude inicial da cache
	 */
	public void setLatitude(double latitude) { this.latitude = latitude; }

	/**
	 * Muda a longitude inicial da cache
	 * Como não se pode alterar a longitude inicial depois 
	 * de criada a cache, o método é privado
	 *
	 * @param longitude a longitude inicial da cache
	 */
	public void setLongitude(double defaultLongitude) { this.defaultLongitude = defaultLongitude; }

	/**
	 * Compara 2 localizações
	 *
	 * @return true se iguais, false caso contrário
	 */
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || this.getClass() == o.getClass())
			return false;
		else
		{
			Location l = (Location) o;

			return (this.latitude == l.getLatitude() && this.defaultLongitude == l.getLongitude());
		}
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();

		s.append("Latitude Inicial: ");
		s.append(this.latitude);
		s.append("\nLatitude Inicial: ");
		s.append(this.defaultLongitude);
		s.append("\n\nLatitude Atual: ");
		s.append(this.latitude);
		s.append("\nLongitude Atual: ");
		s.append(this.longitude);

		return s.toString();
	}

	public Location clone() { return new Location(this); }
}
