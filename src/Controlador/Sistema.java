package Controlador;

import Modelo.BD;
import Modelo.cons;
import Modelo.Excepciones;
import Modelo.Ficheros;
import Modelo.Operaciones;
import Vista.Vista_Configuracion;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author jp
 */
public class Sistema {

    private static Sistema Nodo;

    public static Sistema getNodo() {
        if (Nodo == null) {
            Nodo = new Sistema();
        }
        return Nodo;
    }

    private BD con;
    private Operaciones opc;
    //
    private Relog NodoRlg;
    //
    private Install NodoIll;

    public Install getNodoIll() {
        if (NodoIll == null) {
            NodoIll = new Install();
        }
        return NodoIll;
    }

    public Relog getNodoRlg() {
        return NodoRlg;
    }

    private Sistema() {

    }

    public void star() {
        con = BD.getNodo("jp", "12345", "jdbc:mysql://localhost/Tienda");
        con.Conectar();
        Operaciones.getNodo(con);
        NodoRlg = new Relog();
        NodoRlg.start();
    }

    public class Install {

        private Ficheros fch;

        public Install() {
            this.fch = new Ficheros();
        }

        public void Install(String user, String pass, String url) {
            crearRutas();
            crearUsuario(user, pass, url);
        }

        private void crearRutas() {
            fch.crearCarpeta(cons.URL_DICS);
            fch.crearCarpeta(cons.URL_FILES);
            fch.crearCarpeta(cons.URL_SQL);
            fch.crearCarpeta(cons.URL_HT);
            fch.crearCarpeta(cons.URL_RP);
        }

        private void crearUsuario(String user, String pass, String url) {
            try {
                String bd = fch.crearArchivo(cons.URL_SQL, "usuario.jshop");
                String i = fch.crearArchivo(cons.URL_SQL, "Install.jshop");
                fch.escribirArchivo(bd, user + "-" + pass + "-" + url);
            } catch (IOException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public class Relog extends Thread {

        public JLabel jlbRelog, jlbFecha;
        //
        private String relog, fecha;
        //
        private Calendar cl;
        //conexion a la base de datos

        private Relog() {
            this.jlbFecha = null;
            this.jlbRelog = null;
            this.relog = "";
            this.fecha = "";
            this.cl = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        }

        @Override
        public void run() {
            try {
                while (true) {
                    cl = Calendar.getInstance();
                    relog();
                    fecha();
                    if (false) {
                        cons.getMessage("El sistema", "ha cerrado", "Mensaje del Sistema", 0);
                        throw new Excepciones(Excepciones.getMensaje(1));
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException | Excepciones e) {
                System.out.println("Error en el sistema");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Fin");
            }
        }

        public void setRelog(JLabel relog) {
            this.jlbRelog = relog;
        }

        public void setFecha(JLabel fecha) {
            this.jlbFecha = fecha;
        }

        public void relog() {
            relog = cl.get(Calendar.HOUR) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND);
            if (cl.get(Calendar.HOUR_OF_DAY) > 11) {
                relog += " PM";
            } else {
                relog += " AM";
            }
            if (jlbRelog != null) {
                jlbRelog.setText(relog);
            }
        }

        public void fecha() {
            fecha = cons.getDay(cl.get(Calendar.DAY_OF_WEEK)) + cl.get(Calendar.DAY_OF_MONTH) + "/" + cons.getMes(cl.get(Calendar.MONTH)) + "/" + cl.get(Calendar.YEAR);
            if (jlbFecha != null) {
                jlbFecha.setText(fecha);
            }
        }

        public boolean abrir() {
            return cl.get(Calendar.HOUR_OF_DAY) > 6 && cl.get(Calendar.HOUR_OF_DAY) < 23;
        }

        public Calendar getCl() {
            return cl;
        }

    }

}
