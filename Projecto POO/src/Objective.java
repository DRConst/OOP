/**
 * Created by Diogo on 09/05/2015.
 */
public class Objective {
    private Coord coord;
    private String desciption;
    boolean completed;

    public Objective(Coord coord, String desciption, boolean completed) {
        this.coord = coord;
        this.desciption = desciption;
        this.completed = completed;
    }
    public Objective() {
        this.coord = null;
        this.desciption = null;
        this.completed = false;
    }

    public Object clone(){
        return new Objective(this);
    }

    public Objective(Objective o) {
        this.coord = o.getCoord();
        this.desciption = o.getDesciption();
        this.completed = o.isCompleted();
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "coord=" + coord +
                ", desciption='" + desciption + '\'' +
                ", completed=" + completed +
                '}';
    }
}
