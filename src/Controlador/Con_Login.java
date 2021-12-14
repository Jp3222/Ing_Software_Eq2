package Controlador;

import Modelo.cons;
import Modelo.CL_Empleado;
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

    public Con_Login(Vista_Login login) {
        this.logs = new log(login);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        logs.Login();
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
    private final Operaciones operacion;
    private final Sistema sistema = Sistema.getNodo();
    private final Evt_Ventana evt = Evt_Ventana.getNodo();

    public log(Vista_Login login) {
        this.login = login;
        this.admin = new Vista_MenuAdmin(login);
        this.operacion = Operaciones.getNodo();
        login.addWindowListener(evt);
    }

    public void Login() {
        System.out.println("xd");
        //Obtener informacion de la vista
        String usr = login.getjtfUsuario().getText();
        String pass = String.copyValueOf(login.getjpfPassword().getPassword());
        //Busqueda del empleado
        CL_Empleado empleado = operacion.getEmpleado(usr);
        if (empleado != null && empleado.isExists() && empleado.getPassword().equals(pass)) {
            OK();
            sistema.setSistemUser(empleado);
            login.dispose();
            admin.setVisible(true);
            admin.setUsuario(empleado);
            System.out.println("xd");
            CL_Movimiento movimiento = new CL_Movimiento(
                    sistema.getNodoRlg().getCl(),
                    cons.getMovimiento(0),
                    empleado.getUsuario()
            );
            operacion.setMovimiento(movimiento);
            clear();
        } else {
            NotOK();
        }
    }

    public void NotOK() {
        login.getjtfUsuario().setBorder(cons.OkBorder);
        login.getjpfPassword().setBorder(cons.OkBorder);
        cons.getMessage("Usuario y/0 contraseña ", "icorrecto", "Mensaje", 0);
    }

    public void OK() {
        login.getjtfUsuario().setBorder(cons.OkBorder);
        login.getjpfPassword().setBorder(cons.OkBorder);
    }

    public void clear() {
        login.getjtfUsuario().setText("");
        login.getjpfPassword().setText("");
    }

}
