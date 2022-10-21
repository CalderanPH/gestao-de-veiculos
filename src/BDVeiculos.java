import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    private final List<Passeio> listaPasseio = new ArrayList<>();
    private final List<Carga> listaCarga = new ArrayList<>();

    private final Leitura leitura = new Leitura();

    public BDVeiculos() {
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void removePasseio(Passeio passeio) {
        listaPasseio.remove(passeio);
    }

    public void removeCarga(Carga carga) {
        listaCarga.remove(carga);
    }

    public Passeio consultaPasseio(Passeio passeio) {
        try {
            for (int i = 0; i < listaPasseio.size(); i++) {
                if (passeio.getPlaca().equalsIgnoreCase(listaPasseio.get(i).getPlaca())) {
                    return listaPasseio.get(i);
                }
            }
        } catch (NullPointerException n) {

        }
        return null;
    }

    public Carga consultaCarga(Carga carga) {
        try {
            for (int i = 0; i < listaCarga.size(); i++) {
                if (carga.getPlaca().equalsIgnoreCase(listaCarga.get(i).getPlaca())) {
                    return listaCarga.get(i);
                }
            }
        } catch (NullPointerException ne) {

        }
        return null;
    }

    public Passeio cadastroPasseio(Passeio passeio) throws VeiculoExistenteException {
        System.out.println("Cadastro de Veículos de Passeio");
        passeio.setModelo(leitura.entradaDados("Informe o Modelo do Veiculo...: "));
        passeio.setCor(leitura.entradaDados("Informe a cor do Veículo...: "));
        passeio.setMarca(leitura.entradaDados("Informe a Marca do Veiculo...: "));
        passeio.setQuantidadePassageiros(Integer.parseInt(leitura.entradaDados("Informe a quantidade de Passageiros...:")));
        passeio.setQuantidadeRodas(Integer.parseInt(leitura.entradaDados("Informe a quantidade de rodas...:")));
        passeio.setPlaca(leitura.entradaDados("Informe a Placa do Veículo...: "));
        passeio.getMotor().setQuantidadePistao(Integer.parseInt(leitura.entradaDados("Informe a quantidade de pistões...: ")));
        passeio.getMotor().setPontencia(Integer.parseInt(leitura.entradaDados("Informe a potencia do veículo...: ")));
        try {
            passeio.setVelocidadeMaxima(Integer.parseInt(leitura.entradaDados("Informe a velocidade máxima...:")));
        } catch (VelocidadeException v) {
            System.out.println(v.erroVeloc());
        }

        if (consultaPasseio(passeio) == null) {
            listaPasseio.add(passeio);
            return passeio;
        } else throw new VeiculoExistenteException();
    }

    public Carga cadastroCarga(Carga carga) throws VeiculoExistenteException {
        System.out.println("Cadastro de Veículos de Passeio");
        carga.setModelo(leitura.entradaDados("Informe o Modelo do Veiculo...: "));
        carga.setCor(leitura.entradaDados("Informe a cor do Veículo...: "));
        carga.setMarca(leitura.entradaDados("Informe a Marca do Veiculo...: "));
        carga.setQuantidadeRodas(Integer.parseInt(leitura.entradaDados("Informe a quantidade de rodas...:")));
        carga.setPlaca(leitura.entradaDados("Informe a Placa do Veículo...: "));
        carga.getMotor().setQuantidadePistao(Integer.parseInt(leitura.entradaDados("Informe a quantidade de pistões...: ")));
        carga.getMotor().setPontencia(Integer.parseInt(leitura.entradaDados("Informe a potencia do veículo...: ")));
        carga.setTara(Integer.parseInt(leitura.entradaDados("Informe a Tara do veículo...:")));
        carga.setCargaMaxima(Integer.parseInt(leitura.entradaDados("Informe a Carga máxima do veículo...:")));
        try {
            carga.setVelocidadeMaxima(Integer.parseInt(leitura.entradaDados("Informe a velocidade máxima...:")));
        } catch (VelocidadeException v) {
        }
        if (consultaCarga(carga) == null) {
            listaCarga.add(carga);
            return carga;
        } else throw new VeiculoExistenteException();

    }

    public void imprimirPasseio(Passeio passeio, int i) {
        System.out.println("Passeio amazenado no endereço....: " + i + "(do vetor vet Passeio)");
        System.out.println("Quantidade de Passageiros.....: " + passeio.getQuantidadePassageiros());
        System.out.println("Placa...:" + passeio.getPlaca());
        System.out.println("Marca...:  " + passeio.getMarca());
        System.out.println("Modelo...: " + passeio.getModelo());
        System.out.println("Cor...: " + passeio.getCor());
        System.out.println("Quantidade de Rodas...: " + passeio.getQuantidadeRodas());
        System.out.println("Velocidade máxima...:" + passeio.getVelocidadeMaxima());
        System.out.println("Quantidade de Pistoes do motor...: " + passeio.getMotor().getQuantidadePistao());
        System.out.println("Potencia do motor...: " + passeio.getMotor().getPontencia());
        System.out.println("Quantidade total de Letras...: " + passeio.calcular());
        passeio.calcularVelocidade();
    }

    public void imprimirCarga(Carga carga, int i) {
        System.out.println("Passeio amazenado no endereço....: " + i + "(do vetor vet Carga)");
        System.out.println("Placa...:" + carga.getPlaca());
        System.out.println("Marca...:  " + carga.getMarca());
        System.out.println("Modelo...: " + carga.getModelo());
        System.out.println("Cor...: " + carga.getCor());
        System.out.println("Quantidade de Rodas...: " + carga.getQuantidadeRodas());
        System.out.println("Velocidade máxima...:" + carga.getVelocidadeMaxima());
        System.out.println("Quantidade de Pistoes do motor...: " + carga.getMotor().getQuantidadePistao());
        System.out.println("Potencia do motor...: " + carga.getMotor().getPontencia());
        System.out.println("A tara...: " + carga.getTara());
        System.out.println("A carga Máxima...: " + carga.getCargaMaxima());
        System.out.println("Quantidade total de Letras...: " + carga.calcular());
        carga.calcularVelocidade();
    }

}