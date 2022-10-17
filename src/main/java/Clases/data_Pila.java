/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import PILA_ENLAZADA.Pila_enlazada;

/**
 *
 * @author jlmmj
 */
public class data_Pila {
    Pila_enlazada Pila= new Pila_enlazada();
    public void cargar_datos(){
        for(String[] data:Clases.data.getElements()){
            Pila.Insertar(data);
        }
    }
}
