//package main.java;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;


public class ConsultarDelete extends JFrame {
    private JTextField ctPlaca;
    private JTextField ctPassageiros;
    private JTextField ctMarca;
    private JTextField ctModelo;
    private JTextField ctCor;
    private JTextField ctRodas;
    private JTextField ctVelocMax;
    private JTextField ctPistoes;
    private JTextField ctPotencia;
    private JButton btConsultar;
    private JButton btExcluir;
    private JButton btSair;
    private JLabel lblPlaca;
    private JLabel lblPassageiros;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblCor;
    private JLabel lblRodas;
    private JLabel lblVelocMax;
    private JLabel lblPistoes;
    private JLabel lblPotencia;
    private JPanel painelConsulta;

    private Passeio passeio = new Passeio();
    private BDVeiculos bdVeiculos = new BDVeiculos();


    private static ConsultarDelete consultarDelete;

    private ConsultarDelete(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(painelConsulta);
        this.pack();


        btConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarPlaca();
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }

    public static ConsultarDelete getConsultarDelete() {
        if (consultarDelete == null) {
            consultarDelete = new ConsultarDelete("Consultar ou Exluir veículo pela placa");
            consultarDelete.setSize(450, 400);
            consultarDelete.setVisible(true);
        }
        return consultarDelete;
    }

    public void consultarPlaca() {
        passeio = new Passeio();
        try {
            passeio.setPlaca(Integer.parseInt(ctPlaca.getText()));

            passeio = bdVeiculos.consPasseio(passeio);

            if (passeio != null) {
                ctPlaca.setText(String.valueOf(passeio.getPlaca()));
                ctPassageiros.setText(String.valueOf(passeio.getQtdPassageiros()));
                ctMarca.setText(passeio.getMarca());
                ctModelo.setText(passeio.getModelo());
                ctCor.setText(passeio.getCor());
                ctRodas.setText(String.valueOf(passeio.getQtdRodas()));
                ctVelocMax.setText(String.valueOf(passeio.getVelocMax()));
                ctVelocMax.setText(String.valueOf(passeio.getVelocMax()));
                ctPistoes.setText(String.valueOf(passeio.getMotor().getQtdPist()));
                ctPotencia.setText(String.valueOf(passeio.getMotor().getPontencia()));
                JOptionPane.showMessageDialog(null, "Veículo consultado com sucesso ", "Consulta ok", 1);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Placa não encontrada! ", "Veículo não localizado", 0);
                ctPlaca.setText("");
                ctPlaca.requestFocus();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Entrada inválida, deve ser um número inteiro", "Erro Placa", JOptionPane.ERROR_MESSAGE);
            limpar();
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado! ", "Erro Placa", JOptionPane.ERROR_MESSAGE);
            limpar();
        }
    }

    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
        limpar();
    }

    public void limpar() {
        ctPassageiros.setText("");
        ctPlaca.setText("");
        ctMarca.setText("");
        ctModelo.setText("");
        ctCor.setText("");
        ctRodas.setText("");
        ctVelocMax.setText("");
        ctVelocMax.setText("");
        ctPistoes.setText("");
        ctPotencia.setText("");
        ctPassageiros.requestFocus();
    }


    public void excluir() {
        passeio = new Passeio();
        try {
            passeio.setPlaca(Integer.parseInt(ctPlaca.getText()));

            bdVeiculos.removePasseio(passeio);
            if (passeio == null) {
                ctPlaca.setText(String.valueOf(passeio.getPlaca()));

                JOptionPane.showMessageDialog(null, "Veículos impressos com sucesso", "IMPRESSO", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado, verifique a placa informada", "Erro placa", 0);
                ctPlaca.setText("");
                ctPlaca.requestFocus();
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo Informado", "Erro Delete", 0);
        }

    }
}
