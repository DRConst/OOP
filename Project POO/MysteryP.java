/**
 * Classe que implementa uma Cache Misterio Physical
 *
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class MysteryP extends Physical implements Serializable 
{
    private HashMap<FlexLocation,String> tips;

    public MysteryP() 
    {
        super();
        this.tips = new HashMap<>();
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude, 
             Collection<Treasure> treasures, Map<FlexLocation,String> locations) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                date, difficulty, currentLatitude, currentLongitude, treasures);
        this.tips = new HashMap<>();

        for (Map.Entry<FlexLocation,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, 
            double currentLongitude, Collection<Treasure> treasures, Map<FlexLocation,String> locations) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                year, month, dayOfMonth, difficulty, currentLatitude, currentLongitude, treasures);
        this.tips = new HashMap<>();

        for (Map.Entry<FlexLocation,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            GregorianCalendar date, Difficulty difficulty, double currentLatitude, 
            double currentLongitude, Collection<Treasure> treasures, Collection<FlexLocation> locations, Collection<String> questions) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                date, difficulty, currentLatitude, currentLongitude, treasures);
        this.tips = new HashMap<>();

        Iterator<FlexLocation> itl = locations.iterator();
        Iterator<String> itq = questions.iterator();

        while(itl.hasNext() && itq.hasNext())
            this.tips.put(itl.next().clone(), itq.next());
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, 
            double currentLongitude, Collection<Treasure> treasures, Collection<FlexLocation> locations, Collection<String> questions) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                year, month, dayOfMonth, difficulty, currentLatitude, currentLongitude, treasures);
        this.tips = new HashMap<>();

        Iterator<FlexLocation> itl = locations.iterator();
        Iterator<String> itq = questions.iterator();

        while(itl.hasNext() && itq.hasNext())
            this.tips.put(itl.next().clone(), itq.next());
    }

    public MysteryP(MysteryP m) 
    {
        super(m);
        this.tips = new HashMap<>();

        for (Map.Entry<FlexLocation,String> t : m.getTips().entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public Map<FlexLocation,String> getTips() 
    {    
        HashMap<FlexLocation,String> aux = new HashMap<>();

        for (Map.Entry<FlexLocation,String> t : this.tips.entrySet())
            aux.put(t.getKey().clone(), t.getValue());

        return aux;
    }

    private void setTips(Map<FlexLocation,String> tips)
    {
        this.tips = new HashMap<>();

        for (Map.Entry<FlexLocation,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public void addIntermidiatePoint(String question, FlexLocation FlexLocation) 
    {
        this.tips.put(FlexLocation,question);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), tips.hashCode()});
    }

    public boolean equals(Object o) 
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else 
        {
            MysteryP m = (MysteryP) o;

            if (!super.equals(m))
                return false;

            for (FlexLocation l : m.getTips().keySet()) {
                if (!this.tips.containsKey(l))
                    return false;
            }
            
            for (String s : m.getTips().values()) {
                if (!this.tips.containsValue(s))
                    return false;
            }

            return true;
        }
    }

    public String toString() 
    {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache Misterio Fisica-----------------\n\n");
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

        s.append("\nPerguntas Intermédias:\n");

        Iterator<String> it = this.tips.values().iterator();
        
        for (int i = 0; it.hasNext(); i++) 
        {
            s.append("\nPergunta: ");
            s.append(it.next());
            s.append("\n");
        }

        s.append("\nLocalização:\n");
        s.append("\tLatitude: ").append(this.getDefaultLatitude());
        s.append("\tLongitude: ").append(this.getDefaultLongitude());
        s.append("\n-------------------------------------------------------");

        return s.toString();
    }

    public MysteryP clone() {
        return new MysteryP(this);
    }
}

