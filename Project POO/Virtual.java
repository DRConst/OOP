/**
 * Classe que implementa uma cache virtual
 * 
 * @version (version number or date here)
 */

import java.util.*;

public abstract class Virtual extends Cache
{
    private String question;

    public Virtual() 
    {
        super();
        this.question = "";
    }

    public Virtual(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, String question)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);
        this.question = question;
    }

    public Virtual(String name, String code, String description, String hints, Map<String,Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, String question)
    {
        super(name, code, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty);
        this.question = question;
    }

    public Virtual(Virtual p)
    {
        super(p);
        this.question = p.getQuestion();
    }

    public String getQuestion() { return this.question; }

    public void setQuestion(String question) { this.question = question; }

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

            if (!this.question.equals(v.getQuestion()))
                return false;

            return true;
        }
    }

    public abstract String toString();

    public abstract Virtual clone();
}

