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
        this.motor = new Motor();
    }

    public abstract void calcularVelocidade();

    final public void setVelocidadeMaxima(float velocidadeMaxima) throws VelocidadeException {
        float velocidadeMax = 110.0f;
        float velocidadeMin = 80.0f;
        if (velocidadeMaxima >= velocidadeMin && velocidadeMaxima <= velocidadeMax) {
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

    final public void setQuantidadeRodas(int quantidadeRodas) {
        this.quandidadeRodas = quantidadeRodas;
    }

}