

public final class Carga extends Veiculo implements Calc {
    private int cargaMax;
    private int tara;

    public Carga(){
        this.cargaMax = 0;
        this.tara = 0;
    }

    public void calcVel() {
        float x = (getVelocMax()*10000);
        System.out.println("\n Velocidade do veículo de Carga: "+ x + "cm/h");
    }


    public int calcular(){
        int somaNum = 0;

        somaNum += getMotor().getQtdPist();
        somaNum += getMotor().getPontencia();
        somaNum += getQtdRodas();
        somaNum += getVelocMax();
        somaNum += getTara();
        somaNum += getCargaMax();

        return somaNum;
    }
    public int getCargaMax(){
        return cargaMax;
    }
    public int getTara(){
        return tara;
    }

    public void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }
    public void setTara(int tara){
        this.tara = tara;
    }


}
