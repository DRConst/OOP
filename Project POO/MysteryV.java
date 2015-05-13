/**
 * Classe que implementa uma Cache Misterio Virtual
 * 
 * @version (a version number or a date)
 */

import java.util.*;

public class MysteryV extends Virtual
{
    private ArrayList<String> questions;
    private ArrayList<Location> locations;

    public MysteryV()
    {
        super();
        this.questions = new ArrayList<String>();
        this.locations = new ArrayList<Location>();
    }

    public MysteryV(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, String question, Collection<String> questions, Collection<Location> locations)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty, question);
        this.questions = new ArrayList<String>(questions);
        this.locations = new ArrayList<Location>(locations);
    }

    public MysteryV(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, String question, Collection<String> questions, Collection<Location> locations)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty, question);
        this.questions = new ArrayList<String>(questions);
        this.locations = new ArrayList<Location>(locations);
    }

    public MysteryV(MysteryV m)
    {
        super(m);
        this.questions = new ArrayList<String>(m.getQuestions());
        this.locations = new ArrayList<Location>(m.getLocations());
    }

    public Collection<String> getQuestions() { return new ArrayList<String>(this.questions); }

    public Collection<Location> getLocations() { return new ArrayList<Location>(this.locations); }

    private void setQuestions(Collection<String> question) { this.questions = new ArrayList<String>(questions); }

    private void setLocations(Collection<Location> locations) { this.locations = new ArrayList<Location>(locations); }

    public void changeIntermidiatePoints(Collection<String> questions, Collection<Location> locations)
    {
        if (questions.size() == locations.size())
        {
            this.setQuestions(questions);
            this.setLocations(locations);
        }
    }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o==null || this.getClass() != o.getClass())
            return false;
        else
        {
            MysteryV m = (MysteryV) o;

            if (!super.equals(m))
                return false;

            for (String s : m.getQuestions())
                if (!this.questions.contains(s))
                    return false;

            for (Location s : m.getLocations())
                if (!this.locations.contains(s))
                    return false;

            return true;
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Cache Misterio Virtual-----------------\n\n");
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
            s.append("\t" + r.toString() + "\n");

        s.append("\nPergunta Final:\n\t");
        s.append(this.getFinalQuestion());

        s.append("\n\nPerguntas Intermédias:\n");

        for (int i=0; i<this.questions.size(); i++)
        {
            s.append(this.questions.get(i));
            s.append("\n");
            s.append(this.locations.get(i).toString());
            s.append("\n\n");
        }

        s.append("Localização:\n");
        s.append("\tLatitude: " + this.getDefaultLatitude());
        s.append("\tLongitude: " + this.getDefaultLongitude());
        s.append("--------------------------------------------------------");

        return s.toString();
    }

    public MysteryV clone() { return new MysteryV(this); }
}

