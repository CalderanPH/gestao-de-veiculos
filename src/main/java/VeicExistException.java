package main.java;

import java.lang.Exception;

public class VeicExistException extends Exception {

    public VeicExistException(){
        System.out.println("\nVeiculo já existente! ");
    }
    public String erroVeiculo(){
        return "\n Cadastro não realizado. \nJá tem um cadastrado com a mesma placa!";
    }

}
