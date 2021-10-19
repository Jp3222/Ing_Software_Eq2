package Controlador;

import Modelo.BD;
import Modelo.Const;
import Modelo.Empleado;
import Modelo.Excepciones;
import Modelo.Operaciones;
import Vista.Vista_MenuEmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jp
 */
public class Con_Login extends KeyAdapter implements ActionListener {

    private log logs;

    public Con_Login(Vista_Login login, Vista_MenuAdmin admin, Vista_MenuEmp emp) {
        this.logs = new log(login, admin, emp);
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
    private final Vista_MenuEmp emp;
    private final BD conexion = BD.getNodo();
    private final Operaciones operacion;

    public log(Vista_Login login, Vista_MenuAdmin admin, Vista_MenuEmp emp) {
        this.login = login;
        this.admin = admin;
        this.emp = emp;
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
                    switch (empleado.getCargo()) {
                        case "Gerente":
                            login.dispose();
                            admin.setVisible(true);
                            admin.setUsuario(empleado);
                            break;
                        case "Empleado":
                            login.dispose();
                            emp.setVisible(true);
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
