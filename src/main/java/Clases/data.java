package Clases;

import LISTA_ENLAZADA.Lista_enlazada;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Collections;
/**
 *
 * @author jlmmj
 */
public class data {
public static DAO.Implement im = new DAO.Implement();
protected static ArrayList<String[]> elements= new ArrayList<>();

/*
ORDEN DEL ARRAY EN EL ARRAYLIST:
indice  valor
0   :   Codigo - ID
1   :   Descripción
2   :   Prioridad
3   :   Proveedor
4   :   Costo
5   :   Razón Social
*/

    public static ArrayList<String[]> getElements() {
        return elements;
    }
    
    public static void setElements() {
        Lista_enlazada lista = im.cargar_datos_locales();
        while(!lista.estaVacio()){
            data.elements.add(lista.getDato());
            lista.getSiguiente();
        }
        Collections.shuffle(data.elements);
    }
    
    public static void updateElements(ArrayList<String[]> datos){
        elements = datos;
    }
    
    public static ArrayList<String[]> setFormatList(ArrayList<String[]> datos){//SU FUNCION ES DARLE EL FORMATO CORRECTO AL CODIGO
        ArrayList<String[]> temp = new ArrayList<>();//CREA UN ARRAYLIST
        for(String[] Datos : datos){//RECORRE LA LISTA Y POR CADA ELEMENTO LO ASIGNA AL ARRAY Datos
            String[] temp_element = Datos.clone();//CLONAMOS EL ARRAY A UNA ARRAY TEMPORAL
            temp.add(temp_element);//EL ARRAY TEMPORAL LO AÑADIMOS A LA ARRAYLIST CREADA
        }/*
        esto se hace porque de copiar directamente el arraylist solo copiamos la arraylist en sí mas no sus elementos(los array string) entonces, si modificamos un elemento 
        de los elementos del array string se modificará globalmente, es decir, se modificará los array string que contiene el arraylist llamado elements
        */
        if(!temp.get(0)[0].contains("P")){//COMPRUEBA QUE AL MENOS UN ELEMENTO DE LOS ELEMENTOS DEL ARRAYLIST /NO/ CONTENGA UNA P EN EL CODIGO
            for (int l = 0; l < temp.size(); l++) {//RECCORRE EL ARRAYLIST
                String ID="P"+temp.get(l)[0];//ASIGNAMOS EL ARRAY STRING A LA VARIABLE ID
                temp.get(l)[0] = ID;//CAMBIAMOS EL VALOR DE UN ELEMENTO ESPECIFICO DEL ARRAY STRING POR LA VARIABLE ID
            }
        }/*
        esto se hace para no repetir código en el programa, justamente eso es uno de los prósitos de un metodo
        */
        return temp;//DEVOLVEMOS EL ARRAYLIST MODIFICADO EN EL CÓDIGO
    }
    
    public static ArrayList<String[]> Burbuja(int column) {//LUCERO
        ArrayList<String[]> datos= (ArrayList<String[]>) ((ArrayList<String[]>)getElements()).clone();//CLONA EL ARRAYLIST A DATOS
        for (String[] dato : datos) {//RECORRE DE FORMA EFICIENTE UN ARRAY A DIFERENCIA DE UN FOR
            for(int j=0; j < datos.size()-1; j++){//RECORREMOS EL ARRAYLIST
                String[] numAct= datos.get(j);//ASIGNAMOS UN ELEMENTO DEL ARRAYLIST AL ARRAY
                String[] numSig= datos.get(j+1);//ASIGNAMOS UN ELEMENTO DEL ARRAYLIST AL ARRAY
                if(Integer.parseInt(numAct[0])>Integer.parseInt(numSig[0])){ //COMPRUEBA QUE EL CODIGO  DE numAct SEA MAYOR AL CODIGO DE numSig
                    datos.set(j, numSig);//ASIGNA EL ARRAY STRING numSig EN LA POSICION J
                    datos.set(j+1, numAct);//ASIGNA EL ARRAY STRING numAct EN LA POSICION J+1
                }
            }
        }
        datos = data.setFormatList(datos);//METODO PARA DAR FORMATO CORRECTO AL CODIGO
        System.out.println("--Ordenamiento Burbúja---\n"+"SUCESS");//AVISO POR CONSOLA
        return datos;//DEVUELVE EL ARRAYLIST MODIFICADO
    }
    
