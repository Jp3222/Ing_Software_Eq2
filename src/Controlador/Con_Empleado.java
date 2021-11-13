package Controlador;

import Modelo.BD;
import Modelo.Operaciones;
import Modelo.cons;
import Vista.Vista_Empleados;
import Vista.Vista_Empleados.Create;
import Vista.Vista_Empleados.Read;
import Vista.Vista_Empleados.Update;
import Vista.Vista_Info;
import Vista.Vista_MenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Empleado implements ActionListener {

    //
    private Vista_Empleados empleado;
    private Create create;
    private Read read;
    private Update update;
    //
    private Vista_MenuAdmin admin;
    private Vista_Info info;
    //
    Operaciones opc;

    public Con_Empleado(Vista_Empleados empleado) {
        this.empleado = empleado;
        this.create = empleado.getCreate();
        this.read = empleado.getRead();
        this.update = empleado.getUpdate();
        opc = Operaciones.getNodo();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Atras" ->
                Atras();
            case "Agregar" ->
                Agregar();
            case "Actualizar" ->
                Actualizar();
            case "Actualizar Tabla" ->
                ActualizarTB();

        }
    }

    public void Atras() {
        empleado.dispose();
        admin.setVisible(true);
    }

    public void Agregar() {
        if (create.isEmpty()) {
            return;
        }
        opc.newEmpleado(create.getEmpleado());
        cons.getMessage("Registro", "Exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        create.clear();
    }

    public void setAdmin(Vista_MenuAdmin admin) {
        this.admin = admin;
    }

    public void setInfo(Vista_Info info) {
        this.info = info;
    }

    public void buscar(Object obj) {
        if (update.getJbtBuscar() == obj) {
            update.setEmpleado(opc.getEmpleado(update.getJtfValue()));
        }
    }

    private void ActualizarTB() {
        read.setModelo(opc.getTable("empleados"));
    }

    private void Actualizar() {

    }

}
