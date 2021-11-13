package Vista;

import Controlador.Con_Empleado;
import Modelo.CL_Empleado;
import Modelo.cons;
import Modelo.func;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jp
 */
public class Vista_Empleados extends javax.swing.JFrame {

    //
    private Con_Empleado controlador;
    //
    private Create create;
    private Read read;
    private Update update;
    private Delete delete;

    public Vista_Empleados(Vista_MenuAdmin admin) {
        //
        controlador = new Con_Empleado(this);
        controlador.setAdmin(admin);
        //
        initComponents();
        //
        Cont();
    }

    private void Cont() {
        jbtAtras.addActionListener(controlador);
        //
        jbtAgregar.addActionListener(controlador);
        //
        jbtConsultar.addActionListener(controlador);
    }

    public Create getCreate() {
        if (create == null) {
            create = new Create();
        }
        return create;
    }

    public Read getRead() {
        if (read == null) {
            read = new Read();
        }
        return read;
    }

    public Update getUpdate() {
        return update;
    }

    public Delete getDelete() {
        return delete;
    }

    public class Create {

        private CL_Empleado empleado;
        private final String info[];

        private Create() {
            this.empleado = null;
            info = new String[7];
        }

        public boolean isEmpty() {
            int i = 0;
            //
            if (jtfUsuario.getText().isEmpty()) {
                jtfUsuario.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfUsuario.setBorder(cons.getOkBorder());
            }
            //
            if (jtfNombre.getText().isEmpty()) {
                jtfNombre.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfNombre.setBorder(cons.getOkBorder());
            }
            //
            if (jtfApaterno.getText().isEmpty()) {
                jtfApaterno.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfApaterno.setBorder(cons.getOkBorder());
            }
            //
            if (jtfAmaterno.getText().isEmpty()) {
                jtfAmaterno.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfAmaterno.setBorder(cons.getOkBorder());
            }
            //
            if (jtfEdad.getText().isEmpty()) {
                jtfEdad.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfEdad.setBorder(cons.getOkBorder());
            }
            //
            if (jtfPassword.getText().isEmpty()) {
                jtfPassword.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfPassword.setBorder(cons.getOkBorder());
            }
            if (i > 0) {
                cons.getMessage("Hay campos", "vacios", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
            return i > 0;
        }

        public void clear() {
            jtfUsuario.setText("");
            jtfNombre.setText("");
            jtfApaterno.setText("");
            jtfAmaterno.setText("");
            jtfEdad.setText("");
            jcbCargo.setSelectedIndex(0);
            jtfPassword.setText("");
            func.clear(info);
            empleado = null;
        }

        public CL_Empleado getEmpleado() {
            info[0] = jtfUsuario.getText();
            info[1] = jtfNombre.getText();
            info[2] = jtfApaterno.getText();
            info[3] = jtfAmaterno.getText();
            info[4] = jtfEdad.getText();
            info[5] = jcbCargo.getItemAt(jcbCargo.getSelectedIndex());
            info[6] = jtfPassword.getText();
            empleado = new CL_Empleado(info);
            return empleado;
        }

    }

    public class Read {

        private Read() {

        }

        public void setModelo(DefaultTableModel tb) {
            jtConsultas.setModel(tb);
        }

    }

    public class Update {

        private CL_Empleado empleado;

        private Update() {
            this.empleado = null;
        }

        public boolean isEmpty() {
            int i = 0;
            //
            if (jtfUsuario_2.getText().isEmpty()) {
                jtfUsuario_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfUsuario_2.setBorder(cons.getOkBorder());
            }
            //
            if (jtfNombre_2.getText().isEmpty()) {
                jtfNombre_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfNombre_2.setBorder(cons.getOkBorder());
            }
            //
            if (jtfApaterno_2.getText().isEmpty()) {
                jtfApaterno_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfApaterno_2.setBorder(cons.getOkBorder());
            }
            //
            if (jtfAmaterno_2.getText().isEmpty()) {
                jtfAmaterno_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfAmaterno_2.setBorder(cons.getOkBorder());
            }
            //
            if (jtfEdad_2.getText().isEmpty()) {
                jtfEdad_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfEdad_2.setBorder(cons.getOkBorder());
            }
            //
            if (jtfPassword_2.getText().isEmpty()) {
                jtfPassword_2.setBorder(cons.getBadBorder());
                i++;
            } else {
                jtfPassword_2.setBorder(cons.getOkBorder());
            }
            if (i > 0) {
                cons.getMessage("Hay campos", "vacios", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
            return i > 0;
        }

        public void clear() {
            jtfUsuario_2.setText("");
            jtfNombre_2.setText("");
            jtfApaterno_2.setText("");
            jtfAmaterno_2.setText("");
            jtfEdad_2.setText("");
            jcbCargo_2.setSelectedIndex(0);
            jtfPassword_2.setText("");
            empleado = null;
        }

        public void setEmpleado(CL_Empleado empleado) {
            this.empleado = empleado;
            showEmpleado();
        }

        public void showEmpleado() {
            jtfID.setText("" + empleado.getID());
            jtfUsuario_2.setText(empleado.getUsuario());
            jtfNombre_2.setText(empleado.getNombre());
            jtfApaterno_2.setText(empleado.getA_paterno());
            jtfAmaterno_2.setText(empleado.getA_materno());
            jtfEdad_2.setText(empleado.getEdad());
            jcbCargo_2.setSelectedItem(empleado.getCargo());
            jtfPassword_2.setText(empleado.getPassword());
        }

        public CL_Empleado getEmpleado() {
            return empleado;
        }

        public JButton getJbtBuscar() {
            return jbtBuscar;
        }

        public String getJtfValue() {
            return jtfValue.getText();
        }
    }

    public class Delete {
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
        jtfEdad = new javax.swing.JTextField();
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
        jcbColum = new javax.swing.JComboBox<>();
        jbtBuscar = new javax.swing.JButton();
        jbtActualizar = new javax.swing.JButton();
        jbtCancelar_2 = new javax.swing.JButton();
        txt9 = new javax.swing.JLabel();
        jtfNombre_2 = new javax.swing.JTextField();
        txt10 = new javax.swing.JLabel();
        jtfApaterno_2 = new javax.swing.JTextField();
        txt11 = new javax.swing.JLabel();
        jtfAmaterno_2 = new javax.swing.JTextField();
        txt12 = new javax.swing.JLabel();
        jtfEdad_2 = new javax.swing.JTextField();
        txt13 = new javax.swing.JLabel();
        jcbCargo_2 = new javax.swing.JComboBox<>();
        txt15 = new javax.swing.JLabel();
        jtfUsuario_2 = new javax.swing.JTextField();
        txt16 = new javax.swing.JLabel();
        jtfPassword_2 = new javax.swing.JTextField();
        txt17 = new javax.swing.JLabel();
        jtfValue = new javax.swing.JTextField();
        txt18 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
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
        jTabbedPane1.setToolTipText("Eliminacion de Registros");

        Panel_Create.setBackground(new java.awt.Color(171, 178, 185));
        Panel_Create.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Create.setLayout(null);

        txt1.setForeground(new java.awt.Color(1, 1, 1));
        txt1.setText("Nombre :");
        Panel_Create.add(txt1);
        txt1.setBounds(30, 20, 200, 25);

        jtfEdad.setBackground(new java.awt.Color(255, 255, 255));
        jtfEdad.setForeground(new java.awt.Color(0, 0, 0));
        jtfEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfEdad.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Create.add(jtfEdad);
        jtfEdad.setBounds(230, 170, 300, 25);

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

        jtConsultas.setBackground(new java.awt.Color(255, 255, 255));
        jtConsultas.setForeground(new java.awt.Color(0, 0, 0));
        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clave", "Nombre", "Marca", "Contenido", "udm", "precio"
            }
        ));
        jtConsultas.setEnabled(false);
        jScrollPane1.setViewportView(jtConsultas);

        Panel_Read.add(jScrollPane1);
        jScrollPane1.setBounds(0, 102, 890, 360);

        jbtConsultar.setText("Actualizar Tabla");
        Panel_Read.add(jbtConsultar);
        jbtConsultar.setBounds(0, 70, 150, 29);

        jTabbedPane1.addTab("Consultar", Panel_Read);

        Panel_Update.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.setLayout(null);

        jcbColum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario" }));
        Panel_Update.add(jcbColum);
        jcbColum.setBounds(210, 10, 100, 25);

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

        txt9.setForeground(new java.awt.Color(1, 1, 1));
        txt9.setText("Nombre :");
        Panel_Update.add(txt9);
        txt9.setBounds(130, 110, 200, 25);

        jtfNombre_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfNombre_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfNombre_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfNombre_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfNombre_2);
        jtfNombre_2.setBounds(330, 110, 300, 25);

