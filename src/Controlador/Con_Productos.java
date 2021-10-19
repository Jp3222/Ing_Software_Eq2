package Controlador;

import Modelo.BD;
import Modelo.Const;
import Modelo.Excepciones;
import Modelo.Operaciones;
import Modelo.func;
import Vista.Vista_Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Productos implements ActionListener {

    private final Vista_Productos productos;
    private String[] v;
    private final BD conexion = BD.getNodo();
    private final Operaciones operaciones = new Operaciones(conexion);

    public Con_Productos(Vista_Productos bdProductos) {
        this.productos = bdProductos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (productos.isEmpty2()) {
            JOptionPane.showMessageDialog(productos, "Hay campos vacios");
            return;
        }
        switch (e.getActionCommand()) {
            case "Agregar" ->
                Agregar();
            case "Generar Clave" ->
                key();
        }

    }

    private void Agregar() {

        
    }

    private void key() {

    }
}
