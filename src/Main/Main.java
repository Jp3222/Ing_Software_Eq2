package Main;

import Controlador.Sistema;
import javax.swing.SwingUtilities;
import Vista.Vista_Login;
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
        Vista_Login v = new Vista_Login();
        v.setVisible(true);
    }

}
