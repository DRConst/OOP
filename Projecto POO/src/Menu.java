import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Diogo on 06/05/2015.
 */
public class Menu {
    private Login loginManager;
    private boolean isAuth = false;
    private User activeUser;
    private TreeMap<String, Cache> storedCaches;
    public Menu()
    {
        loginManager = new Login();
        activeUser = null;
        storedCaches = new TreeMap<String, Cache>();
    }
    private void clearScreen()
    {
        /*try {
            if (System.getProperty("os.name").equals("Windows 8.1"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        }catch (IOException e)
        {
            e.printStackTrace();
        }*/
            for(int i = 0; i < 50; i++)
                System.out.println();/*Stupid and need to be replaced by smelting proper*/
    }
    private void loginDialog()
    {
        int answer = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.printf("Utilizador Activo: %s\n\n", (isAuth ? activeUser.getEmail() : "Nenhum"));
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Registar um novo Utilizador");
        System.out.println("2 - Autenticar um Utilizador");
        System.out.println("3 - Voltar ao Menu");
        try {
            answer = input.read();
            input.read();/*Gooble up the \n*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(answer == '1')
        {
            String email, password, name, gender, adress;
            int day, month, year;
            GregorianCalendar DoB;
            clearScreen();
            try {
                System.out.println("Insira o Email: ");
                email = input.readLine();
                System.out.println("Insira a Password: ");
                password = input.readLine();
                System.out.println("Insira os Detalhes do Utilizador");
                System.out.println("Nome: ");
                name = input.readLine();
                System.out.println("Sexo: ");
                gender = input.readLine();
                System.out.println("Morada: ");
                adress = input.readLine();
                System.out.println("Data de Nascimento: ");
                System.out.print("Dia: ");
                day = sc.nextInt();
                System.out.print("M?s: ");
                month = sc.nextInt();
                System.out.print("Ano: ");
                year  = sc.nextInt();
                DoB = new GregorianCalendar(year, month, day);
                loginManager.registerUser(email,password, name, gender, adress, DoB);
            }catch (Exception e){}

        }
        else if(answer == '2')
        {
            String email, password;
            clearScreen();
            try {
                System.out.println("Insira o Email: ");
                email = input.readLine();
                System.out.println("Insira a Password: ");
                password = input.readLine();

                activeUser = loginManager.authenticateUser(email, password);
                if(activeUser != null)
                {
                    System.out.printf("Utilizador %s autenticado;\n" +
                            "\tNome: %s", activeUser.getEmail(), activeUser.getName());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(answer == 3)
        {
            return;
        }
        else
            System.out.println("Input Invalido.");


    }

    private void listUsersActivities(User user)
    {
        TreeSet<Cache> activities;
        Cache c;
        int cnt = 0;
        Iterator<Cache> it;
        clearScreen();
        activities = user.getActivities();
        if(activities == null)
        {
            System.out.println("O utilizador nao tem actividades registadas");
        }
        else{
            it = activities.iterator();
            while(it.hasNext() && cnt < 10)
            {
                c = it.next();
                System.out.println(c.toString());/*Temp*/
            }
        }
    }

    private void listActivities()
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> friends;
        int input;
        int i;
        clearScreen();
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Ultimas Acividades do Proprio");
        System.out.println("2 - Ultimas Acividades de um Amigo");

        input = sc.nextInt();

       if(input == 1)
                listUsersActivities(activeUser);
       else if (input == 2)
       {
           friends = activeUser.getFriends();
           if(friends != null)
           {
               System.out.println("Escolha o amigo: ");
               for(i = 0; i < friends.size(); i++)
               {
                   System.out.printf("%d - %s, %s\n", i + 1, friends.get(i).getName(), friends.get(i).getEmail());
               }
               System.out.printf("%d - Sair\n", i + 1);
               input = sc.nextInt();
               if(input >= i + 1)
                   return;
               else
               {
                   listUsersActivities(friends.get(input - 1));
               }

           }
       }

    }

    private void registerDiscovery()
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        System.out.println("Insira o Codigo da Cache: ");
        try {
            answer = input.readLine();
            if(!storedCaches.containsKey(answer))
            {
                System.out.println("C?digo Inexistente");
            }else
            {
                activeUser.addActivity(storedCaches.get(input));
                System.out.println("Descoberta Registada");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean menuLoop()/*Returns whether app should continue or not */
    {
        Scanner sc = new Scanner(System.in);
        int input;
        if(!isAuth)
        {
            System.out.println("Nenhum Utilizador Activo, deseja fazer login/registar (1) ou sair (2) : ");
            input = sc.nextInt();
            if(input == 1)
                loginDialog();
            else if(input == 2)
                return false;
            else
                return true;
        }

        clearScreen();
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Visualizar Ultimas Acividades");
        System.out.println("2 - Registar Uma Nova Cache");
        System.out.println("3 - Registar Descoberta de uma Cache");


        input = sc.nextInt();

        switch (input)
        {
            case 1:
                listActivities();
                break;
            case 3:
                registerDiscovery();
                break;
        }


        return false;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();

        while(menu.menuLoop())
        {

        }
    }
}

