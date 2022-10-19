/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Listar;
import VISTAS.Inicio;
import VISTAS.Listar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Listar implements ActionListener {
    private final Listar vista;
    private final M_Listar modelo;

    public C_Listar(Listar vista, M_Listar modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.BTN_BACK.addActionListener(this);
    }

    public void Iniciar() throws SQLException, CloneNotSupportedException{
        this.vista.setLocationRelativeTo(this.vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        Clases.data.setElements();
        Table("Reset");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_BACK)){
            Inicio view = new Inicio();
            C_Inicio ctrl = new C_Inicio(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null,"¡UPS, parece que aún no hemos programado esa función!");
        }
    }
    
    public void Table(String tipo) throws SQLException, CloneNotSupportedException{
        ArrayList<String> lista = new ArrayList<>();
        lista.add("ID");
        lista.add("Descripción");
        lista.add("Prioridad");
        lista.add("Proveedor");
        lista.add("Costo");
        lista.add("Razón Social");

        for (String columna : lista) {
            modelo.addColumn(columna);
        }
        vista.TBL_AREA.setModel(modelo.getModelo());

        modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
        modelo.setMy_dict(Clases.data.getElements());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
        modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
        vista.TBL_AREA.setModel(modelo.getModelo());//AGREGA EL MODELO A LA TABLA
    }
}
