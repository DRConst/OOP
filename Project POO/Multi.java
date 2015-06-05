/**
 * Classe que implementa uma multi-cache fisica
 *
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class Multi extends Physical implements Serializable 
{
    private ArrayList<FlexLocation> intermidiateLocations;

    public Multi() 
    {
        super();
        this.intermidiateLocations = new ArrayList<>();
    }

    public Multi(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            GregorianCalendar date, Difficulty difficulty, double currentLatitude,
            double currentLongitude, Collection<Treasure> treasures, Collection<FlexLocation> intermidiate) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                date, difficulty, currentLatitude, currentLongitude, treasures);
        this.intermidiateLocations = new ArrayList<>();

        for (FlexLocation f : intermidiate)
            this.intermidiateLocations.add(f.clone());
    }

    public Multi(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            int year, int month, int dayofMonth, Difficulty difficulty, double currentLatitude,
            double currentLongitude, Collection<Treasure> treasures, Collection<FlexLocation> intermidiate) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                year, month, dayofMonth, difficulty, currentLatitude, currentLongitude, treasures);
        this.intermidiateLocations = new ArrayList<>();

        for (FlexLocation f : intermidiate)
            this.intermidiateLocations.add(f.clone());
    }

    public Multi(Multi m) 
    {
        super(m);
        this.intermidiateLocations = new ArrayList<>();

        for (FlexLocation f : m.getIntermidiateLocations())
            this.intermidiateLocations.add(f.clone());
    }

    public Collection<FlexLocation> getIntermidiateLocations() {
        return new ArrayList<>(this.intermidiateLocations);
    }

    public void setIntermidiateLocations(Collection<FlexLocation> intermidiate) {
        this.intermidiateLocations = new ArrayList<>(intermidiate);
    }

    public void addIntermidiateLocation(FlexLocation l) {
        this.intermidiateLocations.add(l);
    }

    public void removeIntermidiateLocation(FlexLocation l) {
        this.intermidiateLocations.remove(l);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), intermidiateLocations.hashCode()});
    }

    public boolean equals(Object o) 
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else 
        {
            Multi m = (Multi) o;

            if (!super.equals(m))
                return false;

            for (FlexLocation l : m.getIntermidiateLocations())
                if (!this.intermidiateLocations.contains(l))
                    return false;

            return true;
        }
    }

    public String toString() 
    {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Multi Cache-----------------\n\n");
        s.append("\nNome: ");
        s.append(this.getName());
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

        s.append("\nConteúdo do livro de Registos:\n");

        for (Register r : this.getRegBook().values()) 
        {
            s.append(r.toString());
            s.append("\n");
        }

        s.append("\nTesouros:\n");

        for (Treasure t : this.getTreasures()) 
        {
            s.append(t.toString());
            s.append("\n");
        }

        s.append("\nLocalização:\n");
        s.append(this.getCurrentLocation().toString());

        s.append("\nLocalizações Intermédias:\n");

        for (FlexLocation l : this.intermidiateLocations) 
        {
            s.append(l.toString());
            s.append("\n");
        }

        s.append("\n---------------------------------------------");

        return s.toString();
    }

    public Multi clone() {
        return new Multi(this);
    }
}

