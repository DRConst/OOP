/**
 * Classe que implementa uma cache tradicional
 *
 * @version (2015.04.30)
 */

import java.util.*;
import java.io.Serializable;

public class TraditionalP extends Physical implements Serializable 
{
    public TraditionalP() 
    {
        super();
    }

    public TraditionalP(String name, String code, String owner, String description,
            String hints, Map<String, Register> regBook, double defaultLatitude,
            double defaultLongitude, GregorianCalendar date, Difficulty difficulty,
            double currentLatitude, double currentLongitude, Collection<Treasure> treasures) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                date, difficulty, currentLatitude, currentLongitude, treasures);
    }

    public TraditionalP(String name, String code, String owner, String description, 
            String hints, Map<String, Register> regBook, double defaultLatitude, 
            double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, 
            double currentLatitude, double currentLongitude, Collection<Treasure> treasures) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                year, month, dayOfMonth, difficulty, currentLatitude, currentLongitude, treasures);
    }

    public TraditionalP(TraditionalP c) {
        super(c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode()});
    }
    
    /**
     * Verifica se 2 caches são iguais
     *
     * @param o objeto que queremos comparar
     * @return true caso iguais, false caso contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            TraditionalP c = (TraditionalP) o;

            if (!super.equals(c)) {
                return false;
            }

            return true;
        }
    }

    /**
     * Passa o objeto para String
     *
     * @return String resultado
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache Tradicional Física-----------------\n\n");
        s.append("Nome: ");
        s.append(this.getName());
        s.append("\n");
        
        s.append("\nCodigo: ");
        s.append(this.getCode());
        s.append("\n");

        s.append("\nDono: ");
        s.append(this.getOwner());
        s.append("\n");

        s.append("\nDescrição: ");
        s.append(this.getDescription());
        s.append("\n");

        s.append("\nDicas: ");
        s.append(this.getHints());
        s.append("\n");

        s.append("\nData: ");
        s.append(this.getYear()).append("/").append(this.getMonth()).append("/").append(this.getDayOfMonth());
        s.append("\n");

        s.append("Tesouros:\n");

        for (Treasure t : this.getTreasures()) {
            s.append("\t");
            s.append(t.toString());
            s.append("\n");
        }

        s.append("Localização:\n");
        s.append(this.getCurrentLocation().toString());
        s.append("\n----------------------------------------------------------");

        return s.toString();
    }

    /**
     * Clona a cache
     *
     * @return novo clone
     */
    public TraditionalP clone() {
        return new TraditionalP(this);
    }
}
