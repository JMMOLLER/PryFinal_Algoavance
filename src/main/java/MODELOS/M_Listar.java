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
public class M_Listar {
    private DefaultTableModel Table_model= new DefaultTableModel();
    private ArrayList<String[]> my_dict = new ArrayList<>();

    public DefaultTableModel getModelo() {
        return Table_model;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.Table_model = modelo;
    }

    public ArrayList<String[]> getMy_dict() {
        return my_dict;
    }

    public void setMy_dict(ArrayList<String[]> my_dict) {
        this.my_dict = my_dict;
    }

    public void addColumn(Object columnName) {
        Table_model.addColumn(columnName);
    }

    public void setRowCount(int rowCount) {
        Table_model.setRowCount(rowCount);
    }

    public void addRow(Object[] rowData) {
        Table_model.addRow(rowData);
    }

    public void clearArrayList() {
        my_dict.clear();
    }

    public boolean addIntoArrayList(String[] e) {
        return my_dict.add(e);
    }
    
}
