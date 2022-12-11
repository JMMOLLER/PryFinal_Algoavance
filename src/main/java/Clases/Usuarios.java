/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Arrays;

/**
 *
 * @author jlmmj
 */
public class Usuarios {
    private final Lista_enlazada users;
    private int nUsuarios;

    public Usuarios(Lista_enlazada users) {
        this.users = users;
        this.nUsuarios = 0;
        this.users.agregarInicio(new String[]{"admin23","12345"});
    }
    
    public void addUser(String usr, String pass){
        final String[] credentials = {usr, pass};
        users.agregarFinal(credentials);
        nUsuarios++;
    }
    
    public boolean login(String usr, String pass){
        final String[] credentials = {usr, pass};
        return users.Buscar(credentials);
    }
}
