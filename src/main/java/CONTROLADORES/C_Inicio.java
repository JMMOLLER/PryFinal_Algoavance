package CONTROLADORES;

import MODELOS.M_Buscar;
import VISTAS.Buscar;
import VISTAS.Inicio;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Inicio implements ActionListener {
    private final Inicio vista;

    public C_Inicio(Inicio vista) {
        this.vista = vista;
        this.vista.BTN_BUSCAR.addActionListener(this);
        this.vista.BTN_COLA.addActionListener(this);
        this.vista.BTN_LISTAR.addActionListener(this);
        this.vista.BTN_ORDENAMIENTO.addActionListener(this);
        this.vista.BTN_PILA.addActionListener(this);
        this.vista.BTN_LOGOUT.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setLocationRelativeTo(vista);
        vista.getContentPane().setBackground(new Color(0, 102, 102));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_BUSCAR)){
            try {
                M_Buscar modelo = new M_Buscar();
                Buscar view = new Buscar();
                C_Buscar ctrl = new C_Buscar(modelo, view);
                ctrl.iniciar();
                view.setVisible(true);
                vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.BTN_COLA)){
            
        }else if(e.getSource().equals(vista.BTN_LISTAR)){
            
        }else if(e.getSource().equals(vista.BTN_LOGOUT)){
            
        }else if(e.getSource().equals(vista.BTN_ORDENAMIENTO)){
            
        }else if(e.getSource().equals(vista.BTN_PILA)){
            
        }else{
            JOptionPane.showMessageDialog(null,"¡UPS, parece que aún no hemos programado esa función!");
        }
    }
    
}
