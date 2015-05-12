
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
    
    public ArrayList<Location> getTrackHistory(){
        return new ArrayList<>(this.trackHistory); 
    }
    
    public String getCod(){
        return this.cod;
    }
    
    public String getDescription(){
        return this.cod;
    }
    
    public String getObjective(){
        return this.cod;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    private void setDate(int year, int month, int dayOfMonth) { 
        this.date = new GregorianCalendar(year, month, dayOfMonth); 
    }
    
    public void getTrackHistory(ArrayList<Location> trackHistory){
        this.trackHistory = new ArrayList<>(trackHistory);
    }
    
    public void setTrackHistory(ArrayList<Location> trackHistory){
        this.trackHistory = new ArrayList<>(trackHistory); 
    }
    
    public void setCod(String cod){
        this.cod = cod;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setObjective(String objective){
        this.objective = objective;
    }
    
    
    
}
