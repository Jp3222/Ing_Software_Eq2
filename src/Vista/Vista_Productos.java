package Vista;

import Controlador.Con_Productos;
import Controlador.Evt_Ventana;
import Controlador.Sistema;
import Modelo.cons;
import Modelo.CL_Producto;
import Modelo.Reportes;
import Modelo.func;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Vista_Productos extends javax.swing.JFrame {

    private Con_Productos controlador;
    //
    private Create create;
    private Read read;
    private Update update;
    private Delete delete;
    //
    private Vista_Info info;
    //
    private Evt_Ventana evt_Ventana;

    public Vista_Productos(Vista_MenuAdmin admin) {
        //tareas
        this.create = new Create();
        this.read = new Read();
        this.update = new Update();
        this.delete = new Delete();
        //sistema
        this.setIconImage(new ImageIcon(getClass().getResource("/Img/Icono.png")).getImage());
        //
        info = Vista_Info.getNodo();
        initComponents();
        addControladores(admin);
        jtfNombre.getDocument().addDocumentListener(new Evt(jtfNombre));
        evt_Ventana = Evt_Ventana.getNodo();
        addWindowListener(evt_Ventana);

    }

    private void addControladores(Vista_MenuAdmin admin) {
        controlador = new Con_Productos(this, admin);
        jbtAtras.addActionListener(controlador);
        //Create
        jbtAgregar.addActionListener(controlador);
        jbtCancelar.addActionListener(controlador);
        //Read
        jbtConsultar.addActionListener(controlador);
        //update
        jbtBuscar.addActionListener(controlador);
        jbtActualizar.addActionListener(controlador);
        jbtCancelar_2.addActionListener(controlador);
        //delete
        jbtBuscar_2.addActionListener(controlador);
        jbtRemover.addActionListener(controlador);
        jbtCancelar_3.addActionListener(controlador);
    }

    class Evt implements DocumentListener {

        JTextField s;

        public Evt(JTextField s) {
            this.s = s;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (!s.getText().isEmpty()) {
                s.setBorder(cons.getOkBorder());
            } else {
                s.setBorder(cons.getBadBorder());
            }

        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            System.out.println("3");
        }

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
            values[0] = "NA";
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
                jtfNombre.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfNombre.setBorder(cons.getOkBorder());
            }
            if (jtfContenido.getText().isEmpty()) {
                jtfContenido.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfContenido.setBorder(cons.getOkBorder());
            }
            if (jtfPrecio.getText().isEmpty()) {
                jtfPrecio.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfPrecio.setBorder(cons.getOkBorder());
            }
            if (i > 0) {
                cons.getMessage("Hay campos", "Vacios", "", JOptionPane.WARNING_MESSAGE);
            }
            return i != 0;

        }

        public void Empty() {
            jtfNombre.setText("");
            if (!jcKMarca.isSelected()) {
                jcbMarcas.setSelectedIndex(0);
            }
            jtfContenido.setText("");
            if (!jckUD.isSelected()) {
                jcbUDM.setSelectedIndex(0);
            }
            jtfPrecio.setText("");

        }

        public JButton getJbtCancelar() {
            return jbtCancelar;
        }

    }

    public class Read {

        public JTable getJtConsultas() {
            return jtConsultas;
        }

        public JButton getJbtConsultar() {
            return jbtConsultar;
        }

    }

    public class Update {

        private CL_Producto producto;

        public String getValue() {
            return jtfMD.getText();
        }

        public String getCampo() {
            int index = jcbMB.getSelectedIndex();
            return jcbMB.getItemAt(index);
        }

        public JButton getJbtBuscar() {
            return jbtBuscar;
        }

        public CL_Producto getProducto() {
            producto.setNombre(jtfNombre_2.getText());
            producto.setMarca(jcbMarcas_2.getItemAt(jcbMB_2.getSelectedIndex()));
            producto.setContenido(Double.parseDouble(jtfContenido_2.getText()));
            producto.setUDM(jcbUDM_2.getItemAt(jcbUDM_2.getSelectedIndex()));
            producto.setPrecios(Double.parseDouble(jtfPrecio_2.getText()));
            return producto;
        }

        public void setProducto(CL_Producto producto) {
            this.producto = producto;
            set(producto);
        }

        public void set(CL_Producto producto) {
            jtfID.setText("" + producto.getID());
            jtfClave_2.setText(producto.getClave());
            jtfNombre_2.setText(producto.getNombre());
            jcbMarcas_2.setSelectedItem(producto.getMarca());
            jtfContenido_2.setText("" + producto.getContenido());
            jcbUDM_2.setSelectedItem(producto.getUDM());
            jtfPrecio_2.setText("" + producto.getPrecios());
        }

        public void clearS() {
            jcbMB.setSelectedIndex(0);
            jtfMD.setText("");
        }

        public void clear() {
            jtfID.setText("");
            jtfClave_2.setText("");
            jtfNombre_2.setText("");
            jcbMarcas_2.setSelectedIndex(0);
            jtfContenido_2.setText("");
            jcbUDM_2.setSelectedIndex(0);
            jtfPrecio_2.setText("");
        }

        public boolean isEmpty_MD() {
            return jtfMD.getText().isEmpty();
        }

        public boolean isEmpty_Values() {
            int i = 0;
            if (jtfNombre_2.getText().isEmpty()) {
                jtfNombre_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfNombre_2.setBorder(cons.getOkBorder());
            }
            if (jtfContenido_2.getText().isEmpty()) {
                jtfContenido_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfContenido_2.setBorder(cons.getOkBorder());
            }
            if (jtfPrecio_2.getText().isEmpty()) {
                jtfPrecio.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfPrecio_2.setBorder(cons.getOkBorder());
            }
            if (i > 0) {
                cons.getMessage("Hay campos", "Vacios", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
            return i != 0;
        }

    }

    public class Delete {

        private CL_Producto producto;

        public CL_Producto getProducto() {
            return producto;
        }

        public void setProducto(CL_Producto producto) {
            this.producto = producto;
            showProducto();
        }

        public boolean isEmpty() {
            int i = 0;
            if (jtfMB.getText().isEmpty()) {
                i++;
            }
            return i > 0;
        }

        public void showProducto() {
            if (producto != null) {
                jtaInfo.setText(producto.toString());
            }
        }

        public String getCampo() {
            int index = jcbMB_2.getSelectedIndex();
            return jcbMB_2.getItemAt(index);
        }

        public String getValue() {
            return jtfMB.getText();
        }

        public JButton getJbtBuscar_2() {
            return jbtBuscar_2;
        }

        public void clear() {
            jtaInfo.setText(producto.toString());
            producto = null;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtAtras = new javax.swing.JButton();
        jbtInfo = new javax.swing.JButton();
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
        jbtAgregar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jckUD = new javax.swing.JCheckBox();
        jcKMarca = new javax.swing.JCheckBox();
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
        jtfMB = new javax.swing.JTextField();
        jbtBuscar_2 = new javax.swing.JButton();
        jbtRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaInfo = new javax.swing.JTextArea();
        jbtCancelar_3 = new javax.swing.JButton();
        txt15 = new javax.swing.JLabel();
        jrbClave = new javax.swing.JRadioButton();
        jrbMarca = new javax.swing.JRadioButton();
        jrbPrecio = new javax.swing.JRadioButton();
        Reporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(35, 35, 40));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 255)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(35, 35, 40));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 280, 200);

        jbtAtras.setBackground(new java.awt.Color(255, 0, 0));
        jbtAtras.setForeground(new java.awt.Color(0, 0, 0));
        jbtAtras.setText("Atras");
        jbtAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jbtAtras);
        jbtAtras.setBounds(10, 520, 260, 50);

        jbtInfo.setBackground(new java.awt.Color(200, 0, 255));
        jbtInfo.setForeground(new java.awt.Color(0, 0, 0));
        jbtInfo.setText("Info");
        jbtInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInfoActionPerformed(evt);
            }
        });
        jPanel2.add(jbtInfo);
        jbtInfo.setBounds(10, 320, 260, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 280, 580);

        jTabbedPane1.setBackground(new java.awt.Color(254, 254, 254));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        Panel_Create.setBackground(new java.awt.Color(35, 35, 40));
        Panel_Create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.setLayout(null);

        txt1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt1.setForeground(new java.awt.Color(254, 254, 254));
        txt1.setText("Nombre");
        Panel_Create.add(txt1);
        txt1.setBounds(30, 20, 200, 25);

        jtfNombre.setBackground(new java.awt.Color(254, 254, 254));
        jtfNombre.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfNombre);
        jtfNombre.setBounds(230, 20, 300, 25);

        txt2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt2.setForeground(new java.awt.Color(254, 254, 254));
        txt2.setText("Marca");
        Panel_Create.add(txt2);
        txt2.setBounds(30, 70, 200, 25);

        jcbMarcas.setBackground(new java.awt.Color(35, 35, 40));
        jcbMarcas.setForeground(new java.awt.Color(254, 254, 254));
        jcbMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grat Value", "Nestle", "Bombo", "Lala ", "Danone", "Sabritas ", "Marinela ", "Alpura", "Kellogs ", "Quaker ", "Coca cola", "La costeña", "Sigma", "Barcel", "Gamesa ", "Knorr ", "Bonafont ", "Jumex ", "Peñafiel ", "McCormick" }));
        jcbMarcas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jcbMarcas);
        jcbMarcas.setBounds(230, 70, 300, 25);

        txt3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt3.setForeground(new java.awt.Color(254, 254, 254));
        txt3.setText("Contenido");
        Panel_Create.add(txt3);
        txt3.setBounds(30, 130, 200, 25);

        jtfContenido.setBackground(new java.awt.Color(254, 254, 254));
        jtfContenido.setForeground(new java.awt.Color(0, 0, 0));
        jtfContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfContenido.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfContenido);
        jtfContenido.setBounds(230, 130, 300, 25);

        txt4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt4.setForeground(new java.awt.Color(254, 254, 254));
        txt4.setText("Unidad de medida");
        Panel_Create.add(txt4);
        txt4.setBounds(30, 190, 200, 25);

        jcbUDM.setBackground(new java.awt.Color(35, 35, 40));
        jcbUDM.setForeground(new java.awt.Color(254, 254, 254));
        jcbUDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lt", "ml", "Kg", "gr", "Oz", "Pz", " " }));
        jcbUDM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jcbUDM);
        jcbUDM.setBounds(230, 190, 300, 25);

        txt5.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt5.setForeground(new java.awt.Color(254, 254, 254));
        txt5.setText("Precio");
        Panel_Create.add(txt5);
        txt5.setBounds(30, 260, 200, 25);

        jtfPrecio.setBackground(new java.awt.Color(254, 254, 254));
        jtfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        jtfPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfPrecio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfPrecio);
        jtfPrecio.setBounds(230, 260, 300, 25);

        jbtAgregar.setBackground(new java.awt.Color(213, 216, 220));
        jbtAgregar.setForeground(new java.awt.Color(0, 0, 0));
        jbtAgregar.setText("Agregar");
        jbtAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtAgregar);
        jbtAgregar.setBounds(230, 310, 140, 50);

        jbtCancelar.setBackground(new java.awt.Color(255, 0, 0));
        jbtCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar.setText("Cancelar");
        jbtCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.add(jbtCancelar);
        jbtCancelar.setBounds(390, 310, 140, 50);

        jckUD.setText("No cambiar");
        Panel_Create.add(jckUD);
        jckUD.setBounds(540, 190, 97, 24);

        jcKMarca.setText("No cambiar");
        Panel_Create.add(jcKMarca);
        jcKMarca.setBounds(540, 70, 97, 24);

        jTabbedPane1.addTab("Insertar", Panel_Create);

        Panel_Read.setBackground(new java.awt.Color(35, 35, 40));
        Panel_Read.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Read.setLayout(null);

        jtConsultas.setAutoCreateRowSorter(true);
        jtConsultas.setBackground(new java.awt.Color(35, 35, 40));
        jtConsultas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 107, 255)));
        jtConsultas.setForeground(new java.awt.Color(254, 254, 254));
        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Nombre", "Marca", "Contenido", "udm", "precio"
            }
        ));
        jtConsultas.setEnabled(false);
        jtConsultas.setFillsViewportHeight(true);
        jtConsultas.setSelectionBackground(new java.awt.Color(35, 35, 40));
        jtConsultas.setSelectionForeground(new java.awt.Color(254, 254, 254));
        jtConsultas.setShowGrid(true);
        jScrollPane1.setViewportView(jtConsultas);

        Panel_Read.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 860, 360);

        jbtConsultar.setText("Mostrar");
        Panel_Read.add(jbtConsultar);
        jbtConsultar.setBounds(20, 40, 150, 29);

        jTabbedPane1.addTab("Consultar", Panel_Read);

        Panel_Update.setBackground(new java.awt.Color(35, 35, 40));
        Panel_Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.setLayout(null);

        txt6.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt6.setForeground(new java.awt.Color(254, 254, 254));
        txt6.setText("Buscar");
        Panel_Update.add(txt6);
        txt6.setBounds(70, 10, 100, 25);

        jcbMB.setBackground(new java.awt.Color(35, 35, 40));
        jcbMB.setForeground(new java.awt.Color(254, 254, 254));
        jcbMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        jcbMB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        Panel_Update.add(jcbMB);
        jcbMB.setBounds(170, 10, 100, 25);

        jtfMD.setBackground(new java.awt.Color(254, 254, 254));
        jtfMD.setForeground(new java.awt.Color(1, 1, 1));
        jtfMD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfMD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfMD);
        jtfMD.setBounds(270, 10, 300, 25);

        jbtBuscar.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar.setText("Buscar");
        jbtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });
        Panel_Update.add(jbtBuscar);
        jbtBuscar.setBounds(590, 10, 140, 25);

        txt7.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt7.setForeground(new java.awt.Color(254, 254, 254));
        txt7.setText("ID");
        Panel_Update.add(txt7);
        txt7.setBounds(70, 60, 200, 25);

        jtfID.setEditable(false);
        jtfID.setBackground(new java.awt.Color(254, 254, 254));
        jtfID.setForeground(new java.awt.Color(1, 1, 1));
        jtfID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfID);
        jtfID.setBounds(270, 60, 300, 25);

        txt8.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt8.setForeground(new java.awt.Color(254, 254, 254));
        txt8.setText("Clave");
        Panel_Update.add(txt8);
        txt8.setBounds(70, 110, 200, 25);

        jtfClave_2.setEditable(false);
        jtfClave_2.setBackground(new java.awt.Color(254, 254, 254));
        jtfClave_2.setForeground(new java.awt.Color(1, 1, 1));
        jtfClave_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfClave_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfClave_2);
        jtfClave_2.setBounds(270, 110, 300, 25);

        txt9.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt9.setForeground(new java.awt.Color(254, 254, 254));
        txt9.setText("Nombre");
        Panel_Update.add(txt9);
        txt9.setBounds(70, 160, 200, 25);

        jtfNombre_2.setBackground(new java.awt.Color(254, 254, 254));
        jtfNombre_2.setForeground(new java.awt.Color(1, 1, 1));
        jtfNombre_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfNombre_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfNombre_2);
        jtfNombre_2.setBounds(270, 160, 300, 25);

        txt10.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt10.setForeground(new java.awt.Color(254, 254, 254));
        txt10.setText("Marca");
        Panel_Update.add(txt10);
        txt10.setBounds(70, 210, 200, 25);

        jcbMarcas_2.setBackground(new java.awt.Color(35, 35, 40));
        jcbMarcas_2.setForeground(new java.awt.Color(254, 254, 254));
        jcbMarcas_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sabritas", "Coca Cola" }));
        jcbMarcas_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        Panel_Update.add(jcbMarcas_2);
        jcbMarcas_2.setBounds(270, 210, 300, 25);

        txt11.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt11.setForeground(new java.awt.Color(254, 254, 254));
        txt11.setText("Contenido");
        Panel_Update.add(txt11);
        txt11.setBounds(70, 260, 200, 25);

        jtfContenido_2.setBackground(new java.awt.Color(254, 254, 254));
        jtfContenido_2.setForeground(new java.awt.Color(1, 1, 1));
        jtfContenido_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfContenido_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfContenido_2);
        jtfContenido_2.setBounds(270, 260, 300, 25);

        txt12.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt12.setForeground(new java.awt.Color(254, 254, 254));
        txt12.setText("Unidad de medida");
        Panel_Update.add(txt12);
        txt12.setBounds(70, 310, 200, 25);

        jcbUDM_2.setBackground(new java.awt.Color(35, 35, 40));
        jcbUDM_2.setForeground(new java.awt.Color(254, 254, 254));
        jcbUDM_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lt", "ml", "Kg", "gr" }));
        jcbUDM_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        Panel_Update.add(jcbUDM_2);
        jcbUDM_2.setBounds(270, 310, 300, 25);

        txt13.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt13.setForeground(new java.awt.Color(254, 254, 254));
        txt13.setText("Precio");
        Panel_Update.add(txt13);
        txt13.setBounds(70, 360, 200, 25);

        jtfPrecio_2.setBackground(new java.awt.Color(254, 254, 254));
        jtfPrecio_2.setForeground(new java.awt.Color(1, 1, 1));
        jtfPrecio_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1)));
        jtfPrecio_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfPrecio_2);
        jtfPrecio_2.setBounds(270, 360, 300, 25);

        jbtActualizar.setBackground(new java.awt.Color(182, 182, 182));
        jbtActualizar.setForeground(new java.awt.Color(0, 0, 0));
        jbtActualizar.setText("Actualizar");
        jbtActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtActualizarActionPerformed(evt);
            }
        });
        Panel_Update.add(jbtActualizar);
        jbtActualizar.setBounds(590, 60, 140, 50);

        jbtCancelar_2.setBackground(new java.awt.Color(182, 182, 182));
        jbtCancelar_2.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar_2.setText("Cancelar");
        jbtCancelar_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.add(jbtCancelar_2);
        jbtCancelar_2.setBounds(590, 120, 140, 50);

        jTabbedPane1.addTab("Modificar", Panel_Update);

        Panel_Delete.setBackground(new java.awt.Color(35, 35, 40));
        Panel_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.setLayout(null);

        txt14.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt14.setForeground(new java.awt.Color(254, 254, 254));
        txt14.setText("Buscar");
        Panel_Delete.add(txt14);
        txt14.setBounds(70, 10, 100, 25);

        jcbMB_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Clave", "Nombre" }));
        Panel_Delete.add(jcbMB_2);
        jcbMB_2.setBounds(170, 10, 100, 25);

        jtfMB.setBackground(new java.awt.Color(255, 255, 255));
        jtfMB.setForeground(new java.awt.Color(0, 0, 0));
        jtfMB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Delete.add(jtfMB);
        jtfMB.setBounds(270, 10, 250, 25);

        jbtBuscar_2.setBackground(new java.awt.Color(182, 182, 182));
        jbtBuscar_2.setForeground(new java.awt.Color(0, 0, 0));
        jbtBuscar_2.setText("Buscar");
        jbtBuscar_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.add(jbtBuscar_2);
        jbtBuscar_2.setBounds(570, 10, 120, 25);

        jbtRemover.setBackground(new java.awt.Color(182, 182, 182));
        jbtRemover.setForeground(new java.awt.Color(0, 0, 0));
        jbtRemover.setText("Eliminar");
        jbtRemover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtRemover.setOpaque(true);
        Panel_Delete.add(jbtRemover);
        jbtRemover.setBounds(640, 70, 140, 50);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));

        jtaInfo.setEditable(false);
        jtaInfo.setBackground(new java.awt.Color(255, 255, 255));
        jtaInfo.setColumns(20);
        jtaInfo.setForeground(new java.awt.Color(0, 0, 0));
        jtaInfo.setRows(5);
        jScrollPane2.setViewportView(jtaInfo);

        Panel_Delete.add(jScrollPane2);
        jScrollPane2.setBounds(70, 40, 450, 370);

        jbtCancelar_3.setBackground(new java.awt.Color(255, 0, 0));
        jbtCancelar_3.setForeground(new java.awt.Color(0, 0, 0));
        jbtCancelar_3.setText("Cancelar");
        jbtCancelar_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbtCancelar_3.setOpaque(true);
        Panel_Delete.add(jbtCancelar_3);
        jbtCancelar_3.setBounds(640, 160, 140, 50);

        jTabbedPane1.addTab("Borrar", Panel_Delete);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(300, 10, 890, 480);

        txt15.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txt15.setForeground(new java.awt.Color(254, 254, 254));
        txt15.setText("Caracteristicas del reporte");
        jPanel1.add(txt15);
        txt15.setBounds(300, 490, 240, 25);

        jrbClave.setBackground(new java.awt.Color(35, 35, 40));
        jrbClave.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jrbClave.setForeground(new java.awt.Color(254, 254, 254));
        jrbClave.setText("Clave");
        jPanel1.add(jrbClave);
        jrbClave.setBounds(300, 520, 110, 24);

        jrbMarca.setBackground(new java.awt.Color(35, 35, 40));
        jrbMarca.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jrbMarca.setForeground(new java.awt.Color(254, 254, 254));
        jrbMarca.setText("Marca");
        jPanel1.add(jrbMarca);
        jrbMarca.setBounds(410, 520, 110, 24);

        jrbPrecio.setBackground(new java.awt.Color(35, 35, 40));
        jrbPrecio.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jrbPrecio.setForeground(new java.awt.Color(254, 254, 254));
        jrbPrecio.setText("Precio");
        jPanel1.add(jrbPrecio);
        jrbPrecio.setBounds(300, 550, 110, 24);

        Reporte.setBackground(new java.awt.Color(255, 0, 0));
        Reporte.setForeground(new java.awt.Color(0, 0, 0));
        Reporte.setText("Generar reporte");
        Reporte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });
        jPanel1.add(Reporte);
        Reporte.setBounds(540, 490, 140, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInfoActionPerformed
        info.setTxt(0);
        info.setVisible(true);

    }//GEN-LAST:event_jbtInfoActionPerformed

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        try {
            ArrayList<String> lista = new ArrayList<>(0);
            lista.addAll(Arrays.asList("ID" , "Nombre", "Contenido", "UDM"));
            if (jrbMarca.isSelected()) {
                lista.add("Marca");
            }
            if (jrbPrecio.isSelected()) {
                lista.add("Precio");
            }
            if (jrbClave.isSelected()) {
                lista.add("clave");
            }
            String p = Sistema.getNodo().getNodoRlg().getFecha();
            String q = Sistema.getNodo().getNodoRlg().getRelog();
            Reportes r = new Reportes(2, "Listado de productos-" + p + "-" + q);
            r.crearReporte("productos", lista.toArray(new String[lista.size()]));
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_ReporteActionPerformed

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jbtActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Create;
    private javax.swing.JPanel Panel_Delete;
    private javax.swing.JPanel Panel_Read;
    private javax.swing.JPanel Panel_Update;
    private javax.swing.JButton Reporte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtActualizar;
    private javax.swing.JButton jbtAgregar;
    private javax.swing.JButton jbtAtras;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtBuscar_2;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtCancelar_2;
    private javax.swing.JButton jbtCancelar_3;
    private javax.swing.JButton jbtConsultar;
    private javax.swing.JButton jbtInfo;
    private javax.swing.JButton jbtRemover;
    private javax.swing.JCheckBox jcKMarca;
    private javax.swing.JComboBox<String> jcbMB;
    private javax.swing.JComboBox<String> jcbMB_2;
    private javax.swing.JComboBox<String> jcbMarcas;
    private javax.swing.JComboBox<String> jcbMarcas_2;
    private javax.swing.JComboBox<String> jcbUDM;
    private javax.swing.JComboBox<String> jcbUDM_2;
    private javax.swing.JCheckBox jckUD;
    private javax.swing.JRadioButton jrbClave;
    private javax.swing.JRadioButton jrbMarca;
    private javax.swing.JRadioButton jrbPrecio;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextArea jtaInfo;
    private javax.swing.JTextField jtfClave_2;
    private javax.swing.JTextField jtfContenido;
    private javax.swing.JTextField jtfContenido_2;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMB;
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
    private javax.swing.JLabel txt15;
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
