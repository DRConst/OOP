/**
 * Classe que implementa uma generalizaﾃｧﾃ｣o de qualquer tipo de cache Vai ser o
 * topo da hierarquia de caches ﾃ� uma classe abstrata
 *
 * @version (2015.04.30)
 */

import java.util.*;
import java.io.Serializable;

public abstract class Cache implements Serializable 
{
    private String owner;
    private String name, code, description, hints;
    private TreeMap<String, Register> regBook;
    private Location defaultL;
    private GregorianCalendar date;
    private Difficulty difficulty;

    public Cache() 
    {
        this.owner = "";
        this.name = this.code = this.description = this.hints = "";
        this.regBook = new TreeMap<>();
        this.defaultL = new Location();
        this.date = new GregorianCalendar();
        this.difficulty = Difficulty.EASY;
    }

    public Cache(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            GregorianCalendar date, Difficulty difficulty) 
    {
        this.owner = owner;
        this.name = name;
        this.code = code;
        this.description = description;
        this.hints = hints;
        this.regBook = new TreeMap<>();

        for (Map.Entry<String,Register> r : regBook.entrySet())
            this.regBook.put(r.getKey(), r.getValue().clone());

        this.defaultL = new Location(defaultLatitude, defaultLongitude);
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
        this.difficulty = difficulty;
    }

    public Cache(String name, String code, String owner, String description, String hints,
            Map<String, Register> regBook, double defaultLatitude, double defaultLongitude,
            int year, int month, int dayOfMonth, Difficulty difficulty) 
    {
        this.owner = owner;
        this.name = name;
        this.code = code;
        this.description = description;
        this.hints = hints;
        this.regBook = new TreeMap<>();

        for (Map.Entry<String,Register> r : regBook.entrySet())
            this.regBook.put(r.getKey(), r.getValue().clone());

        this.defaultL = new Location(defaultLatitude, defaultLongitude);
        this.date = new GregorianCalendar(year, month, dayOfMonth);
        this.difficulty = difficulty;
    }

    public Cache(Cache c) 
    {
        this.owner = c.getOwner();
        this.name = c.getName();
        this.code = c.getCode();
        this.description = c.getDescription();
        this.hints = c.getHints();
        this.regBook = new TreeMap<>();

        for (Map.Entry<String,Register> r : c.getRegBook().entrySet())
            this.regBook.put(r.getKey(), r.getValue().clone());

        this.defaultL = new Location(c.getDefaultLocation());
        this.date = c.getDate();
        this.difficulty = c.getDifficulty();
    }
    
    public String getOwner() {
        return this.owner;
    }

    /**
     * Retorna o nome da cache
     *
     * @return o nome
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retorna o codigo da cache
     *
     * @return o codigo
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Retorna a descriﾃｧﾃ｣o da cache
     *
     * @return descriﾃｧﾃ｣o
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retorna as dicas dadas na cache
     *
     * @return dicas
     */
    public String getHints() {
        return this.hints;
    }

    /**
     * Devolve o Livro de Registos da cache
     *
     * @return o livro de registos da cache
     */
    public Map<String, Register> getRegBook() {
        return new TreeMap<>(this.regBook);
    }

    /**
     * Devolve a localizaﾃｧﾃ｣o inicial da cache
     *
     * @return a localizaﾃｧﾃ｣o inicial da cache
     */
    public Location getDefaultLocation() {
        return this.defaultL.clone();
    }

    /**
     * Devolve o valor de latitude inicial da cache
     *
     * @return a latitude inicial da cache
     */
    public double getDefaultLatitude() {
        return this.defaultL.getLatitude();
    }

    /**
     * Devolve o valor da longitude inicial da cache
     *
     * @return a longitude inicial da cache
     */
    public double getDefaultLongitude() {
        return this.defaultL.getLongitude();
    }

