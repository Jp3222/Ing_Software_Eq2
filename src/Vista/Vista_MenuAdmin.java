package Vista;

import Controlador.Con_MenuAdmin;
import Controlador.Sistema;
import Controlador.Sistema.Relog;
import Modelo.CL_Empleado;
import Modelo.CL_Producto;
import Modelo.cons;
import Modelo.func;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Vista_MenuAdmin extends javax.swing.JFrame {

    //referencia a la vista de productos
    private final Vista_Productos productos;
    //referencia a la vista de administracion
    private final Vista_Administracion administracion;
    //referencia a la vista de empleados
    private final Vista_Empleados empleados;
    //Sub clase con funciones del carrito
    private Carrito carrito;
    private Agenda agenda;
    //Usuario del sistema
    private CL_Empleado Usuario;
    //Controlador de la clase
    private final Con_MenuAdmin controlador;
    
    public Vista_MenuAdmin(Vista_Login login) {
        this.productos = new Vista_Productos(this);
        this.empleados = new Vista_Empleados(this);
        this.administracion = new Vista_Administracion(this);
        //
        initComponents();
        //
        controlador = new Con_MenuAdmin(this);
        controlador.setLogin(login);
        //
        cont();
        escuchas();
        OtrasClases();
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/JSHOP_2.png")).getImage());
    }
    
    private void cont() {
        controlador.setAdministracion(administracion);
        controlador.setEmpleados(empleados);
        controlador.setProductos(productos);
    }
    
    private void escuchas() {
        //Botones
        jbtSalir.addActionListener(controlador);
        jbtProductos.addActionListener(controlador);
        jbtEmpleados.addActionListener(controlador);
        jbtPerfil.addActionListener(controlador);
        jbtAdministracion.addActionListener(controlador);
        //
    }
    
    private void OtrasClases() {
        carrito = new Carrito();
        agenda = new Agenda();
        RelogSis rlg = new RelogSis();
    }
    
    public void setUsuario(CL_Empleado Usuario) {
        this.Usuario = Usuario;
        UserInfo();
    }
    
    private void UserInfo() {
        if (Usuario != null) {
            jlbNombre.setText("Nombre: " + Usuario.getNombre());
            jlbCargo.setText("Cargo: " + Usuario.getCargo());
            if (Usuario.getCargo().equals("Empleado")) {
                jbtAdministracion.setEnabled(false);
            } else {
                jbtAdministracion.setEnabled(true);
            }
        }
    }
    
    public CL_Empleado getUsuario() {
        return Usuario;
    }
    
    public Carrito getCarrito() {
        if (carrito == null) {
            carrito = new Carrito();
        }
        return carrito;
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
        jbtAdministracion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbNombre = new javax.swing.JLabel();
        jlbCargo = new javax.swing.JLabel();
        jlbRelog = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCarrito = new javax.swing.JTable();
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
        jbtCobrar = new javax.swing.JButton();
        jcbType = new javax.swing.JComboBox<>();
        jtfCont = new javax.swing.JTextField();
        jspPiezas = new javax.swing.JSpinner();
        jtfNombre = new javax.swing.JTextField();
        jtfMarca = new javax.swing.JTextField();
        jbtAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jbtActualizar = new javax.swing.JButton();
        jbtGR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbAgenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(171, 178, 185));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(35, 35, 40));
        jPanel2.setForeground(new java.awt.Color(254, 254, 254));
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
        jbtSalir.setBounds(0, 550, 298, 48);

        jbtProductos.setBackground(new java.awt.Color(96, 17, 207));
        jbtProductos.setForeground(new java.awt.Color(0, 0, 0));
        jbtProductos.setText("Productos");
        jbtProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtProductos);
        jbtProductos.setBounds(0, 320, 298, 50);

        jbtEmpleados.setBackground(new java.awt.Color(96, 17, 207));
        jbtEmpleados.setForeground(new java.awt.Color(0, 0, 0));
        jbtEmpleados.setText("Empleados");
        jbtEmpleados.setToolTipText("");
        jbtEmpleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtEmpleados);
        jbtEmpleados.setBounds(0, 260, 298, 50);

        jbtPerfil.setBackground(new java.awt.Color(96, 17, 207));
        jbtPerfil.setForeground(new java.awt.Color(254, 254, 254));
        jbtPerfil.setText("Perfil");
        jbtPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtPerfil);
        jbtPerfil.setBounds(0, 200, 298, 50);

        jbtAdministracion.setBackground(new java.awt.Color(96, 17, 207));
        jbtAdministracion.setForeground(new java.awt.Color(0, 0, 0));
        jbtAdministracion.setText("Administracion");
        jbtAdministracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtAdministracion);
        jbtAdministracion.setBounds(0, 380, 298, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1, 1, 299, 598);

        jPanel3.setBackground(new java.awt.Color(60, 209, 255));
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
        jPanel3.setBounds(300, 1, 900, 99);

        jTabbedPane1.setBackground(new java.awt.Color(35, 35, 40));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(254, 254, 254));
        jTabbedPane1.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(35, 35, 40));
        jPanel4.setLayout(null);

        jtbCarrito.setBackground(new java.awt.Color(35, 35, 40));
        jtbCarrito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 255)));
        jtbCarrito.setForeground(new java.awt.Color(254, 254, 254));
        jtbCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jtbCarrito.setEnabled(false);
        jtbCarrito.setFillsViewportHeight(true);
        jtbCarrito.setGridColor(new java.awt.Color(1, 1, 1));
        jtbCarrito.setShowGrid(true);
        jScrollPane1.setViewportView(jtbCarrito);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 440, 458);

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Piezas");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(440, 240, 100, 25);

        jbtBuscar.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar.setText("Buscar");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtBuscar);
        jbtBuscar.setBounds(790, 0, 100, 25);

        jtfID.setBackground(new java.awt.Color(255, 255, 255));
        jtfID.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jtfID);
        jtfID.setBounds(590, 0, 200, 25);

        jLabel4.setBackground(new java.awt.Color(254, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(440, 0, 50, 25);

        jLabel5.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Nombre");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(440, 80, 100, 25);

        jLabel6.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Marca");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(440, 120, 100, 25);

        jLabel7.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Contenido");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(440, 160, 100, 25);

        jLabel8.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Precio");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(440, 200, 100, 25);

        jtfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jtfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfPrecio.setEnabled(false);
        jPanel4.add(jtfPrecio);
        jtfPrecio.setBounds(540, 200, 300, 25);

        jbtQuitar.setBackground(new java.awt.Color(182, 182, 182));
        jbtQuitar.setForeground(new java.awt.Color(0, 0, 0));
        jbtQuitar.setText("Quitar");
        jbtQuitar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtQuitar);
        jbtQuitar.setBounds(700, 310, 140, 25);

        jbtCobrar.setBackground(new java.awt.Color(182, 182, 182));
        jbtCobrar.setForeground(new java.awt.Color(0, 0, 0));
        jbtCobrar.setText("Cobrar");
        jbtCobrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtCobrar);
        jbtCobrar.setBounds(540, 360, 300, 25);

        jcbType.setBackground(new java.awt.Color(35, 35, 40));
        jcbType.setForeground(new java.awt.Color(255, 255, 255));
        jcbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        jPanel4.add(jcbType);
        jcbType.setBounds(490, 0, 100, 25);

        jtfCont.setBackground(new java.awt.Color(255, 255, 255));
        jtfCont.setForeground(new java.awt.Color(0, 0, 0));
        jtfCont.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfCont.setEnabled(false);
        jPanel4.add(jtfCont);
        jtfCont.setBounds(540, 160, 300, 25);

        jspPiezas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jspPiezas.setAutoscrolls(true);
        jspPiezas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jspPiezas);
        jspPiezas.setBounds(540, 240, 300, 30);

        jtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfNombre.setEnabled(false);
        jPanel4.add(jtfNombre);
        jtfNombre.setBounds(540, 80, 300, 25);

        jtfMarca.setBackground(new java.awt.Color(255, 255, 255));
        jtfMarca.setForeground(new java.awt.Color(0, 0, 0));
        jtfMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfMarca.setEnabled(false);
        jPanel4.add(jtfMarca);
        jtfMarca.setBounds(540, 120, 300, 25);

        jbtAgregar.setBackground(new java.awt.Color(182, 182, 182));
        jbtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar.setText("Agregar");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jbtAgregar);
        jbtAgregar.setBounds(540, 310, 140, 25);

        jLabel2.setFont(new java.awt.Font("Inter", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Total: $");
        jLabel2.setAutoscrolls(true);
        jPanel4.add(jLabel2);
        jLabel2.setBounds(440, 400, 440, 50);

        jTabbedPane1.addTab("Caja", new javax.swing.ImageIcon(getClass().getResource("/Img/caja-registradora .png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(35, 35, 40));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(null);

        jbtActualizar.setBackground(new java.awt.Color(96, 17, 207));
        jbtActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jbtActualizar.setText("Actualizar Calendario");
        jbtActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtActualizar.setFocusPainted(false);
        jPanel5.add(jbtActualizar);
        jbtActualizar.setBounds(190, 420, 150, 25);

        jbtGR.setBackground(new java.awt.Color(96, 17, 207));
        jbtGR.setForeground(new java.awt.Color(0, 0, 0));
        jbtGR.setText("Generar Lista PDF");
        jbtGR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtGR.setFocusPainted(false);
        jPanel5.add(jbtGR);
        jbtGR.setBounds(10, 420, 150, 25);

        jtbAgenda.setAutoCreateRowSorter(true);
        jtbAgenda.setBackground(new java.awt.Color(35, 35, 40));
        jtbAgenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 255)));
        jtbAgenda.setForeground(new java.awt.Color(254, 254, 254));
        jtbAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbAgenda.setToolTipText("Agenda de visitas");
        jtbAgenda.setEnabled(false);
        jtbAgenda.setFillsViewportHeight(true);
        jtbAgenda.setGridColor(new java.awt.Color(1, 1, 1));
        jtbAgenda.setShowGrid(true);
        jScrollPane3.setViewportView(jtbAgenda);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(10, 10, 870, 390);

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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtActualizar;
    private javax.swing.JButton jbtAdministracion;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCobrar;
    private javax.swing.JButton jbtEmpleados;
    private javax.swing.JButton jbtGR;
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
    private javax.swing.JTable jtbAgenda;
    private javax.swing.JTable jtbCarrito;
    private javax.swing.JTextField jtfCont;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables

    public class RelogSis {
        
        private Relog rlg;
        
        public RelogSis() {
            rlg = Sistema.getNodo().getNodoRlg();
            rlg.setFecha(jlbFecha);
            rlg.setRelog(jlbRelog);
        }
        
    }
    
    public class Carrito {
        
        private CL_Producto producto;
        private DefaultTableModel tb;
        
        public Carrito() {
            
            this.producto = null;
            this.tb = new DefaultTableModel(func.getArray("Clave", "Producto", "Contenido", "piezas", "Precio"), 0);
            //
            jtbCarrito.setModel(tb);
            //
            jbtAgregar.addActionListener(controlador);
            jbtBuscar.addActionListener(controlador);
            jbtCobrar.addActionListener(controlador);
            jbtQuitar.addActionListener(controlador);
        }
        
        public JTable getJtbCarrito() {
            return jtbCarrito;
        }

        /**
         * Metodo que devuelve el campo de busqueda
         *
         * @return
         */
        public String getCampo() {
            int i = jcbType.getSelectedIndex();
            return jcbType.getItemAt(i);
        }

        /**
         * Metodo que devuelve el parametro a evaluar
         *
         * @return String
         */
        public String getValue() {
            return jtfID.getText();
        }
        
        public void setProducto(CL_Producto producto) {
            this.producto = producto;
            showProducto();
        }
        
        public CL_Producto getProducto() {
            return producto;
        }
        
        public void showProducto() {
            jtfNombre.setText(producto.getNombre());
            jtfMarca.setText(producto.getMarca());
            jtfCont.setText(producto.getContenido() + "");
            jtfPrecio.setText(producto.getPrecios() + "");
        }
        
        public String getNombre() {
            return producto.getNombre();
        }
        
        public String getClave() {
            return producto.getClave();
        }
        
        public double getPrecio() {
            return producto.getPrecios();
        }
        
        public String getContenido() {
            return producto.getContenido() + "" + producto.getUDM();
        }
        
        public int getPiezas() {
            return (int) jspPiezas.getValue();
        }
        
        public void clear() {
            jtfNombre.setText("");
            jtfMarca.setText("");
            jtfCont.setText("");
            jtfPrecio.setText("");
            producto = null;
        }
        
        public void clear_2() {
            jcbType.setSelectedIndex(0);
            jtfID.setText("");
        }
        
    }
    
    public class Agenda {
        
        DefaultTableModel tb;

        public Agenda() {
            this.tb = new DefaultTableModel(cons.Dias, 0);
            jtbAgenda.setModel(tb);
        }
        
        
        public void setModelo(DefaultTableModel tb) {
            jtbAgenda.setModel(tb);
        }
    }
    
}
