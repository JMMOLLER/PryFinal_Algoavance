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
        isInitialized = true;
    }
    
    public boolean getIsInitialized(){
        return this.isInitialized;
    }
    
    public void agregar(String[] cadenaArreglo){
        String[] elemento = cadenaArreglo; 
        int indiceArreglo = Integer.parseInt(elemento[0]) % 7;
        System.out.println("El indice es "+ indiceArreglo +"Para el elemento "+ Arrays.toString(elemento));
        //Tratando las colisiones
        while(arreglo[indiceArreglo]!=null){
            indiceArreglo++;
            System.out.println("Ocurrió una colisión en el indice " +(indiceArreglo-1)+ "Cambiar a indice " +indiceArreglo);
            indiceArreglo%=tamanio;
        }
        arreglo[indiceArreglo]=elemento; 
    }
    
    //Metodo para mostrar la tabla
    public void Mostrar(){
        int incremento = 0,i,j;
        for (i = 0; i < 1; i++) {
            incremento += 8;
            for (j = 0; j < 71; j++) {
                System.out.print("-");
            }
            System.out.println();
            for (j = incremento-8; j < arreglo.length; j++) {
                System.out.format("| %3s " + " ", j);                 
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++) {
                System.out.print("-");                
            }
            System.out.println();
            for (j = incremento-8; j < incremento; j++) {
                if(arreglo[j]==null){
                    System.out.println("|       ");
                } else {
                    System.out.print(String.format("| %3s " + " ",Arrays.toString(arreglo[j])));
                }
            }
            System.out.println("|");
             for (j = 0; j < 71; j++) {
                System.out.print("-");                
            }
            System.out.println();           
        }
    }
    
    //Método para buscar Clave
    public String[] buscarClave(String elemento) {
        int indiceArreglo = Integer.parseInt(elemento) % 7;
        int contador = 0;
        while(arreglo[indiceArreglo]!=null){
            if(arreglo[indiceArreglo] == null ? elemento == null : arreglo[indiceArreglo][0].equals(elemento))
            {
                System.out.println("El elemento " + elemento + " Fue encontrado por el Índice " + indiceArreglo);
                this.printIndice(indiceArreglo);
                return arreglo[indiceArreglo];
            }
            indiceArreglo++;
            indiceArreglo%=tamanio;
            contador++;
            if(contador > 7){
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
