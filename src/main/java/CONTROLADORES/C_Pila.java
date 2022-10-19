/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Pila;
import PILA_ENLAZADA.Pila_enlazada;
import VISTAS.ActualizarPila;
import VISTAS.Inicio;
import VISTAS.Pila;
import java.awt.Color;
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
public class C_Pila implements ActionListener {
    Pila_enlazada Pila=new Pila_enlazada();
    private final Pila vista;
    private final M_Pila modelo;

    public C_Pila(Pila vista, M_Pila modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnReset.addActionListener(this);
    }
    
    public void Iniciar() throws SQLException, CloneNotSupportedException{
        this.vista.setLocationRelativeTo(this.vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        Clases.data.setElements();
        Pila.cargar_datos();
        Table("Reset", null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnInsertar)){
            
        }else if(e.getSource().equals(vista.btnBuscar)){
            try {
                Table("Busqueda", vista.txtDato.getText());
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.btnEliminar)){
            try {
                int index=vista.TBL_AREA.getSelectedRow();
                if(index!=-1){
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el elemento: " + index);
                    if(confirm==0){
                        Pila.Eliminar(index);
                        Table("Reset", null);
                        JOptionPane.showMessageDialog(null, "Se eliminó el elemento seleccionado.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Debe escoger una fila a eliminar");
                }
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.btnActualizar)){
            ActualizarPila ip = new ActualizarPila();
            C_ActualizarPila ctrl= new C_ActualizarPila(ip);
            ctrl.Iniciar();
            ip.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource().equals(vista.btnVolver)){
            Inicio view= new Inicio();
            C_Inicio ctrl= new C_Inicio(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource().equals(vista.btnReset)){
            try {
                Table("Reset", null);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                modelo.setMy_dict(Pila.getDatos());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            }case "Busqueda":{
                String[] result = Pila.Buscar(buscar);
                if(result!=null){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA EL CONTENIDO DE LA ARRAYLIST
                    modelo.addIntoArrayList(result);//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//LE DA EL FORMATO CORRECTO AL CÓDIGO
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra en la Base de Datos.");
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    modelo.setMy_dict(Pila.getDatos());
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));
                    vista.txtDato.setText(null);
                }   break;
            }default:
                break;
        }
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
        vista.TBL_AREA.setModel(modelo.getTable_model());//AGREGA EL MODELO A LA TABLA
    }
}
