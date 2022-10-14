package FRAMES;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jlmm
 */
public class Test extends javax.swing.JFrame {
ArrayList<String[]> my_dict = new ArrayList<>();  
DefaultTableModel modelo= new DefaultTableModel();
    /**
     * Creates new form Main
     * @throws java.sql.SQLException
     * @throws java.lang.CloneNotSupportedException
     */
    public Test() throws SQLException, CloneNotSupportedException {
        initComponents();
        this.setTitle("Gestión de Datos");
        this.setLocationRelativeTo(this);
        Clases.data.setElements();
        Table("Reset", -1, null);
    }
    public void Table(String tipo, int column, String buscar) throws SQLException, CloneNotSupportedException{
        ArrayList<String> lista = new ArrayList<>();
        if(column == -1){
            lista.add("ID");
            lista.add("Descripción");
            lista.add("Prioridad");
            lista.add("Proveedor");
            lista.add("Costo");
            lista.add("Razón Social");

            for (String columna : lista) {
                modelo.addColumn(columna);
            }
            TBL_AREA.setModel(modelo);
        }

        if(null != tipo)switch (tipo) {
            case "Reset":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                my_dict=Clases.data.getElements();//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                my_dict=Clases.data.setFormatList(my_dict);//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            case "Burbúja":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                my_dict= Clases.data.Burbuja(0);
            case "Selección":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                my_dict= Clases.data.Seleccion(0);
            case "Shell Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                my_dict= Clases.data.Shell_sort(column);//LLAMA AL METODO SHELL SORT
                break;
            case "Quick Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                my_dict= Clases.data.Quick_sort(0);//LLAMA AL METODO QUICK SORT
                /*for (int l = 0; l < my_dict.size(); l++) {//AGREGA SIMBOLO DE CODIGO
                String ID="P"+my_dict.get(l)[0];
                my_dict.get(l)[0] = ID;
                }*/
                break;
            case "Busqueda Binaria":{
                int index = Clases.data.Busqueda_binaria(Integer.parseInt(buscar));
                if(index >=0){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    my_dict.clear();//ELIMINA EL CONTENIDO DE LA ARRAYLIST
                    my_dict.add(Clases.data.Quick_sort(0).get(index));//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    my_dict=Clases.data.setFormatList(my_dict);//LE DA EL FORMATO CORRECTO AL CÓDIGO
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra en la Base de Datos.");
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    my_dict.clear();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    my_dict=Clases.data.getElements();
                    my_dict=Clases.data.setFormatList(my_dict);
                    CBO_BUSQUEDA.setSelectedIndex(0);
                    TXT_BUSCAR.setText(null);
                }   break;
                }
            case "Busqueda Secuencial":{
                int index = Clases.data.Busqueda_secuencial(Integer.parseInt(buscar));//ENTREGA AL METODO BUSQ SECUENCIAL EL ARRAYLIST SIN LAS LETRAS DE CODIGO Y EL ELEMENTO A BUSCAR
                if(index>=0){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    my_dict.clear();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    my_dict.add(Clases.data.Quick_sort(0).get(index));//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    my_dict=Clases.data.setFormatList(my_dict);
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra en la Base de Datos.");
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    my_dict.clear();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    my_dict=Clases.data.getElements();
                    my_dict=Clases.data.setFormatList(my_dict);
                    CBO_BUSQUEDA.setSelectedIndex(0);
                    TXT_BUSCAR.setText(null);
                }   break;
                }
            default:
                break;
        }
        
        for (String []Datos : my_dict){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
        TBL_AREA.setModel(modelo);//AGREGA EL MODELO A LA TABLA
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TXT_BUSCAR = new javax.swing.JTextField();
        BTN_BUSCAR = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_AREA = new javax.swing.JTable();
        CBO_ORDENAR = new javax.swing.JComboBox<>();
        CBO_COLUMNA = new javax.swing.JComboBox<>();
        BTN_ORDENAR = new javax.swing.JButton();
        CBO_BUSQUEDA = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TXT_BUSCAR.setBackground(new java.awt.Color(255, 204, 204));
        TXT_BUSCAR.setForeground(new java.awt.Color(0, 0, 0));

        BTN_BUSCAR.setBackground(new java.awt.Color(255, 204, 204));
        BTN_BUSCAR.setForeground(new java.awt.Color(0, 0, 0));
        BTN_BUSCAR.setText("Buscar");
        BTN_BUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BUSCARActionPerformed(evt);
            }
        });

        TBL_AREA.setBackground(new java.awt.Color(102, 204, 255));
        TBL_AREA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Zona", "Local", "Sistema", "Descripción", "Prioridad", "Tipo", "Proveedor", "Costo", "Razon Social", "Encargado"
            }
        ));
        jScrollPane2.setViewportView(TBL_AREA);

        CBO_ORDENAR.setBackground(new java.awt.Color(255, 204, 204));
        CBO_ORDENAR.setForeground(new java.awt.Color(0, 0, 0));
        CBO_ORDENAR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Shell Sort", "Quick Sort", "Selección", "Burbúja" }));

        CBO_COLUMNA.setBackground(new java.awt.Color(255, 204, 204));
        CBO_COLUMNA.setForeground(new java.awt.Color(0, 0, 0));
        CBO_COLUMNA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Prioridad", "Costo" }));

        BTN_ORDENAR.setBackground(new java.awt.Color(255, 204, 204));
        BTN_ORDENAR.setForeground(new java.awt.Color(0, 0, 0));
        BTN_ORDENAR.setText("Ordenar");
        BTN_ORDENAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ORDENARActionPerformed(evt);
            }
        });

        CBO_BUSQUEDA.setBackground(new java.awt.Color(255, 204, 204));
        CBO_BUSQUEDA.setForeground(new java.awt.Color(0, 0, 0));
        CBO_BUSQUEDA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Busqueda Binaria", "Busqueda Secuencial" }));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Método de busqueda:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Método de ordenamiento:");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(CBO_ORDENAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CBO_COLUMNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BTN_ORDENAR))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CBO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TXT_BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BTN_BUSCAR)))
                        .addGap(67, 67, 67)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(387, 387, 387))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_BUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_BUSCAR)
                    .addComponent(CBO_ORDENAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBO_COLUMNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_ORDENAR)
                    .addComponent(CBO_BUSQUEDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_BUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BUSCARActionPerformed
        if(CBO_BUSQUEDA.getSelectedItem().equals("Ninguno")){
            /*TableRowSorter<TableModel> fil = new TableRowSorter<>(TBL_AREA.getModel());
            TBL_AREA.setRowSorter(fil);
            fil.setRowFilter(RowFilter.regexFilter(TXT_BUSCAR.getText()));*/
            JOptionPane.showMessageDialog(null, "Debe escoger un método de busqueda.");
        }else if(CBO_BUSQUEDA.getSelectedItem().equals("Busqueda Binaria")){
            try {
                Table("Busqueda Binaria", 0, TXT_BUSCAR.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(CBO_BUSQUEDA.getSelectedItem().equals("Busqueda Secuencial")){
            try {
                Table("Busqueda Secuencial", 0, TXT_BUSCAR.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_BTN_BUSCARActionPerformed

    private void BTN_ORDENARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ORDENARActionPerformed
        // TODO add your handling code here:
        if(CBO_ORDENAR.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Sebe escocger un método de ordenación.");
        }else if(CBO_ORDENAR.getSelectedItem()=="Shell Sort"){
            int column=0;//ORDENA POR DEFECTO POR ID
            if(CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                column = 2;
            }else if(CBO_COLUMNA.getSelectedItem().equals("Costo")){
                column = 4;
            }
            try {
                Table("Shell Sort", column, null);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(CBO_ORDENAR.getSelectedItem()=="Quick Sort"){
            int column=0;//ORDENA POR DEFECTO POR ID
            if(CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                column = 2;
            }else if(CBO_COLUMNA.getSelectedItem().equals("Costo")){
                column = 4;
            }
            try {
                Table("Quick Sort", column, null);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(CBO_ORDENAR.getSelectedItem().equals("Burbúja")){
            int column=0;//ORDENA POR DEFECTO POR ID
            if(CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                column = 2;
            }else if(CBO_COLUMNA.getSelectedItem().equals("Costo")){
                column = 4;
            }
            try {
                Table("Burbúja", column, null);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(CBO_ORDENAR.getSelectedItem().equals("Selección")){
            int column=0;//ORDENA POR DEFECTO POR ID
            if(CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                column = 2;
            }else if(CBO_COLUMNA.getSelectedItem().equals("Costo")){
                column = 4;
            }
            try {
                Table("Selección", column, null);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BTN_ORDENARActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Table("Reset",0,null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha generado un error en la soliitud de los datos internos.");
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Test().setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
            } catch (CloneNotSupportedException ex) {
                JOptionPane.showMessageDialog(null, "Se ha generado un error en la carga de librerías.");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_BUSCAR;
    private javax.swing.JButton BTN_ORDENAR;
    private javax.swing.JComboBox<String> CBO_BUSQUEDA;
    private javax.swing.JComboBox<String> CBO_COLUMNA;
    private javax.swing.JComboBox<String> CBO_ORDENAR;
    private javax.swing.JTable TBL_AREA;
    private javax.swing.JTextField TXT_BUSCAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
