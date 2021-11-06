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
public class CL_Producto {

    private int ID;
    double Contenido, Precios;
    private String Clave, Nombre, Marca, UDM;

    private boolean Exists;

    public CL_Producto() {
        this.Exists = false;
    }

    public CL_Producto(String[] info) {
        this.ID = 0;
        this.Clave = info[0];
        this.Nombre = info[1] + " " + info[3];
        this.Marca = info[2];
        this.Contenido = Double.parseDouble(info[3]);
        this.UDM = info[4];
        this.Precios = Double.parseDouble(info[5]);
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

    public String getUDM() {
        return UDM;
    }

    public void setUDM(String UDM) {
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
        this.UDM = info[5];
        this.Precios = Double.parseDouble(info[6]);
    }

    public String[] getInfo() {
        return func.getArray(ID + "", Clave, Nombre, Marca, Contenido + "", UDM + "", Precios + "");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.ID;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.Contenido) ^ (Double.doubleToLongBits(this.Contenido) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.Precios) ^ (Double.doubleToLongBits(this.Precios) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.Clave);
        hash = 37 * hash + Objects.hashCode(this.Nombre);
        hash = 37 * hash + Objects.hashCode(this.Marca);
        hash = 37 * hash + Objects.hashCode(this.UDM);
        hash = 37 * hash + (this.Exists ? 1 : 0);
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
        final CL_Producto other = (CL_Producto) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.Contenido) != Double.doubleToLongBits(other.Contenido)) {
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
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        if (!Objects.equals(this.UDM, other.UDM)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "ID=" + ID + ", Contenido=" + Contenido + ", Precios=" + Precios + ", Clave=" + Clave + ", Nombre=" + Nombre + ", Marca=" + Marca + ", UDM=" + UDM + ", Exists=" + Exists + '}';
    }

}
