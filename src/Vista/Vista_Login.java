package Vista;

import Controlador.Con_Login;
import Modelo.Empleado;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jp
 */
public class Vista_Login extends javax.swing.JFrame {

    private final Con_Login controlador;
    private final Vista_MenuAdmin admin;
    private Empleado empleado;

    /**
     * Creates new form Vista_Login
     */
    public Vista_Login() {
        initComponents();
        //
        admin = new Vista_MenuAdmin(this);
        controlador = new Con_Login(this, admin);
        jbtLogin.addActionListener(controlador);
        jbtLogin.addKeyListener(controlador);
        jtfUsuario.addKeyListener(controlador);
        jpfPassword.addKeyListener(controlador);
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Icono.png")).getImage());
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        txtIcon = new javax.swing.JLabel();
        txtU = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        txtC = new javax.swing.JLabel();
        jpfPassword = new javax.swing.JPasswordField();
        jbtLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesión");
        setBackground(new java.awt.Color(4, 0, 255));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 189, 255));
        jPanel3.setFocusCycleRoot(true);
        jPanel3.setFocusTraversalPolicyProvider(true);
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 600));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt1.setBackground(new java.awt.Color(0, 0, 0));
        txt1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("Inicio de sesion");
        txt1.setOpaque(true);
        txt1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel3.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        txtIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        jPanel3.add(txtIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 200));

        txtU.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtU.setForeground(new java.awt.Color(0, 0, 0));
        txtU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtU.setText("Usuario");
        jPanel3.add(txtU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 150, 30));

        jtfUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jtfUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jtfUsuario.setToolTipText("Ingrese su usuario");
        jPanel3.add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 200, 30));

        txtC.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtC.setForeground(new java.awt.Color(0, 0, 0));
        txtC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtC.setText("Contraseña");
        jPanel3.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 150, 30));

        jpfPassword.setBackground(new java.awt.Color(255, 255, 255));
        jpfPassword.setForeground(new java.awt.Color(0, 0, 0));
        jpfPassword.setToolTipText("Ingrese su contraseña");
        jPanel3.add(jpfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 200, 30));

        jbtLogin.setBackground(new java.awt.Color(187, 187, 187));
        jbtLogin.setForeground(new java.awt.Color(0, 0, 0));
        jbtLogin.setText("Iniciar Sesion");
        jbtLogin.setFocusPainted(false);
        jPanel3.add(jbtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getjtfUsuario() {
        return jtfUsuario;
    }

    public JPasswordField getjpfPassword() {
        return jpfPassword;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtLogin;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txtC;
    private javax.swing.JLabel txtIcon;
    private javax.swing.JLabel txtU;
    // End of variables declaration//GEN-END:variables
}
