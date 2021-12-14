package Controlador;

import Modelo.BD;
import Modelo.CL_Empleado;
import Modelo.CL_Movimiento;
import Modelo.cons;
import Modelo.Excepciones;
import Modelo.Ficheros;
import Modelo.Operaciones;
import Modelo.Reportes;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
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

    public static void setNodo(Sistema Nodo) {
        Sistema.Nodo = Nodo;
    }

    private BD con;
    private Operaciones opc;
    private Relog NodoRlg;
    private Install NodoIll;
    private final Ficheros fc;
    private CL_Empleado SistemUser;

    private Sistema() {
        fc = new Ficheros();
    }

    public void star() {
        //Lectura del archivo 
        String sql[] = fc.leer(cons.url(1) + "/Usuario.jshop").split("-");
        //Inicializacion del drive
        con = BD.getNodo(sql[0], sql[1], sql[2]);
        //Establecer Conexion 
        con.Conectar();
        //Iniciar operaciones
        opc = Operaciones.getNodo(con);
        //Inicializacion del relog
        NodoRlg = new Relog();
        NodoRlg.start();
    }

    public CL_Empleado getSistemUser() {
        return SistemUser;
    }

    public void setSistemUser(CL_Empleado SistemUser) {
        this.SistemUser = SistemUser;
    }

    public Relog getNodoRlg() {
        return NodoRlg;
    }

    public Install getNodoIll() {
        if (NodoIll == null) {
            NodoIll = new Install();
        }
        return NodoIll;
    }

    public class Install {

        private final Ficheros fch;

        public Install() {
            this.fch = new Ficheros();
        }

        public void Install(String user, String pass, String url) {
            crearRutas();
            crearUsuario(user, pass, url);
        }

        private void crearRutas() {
            fch.crearCarpeta(cons.url(4));
            fch.crearCarpeta(cons.url(1));
            fch.crearCarpeta(cons.url(2));
            fch.crearCarpeta(cons.url(3));
        }

        private void crearUsuario(String user, String pass, String url) {
            try {
                String bd = fch.crearArchivo(cons.url(1), "Usuario.jshop");
                String i = fch.crearArchivo(cons.url(1), "Install.jshop");
                fch.escribirArchivo(bd, user + "-" + pass + "-" + url);
                fch.escribirArchivo(i, "Archivo de comprobante de instalacion");
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
        @SuppressWarnings("SleepWhileInLoop")
        public void run() {
            Timers();
            try {
                while (true) {
                    cl = Calendar.getInstance();
                    relog();
                    fecha();
                    if (!abrir()) {
                        cons.getMessage("El sistema", "ha cerrado", "Mensaje del Sistema", 0);
                        System.exit(1);
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
            relog = cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND);
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

        public String getFecha() {
            return cl.get(Calendar.DAY_OF_MONTH) + "" + (cl.get(Calendar.MONTH) + 1) + "" + cl.get(Calendar.YEAR);
        }

        public String getRelog() {
            return cl.get(Calendar.HOUR_OF_DAY) + "" + cl.get(Calendar.MINUTE) + "" + cl.get(Calendar.SECOND);
        }

        public void Timers() {
            Tareas obj = new Tareas();
            Calendar cls = Calendar.getInstance();
            cls.set(Calendar.YEAR, cls.get(Calendar.YEAR));
            cls.set(Calendar.MONTH, cls.get(Calendar.MONTH));
            cls.set(Calendar.DAY_OF_WEEK, cls.get(Calendar.DAY_OF_WEEK));
            cls.set(Calendar.HOUR_OF_DAY, 21);
            cls.set(Calendar.MINUTE, 59);
            cls.set(Calendar.SECOND, 0);
            cls.set(Calendar.MILLISECOND, 0);
            Timer t = new Timer();
            t.schedule(obj, cls.getTime());
            t.purge();

        }

        class Tareas extends TimerTask {

            @Override
            public void run() {
                Historial();
            }

            /**
             *
             */
            private void Historial() {
                try {
                    CL_Movimiento mov = new CL_Movimiento(cl, "Reporte Historial", "root");
                    opc.setMovimiento(mov);
                    Reportes r = new Reportes(2, "Historial de Hoy");
                    r.crearReporte("movimientos", cons.Movimientos);
                    //
                    BD.getNodo().Vaciar("movimientos");
                } catch (SQLException | FileNotFoundException | DocumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }

    }

}