    public static ArrayList<String[]> Seleccion(int column){//LUCERO
        ArrayList<String[]> datos= (ArrayList<String[]>) ((ArrayList<String[]>)getElements()).clone();//CLONA EL ARRAYLIST A DATOS
        for(int i=1; i<datos.size(); i++){//RECORRE EL ARRAYLIST
            int k=i;
            String[] Menor = datos.get(i);//ASIGNAMOS UN ARRAY STRING DEL ARRAYLIST AL ARRAY STRING Menor
            for(int j=i+1; j < datos.size(); j++){//RECORRE EL ARRAYLIST
                if(Integer.parseInt(Menor[0]) > Integer.parseInt(datos.get(j)[0])){//COMPRRUEBA QUE EL CODIGO DE EL ARRAY STRING Menor SEA MENOR AL CODIGO DEL ARRAY STRING ACTUAL DEL ARRAYLIST
                    k = j;
                    Menor = datos.get(j);//ASIGNA EL ELEMENTO EN EL INDICE J DE LA ARRAYLIST AL ARRAY STRING Menor
                }
            }
            datos.set(k, datos.get(i));//ASIGNA UN ELEMENTO DEL ARRAYLIST EN UNA POSICION ESPECIFICA
            datos.set(i, Menor);//ASIGNA Menor EN UNA POSICION ESPECIFICA
        }
        datos = data.setFormatList(datos);//METODO PARA DAR FORMATO CORRECTO AL CODIGO
        System.out.println("--Ordenamiento Selección---\n"+"SUCESS");//AVISO POR CONSOLA
        return datos;//DEVUELVE EL ARRAYLIST MODIFICADO
    }
    
    public static ArrayList<String[]> Insercion(int column){//KEVIN
        ArrayList<String[]> datos= (ArrayList<String[]>) ((ArrayList<String[]>)getElements()).clone();//CLONA EL ARRAYLIST A DATOS
        
        for(int i=1; i < datos.size(); i++ ){//RECORREMOS EL ARRAYLIST
            String[] Tem = datos.get(i);//ASIGNAMOS UN ELEMENTO ESPECIFICO DEL ARRAYLIST AL ARRAY STRING Tem
            int k = i-1;
            while(k>=0 && Float.parseFloat(Tem[column]) < Float.parseFloat(datos.get(k)[column])){//PARA QUE ENTRE AL WHILE K DEBE SER MAYOR O IGUAL A 0 Y EL CODIGO DE Tem DEBE SER MENOR AL CODIGO DEL ELEMENTO EN EL INDICE k DEL ARRAYLIST
                datos.set(k+1, datos.get(k));//ASIGNA UN ELEMENTO ESPECIFICO DEL ARRAYLIST AL INDICE k+1 DEL ARRAYLIST
                k = k-1;    
            }
            datos.set(k+1, Tem);//ASIGNA Tem AL INDICE k+1 DEL ARRAYLIST
        }
        
        datos = data.setFormatList(datos);//METODO PARA DAR FORMATO CORRECTO AL CODIGO
        System.out.println("--Ordenamiento Selección---\n"+"SUCESS");//AVISO POR CONSOLA
        return datos;//DEVUELVE EL ARRAYLIST MODIFICADO
    }
    
