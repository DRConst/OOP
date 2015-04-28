
import java.util.*;

/**
 * Classe Utilizador
 *
 * @version (a version number or a date)
 */
public class User {

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Variáveis de Instância
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private Calendar birth;
    private TreeSet<Cache> activities;
    //private Statistics stats;
    private ArrayList<String> friends;

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Construtor parameterizado e de copia
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public User(String email, String password, String name, String gender, String address, Calendar birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
        //this.activities = new TreeSet<Cache>(new ComparatorCaches());
=======
        //this.activities = new TreeSet<Cache>(new CacheComparator());
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
        //this.stats = new Statistics();
        this.friends = new ArrayList<>();
    }

    public User(User u) {
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.name = u.getName();
        this.gender = u.getGender();
        this.address = u.getAddress();
        this.birth = u.getBirth();
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
        this.activities = u.getCaches();
=======
        this.activities = u.getActivities();
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
        //this.stats = u.getStatistics();
        this.friends = u.getAmigos();
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
    public String getEmail() {
        return email;
    }

=======
    /**
     * Getters e Setters
     *
     * Devolve o email do utilizador
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }
/**
     * Devolve Password do utilizador
     * 
     * @return password
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public String getPassword() {
        return password;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Devolve nome do utilizador
     * 
     * @return name
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public String getName() {
        return name;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Devolve genero do utilizador
     * 
     * @return gender
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public String getGender() {
        return gender;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Devolve morada do utilizador
     * 
     * @return address
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public String getAddress() {
        return address;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Devolve data de nascimento do utilizador
     * 
     * @return birth
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public Calendar getBirth() {
        return birth;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
    public ArrayList<String> getAmigos() {
        ArrayList<String> novo = new ArrayList<>();
        for (String mail : friends) {
            novo.add(mail);
        }
        return novo;
    }

   

    public TreeSet<Cache> getCaches() {
        TreeSet<Cache> nova = new TreeSet<Cache>(new ComparatorCaches());

        for (Cache a : activities) {
            //nova.add(a.clone());
        }

        return nova;
    }
/*
    public Statistics getStatistics() {
        return stats.clone();
    }
*/
=======
    /**
     * Devolve a Lista de Amigos
     *
     * @return friendsL lista de amigos
     */
    public ArrayList<String> getAmigos() {
        ArrayList<String> friendsL = new ArrayList<>();
        for (String mail : friends) {
            friendsL.add(mail);
        }
        return friendsL;
    }

    /**
     * Devolve a Lista de Atividades
     *
     * @return activitiesL lista de atividades
     */
    public TreeSet<Cache> getActivities() {
        TreeSet<Cache> activitiesL = new TreeSet<Cache>(new CacheComparator());

        for (Cache a : activities) {
            //activitiesL.add(a.clone());
        }

        return activitiesL;
    }
    /** futuramente para devolver as estatísticas do utilizador
     public Statistics getStatistics() {
     return stats.clone();
     }
     */

    /**
     * Altera a password do utilizador pelo parâmetro passado
     *
     * @param password - nova password
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Altera a morada do utilizador pelo parâmetro passado
     *
     * @param address - nova morada
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public void setAddress(String address) {
        this.address = address;
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Adiciona um utilizador à lista de amigos
     *
     * @param email do novo amigo utilizador
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public void addFriend(String email) {
        friends.add(email);
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
    public void addCache(Cache a) {
        //stats.addEstAct(a.clone());
        //this.activities.add(a.clone());
    }

=======
    /**
     * Adiciona uma cache à lista de atividades
     *
     * @param a - cache a adicionar
     */
    public void addActivity(Cache a) {
        //stats.addStats(a.clone());
        //this.activities.add(a.clone());
    }

    /**
     * Remove uma cache da lista de atividades
     *
     * @param pos - posição da lista de atividades onde se encontra a atividade a remover
     */
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public void removeCache(int pos) {
        Iterator it = activities.iterator();
        boolean done = false;
        int i = 0;
        while (done == false && it.hasNext()) {
            it.next();
            if (i == pos) {
                it.remove();
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
                done = true;
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
            }
            i++;
        }
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /** funções que convertem as listas em strings*/
    
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public String activitiesToString() {
        StringBuilder s = new StringBuilder();
        for (Cache a : activities) {
            s.append(a.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public String friendsToString() {
        StringBuilder s = new StringBuilder();
        for (String mail : friends) {
            s.append(mail);
            s.append("\n");
        }
        return s.toString();
    }
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165

=======
/**
     * HashCode para a classe User
     */
    @Override
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public int hashCode() {
        return Arrays.hashCode(new Object[]{email, password, name, gender, address,
            /* stats.hashCode(),*/ activities.hashCode(), birth.get(Calendar.YEAR),
            birth.get(Calendar.MONTH), birth.get(Calendar.DAY_OF_MONTH), friends.hashCode()});
    }

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
=======
    /**
     * Equals para a classe User
     * 
     * Utiliza para comparar: 
     * - o tamanho das listas de amigos (em vez de comparar um por um)
     * - email, nome e genero direto
     * 
     * @return o - objeto a comparar
     */
    @Override
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        User u = (User) o;

<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
        if (activities.size() != u.getCaches().size()) {
=======
        if (activities.size() != u.getActivities().size()) {
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
            return false;
        }
        if (friends.size() != u.getAmigos().size()) {
            return false;
        }

        if (!(email.equals(u.getEmail()) && name.equals(u.getName()) && gender.equals(u.getGender())
                && address.equals(u.getAddress()) && birth.equals(u.getBirth()) /* && stats.equals(u.getStatistics())*/)) {
            return false;
        }
        if (!(birth.get(Calendar.YEAR) == u.getBirth().get(Calendar.YEAR)
                && birth.get(Calendar.MONTH) == u.getBirth().get(Calendar.MONTH)
                && birth.get(Calendar.DAY_OF_MONTH) == u.getBirth().get(Calendar.DAY_OF_MONTH))) {
            return false;
        }
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
        if (!activities.containsAll(u.getCaches())) {
=======
        if (!activities.containsAll(u.getActivities())) {
>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
            return false;
        }
        for (String s : friends) {
            if (!u.getAmigos().contains(s)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("----------------Informações da conta----------------\n");
        s.append("Email: ");
        s.append(email);
        s.append("\n");
        s.append("Nome: ");
        s.append(name);
        s.append("\n");
        s.append("Genero: ");
        s.append(gender);
        s.append("\n");
        s.append("Morada: ");
        s.append(address);
        s.append("\n");

        s.append("Data Nascimento: ");
        s.append(birth.get(Calendar.DAY_OF_MONTH));
        s.append("/");
        s.append(birth.get(Calendar.MONTH) + 1);
        s.append("/");
        s.append(birth.get(Calendar.YEAR));
<<<<<<< 17fbdbeee22d382c82567ea6d3fa9cabf5d6f165
        
=======

>>>>>>> 501c134a0554b1bd1eaf80553340e08dd17d8438
        /*Não sei se aqui é melhor colocar o número de amigos ou mostrar a lista toda de amigos*/
        s.append("\n");
        s.append("Número de amigos: ");
        s.append(friends.size());
        s.append("\n");
        s.append("----------------------------------------------------\n");

        return s.toString();
    }

    public User clone() {
        return new User(this);
    }
}
