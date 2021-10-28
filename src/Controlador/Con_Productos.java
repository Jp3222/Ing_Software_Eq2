package Controlador;

import Modelo.BD;
import Modelo.Operaciones;
import Modelo.func;
import Vista.Vista_MenuAdmin;
import Vista.Vista_Productos;
import Vista.Vista_Productos.Create;
import Vista.Vista_Productos.Read;
import Vista.Vista_Productos.Update;
import Vista.Vista_Productos.Delete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Con_Productos implements ActionListener {

    private final Vista_MenuAdmin admin;
    private final Vista_Productos productos;
    private Create create;
    private Read read;
    private Update update;
    private Delete delete;
    private String[] values;
    private final BD conexion;
    private final Operaciones operaciones;

    public Con_Productos(Vista_Productos productos, Vista_MenuAdmin admin) {
        this.productos = productos;
        this.admin = admin;
        this.create = productos.getCreate();
        this.read = productos.getRead();
        this.update = productos.getUpdate();
        this.delete = productos.getDelete();
        this.conexion = BD.getNodo();
        this.operaciones = new Operaciones(conexion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        values = create.values();
        switch (e.getActionCommand()) {
            case "Atras" ->
                Atras();
            case "Cancelar" ->
                Cancelar(e.getSource());
            case "Buscar" ->
                Buscar(e.getSource());
            case "Generar Clave" ->
                key();
            case "Agregar" ->
                Agregar();
            case "Mostrar" ->
                Buscar(e.getSource());
        }

    }

    public void Atras() {
        productos.dispose();
        admin.setVisible(true);
    }

    public void Cancelar(Object obj) {
        if (create.getJbtCancelar() == obj) {
            create.Empty();
        } else if (true) {

        }
    }

    private void Agregar() {
        if (create.isEmpty()) {
            return;
        }
        key();
        operaciones.createProducto(BD.getValues(true, values));
        create.Empty();
    }

    private void key() {
        if (!create.isEmpty() && values[0].equals("NA")) {
            values[0] = func.getID(values[1], values[3], values[5]);
            create.getJtfClave().setText(values[0]);
        } else {
            System.out.println("Clave generada");
        }
    }

    public void Buscar(Object obj) {
        if (read.getJbtConsultar() == obj) {
            read.getJtConsultas().setModel(operaciones.Tabla("Productos"));
        } else {
        }
    }

    public void Actualizar() {

    }

    public void Borrar() {
    }

}