        txt10.setForeground(new java.awt.Color(1, 1, 1));
        txt10.setText("Apellido Paterno");
        Panel_Update.add(txt10);
        txt10.setBounds(130, 160, 200, 25);

        jtfApaterno_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfApaterno_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfApaterno_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfApaterno_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfApaterno_2);
        jtfApaterno_2.setBounds(330, 160, 300, 25);

        txt11.setForeground(new java.awt.Color(1, 1, 1));
        txt11.setText("Apellido Materno");
        Panel_Update.add(txt11);
        txt11.setBounds(130, 210, 200, 25);

        jtfAmaterno_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfAmaterno_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfAmaterno_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfAmaterno_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfAmaterno_2);
        jtfAmaterno_2.setBounds(330, 210, 300, 25);

        txt12.setForeground(new java.awt.Color(1, 1, 1));
        txt12.setText("Edad");
        Panel_Update.add(txt12);
        txt12.setBounds(130, 260, 200, 25);

        jtfEdad_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfEdad_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfEdad_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfEdad_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfEdad_2);
        jtfEdad_2.setBounds(330, 260, 300, 25);

        txt13.setForeground(new java.awt.Color(1, 1, 1));
        txt13.setText("Cargo");
        Panel_Update.add(txt13);
        txt13.setBounds(130, 310, 200, 25);

        jcbCargo_2.setBackground(new java.awt.Color(213, 216, 220));
        jcbCargo_2.setForeground(new java.awt.Color(0, 0, 0));
        jcbCargo_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Empleado" }));
        jcbCargo_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Update.add(jcbCargo_2);
        jcbCargo_2.setBounds(330, 310, 300, 25);

        txt15.setForeground(new java.awt.Color(1, 1, 1));
        txt15.setText("Usuario");
        Panel_Update.add(txt15);
        txt15.setBounds(130, 360, 200, 25);

        jtfUsuario_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfUsuario_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfUsuario_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfUsuario_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfUsuario_2);
        jtfUsuario_2.setBounds(330, 360, 300, 25);

        txt16.setForeground(new java.awt.Color(1, 1, 1));
        txt16.setText("Contraseña");
        Panel_Update.add(txt16);
        txt16.setBounds(130, 410, 200, 25);

        jtfPassword_2.setBackground(new java.awt.Color(255, 255, 255));
        jtfPassword_2.setForeground(new java.awt.Color(0, 0, 0));
        jtfPassword_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtfPassword_2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfPassword_2);
        jtfPassword_2.setBounds(330, 410, 300, 25);

        txt17.setForeground(new java.awt.Color(1, 1, 1));
        txt17.setText("Buscar");
        Panel_Update.add(txt17);
        txt17.setBounds(70, 10, 120, 25);

        jtfValue.setBackground(new java.awt.Color(255, 255, 255));
        jtfValue.setForeground(new java.awt.Color(0, 0, 0));
        jtfValue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfValue);
        jtfValue.setBounds(330, 10, 300, 25);

        txt18.setForeground(new java.awt.Color(1, 1, 1));
        txt18.setText("Buscar");
        Panel_Update.add(txt18);
        txt18.setBounds(130, 60, 200, 25);

        jtfID.setBackground(new java.awt.Color(255, 255, 255));
        jtfID.setForeground(new java.awt.Color(0, 0, 0));
        jtfID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Panel_Update.add(jtfID);
        jtfID.setBounds(330, 60, 300, 25);

        jTabbedPane1.addTab("Modificar", Panel_Update);

        Panel_Delete.setBackground(new java.awt.Color(180, 180, 180));
        Panel_Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_Delete.setLayout(null);

        txt14.setForeground(new java.awt.Color(1, 1, 1));
        txt14.setText("Buscar");
        Panel_Delete.add(txt14);
        txt14.setBounds(70, 10, 120, 25);

        jcbMB_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario" }));
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
    private javax.swing.JComboBox<String> jcbCargo_2;
    private javax.swing.JComboBox<String> jcbColum;
    private javax.swing.JComboBox<String> jcbMB_2;
    private javax.swing.JTextField jftMB;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextField jtfAmaterno;
    private javax.swing.JTextField jtfAmaterno_2;
    private javax.swing.JTextField jtfApaterno;
    private javax.swing.JTextField jtfApaterno_2;
    private javax.swing.JTextField jtfEdad;
    private javax.swing.JTextField jtfEdad_2;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfNombre_2;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfPassword_2;
    private javax.swing.JTextField jtfUsuario;
    private javax.swing.JTextField jtfUsuario_2;
    private javax.swing.JTextField jtfValue;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt10;
    private javax.swing.JLabel txt11;
    private javax.swing.JLabel txt12;
    private javax.swing.JLabel txt13;
    private javax.swing.JLabel txt14;
    private javax.swing.JLabel txt15;
    private javax.swing.JLabel txt16;
    private javax.swing.JLabel txt17;
    private javax.swing.JLabel txt18;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt9;
    // End of variables declaration//GEN-END:variables
}
