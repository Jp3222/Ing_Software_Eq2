package Controlador;

import Modelo.BD;
import Modelo.Const;
import Modelo.Excepciones;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JLabel;

/**
 *
 * @author jp
 */
public class Sistema extends Thread {

    private static Sistema Nodo;

    public static Sistema getNodo() {
        if (Nodo == null) {
            Nodo = new Sistema();
        }
        return Nodo;
    }
    public JLabel jlbRelog, jlbFecha;
    private String relog, fecha;
    private Calendar cl;
    private HashMap<Integer, JLabel> relogs;

    private Sistema() {
        //this.jlbRelog = null;
        this.jlbFecha = null;
        this.relog = "";
        this.fecha = "";
        this.cl = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        this.relogs = new HashMap<>();
    }

    @Override
    public void run() {

        try {
            while (true) {
                cl = Calendar.getInstance();
                relog();
                fecha();
                if (false) {
                    Const.getMessage("El sistema", "ha cerrado");
                    throw new Excepciones(Excepciones.getMensaje(1));
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getCause().getMessage());
        } catch (Excepciones ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
            BD.getNodo().desConectar();
        } finally {
            System.out.println("Fin");
        }
    }

    public void addRelog(int i, JLabel relog) {
        jlbRelog = relog;
    }

    public void relog() {
        relog = cl.get(Calendar.HOUR) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND);
        if (cl.get(Calendar.HOUR_OF_DAY) > 11) {
            relog += " PM";
        } else {
            relog += " AM";
        }
        System.out.println(relog);
        if (jlbRelog != null) {
            jlbRelog.setText(relog);
        }
    }

public void fecha() {
        fecha = Const.getDay(cl.get(Calendar.DAY_OF_WEEK)) + cl.get(Calendar.DAY_OF_MONTH) + "/" + Const.getMes(cl.get(Calendar.MONTH)) + "/" + cl.get(Calendar.YEAR);
        if (jlbFecha != null) {
            jlbFecha.setText(fecha);
        }
    }

    public boolean abrir() {
        return cl.get(Calendar.HOUR_OF_DAY) > 6 && cl.get(Calendar.HOUR_OF_DAY) < 23;
    }

    public void setJlbFecha(JLabel jlbFecha) {
        this.jlbFecha = jlbFecha;
    }

    public String getDate() {
        return cl.get(Calendar.YEAR) + "-" + cl.get(Calendar.MONTH) + "-" + cl.get(Calendar.DAY_OF_MONTH) + " "
                + cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND) + "";
    }
}
