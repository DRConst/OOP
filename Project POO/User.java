
import java.util.*;

/**
 * @version (a version number or a date)
 */
public class User {

    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private Calendar birth;
    private TreeSet<Cache> activities;
    //private Statistics stats;
    private ArrayList<String> friends;

    public User(String email, String password, String name, String gender, String address, Calendar birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        //this.activities = new TreeSet<Cache>(new ComparatorCaches());
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
        this.activities = u.getCaches();
        //this.stats = u.getStatistics();
        this.friends = u.getAmigos();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public Calendar getBirth() {
        return birth;
    }

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
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addFriend(String email) {
        friends.add(email);
    }

    public void addCache(Cache a) {
        //stats.addEstAct(a.clone());
        //this.activities.add(a.clone());
    }

    public void removeCache(int pos) {
        Iterator it = activities.iterator();
        boolean done = false;
        int i = 0;
        while (done == false && it.hasNext()) {
            it.next();
            if (i == pos) {
                it.remove();
            }
            i++;
        }
    }

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

    public int hashCode() {
        return Arrays.hashCode(new Object[]{email, password, name, gender, address,
            /* stats.hashCode(),*/ activities.hashCode(), birth.get(Calendar.YEAR),
            birth.get(Calendar.MONTH), birth.get(Calendar.DAY_OF_MONTH), friends.hashCode()});
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        User u = (User) o;

        if (activities.size() != u.getCaches().size()) {
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
        if (!activities.containsAll(u.getCaches())) {
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
