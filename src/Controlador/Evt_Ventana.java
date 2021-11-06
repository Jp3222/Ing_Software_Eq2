package Controlador;

import Modelo.BD;
import Modelo.CL_Empleado;
import Modelo.CL_Movimiento;
import Modelo.Operaciones;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author jp
 */
public class Evt_Ventana implements WindowListener {

    private static Evt_Ventana Nodo;

    public static Evt_Ventana getNodo() {
        if (Nodo == null) {
            Nodo = new Evt_Ventana();
        }
        return Nodo;
    }

    private final BD bd;
    private final Operaciones op;
    private final Sistema sis;
    private CL_Empleado em;

    private Evt_Ventana() {
        bd = BD.getNodo();
        op = new Operaciones(bd);
        sis = Sistema.getNodo();
    }

    public void setEm(CL_Empleado em) {
        this.em = em;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        //CL_Movimiento mov = new CL_Movimiento(sis.getCl(), "Cierre del sistema", em.getUsuario());
        //op.setMovimiento(mov);
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
   
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //bd.Conectar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //bd.desConectar();
    }

}
