package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Operaciones {

    private final BD conexion;
    private ResultSet rs;

    public Operaciones(BD conexion) {
        this.conexion = conexion;
    }

    //Productos
    public Producto getProducto(String obj, int opc) {
        Producto producto = null;
        try {
            switch (opc) {
                case 0:
                    rs = conexion.Buscar("Producto", "*", "id = " + obj);
                    break;
                case 1:
                    rs = conexion.Buscar(obj, 2);
                    break;
                case 2:
                    rs = conexion.Buscar("Producto", "*", "nombre = " + obj);
                    break;
                default:
                    System.out.println("NO valido");
            }
            producto = new Producto();
            if (rs.next()) {
                producto.setExists(true);
                String[] info = new String[Const.getProductos().length];
                int i = 0;
                for (String producto1 : Const.getProductos()) {
                    info[0] = rs.getString(producto1);
                }
                producto.setInfo(info);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Excepciones ex) {
            System.out.println(ex.getMessage());
        } finally {
            return producto;
        }
    }

    public void newProducto(Producto producto) {
        try {
            conexion.Insertar("Productos",
                    BD.getColums(func.exp(Const.getProductos(), 0)),
                    BD.getValues(true, producto.getInfo()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Empleados
    public Empleado getEmpleado(String user) {
        Empleado empleado = null;
        try {
            rs = conexion.Buscar(user, 1);
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setExists(true);
                String info[] = new String[Const.getUsuarios().length];
                int i = 0;
                for (String usuario : Const.getUsuarios()) {
                    info[i] = rs.getString(usuario);
                    i++;
                }
                empleado.setInfo(info);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
        } finally {
            return empleado;
        }
    }

    public void newEmpleado(Empleado obj) {
        try {
            conexion.Insertar("Empleado",
                    BD.getColums(func.exp(Const.getUsuarios(), 0)),
                    BD.getValues(true, obj.getInfo())
            );
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //BD
//    public DefaultTableModel Tabla(String[] campos) {
//        DefaultTableModel obj = new DefaultTableModel();
//        
//        for (String producto : campos) {
//            obj.addColumn(producto);
//        }
//        
//        String[] filas=new String[campos.length];
//    }
}
