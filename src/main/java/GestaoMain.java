

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GestaoMain extends JFrame {
    private JPanel painelGest;
    private JButton btPasseio;
    private JButton btCarga;
    private JTextArea escolhaQualTipoDeTextArea;
    private JButton btSair;

    public GestaoMain(String title) {
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
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }

    public void passeio() {
        VeiculosPasseio.getVeiculosPasseio().setVisible(true);
    }

    public void carga() {

    }


    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        JFrame jan3 = new GestaoMain("Gestão de Veículos");
        jan3.setSize(600, 500);
        jan3.setVisible(true);
    }
}
