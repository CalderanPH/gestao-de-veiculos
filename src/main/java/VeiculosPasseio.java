package main.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculosPasseio extends javax.swing.JFrame{
    private JPanel painelPasseio;
    private JButton cadastrarButton;
    private JButton consultarExcluirPelaPlacaButton;
    private JButton imprimirExcluirTodosButton;
    private JButton sairButton;
    private JTextArea txt1;


    public VeiculosPasseio(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(painelPasseio);
        this.pack();


        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
        consultarExcluirPelaPlacaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultar();
            }
        });
        imprimirExcluirTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirExluir();
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }


    public void cadastrar(){
        JFrame jan1 = new CadPasseio("Cadastro Veículos de Passeio");
        jan1.setSize(450,400);
        jan1.setVisible(true);
    }

    public void consultar(){
        JFrame jan2 = new ConsultarDelete("Consultar ou Exluir veículo pela placa");
        jan2.setSize(450,400);
        jan2.setVisible(true);
    }

    public void imprimirExluir(){
        JFrame jan3 = new ImprimirExcluir("Imprimir ou Excluir todos os veículos");
        jan3.setSize(450,400);
        jan3.setVisible(true);
    }

    public void sair(){
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0){
            this.dispose();
        }
    }

}
