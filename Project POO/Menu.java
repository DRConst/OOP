
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
    private CacheStorage cacheStorage;
    private ReportDB reportDB;

    public Menu() {

        try {
            loginManager = (Login) Serializer.readObject(Login.class.getName());

        } catch (IOException e) {
            System.out.println("Logins Nao Encontrados");
            loginManager = new Login();
        } catch (ClassNotFoundException e) {/**/
            e.printStackTrace();
            loginManager = new Login();
        }

        activeUser = null;

        try {
            cacheStorage = (CacheStorage) Serializer.readObject(CacheStorage.class.getName());
        } catch (IOException e) {
            System.out.println("Caches Nao Encontradas");
            cacheStorage = new CacheStorage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            reportDB = (ReportDB) Serializer.readObject(ReportDB.class.getName());
        } catch (IOException e) {
            System.out.println("Reports Nao Encontrados");
            reportDB = new ReportDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void clearScreen() {
        /*try {
            if (System.getProperty("os.name").equals("Windows 8.1"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        }catch (IOException e)
        {
            e.printStackTrace();
        }*/
        for (int i = 0; i < 50; i++)
            System.out.println();/*Stupid and need to be replaced by smelting proper*/
    }

    private boolean loginDialog() {
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

        if (answer == '1') {
            String email, password, name, gender, adress, admin;
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
                System.out.print("Mes: ");
                month = sc.nextInt();
                System.out.print("Ano: ");
                year = sc.nextInt();
                DoB = new GregorianCalendar(year, month, day);
                loginManager.registerUser(email, password, name, gender, adress, DoB);
                activeUser = loginManager.authenticateUser(email, password);
                if (loginManager.getHashes().size() == 1 || (activeUser != null && activeUser.isAdmin())) {
                    System.out.println("Tornar Administrador? (y/n)");
                    admin = input.readLine();

                    if (admin.equals("y"))
                        activeUser.setAdmin(true);

                }
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (answer == '2') {
            String email, password;
            clearScreen();
            try {
                System.out.println("Insira o Email: ");
                email = input.readLine();
                System.out.println("Insira a Password: ");
                password = input.readLine();

                activeUser = loginManager.authenticateUser(email, password);
                if (activeUser != null) {
                    System.out.printf("Utilizador %s autenticado;\n" +
                            "\tNome: %s", activeUser.getEmail(), activeUser.getName());
                    return true;
                }
                else return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (answer == 3) {
            return false;
        } else
            System.out.println("Input Invalido.");

        return false;
    }

    private void listUsersActivities(User user) {
        TreeSet<Cache> activities;
        Cache c;
        int cnt = 0;
        Iterator<Cache> it;
        clearScreen();
        activities = user.getActivities();
        if (activities == null || activities.isEmpty()) {
            System.out.println("O utilizador nao tem actividades registadas");
        } else {
            it = activities.iterator();
            while (it.hasNext() && cnt++ < 10) {
                c = it.next();
                System.out.println(c.toString());/*Temp*/
            }
        }
    }

    private void listActivities() {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> friends;
        int input;
        int i;
        clearScreen();
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Ultimas Acividades do Proprio");
        System.out.println("2 - Ultimas Acividades de um Amigo");

        input = sc.nextInt();

        if (input == 1)
            listUsersActivities(activeUser);
        else if (input == 2) {
            friends = activeUser.getFriends();
            if (friends != null) {
                System.out.println("Escolha o amigo: ");
                for (i = 0; i < friends.size(); i++) {
                    System.out.printf("%d - %s, %s\n", i + 1, friends.get(i).getName(), friends.get(i).getEmail());
                }
                System.out.printf("%d - Sair\n", i + 1);
                input = sc.nextInt();
                if (input >= i + 1)
                    return;
                else {
                    listUsersActivities(friends.get(input - 1));
                }

            }
        }

    }

    private void registerDiscovery() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        System.out.println("Insira o Codigo da Cache: ");
        try {
            answer = input.readLine();
            if (cacheStorage.getCache(answer) == null) {
                System.out.println("Codigo Inexistente");
            } else {
                activeUser.addActivity(cacheStorage.getCache(answer));
                System.out.println("Descoberta Registada");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerCommun(Cache c)
    {

    }

    private void registerCache(){
        Scanner sc = new Scanner(System.in);
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String name, code, desc, line, hints;
        ArrayList<Treasure> treasures = new ArrayList<>();
        int day, month, year, isPhysical = 0;
        GregorianCalendar date;
        double lat, lon, tLat, tLon;
        Cache toRet = null;
        Difficulty d;
        int answer;
        int type;
        int numLocks;
        ArrayList<FlexLocation> fLocs = null;
        ArrayList<Location> locs = null;
        ArrayList<String> questions = null;
        String mainQuestion = null;
        HashMap<String, Register> regBook = new HashMap<>();
        clearScreen();
        try {

            System.out.println("Escolha o Tipo de Cache:");
            System.out.println("1 - Tradicional");
            System.out.println("2 - Multi");
            System.out.println("3 - Misterio");
            System.out.println("0 - Sair");

            type = sc.nextInt();


            System.out.println("Escolha o Tipo de Cache:");
            System.out.println("1 - Virtual");
            System.out.println("2 - Fisica");

            isPhysical = sc.nextInt();

            clearScreen();

            System.out.println("Detalhes:");
            System.out.println("Nome:");

            name = r.readLine();
            code = new StringBuilder().append(name.hashCode()).toString();

            System.out.println("Descricao ('END' Termina):");

            while (true) {
                line = r.readLine();
                if (line.equals("END"))
                    break;
                sb.append(line);
            }
            desc = sb.toString();

            sb.setLength(0);/*Clear Buffer*/

            System.out.println("Pistas ('END' Termina):");

            while (true) {
                line = r.readLine();
                if (line.equals("END"))
                    break;
                sb.append(line);
            }

            hints = sb.toString();
            sc.next();/*Clear the Buffer*/
            System.out.println("Latitude:");
            lat = sc.nextDouble();
            System.out.println("Longitude:");
            lon = sc.nextDouble();
            System.out.print("Dia: ");
            day = sc.nextInt();
            System.out.print("Mes: ");
            month = sc.nextInt();
            System.out.print("Ano: ");
            year = sc.nextInt();
            date = new GregorianCalendar(year, month, day);
            System.out.print("Dificuldade: ");

            System.out.print("1 - Facil: ");
            System.out.print("2 - Media: ");
            System.out.print("3 - Dificil: ");
            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    d = Difficulty.EASY;
                    break;
                case 2:
                    d = Difficulty.MEDIUM;
                    break;
                case 3:
                    d = Difficulty.HARD;
                    break;
                default:
                    System.out.println("Erro de Input, Cache nao registada");
                    return;
            }

            if (isPhysical == 2) {
                System.out.println("Tesouros ('END' Termina):");

                while (true) {
                    line = r.readLine();
                    if (line.equals("END"))
                        break;
                    treasures.add(new Treasure(line));
                }
            }

            if(type == 2)
            {
                System.out.println("Insira o Numero de Coordenadas Intermedias: ");
                numLocks = sc.nextInt();
                fLocs = new ArrayList<>(numLocks);

                for(int i = 0; i < numLocks; i++)
                {

                    System.out.println("Latitude: ");
                    tLat = sc.nextDouble();

                    System.out.println("Longitude: ");
                    tLon = sc.nextDouble();

                    fLocs.add(new FlexLocation(tLat, tLon, tLat, tLon));
                }

            }

            if(type == 3)
            {

                System.out.println("Insira a Pergunta: ");
                mainQuestion = r.readLine();


                System.out.println("Insira o Numero de Perguntas Secundarias: ");
                numLocks = sc.nextInt();
                locs = new ArrayList<>(numLocks);
                questions = new ArrayList<>(numLocks + 1);

                for(int i = 0; i < numLocks; i++)
                {
                    System.out.println("Pergunta: ");
                    questions.add(r.readLine());

                    System.out.println("Latitude: ");
                    tLat = sc.nextDouble();

                    System.out.println("Longitude: ");
                    tLon = sc.nextDouble();

                    locs.add(new Location(tLat, tLon));
                }

            }
            switch (type)
            {
                case 1:
                    toRet = (isPhysical == 1 ?
                            new TraditionalV(name, code, activeUser.getEmail(), desc, hints, regBook, lat, lon, date, d, "") :
                            new TraditionalP(name, code, activeUser.getEmail(), desc, hints, regBook, lat, lon, date, d, lat, lon, treasures) )                    ;
                    break;
                case 2:
                    toRet = new Multi(name,code, activeUser.getEmail(), desc, hints, regBook, lat, lon, date, d, lat, lon, treasures, fLocs);
                    break;
                case 3:
                    toRet = (isPhysical == 1 ?
                            new MysteryV(name, code, activeUser.getEmail(), desc, hints, regBook, lat,lon,date, d, mainQuestion, locs, questions) :
                            new MysteryP(name, code, activeUser.getEmail(), desc, hints, regBook, lat, lon, date, d, lat, lon, treasures, fLocs, questions));
                default:
                    return;
            }
            cacheStorage.saveCache(toRet);

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void reportCache() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        Report r;
        StringBuilder sb;
        Cache c;
        System.out.print("Insira o Codigo da Cache a Reportar: ");
        try {
            answer = input.readLine();
            System.out.println();
            if ((c = cacheStorage.getCache(answer)) == null) {
                System.out.println("Cache nao Existente");
                return;
            }
            if ((r = reportDB.getReport(answer)) != null) {
                System.out.println("Registo ja existente:");
                System.out.println(r.getDesc());
                System.out.println("Deseja Adicionar um Novo Registo? (y/n)");
                if (input.readLine().equals("y")) {
                    sb = new StringBuilder();
                    System.out.println("Insira a Descricao: (Escreva \"END\" para Terminar");
                    while ((answer = input.readLine()).equals("END")) {
                        sb.append(answer);
                    }
                    reportDB.addReport(c, sb.toString());
                }
            } else {
                sb = new StringBuilder();
                System.out.println("Insira a Descricao: (Escreva \"END\" para Terminar");
                while (!(answer = input.readLine()).equals("END")) {
                    sb.append(answer);
                }
                reportDB.addReport(c, sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro de IO");
        }

    }

    public void displayActivities(User u) {
        TreeSet<Cache> acts = u.getActivities();
        int cnt = 10;
        if (acts == null) {
            System.out.println("Nao Existem Actividades Registadas");
        } else {
            Iterator<Cache> it = acts.iterator();
            while (it.hasNext() && cnt-- > 0) {
                System.out.println(it.next().toString());/*TODO: Beautify*/
            }
        }
    }

    private void manageFriends() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String answer;
        User usr;
        System.out.println("Escolha uma Opcao: ");
        System.out.println("1 - Remover Amigo");
        System.out.println("2 - Adicionar Amigo");

        try {
            answer = input.readLine();
            if (answer.equals("1")) {
                System.out.println("Insira o Email do Amigo: ");
                answer = input.readLine();
                usr = activeUser.getFriend(answer);
                if (usr == null) {
                    System.out.println("Utilizador Nao Pertence a Lista de Amigos ");
                    return;
                } else if (activeUser.removeFriend(usr)) {
                    System.out.println("Amigo Apagado");
                    return;
                }
            }
            if (answer.equals("2")) {
                System.out.println("Insira o Email do Amigo: ");
                answer = input.readLine();
                usr = loginManager.getRegisteredUser(answer);
                if (usr == null) {
                    System.out.println("Utilizador Nao Existe");
                    return;
                } else activeUser.addFriend(usr);/*TODO: Force A Need For Requests??*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void listReports() {
        int cnt = 0;
        Scanner sc = new Scanner(System.in);
        int input;
        Iterator<Report> it = reportDB.getReports().values().iterator();
        clearScreen();
        while (cnt < 10 && it.hasNext()) {
            System.out.println(it.next().toString());
            if (++cnt == 10) {
                System.out.println("Escolha uma Opcao: ");
                System.out.println("1 - Listar Mais Relatorios");
                System.out.println("0 - Sair");

                input = sc.nextInt();

                switch (input) {
                    case 0:
                        return;
                    case 1:
                        clearScreen();
                        return;
                }
            }
        }
        System.out.println("Escolha uma opcao: ");
        System.out.println("0 - Sair");

        sc.nextInt();
    }

    private void manageReport() {

    }

    public void manageReports() {
        Scanner sc = new Scanner(System.in);
        int input;
        int cnt;
        if (!activeUser.isAdmin())
            return;
        cnt = reportDB.getReportCount();
        System.out.println("Existem " + cnt + " Relatorios");

        System.out.println("Escolha uma opcao: ");
        if (cnt > 0) {
            System.out.println("1 - Listar Relatorios");
            System.out.println("2 - Gerir Relatorio");
        }
        System.out.println("0 - Sair");
        input = sc.nextInt();

        switch (input) {

            case 0:
                return;
            case 1:
                if (cnt > 0)
                    listReports();
                break;
            case 2:
                if (cnt > 0)
                    manageReport();
                break;

            default:
                break;

        }

    }

    public boolean menuLoop()/*Returns whether app should continue or not */ {
        Scanner sc = new Scanner(System.in);
        int input;
        if (activeUser == null && !isAuth) {
            System.out.println("Nenhum Utilizador Activo, deseja fazer login/registar (1) ou sair (2) : ");
            input = sc.nextInt();
            if (input == 1)
                while(!loginDialog());
            else return input != 2;
        }

        clearScreen();
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Visualizar Ultimas Acividades");
        System.out.println("2 - Registar Uma Nova Cache");/*TODO*/
        System.out.println("3 - Registar Descoberta de uma Cache");
        System.out.println("4 - Invalidar uma Cache");/*TODO*/
        System.out.println("5 - Reportar uma Cache");
        System.out.println("6 - Consultar Actividades de Descoberta");
        System.out.println("7 - Consultar Estatisticas");
        System.out.println("8 - Gerir Amigos");

        if (activeUser.isAdmin())
            System.out.println("9 - Gerir Reports");

        System.out.println("0 - Sair");
        input = sc.nextInt();

        switch (input) {
            case 1:
                listActivities();
                break;
            case 2:
                registerCache();
                break;
            case 3:
                registerDiscovery();
                break;
            case 4:
                break;
            case 5:
                reportCache();
                break;
            case 6:
                displayActivities(activeUser);
                break;
            case 7:
                break;
            case 8:
                manageFriends();
                break;
            case 9:
                manageReports();
                break;

            default:
                return false;
        }

        return true;
    }

    public void saveState() throws IOException {

        Serializer.writeObject(this.loginManager);
        Serializer.writeObject(this.cacheStorage);
        Serializer.writeObject(this.reportDB);
    }
}

