
import java.util.Arrays;
import java.io.Serializable;

public class Treasure implements Serializable
{
    private String nome;

    public Treasure() {
        this.nome = "";
    }

    public Treasure(String nome) {
        this.nome = nome;
    }

    public Treasure(Treasure t) {
        this.nome = t.getNome();
    }

    public String getNome() {
        return this.nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{nome});
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Treasure t = (Treasure) o;

            return this.nome.equals(t.getNome());
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Nome do Tesouro: ").append(this.getNome());

        return s.toString();
    }

    public Treasure clone() {
        return new Treasure(this);
    }
}
