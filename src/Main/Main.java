package Main;

import javax.swing.SwingUtilities;
import Controlador.Sistema;
import Modelo.Ficheros;
import Modelo.cons;
import Vista.Vista_Configuracion;
import Vista.Vista_Login;

/**
 *
 * @author jp
 */
public class Main {

    public static void main(String[] args) {
        //Arranque de un hilo independiente
        SwingUtilities.invokeLater(() -> Star());
    }

    /**
     * Metodo de activacion del sistema
     */
    public static void Star() {
        Ficheros ft = new Ficheros();
        Sistema so = Sistema.getNodo();
        if (!ft.Exists(cons.url(1)+"/Install.jshop")) {
            Vista_Configuracion vc = new Vista_Configuracion();
            vc.setVisible(true);
        } else {
            so.star();
            Vista_Login log = new Vista_Login();

            log.setVisible(true);
        }

    }
}
