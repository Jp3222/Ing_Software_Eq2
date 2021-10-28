package Controlador;

import Modelo.BD;
import Modelo.Const;
import Modelo.Empleado;
import Modelo.Excepciones;
import Modelo.Operaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Con_Login extends KeyAdapter implements ActionListener {

    private log logs;

    public Con_Login(Vista_Login login, Vista_MenuAdmin admin) {
        this.logs = new log(login, admin);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (true) {
            logs.Login();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            logs.Login();
        }
    }

}

class log {

    private final Vista_Login login;
    private final Vista_MenuAdmin admin;
    private final BD conexion = BD.getNodo();
    private final Operaciones operacion;

    public log(Vista_Login login, Vista_MenuAdmin admin) {
        this.login = login;
        this.admin = admin;
        operacion = new Operaciones(conexion);
    }

    public void Login() {
        try {
            String usr = login.getjtfUsuario().getText();
            String pass = String.copyValueOf(login.getjpfPassword().getPassword());
            //
            Empleado empleado = operacion.getEmpleado(usr);
            if (empleado == null) {
                throw new Excepciones(Excepciones.getMensaje(3000));
            }
            if (empleado.isExists()) {
                login.getjtfUsuario().setBorder(Const.getOkBorder());
                if (empleado.getPassword().equals(pass)) {
                    login.getjpfPassword().setBorder(Const.getOkBorder());
                    conexion.Insertar("Movimientos", BD.getColums("Dia", "tipo", "usuario"), BD.getValues(false, Sistema.getNodo().getDate(), "inicio de seson", empleado.getUsuario()));
                    switch (empleado.getCargo()) {
                        case "Gerente":
                            login.dispose();
                            admin.setVisible(true);
                            admin.setUsuario(empleado);
                            break;
                        default:
                            System.out.println("No reconocido");
                    }
                    clear();
                } else {
                    Const.getMessage("La contraseña", "Es incorrecta");
                    login.getjpfPassword().setBorder(Const.getBadBorder());
                }
            } else {
                Const.getMessage("EL usuario", "Es incorrecto");
                login.getjtfUsuario().setBorder(Const.getBadBorder());
            }
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(log.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        login.getjtfUsuario().setText("");
        login.getjpfPassword().setText("");
    }

}
