package Controlador;

import Modelo.Excepciones;
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;
import Vista.Vista_Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Con_MenuAdmin implements ActionListener {

    private Vista_MenuAdmin admin;
    private Vista_Login login;
    //
    private Vista_Productos productos;

    public Con_MenuAdmin(Vista_MenuAdmin admin, Vista_Login login) {
        try {
            if (admin == null || login == null) {
                throw new Excepciones(Excepciones.getMensaje(Excepciones.ERROR_IN_CLASS_CON_MENU));
            }
            this.admin = admin;
            this.login = login;
        } catch (Excepciones ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setProductos(Vista_Productos productos) {
        this.productos = productos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cerrar Sesion" ->
                Cerrar_Sesion();
            case "Perfil" ->
                Perfil();
            case "Empleados" ->
                Empleados();
            case "Productos" ->
                Productos();
            case "Inventario" ->
                Inventario();

        }
    }

    public void Cerrar_Sesion() {
        admin.dispose();
        login.setVisible(true);
    }

    public void Perfil() {
        System.out.println("Perfil");
    }

    public void Productos() {
        admin.dispose();
        productos.setVisible(true);
    }

    public void Empleados() {
        System.out.println("Empleado");
    }

    public void Inventario() {
        System.out.println("Inventario");
    }

}
