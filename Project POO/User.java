/**
 * Classe Utilizador
 *
 * @version (a version number or a date)
 */

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

    //Variáveis de Instância

    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private Calendar birth;
    private TreeSet<Cache> activities;
    private TreeSet<Cache> createdCaches;
    private ArrayList<User> friends;
    private boolean admin;

    //Construtor parameterizado e de copia

    public User() {
        this.activities = new TreeSet<>(new CacheComparator());
        this.createdCaches = new TreeSet<>(new CacheComparator());
        this.friends = new ArrayList<>();
    }

    public User(String email, String password, String name, String gender, String address, Calendar birth) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.activities = new TreeSet<>(new CacheComparator());
        this.createdCaches = new TreeSet<>(new CacheComparator());
        this.friends = new ArrayList<>();
    }

    public User(User u) {
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.name = u.getName();
        this.gender = u.getGender();
        this.address = u.getAddress();
        this.birth = u.getBirth();
        this.activities = u.getActivities();
        this.createdCaches = u.getCreatedCaches();
        this.friends = u.getFriends();
    }

    //Getters e Setters

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    /**
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
    public String getPassword() {
        return password;
    }

    /**
     * Devolve nome do utilizador
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Devolve genero do utilizador
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Devolve morada do utilizador
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Devolve data de nascimento do utilizador
     *
     * @return birth
     */
    public Calendar getBirth() {
        return birth;
    }

    /**
     * Devolve a Lista de Amigos
     *
     * @return friendsL lista de amigos
     */
    public ArrayList<User> getFriends() {
        ArrayList<User> friendsL = new ArrayList<User>();
        for (User u : friends) {
            friendsL.add(u);
        }
        return friendsL;
    }

    /**
     * Devolve a Lista de Atividades
     *
     * @return activitiesL lista de atividades
     */
    public TreeSet<Cache> getActivities() {
        TreeSet<Cache> activitiesL = new TreeSet<>(new CacheComparator());

        for (Cache a : activities) {
            activitiesL.add(a.clone());
        }
        return activitiesL;
    }

    /**
     * Devolve a Lista de Caches Criadas
     *
     * @return cCaches lista de atividades
     */
    public TreeSet<Cache> getCreatedCaches() {
        TreeSet<Cache> cCaches = new TreeSet<>(new CacheComparator());

        for (Cache a : createdCaches) {
            cCaches.add(a.clone());
        }
        return cCaches;
    }

    
    /**
     * Altera a password do utilizador pelo parâmetro passado
     *
     * @param password - nova password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Altera a morada do utilizador pelo parâmetro passado
     *
     * @param address - nova morada
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Adiciona um utilizador à lista de amigos
     *
     * @param usr do novo amigo utilizador
     */
    public void addFriend(User usr, boolean goOn) {
        friends.add(usr);
        if (goOn)
            usr.addFriend(this, false);
    }

    /**
     * Adiciona uma cache à lista de atividades
     *
     * @param a - cache a adicionar
     */
    public void addActivity(Cache a) {
        //stats.addStats(a.clone());
        this.activities.add(a.clone());
    }

    /**
     * Remove uma cache da lista de atividades
     *
     * @param pos - posição da lista de atividades onde se encontra a atividade
     * a remover
     */
    public void removeActivity(int pos) {
        Iterator it = activities.iterator();
        boolean done = false;
        int i = 0;
        while (done == false && it.hasNext()) {
            it.next();
            if (i == pos) {
                it.remove();
                done = true;
            }
            i++;
        }
    }


    public void registerCacheCreation(Cache c)
    {
        this.createdCaches.add(c);
    }
    
    public void deleteCacheCreation(Cache c)
    {
    	this.createdCaches.remove(c);
    }
    
    public void deleteCacheCreation(String code)
    {
    	for(Cache c : this.createdCaches)
    	{
    		if(c.getCode().equals(code))
    		{
    	    	this.createdCaches.remove(c);    	
    			return;
    		}		
    	}
    }
    
    public Set<Cache> nCaches(GregorianCalendar lowerDate, GregorianCalendar topDate){
	TreeSet<Cache> aux = new TreeSet<>(new CacheComparatorByDate());
	Set<Cache> res =  new TreeSet<>( new CacheComparatorByDate());
	aux.addAll(activities);
	/*Actividades artificiais para efeitos de comparacao*/
	Cache c1 = new TraditionalP(); 
        c1.setDate(lowerDate);
	Cache c2 = new TraditionalP(); 
        c2.setDate(topDate);

	res.addAll( aux.subSet(c1, true, c2, true));

	return res;
	
    }

    /**
     * funções que convertem as listas em strings
     */
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
        for (User u : friends) {
            s.append(u.getEmail());
            s.append("\n");
        }
        return s.toString();
    }

    public boolean removeFriend(User usr) { return friends.remove(usr);}

    public boolean hasFriend(String userName)
    {
        for (User user : friends) {
            if(user.getEmail().equals(userName))
                return true;
        }
        return false;
    }

    public User getFriend(String userName)
    {
        for (User user : friends) {
            if(user.getEmail().equals(userName))
                return user;
        }
        return null;
    }

    public int calcEstimatedTime(String s)
    {
        int time;
        int nrCaches=0;

        for (Cache c : this.activities)
            if (c.getClass().getSimpleName().equals(s))
                nrCaches++;

        int fatRandom = new Random().nextInt(40) - 10;

        return (120 - ((nrCaches)/120) + fatRandom);
    }

    /**
     * HashCode para a classe User
     */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{email, password, name, gender, address,
            /* stats.hashCode(),*/ activities.hashCode(), birth.get(Calendar.YEAR),
            birth.get(Calendar.MONTH), birth.get(Calendar.DAY_OF_MONTH), friends.hashCode()});
    }

    /**
     * Equals para a classe User
     *
     * Utiliza para comparar: - o tamanho das listas de amigos (em vez de
     * comparar um por um) - email, nome e genero direto
     *
     * @return o - objeto a comparar
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        User u = (User) o;

        if (activities.size() != u.getActivities().size()) {
            return false;
        }
        if (friends.size() != u.getFriends().size()) {
            return false;
        }

        if (!(email.equals(u.getEmail()) && name.equals(u.getName()) && gender.equals(u.getGender())
                && address.equals(u.getAddress()) && birth.equals(u.getBirth()))) {
            return false;
        }
        if (!(birth.get(Calendar.YEAR) == u.getBirth().get(Calendar.YEAR)
                && birth.get(Calendar.MONTH) == u.getBirth().get(Calendar.MONTH)
                && birth.get(Calendar.DAY_OF_MONTH) == u.getBirth().get(Calendar.DAY_OF_MONTH))) {
            return false;
        }
        if (!activities.containsAll(u.getActivities())) {

            return false;
        }
        for (User usr : friends) {
            if (!u.getFriends().contains(usr)) {
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
