package Controlador;

import Modelo.BD;
import Modelo.cons;
import Modelo.Operaciones;
import Modelo.CL_Producto;
import Modelo.func;
import Vista.Vista_MenuAdmin;
import Vista.Vista_Productos;
import Vista.Vista_Productos.Create;
import Vista.Vista_Productos.Read;
import Vista.Vista_Productos.Update;
import Vista.Vista_Productos.Delete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Productos implements ActionListener {

    private final Vista_MenuAdmin admin;
    private final Vista_Productos productos;
    private final Create create;
    private final Read read;
    private final Update update;
    private final Delete delete;
    private String[] values;
    private final Operaciones operaciones;

    public Con_Productos(Vista_Productos productos, Vista_MenuAdmin admin) {
        this.productos = productos;
        this.admin = admin;
        this.create = productos.getCreate();
        this.read = productos.getRead();
        this.update = productos.getUpdate();
        this.delete = productos.getDelete();
        this.operaciones = Operaciones.getNodo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        values = create.values();
        switch (e.getActionCommand()) {
            case "Atras" ->
                Atras();
            case "Cancelar" ->
                Cancelar(e.getSource());
            case "Buscar" ->
                Buscar(e.getSource());
            case "Agregar" ->
                Agregar();
            case "Mostrar" ->
                Buscar(e.getSource());
            case "Actualizar" ->
                Actualizar();
            case "Eliminar" ->
                Borrar();
        }

    }

    public void Atras() {
        productos.dispose();
        admin.setVisible(true);
    }

    public void Cancelar(Object obj) {
        if (obj == create.getJbtCancelar()) {
            create.Empty();
        }
        if (obj == update.getJbtCancelar_2()) {
            update.clear();
            update.clearS();
        }
        if (obj == delete.getJbtCancelar_3()) {
            delete.clear();
        }
    }

    private void Agregar() {
        if (create.isEmpty()) {
            return;
        }
        values[0] = func.getID(values[1], values[3], values[5]);
        CL_Producto p = new CL_Producto(values);
        operaciones.newProducto(p);
        cons.getMessage("El producto " + values[1] + " " + values[3],
                "\nha sido registrado con la clave: " + values[0],
                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        create.Empty();
    }

    public void Buscar(Object obj) {
        if (read.getJbtConsultar() == obj) {
            read.getJtConsultas().setModel(operaciones.getTable("productos"));
        } else if (update.getJbtBuscar() == obj) {
            CL_Producto producto = operaciones.getProducto("*", update.getCampo() + " = '" + BD.IN(update.getValue()) + "'");
            if (producto != null && producto.isExists()) {
                update.setProducto(producto);
            } else {
                cons.getMessage("Este producto", "no existe", "Error", JOptionPane.WARNING_MESSAGE);
            }
            update.clearS();
        } else if (delete.getJbtBuscar_2() == obj) {
            CL_Producto producto = operaciones.getProducto("*", delete.getCampo() + " = " + BD.IN(delete.getValue()));
            if (producto != null && producto.isExists()) {
                delete.setProducto(producto);
            } else {
                cons.getMessage("Este producto", "no existe", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void Actualizar() {
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que desea hacer cambios en los campos?");
        if (opc == JOptionPane.YES_NO_OPTION) {
            operaciones.ActProducto(update.getProducto());
            cons.getMessage("Los campos", "se han actualizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            update.clear();
        }
    }

    public void Borrar() {
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este producto?");
        if (opc == JOptionPane.YES_NO_OPTION) {
            operaciones.BorrarProducto(delete.getProducto());
            delete.clear();
        }
    }

}
