package Controlador;

import Modelo.BD;
import Modelo.cons;
import Modelo.CL_Empleado;
import Modelo.Excepciones;
import Modelo.CL_Movimiento;
import Modelo.Operaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//
import Vista.Vista_Login;
import Vista.Vista_MenuAdmin;
import javax.swing.JOptionPane;

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
    private final Evt_Ventana evt = Evt_Ventana.getNodo();

    public log(Vista_Login login, Vista_MenuAdmin admin) {
        this.login = login;
        this.admin = admin;
        login.addWindowListener(evt);
        operacion = new Operaciones(conexion);
    }

    public void Login() {
        try {
            String usr = login.getjtfUsuario().getText();
            String pass = String.copyValueOf(login.getjpfPassword().getPassword());
            //
            CL_Empleado empleado = operacion.getEmpleado(usr);
            evt.setEm(empleado);
            if (empleado == null) {
                throw new Excepciones(Excepciones.getMensaje(3000));
            }
            if (empleado.isExists()) {
                login.getjtfUsuario().setBorder(cons.getOkBorder());
                if (empleado.getPassword().equals(pass)) {
                    login.getjpfPassword().setBorder(cons.getOkBorder());
                    //
                    login.dispose();
                    admin.setVisible(true);
                    admin.setUsuario(empleado);
                    CL_Movimiento mov = new CL_Movimiento(sistema.getCl(), cons.getMovimiento(0), empleado.getUsuario());
                    operacion.setMovimiento(mov);
                    clear();
                } else {
                    mensaje();
                }
            } else {
                mensaje();
            }
        } catch (Excepciones e) {
            System.out.println(e.getMessage());
        }
    }

    public void mensaje() {
        login.getjtfUsuario().setBorder(cons.getBadBorder());
        login.getjpfPassword().setBorder(cons.getBadBorder());
        cons.getMessage("Usuario y/0 contraseña ", "icorrecto", "Mensaje", JOptionPane.ERROR_MESSAGE);
    }

    public void clear() {
        login.getjtfUsuario().setText("");
        login.getjpfPassword().setText("");
    }

}
