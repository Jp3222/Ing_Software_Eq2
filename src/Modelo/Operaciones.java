package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Operaciones {

    private final BD conexion;
    private ResultSet rs;
    private final String campos[] = Const.getUsuarios();

    public Operaciones(BD conexion) {
        this.conexion = conexion;
    }

    @SuppressWarnings("FinallyDiscardsException")
    public Empleado getEmpleado(String usuario) throws Excepciones, SQLException {
        Empleado obj = new Empleado();
        rs = conexion.Buscar(usuario, 1);
        if (rs.next()) {
            obj.setExists(true);
            String info[] = new String[campos.length];
            for (int i = 0; i < info.length; i++) {
                info[i] = "" + rs.getString(campos[i]);
            }
            obj.setInfo(info);
            return obj;
        }
        throw new Excepciones(Excepciones.getMensaje(15));
    }

    public void createProducto(String values) {
        try {
            conexion.Insertar("Productos", BD.getColums(func.exp(Const.getProductos(), 0)), values);
            Const.getMessage("El producto", "se ha agregado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultTableModel Tabla(String Table) {
        DefaultTableModel obj = new DefaultTableModel();
        try {
            for (String campo : Const.getProductos()) {
                obj.addColumn(campo);
            }
            String x[] = new String[Const.getProductos().length];
            ResultSet r = conexion.Buscar(Table);
            Calendar c = Calendar.getInstance();
         
            while (r.next()) {
                int i = 0;
                for (String campo : Const.getProductos()) {
                    x[i] = r.getString(campo);
                    x[i] = BD.OUT(x[i]);
                    i++;
                }
                System.out.println("obj");
                obj.addRow(x);
            }
            System.out.println("xd");
            return obj;
        } catch (SQLException ex) {
            System.out.println("error");
            ex.printStackTrace();
        } finally {
            return obj;
        }
    }

}
