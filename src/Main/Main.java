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
        SwingUtilities.invokeLater(() -> Star());
    }

    public static void Star() {
        BD conexion = BD.getNodo("jp", "LANIXLX6", "jdbc:mysql://localhost/Tienda");
        Sistema cr = Sistema.getNodo();
        cr.start();
        Vista_Login v = new Vista_Login();
        v.setVisible(true);
    }

}
