public class Main {

    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static final BDVeiculos bdVeiculos = new BDVeiculos();
    private static final Leitura leitura = new Leitura();

    public static void main(String[] args) throws Exception {

        boolean continua = true;
        int opcao;

        while (continua) {
            System.out.println("\n ===================SISTEM DE GESTÃO DE VEÍCULOS - MENU PRINCIPAL ================\n");
            System.out.println("   |-------------------------------------------|");
            System.out.println("   | 1. Cadastrar Veículo de Passeio           |");
            System.out.println("   | 2. Cadastrar Veículo de Carga             |");
            System.out.println("   | 3. Imprimir todos os Veículos de Passeio  |");
            System.out.println("   | 4. Imprimir todos os Veículos de Carga    |");
            System.out.println("   | 5. Imprimir Veículo de Passeio pela Placa |");
            System.out.println("   | 6. Imprimir Veículo de Carga pela Placa   |");
            System.out.println("   | 7. Excluir Veículo de Passeio pela Placa  |");
            System.out.println("   | 8. Excluir Veículo de Carga pela Placa    |");
            System.out.println("   | 9. Sair do Sistema                        |");
            System.out.println("   |-------------------------------------------|");
            System.out.println("\n Digite o número de uma opção! \n ");

            try {
                opcao = Integer.parseInt(leitura.entradaDados("Digite o número da opção desejada!"));
            } catch (NumberFormatException nfe) {
                System.out.println("Deve ser um número inteiro - PRESS -> ENTER <- para recomeçar");
                leitura.entradaDados("");
                continue;
            }

            switch (opcao) {
                //Cadastrar Veículo de Passeio
                case 1:
                    try {
                        passeio = bdVeiculos.cadastroPasseio(passeio);
                        if (passeio != null) {
                            leitura.entradaDados("Veículo cadastrado com sucesso - PRESS -> ENTER <-");
                        } else {
                            throw new VeiculoExistenteException();
                        }
                    } catch (NumberFormatException nfe1) {
                        leitura.entradaDados("\n A quantidade de passageiros deve ser um número inteiro! \n Tente novamente!");
                    } catch (VeiculoExistenteException vee) {
                        leitura.entradaDados(vee.erroVeiculo() + "- PRESS - -> ENTER <- para recomeçar!");
                    } catch (Exception e) {
                        System.out.println("Erro inesperado tente novamente!");
                    }
                    break;
                //Cadastrar Veículo de Carga
                case 2:
                    try {
                        carga = bdVeiculos.cadastroCarga(carga);
                        if (passeio != null) {
                            leitura.entradaDados("Veículo cadastrado com sucesso - PRESS -> ENTER <-");
                        } else {
                            throw new VeiculoExistenteException();
                        }
                    } catch (VeiculoExistenteException vee) {
                        leitura.entradaDados(vee.erroVeiculo() + "- PRESS - -> ENTER <- para recomeçar!");
                    } catch (Exception e) {
                        System.out.println("Erro inesperado tente novamente!");
                    }
                    break;
                //Imprime Passeio
                case 3:
                    System.out.println("\n Passeio - Impressão de todos veiculos");
                    for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++) {
                        if (bdVeiculos.getListaPasseio().get(i) != null) {
                            bdVeiculos.imprimirPasseio(bdVeiculos.getListaPasseio().get(i), i);
                        } else {
                            leitura.entradaDados("\n Sem mais Veículos de Passeio para imprimir - PRESS -> ENTER <-");
                            break;
                        }
                    }
                    break;
                //impressão-carga
                case 4:
                    System.out.println("Carga - impressão de todos veículos de carga");
                    for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++) {
                        if (bdVeiculos.getListaCarga().get(i) != null) {
                            bdVeiculos.imprimirCarga(bdVeiculos.getListaCarga().get(i), i);
                        } else {
                            leitura.entradaDados("Sem mais veículos de carga para imprimir - PRESS -> ENTER <-");
                            break;
                        }
                    }
                    break;
                //consulta-passeio
                case 5:
                    System.out.println("Consulta pela Placa - veiculos Passeio");
                    passeio = new Passeio();
                    boolean existePlacaPasseio = false;
                    String placaPasseio = leitura.entradaDados("Informe a placa a ser pesquisada: ");
                    passeio.setPlaca(placaPasseio);
                    for (int i = 0; i < bdVeiculos.getListaPasseio().size(); i++) {
                        try {
                            if (bdVeiculos.getListaPasseio().get(i).getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                                bdVeiculos.imprimirPasseio(bdVeiculos.getListaPasseio().get(i), i);
                                existePlacaPasseio = true;
                            }
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                    }
                    if (!existePlacaPasseio) {
                        leitura.entradaDados("Não existe veiculo de Passeio com está Placa -PRESS -> ENTER <- para recomeçar! ");
                    }
                    break;
                //consulta-carga
                case 6:
                    System.out.println("Consulta pela Placa do veículo de Carga");
                    carga = new Carga();
                    boolean existePlacaCarga = false;
                    String placaCarga = leitura.entradaDados("Informe a placa à ser pesquisada");
                    carga.setPlaca(placaCarga);
                    for (int i = 0; i < bdVeiculos.getListaCarga().size(); i++) {
                        try {
                            if (bdVeiculos.getListaCarga().get(i).getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                                bdVeiculos.imprimirCarga(bdVeiculos.getListaCarga().get(i), i);
                                existePlacaCarga = true;
                            }
                        } catch (NullPointerException npe) {
                            npe.printStackTrace();
                        }
                    }
                    if (!existePlacaCarga) {
                        leitura.entradaDados("Não existe veiculo de Carga com esta Placa - PRESS -> ENTER <-");
                    }
                    break;
                //encerra sistema
                case 7:
                    System.out.println("Exclui veículo de passeio pela placa");
                    passeio = new Passeio();
                    passeio.setPlaca(leitura.entradaDados("Informe a placa do veículo a ser removido!"));
                    passeio = bdVeiculos.consultaPasseio(passeio);
                    if (passeio != null) {
                        bdVeiculos.removePasseio(passeio);
                        leitura.entradaDados("Veículo deletado com sucesso! - PRESS -> ENTER <-");
                    } else {
                        leitura.entradaDados("Não existe veículo com está placa! Press --> ENTER <--");
                    }
                    break;
                case 8:
                    System.out.println("Exclui veículo de carga pela placa");
                    carga = new Carga();
                    carga.setPlaca(leitura.entradaDados("Informe a placa do veículo a ser removido!"));
                    carga = bdVeiculos.consultaCarga(carga);
                    if (carga != null) {
                        bdVeiculos.removeCarga(carga);
                        leitura.entradaDados("Veículo deletado com sucesso! - PRESS -> ENTER <-");
                    } else {
                        leitura.entradaDados("Não existe veículo com está placa! Press --> ENTER <--");
                    }
                    break;
                case 9:
                    continua = false;
                    break;

                default:
                    leitura.entradaDados("O valor deve ser de 1 ao 9 - PRESS -> ENTER <-");
                    break;
            }
        }
    }

}