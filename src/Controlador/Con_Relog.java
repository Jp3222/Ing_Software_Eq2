package Controlador;

import Modelo.Const;
import Modelo.Excepciones;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Relog extends Thread {

    private static Con_Relog Nodo;
    private static Calendar cl;
    private JLabel lblRelog;
    private int hora, min, seg;
    private String txt;

    public static Con_Relog getNodo() {
        if (Nodo == null) {
            Nodo = new Con_Relog();
        }
        return Nodo;
    }

    private Con_Relog() {
        this.hora = 0;
        this.min = 0;
        this.seg = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cl = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                hora = cl.get(Calendar.HOUR);
                min = cl.get(Calendar.MINUTE);
                seg = cl.get(Calendar.SECOND);
                if (cl.get(Calendar.HOUR_OF_DAY) < 12) {
                    txt = hora + " : " + min + " : " + seg + " AM ";
                } else {
                    txt = hora + " : " + min + " : " + seg + " PM";
                }
                if (lblRelog != null) {
                    lblRelog.setText(txt);
                }
                Thread.sleep(1000);
                if (abrir()) {
                    Const.getMessage("El sistema", "ha cerrado");
                    throw new Excepciones(Excepciones.getMensaje(1));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getCause().getMessage());
        } catch (Excepciones ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        } finally {
            System.out.println("Fin");
        }
    }

    public boolean abrir() {
        return cl.get(Calendar.HOUR_OF_DAY) > 6 && cl.get(Calendar.HOUR_OF_DAY) < 23;
    }

    public void setLblRelog(JLabel lblRelog) {
        this.lblRelog = lblRelog;
    }

}
