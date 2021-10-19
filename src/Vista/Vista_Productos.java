package Vista;

import Controlador.Con_Productos;
import Modelo.Const;
import Modelo.func;
import javax.swing.JTextField;

public class Vista_Productos extends javax.swing.JFrame {

    Vista_MenuAdmin admin;
    private final Con_Productos controlador;

    public Vista_Productos(Vista_MenuAdmin admin) {
        initComponents();
        controlador = new Con_Productos(this);
        jbtAgregar1.addActionListener(controlador);
        jbtQuitar1.addActionListener(controlador);
        jbtQuitar2.addActionListener(controlador);

    }

    public String[] values() {
        String values[] = new String[6];
        values[0] = "-1";
        values[1] = jtfNombre.getText();
        values[2] = (String) jcbMarcas.getSelectedItem();
        values[3] = jtfContenido.getText();
        values[4] = (String) jcbUDM.getSelectedItem();
        values[5] = jtfPrecio.getText();
        return values;
    }

    public JTextField getJtfClave() {
        return jtfClave;
    }

    public boolean isEmpty2() {
        int i = 0;
        if (jtfNombre.getText().isEmpty()) {
            jtfNombre.setBorder(Const.getBadBorder());
            i++;
        } else {
            jtfNombre.setBorder(Const.getOkBorder());
        }
        if (jtfContenido.getText().isEmpty()) {
            jtfContenido.setBorder(Const.getBadBorder());
            i++;
        } else {
            jtfContenido.setBorder(Const.getOkBorder());
        }
        if (jtfPrecio.getText().isEmpty()) {
            jtfPrecio.setBorder(Const.getBadBorder());
            i++;
        } else {
            jtfPrecio.setBorder(Const.getOkBorder());
        }
        return i != 0;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbNombre = new javax.swing.JLabel();
        jlbCargo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Create = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jbtQuitar1 = new javax.swing.JButton();
        jbtAgregar1 = new javax.swing.JButton();
        jtfClave = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfContenido = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jbtQuitar2 = new javax.swing.JButton();
        jcbUDM = new javax.swing.JComboBox<>();
        jcbMarcas = new javax.swing.JComboBox<>();
        Panel_Read = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Panel_Update = new javax.swing.JPanel();
        Panel_Delete = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DD/MM/YY");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(700, 0, 200, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 0, 900, 100);

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 142));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        Panel_Create.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.setLayout(null);

        jLabel11.setForeground(new java.awt.Color(1, 1, 1));
        jLabel11.setText("Nombre");
        Panel_Create.add(jLabel11);
        jLabel11.setBounds(30, 20, 200, 25);

        jLabel12.setForeground(new java.awt.Color(1, 1, 1));
        jLabel12.setText("Marca");
        Panel_Create.add(jLabel12);
        jLabel12.setBounds(30, 70, 200, 25);

        jLabel13.setForeground(new java.awt.Color(1, 1, 1));
        jLabel13.setText("Unidad de medida");
        Panel_Create.add(jLabel13);
        jLabel13.setBounds(30, 190, 200, 25);

        jLabel14.setForeground(new java.awt.Color(1, 1, 1));
        jLabel14.setText("Precio");
        Panel_Create.add(jLabel14);
        jLabel14.setBounds(30, 260, 200, 25);

        jbtQuitar1.setBackground(new java.awt.Color(182, 182, 182));
        jbtQuitar1.setForeground(new java.awt.Color(0, 0, 0));
        jbtQuitar1.setText("Generar Clave");
        jbtQuitar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtQuitar1);
        jbtQuitar1.setBounds(30, 320, 140, 25);

        jbtAgregar1.setBackground(new java.awt.Color(182, 182, 182));
        jbtAgregar1.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar1.setText("Agregar");
        jbtAgregar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtAgregar1);
        jbtAgregar1.setBounds(580, 30, 140, 50);

        jtfClave.setBackground(new java.awt.Color(255, 255, 255));
        jtfClave.setForeground(new java.awt.Color(0, 0, 0));
        jtfClave.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfClave.setEnabled(false);
        Panel_Create.add(jtfClave);
        jtfClave.setBounds(230, 320, 300, 25);

        jLabel15.setForeground(new java.awt.Color(1, 1, 1));
        jLabel15.setText("Contenido");
        Panel_Create.add(jLabel15);
        jLabel15.setBounds(30, 130, 200, 25);

        jtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfNombre);
        jtfNombre.setBounds(230, 20, 300, 25);

        jtfContenido.setBackground(new java.awt.Color(255, 255, 255));
        jtfContenido.setForeground(new java.awt.Color(0, 0, 0));
        jtfContenido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfContenido);
        jtfContenido.setBounds(230, 130, 300, 25);

        jtfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jtfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfPrecio);
        jtfPrecio.setBounds(230, 260, 300, 25);

        jbtQuitar2.setBackground(new java.awt.Color(182, 182, 182));
        jbtQuitar2.setForeground(new java.awt.Color(0, 0, 0));
        jbtQuitar2.setText("Cancelar");
        jbtQuitar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtQuitar2);
        jbtQuitar2.setBounds(740, 30, 140, 50);

        jcbUDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lt", "ml", "Kg", "gr" }));
        Panel_Create.add(jcbUDM);
        jcbUDM.setBounds(230, 190, 300, 25);

        jcbMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sabritas", "Coca Cola" }));
        Panel_Create.add(jcbMarcas);
        jcbMarcas.setBounds(230, 70, 300, 25);

        jTabbedPane1.addTab("Insertar", Panel_Create);

        Panel_Read.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Read.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Read.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        Panel_Read.add(jScrollPane1);
        jScrollPane1.setBounds(0, 102, 890, 360);

        jButton1.setText("Mostrar");
        Panel_Read.add(jButton1);
        jButton1.setBounds(0, 0, 150, 28);

        jTabbedPane1.addTab("Consultar", Panel_Read);

        Panel_Update.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.setLayout(null);
        jTabbedPane1.addTab("Modificar", Panel_Update);

        Panel_Delete.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.setLayout(null);
        jTabbedPane1.addTab("Borrar", Panel_Delete);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(300, 100, 900, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Create;
    private javax.swing.JPanel Panel_Delete;
    private javax.swing.JPanel Panel_Read;
    private javax.swing.JPanel Panel_Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtAgregar1;
    private javax.swing.JButton jbtQuitar1;
    private javax.swing.JButton jbtQuitar2;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<String> jcbMarcas;
    private javax.swing.JComboBox<String> jcbUDM;
    private javax.swing.JLabel jlbCargo;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JTextField jtfClave;
    private javax.swing.JTextField jtfContenido;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}
