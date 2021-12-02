import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestaoMain extends javax.swing.JFrame{
    private JPanel painelGest;
    private JButton btPasseio;
    private JButton btCarga;
    private JTextArea escolhaQualTipoDeTextArea;

    public GestaoMain(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(painelGest);
        this.pack();
        btPasseio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passeio();
            }
        });
        btCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carga();
            }
        });
    }

    public void passeio(){

    }

    public void carga(){

    }

    public static void main(String[] args){
        JFrame jan3 = new GestaoMain("Gestão de Veículos");
        jan3.setSize(600,500);
        jan3.setVisible(true);

    }
}
