import javax.swing.*;

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
    }


    public static void main(String[] args){
        JFrame jan4 = new VeiculosPasseio("Gestão de Veículos");
        jan4.setSize(450,400);
        jan4.setVisible(true);

    }
}
