package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;

public class Leitura {

    public String entDados(String rotulo) {

        System.out.println(rotulo);
        InputStreamReader tec = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(tec);

        String ret = "";

        try {
            ret = buff.readLine();
        }
        catch (IOException ioe){
            System.out.println("\n Erro de Sistema");
        }
        return ret;
    }
}
