package main.java;
import java.util.ArrayList;
import java.util.List;



public class BDVeiculos {

    private List<Passeio> listaPasseio = new ArrayList<Passeio>();
    private List<Carga>  listaCarga = new ArrayList<Carga>();



    private Passeio passeio = new Passeio();
    private Carga carga = new Carga();
    private Leitura l = new Leitura();

    public BDVeiculos() {

    }




    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

//    public void setListaPasseio(Passeio listaPasseio) {
//        this.listaPasseio = listaPasseio;
//    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

//    public void setListaCarga(Carga listaCarga) {
//        this.listaCarga = listaCarga;
//    }

    public void removePasseio(Passeio passeio){
        passeio = consPasseio(passeio);
        if(passeio != null){
            listaPasseio.remove(passeio);
        }
    }

    public void removeCarga(Carga carga){
        carga = consCarga(carga);
        if(carga != null) {
            listaCarga.remove(carga);
        }
    }



    public Passeio consPasseio(Passeio passeio) {
       try {
           for (int i = 0; i < listaPasseio.size(); i++) {
               if (passeio.getPlaca().equalsIgnoreCase(listaPasseio.get(i).getPlaca())){
                    return listaPasseio.get(i);
               }
           }
       }catch (NullPointerException n){

       }return null;
    }

    public Carga consCarga(Carga carga){
        try {
            for (int i = 0; i < listaCarga.size(); i++) {
                if (carga.getPlaca().equalsIgnoreCase(listaCarga.get(i).getPlaca())) {
                    return listaCarga.get(i);
                }
            }
        }catch (NullPointerException ne){

        }return null;
    }


    public Passeio cadPasseio (Passeio passeio) throws VeicExistException {
        if (consPasseio(passeio) == null){
            listaPasseio.add(passeio);
             return passeio;
         }
         else throw new VeicExistException();
    }


    public Carga cadCarga(Carga carga) throws VeicExistException{
        System.out.println("Cadastro de Veículos de Passeio");
        carga.setModelo(l.entDados("Informe o Modelo do Veiculo...: "));
        carga.setCor(l.entDados("Informe a cor do Veículo...: "));
        carga.setMarca(l.entDados("Informe a Marca do Veiculo...: "));
        carga.setQtdRodas(Integer.parseInt(l.entDados("Informe a quantidade de rodas...:")));
        carga.setPlaca(l.entDados("Informe a Placa do Veículo...: "));
        carga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Informe a quantidade de pistões...: ")));
        carga.getMotor().setPontencia(Integer.parseInt(l.entDados("Informe a potencia do veículo...: ")));
        carga.setTara(Integer.parseInt(l.entDados("Informe a Tara do veículo...:")));
        carga.setCargaMax(Integer.parseInt(l.entDados("Informe a Carga máxima do veículo...:")));
        try{
            carga.setVelocMax(Integer.parseInt(l.entDados("Informe a velocidade máxima...:")));
        } catch (VelocException v){
        }
        if (consCarga(carga) == null){
            listaCarga.add(carga);
            return carga;
        }
        else throw new VeicExistException();

    }

    public void impPasseio(Passeio passeio, int i){
        System.out.println("Passeio amazenado no endereço....: " + i+ "(do vetor vet Passeio)");
        System.out.println("Quantidade de Passageiros.....: " + passeio.getQtdPassageiros());
        System.out.println("Placa...:" + passeio.getPlaca());
        System.out.println("Marca...:  " +passeio.getMarca());
        System.out.println("Modelo...: " + passeio.getModelo());
        System.out.println("Cor...: " + passeio.getCor());
        System.out.println("Quantidade de Rodas...: "+passeio.getQtdRodas());
        System.out.println("Velocidade máxima...:" + passeio.getVelocMax());
        System.out.println("Quantidade de Pistoes do motor...: "+passeio.getMotor().getQtdPist());
        System.out.println("Potencia do motor...: "+ passeio.getMotor().getPontencia());
        System.out.println("Quantidade total de Letras...: "+ passeio.calcular());
        passeio.calcVel();
    }

    public void impCarga(Carga carga, int i){
        System.out.println("Passeio amazenado no endereço....: " + i+ "(do vetor vet Carga)");
        System.out.println("Placa...:" + carga.getPlaca());
        System.out.println("Marca...:  " +carga.getMarca());
        System.out.println("Modelo...: " + carga.getModelo());
        System.out.println("Cor...: " + carga.getCor());
        System.out.println("Quantidade de Rodas...: "+carga.getQtdRodas());
        System.out.println("Velocidade máxima...:" + carga.getVelocMax());
        System.out.println("Quantidade de Pistoes do motor...: "+carga.getMotor().getQtdPist());
        System.out.println("Potencia do motor...: "+ carga.getMotor().getPontencia());
        System.out.println("A tara...: "+ carga.getTara());
        System.out.println("A carga Máxima...: "+carga.getCargaMax());
        System.out.println("Quantidade total de Letras...: "+ carga.calcular());
        passeio.calcVel();
    }










}
