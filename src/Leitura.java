import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

    public String entradaDados(String rotulo) {

        System.out.println(rotulo);
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(teclado);

        String ret = "";

        try {
            ret = buff.readLine();
        } catch (IOException ioe) {
            System.out.println("\n Erro de Sistema");
        }
        return ret;
    }

}