    public static ArrayList<String[]> Shell_sort(int column) throws SQLException, CloneNotSupportedException{//ROXANA
        ArrayList<String[]> datos= (ArrayList<String[]>) ((ArrayList<String[]>)getElements()).clone();//CLONA EL ARRAYLIST A DATOS
        String[] tem;//CREAMOS UN ARREGLO QUE ALMACENE LOS DATOS TEMPORALMENTE
        int i, j, k, salto;//CREAMOS VARIABLES
        salto= datos.size()/2;//DEFINIMOS LOS SALTOS
        if(column != 2){//BUSCA EN CALUMNA COSTO O ID
            while(salto > 0){//COMPRUEBA QUE SALTO SEA MEYOR A 0
                for(i= salto; i< datos.size(); i++){//RECORREMOS EL ARRAYLIST
                    j= i - salto;
                    while(j >= 0){
                        k= j+ salto;
                        if(Float.parseFloat(datos.get(j)[column]) >= Float.parseFloat(datos.get(k)[column])){//SELECCIONAMOS UN ARREGLO ESPECIFICO DENTRO DE LA ARREGLO
                            tem= datos.get(j);//ASIGNAMOS UN ELEMENTO ESPECIFICO DEL ARRAYLIST A tem
                            datos.set(j, datos.get(k));//ASIGNAMOS AL INDICE j EL ELEMENTO DEL INDICE j DEL ARRAYLIST
                            datos.set(k, tem);//ASIGNAMOS EN EL INDICE k DEL ARRAYLIST EL ARRAY STRING tem
                            j -= salto;
                        }else{j=-1;}
                    }
                }
                salto= salto/2;
            }
        }else{//BUSCA EN COLUMNA PRIORIDAD
            for(int l=0; l<2;l++){
                while(salto > 0){/*se hace el mismo proceso solo que con cadenas de texto*/
                    for(i= salto; i< datos.size(); i++){
                        j= i - salto;
                        while(j >= 0){
                            k= j+ salto;
                            if(datos.get(j)[column].equals("MEDIA") && !datos.get(k)[column].equals("MEDIA")){
                                tem= datos.get(j);
                                datos.set(j, datos.get(k));
                                datos.set(k, tem);
                                j -= salto;
                            }else if(datos.get(j)[column].equals("ALTA") && !datos.get(k)[column].equals("ALTA")){
                                tem= datos.get(k);
                                datos.set(k, datos.get(j));
                                datos.set(j, tem);
                                j -= salto;
                            }
                            else
                            j=-1;
                        }
                    }
                    salto= salto/2;
                }
            }
        }
        datos = data.setFormatList(datos);//METODO PARA DAR FORMATO CORRECTO AL CODIGO
        System.out.println("--Ordenamiento Shell Sort---\n"+"SUCESS");//AVISO POR CONSOLA
        return datos;//DEVUELVE EL ARRAYLIST MODIFICADO
    }
    
