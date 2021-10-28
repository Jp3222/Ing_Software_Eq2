package Main;

import Controlador.Sistema;
import javax.swing.SwingUtilities;
import Vista.Vista_Login;
import Modelo.BD;
import Modelo.Excepciones;

/**
 *
 * @author jp
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, Excepciones {
        //
        SwingUtilities.invokeLater(() -> Star());
    }
    /**
     * Metodo de activacion del sistema
     */
    public static void Star() {
        //Inicio del Hilo del sistema
        Sistema cr = Sistema.getNodo();
        cr.start();
        //Conexion a la base de datos
        BD conexion = BD.getNodo("jp", "LANIXLX6", "jdbc:mysql://localhost/Tienda");
        conexion.Conectar();
        Vista_Login v = new Vista_Login();
        v.setVisible(true);
    }

}
