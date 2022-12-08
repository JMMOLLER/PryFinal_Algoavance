/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author LAB-USR-AQ265-A0302
 */
public class ArbolBinario {
    /* DECLARACIÓN DE VARIABLE */
    private NArbol raiz;
    private final ArrayList<Integer> datos = new ArrayList<>();
    
    /* CONSTRUCTOR */
    public ArbolBinario() {
        this.raiz = null;
    }
    
    /* MÉTODOS */
    public void insertar(int dato){
        NArbol nuevo= new NArbol(dato);//INSTANCIA LA CLASE NArbol ENVIANDOLE DATO A SU CONSTRUCTOR
        if(raiz==null)
            raiz= nuevo;//RAIZ ES IGUAL A LA INSTANCIA CREADA
        else{
            NArbol temp= raiz;//TEMP ES IGUAL A RAIZ
            NArbol padre;//CREAMOS UNA VARIABLE DE TIPO NArbol
            while(true){
                padre= temp;//PADRE ES IGUAL A TEMP(QUE ES IGUAL A RAIZ)
                if(dato<temp.getDato()){
                    temp= temp.getIzq();//TEMP ES IGUAL AL DATO DE LA IZQUIERDA DE TEMP
                    if(temp==null){
                        padre.setIzq(nuevo);//ENVIAMOS NUEVO A LA IZQUIERDA DE PADRE
                        return;//RETORNAMOS LA OPERACIÓN
                    }
                }else{
                    temp= temp.getDer();//PADRE ES IGUAL A TEMP(QUE ES IGUAL A RAIZ)
                    if(temp==null){
                        padre.setDer(nuevo);//ENVIAMOS NUEVO A LA DERECHA DE PADRE
                        return;//RETORNAMOS LA OPERACIÓN
                    }
                }
            }
        }
    }
    
    public NArbol getRaiz(){
        return this.raiz;
    }
    
    public NArbol buscarElemento(int dato){
        NArbol temp= raiz;
        while(temp.getDato()!=dato){
            if(dato<temp.getDato()){
                temp= temp.getIzq();
            }else{
                temp= temp.getDer();
            }
            if(temp==null){
                return null;
            }
        }
        return temp;
    }
    
    
    public String getOrdenData(NArbol r, String type){
        String response = null;
        switch (type) {
            case "preOrden":
                response = this.preOrden(r).toString();
                break;
            case "postOrden":
                response = this.postOrden(r).toString();
                break;
            case "inOrden":
                this.inOrden(r).toString();
                break;
            default:
                return null;
        }
        datos.clear();
        return response;
    }
    
    public ArrayList<Integer> preOrden(NArbol r){
        if(r!=null){
            datos.add(r.getDato());
            preOrden(r.getIzq());
            preOrden(r.getDer());
        }
        return datos;
    }
     
    
    public ArrayList<Integer> inOrden(NArbol r){
        if(r!=null){
            this.inOrden(r.getIzq());
            datos.add(r.getDato());
            this.inOrden(r.getDer());
        }
        return datos;
    }
    
    public ArrayList<Integer> postOrden(NArbol r){
        if(r!=null){
            this.inOrden(r.getIzq());
            this.inOrden(r.getDer());
            datos.add(r.getDato()); 
        }
        return datos;
    }
}
