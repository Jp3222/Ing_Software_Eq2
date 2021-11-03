package Controlador;

import Modelo.BD;
import Modelo.Const;
import Modelo.Empleado;
import Modelo.Excepciones;
import Modelo.Movimiento;
import Modelo.Operaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;

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
    private final Sistema sistema = Sistema.getNodo();

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
                    Movimiento mov = new Movimiento(sistema.getCl(), Const.getMovimiento(0), empleado.getUsuario());
                    operacion.setMovimiento(mov);
                    switch (empleado.getCargo()) {
                        case "Gerente" -> {
                            login.dispose();
                            admin.setVisible(true);
                            admin.setUsuario(empleado);
                        }
                        default ->
                            System.out.println("No reconocido");
                    }
                    clear();
                } else {
                    Const.getMessage("La contraseña", "Es incorrecta"
                    ,"Mensaje",0);
                    login.getjpfPassword().setBorder(Const.getBadBorder());
                }
            } else {
                Const.getMessage("EL usuario", "Es incorrecto" ,"Mensaje",0);
                login.getjtfUsuario().setBorder(Const.getBadBorder());
            }
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
        }
    }

    public void clear() {
        login.getjtfUsuario().setText("");
        login.getjpfPassword().setText("");
    }

}
