
package VISTAS;

import CONTROLADORES.C_Pila;
import MODELOS.M_Pila;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
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

        jPanel1 = new javax.swing.JPanel();
        BTN_BUSCAR = new javax.swing.JButton();
        BTN_LISTAR = new javax.swing.JButton();
        BTN_ORDENAMIENTO = new javax.swing.JButton();
        BTN_PILA = new javax.swing.JButton();
        BTN_COLA = new javax.swing.JButton();
        BTN_LOGOUT = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base de Datos");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BIENVENIDO(A)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SansSerif", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        BTN_BUSCAR.setBackground(new java.awt.Color(204, 255, 255));
        BTN_BUSCAR.setForeground(new java.awt.Color(0, 0, 0));
        BTN_BUSCAR.setText("BUSCAR DATOS");
        BTN_BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BUSCARActionPerformed(evt);
            }
        });

        BTN_LISTAR.setBackground(new java.awt.Color(204, 255, 255));
        BTN_LISTAR.setForeground(new java.awt.Color(0, 0, 0));
        BTN_LISTAR.setText("LISTAR DATOS");
        BTN_LISTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LISTARActionPerformed(evt);
            }
        });

        BTN_ORDENAMIENTO.setBackground(new java.awt.Color(204, 255, 255));
        BTN_ORDENAMIENTO.setForeground(new java.awt.Color(0, 0, 0));
        BTN_ORDENAMIENTO.setText("ORDENAR DATOS");
        BTN_ORDENAMIENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ORDENAMIENTOActionPerformed(evt);
            }
        });

        BTN_PILA.setBackground(new java.awt.Color(204, 255, 255));
        BTN_PILA.setForeground(new java.awt.Color(0, 0, 0));
        BTN_PILA.setText("FORMATO EN PILA");
        BTN_PILA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PILAActionPerformed(evt);
            }
        });

        BTN_COLA.setBackground(new java.awt.Color(204, 255, 255));
        BTN_COLA.setForeground(new java.awt.Color(0, 0, 0));
        BTN_COLA.setText("FORMATO EN COLA");
        BTN_COLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_COLAActionPerformed(evt);
            }
        });

        BTN_LOGOUT.setBackground(new java.awt.Color(0, 102, 102));
        BTN_LOGOUT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTN_LOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_LOGOUT.setText("CERRAR SESIÓN");
        BTN_LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LOGOUTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(BTN_BUSCAR)
                .addGap(30, 30, 30)
                .addComponent(BTN_LISTAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(BTN_ORDENAMIENTO)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(BTN_PILA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_COLA)
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(BTN_LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_LISTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_ORDENAMIENTO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_PILA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_COLA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(BTN_LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BUSCARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_BUSCARActionPerformed

    private void BTN_LISTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LISTARActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Listar lis= new Listar();
            lis.setVisible(true);
            this.setVisible(false);
        } catch (SQLException | CloneNotSupportedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_LISTARActionPerformed

    private void BTN_ORDENAMIENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ORDENAMIENTOActionPerformed
        // TODO add your handling code here:
        try {
            Ordenamiento or= new Ordenamiento();
            or.setVisible(true);
            this.setVisible(false);
        } catch (SQLException | CloneNotSupportedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_ORDENAMIENTOActionPerformed

    private void BTN_PILAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PILAActionPerformed
        try {
            Pila vista= new Pila();
            M_Pila modelo= new M_Pila();
            C_Pila ctrl= new C_Pila(vista, modelo);
            ctrl.Iniciar();
            vista.setVisible(true);
            this.setVisible(false);
        } catch (SQLException | CloneNotSupportedException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTN_PILAActionPerformed

    private void BTN_COLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_COLAActionPerformed
        Cola cola = new Cola();
        cola.setVisible(true);
    }//GEN-LAST:event_BTN_COLAActionPerformed

    private void BTN_LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LOGOUTActionPerformed
        IniciarSesion retroceder = new IniciarSesion();
        retroceder.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_LOGOUTActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_BUSCAR;
    public javax.swing.JButton BTN_COLA;
    public javax.swing.JButton BTN_LISTAR;
    public javax.swing.JToggleButton BTN_LOGOUT;
    public javax.swing.JButton BTN_ORDENAMIENTO;
    public javax.swing.JButton BTN_PILA;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
