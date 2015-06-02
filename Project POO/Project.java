/**
 * Classe que implementa uma Cache de Projeto
 *  
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class Project extends Cache implements Serializable
{
    private TreeSet<Cache> project;

    public Project()
    {
        super();
        this.project = new TreeSet<Cache>();
    }

    public Project(String name, String code, String owner, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures, Collection<Cache> caches)
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);        
        this.project = new TreeSet<>();

        for (Cache c : caches)
            this.project.add(c.clone());
    }

    public Project(String name, String code, String owner, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures, Collection<Cache> caches)
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty);
        this.project = new TreeSet<>();

        for (Cache c : caches)
            this.project.add(c.clone());
    }

    public Project(Project p)
    {
        super(p);  
        this.project = new TreeSet<>();

        for (Cache c : p.getCaches())
            this.project.add(c.clone());
    }

    public Collection<Cache> getCaches() { 
        return new TreeSet<Cache>(this.project); 
    }

    public void setCaches(Collection<Cache> caches) { 
        this.project = new TreeSet<Cache>(caches); 
    }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else
        {
            Project p = (Project) o;

            if (!super.equals(p))
                return false;

            for (Cache c : p.getCaches())
                if (!this.project.contains(c))
                    return false;

            return true;
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache de Projeto-----------------\n\n");
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

        s.append("\nCaches do Projeto:\n");

        for (Cache c : this.project)
        {
            s.append("\t");
            s.append(c.toString());
            s.append("\n");
        }

        s.append("\nLocalização:\n");
        s.append(this.getDefaultLocation().toString());
        s.append("--------------------------------------------------");

        return s.toString();
    }
    
    public Project clone() { 
        return new Project(this); 
    }
}
