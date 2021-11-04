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
    public CL_Producto getProducto(String campos, String where) {
        CL_Producto producto = null;
        try {
            rs = conexion.Buscar("productos", campos, where);
            if (rs.next()) {
                producto = new CL_Producto();
                producto.setExists(true);
                String[] info = new String[cons.getProductos().length];
                int i = 0;
                for (String producto1 : cons.getProductos()) {
                    info[i] = rs.getString(producto1);
                    i++;
                }
                producto.setInfo(info);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        }
        return producto;
    }

    public void newProducto(CL_Producto producto) {
        try {
            conexion.Insertar("productos",
                    BD.getColums(func.exp(cons.getProductos(), 0)),
                    BD.getValues(true, producto.getInfo()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Empleados
    public CL_Empleado getEmpleado(String user) {
        CL_Empleado empleado = null;
        try {
            rs = conexion.Buscar(user, 1);
            if (rs.next()) {
                empleado = new CL_Empleado();
                empleado.setExists(true);
                String info[] = new String[cons.getUsuarios().length];
                int i = 0;
                for (String usuario : cons.getUsuarios()) {
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

    public void newEmpleado(CL_Empleado obj) {
        try {
            conexion.Insertar("Empleado",
                    BD.getColums(func.exp(cons.getUsuarios(), 0)),
                    BD.getValues(true, obj.getInfo())
            );
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMovimiento(CL_Movimiento mov) {
        try {
            conexion.Insertar("movimientos",
                    BD.getColums(func.exp(cons.getMovimientos(), 0)),
                    BD.getValues(true, mov.getInfo()));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //
    public DefaultTableModel getTable(String nom) {
        DefaultTableModel tm = new DefaultTableModel();
        try {

            for (String colm : cons.getProductos()) {
                tm.addColumn(colm);
            }

            rs = conexion.Buscar(nom);
            String[] aux = new String[cons.getProductos().length];
            int i;
            while (rs.next()) {
                i = 0;
                for (String value : cons.getProductos()) {
                    aux[i] = rs.getString(value);
                    i++;
                }
                tm.addRow(aux);
            }
            return tm;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
