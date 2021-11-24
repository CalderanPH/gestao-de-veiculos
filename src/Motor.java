public class Motor {
    private int qtdPist;
    private int pontencia;

    public Motor() {
        this.qtdPist = 0;
        this.pontencia = 0;
    }

    public int getQtdPist(){
        return qtdPist;
    }
    final public void setQtdPist(int qtdPist){
        this.qtdPist = qtdPist;
    }

    public int getPontencia(){
        return pontencia;
    }
    final public void setPontencia(int pontencia){
        this.pontencia = pontencia;
    }

}

