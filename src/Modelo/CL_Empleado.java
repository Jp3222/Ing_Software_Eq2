package Modelo;

import java.util.Objects;

public class CL_Empleado {

    private int ID;
    private String usuario,
            Nombre,
            A_paterno,
            A_materno,
            Edad,
            Cargo,
            Password;
    private boolean Exists;

    public CL_Empleado() {
        this.Exists = false;
    }

    public CL_Empleado(String[] info) {
        this.ID = 0;
        this.usuario = info[0];
        this.Nombre = info[1];
        this.A_paterno = info[2];
        this.A_materno = info[3];
        this.Edad = info[4];
        this.Cargo = info[5];
        this.Password = info[6];
    }

    public int getID() {
        return ID;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getA_paterno() {
        return A_paterno;
    }

    public void setA_paterno(String A_paterno) {
        this.A_paterno = A_paterno;
    }

    public String getA_materno() {
        return A_materno;
    }

    public void setA_materno(String A_materno) {
        this.A_materno = A_materno;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isExists() {
        return Exists;
    }

    public void setExists(boolean Exists) {
        this.Exists = Exists;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ID);
        hash = 23 * hash + Objects.hashCode(this.Nombre);
        hash = 23 * hash + Objects.hashCode(this.A_paterno);
        hash = 23 * hash + Objects.hashCode(this.A_materno);
        hash = 23 * hash + Objects.hashCode(this.Edad);
        hash = 23 * hash + Objects.hashCode(this.Cargo);
        hash = 23 * hash + Objects.hashCode(this.Password);
        hash = 23 * hash + (this.Exists ? 1 : 0);
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
        final CL_Empleado other = (CL_Empleado) obj;
        if (this.Exists != other.Exists) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.Nombre, other.Nombre)) {
            return false;
        }
        if (!Objects.equals(this.A_paterno, other.A_paterno)) {
            return false;
        }
        if (!Objects.equals(this.A_materno, other.A_materno)) {
            return false;
        }
        if (!Objects.equals(this.Edad, other.Edad)) {
            return false;
        }
        if (!Objects.equals(this.Cargo, other.Cargo)) {
            return false;
        }
        return Objects.equals(this.Password, other.Password);
    }

    public void setInfo(String[] info) {
        this.ID = Integer.parseInt(info[0]);
        this.usuario = info[1];
        this.Nombre = info[2];
        this.A_paterno = info[3];
        this.A_materno = info[4];
        this.Edad = info[5];
        this.Cargo = info[6];
        this.Password = info[7];
    }

    public String[] getInfo() {
        return func.getArray(ID + "", usuario, Nombre, A_paterno, A_materno, Edad, Cargo, Password);
    }

    @Override
    public String toString() {
        return "Empleado{\nID=" + ID
                + "\nNombre=" + Nombre
                + "\nA_paterno=" + A_paterno
                + "\nA_materno=" + A_materno
                + "\nEdad=" + Edad
                + "\nCargo=" + Cargo
                + "\nPassword=" + Password + '}';
    }

}
