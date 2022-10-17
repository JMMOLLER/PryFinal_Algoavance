package PILA_ENLAZADA;

import Clases.Nodo;
import static Clases.data.im;
import LISTA_ENLAZADA.Lista_enlazada;
import java.util.ArrayList;

/**
 *
 * @author jlmmj
 */
public class Pila_enlazada {
    private Nodo inicio;
    private int nElementos;

    public Pila_enlazada() {
        this.inicio = null;
        this.nElementos = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public int getnElementos() {
        return nElementos;
    }

    public String[] getDato() {
        return this.inicio.getDato();
    }

    public void getSiguiente() {
        this.inicio = this.inicio.getSiguienteNodo();
    }
    
    public void setnElementos(int nElementos) {
        this.nElementos = nElementos;
    }
    
    public void Insertar(String[] dato){
        Nodo nuevo= new Nodo(dato);
        nuevo.setSiguienteNodo(inicio);
        this.inicio=nuevo;
        nElementos++;
    }
    
    public ArrayList<String[]> getDatos(){
        ArrayList<String[]> datos= new ArrayList<>();
        Nodo temp= inicio;
        while(temp!=null){
            datos.add(temp.getDato());
            temp=temp.getSiguienteNodo();
        }
        return datos;
    }
    
    public void cargar_datos(){
        Lista_enlazada lista = im.cargar_datos_locales();
        while(!lista.estaVacio()){
            this.Insertar(lista.getDato());
            lista.getSiguiente();
        }
    }
    
    public String[] Buscar(String ID){
        ID=ID.replace("P", "");
        Nodo temp= inicio;
        String[] dato=null;
        while(temp!=null){
            if(temp.getDato()[0].equals(ID)){
                dato=temp.getDato();
                break;
            }
            temp=temp.getSiguienteNodo();
        }
        return dato;
    }
    
    public void Eliminar(int datos){
        Nodo temp= inicio;
        ArrayList<String[]> nuevo= new ArrayList<>();
        int count=0;
        while(temp!=null){
            if(count!=datos){
                nuevo.add(temp.getDato());
            }
            temp=temp.getSiguienteNodo();
            count++;
        }
        inicio=null;
        for(String[] dato: nuevo){
            this.Insertar(dato);
        }
    }
}
