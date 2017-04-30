
package vistas;

import TablaModel.RendererTablaUsuario;
import dao.DaoAdministrador;
import dao.DaoContadorRegistro;
import dao.DaoManager;
import dao.DaoRegistro;
import dao.DaoRegistroTemporal;
import dao.DaoUsuario;
import dao.mysql.MysqlDaoManager;
import java.awt.Color;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Usuario;

public class FrmUsuario extends javax.swing.JFrame {

    private int x, y;
    private DaoManager manager;
    private DaoAdministrador daoAdministrador;
    
    private Integer id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String tipo;
    
    private DaoUsuario daoUsuario;
    private DaoContadorRegistro daoContadorRegistro;
    private DaoRegistroTemporal daoRegistroTemporal;
    private DaoRegistro daoRegistro;
    
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    
    private String caracterValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMÑOPQRSTUVWXYZ1234567890_@";
    private String numerosValidos = "1234567890";
    
    private DefaultTableModel model;
    private RendererTablaUsuario cellRenderer;
    
    private String buscar;
    private int bandBuscar = 0;
    
    public FrmUsuario() {

        initComponents();
        setLocationRelativeTo(null);
        
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/iconoRegistro64.png")).getImage());
        
        cbxItem.setVisible(false);
        txtBuscar.setVisible(false);
        btnCerrar.setVisible(false);
        lbl1.setVisible(false);
        lblEncontrados.setVisible(false);
        
        buttonGroup1.add(rbDocente);
        buttonGroup1.add(rbEstudiante);
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
            DialogMensaje.Error(null,"No hay conexion a la Base de Datos");
            System.exit(0);
        }
        
        actualizarContadorUsuario();
        daoAdministrador = manager.getDaoAdministrador();
        
        frmPrincipal.lblNombreAdmin.setText(daoAdministrador.obtener().getUser());
        
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("ID");
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDO");
        model.addColumn("TIPO");
        model.addColumn("CORREO");
        
        tablaUsuarios.setRowHeight(25);
        mostrarUltimosUsuariosRegistrados();
        tablaUsuarios.setModel(model);
        tablaUsuarios.removeColumn(tablaUsuarios.getColumnModel().getColumn(0));
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        
        cellRenderer = new RendererTablaUsuario();
        tablaUsuarios.setDefaultRenderer(Object.class, cellRenderer);
        
        
        TableColumnModel columnModel = tablaUsuarios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setPreferredWidth(135);
        
        tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                
                int fila = tablaUsuarios.getSelectedRow();
                
