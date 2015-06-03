/**
 * Classe que implementa uma Cache Misterio Virtual
 *
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.Serializable;

public class MysteryV extends Virtual implements Serializable
{
    private HashMap<Location,String> tips;

    public MysteryV() 
    {
        super();
        this.questions = new HashMap<>();
    }

    public MysteryV(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            GregorianCalendar date, Difficulty difficulty, String question, Map<Location,String> tips) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                date, difficulty, question);
        this.tips = new HashMap<>();

        for (Map.Entry<Location,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public MysteryV(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            int year, int month, int dayOfMonth, Difficulty difficulty, String question,
            Map<Location,String> tips) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude,
                year, month, dayOfMonth, difficulty, question);
        this.tips = new HashMap<>();

        for (Map.Entry<Location,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public MysteryV(MysteryV m) 
    {
        super(m);
        this.tips = new HashMap<>();

        for (Map.Entry<Location,String> t : tips.getTips().entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public Map<Location,String> getTips() 
    {    
        HashMap<Location,String> aux = new HashMap<>();

        for (Map.Entry<Location,String> t : this.tips.entrySet())
            aux.put(t.getKey().clone(), t.getValue());

        return aux;
    }

    private void setTips(Map<Location,String> tips)
    {
        this.tips = new HashMap<>();

        for (Map.Entry<Location,String> t : tips.entrySet())
            this.tips.put(t.getKey().clone(), t.getValue());
    }

    public void addIntermidiatePoint(String question, Location location) 
    {
        this.tips.put(location,question);
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
