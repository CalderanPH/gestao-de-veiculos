

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VeiculosPasseio extends JFrame {
    private JPanel painelPasseio;
    private JButton cadastrarButton;
    private JButton consultarExcluirPelaPlacaButton;
    private JButton imprimirExcluirTodosButton;
    private JButton sairButton;
    private JTextArea txt1;

    private static VeiculosPasseio veiculosUnico;


    private VeiculosPasseio(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

    public static VeiculosPasseio getVeiculosPasseio() {
        if (veiculosUnico == null) {
            veiculosUnico = new VeiculosPasseio("Cadastro Veículos de Passeio");
            veiculosUnico.setSize(450, 400);
            veiculosUnico.setVisible(true);
        }
        return veiculosUnico;
    }


    public void cadastrar() {
        CadPasseio.getCadPasseio().setVisible(true);
    }

    public void consultar() {
        ConsultarDelete.getConsultarDelete().setVisible(true);
    }

    public void imprimirExluir() {
        ImprimirExcluir.getImprimirExcluir().setVisible(true);
    }

    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }
}