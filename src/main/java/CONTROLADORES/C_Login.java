/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import Clases.Lista_enlazada;
import Clases.Usuarios;
import VISTAS.IniciarSesion;
import VISTAS.Inicio;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Login implements ActionListener {
    private final IniciarSesion vista;
    private final Clases.Usuarios users;

    public C_Login(IniciarSesion vista) {
        this.vista = vista;
        this.vista.btnLogin.addActionListener(this);
        this.vista.btnExit.addActionListener(this);
        this.users = new Usuarios(new Lista_enlazada());
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\ico\\login-ico-48x48.png");   
        JLabel userLabel = new JLabel("Full Name :", icon, JLabel.LEFT);
        this.vista.getContentPane().add(userLabel);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnLogin)){
            String user, pass;
            user = this.vista.txtUser.getText();
            pass = this.vista.txtPass.getText();
            /* users.login(user, pass) */
            if(true){
                Inicio view = new Inicio();
                C_Inicio ctrl = new C_Inicio(view);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta", "¡ERROR!", WIDTH);
            }
        }else if(e.getSource().equals(vista.btnExit)){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "¡UPS, parece que aún no hemos programado esa función!", "¡ADVERTENCIA!", WIDTH);
        }
    }
    
}
