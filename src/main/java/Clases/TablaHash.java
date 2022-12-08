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
public class TablaHash {
    String[][] arreglo;
    int tamanio, contador;
    private boolean isInitialized = false;
    
    //Constructor

    public TablaHash(int tam) {
        tamanio = tam; //Estamos inicializando el tamaño
        arreglo = new String[tam][];
    }
    
    public boolean getIsInitialized(){
        return this.isInitialized;
    }
    
    public void agregar(String[] cadenaArreglo){
        isInitialized = true;
        String[] elemento = cadenaArreglo; 
        int indiceArreglo = Integer.parseInt(elemento[0]) % 97;
        System.out.println("El indice es "+ indiceArreglo +" Para el elemento "+ Arrays.toString(elemento));
        //Tratando las colisiones
        while(arreglo[indiceArreglo]!=null){
            indiceArreglo++;
            System.out.println("Ocurrió una colisión en el indice " +(indiceArreglo-1)+ " Cambiar a indice " +indiceArreglo);
            indiceArreglo%=tamanio;
        }
        arreglo[indiceArreglo]=elemento;
    }
    
    //Método para buscar Clave
    public String[] buscarClave(String elemento) {
        int indiceArreglo = Integer.parseInt(elemento) % 7;
        int count = 0;
        while(arreglo[indiceArreglo]!=null){
            if(arreglo[indiceArreglo] == null ? elemento == null : arreglo[indiceArreglo][0].equals(elemento))
            {
                System.out.println("El elemento " + elemento + " Fue encontrado por el Índice " + indiceArreglo);
                this.printIndice(indiceArreglo);
                return arreglo[indiceArreglo];
            }
            indiceArreglo++;
            indiceArreglo%=tamanio;
            count++;
            if(count > 7){
                break;
            }
        }
        return null;
    }
    
    public String[][] getData(){
        return this.arreglo;
    }
    
    public void printIndice(int index){
        System.out.println(Arrays.toString(arreglo[index]));
    }
}