                if(fila > -1){
                    id = Integer.parseInt(model.getValueAt(fila, 0).toString());
                    codigo = model.getValueAt(fila,1).toString();
                    nombre = model.getValueAt(fila,2).toString();
                    apellido = model.getValueAt(fila,3).toString();
                    tipo = model.getValueAt(fila,4).toString();
                    email = model.getValueAt(fila,5).toString();

                    txtCodigoSeleccionado.setText(codigo);
                    txtNombreSeleccionado.setText(nombre);
                    txtApellidoSeleccionado.setText(apellido);

                    txtEmailSeleccionado.setText(email);
                    
                    txtCodigoSeleccionado.setEditable(true);
                    txtNombreSeleccionado.setEditable(true);
                    txtApellidoSeleccionado.setEditable(true);
                    txtEmailSeleccionado.setEditable(true);
                }
                
            }
        });
        
        
        txtCodigoSeleccionado.setEditable(false);
        txtNombreSeleccionado.setEditable(false);
        txtApellidoSeleccionado.setEditable(false);
        txtEmailSeleccionado.setEditable(false);
        
        setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rbEstudiante = new javax.swing.JRadioButton();
        rbDocente = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        lblCantidadUsuarios = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cbxItem = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtNombreSeleccionado = new javax.swing.JTextField();
        txtApellidoSeleccionado = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtEmailSeleccionado = new javax.swing.JTextField();
        txtCodigoSeleccionado = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl1 = new javax.swing.JLabel();
        lblEncontrados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jPanel5.setBackground(new java.awt.Color(34, 34, 34));
        jPanel5.setPreferredSize(new java.awt.Dimension(1258, 515));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("+ Nuevo Usuario");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(184, 207, 229));
        jLabel24.setText("Por favor, complete todos los campos.");

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("CODIGO");

        txtCodigo.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigo.setForeground(java.awt.Color.white);
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        txtNombre.setBackground(new java.awt.Color(34, 34, 34));
        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre.setForeground(java.awt.Color.white);
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("APELLIDO");

        txtApellido.setBackground(new java.awt.Color(34, 34, 34));
        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellido.setForeground(java.awt.Color.white);
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("EMAIL");

        txtEmail.setBackground(new java.awt.Color(34, 34, 34));
        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmail.setForeground(java.awt.Color.white);
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        rbEstudiante.setBackground(new java.awt.Color(34, 34, 34));
        rbEstudiante.setForeground(java.awt.Color.white);
        rbEstudiante.setSelected(true);
        rbEstudiante.setText("ESTUDIANTE");
        rbEstudiante.setFocusable(false);

        rbDocente.setBackground(new java.awt.Color(34, 34, 34));
        rbDocente.setForeground(java.awt.Color.white);
        rbDocente.setText("DOCENTE");
        rbDocente.setFocusable(false);
        rbDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDocenteActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Cantidad de Usuarios:");

        lblCantidadUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadUsuarios.setText("##");

        txtBuscar.setBackground(new java.awt.Color(34, 34, 34));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar.setForeground(java.awt.Color.white);
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        cbxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "APELLIDOS" }));

        btnBuscar.setBackground(new java.awt.Color(184, 207, 229));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(34, 34, 34));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Usuario Selecionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("APELLIDO");

        txtNombreSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreSeleccionado.setForeground(java.awt.Color.white);
        txtNombreSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        txtApellidoSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtApellidoSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellidoSeleccionado.setForeground(java.awt.Color.white);
        txtApellidoSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("EMAIL");

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("NOMBRE");

        txtEmailSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtEmailSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailSeleccionado.setForeground(java.awt.Color.white);
        txtEmailSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmailSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        txtCodigoSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigoSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoSeleccionado.setForeground(java.awt.Color.white);
        txtCodigoSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("CODIGO");

        btnModificar.setBackground(new java.awt.Color(34, 70, 135));
        btnModificar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnModificar.setForeground(java.awt.Color.white);
        btnModificar.setText("MODIFICAR");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setFocusable(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(34, 70, 135));
        btnEliminar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnEliminar.setForeground(java.awt.Color.white);
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtApellidoSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35)
                                .addComponent(jLabel34)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37))
                            .addGap(184, 184, 184))
                        .addComponent(txtEmailSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodigoSeleccionado, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnGuardar.setBackground(new java.awt.Color(34, 70, 135));
        btnGuardar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnGuardar.setForeground(java.awt.Color.white);
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl1.setText("Nro de Registros Encontrados: ");

        lblEncontrados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEncontrados.setForeground(new java.awt.Color(184, 207, 229));
        lblEncontrados.setText("0");

        jScrollPane1.setViewportView(tablaUsuarios);

        btnCerrar.setBackground(new java.awt.Color(184, 207, 229));
        btnCerrar.setForeground(java.awt.Color.white);
        btnCerrar.setText("X");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusable(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sección USUARIOS usted podrá realizar");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("modificaciones a los datos de los usuarios ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("que han sido registrados.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(rbEstudiante)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rbDocente))))
                            .addComponent(jLabel14)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel4)
                                        .addComponent(txtEmail)
                                        .addComponent(txtApellido)
                                        .addComponent(txtNombre)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxItem, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblEncontrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbEstudiante)
                    .addComponent(rbDocente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if(bandBuscar == 0){
            btnCerrar.setVisible(true);
            txtBuscar.setVisible(true);
            cbxItem.setVisible(true);
            lbl1.setVisible(true);
            lblEncontrados.setVisible(true);
            bandBuscar++;
        }else if(bandBuscar == 1){
            
            limpiarTabla();

            buscar = txtBuscar.getText();
            if(validar(buscar)){

                if(cbxItem.getSelectedItem().equals("CODIGO")){

                    daoUsuario = manager.getDaoUsuario();
                    usuario = daoUsuario.obtenerPorCodigoUsuario(buscar);

                    limpiarTabla();
                    if(usuario != null){
                        listaUsuarios.add(usuario);
                        lblEncontrados.setText(String.valueOf(listaUsuarios.size()));
                        mostrarUsuariosBuscados(listaUsuarios);
                    }else{
                        lblEncontrados.setText("0");
                    }
                }else{
                    daoUsuario = manager.getDaoUsuario();
                    this.listaUsuarios = daoUsuario.obtenerPorApellido(new Usuario(null,null, null, buscar, null, null, null, null));

                    limpiarTabla();
                    if(listaUsuarios != null){
                        lblEncontrados.setText(String.valueOf(listaUsuarios.size()));
                        mostrarUsuariosBuscados(listaUsuarios);
                    }else{
                        lblEncontrados.setText("0");
                    }
                }
            }else{
                lblEncontrados.setText("0");
                DialogMensaje.Error(null,"Ingrese algún caracter válido");
                
            }
        }
        
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int fila = tablaUsuarios.getSelectedRow();
 
        if(txtCodigoSeleccionado.getText().equals("") || fila == -1){
            DialogMensaje.Error(null,"Seleccione algún usuario de tabla");

        }else{

            codigo = txtCodigoSeleccionado.getText();
            
            if(validarPurosNumeros(codigo)){
                
                int aceptar = DialogMensaje.Confirmacion(null,"¿ Seguro que desea modificarlo ?");

                /* Acepto Modificarlo */
                if(aceptar == 0){

                    daoUsuario = manager.getDaoUsuario();

                    usuario = daoUsuario.obtenerPorCodigoUsuario(codigo);
                    if(usuario == null){
                        daoUsuario.actualizar(obtenerDatosSeleccioandos());
                        limpiarTabla();
                        mostrarUltimosUsuariosRegistrados();
                        actualizarContadorUsuario();
                        limpiarCamposSeleccionados();
                    } else if(usuario.getId().equals(model.getValueAt(fila, 0))){
                        daoUsuario.actualizar(obtenerDatosSeleccioandos());
                        limpiarTabla();
                        mostrarUltimosUsuariosRegistrados();
                        actualizarContadorUsuario();
                        limpiarCamposSeleccionados();
                    } else{
                        DialogMensaje.Error(null,"Código ya existe");
                    }

                }   
            }else{
                DialogMensaje.Error(null,"Sólo se aceptan dígitos");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tablaUsuarios.getSelectedRow();
 
        if(txtCodigoSeleccionado.getText().equals("") || fila == -1){
            DialogMensaje.Error(null,"Seleccione algun usuario de tabla");
        }else{

            int aceptar = DialogMensaje.Confirmacion(null,"¿ Seguro que desea eliminarlo ?");

            /* Acepto Eliminarlo */
            if(aceptar == 0){
                codigo = txtCodigoSeleccionado.getText();
                daoUsuario = manager.getDaoUsuario();
                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                int codigoAeliminar = Integer.parseInt(model.getValueAt(fila, 0).toString());
                boolean band = daoRegistroTemporal.verificarUsuarioActivo(codigoAeliminar);
                if(band == false){

                    aceptar = DialogMensaje.Confirmacion(null,"Se eliminará todos los registros de <br> la unidad de cómputo de ese Usuario");
                    if(aceptar == 0){
                        daoRegistro = manager.getDaoRegistro();
                        daoRegistro.eliminarTodosLosRegistrosDeUnUsuario(codigoAeliminar);
                        daoUsuario.eliminar(new Usuario(codigoAeliminar,null,null,null,null,null,null,null));
                        limpiarTabla();
                        mostrarUltimosUsuariosRegistrados();
                        actualizarContadorUsuario();
                        limpiarCamposSeleccionados();
                    }

                }else{
                    DialogMensaje.Error(null,"No se puede eliminar <br> El usuario se encuentra activo en este momento");
                }
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        codigo = txtCodigo.getText();
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        email = txtEmail.getText();

        if(rbEstudiante.isSelected()){
            tipo = "Estudiante";
        }else{
            tipo = "Docente";
        }

        if(validar(codigo) && validar(nombre) && validar(apellido) && validar(email)){

            if(validarCodigoEspaciosVacios(codigo)){

                if(validarPurosNumeros(codigo)){

                    if(rbEstudiante.isSelected()){
                        if(validarLongitudCodigoEstudiante(codigo)){
                            daoUsuario = manager.getDaoUsuario();
                            usuario = daoUsuario.obtenerPorCodigoUsuario(codigo);
                            if(usuario == null){
                                daoUsuario.insertar(new Usuario(null,codigo,nombre,apellido,email,tipo,Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now())));
                                actualizarContadorUsuario();
                                limpiarTabla();
                                mostrarUltimosUsuariosRegistrados();
                                limpiarCamposGuardar();
                            }else{
                                DialogMensaje.Error(null,"Código ya existe");
                            }
                        }else{
                            DialogMensaje.Error(null,"Código Estudiante debe poseer 10 dígitos");
                        }
                    }else{
                        if(validarLongitudCodigoDocente(codigo)){
                            daoUsuario = manager.getDaoUsuario();
                            usuario = daoUsuario.obtenerPorCodigoUsuario(codigo);
                            if(usuario == null){
                                daoUsuario.insertar(new Usuario(null,codigo,nombre,apellido,email,tipo,Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now())));
                                actualizarContadorUsuario();
                                limpiarTabla();
                                mostrarUltimosUsuariosRegistrados();
                                limpiarCamposGuardar();
                            }else{
                                DialogMensaje.Error(null,"Código ya existe");
                            }
                        }else{
                            DialogMensaje.Error(null,"Código Docente debe poseer 4 dígitos");
                        }
                    }
                }else{
                    DialogMensaje.Error(null,"Código debe poseer solo dígitos");
                }

            }else{
                DialogMensaje.Error(null,"El campo código no debe poseer espacios en blanco");
            }

        }else{
            DialogMensaje.Error(null,"Complete los campos");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rbDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDocenteActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        bandBuscar = 0;
        btnCerrar.setVisible(false);
        txtBuscar.setVisible(false);
        cbxItem.setVisible(false);
        lbl1.setVisible(false);
        lblEncontrados.setVisible(false);
        limpiarTabla();
        mostrarUltimosUsuariosRegistrados();
    }//GEN-LAST:event_btnCerrarActionPerformed
    
     public Usuario obtenerDatosSeleccioandos(){
        codigo = txtCodigoSeleccionado.getText();
        nombre = txtNombreSeleccionado.getText();
        apellido = txtApellidoSeleccionado.getText();
        email = txtEmailSeleccionado.getText();
        return new Usuario(id,codigo, nombre, apellido,email,null,null,null);
    }
    
    public boolean validar(String texto){
        int i,j;
        int sizeTexto = texto.length();
        int sizeCaracteresalidos = caracterValidos.length();
        
        for(i=0; i< sizeTexto; i++){
            for(j=0; j<sizeCaracteresalidos; j++){
                if(texto.charAt(i) == caracterValidos.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean validarPurosNumeros(String codigo){
        int i,j;
        int sizeCodigo = codigo.length();
        int sizeNumerosValidos = numerosValidos.length();
        
        boolean band;
        
        for (i = 0; i < sizeCodigo; i++) {
            band = false;
            for (j = 0; j < sizeNumerosValidos; j++) {
                if(codigo.charAt(i) == numerosValidos.charAt(j)){
                    band = true;
                    break;
                }
            }
            
            if(band == false){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarCodigoEspaciosVacios(String codigo){
        int i;
        for(i=0; i< codigo.length(); i++){
            if(codigo.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarLongitudCodigoEstudiante(String codigo){
        return codigo.length() == 10;
    }
    
    public boolean validarLongitudCodigoDocente(String codigo){
        return codigo.length() == 4;
    }
    
    public void actualizarContadorUsuario(){
        lblCantidadUsuarios.setText(manager.getContadorRegistro().obtenerContadorUsuario());
    } 
    
    public void limpiarCamposGuardar(){
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
    }
    
    public void limpiarCamposSeleccionados(){
        txtCodigoSeleccionado.setText("");
        txtNombreSeleccionado.setText("");
        txtApellidoSeleccionado.setText("");
        txtEmailSeleccionado.setText("");
    }
    
    
    public void mostrarUltimosUsuariosRegistrados(){
        daoUsuario = manager.getDaoUsuario();
        listaUsuarios = daoUsuario.obtenerUltimosRegistros();
        
        for (Usuario user : listaUsuarios) {
            model.addRow(new Object[]{user.getId(),user.getCodigo(),user.getNombre(),user.getApellido(),user.getTipo(),user.getCorreo()});
        }
        this.listaUsuarios = null;
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void mostrarUsuariosBuscados(List<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
        for (Usuario user : listaUsuarios) {
            model.addRow(new Object[]{user.getId(),user.getCodigo(),user.getNombre(),user.getApellido(),user.getTipo(),user.getCorreo()});
        }
        this.listaUsuarios = null;
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void limpiarTabla(){
        this.tablaUsuarios.getSelectionModel().clearSelection();
        this.tablaUsuarios.clearSelection();
        int cant = model.getRowCount();
        int i;
        for(i =0 ; i< cant; i++){
            model.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxItem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblCantidadUsuarios;
    private javax.swing.JLabel lblEncontrados;
    private javax.swing.JRadioButton rbDocente;
    private javax.swing.JRadioButton rbEstudiante;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoSeleccionado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoSeleccionado;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailSeleccionado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreSeleccionado;
    // End of variables declaration//GEN-END:variables
}
