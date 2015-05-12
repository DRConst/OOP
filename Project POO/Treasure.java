
public class Treasure {

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

    public void setCode(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Cache c = (Cache) o;

            return this.nome.equals(c.getCode());
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