    /**
     * Devolve o ano da data que estﾃ｡ na cache
     *
     * @return ano da data
     */
    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }

    /**
     * Devolve o mes da data que estﾃ｡ na cache
     *
     * @return mes da data
     */
    public int getMonth() {
        return this.date.get(Calendar.MONTH);
    }

    /**
     * Devolve o dia da data que estﾃ｡ na cache
     *
     * @return dia da data
     */
    public int getDayOfMonth() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Devolve a data completa que estﾃ｡ na cache
     *
     * @return data
     */
    public GregorianCalendar getDate() {
        return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth());
    }

    /**
     * Devolve a dificuldade da cache Usa as constantes definidas anteriormente
     * para a dificuldade
     *
     * @return a dificuldade da cache
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Muda o nome da cache
     *
     * @param name: nome para a cache
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Muda o codigo da cache
     *
     * @param code: codigo para a cache
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Muda a descriﾃｧﾃ｣o da cache
     *
     * @param description a string descriﾃｧﾃ｣o da cache
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Muda as dicas dadas ao geochachers sobre a cache
     *
     * @param hints a string com as dicas sobre a cache
     */
    public void setHints(String hints) {
        this.hints = hints;
    }

    /**
     * Altera o livro de registos da cache
     *
     * @param regBook o livro de registos
     */
    public void setRegBook(Map<String, Register> regBook) {
        this.regBook = new TreeMap<>(regBook);
    }

    /**
     * Muda a latitude inicial da cache Como nﾃ｣o se pode alterar a latitude
     * inicial depois de criada a cache, o mﾃｩtodo ﾃｩ privado
     *
     * @param defaultLatitude a latitude inicial da cache
     */
    private void setDefaultLatitude(double defaultLatitude) {
        this.defaultL.setLatitude(defaultLatitude);
    }

    /**
     * Muda a longitude inicial da cache Como nﾃ｣o se pode alterar a longitude
     * inicial depois de criada a cache, o mﾃｩtodo ﾃｩ privado
     *
     * @param defaultLongitude a latitude inicial da cache
     */
    private void setDefaultLongitude(double defaultLongitude) {
        this.defaultL.setLongitude(defaultLongitude);
    }

    /**
     * Muda a data de criaﾃｧﾃ｣o da cache
     *
     * @param year o ano da data
     * @param month o mes da data
     * @param dayOfMonth o dia da data
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    public void setDate(GregorianCalendar date) {
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DAY_OF_MONTH));
    }
    /**
     * Muda a dificuldade da cache Usa as constantes definidas anteriormente
     * para a dificuldade
     *
     * @param difficulty a dificuldade da cache
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Adiciona um registo ao livro de registos da cache
     *
     * @param reg registo a adicionar
     */
    public void addRegister(Register reg) {
        this.regBook.put(reg.getUser(), reg.clone());
    }

    /**
     * Remove um registo ao livro de registos da cache
     *
     * @param reg registo a remover
     */
    public void removeRegister(Register reg) {
        this.regBook.remove(reg.getUser());
    }

    /**
     * Verifica se 2 cache sﾃ｣o iguais
     *
     * @return true se iguais, false caso contrﾃ｡rio
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{owner.hashCode(), name, code, regBook.hashCode(),
            defaultL.hashCode(), date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)});
    }

    public boolean equals(Object o) 
    {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        else 
        {
            Cache c = (Cache) o;

            if (!this.code.equals(c.getCode()))
                return false;

            for (String s : c.getRegBook().keySet())
                if (!this.regBook.containsKey(s))
                    return false;

            if (!this.defaultL.equals(c.getDefaultLocation()))
                return false;

            if (this.date.get(Calendar.YEAR) != c.getYear() || this.date.get(Calendar.MONTH) != c.getMonth()
                    || this.date.get(Calendar.DAY_OF_MONTH) != c.getDayOfMonth())
                return false;

            if (this.difficulty.equals(c.getDifficulty()))
                return false;

            return true;
        }
    }

    /**
     * Passa a informaﾃｧﾃ｣o da cache toda para string
     *
     * @return string resultado
     */
    public abstract String toString();

    /**
     * Clona uma cache
     *
     * @return clone da cache
     */
    public abstract Cache clone();

    /**
     * Passa a informaﾃｧﾃ｣o da cache toda para string
     *
     * @return string resultado
     */
    public String toStringSmall() {
        final StringBuilder sb = new StringBuilder("Cache{ ");
        sb.append("Nome='").append(name).append('\'');
        sb.append(", Codigo='").append(code).append('\'');
        sb.append(", Descricao='").append(description).append('\'');
        sb.append(", ").append(defaultL);
        sb.append(", Dificuldade=").append(difficulty);
        sb.append(" }");
        return sb.toString();
    }
}

