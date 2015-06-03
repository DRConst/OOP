/**
 * Classe que implementa a cache que está na sede do Geocaching
 * 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class HQ extends Virtual implements Serializable
{
    public HQ() 
    { 
        super("Sede do GeoCaching", "GCK25P", "Geochaching", "Junte-se a uma das nossa visitas guiadas à sede do Geocaching, onde poderá obter acesso direto à nossa loja e até mesmo colecionar uma nova lembrança na sua conta! Esta cache requer uma marcação direta com um dos nossos administradores, pois não estamos abertos ao público a tempo inteiro. Explore mais no nosso site sobre a sede do Geocaching.", "", new TreeMap<String,Register>(), 47.64897, -122.34812, 2004, 7, 22, Difficulty.EASY, ""); 
    }
    
    public double getLatitudeSede() { 
        return this.getDefaultLatitude(); 
    }
    
    public double getLongitudeSede() { 
        return this.getDefaultLongitude(); 
    }
    
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        
        if (o == null || this.getClass() != o.getClass())
            return false;
            
        else
        {
            HQ h = (HQ) o;
            
            return (this.getDefaultLatitude() == h.getDefaultLatitude() && this.getDefaultLongitude() == h.getDefaultLongitude());
        }
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        
        s.append("-----------------Sede do GeoCaching-----------------\n\n");
        s.append("\nNome: ");
        s.append(this.getName());
        s.append("\n");

        s.append("\nDono: ");
        s.append(this.getOwner().toString());
        s.append("\n");

        s.append("\nDescrição: ");
        s.append(this.getDescription());
        s.append("\n");

        s.append("\nDicas: ");
        s.append(this.getHints());
        s.append("\n");

        s.append("\nData: ");
        s.append(this.getYear() + "/" + this.getMonth() + "/" + this.getDayOfMonth());
        s.append("\n");

		s.append("\nConteúdo do livro de Registos:\n");

		for (Register r : this.getRegBook().values())
        {
			s.append("\t");
            s.append(r.toString());
            s.append("\n");
        }

		s.append("\nLocalização:\n");
		s.append("\tLatitude: " + this.getDefaultLatitude());
		s.append("\tLongitude: " + this.getDefaultLongitude());
		s.append("----------------------------------------------------");
		
		return s.toString();
    }
    
    public HQ clone() { 
        return new HQ(); 
    }
}

