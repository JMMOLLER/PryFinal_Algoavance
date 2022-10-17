/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELOS;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jlmmj
 */
public class M_Pila {
    ArrayList<String[]> my_dict = new ArrayList<>();  
    DefaultTableModel table_model= new DefaultTableModel();
    int init = 1;

    public ArrayList<String[]> getMy_dict() {
        return my_dict;
    }

    public void setMy_dict(ArrayList<String[]> my_dict) {
        this.my_dict = my_dict;
    }

    public DefaultTableModel getTable_model() {
        return table_model;
    }

    public void setTable_model(DefaultTableModel modelo) {
        this.table_model = modelo;
    }

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }   

    public void addColumn(Object columnName) {
        table_model.addColumn(columnName);
    }

    public void setRowCount(int rowCount) {
        table_model.setRowCount(rowCount);
    }

    public void addRow(Object[] rowData) {
        table_model.addRow(rowData);
    }

    public void clearArrayList() {
        my_dict.clear();
    }

    public boolean addIntoArrayList(String[] e) {
        return my_dict.add(e);
    }
}
