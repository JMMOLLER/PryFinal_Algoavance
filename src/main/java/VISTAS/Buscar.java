
package VISTAS;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buscar extends javax.swing.JFrame {  
    
    public Buscar() throws SQLException, CloneNotSupportedException {
        initComponents();    
        
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_BACK = new javax.swing.JButton();
        TXT_BUSCAR = new javax.swing.JTextField();
        BTN_BUSCAR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_AREA = new javax.swing.JTable();
        CBO_BUSQUEDA = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscar en Registros");
        setBackground(new java.awt.Color(0, 102, 102));

        BTN_BACK.setBackground(new java.awt.Color(0, 102, 102));
        BTN_BACK.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BACK.setText("VOLVER");
        BTN_BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BACKActionPerformed(evt);
            }
        });

        TXT_BUSCAR.setBackground(new java.awt.Color(0, 102, 102));
        TXT_BUSCAR.setForeground(new java.awt.Color(255, 255, 255));

        BTN_BUSCAR.setBackground(new java.awt.Color(0, 102, 102));
        BTN_BUSCAR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_BUSCAR.setText("BUSCAR");
        BTN_BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BUSCARActionPerformed(evt);
            }
        });

        TBL_AREA.setBackground(new java.awt.Color(204, 255, 255));
        TBL_AREA.setForeground(new java.awt.Color(0, 0, 0));
        TBL_AREA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Zona", "Local", "Sistema", "Descripción", "Prioridad", "Tipo", "Proveedor", "Costo", "Razon Social", "Encargado"
            }
        ));
        jScrollPane2.setViewportView(TBL_AREA);

        CBO_BUSQUEDA.setBackground(new java.awt.Color(0, 102, 102));
        CBO_BUSQUEDA.setForeground(new java.awt.Color(255, 255, 255));
        CBO_BUSQUEDA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Busqueda Binaria", "Busqueda Secuencial" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MÉTODO DE BÚSQUEDA:");

        jSeparator1.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(CBO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(TXT_BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addComponent(jLabel1)))
                        .addGap(74, 74, 74)
                        .addComponent(BTN_BUSCAR))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTN_BACK)
                .addGap(388, 388, 388))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_BUSCAR)
                    .addComponent(CBO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_BACK)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BACKActionPerformed

    }//GEN-LAST:event_BTN_BACKActionPerformed

    private void BTN_BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BUSCARActionPerformed
        
    }//GEN-LAST:event_BTN_BUSCARActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Buscar().setVisible(true);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_BACK;
    public javax.swing.JButton BTN_BUSCAR;
    public javax.swing.JComboBox<String> CBO_BUSQUEDA;
    public javax.swing.JTable TBL_AREA;
    public javax.swing.JTextField TXT_BUSCAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
