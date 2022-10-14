package DAO;

import LISTA_ENLAZADA.Lista_enlazada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jlmmj
 */
public class Implement extends MySQLConexion implements Interface {
    
    @Override
    public ArrayList<String[]> Cargar_datos() {
        System.out.println("STATIC CLASS DESCARGA_DATOS SUCESS");
        ArrayList<String[]> datos = new ArrayList<>();
        try{
            Connection conn = getConexion();
            String SQL = "select * from orden_servicio";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                String data[] = {
                    rs.getString("COD_PRO").replace("P", ""),
                    rs.getString("DESC_PRO"),
                    rs.getString("prioridad"),
                    rs.getString("proveedor"),
                    rs.getString("PRECIO_PRO"),
                    rs.getString("razon_social"),
                };
                datos.add(data);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            //Implement.cerrar();
            Collections.shuffle(datos);
            /*System.out.println("DATOS-----------");
            for (String[] datoss : datos){//AGREGA SIMBOLO DE CODIGO
                System.out.println(Arrays.toString(datoss));
            }*/
            return datos;
        }
    }

    @Override
    public Lista_enlazada cargar_datos_locales() {
        Lista_enlazada lista= new Lista_enlazada();
        lista.agregarInicio(new String[] {"001", "Cambio de lona y fluorescentes", "MEDIA", "ECOGEN", "900.15", "JEL"});
        lista.agregarInicio(new String[] {"002", "Cambio de lona", "MEDIA", "ECOGEN", "900.43", "CPJ"});
        lista.agregarInicio(new String[] {"003", "Cambio de lona", "MEDIA", "ECOGEN", "900.73", "CPJ"});
        lista.agregarInicio(new String[] {"004", "Suministro e implementación de tablero nuevo ", "ALTA", "ESINEEL", "1225.75", "LOCALES AT"});
        lista.agregarInicio(new String[] {"005", "PROBLEMAS DE VISIBILIDAD DE CAMARAS ", "ALTA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"006", "PROBLEMAS DE CONEXION DE HDMI", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"007", "PROBLEMA DE CAMARAS ", "MEDIA", "TECNICO DE SOPORTE", "143.43", "LOCALES AT"});
        lista.agregarInicio(new String[] {"008", "Conexiones Hdmi juegos virtuales con spliter a pc central-problemas con una pantalla zona deportiva HDMI", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"009", "SUMINISTRO E INSTALACION DE LUMINARIA ", "MEDIA", "LUGONI", "171.76", "CPJ"});
        lista.agregarInicio(new String[] {"010", "PINTADO DE TIENDA ", "MEDIA", "PROYECTO SAN MIGUEL ", "1500.32", "LOCALES AT"});
        lista.agregarInicio(new String[] {"011", "PINTADO DE MUROS ", "MEDIA", "PROYECTO SAN MIGUEL ", "1500.20", "LOCALES AT"});
        lista.agregarInicio(new String[] {"012", "PROBLEMAS EN HDMI", "MEDIA", "GARANTIA", "0.00", "JEL"});
        lista.agregarInicio(new String[] {"013", "DESMONTAJE E INSTALACION DE AIO DE MARCO METALICO ", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"014", "CORRECCION CON EL DRENAJE DEL DUCTOR DEL CONDENSADOR", "ALTA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"015", "CAMBIO DE 2 LUMINARIAS", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"016", "MANTENIMIENTO CORRECTIVO ", "ALTA", "GARANTIA", "1062.21", "LOCALES AT"});
        lista.agregarInicio(new String[] {"017", "ATORO DE DESAGUE ", "ALTA", "GARANTIA", "0.00", "LOCALES AT"});
        lista.agregarInicio(new String[] {"018", "DESMONSTAJE E INSTALACION DE TV EN MARCO METALICO ", "MEDIA", "GARANTIA", "120.00", "CPJ"});
        lista.agregarInicio(new String[] {"019", "DESMONTAJE E INSTALACION DE MARCO METALICO ", "MEDIA", "GARANTIA", "120.00", "CPJ"});
        lista.agregarInicio(new String[] {"020", "cambio pantalla TV 51\"", "MEDIA", "ECOGEN", "900.53", "JEL"});
        lista.agregarInicio(new String[] {"028", "Cambio de lona", "BAJA", "ECOGEN", "700.40", "JEL"});
        //NUEVOS DATOS
        lista.agregarInicio(new String[] {"3078","Suministro e implementación de tablero nuevo ","ALTA","ESINEEL","1224.84","LOCALES AT"});
        lista.agregarInicio(new String[] {"3291","PROBLEMAS DE VISIBILIDAD DE CAMARAS ","ALTA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3312","PROBLEMAS DE CONEXION DE HDMI","MEDIA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3309","PROBLEMA DE CAMARAS ","MEDIA","TECNICO DE SOPORTE","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3310","Conexiones Hdmi juegos virtuales con spliter a pc central /// problemas con una pantalla zona deportiva HDMI","MEDIA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3070","SUMINISTRO E INSTALACION DE LUMINARIA ","MEDIA","LUGONI","170.86","CPJ"});
        lista.agregarInicio(new String[] {"3219","PINTADO DE TIENDA ","MEDIA","PROYECTO SAN MIGUEL","1500.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3066","PINTADO DE MUROS ","MEDIA","PROYECTO SAN MIGUEL","1500.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3285","PROBLEMAS EN HDMI","MEDIA","GARANTIA","0.00","JEL"});
        lista.agregarInicio(new String[] {"3330","DESMONTAJE E INSTALACION DE AIO DE MARCO METALICO","MEDIA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3411","CORRECCION CON EL DRENAJE DEL DUCTOR DEL CONDENSADOR","ALTA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3391","CAMBIO DE 2 LUMINARIAS","MEDIA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3498","MANTENIMIENTO CORRECTIVO ","ALTA","GARANTIA","1062.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3408","ATORO DE DESAGUE ","ALTA","GARANTIA","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3347","DESMONSTAJE E INSTALACION DE TV EN MARCO METALICO ","MEDIA","GARANTIA","120.00","CPJ"});
        lista.agregarInicio(new String[] {"4125","DESMONTAJE E INSTALACION DE MARCO METALICO ","MEDIA","GARANTIA","120.00","CPJ"});
        lista.agregarInicio(new String[] {"3228","DESMONTAJE E INSTALACION DE 1 TV","MEDIA","PROYECTOS INVERSIONES SAN MIGUEL SAC","120.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3130","CAMBIO DE INTERRUPTOR DIFERENCIAL","ALTA","ESINEEL","362.85","LOCALES AT"});
        lista.agregarInicio(new String[] {"4118","PEINADO DE COUNTER ","MEDIA","JULIO JAUREGUI","0.00","OPERACIONES AT"});
        lista.agregarInicio(new String[] {"4261","CAMBIO DE LUMINARIA","MEDIA","JULIO JAUREGUI","0.00","OPERACIONES AT"});
        lista.agregarInicio(new String[] {"3239","CAJON DAÑADO POR ROBO, CORREDIZAS SE ATASCAN Y SIN MANIJA","MEDIA","C&TVentas y Servicios Generales EIRL","221.25","LOCALES AT"});
        lista.agregarInicio(new String[] {"4096","CORREDIZAS DAÑADAS DE PUERTA Y DE CAJA","MEDIA","C&TVentas y Servicios Generales EIRL","256.65","JEL"});
        lista.agregarInicio(new String[] {"4390","CHAPA DE CAJA NO FUNCIONA Y CHAPA DE TERMINAL NO FUNCIONA","MEDIA","C&TVentas y Servicios Generales EIRL","89.09","LOCALES AT"});
        lista.agregarInicio(new String[] {"3388","CORREDIZAS DE CAJON SE ATASCAN, PUERTA CORREDIZA DE CAJA EN MAL ESTADO DESENTRADA, DIFICULTA PARA ABRIR Y CERRAR","MEDIA","C&TVentas y Servicios Generales EIRL","221.25","LOCALES AT"});
        lista.agregarInicio(new String[] {"4054","CAMBIO DE CHAPAS EN CAJON POR MOTIVOS Y COLOCAR PUERTA EN CAJA","MEDIA","C&TVentas y Servicios Generales EIRL","280.25","JEL"});
        lista.agregarInicio(new String[] {"4014","PUERTA DE CAJA CON CORREDIZAS DAÑADAS, PUERTA DESENTRADA REPARAR TAPA DE CAJA, COLOCAR BOVEDA EN CAJA SOLO INSTALACIÓN","MEDIA","C&TVentas y Servicios Generales EIRL","339.25","CPJ"});
        lista.agregarInicio(new String[] {"3393","TVs no prenden","MEDIA","Julio Jauregui","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"5220","MANTENIMIENTO DE PISOS, PINTADO DE PAREDES Y REPARACION DE DRIWALL","MEDIA","ECOGEN","950.00","CPJ"});
        lista.agregarInicio(new String[] {"4318","Laminado de mampara, reordenamiento de counter, taco para puerta","ALTA","Tecnico Local","1152.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"2238","MANTENIMIENTO PREVENTIVO DE POZO A TIERRA","MEDIA","WANG","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3234","MANTENIMIENTO PREVENTIVO POZO A TIERRA","MEDIA","WANG","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"2220","MANTENIMIENTO PREVENTIVO POZO A TIERRA","MEDIA","WANG","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"7734","PROBLEMA CON SONIDO DE SENSORES DE HUMO","MEDIA","JULIO JAUREGUI","0.00","CPJ"});
        lista.agregarInicio(new String[] {"3270","PROBLEMAS CON TIMER Y ENCENDIDO DE LETRERO PUBLICITARIO","BAJA","JULIO JAUREGUI","0.00","LOCALES AT"});
        lista.agregarInicio(new String[] {"3218","MANTENIMIENTO PREVENTIVO DE LUCES DE EMERGENCIA, DETECTORES DE HUMO Y POZO A TIERRA","MEDIA","JULIO JAUREGUI","0.00","CPJ"});
        lista.agregarInicio(new String[] {"2208","MANTENIMIENTO PREVENTIVO LUCES DE EMERGENCIA, SENSOR DE HUMO","MEDIA","JULIO JAUREGUI","0.00","CPJ"});
        return lista;
    }
    
    
}