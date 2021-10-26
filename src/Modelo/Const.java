package Modelo;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Const {

    private static final String Productos[] = {
        "ID",
        "Clave",
        "Nombre",
        "Marca",
        "Contenido",
        "UDM",
        "Precio"
    };

    private static final String Usuarios[] = {
        "ID",
        "Usuario",
        "Nombre",
        "A_paterno",
        "A_materno",
        "Edad",
        "Cargo",
        "Contra"
    };

    private static final String Dias[] = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miercoles",
        "Juves",
        "Viernes",
        "Sabado"
    };
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
        "Octubre", "Noviembre", "Diciembre",};

    public static final String UDM[] = {"Lt", "ml", "Kg", "gr"};

    private static final LineBorder OkBorder = new LineBorder(Color.black);

    private static final LineBorder BadBorder = new LineBorder(Color.red);

    public static String[] getProductos() {
        return Productos;
    }

    public static String[] getUsuarios() {
        return Usuarios;
    }

    public static Border getOkBorder() {
        return OkBorder;
    }

    public static Border getBadBorder() {
        return BadBorder;
    }

    public static String[] getUDM() {
        return UDM;
    }

    public static String getDay(int i) {
        return Dias[i - 1];
    }

    public static String getMes(int i) {
        return meses[i];
    }

    public static void getMessage(String obj, String txt) {
        JOptionPane.showMessageDialog(null, obj + " " + txt);
    }

}
