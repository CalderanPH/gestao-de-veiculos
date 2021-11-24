import java.lang.Throwable;

public abstract class Veiculo {
        private String placa;
        private String marca;
        private String modelo;
        private String cor;
        private float velocMax;
        private int qtdRodas;
        private Motor motor;


        public Veiculo() {
                        this.placa = "";
                        this.marca = "";
                        this.modelo = "";
                        this.cor = "";
                        this.velocMax = 0;
                        this.qtdRodas = 0;
                        Motor motor = new Motor();
                                this.motor = motor;
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

        public float getVelocMax() {
                return velocMax;
        }

        public int getQtdRodas() {
                return qtdRodas;
        }

        final public void setQtdRodas(int qtdRodas) {
                this.qtdRodas = qtdRodas;
        }

        public Motor getMotor(){
                return this.motor;
        }

        public abstract void calcVel();

        final public void setVelocMax(float velocMax) throws VelocException{
                float velMax = 110.0f;
                float velMin = 80.0f;
                if(velocMax >= velMin && velocMax <= velMax){
                        this.velocMax = velocMax;
                } else throw new VelocException();
        }


}













