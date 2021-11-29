import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadPasseio extends javax.swing.JFrame {
    private JButton btCadastrar;
    private JButton btLimpar;
    private JButton btNovo;
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
    private JPanel painel;

    public CadPasseio() {
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        btNovo.addActionListener(new ActionListener() {
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

    public void limpar(){
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


    public void sair(){
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0){
            this.dispose();
        }
        limpar();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("CadPasseio");
        frame.setContentPane(new CadPasseio().painel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
