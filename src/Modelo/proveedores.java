package Modelo;

import java.util.Objects;

/**
 *
 * @author jp
 */
public class proveedores {

    private int index;
    private String nombre;

    public proveedores(int index, String nombre) {
        this.index = index;
        this.nombre = nombre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.index;
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        final proveedores other = (proveedores) obj;
        if (this.index != other.index) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "proveedores{" + "index=" + index + ", nombre=" + nombre + '}';
    }
    
    
    
    

}
