package Modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase enfocada a la conexion de base de datos
 */
public class BD {

    /**
     * Variable unica de instancia
     */
    private static BD Nodo;

    /**
     * @param user usuario de la base de datos
     * @param pass contraseña asignada al usuario
     * @param url direccion del base de datos
     * @return retorna una instancia de clase
     */
    public static BD getNodo(String user, String pass, String url) {
        if (Nodo == null) {
            Nodo = new BD(user, pass, url);
        }
        return Nodo;
    }

    /**
     * @return retorna una instancia de clase
     */
    public static BD getNodo() {
        return Nodo;
    }

    /**
     * @param clear define si los datos ocuparan cierto proceso de limpieza
     * antes de ser insertada a la base de datos.
     * @param values coleccion de elementos a los cuales se pondran en cierto
     * formato para la inserccion en la base de datos.
     * @return retorna los elementos dados con la forma indicada para ser
     * insertada a la base de datos.
     */
    public static String getValues(boolean clear, String... values) {
        String v = "";
        for (String value : values) {
            if (clear) {
                v += "'" + IN(value) + "',";
            } else {
                v += "'" + value + "',";
            }
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    /**
     *
     * @param colums Coleccion de elementos tomados como columnas a los cuales
     * se les dara un formato para el manejo de funciones relacionadas con la
     * base de datos
     * @return
     */
    public static String getColums(String... colums) {
        String v = "";
        for (String value : colums) {
            v += "" + value + ",";
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    public static String getData(String[] campos, String[] datos) {
        if (campos.length != datos.length) {
            cons.getMessage("Los arreglos no son iguales", "", "mensaje", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        String sent = "";
        for (int i = 0; i < campos.length; i++) {
            sent += campos[i] + " = " + "'" + datos[i] + "',";
        }
        return sent.substring(0, sent.length() - 1);
    }

    public static String IN(String v) {
        return v.trim().replace(" ", "_").toLowerCase();
    }

    public static String OUT(String v) {
        return v.replace("_", " ");
    }

    private final String user;
    private final String pass;
    private final String url;
    private final String psECall1, psPCall1;
    private Connection cn;
    private PreparedStatement ps, ps1, ps2;
    private Statement st;

    private BD(String user, String pass, String url) {
        //Constantes
        this.psECall1 = SELECT("Empleados", "*", "usuario = ?");
        this.psPCall1 = SELECT("Productos", "*", "calve = ?");
        //
        this.user = user;
        this.pass = pass;
        this.url = url;

    }

    /**
     * Conectar
     */
    public void Conectar() {
        try {
            cn = DriverManager.getConnection(url, user, pass);
            ConstltasPreparadas();

            System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            System.out.println("Error de conexion\n");
        }
    }

    public void desConectar() {
        try {
            cn.close();
            System.out.println("Desconectando");
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ConstltasPreparadas() {
        try {
            ps1 = cn.prepareCall(psECall1);
            ps2 = cn.prepareCall(psPCall1);
        } catch (SQLException ex) {
            System.out.println("Error en las cosultas preparadas");
        }
    }

    public void Insertar(String Tabla, String values) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(INSERT(Tabla, values));
        st.close();
    }

    //
    public void Insertar(String Tabla, String colums, String values) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(INSERT(Tabla, colums, values));
        st.close();
    }

    public void Update(String Tabla, String data, String where) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(UPDATE(Tabla, data, where));
        st.close();
    }

    public void Update(String Tabla, String campo, String dato, String where) throws SQLException {
        st = cn.createStatement();
        st.executeQuery(UPDATE(Tabla, campo, dato, where));
        st.close();
    }

    public void Delete(String Tabla, String where) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(DELETE(Tabla, where));
        st.close();
    }

    /**
     * Este metodo "Buscar" es un metodo cuyas sentencias son preparadas con el
     * proposito de ahorrar espacio en memoria.<br>
     *
     * @param obj es el valor de una clave o usuario segun la tabla indicada con
     * el indice i
     * @param i indica tablabra de la cual se quiere hacer una consulta para un
     * objeto especifico
     * <br> 1.- Tabla Empleados
     * <br> 2.- Tabla Productos
     * @return un objeto de tipo ResultSet dependiendo el indice dato
     * @throws java.sql.SQLException
     */
    public ResultSet Buscar(String obj, int i) throws SQLException, Excepciones {
        switch (i) {
            case 1 -> {
                ps1.setString(1, obj);
                return ps1.executeQuery();
            }
            case 2 -> {
                ps2.setString(1, obj);
                return ps2.executeQuery();
            }
            default -> {
                throw new Excepciones(Excepciones.getMensaje(Excepciones.ERROR_IN_CLASS_BD));
            }
        }
    }

    public ResultSet Buscar(String Tabla) throws SQLException {
        st = cn.createStatement();
        return st.executeQuery(SELECT(Tabla, "*"));
    }

    //
    public ResultSet Buscar(String Tabla, String Campos, String Where) throws SQLException {
        st = cn.createStatement();
        return st.executeQuery(SELECT(Tabla, Campos, Where));

    }

    public void BuscarClose() throws SQLException {
       
    }

    private String SELECT(String Tabla, String Campo, String Where) {
        return "select " + Campo + " from " + Tabla + " Where " + Where;
    }

    private String SELECT(String Tabla, String Campo) {
        return "select " + Campo + " from " + Tabla;
    }

    private String UPDATE(String Tabla, String data, String where) {
        return "update " + Tabla + " set " + data + " where " + where;
    }

    private String UPDATE(String Tabla, String campo, String dato, String where) {
        return "update " + Tabla + " set " + campo + " = " + "'" + dato + "'" + " where " + where;
    }

    public String DELETE(String Tabla, String where) {
        return "delete from " + Tabla + " where " + where;
    }

    private String INSERT(String Tabla, String Campos, String Values) {
        return "insert into " + Tabla + " (" + Campos + ")" + " Values (" + Values + ")";
    }

    private String INSERT(String Tabla, String Values) {
        return "insert into " + Tabla + " Values (" + Values + ")";
    }

    @Override
    public String toString() {
        return "BD{" + "user=" + user + ", pass=" + pass + ", url=" + url + '}';
    }

}