    public static ArrayList<String[]> Quick_sort(int column){//KEVIN
        ArrayList<String[]> numeros= (ArrayList<String[]>) ((ArrayList<String[]>)getElements()).clone();//CLONA EL ARRAYLIST A DATOS
        if(numeros.get(0)[0].contains("P")){/*es lo mismo que de la linea 41 a la 48*/
            for (int i = 0; i < numeros.size(); i++) {
                numeros.get(i)[0]= numeros.get(i)[0].replace("P", "");
            }
        }
        System.out.println("--Ordenamiento Quick Sort---\n"+"SUCESS");//AVISO POR CONSOLA
        return quicksort_implement(numeros,0,numeros.size()-1, column); 
    }
    public static ArrayList<String[]> quicksort_implement(ArrayList<String[]> datito,int primero, int ultimo, int column){//SHELL SORT
        if(primero>=ultimo)//COMPROBAMOS QUE PRIMERO SEA MAYOR O IGUAL A ULTIMO
            return datito;//DE SER ASÍ DEVOLVEMOS DATITO
        int i=primero, d=ultimo;
        if(primero!=ultimo){//COMPROBAMOS QUE PRIMERO SEA DIFERENTE DE ULTIMO
            int pivote;
            String[] tem;
            String[] tem2;
            pivote = primero;//PRIMERO ES IGUAL A PIVOTE
            while(primero!=ultimo){//SI PRIMERO ES DIFERENTE A ULTIMO ENTRA AL WHILE
                while(Float.parseFloat(datito.get(ultimo)[column])>=Float.parseFloat(datito.get(pivote)[column]) && primero<ultimo)//SI EL INDICE 0 DEL ELEMENTO EN EL INDICE ULTIMO DEL ARRAYLIST ES MAYOR O IGUAL AL DE (LO MISMO PERO CON PIVOTE)
                    ultimo--;
                while(Float.parseFloat(datito.get(primero)[column])<Float.parseFloat(datito.get(pivote)[column]) && primero<ultimo)//LO MISMO QUE ARRIBA PERO VERIFICA QUE SEA MENOR
                    primero++;
                if(ultimo!=primero){//ULTIMO ES DIFERENTE A PRIMERO
                    tem= datito.get(ultimo);//ASIGNA EL INDICE ULTIMO DE DATITO A tem
                    tem2= datito.get(primero);//ASIGNA EL INDICE ULTIMO DE DATITO A tem2
                    datito.set(i, tem);//HACE EL CAMBIO DE ELEMENTOS
                    datito.set(ultimo, tem2);//HACE EL CAMBIO DE ELEMENTOS
                }
            }
            if(primero==ultimo){
                quicksort_implement(datito,i,primero-1, column);//SE LLAMA A SI MISMO SI PRIMERO ES IGUAL A ULTIMO
                quicksort_implement(datito,primero+1,d, column);//DESPUES DE QUE TERMINE LA LLAMADA A SI MISMO SE VUELVE A LLAMR PERO CON primero+1 Y d
            }
        }else{
            return datito;
        }
        datito = data.setFormatList(datito);
        return datito; 
    }
    
    public static int Busqueda_binaria(int dato) throws SQLException, CloneNotSupportedException{//ROXANA
        ArrayList<String[]> array = new ArrayList<>();
        array = data.Quick_sort(0);
        if(array.get(0)[0].contains("P")){
            for (int i = 0; i < array.size(); i++) {
                array.get(i)[0]= array.get(i)[0].replace("P", "");
            }
        }
        int izquierda, derecha, centro;
        izquierda = 0;
        derecha = array.size() - 1;
        centro = (izquierda + derecha)/2;
        
        while (izquierda <= derecha){
            if(dato == Integer.parseInt(array.get(centro)[0])){
                break;
            }
            if(dato > Integer.parseInt(array.get(centro)[0])){
                izquierda = centro + 1;
            }
            if (dato < Integer.parseInt(array.get(centro)[0])){
                derecha = centro - 1;
            }
            centro = (izquierda + derecha) / 2;
        }
        if (dato == Integer.parseInt(array.get(centro)[0])){
           System.out.println("---Busqueda Binaria---\n"+"El elmento "+ dato + " Se encuentra en la posición " + centro);
           return centro;
        }
        else{
           System.out.println("---Busqueda Binaria---\n"+"No se encuentra el elemento buscado");
           return centro=-1;
        }
    }
    
    public static int Busqueda_secuencial(int dato){//JORGE && FUNCIONAMIENTO DE TABLA
        ArrayList<String[]> array = new ArrayList<>();
        array = data.Quick_sort(0);
        if(array.get(0)[0].contains("P")){
            for (int i = 0; i < array.size(); i++) {
                array.get(i)[0]= array.get(i)[0].replace("P", "");
            }
        }
        int posicion = -1;
        for(int i = 0; i < array.size(); i++){//recorremos todo el arreglo
            if(Integer.parseInt(array.get(i)[0]) == dato){//comparamos el elemento en el arreglo con el buscado
                posicion = i;//Si es verdadero guardamos la posicion
                System.out.println("---Busqueda Secuencial---\n"+"El elmento "+ dato + " Se encuentra en la posición " + posicion);
                break;//Para el ciclo
            }
        }
        if(posicion==-1){System.out.println("---Busqueda Secuencial---\n"+"No se encuentra el elemento buscado");}
        return posicion;
    }
}

