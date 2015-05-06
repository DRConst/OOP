import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Diogo on 06/05/2015.
 */
public class Menu {
    private Login loginManager;
    private boolean isAuth = false;
    private User activeUser;
    public Menu()
    {
        loginManager = new Login();
        activeUser = null;
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
    private boolean loginDialog()
    {
        int answer = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.printf("Utilizador Activo: %s\n\n", (isAuth ? activeUser.getEmail() : "Nenhum"));
        System.out.println("Escolha uma op??o: ");
        System.out.println("1 - Registar um novo Utilizador");
        System.out.println("2 - Autenticar um Utilizador");
        System.out.println("3 - Voltar ao Menu");
        System.out.println("0 - Sair");
        try {
            answer = input.read();
            input.read();/*Gooble up the \n*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(answer == 0)
        {
            System.out.println("Input Inv?lido.");
            return true;
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

            return false;
        }
        if(answer == '2')
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




        return true;

    }

    public boolean menuLoop()/*Returns whether app should terminate or not */
    {
        if(!isAuth)
        {
            if(!loginDialog())
                return true;
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

