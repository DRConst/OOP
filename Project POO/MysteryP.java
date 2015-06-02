/**
 * Classe que implementa uma Cache Misterio Physical
 *
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class MysteryP extends Physical implements Serializable 
{
    private ArrayList<String> questions;
    private ArrayList<FlexLocation> locations;

    public MysteryP() 
    {
        super();
        this.questions = new ArrayList<>();
        this.locations = new ArrayList<>();
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude, 
            Collection<Treasure> treasures, Collection<String> questions, Collection<FlexLocation> locations) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                date, difficulty, currentLatitude, currentLongitude, treasures);
        
        this.questions = new ArrayList<>(questions);

        for (FlexLocation f : locations)
            this.locations.add(f.clone());
    }

    public MysteryP(String name, String code, String owner, String description, String hints, 
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, 
            int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, 
            double currentLongitude, Collection<Treasure> treasures, Collection<String> questions, 
            Collection<FlexLocation> locations) 
    {    
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, 
                year, month, dayOfMonth, difficulty, currentLatitude, currentLongitude, treasures);
        
        this.questions = new ArrayList<>(questions);
        this.locations = new ArrayList<>();

        for (FlexLocation f : locations)
            this.locations.add(f.clone());
    }

    public MysteryP(MysteryP m) {
        super(m);

        this.questions = new ArrayList<>(m.getQuestions());
        this.locations = new ArrayList<>();

        for (FlexLocation f : m.getLocations())
            this.locations.add(f.clone());
    }

    public Collection<String> getQuestions() {
        return new ArrayList<>(this.questions);
    }

    public Collection<FlexLocation> getLocations() 
    {
        ArrayList<FlexLocation> aux = new ArrayList<>();

        for (FlexLocation l : this.locations)
            aux.add(l.clone());

        return aux;
    }

    private void setQuestions(Collection<String> questions) {
        this.questions = new ArrayList<>(questions);
    }

    private void setLocations(Collection<FlexLocation> locations) 
    {
        this.locations = new ArrayList<>();

        for (FlexLocation f : locations)
            this.locations.add(f.clone());
    }

    public void addIntermidiatePoint(String question, FlexLocation location) 
    {
        this.questions.add(question);
        this.locations.add(location);
    }

    public void changeIntermidiatePoints(Collection<String> questions, Collection<FlexLocation> locations) 
    {
        if (questions.size() == locations.size()) {
            this.setQuestions(questions);
            this.setLocations(locations);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), locations.hashCode()});
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

            for (String s : m.getQuestions())
                if (!this.questions.contains(s))
                    return false;

            for (FlexLocation s : m.getLocations())
                if (!this.locations.contains(s))
                    return false;

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

        for (int i = 0; i < this.questions.size(); i++) 
        {
            s.append("\nPergunta: ");
            s.append(this.questions.get(i));
            s.append("\nLatitude: ");
            s.append(this.locations.get(i).getCurrentLatitude());
            s.append("\nLongitude: ");
            s.append(this.locations.get(i).getCurrentLongitude());
            s.append("\n");
        }

        s.append("\nLocalização:\n");
        s.append("\tLatitude: ").append(this.getDefaultLatitude());
        s.append("\tLongitude: ").append(this.getDefaultLongitude());
        s.append("-------------------------------------------------------");

        return s.toString();
    }

    public MysteryP clone() {
        return new MysteryP(this);
    }
}

