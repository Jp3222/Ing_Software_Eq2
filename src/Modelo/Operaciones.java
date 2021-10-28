package Modelo;

import Controlador.Sistema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Operaciones {
    
    private final BD conexion;
    private ResultSet rs;
    private final String campos[] = Const.getUsuarios();
    
    public Operaciones(BD conexion) {
        this.conexion = conexion;
    }
    
    public void Movimientos(String tipo, String usuario) {
        try {
            conexion.Insertar("Movimientos", BD.getColums(func.exp(Const.getMovimientos(), 0)), BD.getValues(false, Sistema.getNodo().getDate(), tipo, usuario));
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        for (String producto : Const.getProductos()) {
            obj.addColumn(producto);
        }
        try {
            String x[] = new String[Const.getProductos().length];
            ResultSet r = conexion.Buscar(Table);
            while (r.next()) {
                int i = 0;
                for (String campo : Const.getProductos()) {
                    x[i] = r.getString(campo);
                    x[i] = BD.OUT(x[i]);
                    i++;
                }
                obj.addRow(x);
            }
            return obj;
        } catch (SQLException ex) {
            System.out.println("error");
            ex.printStackTrace();
        } finally {
            return obj;
        }
    }
    
}
