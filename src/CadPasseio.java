import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadPasseio extends javax.swing.JFrame {
    private JPanel painelPasseio;
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



    private Passeio passeio = new Passeio();
    private BDVeiculos bdVeiculos = new BDVeiculos();

    public CadPasseio(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void cadastrar(){
            passeio = new Passeio();
        try {
            passeio.setModelo(ctModelo.getText());
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
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um veículo com está placa! ", "Cadastro não realizado", 0);
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
            JFrame frame = new CadPasseio("Cadastro Veículos de Passeio");
            frame.setVisible(true);
    }


}
