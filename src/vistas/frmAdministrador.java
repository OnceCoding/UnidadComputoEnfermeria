package vistas;

import dao.DaoAdministrador;
import dao.DaoManager;
import dao.mysql.MysqlDaoManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Administrador;

public class frmAdministrador extends javax.swing.JFrame {

    private int x, y;
    private String nombreNuevo;
    private String caracterValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMÑOPQRSTUVWXYZ123456789";
    
    private DaoManager manager;
    private DaoAdministrador daoAdmin;
    private Administrador administrador;
    
    private String usuario;
    private String claveOriginal;
    private String claveNueva;
    
    private boolean bandClaveOriginal;
    private boolean bandClaveNueva;
    
    public frmAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/logolamparaenfermeria2.png")).getImage());
        
        btnListo1.setVisible(false);
        txtNombreNuevo1.setVisible(false);
        btnListo2.setVisible(false);
        txtNombreNuevo2.setVisible(false);
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("Error en la base de datos");
        }
        
        daoAdmin = manager.getDaoAdministrador();
        lblNombreCompletoAdmin.setText(daoAdmin.obtener().getNombreCompleto()); 
        lblUserAdmin.setText(daoAdmin.obtener().getUser()); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCambiarClave = new javax.swing.JButton();
        txtClaveActual = new javax.swing.JTextField();
        txtClaveNueva = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNombreCompletoAdmin = new javax.swing.JLabel();
        btnEditar1 = new javax.swing.JButton();
        txtNombreNuevo1 = new javax.swing.JTextField();
        btnListo1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblUserAdmin = new javax.swing.JLabel();
        btnEditar2 = new javax.swing.JButton();
        txtNombreNuevo2 = new javax.swing.JTextField();
        btnListo2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        bttMinizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(34, 34, 34));

        jPanel4.setBackground(new java.awt.Color(184, 207, 229));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ADMINISTRADOR");

        btnAtras.setBackground(new java.awt.Color(184, 207, 229));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back.png"))); // NOI18N
        btnAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(184, 207, 229)));
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setFocusable(false);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnAtras)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(34, 34, 34));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.white, 1, true), "Cambiar clave", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLAVE ACTUAL");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CLAVE NUEVA");

        btnCambiarClave.setBackground(new java.awt.Color(34, 70, 135));
        btnCambiarClave.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnCambiarClave.setForeground(java.awt.Color.white);
        btnCambiarClave.setText("CAMBIAR CLAVE");
        btnCambiarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarClave.setFocusable(false);
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });

        txtClaveActual.setBackground(new java.awt.Color(34, 34, 34));
        txtClaveActual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtClaveActual.setForeground(java.awt.Color.white);
        txtClaveActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClaveActual.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        txtClaveNueva.setBackground(new java.awt.Color(34, 34, 34));
        txtClaveNueva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtClaveNueva.setForeground(java.awt.Color.white);
        txtClaveNueva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClaveNueva.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtClaveActual)
                    .addComponent(btnCambiarClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveActual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setBackground(new java.awt.Color(184, 207, 229));
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(0, 10));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(34, 34, 34));
        jLabel12.setText("ngy");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(34, 34, 34));
        jLabel13.setText("WR");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(184, 207, 229));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ADMINISTRADOR ");

        lblNombreCompletoAdmin.setFont(new java.awt.Font("Tempus Sans ITC", 0, 22)); // NOI18N
        lblNombreCompletoAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreCompletoAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreCompletoAdmin.setText("Nombre del Administrador");
        lblNombreCompletoAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEditar1.setBackground(new java.awt.Color(184, 207, 229));
        btnEditar1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnEditar1.setForeground(java.awt.Color.white);
        btnEditar1.setText("EDITAR");
        btnEditar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar1.setFocusable(false);
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        txtNombreNuevo1.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreNuevo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombreNuevo1.setForeground(java.awt.Color.white);
        txtNombreNuevo1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreNuevo1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtNombreNuevo1.setCaretColor(new java.awt.Color(255, 255, 255));

        btnListo1.setBackground(new java.awt.Color(34, 70, 135));
        btnListo1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnListo1.setForeground(java.awt.Color.white);
        btnListo1.setText("LISTO");
        btnListo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListo1.setFocusable(false);
        btnListo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListo1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(184, 207, 229));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("USUARIO");

        lblUserAdmin.setFont(new java.awt.Font("Tempus Sans ITC", 0, 22)); // NOI18N
        lblUserAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblUserAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserAdmin.setText("Nombre del Administrador");
        lblUserAdmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEditar2.setBackground(new java.awt.Color(184, 207, 229));
        btnEditar2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnEditar2.setForeground(java.awt.Color.white);
        btnEditar2.setText("EDITAR");
        btnEditar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar2.setFocusable(false);
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });

        txtNombreNuevo2.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreNuevo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombreNuevo2.setForeground(java.awt.Color.white);
        txtNombreNuevo2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreNuevo2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtNombreNuevo2.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombreNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreNuevo2ActionPerformed(evt);
            }
        });

        btnListo2.setBackground(new java.awt.Color(34, 70, 135));
        btnListo2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 11)); // NOI18N
        btnListo2.setForeground(java.awt.Color.white);
        btnListo2.setText("LISTO");
        btnListo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListo2.setFocusable(false);
        btnListo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListo2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(34, 34, 34));
        jLabel16.setText("WR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListo1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreCompletoAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombreNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnListo2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreCompletoAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListo1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnEditar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnListo2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(34, 70, 135));

        jPanel1.setBackground(new java.awt.Color(34, 70, 135));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(34, 70, 135));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        bttMinizar.setBackground(new java.awt.Color(34, 70, 135));
        bttMinizar.setForeground(new java.awt.Color(255, 255, 255));
        bttMinizar.setText("_");
        bttMinizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttMinizar.setFocusable(false);
        bttMinizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMinizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ESCUELA DE ENFERMERIA - UNT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttMinizar)
                .addGap(5, 5, 5)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttMinizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setOpaque(true);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desktop-32-white.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 9)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UNIDAD DE CÓMPUTO E INFORMÁTICA ");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("OLGA YIKA DE TORRE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Universidad Nacional de Trujillo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(84, 84, 84))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        new frmPrincipal().setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void bttMinizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMinizarActionPerformed
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_bttMinizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
        new frmPrincipal().setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        
        claveOriginal = txtClaveActual.getText();
        claveNueva = txtClaveNueva.getText();
        
        administrador = daoAdmin.obtener();
        
        bandClaveOriginal = false;
        if(administrador.getPass().equals(claveOriginal)){
            bandClaveOriginal = true;
        }else{
            DialogMensaje.Error(null,"Contraseña actual incorrecta");
            //JOptionPane.showMessageDialog(rootPane,"Contraseña Actual Incorrecta","Contraseña",JOptionPane.ERROR_MESSAGE);
        }
        
        if(bandClaveOriginal){
            if(revisar(claveNueva)){
                daoAdmin.actualizarContraseña(new Administrador(null, null,claveNueva, null));   
            }else{
                DialogMensaje.Error(null,"Solo se acepta letras o numeros");
               
            }
        }
       
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - this.x, this.getLocation().y + evt.getY() - this.y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        btnListo1.setVisible(true);
        txtNombreNuevo1.setVisible(true);
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnListo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListo1ActionPerformed
        String nombreCompleto = txtNombreNuevo1.getText();
        if(!"".equals(nombreCompleto)){
            daoAdmin.actualizarNombre(new Administrador(null, null, null, nombreCompleto));
            
            lblNombreCompletoAdmin.setText(nombreCompleto);
        }else{
            DialogMensaje.Error(null,"Datos a actualizar incorrectos, verifique." );
        }
        btnListo1.setVisible(false);
        txtNombreNuevo1.setVisible(false);
    }//GEN-LAST:event_btnListo1ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
        btnListo2.setVisible(true);
        txtNombreNuevo2.setVisible(true);
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void btnListo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListo2ActionPerformed
        String user = txtNombreNuevo2.getText();
        if(revisar(user)){
            daoAdmin.actualizarUsuario(new Administrador(null, user, null, null));
            
            lblUserAdmin.setText(user);
        }else{
            DialogMensaje.Error(null,"Datos a actualizar incorrectos, verifique." );
        }
        btnListo2.setVisible(false);
        txtNombreNuevo2.setVisible(false);
    }//GEN-LAST:event_btnListo2ActionPerformed

    private void txtNombreNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreNuevo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreNuevo2ActionPerformed

    /*
        true = valido
        false = no valido
    */
    public boolean revisar(String texto){
        int size = texto.length();
        int sizeCaracteresValidos = this.caracterValidos.length();
        int i,j;
        boolean band = false;
        for(i = 0; i<size; i++){
            band = false;
            for(j=0; j<sizeCaracteresValidos; j++){
                if(texto.charAt(i) == this.caracterValidos.charAt(j)){
                    band = true;
                    break;
                }
            }
            
            if(band == false){
                break;
            }       
        }
        return band;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCambiarClave;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnListo1;
    private javax.swing.JButton btnListo2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton bttMinizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblNombreCompletoAdmin;
    private javax.swing.JLabel lblUserAdmin;
    private javax.swing.JTextField txtClaveActual;
    private javax.swing.JTextField txtClaveNueva;
    private javax.swing.JTextField txtNombreNuevo1;
    private javax.swing.JTextField txtNombreNuevo2;
    // End of variables declaration//GEN-END:variables
}
