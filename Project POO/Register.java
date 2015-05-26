
/**
 * Classe que implementa um registo de que uma pessoa completou uma cache
 *
 * @version (2015.05.01)
 */

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Register {

    private String user;
    private String comment;
    private GregorianCalendar date;

    public Register() {
        this.user = "";
        this.comment = "";
        this.date = new GregorianCalendar();
    }

    public Register(String user, String comment, GregorianCalendar date) {
        this.user = user;
        this.comment = comment;
        this.date = new GregorianCalendar(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
    }

    public Register(String user, String comment, int year, int month, int dayOfMonth) {
        this.user = user;
        this.comment = comment;
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    public Register(Register reg) {
        this.user = reg.getUser();
        this.comment = reg.getComment();
        this.date = reg.getDate();
    }

    /**
     * Devolve o utilizador que esta no registo
     *
     * @return utilizador
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Devolve o comentário que está no registo
     *
     * @return comentário
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Devolve o ano da data que está no registo
     *
     * @return ano da data
     */
    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }

    /**
     * Devolve o mes da data que está no registo
     *
     * @return mes da data
     */
    public int getMonth() {
        return this.date.get(Calendar.MONTH);
    }

    /**
     * Devolve o dia da data que está no registo
     *
     * @return dia da data
     */
    public int getDayOfMonth() {
        return this.date.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Devolve a data completa que está no registo
     *
     * @return data
     */
    public GregorianCalendar getDate() {
        return new GregorianCalendar(this.getYear(), this.getMonth(), this.getDayOfMonth());
    }

    /**
     * Muda o utilizador que está no registo Como não se pode alterar o
     * utilizador depois de criado o registo, o método é privado
     *
     * @param user o email do utilizador que escreve o registo
     */
    private void setUser(String user) {
        this.user = user;
    }

    /**
     * Muda o comentário que está no registo
     *
     * @param comment o comentário que o utilizador escreve no registo
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Muda a data em que foi escrito o registo
     *
     * @param year ano da data
     * @param month mes da data
     * @param dayOfMonth dia da data
     */
    public void setDate(int year, int month, int dayOfMonth) {
        this.date = new GregorianCalendar(year, month, dayOfMonth);
    }

    /**
     * Dá um código de hash para o registo
     *
     * @return hashcode do registo
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{user.hashCode(), comment, date.get(Calendar.YEAR),
            date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH)});
    }

    /**
     * Verifica se 2 registo são iguais
     *
     * @return true se iguais, false caso contrário
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            Register r = (Register) o;

            return (this.user.equals(r.getUser()) && this.comment.equals(r.getComment())
                    && this.getYear() == r.getYear() && this.getMonth() == r.getMonth()
                    && this.getDayOfMonth() == r.getDayOfMonth());
        }
    }

    /**
     * Devolve uma string com a descrição do registo
     *
     * @return string resultado
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("---------------Registo---------------\n\n");
        s.append("\tUtilizador: ").append(this.user);
        s.append("\tData: ").append(this.getYear()).append("/").append(this.getMonth())
                .append("/").append(this.getDayOfMonth()).append("\n");
        s.append("\tComentário:\n\n\t").append(this.comment);
        s.append("-------------------------------------");

        return s.toString();
    }

    /**
     * Clona o registo
     *
     * @return o clone do registo
     */
    public Register clone() {
        return new Register(this);
    }
}
