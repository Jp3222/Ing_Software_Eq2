package Main;

import Controlador.Con_Relog;
import javax.swing.SwingUtilities;
import Vista.Vista_Login;
import Modelo.BD;
import Modelo.Operaciones;
import Modelo.func;
import javax.swing.SwingConstants;

/**
 *
 * @author jp
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> Star());
    }

    public static void Star() {
        BD conexion = BD.getNodo("jp", "LANIXLX6", "jdbc:mysql://localhost/Tienda");
        Con_Relog cr = Con_Relog.getNodo();
        cr.start();
        Vista_Login v = new Vista_Login();
        v.setVisible(true);
    }

}
