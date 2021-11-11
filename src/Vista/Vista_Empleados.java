package Vista;

import Controlador.Con_Empleado;

/**
 *
 * @author jp
 */
public class Vista_Empleados extends javax.swing.JFrame {
    
    private Con_Empleado controlador;
    
    public Vista_Empleados(Vista_MenuAdmin admin) {
        //
        controlador = new Con_Empleado(this);
        controlador.setAdmin(admin);
        //
        initComponents();
        //
        Cont();
    }
    
    public void Cont() {
        jbtAtras.addActionListener(controlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtAtras = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Create = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        jftEdad = new javax.swing.JTextField();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        jtfAmaterno = new javax.swing.JTextField();
        txt4 = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jbtAgregar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        txt5 = new javax.swing.JLabel();
        txt6 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfApaterno = new javax.swing.JTextField();
        jcbCargo = new javax.swing.JComboBox<>();
        Panel_Read = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jbtConsultar = new javax.swing.JButton();
        Panel_Update = new javax.swing.JPanel();
        txt8 = new javax.swing.JLabel();
        jcbMB = new javax.swing.JComboBox<>();
        jtfMD = new javax.swing.JTextField();
        jbtBuscar = new javax.swing.JButton();
        jbtActualizar = new javax.swing.JButton();
        jbtCancelar_2 = new javax.swing.JButton();
        Panel_Delete = new javax.swing.JPanel();
        txt14 = new javax.swing.JLabel();
        jcbMB_2 = new javax.swing.JComboBox<>();
        jftMB = new javax.swing.JTextField();
        jbtBuscar_2 = new javax.swing.JButton();
        jbtRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbtCancelar_3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(171, 178, 185));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(177, 177, 255));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 300, 200);

        jbtAtras.setBackground(new java.awt.Color(255, 0, 0));
        jbtAtras.setForeground(new java.awt.Color(0, 0, 0));
        jbtAtras.setText("Atras");
        jbtAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtAtras);
        jbtAtras.setBounds(0, 550, 300, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 300, 600);

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 250));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        Panel_Create.setBackground(new java.awt.Color(171, 178, 185));
        Panel_Create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.setLayout(null);

        txt1.setForeground(new java.awt.Color(1, 1, 1));
        txt1.setText("Nombre :");
        Panel_Create.add(txt1);
        txt1.setBounds(30, 20, 200, 25);

        jftEdad.setBackground(new java.awt.Color(255, 255, 255));
        jftEdad.setForeground(new java.awt.Color(0, 0, 0));
        jftEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jftEdad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jftEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftEdadActionPerformed(evt);
            }
        });
        Panel_Create.add(jftEdad);
        jftEdad.setBounds(230, 170, 300, 25);

        txt2.setForeground(new java.awt.Color(1, 1, 1));
        txt2.setText("Apellido Paterno");
        Panel_Create.add(txt2);
        txt2.setBounds(30, 70, 200, 25);

        txt3.setForeground(new java.awt.Color(1, 1, 1));
        txt3.setText("Apellido Materno");
        Panel_Create.add(txt3);
        txt3.setBounds(30, 120, 200, 25);

        jtfAmaterno.setBackground(new java.awt.Color(255, 255, 255));
        jtfAmaterno.setForeground(new java.awt.Color(0, 0, 0));
        jtfAmaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfAmaterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfAmaterno);
        jtfAmaterno.setBounds(230, 120, 300, 25);

        txt4.setForeground(new java.awt.Color(1, 1, 1));
        txt4.setText("Edad");
        Panel_Create.add(txt4);
        txt4.setBounds(30, 170, 200, 25);

        txt7.setForeground(new java.awt.Color(1, 1, 1));
        txt7.setText("Contraseña");
        Panel_Create.add(txt7);
        txt7.setBounds(30, 320, 200, 25);

        jtfPassword.setBackground(new java.awt.Color(255, 255, 255));
        jtfPassword.setForeground(new java.awt.Color(0, 0, 0));
        jtfPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfPassword.setEnabled(false);
        Panel_Create.add(jtfPassword);
        jtfPassword.setBounds(230, 320, 300, 25);

        jbtAgregar.setBackground(new java.awt.Color(213, 216, 220));
        jbtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar.setText("Agregar");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtAgregar);
        jbtAgregar.setBounds(580, 30, 140, 50);

        jbtCancelar.setBackground(new java.awt.Color(255, 0, 0));
        jbtCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtCancelar);
        jbtCancelar.setBounds(740, 30, 140, 50);

        txt5.setForeground(new java.awt.Color(1, 1, 1));
        txt5.setText("Cargo");
        Panel_Create.add(txt5);
        txt5.setBounds(30, 220, 200, 25);

        txt6.setForeground(new java.awt.Color(1, 1, 1));
        txt6.setText("Usuario");
        Panel_Create.add(txt6);
        txt6.setBounds(30, 270, 200, 25);

        jtfUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jtfUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jtfUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfUsuario.setEnabled(false);
        Panel_Create.add(jtfUsuario);
        jtfUsuario.setBounds(230, 270, 300, 25);

        jtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfNombre);
        jtfNombre.setBounds(230, 20, 300, 25);

        jtfApaterno.setBackground(new java.awt.Color(255, 255, 255));
        jtfApaterno.setForeground(new java.awt.Color(0, 0, 0));
        jtfApaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfApaterno.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfApaterno);
        jtfApaterno.setBounds(230, 70, 300, 25);

        jcbCargo.setBackground(new java.awt.Color(213, 216, 220));
        jcbCargo.setForeground(new java.awt.Color(0, 0, 0));
        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Empleado" }));
        jcbCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jcbCargo);
        jcbCargo.setBounds(230, 220, 300, 25);

        jTabbedPane1.addTab("Insertar", Panel_Create);

        Panel_Read.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Read.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Read.setLayout(null);

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Nombre", "Marca", "Contenido", "udm", "precio"
            }
        ));
        jScrollPane1.setViewportView(jtConsultas);

        Panel_Read.add(jScrollPane1);
        jScrollPane1.setBounds(0, 102, 890, 360);

        jbtConsultar.setText("Mostrar");
        Panel_Read.add(jbtConsultar);
        jbtConsultar.setBounds(0, 0, 150, 29);

        jTabbedPane1.addTab("Consultar", Panel_Read);

        Panel_Update.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.setLayout(null);

        txt8.setForeground(new java.awt.Color(1, 1, 1));
        txt8.setText("Buscar");
        Panel_Update.add(txt8);
        txt8.setBounds(70, 10, 120, 25);

        jcbMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        Panel_Update.add(jcbMB);
        jcbMB.setBounds(210, 10, 100, 25);

        jtfMD.setBackground(new java.awt.Color(255, 255, 255));
        jtfMD.setForeground(new java.awt.Color(0, 0, 0));
        jtfMD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfMD);
        jtfMD.setBounds(330, 10, 300, 25);

        jbtBuscar.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar.setText("Buscar");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.add(jbtBuscar);
        jbtBuscar.setBounds(650, 10, 120, 25);

        jbtActualizar.setBackground(new java.awt.Color(182, 182, 182));
        jbtActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jbtActualizar.setText("Actualizar");
        jbtActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.add(jbtActualizar);
        jbtActualizar.setBounds(650, 60, 140, 50);

        jbtCancelar_2.setBackground(new java.awt.Color(182, 182, 182));
        jbtCancelar_2.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar_2.setText("Cancelar");
        jbtCancelar_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.add(jbtCancelar_2);
        jbtCancelar_2.setBounds(650, 130, 140, 50);

        jTabbedPane1.addTab("Modificar", Panel_Update);

        Panel_Delete.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.setLayout(null);

        txt14.setForeground(new java.awt.Color(1, 1, 1));
        txt14.setText("Buscar");
        Panel_Delete.add(txt14);
        txt14.setBounds(70, 10, 120, 25);

        jcbMB_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        Panel_Delete.add(jcbMB_2);
        jcbMB_2.setBounds(210, 10, 100, 25);

        jftMB.setBackground(new java.awt.Color(255, 255, 255));
        jftMB.setForeground(new java.awt.Color(0, 0, 0));
        jftMB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Delete.add(jftMB);
        jftMB.setBounds(330, 10, 300, 25);

        jbtBuscar_2.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar_2.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar_2.setText("Buscar");
        jbtBuscar_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.add(jbtBuscar_2);
        jbtBuscar_2.setBounds(650, 10, 120, 25);

        jbtRemover.setBackground(new java.awt.Color(182, 182, 182));
        jbtRemover.setForeground(new java.awt.Color(0, 0, 0));
        jbtRemover.setText("Remover");
        jbtRemover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.add(jbtRemover);
        jbtRemover.setBounds(140, 260, 140, 50);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        Panel_Delete.add(jScrollPane2);
        jScrollPane2.setBounds(70, 80, 700, 150);

        jbtCancelar_3.setBackground(new java.awt.Color(182, 182, 182));
        jbtCancelar_3.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar_3.setText("Cancelar");
        jbtCancelar_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.add(jbtCancelar_3);
        jbtCancelar_3.setBounds(450, 260, 140, 50);

        jTabbedPane1.addTab("Borrar", Panel_Delete);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(300, 0, 900, 500);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jftEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftEdadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Create;
    private javax.swing.JPanel Panel_Delete;
    private javax.swing.JPanel Panel_Read;
    private javax.swing.JPanel Panel_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtActualizar;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtAtras;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtBuscar_2;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtCancelar_2;
    private javax.swing.JButton jbtCancelar_3;
    private javax.swing.JButton jbtConsultar;
    private javax.swing.JButton jbtRemover;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JComboBox<String> jcbMB;
    private javax.swing.JComboBox<String> jcbMB_2;
    private javax.swing.JTextField jftEdad;
    private javax.swing.JTextField jftMB;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextField jtfAmaterno;
    private javax.swing.JTextField jtfApaterno;
    private javax.swing.JTextField jtfMD;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt14;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    // End of variables declaration//GEN-END:variables
}
