/** 
 * Classe que implementa uma cache tradicional
 * 
 * @version (2015.04.30)
 */

import java.util.*;

public class TraditionalP extends Physical
{
    public TraditionalP() 
    { 
        super();
    }

    public TraditionalP(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty, currentLatitude, currentLongitude, treasures);
    }

    public TraditionalP(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty, currentLatitude, currentLongitude, treasures);
    }

    public TraditionalP(TraditionalP c)
    {
        super(c);
    }

    /**
     * Verifica se 2 caches são iguais
     * 
     * @param o objeto que queremos comparar
     * @return true caso iguais, false caso contrário
     */
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o==null || this.getClass() != o.getClass())
            return false;
        else
        {
            TraditionalP c = (TraditionalP) o;

            if (!super.equals(c))
                return false;

            return true;
        }
    }

    /**
     * Passa o objeto para String
     *
     * @return String resultado
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache Tradicional Física-----------------\n\n");
        s.append("Nome: ");
        s.append(this.getName());
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

        s.append("Conteúdo do livro de Registos:\n");

        for (Register r : this.getRegBook().values())
        {
            s.append("\t");
            s.append(r.toString());
            s.append("\n");
        }

        s.append("Tesouros:\n");

        for (Treasure t : this.getTreasures())
        {
            s.append("\t");
            s.append(t.toString());
            s.append("\n");
        }

        s.append("Localização:\n");
        s.append(this.getCurrentLocation().toString());
        s.append("----------------------------------------------------------");

        return s.toString();
    }

    /**
     * Clona a cache
     *
     * @return novo clone
     */ 
    public TraditionalP clone()
    {
        return new TraditionalP(this);
    }
}

