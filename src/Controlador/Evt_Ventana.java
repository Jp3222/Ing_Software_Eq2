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

    private final Operaciones operaciones;
    private final Sistema sistema;
    private CL_Empleado empleado;

    private Evt_Ventana() {
        operaciones = Operaciones.getNodo();
        sistema = Sistema.getNodo();
        empleado = sistema.getSistemUser();
    }


    @Override
    public void windowClosing(WindowEvent e) {
        if (empleado != null) {
            CL_Movimiento mov = new CL_Movimiento(
                    sistema.getNodoRlg().getCl(),
                    "Cierre del sistema",
                    empleado.getUsuario()
            );
            operaciones.setMovimiento(mov);
        }
        System.exit(0);
    }

}
