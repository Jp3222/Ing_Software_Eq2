package Vista;

import Controlador.Con_MenuAdmin;
import Controlador.Sistema;
import Modelo.Empleado;
import javax.swing.ImageIcon;

/**
 *
 * @author jp
 */
public class Vista_MenuAdmin extends javax.swing.JFrame {

    private final Con_MenuAdmin controlador;
    private Empleado Usuario;
    //
    private Vista_Productos productos;
    private Vista_Inventario inventario;
    //
    private Sistema relog;

    public Vista_MenuAdmin(Vista_Login login) {
        productos = new Vista_Productos(this);
        inventario = new Vista_Inventario(this);
        //
        initComponents();
        //
        controlador = new Con_MenuAdmin(this, login);
        cont();
        escuchas();
        relog = Sistema.getNodo();
        relog.setJlbRelog(jlbRelog);
        relog.setJlbFecha(jlbFecha);
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Icono.png")).getImage());
    }

    private void cont() {
        controlador.setProductos(productos);
        controlador.setInventario(inventario);

    }

    private void escuchas() {

        //Botones
        jbtSalir.addActionListener(controlador);
        jbtProductos.addActionListener(controlador);
        jbtEmpleados.addActionListener(controlador);
        jbtPerfil.addActionListener(controlador);
        jbtInventario.addActionListener(controlador);
    }

    private void UserInfo() {
        jlbNombre.setText("Nombre: " + Usuario.getNombre());
        jlbCargo.setText("Cargo: " + Usuario.getCargo());
    }

