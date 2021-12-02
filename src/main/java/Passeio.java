package main.java;

public final class Passeio extends Veiculo implements Calc{
    private int qtdPassageiros;

    Passeio(){
        this.qtdPassageiros = 0;
    }

    public int getQtdPassageiros(){
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros){
        this.qtdPassageiros =  qtdPassageiros;
    }



    public void calcVel() {
       float x = (getVelocMax()*1000);
        System.out.println("\n Velocidade do veículo de passeio: "+ x + "m/h");
    }

    public int calcular(){
        int somaLetras = 0;

        somaLetras += getPlaca().length();
        somaLetras += getMarca().length();
        somaLetras += getModelo().length();
        somaLetras += getCor().length();

        return somaLetras;
    }
}
