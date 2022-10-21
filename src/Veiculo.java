public abstract class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocidadeMaxima;
    private int quandidadeRodas;
    private final Motor motor;

    public Veiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.cor = "";
        this.velocidadeMaxima = 0;
        this.quandidadeRodas = 0;
        Motor motor = new Motor();
        this.motor = motor;
    }

    public abstract void calcularVelocidade();

    final public void setVelocidadeMaxima(float velocidadeMaxima) throws VelocidadeException {
        float velMax = 110.0f;
        float velMin = 80.0f;
        if (velocidadeMaxima >= velMin && velocidadeMaxima <= velMax) {
            this.velocidadeMaxima = velocidadeMaxima;
        } else throw new VelocidadeException();
    }

    public Motor getMotor() {
        return this.motor;
    }


    public String getPlaca() {
        return placa;
    }

    final public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    final public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    final public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    final public void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public int getQuantidadeRodas() {
        return quandidadeRodas;
    }

    final public void setQuantidadeRodas(int qtdRodas) {
        this.quandidadeRodas = qtdRodas;
    }

}