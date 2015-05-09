/**
 * Created by Diogo on 09/05/2015.
 */
public class Coord {

    double latitude, longitude;
    /*boolean north, east;*//*North and East can be defined as positive coords and South and West as negative*/

    public Coord()
    {
        latitude = longitude = 0;
    }

    public Coord(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coord(Coord c)
    {
        this.longitude = c.getLongitude();
        this.latitude = c.getLatitude();
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
