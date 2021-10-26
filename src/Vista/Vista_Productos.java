package Vista;

import Controlador.Con_Productos;
import Controlador.Sistema;
import Modelo.Const;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Vista_Productos extends javax.swing.JFrame {

    private Con_Productos controlador;
    private Create create;
    private Read read;
    private Update update;
    private Delete delete;
    private Sistema relog;
    //
    private Vista_Info info;

    public Vista_Productos(Vista_MenuAdmin admin) {
        //tareas
        this.create = new Create();
        this.read = new Read();
        this.update = new Update();
        this.delete = new Delete();
        this.relog = Sistema.getNodo();
        //sistema
        relog.setJlbRelog(jlbRelog);
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Icono.png")).getImage());
        //
        info = Vista_Info.getNodo();
        initComponents();
        addControladores(admin);
    }

    private void addControladores(Vista_MenuAdmin admin) {
        controlador = new Con_Productos(this, admin);
        jbtAtras.addActionListener(controlador);
        //Create
        jbtAgregar.addActionListener(controlador);
        jbtCancelar.addActionListener(controlador);
        jbtGC.addActionListener(controlador);
        //Read
        jbtConsultar.addActionListener(controlador);
        jbtConsultar.addActionListener(controlador);

    }

    public Create getCreate() {
        return create;
    }

    public Read getRead() {
        return read;
    }

    public Update getUpdate() {
        return update;
    }

    public Delete getDelete() {
        return delete;
    }

    public class Create {

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

        public boolean isEmpty() {
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

        public void Empty() {
            jtfNombre.setText("");
            jcbMarcas.setSelectedIndex(0);
            jtfContenido.setText("");
            jcbUDM.setSelectedIndex(0);
            jtfPrecio.setText("");
            jtfClave.setText("");
        }

        public JTextField getJtfClave() {
            return jtfClave;
        }

        public JButton getJbtCancelar() {
            return jbtCancelar;
        }

    }

    public class Read {

        private DefaultTableModel modelo;

        public Read() {
            jtConsultas = new JTable();
            modelo = new DefaultTableModel();
            for (String producto : Const.getProductos()) {
                modelo.addColumn(producto);
            }
            jtConsultas.setModel(modelo);
        }

        public JTable getJtConsultas() {
            return jtConsultas;
        }

        public JButton getJbtConsultar() {
            return jbtConsultar;
        }

    }

    public class Update {

    }

    public class Delete {

        public Delete() {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtAtras = new javax.swing.JButton();
        jbtInventario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbNombre = new javax.swing.JLabel();
        jlbCargo = new javax.swing.JLabel();
        jlbRelog = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Create = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        txt2 = new javax.swing.JLabel();
        jcbMarcas = new javax.swing.JComboBox<>();
        txt3 = new javax.swing.JLabel();
        jtfContenido = new javax.swing.JTextField();
        txt4 = new javax.swing.JLabel();
        jcbUDM = new javax.swing.JComboBox<>();
        txt5 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jbtGC = new javax.swing.JButton();
        jtfClave = new javax.swing.JTextField();
        jbtAgregar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        Panel_Read = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jbtConsultar = new javax.swing.JButton();
        Panel_Update = new javax.swing.JPanel();
        txt6 = new javax.swing.JLabel();
        jcbMB = new javax.swing.JComboBox<>();
        jtfMD = new javax.swing.JTextField();
        jbtBuscar = new javax.swing.JButton();
        txt7 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        txt8 = new javax.swing.JLabel();
        jtfClave_2 = new javax.swing.JTextField();
        txt9 = new javax.swing.JLabel();
        jtfNombre_2 = new javax.swing.JTextField();
        txt10 = new javax.swing.JLabel();
        jcbMarcas_2 = new javax.swing.JComboBox<>();
        txt11 = new javax.swing.JLabel();
        jtfContenido_2 = new javax.swing.JTextField();
        txt12 = new javax.swing.JLabel();
        jcbUDM_2 = new javax.swing.JComboBox<>();
        txt13 = new javax.swing.JLabel();
        jtfPrecio_2 = new javax.swing.JTextField();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 193));
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

        jbtInventario.setBackground(new java.awt.Color(200, 0, 255));
        jbtInventario.setForeground(new java.awt.Color(0, 0, 0));
        jbtInventario.setText("Info");
        jbtInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(jbtInventario);
        jbtInventario.setBounds(0, 320, 300, 50);

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

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 0, 900, 100);

        jTabbedPane1.setBackground(new java.awt.Color(0, 255, 142));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        Panel_Create.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.setLayout(null);

        txt1.setForeground(new java.awt.Color(1, 1, 1));
        txt1.setText("Nombre");
        Panel_Create.add(txt1);
        txt1.setBounds(30, 20, 200, 25);

        jtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfNombre);
        jtfNombre.setBounds(230, 20, 300, 25);

        txt2.setForeground(new java.awt.Color(1, 1, 1));
        txt2.setText("Marca");
        Panel_Create.add(txt2);
        txt2.setBounds(30, 70, 200, 25);

        jcbMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sabritas", "Coca Cola" }));
        Panel_Create.add(jcbMarcas);
        jcbMarcas.setBounds(230, 70, 300, 25);

        txt3.setForeground(new java.awt.Color(1, 1, 1));
        txt3.setText("Contenido");
        Panel_Create.add(txt3);
        txt3.setBounds(30, 130, 200, 25);

        jtfContenido.setBackground(new java.awt.Color(255, 255, 255));
        jtfContenido.setForeground(new java.awt.Color(0, 0, 0));
        jtfContenido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfContenido);
        jtfContenido.setBounds(230, 130, 300, 25);

        txt4.setForeground(new java.awt.Color(1, 1, 1));
        txt4.setText("Unidad de medida");
        Panel_Create.add(txt4);
        txt4.setBounds(30, 190, 200, 25);

        jcbUDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lt", "ml", "Kg", "gr" }));
        Panel_Create.add(jcbUDM);
        jcbUDM.setBounds(230, 190, 300, 25);

        txt5.setForeground(new java.awt.Color(1, 1, 1));
        txt5.setText("Precio");
        Panel_Create.add(txt5);
        txt5.setBounds(30, 260, 200, 25);

        jtfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        jtfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfPrecio);
        jtfPrecio.setBounds(230, 260, 300, 25);

        jbtGC.setBackground(new java.awt.Color(182, 182, 182));
        jbtGC.setForeground(new java.awt.Color(0, 0, 0));
        jbtGC.setText("Generar Clave");
        jbtGC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtGC);
        jbtGC.setBounds(30, 320, 140, 25);

        jtfClave.setBackground(new java.awt.Color(255, 255, 255));
        jtfClave.setForeground(new java.awt.Color(0, 0, 0));
        jtfClave.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jtfClave.setEnabled(false);
        Panel_Create.add(jtfClave);
        jtfClave.setBounds(230, 320, 300, 25);

        jbtAgregar.setBackground(new java.awt.Color(182, 182, 182));
        jbtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar.setText("Agregar");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtAgregar);
        jbtAgregar.setBounds(580, 30, 140, 50);

        jbtCancelar.setBackground(new java.awt.Color(182, 182, 182));
        jbtCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtCancelar);
        jbtCancelar.setBounds(740, 30, 140, 50);

        jTabbedPane1.addTab("Insertar", Panel_Create);

        Panel_Read.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Read.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Read.setLayout(null);

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtConsultas);

        Panel_Read.add(jScrollPane1);
        jScrollPane1.setBounds(0, 102, 890, 360);

        jbtConsultar.setText("Mostrar");
        Panel_Read.add(jbtConsultar);
        jbtConsultar.setBounds(0, 0, 150, 28);

        jTabbedPane1.addTab("Consultar", Panel_Read);

        Panel_Update.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.setLayout(null);

        txt6.setForeground(new java.awt.Color(1, 1, 1));
        txt6.setText("Buscar");
        Panel_Update.add(txt6);
        txt6.setBounds(70, 10, 120, 25);

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

        txt7.setForeground(new java.awt.Color(1, 1, 1));
        txt7.setText("ID");
        Panel_Update.add(txt7);
        txt7.setBounds(70, 60, 200, 25);

        jtfID.setBackground(new java.awt.Color(255, 255, 255));
        jtfID.setForeground(new java.awt.Color(0, 0, 0));
        jtfID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfID);
        jtfID.setBounds(270, 60, 300, 25);

        txt8.setForeground(new java.awt.Color(1, 1, 1));
        txt8.setText("Clave");
        Panel_Update.add(txt8);
        txt8.setBounds(70, 110, 200, 25);

        jtfClave_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfClave_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfClave_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfClave_2);
        jtfClave_2.setBounds(270, 110, 300, 25);

        txt9.setForeground(new java.awt.Color(1, 1, 1));
        txt9.setText("Nombre");
        Panel_Update.add(txt9);
        txt9.setBounds(70, 160, 200, 25);

        jtfNombre_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfNombre_2);
        jtfNombre_2.setBounds(270, 160, 300, 25);

        txt10.setForeground(new java.awt.Color(1, 1, 1));
        txt10.setText("Marca");
        Panel_Update.add(txt10);
        txt10.setBounds(70, 210, 200, 25);

        jcbMarcas_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sabritas", "Coca Cola" }));
        Panel_Update.add(jcbMarcas_2);
        jcbMarcas_2.setBounds(270, 210, 300, 25);

        txt11.setForeground(new java.awt.Color(1, 1, 1));
        txt11.setText("Contenido");
        Panel_Update.add(txt11);
        txt11.setBounds(70, 260, 200, 25);

        jtfContenido_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfContenido_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfContenido_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfContenido_2);
        jtfContenido_2.setBounds(270, 260, 300, 25);

        txt12.setForeground(new java.awt.Color(1, 1, 1));
        txt12.setText("Unidad de medida");
        Panel_Update.add(txt12);
        txt12.setBounds(70, 310, 200, 25);

        jcbUDM_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lt", "ml", "Kg", "gr" }));
        Panel_Update.add(jcbUDM_2);
        jcbUDM_2.setBounds(270, 310, 300, 25);

        txt13.setForeground(new java.awt.Color(1, 1, 1));
        txt13.setText("Precio");
        Panel_Update.add(txt13);
        txt13.setBounds(70, 360, 200, 25);

        jtfPrecio_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfPrecio_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfPrecio_2);
        jtfPrecio_2.setBounds(270, 360, 300, 25);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInventarioActionPerformed
        info.setTxt(0);
        info.setVisible(true);

    }//GEN-LAST:event_jbtInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Create;
    private javax.swing.JPanel Panel_Delete;
    private javax.swing.JPanel Panel_Read;
    private javax.swing.JPanel Panel_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JButton jbtGC;
    private javax.swing.JButton jbtInventario;
    private javax.swing.JButton jbtRemover;
    private javax.swing.JComboBox<String> jcbMB;
    private javax.swing.JComboBox<String> jcbMB_2;
    private javax.swing.JComboBox<String> jcbMarcas;
    private javax.swing.JComboBox<String> jcbMarcas_2;
    private javax.swing.JComboBox<String> jcbUDM;
    private javax.swing.JComboBox<String> jcbUDM_2;
    private javax.swing.JTextField jftMB;
    private javax.swing.JLabel jlbCargo;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbRelog;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextField jtfClave;
    private javax.swing.JTextField jtfClave_2;
    private javax.swing.JTextField jtfContenido;
    private javax.swing.JTextField jtfContenido_2;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMD;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNombre_2;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfPrecio_2;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt10;
    private javax.swing.JLabel txt11;
    private javax.swing.JLabel txt12;
    private javax.swing.JLabel txt13;
    private javax.swing.JLabel txt14;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    private javax.swing.JLabel txt9;
    // End of variables declaration//GEN-END:variables
}
