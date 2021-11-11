package Controlador;

import Modelo.BD;
import Modelo.Operaciones;
import Vista.Vista_Empleados;
import Vista.Vista_Info;
import Vista.Vista_MenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jp
 */
public class Con_Empleado implements ActionListener {

    //
    private Vista_Empleados empleado;
    //
    private Vista_MenuAdmin admin;
    private Vista_Info info;
    //
    BD conexion = BD.getNodo();
    Operaciones opc;

    public Con_Empleado(Vista_Empleados empleado) {
        this.empleado = empleado;
        opc = new Operaciones(conexion);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Atras" ->
                Atras();
        }
    }

    public void Atras() {
        empleado.dispose();
        admin.setVisible(true);
    }

    public void setAdmin(Vista_MenuAdmin admin) {
        this.admin = admin;
    }

    public void setInfo(Vista_Info info) {
        this.info = info;
    }

}
