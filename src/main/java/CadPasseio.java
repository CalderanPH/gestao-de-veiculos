

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadPasseio extends JFrame {
    private JPanel painelPasseio;
    private JButton btCadastrar;
    private JButton btLimpar;
    private JButton btSair;
    private JTextField ctPassageiros;
    private JTextField ctPlaca;
    private JTextField ctMarca;
    private JTextField ctModelo;
    private JTextField ctCor;
    private JTextField ctRodas;
    private JTextField ctVelocMax;
    private JTextField ctPistoes;
    private JTextField ctPotencia;
    private JLabel lblPassageiros;
    private JLabel lblPlaca;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblCor;
    private JLabel lblRodas;
    private JLabel lblVelocMax;
    private JLabel lblPistoes;
    private JLabel lblPotencia;

    private static CadPasseio cadPassUnico;


    private Passeio passeio = new Passeio();
    private BDVeiculos bdVeiculos = new BDVeiculos();


    private CadPasseio(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(painelPasseio);
        this.pack();


        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }


    public static CadPasseio getCadPasseio() {
        if (cadPassUnico == null) {
            cadPassUnico = new CadPasseio("Cadastro Veículos de Passeio");
            cadPassUnico.setSize(450, 400);
            cadPassUnico.setVisible(true);
        }
        return cadPassUnico;
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


    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
        limpar();
    }

    public void cadastrar() {
        passeio = new Passeio();
        try {
            passeio.setModelo(ctModelo.getText());
            passeio.setCor(ctCor.getText());
            passeio.setMarca(ctCor.getText());
            passeio.setQtdPassageiros(Integer.parseInt(ctPassageiros.getText()));
            passeio.setQtdRodas(Integer.parseInt(ctRodas.getText()));
            passeio.setPlaca(Integer.parseInt(ctPlaca.getText()));
            passeio.getMotor().setQtdPist(Integer.parseInt(ctPistoes.getText()));
            passeio.getMotor().setPontencia(Integer.parseInt(ctPotencia.getText()));
            passeio.setVelocMax(Integer.parseInt(ctVelocMax.getText()));

            passeio = bdVeiculos.cadPasseio(passeio);
            if (passeio != null) {
                JOptionPane.showMessageDialog(null, "Passeio cadastrado com sucesso! ", "Cadastro ok", 1);
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "Já existe um veículo com está placa! ", "Cadastro não realizado", 0);
                ctPlaca.setText("");
                ctPlaca.requestFocus();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro! ", "Erro", JOptionPane.ERROR_MESSAGE);
            limpar();
        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "Erro inesperado tente novamente! ", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (VeicExistException vee) {
            JOptionPane.showMessageDialog(null, vee.erroVeiculo(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (VelocException v) {
            JOptionPane.showMessageDialog(null, v.erroVeloc(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
