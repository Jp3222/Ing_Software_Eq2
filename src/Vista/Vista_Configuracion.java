package Vista;

import Controlador.Sistema.Install;
import Controlador.Sistema;
import Modelo.Ficheros;
import Modelo.cons;
import java.io.IOException;

public class Vista_Configuracion extends javax.swing.JFrame {

    private String user, pass, url;
    private Install so;

    public Vista_Configuracion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUrl = new javax.swing.JTextField();
        jtfUser = new javax.swing.JTextField();
        jtfPass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(170, 178, 185));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("J - Shop  ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 280, 400, 20);

        jLabel2.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 30, 100, 25);

        jLabel3.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Usuario");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 100, 25);

        jtfUrl.setBackground(new java.awt.Color(255, 255, 255));
        jtfUrl.setForeground(new java.awt.Color(1, 1, 1));
        jtfUrl.setText("jdbc:mysql://localhost/Tienda");
        jtfUrl.setToolTipText("");
        jPanel1.add(jtfUrl);
        jtfUrl.setBounds(100, 60, 200, 25);

        jtfUser.setBackground(new java.awt.Color(255, 255, 255));
        jtfUser.setForeground(new java.awt.Color(1, 1, 1));
        jtfUser.setText(" ");
        jtfUser.setToolTipText("");
        jPanel1.add(jtfUser);
        jtfUser.setBounds(100, 0, 200, 25);

        jtfPass.setBackground(new java.awt.Color(255, 255, 255));
        jtfPass.setForeground(new java.awt.Color(1, 1, 1));
        jtfPass.setToolTipText("");
        jPanel1.add(jtfPass);
        jtfPass.setBounds(100, 30, 200, 25);

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 120, 200, 29);

        jLabel4.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ruta");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 60, 100, 25);

        jTextArea1.setBackground(new java.awt.Color(171, 178, 185));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("Los datos solicitados son para establecer una conexion\nentre el programa y la base de datos.\n\nEL usuario dado debera tener permisos para poder:\nInsertar\nLeer\nActualizar\nBorrar \nInformacion correspondiente de la base de datos establecida");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 167, 400, 110);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        user = jtfUser.getText();
        pass = jtfPass.getText();
        url = jtfUrl.getText();
        Init();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    private void Init() {
        try {
            Ficheros ft = new Ficheros();
            if (!ft.Exists(cons.url(1) + "/Install.jshop")) {
                so = Sistema.getNodo().getNodoIll();
                so.Install(user, pass, url);
                Sistema s = Sistema.getNodo();
                s.star();
                Vista_Login log = new Vista_Login();
                log.setVisible(true);
            } else {
                Vista_Login log = new Vista_Login();
                log.setVisible(true);
                ft.escribirArchivo(cons.url(1) + "/Usuario.jshop", user + "-" + pass + "-" + url);
            }
        } catch (IOException e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jtfPass;
    private javax.swing.JTextField jtfUrl;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
}
