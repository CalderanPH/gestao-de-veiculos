package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImprimirExcluir extends javax.swing.JFrame{
    private JPanel painel;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton btImprimir;
    private JButton btExcluir;
    private JButton btSair;

    private Passeio passeio = new Passeio();
    private BDVeiculos bdVeiculos = new BDVeiculos();

    String header[] = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Velocidade Máxima", "Qtd. Pistão", "Potência", "Qtd. Passageiros"};

    private void createUIComponents() {
         DefaultTableModel modelo = new DefaultTableModel(0,9);
         modelo.setColumnIdentifiers(header);
         modelo.setRowCount(0);
         int posLin = 0;

         for (Passeio passeio : bdVeiculos.getListaPasseio()) {
             modelo.insertRow(posLin, new Object[]{passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(), passeio.getQtdRodas(), passeio.getVelocMax(), passeio.getMotor().getQtdPist(), passeio.getMotor().getPontencia(), passeio.getQtdPassageiros()});
             posLin++;
         }
    }


    public ImprimirExcluir(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(painel);
        this.pack();

        btImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUIComponents();
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }



    public void sair(){
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0){
            this.dispose();
        }
    }



    public void imprimir(){
        passeio = new Passeio();
        try {
            passeio.getModelo(ctModelo.getText());
            passeio.setCor(ctCor.getText());
            passeio.setMarca(ctCor.getText());
            passeio.setQtdPassageiros(Integer.parseInt(ctPassageiros.getText()));
            passeio.setQtdRodas(Integer.parseInt(ctRodas.getText()));
            passeio.setPlaca(ctPlaca.getText());
            passeio.getMotor().setQtdPist(Integer.parseInt(ctPistoes.getText()));
            passeio.getMotor().setPontencia(Integer.parseInt(ctPotencia.getText()));
            passeio.setVelocMax(Integer.parseInt(ctVelocMax.getText()));

            passeio = bdVeiculos.cadPasseio(passeio);
            if(passeio != null){
                JOptionPane.showMessageDialog(null, "Passeio cadastrado com sucesso! ", "Cadastro ok", 1);
                limpar();
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um veículo com está placa! ", "Cadastro não realizado", 0);
                ctPlaca.setText("");
                ctPlaca.requestFocus();
            }
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "A quantidade de passageiros deve ser Inteiro! ", "Erro Passageiros", JOptionPane.ERROR_MESSAGE);
            limpar();
        }catch (NullPointerException n){
            JOptionPane.showMessageDialog(null, "Erro inesperado tente novamente! ", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch (VeicExistException vee) {
            JOptionPane.showMessageDialog(null, vee.erroVeiculo(), "Erro", JOptionPane.ERROR_MESSAGE);
        }catch (VelocException v){
            JOptionPane.showMessageDialog(null, v.erroVeloc(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame jan6 = new ImprimirExcluir("Cadastro Veículos de Passeio");
        jan6.setSize(600,600);
        jan6.setVisible(true);
    }
}
