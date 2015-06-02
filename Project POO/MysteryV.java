/**
 * Classe que implementa uma Cache Misterio Virtual
 *
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class MysteryV extends Virtual implements Serializable
{
    private ArrayList<String> questions;
    private ArrayList<Location> locations;

    public MysteryV() 
    {
        super();
        this.questions = new ArrayList<>();
        this.locations = new ArrayList<>();
    }

    public MysteryV(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            GregorianCalendar date, Difficulty difficulty, String question, Collection<String> questions,
            Collection<Location> locations) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                date, difficulty, question);

        this.questions = new ArrayList<>(questions);
        this.locations = new ArrayList<>();

        for (Location l : locations)
            this.locations.add(l.clone());
    }

    public MysteryV(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            int year, int month, int dayOfMonth, Difficulty difficulty, String question,
            Collection<String> questions, Collection<Location> locations) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                year, month, dayOfMonth, difficulty, question);

        this.questions = new ArrayList<>(questions);
        this.locations = new ArrayList<>();

        for (Location l : locations)
            this.locations.add(l.clone());
    }

    public MysteryV(MysteryV m) 
    {
        super(m);
        this.questions = new ArrayList<>(m.getQuestions());
        this.locations = new ArrayList<>();

        for (Location l : m.getLocations())
            this.locations.add(l.clone());
    }

    public Collection<String> getQuestions() {
        return new ArrayList<>(this.questions);
    }

    public Collection<Location> getLocations() 
    {    
        ArrayList<Location> aux = new ArrayList<>();

        for (Location l : this.locations)
            aux.add(l.clone());

        return aux;
    }

    private void setQuestions(Collection<String> questions) {
        this.questions = new ArrayList<>(questions);
    }

    private void setLocations(Collection<Location> locations) 
    {
        this.locations = new ArrayList<>();

        for (Location l : locations)
            this.locations.add(l.clone());
    }

    public void addIntermidiatePoint(String question, Location location) 
    {
        this.questions.add(question);
        this.locations.add(location);
    }

    public void changeIntermidiatePoints(Collection<String> questions, Collection<Location> locations) 
    {
        if (questions.size() == locations.size()) 
        {
            this.setQuestions(questions);
            this.setLocations(locations);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), locations.hashCode()});
    }

    public boolean equals(Object o) 
    {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            MysteryV m = (MysteryV) o;

            if (!super.equals(m)) {
                return false;
            }

            for (String s : m.getQuestions()) {
                if (!this.questions.contains(s)) {
                    return false;
                }
            }

            for (Location s : m.getLocations()) {
                if (!this.locations.contains(s)) {
                    return false;
                }
            }

            return true;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache Misterio Virtual-----------------\n\n");
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
        s.append(this.getYear()).append("/").append(this.getMonth()).append("/").append(this.getDayOfMonth());
        s.append("\n");

        s.append("\nConteúdo do livro de Registos:\n");

        for (Register r : this.getRegBook().values()) {
            s.append(r.toString());
            s.append("\n");
        }

        s.append("\nPergunta Final:\n\t");
        s.append(this.getFinalQuestion());

        s.append("\nPerguntas Intermédias:\n");

        for (int i = 0; i < this.questions.size(); i++) {
            s.append("\nPergunta: ");
            s.append(this.questions.get(i));
            s.append("\n");
            s.append(this.locations.get(i).toString());
            s.append("\n");
        }

        s.append("\nLocalização:\n");
        s.append("\tLatitude: ").append(this.getDefaultLatitude());
        s.append("\tLongitude: ").append(this.getDefaultLongitude());
        s.append("--------------------------------------------------------");

        return s.toString();
    }

    public MysteryV clone() {
        return new MysteryV(this);
    }
}
