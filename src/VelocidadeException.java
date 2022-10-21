public class VelocidadeException extends Exception {

    public VelocidadeException() {
        System.out.println("A velocidade máxima está fora dos limites brasileiros");
    }

    public String erroVeloc() {
        return "A velocidade deve ser entre 80km/h à 110km/h";
    }
}
