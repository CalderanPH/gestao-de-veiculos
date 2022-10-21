public class Motor {

    private int quantidadePistao;
    private int pontencia;

    public Motor() {
        this.quantidadePistao = 0;
        this.pontencia = 0;
    }

    public int getQuantidadePistao() {
        return quantidadePistao;
    }

    final public void setQuantidadePistao(int quantidadePistao) {
        this.quantidadePistao = quantidadePistao;
    }

    public int getPontencia() {
        return pontencia;
    }

    final public void setPontencia(int pontencia) {
        this.pontencia = pontencia;
    }

}