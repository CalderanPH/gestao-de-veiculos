
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GestMain extends javax.swing.JPanel {

    /**
     * Creates new form GestMain
     */
    public GestMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btPasseio = new javax.swing.JButton();
        btCarga = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        btPasseio.setText("Passeio");
        btPasseio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPasseioActionPerformed(evt);
            }
        });

        btCarga.setText("Carga");

        jTextField1.setText("Escolha qual tipo de ve�culo deseja cadastrar!");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btPasseio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCarga)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPasseio)
                    .addComponent(btCarga))
                .addGap(117, 117, 117))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btPasseioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPasseioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPasseioActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCarga;
    private javax.swing.JButton btPasseio;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
