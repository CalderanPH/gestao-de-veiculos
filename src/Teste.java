//import java.lang.NumberFormatException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class Teste {
//    private static Passeio passeio = new Passeio();
//    private static Carga carga = new Carga();
//    private static BDVeiculos bdVeiculos = new BDVeiculos();
//    private static Leitura l = new Leitura();
//
//
//    public static void main(String[] args) {
//
//
//
//        boolean continua = true;
//        int opcao = 0;
//
//        while (continua){
//            System.out.println("\n ===================SISTEM DE GESTÃO DE VEÍCULOS - MENU PRINCIPAL ================\n");
//            System.out.println("   |-------------------------------------------|");
//            System.out.println("   | 1. Cadastrar Veículo de Passeio           |");
//            System.out.println("   | 2. Cadastrar Veículo de Carga             |");
//            System.out.println("   | 3. Imprimir todos os Veículos de Passeio  |");
//            System.out.println("   | 4. Imprimir todos os Veículos de Carga    |");
//            System.out.println("   | 5. Imprimir Veículo de Passeio pela Placa |");
//            System.out.println("   | 6. Imprimir Veículo de Carga pela Placa   |");
//            System.out.println("   | 7. Excluir Veículo de Passeio pela Placa  |");
//            System.out.println("   | 8. Excluir Veículo de Carga pela Placa    |");
//            System.out.println("   | 9. Sair do Sistema                        |");
//            System.out.println("   |-------------------------------------------|");
//            System.out.println("\n Digite o número de uma opção! \n ");
//
//
//            try {
//                opcao = Integer.parseInt(l.entDados("Digite o número da opção desejada!"));
//            }
//            catch (NumberFormatException nfe) {
//                System.out.println("Deve ser um número inteiro - PRESS -> ENTER <- para recomeçar");
//                l.entDados("");
//
//                continue;
//            }
//
//            switch (opcao){
//                //Cadastrar Veículo de Passeio
//                case 1:
//                    try {
//                         passeio = new Passeio();
//                         passeio = bdVeiculos.cadPasseio(passeio);
//                         if(passeio != null){
//                             l.entDados("Veículo cadastrado com sucesso - PRESS -> ENTER <-");
//                         }
//                        else {
//                             l.entDados("Já existe um veículo com está placa - PRESS -> ENTER <-");
//                             break;
//                        }
//                    }catch (NumberFormatException nfe1) {
//                            l.entDados("\n A quantidade de passageiros deve ser um número inteiro! \n Tente novamente!");
//                    }catch (NullPointerException n){
//                        System.out.println("Erro inesperado tente novamente!");
//                    }catch (VeicExistException vee) {
//                        l.entDados(vee.erroVeiculo() + "- PRESS - -> ENTER <- para recomeçar!");
//                    }
//                    break;
//
//                    //Cadastrar Veículo de Carga
//                case 2:
//                    try {
//                        carga = new Carga();
//                        carga = bdVeiculos.cadCarga(carga);
//                        if(passeio != null){
//                            l.entDados("Veículo cadastrado com sucesso - PRESS -> ENTER <-");
//                        } else {
//                            l.entDados("Já existe um veículo com está placa - PRESS -> ENTER <-");
//                            break;
//                        }
//                    } catch (NullPointerException n){
//                        System.out.println("Erro inesperado tente novamente!");
//                    }catch (VeicExistException vee) {
//                        System.out.println(vee.erroVeiculo() + "- PRESS - -> ENTER <- para recomeçar!");
//                    }
//                    break;
//                    //impressão-PASSEIO
//                case 3:
//                    System.out.println("\n Passeio - Impressão de todos veiculos");
//                    for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++){
//                        if(bdVeiculos.getListaPasseio().get(i) != null){
//                            bdVeiculos.impPasseio(bdVeiculos.getListaPasseio().get(i), i);
//                        }
//                        else {
//                            l.entDados("\n Sem mais Veículos de Passeio para imprimir - PRESS -> ENTER <-");
//                            break;
//                        }
//                    }
//                    break;
//                    //impressão-carga
//                case 4:
//                    System.out.println("Carga - impressão de todos veículos de carga");
//                    for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++){
//                        if(bdVeiculos.getListaCarga().get(i) != null){
//                            bdVeiculos.impCarga(bdVeiculos.getListaCarga().get(i), i);
//                    }
//                        else{
//                            l.entDados("Sem mais veículos de carga para imprimir - PRESS -> ENTER <-");
//                            break;
//                    }
//                }break;
//                //consulta-passeio
//                case 5:
//                    System.out.println("Consulta pela Placa - veiculos Passeio");
//                    passeio = new Passeio();
//                    boolean existPlacaPass = false;
//                    String placaPass = l.entDados("Informe a placa a ser pesquisada: ");
//                    passeio.setPlaca(placaPass);
//                    for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++){
//                        try {
//                            if (bdVeiculos.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
//                                bdVeiculos.impPasseio(bdVeiculos.getListaPasseio().get(i), i);
//                                existPlacaPass = true;
//                            }
//                        }
//                        catch (NullPointerException npe){
//                        }
//                    }
//                    if(!existPlacaPass){
//                        l.entDados("Não existe veiculo de Passeio com está Placa -PRESS -> ENTER <- para recomeçar! ");
//                    }break;
//                //consulta-carga
//                case 6:
//                    System.out.println("Consulta pela Placa do veículo de Carga");
//                    carga = new Carga();
//                    boolean existPlacaCarg = false;
//                    String placaCarg = l.entDados("Informe a placa à ser pesquisada");
//                    carga.setPlaca(placaCarg);
//                    for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++){
//                        try {
//                            if (bdVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())) {
//                                bdVeiculos.impCarga(bdVeiculos.getListaCarga().get(i), i);
//                                existPlacaCarg = true;
//                            }
//                        }
//                        catch (NullPointerException npe){
//                        }
//                    }
//                    if(!existPlacaCarg){
//                        l.entDados("Não existe veiculo de Carga com esta Placa - PRESS -> ENTER <-");
//                    }
//                    break;
//                    //encerra sistema
//                case 7:
//                    System.out.println("Exclui veículo de passeio pela placa");
//                    passeio = new Passeio();
//                    passeio.setPlaca(l.entDados("Informe a placa do veículo a ser removido!"));
//                    passeio = bdVeiculos.consPasseio(passeio);
//                    if(passeio != null){
//                        bdVeiculos.removePasseio(passeio);
//                        l.entDados("Veículo deletado com sucesso! - PRESS -> ENTER <-");
//                    }
//                    else {
//                        l.entDados("Não existe veículo com está placa! Press --> ENTER <--");
//                    }
//                    break;
//                case 8:
//                    System.out.println("Exclui veículo de carga pela placa");
//                    carga = new Carga();
//                    carga.setPlaca(l.entDados("Informe a placa do veículo a ser removido!"));
//                    carga = bdVeiculos.consCarga(carga);
//                    if(carga != null){
//                        bdVeiculos.removeCarga(carga);
//                        l.entDados("Veículo deletado com sucesso! - PRESS -> ENTER <-");
//                    }
//                    else {
//                        l.entDados("Não existe veículo com está placa! Press --> ENTER <--");
//                    }
//                    break;
//                case 9:
//                    continua = false;
//                    break;
//
//                default:
//                    l.entDados("O valor deve ser de 1 ao 9 - PRESS -> ENTER <-");
//                    break;
//            }
//        }
//    }
//
//
//}