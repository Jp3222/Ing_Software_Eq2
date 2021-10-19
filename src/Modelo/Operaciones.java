package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

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
            conexion.Insertar("Productos", BD.getColums(Const.getProductos()), values);
            System.out.println("Inserccion hecha");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
