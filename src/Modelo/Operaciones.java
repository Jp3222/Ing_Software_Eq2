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
                    info[i] = rs.getString(producto1);
                    i++;
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
            conexion.Insertar("productos",
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

    public void setMovimiento(Movimiento mov) {
        try {
            conexion.Insertar("movimientos",
                    BD.getColums(func.exp(Const.getMovimientos(), 0)),
                    BD.getValues(true, mov.getInfo()));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //
    public DefaultTableModel getTable(String nom) {
        DefaultTableModel tm = new DefaultTableModel();
        try {
            
            for (String colm : Const.getProductos()) {
                tm.addColumn(colm);
            }

            rs = conexion.Buscar(nom);
            String[] aux = new String[Const.getProductos().length];
            int i;
            while (rs.next()) {
                i = 0;
                for (String value : Const.getProductos()) {
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
