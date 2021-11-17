package Controlador;

import Modelo.CL_Empleado;
import Modelo.Operaciones;
import Modelo.cons;
import Vista.Vista_Empleados;
import Vista.Vista_Empleados.Create;
import Vista.Vista_Empleados.Read;
import Vista.Vista_Empleados.Update;
import Vista.Vista_Empleados.Delete;
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
    private Delete delete;
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
        this.delete = empleado.getDelete();
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
            case "Buscar","buscar" ->
                buscar(e.getSource());
            case "Remover" ->
                Borrar();
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
            if (update.getJtfValue().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }
            CL_Empleado cl = opc.getEmpleado(update.getJtfValue());
            if (cl == null) {
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Advertencia", JOptionPane.ERROR_MESSAGE);
            } else {
                update.setEmpleado(cl);
                update.clear2();
            }
        } else if (delete.getJbtBuscar_2() == obj) {
            if (delete.getValue().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Advertencia", JOptionPane.ERROR_MESSAGE);
                return;
            }
            CL_Empleado cl = opc.getEmpleado(delete.getValue());
            delete.setEmpleado(cl);
            if (cl == null) {
                JOptionPane.showMessageDialog(null, "Usuario No Encontrado", "Advertencia", JOptionPane.ERROR_MESSAGE);
            } else {
                delete.setEmpleado(cl);
                delete.clear();
            }

        }
    }

    private void ActualizarTB() {
        read.setModelo(opc.getTable("empleados"));
    }

    private void Actualizar() {
        if (update.getEmpleado() == null) {
            JOptionPane.showMessageDialog(null, "Objeto invalido", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return;
        }
        opc.actEmpleado(update.getEmpleado());
        update.clear();
    }

    private void Borrar() {
        CL_Empleado cl = delete.getEmpleado();
        if (cl == null) {
            cons.getMessage("No es posible realizar estaccion", "", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return;
        }
        opc.brEmpleado(cl);
        delete.clear();
        cons.getMessage("El empleado: ",
                cl.getNombre() + " " + cl.getA_paterno() + " " + cl.getA_materno() + "Ha sido eliminado",
                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

}
