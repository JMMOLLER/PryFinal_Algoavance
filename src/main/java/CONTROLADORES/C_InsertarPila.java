package CONTROLADORES;

import MODELOS.M_Pila;
import VISTAS.InsertarPila;
import VISTAS.Pila;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class C_InsertarPila implements ActionListener{
    private final M_Pila modelo;
    private final InsertarPila vista;

    public C_InsertarPila(InsertarPila vista, M_Pila modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnGuarda.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(vista);
        this.vista.txtID.setText(Clases.data.getTablaHash().getLastID());
        this.vista.txtCosto.setText("0.00");
    }
    
    private String getID(){
        return vista.txtID.getText().replace("P", "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnGuarda)){         
            try{
                String Descripcion=vista.txtDescrip.getText();
                String Razonsocial=vista.txtRazsocial.getText();
                String Proveedor=vista.txtProveedor.getText();
                String Prioridad=vista.txtPrioridad.getText();
                float Costo = 0;
                Costo = Float.parseFloat(vista.txtCosto.getText());
                String dato[] = {this.getID(),Descripcion,Razonsocial,Proveedor,Prioridad,String.valueOf(Costo)};
                modelo.getPila().Insertar(dato);
                modelo.getPila().EnviarDatos();
                System.out.println("Cantidad de elementos en la lista --> "+modelo.getPila().getnElementos());
                int response = JOptionPane.showConfirmDialog(null, "Se agregó correctamente el dato.\n"
                        + "¿Desea ingresar un nuevo dato?");
                if(response==1){
                    try {
                        Pila view = new Pila();
                        M_Pila model = new M_Pila();
                        C_Pila ctrl = new C_Pila( view, model);
                        ctrl.Iniciar();
                        view.setVisible(true);
                        vista.setVisible(false);
                    } catch (SQLException | CloneNotSupportedException ex) {
                        Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    vista.txtID.setText(Integer.toString(Integer.parseInt(vista.txtID.getText().replace("P", ""))+1));
                    vista.txtDescrip.setText(null);
                    vista.txtRazsocial.setText(null);
                    vista.txtProveedor.setText(null);
                    vista.txtPrioridad.setText(null);
                    vista.txtCosto.setText("0.00");
                }
            }catch(NumberFormatException  ex){
                JOptionPane.showMessageDialog(null, "Solo se permiten números");
                vista.txtID.setText(Clases.data.getTablaHash().getLastID());
                vista.txtDescrip.setText(null);
                vista.txtRazsocial.setText(null);
                vista.txtProveedor.setText(null);
                vista.txtPrioridad.setText(null);
                vista.txtCosto.setText("0.00");
            }
        }else if(e.getSource().equals(vista.btnVolver)){
            try {
                Pila view = new Pila();
                M_Pila model = new M_Pila();
                C_Pila ctrl = new C_Pila( view, model);
                ctrl.Iniciar();
                view.setVisible(true);
                vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"¡UPS, parece que aún no hemos programado esa función!");
        }
    }
}
