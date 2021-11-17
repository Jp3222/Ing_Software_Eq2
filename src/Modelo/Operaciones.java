package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Operaciones {

    private static Operaciones Nodo;

    public static Operaciones getNodo(BD conexion) {
        if (Nodo == null) {
            Nodo = new Operaciones(conexion);
        }
        return Nodo;
    }

    public static Operaciones getNodo() {
        return Nodo;
    }

    private final BD conexion;
    private ResultSet rs;

    private Operaciones(BD conexion) {
        this.conexion = conexion;
    }

    //Productos
    public CL_Producto getProducto(String campo, String where) {
        CL_Producto producto = null;
        try {
            rs = conexion.Buscar("productos", campo, where);
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
            conexion.BuscarClose();
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
                    BD.getValues(true, func.exp(producto.getInfo(), 0)));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ActProducto(CL_Producto producto) {
        try {
            conexion.Update("productos", BD.getData(
                    func.exp(cons.getProductos(), 0, 1), func.exp(producto.getInfo(), 0, 1)),
                    "id = '" + producto.getID() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BorrarProducto(CL_Producto producto) {
        try {
            conexion.Delete("productos", "id = '" + producto.getID() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Operaciones para el manejo de empleados
    /**
     * @param user
     * @return
     */
    public CL_Empleado getEmpleado(String user) {
        CL_Empleado empleado = null;
        String values[];
        try {
            rs = conexion.Buscar(user, 1);
            if (rs.next()) {
                empleado = new CL_Empleado();
                empleado.setExists(true);
                int i = 0;
                values = new String[cons.getUsuarios().length];
                for (String colums : cons.getUsuarios()) {
                    values[i] = rs.getString(colums);
                    i++;
                }
                empleado.setInfo(values);
                conexion.BuscarClose();
            }
            rs.close();
        } catch (Excepciones | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            values = null;
        }
        return empleado;
    }

    public void newEmpleado(CL_Empleado empleado) {
        try {
            conexion.Insertar("empleados",
                    BD.getColums(func.exp(cons.getUsuarios(), 0)),
                    BD.getValues(false, func.exp(empleado.getInfo(), 0))
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actEmpleado(CL_Empleado empleado) {

        try {
            conexion.Update("empleados", BD.getData(
                    func.exp(cons.getUsuarios(), 0, 1), func.exp(empleado.getInfo(), 0, 1)),
                    "id = '" + empleado + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void brEmpleado(CL_Empleado empleado) {
        try {
            conexion.Delete("empleados", "id = " + empleado.getID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //Operaciones para el manejo de movimientos
    public void setMovimiento(CL_Movimiento mov) {
        try {
            conexion.Insertar("movimientos",
                    BD.getColums(func.exp(cons.getMovimientos(), 0)),
                    BD.getValues(true, mov.getInfo()));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Operaciones para el manejo de la base de datos general
    public DefaultTableModel getTable(String nom) {
        DefaultTableModel tm = new DefaultTableModel();
        try {
            String array[] = new String[1];
            switch (nom) {
                case "productos" ->
                    array = cons.getProductos();
                case "empleados" ->
                    array = cons.getUsuarios();
            }
            for (String colm : array) {
                tm.addColumn(colm);

            }
            rs = conexion.Buscar(nom);
            String[] aux = new String[array.length];
            int i;
            while (rs.next()) {
                i = 0;
                for (String value : array) {
                    aux[i] = rs.getString(value);
                    i++;
                }
                tm.addRow(aux);
            }
            rs.close();
            conexion.BuscarClose();
            return tm;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
