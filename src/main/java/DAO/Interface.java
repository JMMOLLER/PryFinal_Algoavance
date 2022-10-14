/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import LISTA_ENLAZADA.Lista_enlazada;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract interface Interface {
    public abstract ArrayList<String[]> Cargar_datos() throws SQLException;
    public abstract Lista_enlazada cargar_datos_locales();
}
