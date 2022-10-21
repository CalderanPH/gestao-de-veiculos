public final class Carga extends Veiculo implements Calcular {

    private int cargaMaxima;
    private int tara;

    public Carga() {
        this.cargaMaxima = 0;
        this.tara = 0;
    }

    public void calcularVelocidade() {
        float x = (getVelocidadeMaxima() * 10000);
        System.out.println("\n Velocidade do veículo de Carga: " + x + "cm/h");
    }

    public int calcular() {
        int somarNumero = 0;

        somarNumero += getMotor().getQuantidadePistao();
        somarNumero += getMotor().getPontencia();
        somarNumero += getQuantidadeRodas();
        somarNumero += getVelocidadeMaxima();
        somarNumero += getTara();
        somarNumero += getCargaMaxima();

        return somarNumero;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public int getTara() {
        return tara;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

}