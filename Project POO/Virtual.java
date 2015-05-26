/**
 * Classe que implementa uma cache virtual
 * 
 * @version (version number or date here)
 */

import java.util.GregorianCalendar;
import java.util.Map;

public abstract class Virtual extends Cache
{
    private String finalQuestion;

    public Virtual() 
    {
        super();
        this.finalQuestion = "";
    }

    public Virtual(String name, String code, User owner, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, String question)
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);
        this.finalQuestion = question;
    }

    public Virtual(String name, String code, User owner, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, String question)
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty);
        this.finalQuestion = question;
    }

    public Virtual(Virtual p)
    {
        super(p);
        this.finalQuestion = p.getFinalQuestion();
    }

    public String getFinalQuestion() { return this.finalQuestion; }

    public void setFinalQuestion(String question) { this.finalQuestion = question; }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else
        {
            Virtual v = (Virtual) o;

            if (!super.equals(v))
                return false;

            if (!this.finalQuestion.equals(v.getFinalQuestion()))
                return false;

            return true;
        }
    }

    public abstract String toString();

    public abstract Virtual clone();
}

