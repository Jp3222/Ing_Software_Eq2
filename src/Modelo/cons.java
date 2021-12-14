package Modelo;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class cons {
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
// - - - - - - - - - - - - - Direcciones y Ficheros - - - - - - - - - - - - - //

    public static final String URL_DICS_1 = System.getProperty("user.home") + "/Escritorio";

    public static final String URL_DICS_2 = System.getProperty("user.home") + "/Desktop";

    public static final String URL_FILES = URL_DICS_2 + "/J-Shop";

    /**
     * @param i ruta escogida
     * <br>1 - .BD
     * <br>2 - Reportes Generados
     * <br>3 - Historial de Movimientos
     * <br>4 - J-Shop
     * @return ruta existente + ruta escogida
     */
    public static String url(int i) {
        Ficheros ft = new Ficheros();
        String url = "";
        if (ft.Exists(URL_DICS_1)) {
            url += URL_DICS_1;
        } else if (ft.Exists(URL_DICS_2)) {
            url += URL_DICS_2;
        }
        url += "/J-Shop";
        switch (i) {
            case 1 -> {
                return url + "/.BD";
            }
            case 2 -> {
                return url + "/Reportes Generados";
            }
            case 3 -> {
                return url + "/Historial de Movimientos";
            }
            case 4 -> {
                return url;
            }
            default ->
                throw new NullPointerException("Indice no valido");
        }
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
// - - - - - - - - - - - - - - - Base de datos - - - - - - - - - - - - - - - //
    public final String[] TABLAS = {
        "empleados",
        "productos",
        "movimientos"
    };
    /**
     * Constantes de la tabla 'productos'
     */
    public static final String Productos[] = {
        "ID",
        "Clave",
        "Nombre",
        "Marca",
        "Contenido",
        "UDM",
        "Precio"
    };
    /**
     * Constantes de la tabla 'empleados'
     */
    public static final String Usuarios[] = {
        "ID",
        "Usuario",
        "Nombre",
        "A_paterno",
        "A_materno",
        "Edad",
        "Cargo",
        "Contra"
    };

    /**
     * Constantes de la tabla 'movimientos'
     */
    public static final String Movimientos[] = {
        "ID",
        "Dia",
        "Mes",
        "AÑo",
        "Hora",
        "MIn",
        "Seg",
        "Tipo",
        "Usuario"
    };

    //tipos de movimientos
    private static final String[] Tipo_Movimientos = {
        "Inicio de sesion",
        "Cierre de sesion",
        "Realizo una venta",
        "Se hizo una alta en la tabla",
        "Se hizo una baja en la tabla",
        "Se hizo una modificacion en la tabla ",
        "Se hizo una actualizacion en la tabla"
    };

    /**
     * @param i tipo de movimiento
     * @return el movimiento segun el index
     * <br> 0.-"Inicio de sesion"
     * <br> 1.-"Cierre de sesion"
     * <br> 2.-"Realizo una venta",
     * <br> 3.-"alta",
     * <br> 4.-"baja",
     * <br> 5.-"modificacion",
     * <br> 7.-"actualizacion",
     */
    public static String getMovimiento(int i) {
        return Tipo_Movimientos[i];
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
// - - - - - - - - - - - - - - - - - Tiempo - - - - - - - - - - - - - - - - - //
    /**
     * Constantes de los dias de la semana
     */
    public static final String Dias[] = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado"
    };

    /**
     * @param i indice del dia escogido
     * @return el dia de la semana segun el indice
     * <br>0.- domingo
     * <br>1.- lunes
     * <br>2.- martes
     * <br>3.- miercoles
     * <br>4.- jueves
     * <br>5.- viernes
     * <br>6.- sabado
     */
    public static String getDay(int i) {
        return Dias[i - 1];
    }

    /**
     * Constantes de los meses del año
     */
    private static final String meses[] = {
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };

    /**
     * @param i indice del mes escogido
     * @return el mes del año segun el indice
     * <br>0.- Ene
     * <br>1.- Feb
     * <br>2.- Mar
     * <br>3.- Abr
     * <br>4.- May
     * <br>5.- Jun
     * <br>6.- Jul
     * <br>7.- Ago
     * <br>8.- Sep
     * <br>9.- Oct
     * <br>10.- Nov
     * <br>11.- Dic
     */
    public static String getMes(int i) {
        return meses[i];
    }

    /**
     * @param obj Motivo del mensaje
     * @param txt Informacion complemnetaria
     * @param title titulo del mensaje
     * @param i tipo de icono
     * <br>0.- Error
     * <br>1.- Informacion
     * <br>2.- Advertencia
     */
    public static void getMessage(String obj, String txt, String title, int i) {
        JOptionPane.showMessageDialog(null, obj + " " + txt, title, i);
    }

    public static final LineBorder OkBorder = new LineBorder(Color.black);

    public static final LineBorder BadBorder = new LineBorder(Color.red);

}
