/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Pila;
import VISTAS.ActualizarPila;
import VISTAS.Pila;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlmmj
 */
public class C_ActualizarPila implements ActionListener {
    private final ActualizarPila vista;

    public C_ActualizarPila(ActualizarPila vista) {
        this.vista = vista;
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnVolver)){
            try {
                Pila view= new Pila();
                M_Pila model=new M_Pila();
                C_Pila ctrl= new C_Pila(view, model);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_ActualizarPila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }if(e.getSource().equals(vista.btnGuardar)){
            
        }else{
            
        }
    }
    
    
}