    public void setUsuario(Empleado Usuario) {
        this.Usuario = Usuario;
        UserInfo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtSalir = new javax.swing.JButton();
        jbtProductos = new javax.swing.JButton();
        jbtEmpleados = new javax.swing.JButton();
        jbtPerfil = new javax.swing.JButton();
        jbtInventario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbNombre = new javax.swing.JLabel();
        jlbCargo = new javax.swing.JLabel();
        jlbRelog = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbtBuscar = new javax.swing.JButton();
        jtfID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jbtQuitar = new javax.swing.JButton();
        jbtAgregar = new javax.swing.JButton();
        jcbType = new javax.swing.JComboBox<>();
        jtfCont = new javax.swing.JTextField();
        jspPiezas = new javax.swing.JSpinner();
        jtfNombre = new javax.swing.JTextField();
        jtfMarca = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 255, 103));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 193));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 200);

        jbtSalir.setBackground(new java.awt.Color(255, 0, 0));
        jbtSalir.setForeground(new java.awt.Color(0, 0, 0));
        jbtSalir.setText("Cerrar Sesion");
        jbtSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtSalir);
        jbtSalir.setBounds(0, 550, 300, 50);

        jbtProductos.setBackground(new java.awt.Color(200, 0, 255));
        jbtProductos.setForeground(new java.awt.Color(0, 0, 0));
        jbtProductos.setText("Productos");
        jbtProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtProductos);
        jbtProductos.setBounds(0, 320, 300, 50);

        jbtEmpleados.setBackground(new java.awt.Color(200, 0, 255));
        jbtEmpleados.setForeground(new java.awt.Color(0, 0, 0));
        jbtEmpleados.setText("Empleados");
        jbtEmpleados.setToolTipText("");
        jbtEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtEmpleados);
        jbtEmpleados.setBounds(0, 260, 300, 50);

        jbtPerfil.setBackground(new java.awt.Color(200, 0, 255));
        jbtPerfil.setForeground(new java.awt.Color(0, 0, 0));
        jbtPerfil.setText("Perfil");
        jbtPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtPerfil);
        jbtPerfil.setBounds(0, 200, 300, 50);

        jbtInventario.setBackground(new java.awt.Color(200, 0, 255));
        jbtInventario.setForeground(new java.awt.Color(0, 0, 0));
        jbtInventario.setText("Inventario");
        jbtInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtInventario);
        jbtInventario.setBounds(0, 380, 300, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 300, 600);

        jPanel3.setBackground(new java.awt.Color(0, 255, 239));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 100));
        jPanel3.setLayout(null);

        jlbNombre.setBackground(new java.awt.Color(1, 1, 1));
        jlbNombre.setForeground(new java.awt.Color(0, 0, 0));
        jlbNombre.setText("Nombre :");
        jPanel3.add(jlbNombre);
        jlbNombre.setBounds(0, 0, 250, 30);

        jlbCargo.setBackground(new java.awt.Color(1, 1, 1));
        jlbCargo.setForeground(new java.awt.Color(0, 0, 0));
        jlbCargo.setText("Cargo");
        jPanel3.add(jlbCargo);
        jlbCargo.setBounds(0, 30, 250, 30);

        jlbRelog.setForeground(new java.awt.Color(0, 0, 0));
        jlbRelog.setText("DD/MM/YY");
        jPanel3.add(jlbRelog);
        jlbRelog.setBounds(700, 0, 200, 30);

        jlbFecha.setForeground(new java.awt.Color(0, 0, 0));
        jlbFecha.setText("DD/MM/YY");
        jPanel3.add(jlbFecha);
        jlbFecha.setBounds(700, 30, 200, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 0, 900, 100);

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 142));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(171, 178, 185));
        jPanel4.setLayout(null);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 350, 458);

        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Piezas");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(350, 240, 100, 25);

        jbtBuscar.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar.setText("Buscar");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtBuscar);
        jbtBuscar.setBounds(750, 0, 140, 25);

        jtfID.setBackground(new java.awt.Color(255, 255, 255));
        jtfID.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jtfID);
        jtfID.setBounds(550, 0, 200, 25);

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Buscar");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(350, 0, 100, 25);

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Nombre");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(350, 80, 100, 25);

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Marca");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(350, 120, 100, 25);

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Contenido");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(350, 160, 100, 25);

        jLabel8.setForeground(new java.awt.Color(1, 1, 1));
        jLabel8.setText("Precio");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(350, 200, 100, 25);

        jtfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jtfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfPrecio.setEnabled(false);
        jPanel4.add(jtfPrecio);
        jtfPrecio.setBounds(450, 200, 300, 25);

        jbtQuitar.setBackground(new java.awt.Color(182, 182, 182));
        jbtQuitar.setForeground(new java.awt.Color(0, 0, 0));
        jbtQuitar.setText("Quitar");
        jbtQuitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtQuitar);
        jbtQuitar.setBounds(610, 310, 140, 25);

        jbtAgregar.setBackground(new java.awt.Color(182, 182, 182));
        jbtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar.setText("Agregar");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtAgregar);
        jbtAgregar.setBounds(450, 310, 140, 25);

        jcbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        jPanel4.add(jcbType);
        jcbType.setBounds(450, 0, 100, 25);

        jtfCont.setBackground(new java.awt.Color(255, 255, 255));
        jtfCont.setForeground(new java.awt.Color(0, 0, 0));
        jtfCont.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfCont.setEnabled(false);
        jPanel4.add(jtfCont);
        jtfCont.setBounds(450, 160, 300, 25);

        jspPiezas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jspPiezas.setAutoscrolls(true);
        jspPiezas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jspPiezas);
        jspPiezas.setBounds(450, 240, 300, 30);

        jtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfNombre.setEnabled(false);
        jPanel4.add(jtfNombre);
        jtfNombre.setBounds(450, 80, 300, 25);

        jtfMarca.setBackground(new java.awt.Color(255, 255, 255));
        jtfMarca.setForeground(new java.awt.Color(0, 0, 0));
        jtfMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfMarca.setEnabled(false);
        jPanel4.add(jtfMarca);
        jtfMarca.setBounds(450, 120, 300, 25);

        jTabbedPane1.addTab("Caja", new javax.swing.ImageIcon(getClass().getResource("/Img/caja-registradora .png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(180, 180, 180));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Agenda", new javax.swing.ImageIcon(getClass().getResource("/Img/reloj.png")), jPanel5); // NOI18N

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(300, 100, 900, 500);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Tab");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtEmpleados;
    private javax.swing.JButton jbtInventario;
    private javax.swing.JButton jbtPerfil;
    private javax.swing.JButton jbtProductos;
    private javax.swing.JButton jbtQuitar;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<String> jcbType;
    private javax.swing.JLabel jlbCargo;
    private javax.swing.JLabel jlbFecha;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbRelog;
    private javax.swing.JSpinner jspPiezas;
    private javax.swing.JTextField jtfCont;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
