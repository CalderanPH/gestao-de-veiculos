public class VeiculoExistenteException extends Exception {

    public VeiculoExistenteException() {
        System.out.println("\nVeiculo já existente! ");
    }

    public String erroVeiculo() {
        return "\n Cadastro não realizado. \nJá tem um cadastrado com a mesma placa!";
    }

}