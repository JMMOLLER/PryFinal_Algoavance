import DAO.Implement;
import LISTA_ENLAZADA.Lista_enlazada;
import java.util.Arrays;


/**
 *
 * @author jlmmj
 */
public class Test {
    public static void main(String[] args) {
        Implement init= new Implement();
        Lista_enlazada lista = init.cargar_datos_locales();
        System.out.println("DATO");
        System.out.println(Arrays.toString(lista.getDato()));
        System.out.println("DATO");
        while(!lista.estaVacio()){
            System.out.println(Arrays.toString(lista.getDato()));
            lista.getSiguiente();
        }
        System.out.println("COMPLETE");
    }
}
