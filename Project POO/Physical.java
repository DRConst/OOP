/**
 * Classe que implementa um cache fisica
 *
 * @version (version number or date here)
 */

import java.util.*;
import java.io.Serializable;

public abstract class Physical extends Cache implements Serializable
{
    private Location currentL;
    private Size size;
    private ArrayList<Treasure> treasures;

    public Physical() 
    {
        super();
        this.size = Size.MICRO;
        this.treasures = new ArrayList<>();
    }

    public Physical(String name, String code, String owner, String description, String hints, Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, GregorianCalendar date, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, date, difficulty);
        this.currentL = new Location(defaultLatitude, defaultLongitude);
        this.treasures = new ArrayList<>(treasures);
    }

    public Physical(String name, String code, String owner, String description, String hints, Map<String, Register> regBook, double defaultLatitude, double defaultLongitude, int year, int month, int dayOfMonth, Difficulty difficulty, double currentLatitude, double currentLongitude, Collection<Treasure> treasures) 
    {
        super(name, code, owner, description, hints, regBook, defaultLatitude, defaultLongitude, year, month, dayOfMonth, difficulty);
        this.currentL = new Location(defaultLatitude, defaultLongitude);
        this.treasures = new ArrayList<>(treasures);
    }

    public Physical(Physical p) 
    {
        super(p);
        this.currentL = new Location(p.getCurrentLocation());

        this.treasures = new ArrayList<>();

        for (Treasure t : p.getTreasures())
            this.treasures.add(t.clone());
    }

    /**
     * Devolve a localização atual da cache
     *
     * @return a localização atual da cache
     */
    public Location getCurrentLocation() {
        return this.currentL.clone();
    }

    /**
     * Devolve o valor da latitude no momento da cache Não pode estar
     * distanciada mais de 10 metros da localização inicial
     *
     * @return a latitude no momento da cache
     */
    public double getCurrentLatitude() {
        return this.currentL.getLatitude();
    }

    /**
     * Devolve o valor da longitude no momento da cache Não pode estar
     * distanciada mais de 10 metros da localização inicial
     *
     * @return a longitude no momento da cache
     */
    public double getCurrentLongitude() {
        return this.currentL.getLongitude();
    }

    /**
     * Devolve o máximo de tesouros permitidos na cache
     *
     * @return treasures a lista com os tesouros
     */
    public int getSize() {
        return this.size.getValue();
    }

    /**
     * Devolve os tesouros presentes na cache
     *
     * @return a lista com os tesouros
     */
    public Collection<Treasure> getTreasures() 
    {
        ArrayList<Treasure> aux = new ArrayList<>();

        for (Treasure t : this.treasures)
            aux.add(t.clone());

        return aux;
    }

    /**
     * Muda a localização no momento da cache Não pode estar distanciado mais de
     * 10 metros da localização inicial da cache
     *
     * @param latitude a latitude no momento da cache
     * @param longitude a longitude no momento da cache
     */
    public void setCurrentLocation(double latitude, double longitude) 
    {
        // Adicionar verificador de distância

        this.currentL.setLatitude(latitude);
        this.currentL.setLongitude(longitude);
    }

    /**
     * Muda a latitude no momento da cache
     *
     * @param currentLatitude a latitude no momento da cache
     */
    public void setCurrentLatitude(double currentLatitude) {
        this.currentL.setLatitude(currentLatitude);
    }  // adicionar verificador de distancia

    /**
     * Muda a longitude no momento da cache
     *
     * @param currentLongitude a longitude no momento da cache
     */
    public void setCurrentLongitude(double currentLongitude) {
        this.currentL.setLongitude(currentLongitude);
    }  // adicionar verificador de distancia

    /**
     * Coloca na cache o máximo de tesouros permitidos na cache
     *
     * @param s size a constante com o tamanho
     */
    public void setSize(Size s) {
        this.size = s;
    }

    /**
     * Coloca na cache um conjunto de tesouros passado como parametro
     *
     * @param treasures o conjunto de tesouros a colocar na cache
     */
    public void setTreasures(Collection<Treasure> treasures) 
    {
        if (treasures.size() <= this.size.getValue()) {
            this.treasures = new ArrayList<>();

            for (Treasure t : treasures)
                this.treasures.add(t.clone());
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{super.hashCode(), currentL.hashCode(), size, treasures.hashCode()});
    }

    /**
     * Verifica se 2 cache fisicas são iguais
     *
     * @return true se iguais, false caso contrário
     */
    public boolean equals(Object o) 
    {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } 
        else 
        {
            Physical p = (Physical) o;

            if (!super.equals(p)) {
                return false;
            }

            if (!this.currentL.equals(p.getCurrentLocation())) {
                return false;
            }

            if (this.size.getValue() != p.getSize()) {
                return false;
            }

            for (Treasure t : p.getTreasures()) {
                if (!this.treasures.contains(t)) {
                    return false;
                }
            }

            return true;
        }
    }

    public abstract String toString();

    public abstract Physical clone();
}

