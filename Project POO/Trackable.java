
import java.util.*;

public class Trackable extends Treasure {

    //private int kmTotal;
    private User owner;
    private GregorianCalendar date;
    private ArrayList<Location> trackHistory;
    private String cod, description, objective;

    public Trackable() {
        super();
        this.owner = null;
        this.date = new GregorianCalendar();
        this.trackHistory = new ArrayList<>();
        this.cod = this.description = this.objective = "";
    }

    public Trackable(String name, User owner, GregorianCalendar date, ArrayList<Location> trackHistory, String cod, String description, String objective) {
        super(name);
        this.owner = owner;
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        this.trackHistory = new ArrayList<>(trackHistory);
        this.cod = cod;
        this.description = description;
        this.objective = objective;
    }

    public Trackable(String name, User owner, int year, int month, int dayOfMonth, ArrayList<Location> trackHistory, String cod, String description, String objective) {
        super(name);
        this.owner = owner;
        this.date = new GregorianCalendar(year, month, dayOfMonth);
        this.trackHistory = new ArrayList<>(trackHistory);
        this.cod = cod;
        this.description = description;
        this.objective = objective;
    }

    public Trackable(Trackable c) {
        super(c);
        this.owner = c.getOwner();
        this.date = c.getDate();
        this.trackHistory = new ArrayList<>(c.getTrackHistory());
        this.cod = c.getCod();
        this.description = c.getDescription();
        this.objective = c.getObjective();
    }

    public User getOwner() {
        return this.owner;
    }

    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }

    public int getMonth() {
        return this.date.get(Calendar.MONTH);
    }

    public int getDayOfMonth() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }

    public GregorianCalendar getDate() {
        return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth());
    }

    public ArrayList<Location> getTrackHistory() {
        return new ArrayList<>(this.trackHistory);
    }

    public String getCod() {
        return this.cod;
    }

    public String getDescription() {
        return this.cod;
    }

    public String getObjective() {
        return this.cod;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    private void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    public void setTrackHistory(ArrayList<Location> trackHistory) {
        this.trackHistory = new ArrayList<>(trackHistory);
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), owner.hashCode(),
            date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH),
            trackHistory.hashCode(), cod, description, objective});
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Trackable t = (Trackable) o;

            if (this.date.get(Calendar.YEAR) != t.getYear() || this.date.get(Calendar.MONTH) != t.getMonth() || this.date.get(Calendar.DAY_OF_MONTH) != t.getDayOfMonth()) {
                return false;
            }

            for (Location s : t.getTrackHistory()) {
                if (!this.trackHistory.contains(s)) {
                    return false;
                }
            }

            if (!this.cod.equals(t.getCod())) {
                return false;
            }

            if (!this.description.equals(t.getDescription())) {
                return false;
            }

            if (!this.objective.equals(t.getObjective())) {
                return false;
            }

            return true;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("-----------------Trackable-----------------\n\n");

        s.append("Dono: ");
        s.append(this.getOwner().getName());
        s.append("\n");

        s.append("\nCódigo: ");
        s.append(this.getCod());
        s.append("\n");

        s.append("\nData de Criação: ");
        s.append(this.getYear()).append("/").append(this.getMonth()).append("/").append(this.getDayOfMonth());
        s.append("\n");

        s.append("\nDescrição: ");
        s.append(this.getDescription());
        s.append("\n");

        s.append("\nObjective: ");
        s.append(this.getObjective());
        s.append("\n");

        s.append("\n\nLocais Por Onde Passou:\n");
        for (Location tH : this.trackHistory) {
            s.append(tH);
            s.append("\n");
            s.append(tH.toString());
            s.append("\n\n");
        }

        return s.toString();
    }

    public Trackable clone() {
        return new Trackable(this);
    }

}
