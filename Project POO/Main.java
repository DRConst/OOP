import java.io.IOException;

/**
 * Created by Diogo on 26/05/2015.
 */
public class Main {


    public static void main(String[] args) {
        Menu menu = new Menu();

        while (menu.menuLoop()) {

        }

        try {
            menu.saveState();
        } catch (IOException e) {
            System.out.println("Erro na Gravação de Estado");
        }
    }
}
