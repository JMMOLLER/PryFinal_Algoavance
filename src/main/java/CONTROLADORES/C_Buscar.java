/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Buscar;
import VISTAS.Buscar;
import VISTAS.Inicio;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Buscar implements ActionListener {
    private final M_Buscar modelo;
    private final Buscar vista;

    public C_Buscar(M_Buscar modelo, Buscar vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.BTN_BACK.addActionListener(this);
        this.vista.BTN_BUSCAR.addActionListener(this);
        //this.vista.TBL_AREA.
        //this.vista.TXT_BUSCAR.addActionListener(this);
    }
    
    public void iniciar() throws SQLException, CloneNotSupportedException{
        vista.setLocationRelativeTo(vista);
        vista.getContentPane().setBackground(new Color(0, 102, 102));
        Clases.data.setElements();
        Table("Reset", null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_BUSCAR)){
            try{
                if(vista.TXT_BUSCAR.getText() == null || vista.TXT_BUSCAR.getText().equals(" ")){
                    JOptionPane.showMessageDialog(null, "No puede buscar elementos vacios");
                }else if(vista.CBO_BUSQUEDA.getSelectedItem().equals("Ninguno")){
                    /*TableRowSorter<TableModel> fil = new TableRowSorter<>(TBL_AREA.getModel());
                    TBL_AREA.setRowSorter(fil);
                    fil.setRowFilter(RowFilter.regexFilter(TXT_BUSCAR.getText()));*/
                    JOptionPane.showMessageDialog(null, "Debe escoger un método de busqueda.");
                }else if(vista.CBO_BUSQUEDA.getSelectedItem().equals("Busqueda Binaria")){
                    try {
                        Table("Busqueda Binaria", vista.TXT_BUSCAR.getText());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if(vista.CBO_BUSQUEDA.getSelectedItem().equals("Busqueda Secuencial")){
                    try {
                        Table("Busqueda Secuencial", vista.TXT_BUSCAR.getText());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Buscar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }catch(HeadlessException | NumberFormatException ex ){
                JOptionPane.showMessageDialog(null, "Se generó un problema, intente ingresar datos adecuados.");
            }
        }else if(e.getSource().equals(vista.BTN_BACK)){
            //M_Inicio model = new M_Inicio();
            Inicio view = new Inicio();
            C_Inicio ctrl = new C_Inicio(view);
            ctrl.iniciar();
            view.setVisible(true);
            vista.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null,"¡UPS, parece que aún no hemos programado esa función!");
        }
    }
    
    public void Table(String tipo, String buscar) throws SQLException, CloneNotSupportedException{
        ArrayList<String> lista = new ArrayList<>();
        
        if(modelo.getInit()==1){
            modelo.setInit(0);
            lista.add("ID");
            lista.add("Descripción");
            lista.add("Prioridad");
            lista.add("Proveedor");
            lista.add("Costo");
            lista.add("Razón Social");
        }

        for (String columna : lista) {
            modelo.addColumn(columna);
        }
        vista.TBL_AREA.setModel(modelo.getTable_model());

        if(null != tipo)switch (tipo) {
            case "Reset":{
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.getElements());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            }
            case "Busqueda Binaria":{
                int index = Clases.data.Busqueda_binaria(Integer.parseInt(buscar));
                if(index >=0){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA EL CONTENIDO DE LA ARRAYLIST
                    modelo.addIntoArrayList(Clases.data.Quick_sort(0).get(index));//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//LE DA EL FORMATO CORRECTO AL CÓDIGO
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra en la Base de Datos.");
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    modelo.setMy_dict(Clases.data.getElements());
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));
                    vista.CBO_BUSQUEDA.setSelectedIndex(0);
                    vista.TXT_BUSCAR.setText(null);
                }   break;
            }
            case "Busqueda Secuencial":{
                int index = Clases.data.Busqueda_secuencial(Integer.parseInt(buscar));//ENTREGA AL METODO BUSQ SECUENCIAL EL ARRAYLIST SIN LAS LETRAS DE CODIGO Y EL ELEMENTO A BUSCAR
                if(index>=0){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    modelo.addIntoArrayList(Clases.data.Quick_sort(0).get(index));//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra en la Base de Datos.");
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    modelo.setMy_dict(Clases.data.getElements());
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));
                    vista.CBO_BUSQUEDA.setSelectedIndex(0);
                    vista.TXT_BUSCAR.setText(null);
                }   
                break;
            }
            default:
                break;
        }
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
        vista.TBL_AREA.setModel(modelo.getTable_model());//AGREGA EL MODELO A LA TABLA
    }
}
