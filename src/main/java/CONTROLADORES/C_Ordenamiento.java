/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Ordenamiento;
import VISTAS.Inicio;
import VISTAS.Ordenamiento;
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
public class C_Ordenamiento implements ActionListener {
    private final Ordenamiento vista;
    private final M_Ordenamiento modelo;

    public C_Ordenamiento(Ordenamiento vista, M_Ordenamiento modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.BTN_ORDENAR.addActionListener(this);
        this.vista.BTN_RESET.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    public void Iniciar() throws SQLException, CloneNotSupportedException{
        this.vista.setLocationRelativeTo(this.vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        Table("Reset", -1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_ORDENAR)){
            if(vista.CBO_ORDENAR.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Sebe escocger un método de ordenación.");
            }else if(vista.CBO_ORDENAR.getSelectedItem()=="Shell Sort"){
                int column=0;//ORDENA POR DEFECTO POR ID
                if(vista.CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                    column = 2;
                }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                    column = 4;
                }
                try {
                    Table("Shell Sort", column);
                } catch (SQLException | CloneNotSupportedException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                }
            }else if(vista.CBO_ORDENAR.getSelectedItem()=="Quick Sort"){
                int column=0;//ORDENA POR DEFECTO POR ID
                if(vista.CBO_COLUMNA.getSelectedItem().equals("ID") || vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                    if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                        column = 4;
                    }
                    try {
                        Table("Quick Sort", column);
                    } catch (SQLException | CloneNotSupportedException ex) {
                        JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "De momento no se ordenar por la categoría seleccionada usando este método.");
                }

            }else if(vista.CBO_ORDENAR.getSelectedItem().equals("Burbúja")){
                int column=0;//ORDENA POR DEFECTO POR ID
                if(vista.CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                    column = 2;
                }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                    column = 4;
                }
                try {
                    Table("Burbúja", column);
                } catch (SQLException | CloneNotSupportedException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                }
            }else if(vista.CBO_ORDENAR.getSelectedItem().equals("Selección")){
                int column=0;//ORDENA POR DEFECTO POR ID
                if(vista.CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                    column = 2;
                }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                    column = 4;
                }
                try {
                    Table("Selección", column);
                } catch (SQLException | CloneNotSupportedException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                }
            }else if(vista.CBO_ORDENAR.getSelectedItem().equals("Inserción")){
                int column=0;//ORDENA POR DEFECTO POR ID
                if(vista.CBO_COLUMNA.getSelectedItem().equals("ID") || vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                    if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                        column = 4;
                    }
                    try {
                        Table("Inserción", column);
                    } catch (SQLException | CloneNotSupportedException ex) {
                        JOptionPane.showMessageDialog(null, "Se ha generado un error con la Base de Datos.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "De momento no se puede ordenar por la categoría seleccionada usando este método.");
                }
            }
        }else if(e.getSource().equals(vista.BTN_RESET)){
            try {
                Table("Reset",0);
            } catch (CloneNotSupportedException | SQLException ex) {
                Logger.getLogger(C_Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.btnVolver)){
            Inicio view= new Inicio();
            C_Inicio ctrl= new C_Inicio(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
    public void Table(String tipo, int column) throws SQLException, CloneNotSupportedException{
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
            vista.TBL_AREA.setModel(modelo.getTable_model());
        }

        if(null != tipo)switch (tipo) {
            case "Reset":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.getElements());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            case "Burbúja":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Burbuja(0));
            case "Selección":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Seleccion(0));
            case "Shell Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Shell_sort(column));//LLAMA AL METODO SHELL SORT
                break;
            case "Quick Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Quick_sort(column));//LLAMA AL METODO QUICK SORT
                break;
            case "Inserción":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Insercion(column));//LLAMA AL METODO QUICK SORT
                break;
            default:
                break;
        }
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
        vista.TBL_AREA.setModel(modelo.getTable_model());//AGREGA EL MODELO A LA TABLA
    }
}
