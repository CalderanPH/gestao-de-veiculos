public final class Passeio extends Veiculo implements Calcular {

    private int quantidadePassageiros;

    Passeio() {
        this.quantidadePassageiros = 0;
    }

    public void calcularVelocidade() {
        float x = (getVelocidadeMaxima() * 1000);
        System.out.println("\n Velocidade do veículo de passeio: " + x + "m/h");
    }

    public int calcular() {
        int somarLetras = 0;

        somarLetras += getPlaca().length();
        somarLetras += getMarca().length();
        somarLetras += getModelo().length();
        somarLetras += getCor().length();

        return somarLetras;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int qtdPassageiros) {
        this.quantidadePassageiros = qtdPassageiros;
    }

}