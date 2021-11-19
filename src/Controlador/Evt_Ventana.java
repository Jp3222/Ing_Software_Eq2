package Controlador;

import Modelo.CL_Empleado;
import Modelo.CL_Movimiento;
import Modelo.Operaciones;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author jp
 */
public class Evt_Ventana extends WindowAdapter {

    private static Evt_Ventana Nodo;

    public static Evt_Ventana getNodo() {
        if (Nodo == null) {
            Nodo = new Evt_Ventana();
        }
        return Nodo;
    }

    private final Operaciones op;
    private final Sistema sis;
    private CL_Empleado em;

    private Evt_Ventana() {
        op = Operaciones.getNodo();
        sis = Sistema.getNodo();
    }

    public void setEm(CL_Empleado em) {
        this.em = em;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (em != null) {
            CL_Movimiento mov = new CL_Movimiento(sis.getNodoRlg().getCl(), "Cierre del sistema", em.getUsuario());
            op.setMovimiento(mov);
        }
        System.exit(0);
    }

}
