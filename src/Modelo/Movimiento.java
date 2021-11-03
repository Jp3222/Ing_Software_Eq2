package Modelo;

import java.util.Calendar;
import java.util.Objects;

public class Movimiento {

    private int id;
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int min;
    private int seg;
    private String tipo;
    private String usuario;

    public Movimiento(Calendar cl, String tipo, String usuario) {
        this.dia = cl.get(Calendar.DAY_OF_MONTH);
        this.mes = cl.get(Calendar.MONTH);
        this.anio = cl.get(Calendar.YEAR);
        this.hora = cl.get(Calendar.HOUR_OF_DAY);
        this.min = cl.get(Calendar.MINUTE);
        this.seg = cl.get(Calendar.SECOND);
        this.tipo = tipo;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
        hash = 19 * hash + this.dia;
        hash = 19 * hash + this.mes;
        hash = 19 * hash + this.anio;
        hash = 19 * hash + this.hora;
        hash = 19 * hash + this.min;
        hash = 19 * hash + this.seg;
        hash = 19 * hash + Objects.hashCode(this.tipo);
        hash = 19 * hash + Objects.hashCode(this.usuario);
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
        final Movimiento other = (Movimiento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        if (this.min != other.min) {
            return false;
        }
        if (this.seg != other.seg) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    public void setInfo(String[] info) {
        this.dia = Integer.parseInt(info[0]);
        this.mes = Integer.parseInt(info[1]);
        this.anio = Integer.parseInt(info[2]);
        this.hora = Integer.parseInt(info[3]);
        this.min = Integer.parseInt(info[4]);
        this.seg = Integer.parseInt(info[5]);
        this.tipo = info[6];
        this.usuario = info[7];
    }

    public String[] getInfo() {
        return func.getArray( dia + "", mes + "", anio + "", hora + "", min + "", seg + "", tipo, usuario);
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id=" + id + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", hora=" + hora + ", min=" + min + ", seg=" + seg + ", tipo=" + tipo + ", usuario=" + usuario + '}';
    }

}
