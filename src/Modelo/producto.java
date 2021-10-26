package Modelo;

import java.util.Objects;

/*
 obj 
 obj. 
 obj.
 
 */
/**
 *
 * @author jp
 */
public class producto {

    private final BD conexion;
    private int ID;
    double Contenido, UDM, Precios;
    private String Clave, Nombre, Marca;

    private boolean Exists;

    public producto(BD conexion) {
        this.conexion = conexion;
        this.ID = 0;
        this.Clave = "";
        this.Nombre = "";
        this.Marca = "";
        this.Contenido = 0;
        this.UDM = 0;
        this.Precios = 0;
        this.Exists = false;
    }

    public int getID() {
        return ID;
    }

    public double getContenido() {
        return Contenido;
    }

    public void setContenido(double Contenido) {
        this.Contenido = Contenido;
    }

    public double getUDM() {
        return UDM;
    }

    public void setUDM(double UDM) {
        this.UDM = UDM;
    }

    public double getPrecios() {
        return Precios;
    }

    public void setPrecios(double Precios) {
        this.Precios = Precios;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public boolean isExists() {
        return Exists;
    }

    public void setExists(boolean Exists) {
        this.Exists = Exists;
    }

    public void setInfo(String[] info) {
        this.ID = Integer.parseInt(info[0]);
        this.Clave = info[1];
        this.Nombre = info[2];
        this.Marca = info[3];
        this.Contenido = Double.parseDouble(info[4]);
        this.UDM = Double.parseDouble(info[5]);
        this.Precios = Double.parseDouble(info[6]);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.conexion);
        hash = 41 * hash + this.ID;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.Contenido) ^ (Double.doubleToLongBits(this.Contenido) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.UDM) ^ (Double.doubleToLongBits(this.UDM) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.Precios) ^ (Double.doubleToLongBits(this.Precios) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.Clave);
        hash = 41 * hash + Objects.hashCode(this.Nombre);
        hash = 41 * hash + Objects.hashCode(this.Marca);
        hash = 41 * hash + (this.Exists ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final producto other = (producto) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.Contenido) != Double.doubleToLongBits(other.Contenido)) {
            return false;
        }
        if (Double.doubleToLongBits(this.UDM) != Double.doubleToLongBits(other.UDM)) {
            return false;
        }
        if (Double.doubleToLongBits(this.Precios) != Double.doubleToLongBits(other.Precios)) {
            return false;
        }
        if (this.Exists != other.Exists) {
            return false;
        }
        if (!Objects.equals(this.Clave, other.Clave)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        return Objects.equals(this.Marca, other.Marca);
    }

    @Override
    public String toString() {
        return "producto{" + "conexion=" + conexion + ", ID=" + ID + ", Contenido=" + Contenido + ", UDM=" + UDM + ", Precios=" + Precios + ", Clave=" + Clave + ", Nombre=" + Nombre + ", Marca=" + Marca + ", Exists=" + Exists + '}';
    }

}
