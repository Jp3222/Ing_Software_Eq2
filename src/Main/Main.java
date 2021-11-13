package Main;

import javax.swing.SwingUtilities;
import Controlador.Sistema.Install;
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
        Sistema st = Sistema.getNodo();
        Ficheros ft;
        ft = new Ficheros();
        if (!ft.Exists(cons.URL_SQL + "/Install.jshop")) {
            Install ill = st.getNodoIll();
            Vista_Configuracion conf = new Vista_Configuracion();
            conf.setVisible(true);
            ill.Install(conf.getUser(), conf.getPass(), conf.getUrl());
            Star();
        } else {
            st.star();
            Vista_Login log = new Vista_Login();
            log.setVisible(true);
        }
    }
}
