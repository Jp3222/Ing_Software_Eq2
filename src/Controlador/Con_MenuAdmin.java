package Controlador;

import Modelo.BD;
import Modelo.CL_Empleado;
import Modelo.CL_Producto;
import Modelo.Operaciones;
import Modelo.cons;
import Modelo.func;
import Vista.Vista_Empleados;
import Vista.Vista_Administracion;
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;
import Vista.Vista_Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Con_MenuAdmin implements ActionListener {

    private Vista_MenuAdmin admin;
    private Vista_Login login;
    //
    private Vista_Productos productos;
    private Vista_Administracion administracion;
    private Vista_Empleados empleados;
    //
    private final BD conexion = BD.getNodo();
    private final Operaciones opc = new Operaciones(conexion);

    public Con_MenuAdmin(Vista_MenuAdmin admin) {
        this.admin = admin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Agregar" ->
                Agregar();
            case "Quitar" ->
                Quitar();
            case "Buscar" ->
                Buscar();
            case "Perfil" ->
                Perfil();
            case "Empleados" ->
                Empleados();
            case "Productos" ->
                Productos();
            case "Administracion" ->
                Administracion();
            case "Cerrar Sesion" ->
                Cerrar_Sesion();
        }
    }

    public void Agregar() {
        addCarrito((DefaultTableModel) admin.getJtbCarrito().getModel());
    }

    public void addCarrito(DefaultTableModel tb) {
        tb.addRow(
                func.getArray(
                        admin.getClave(),
                        admin.getNombre(),
                        admin.getContenido(),
                        admin.getPiezas() + "",
                        (admin.getPrecio() * admin.getPiezas()) + ""
                ));
    }

    public void Quitar() {
        removeCarrito((DefaultTableModel) admin.getJtbCarrito().getModel());
    }

    public void removeCarrito(DefaultTableModel tb) {
        if (tb.getRowCount() > 0) {
            tb.removeRow(tb.getRowCount() - 1);
        } else {
            cons.getMessage("NO hay productos", "en el carrito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void Buscar() {
        CL_Producto producto = opc.getProducto("*", admin.getCampo() + " = '" + admin.getValue() + "'");
        if (producto != null) {
            admin.setProducto(producto);
        } else {
            cons.getMessage("El producto: " + admin.getValue(), "NO existe", "mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void Perfil() {
        System.out.println("perfil");
    }

    public void Empleados() {
        admin.dispose();
        empleados.setVisible(true);

    }

    public void Productos() {
        admin.dispose();
        productos.setVisible(true);
    }

    public void Administracion() {
        admin.dispose();
        administracion.setVisible(true);
    }

    public void Cerrar_Sesion() {
        admin.dispose();
        login.setVisible(true);
    }

    public void setAdministracion(Vista_Administracion administracion) {
        this.administracion = administracion;
    }

    public void setEmpleados(Vista_Empleados empleados) {
        this.empleados = empleados;
    }

    public void setProductos(Vista_Productos productos) {
        this.productos = productos;
    }

    public void setAdmin(Vista_MenuAdmin admin) {
        this.admin = admin;
    }

    public void setLogin(Vista_Login login) {
        this.login = login;
    }

}
