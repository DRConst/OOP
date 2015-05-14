
import java.util.Arrays;


/**
 * Classe que implementa uma Localização Flexivel
 *
 * @version (a version number or a date)
 */
public class FlexLocation extends Location {

    private double currentLatitude;
    private double currentLongitude;

    public FlexLocation() {
        super();
        this.currentLatitude = 0.0;
        this.currentLongitude = 0.0;
    }

    public FlexLocation(double la, double lo, double cla, double clo) {
        super(la, lo);
        this.currentLatitude = cla;
        this.currentLongitude = clo;
    }

    public FlexLocation(FlexLocation f) {
        super(f);
        this.currentLatitude = f.getCurrentLatitude();
        this.currentLongitude = f.getCurrentLongitude();
    }

    public double getCurrentLatitude() {
        return this.currentLatitude;
    }

    public double getCurrentLongitude() {
        return this.currentLongitude;
    }

    public void setCurrentLatitude(double cla) {
        this.currentLatitude = cla;
    }

    public void setCurrentLongitude(double clo) {
        this.currentLongitude = clo;
    }

    public void changeCurrentLocation(double cla, double clo) {
        this.currentLatitude = cla;
        this.currentLongitude = clo;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(),currentLatitude,currentLongitude});
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            FlexLocation f = (FlexLocation) o;

            if (!super.equals(f)) {
                return false;
            }

            return (this.currentLatitude == f.getCurrentLatitude() && this.currentLongitude == f.getCurrentLongitude());
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(super.toString());

        s.append("\nLatitude Atual: ");
        s.append(this.currentLatitude);
        s.append("\nLongitude Atual: ");
        s.append(this.currentLongitude);

        return s.toString();
    }

    public FlexLocation clone() {
        return new FlexLocation(this);
    }
}
