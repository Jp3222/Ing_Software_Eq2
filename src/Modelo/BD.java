package Modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

    private static BD Nodo;

    public static BD getNodo(String user, String pass, String url) {
        if (Nodo == null) {
            Nodo = new BD(user, pass, url);
        }
        return Nodo;
    }

    public static BD getNodo() {
        return Nodo;
    }

    public static String getValues(String... values) {
        String v = "";
        for (String value : values) {
            v += "'" + value + "',";
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    public static String getColums(String... colums) {
        String v = "";
        for (String value : colums) {
            v += "" + value + ",";
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    public static String clear(String v) {
        return v.trim().replace(" ", "_").toLowerCase();
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
        Conectar();
        ConstltasPreparadas();
    }

    private void ConstltasPreparadas() {
        try {
            ps1 = cn.prepareCall(psECall1);
            ps2 = cn.prepareCall(psPCall1);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Insertar(String Tabla, String values) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(INSERT(Tabla, values));
    }

    public void Insertar(String Tabla, String colums, String values) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(INSERT(Tabla, colums, values));
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

    public ResultSet Buscar(String Tabla, String Where) throws SQLException {
        return null;
    }

    public ResultSet Buscar(String Tabla, String Campos, String Where) throws SQLException {
        return null;
    }

    private void Conectar() {
        try {
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion establecida");
        } catch (SQLException ex) {
            System.out.println("Error de conecion\n" + ex.getCause().getMessage());
        }
    }

    private String SELECT(String Tabla, String Campo, String Where) {
        return "select " + Campo + " from " + Tabla + " Where " + Where;
    }

    private String SELECT(String Tabla, String Campo) {
        return "select " + Campo + " from " + Tabla;
    }

    private String INSERT(String Tabla, String Campos, String Values) {
        return "insert into " + Tabla + " (" + Campos + ")" + " Values (" + Values + ")";
    }

    private String INSERT(String Tabla, String Values) {
        return "insert into " + Tabla + " Values (" + Values + ")";
    }

    private void desConectar() {
        try {
            cn.close();
            System.out.println("Desconectando");
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "BD{" + "user=" + user + ", pass=" + pass + ", url=" + url + '}';
    }

}
