package vistas;

import dao.DaoManager;
import dao.DaoUsuario;
import dao.mysql.MysqlDaoManager;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Usuario;

public class panelUser extends javax.swing.JPanel {

    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String tipo;
    
    private DaoUsuario daoUsuario;
    private DaoManager manager;
    
    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    
    private String caracterValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMÑOPQRSTUVWXYZ123456789";
    private String caracteresCodigoSeleccionadoValido = "1234567890";
    
    private DefaultTableModel model;
    
    private String buscar;
    
    public panelUser() {
        
        initComponents();
        listaUsuarios = new ArrayList<>();
        radioGroup.add(rbEstudiante);
        radioGroup.add(rbDocente);

        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
        
        actualizarContadorUsuario();
        
        
        //model = new DefaultTableModel();
        model = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Integer.class;
                } else {
                    return Integer.class;
                }
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDO");
        model.addColumn("TIPO");
        model.addColumn("CORREO");
        //model.addColumn("FECHA REGISTRO");
        
        tablaUsuarios.setRowHeight(25);
        mostrarUltimosUsuariosRegistrados();
        tablaUsuarios.setModel(model);

        TableColumnModel columnModel = tablaUsuarios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(25);
        columnModel.getColumn(4).setPreferredWidth(135);
        
        
        tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                
                try{
                    int fila = tablaUsuarios.getSelectedRow();
                    codigo = model.getValueAt(fila,0).toString();
                    nombre = model.getValueAt(fila,1).toString();
                    apellido = model.getValueAt(fila,2).toString();
                    tipo = model.getValueAt(fila,3).toString();
                    email = model.getValueAt(fila,4).toString();

                    txtCodigoSeleccionado.setText(codigo);
                    txtNombreSeleccionado.setText(nombre);
                    txtApellidoSeleccionado.setText(apellido);

                    txtEmailSeleccionado.setText(email);
                }catch(Exception e){
                    
                }
                
                
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        radioGroupSeleccionado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rbEstudiante = new javax.swing.JRadioButton();
        rbDocente = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        lblCantidadUsuarios = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cbxItem = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtNombreSeleccionado = new javax.swing.JTextField();
        txtApellidoSeleccionado = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtEmailSeleccionado = new javax.swing.JTextField();
        txtCodigoSeleccionado = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(1258, 515));

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

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("+ Nuevo Usuario");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(184, 207, 229));
        jLabel19.setText("Por favor, complete todos los campos.");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("CODIGO");

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

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("APELLIDO");

        txtApellido.setBackground(new java.awt.Color(34, 34, 34));
        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellido.setForeground(java.awt.Color.white);
        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("EMAIL");

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

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cantidad de Usuarios:");

        lblCantidadUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadUsuarios.setText("##");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(184, 207, 229));
        jLabel20.setText("Buscar usuario(s)...");

        txtBuscar.setBackground(new java.awt.Color(34, 34, 34));
        txtBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBuscar.setForeground(java.awt.Color.white);
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        cbxItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CODIGO", "APELLIDOS" }));

        btnBuscar.setBackground(new java.awt.Color(184, 207, 229));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Usuario Selecionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("APELLIDO");

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

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("EMAIL");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("NOMBRE");

        txtEmailSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtEmailSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailSeleccionado.setForeground(java.awt.Color.white);
        txtEmailSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmailSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        txtCodigoSeleccionado.setEditable(false);
        txtCodigoSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigoSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoSeleccionado.setForeground(java.awt.Color.white);
        txtCodigoSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("CODIGO");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtApellidoSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombreSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27)
                                .addComponent(jLabel26)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29))
                            .addGap(184, 184, 184))
                        .addComponent(txtEmailSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodigoSeleccionado, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmailSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Nro de Registros Encontrados: ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(184, 207, 229));
        jLabel22.setText("0");

        jScrollPane1.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel25)
                                                .addComponent(jLabel3)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                                .addComponent(txtApellido)
                                                .addComponent(txtNombre)
                                                .addComponent(txtCodigo))
                                            .addComponent(jLabel19)))
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbEstudiante)
                                .addGap(10, 10, 10)
                                .addComponent(rbDocente)))
                        .addGap(63, 63, 63)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(363, 363, 363)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidadUsuarios))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(1873, 1873, 1873))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbEstudiante)
                            .addComponent(rbDocente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCantidadUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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
            
            if(validarCodigo(codigo)){
                
                if(rbEstudiante.isSelected()){
                    if(validarLongitudCodigoEstudiante(codigo)){
                        daoUsuario = manager.getDaoUsuario();
                        usuario = daoUsuario.obtener(codigo);
                        if(usuario == null){
                            daoUsuario.insertar(new Usuario(codigo,nombre,apellido,email,tipo,Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now())));
                            lblCantidadUsuarios.setText(manager.getContadorRegistro().obtenerContadorUsuario());
                            limpiarTabla();
                            mostrarUltimosUsuariosRegistrados();
                            limpiarCamposGuardar();
                        }else{
                            JOptionPane.showMessageDialog(null,"         Codigo Ya Existe","Usuario",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Codigo Estudiante debe poseer 10 digitos","Usuario",JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    if(validarLongitudCodigoDocente(codigo)){
                        daoUsuario = manager.getDaoUsuario();
                        usuario = daoUsuario.obtener(codigo);
                        if(usuario == null){
                            daoUsuario.insertar(new Usuario(codigo,nombre,apellido,email,tipo,Date.valueOf(LocalDate.now()),Time.valueOf(LocalTime.now())));
                            lblCantidadUsuarios.setText(manager.getContadorRegistro().obtenerContadorUsuario());
                            limpiarTabla();
                            mostrarUltimosUsuariosRegistrados();
                            limpiarCamposGuardar();
                        }else{
                            JOptionPane.showMessageDialog(null,"         Codigo Ya Existe","Usuario",JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Codigo Docente debe poseer 5 digitos","Usuario",JOptionPane.WARNING_MESSAGE);
                    }
                } 
                
                
            }else{
                JOptionPane.showMessageDialog(null,"El Campo Codigo no debe poseer espacios en blanco","Usuario",JOptionPane.WARNING_MESSAGE);
            }            
            
        }else{
            JOptionPane.showMessageDialog(null,"Complete los Campos Vacios","Usuario",JOptionPane.WARNING_MESSAGE);
        }
        
        

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        limpiarTabla();
        
       buscar = txtBuscar.getText();
        if(validar(buscar)){
            
            if(cbxItem.getSelectedItem().equals("CODIGO")){
               
                
                daoUsuario = manager.getDaoUsuario();
                usuario = daoUsuario.obtener(buscar);
                
                limpiarTabla();
                if(usuario != null){
                    listaUsuarios.add(usuario);
                    mostrarUsuariosBuscados(listaUsuarios);
                }     
            }else{
                daoUsuario = manager.getDaoUsuario();
                this.listaUsuarios = daoUsuario.obtenerPorApellido(new Usuario(null, null, buscar, null, null, null, null));
                
                limpiarTabla();
                if(listaUsuarios != null){
                    mostrarUsuariosBuscados(listaUsuarios);
                }             
            }           
        }else{
            JOptionPane.showMessageDialog(null,"Ingrese Algun Caracter Valido","Buscar",JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if(txtCodigoSeleccionado.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Porfavor Seleccione algun Usuario de Tabla",
                    "Usuario",JOptionPane.WARNING_MESSAGE);
        }else{
            //true = 0   false = 1
            /*int aceptar = JOptionPane.showConfirmDialog(null,"¿Está Seguro?","Eliminar",
                    JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            */
            
            Object[] options = {"Eliminar","Cancelar"};
            int aceptar = JOptionPane.showOptionDialog(
                    null,"Esta Seguro de Eliminarlo ?","Eliminar",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,null,options,null);
            
            /* Acepto Eliminarlo */
            if(aceptar == 0){
                int fila = tablaUsuarios.getSelectedRow();
                codigo = txtCodigoSeleccionado.getText();
                daoUsuario = manager.getDaoUsuario();
                daoUsuario.eliminar(new Usuario(model.getValueAt(fila,0).toString(),null,null,null,null,null,null));
                limpiarTabla();
                mostrarUltimosUsuariosRegistrados();
                actualizarContadorUsuario();
                limpiarCamposSeleccionados();
            }
            
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(txtCodigoSeleccionado.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Porfavor Seleccione algun Usuario de Tabla",
                    "Usuario",JOptionPane.WARNING_MESSAGE);
        }else{
            //true = 0   false = 1
           
            Object[] options = {"Modificar","Cancelar"};
            int aceptar = JOptionPane.showOptionDialog(
                    null,"Esta Seguro de Eliminarlo ?","Eliminar",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,null,options,null);
            
            /* Acepto Modificarlo */
            if(aceptar == 0){
               
                int fila = tablaUsuarios.getSelectedRow();
                codigo = model.getValueAt(fila,0).toString();
                daoUsuario = manager.getDaoUsuario();
                daoUsuario.actualizar(obtenerDatosSeleccioandos());
                limpiarTabla();
                mostrarUltimosUsuariosRegistrados();
                actualizarContadorUsuario();
                limpiarCamposSeleccionados();
            }
            
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public Usuario obtenerDatosSeleccioandos(){
        codigo = txtCodigoSeleccionado.getText();
        nombre = txtNombreSeleccionado.getText();
        apellido = txtApellidoSeleccionado.getText();
        email = txtEmailSeleccionado.getText();
        return new Usuario(codigo, nombre, apellido,email,null,null,null);
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
    
    public boolean validarCodigo(String codigo){
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
        return codigo.length() == 5;
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
            model.addRow(new Object[]{user.getCodigo(),user.getNombre(),user.getApellido(),user.getTipo(),user.getCorreo()});
        }
        this.listaUsuarios = null;
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void mostrarUsuariosBuscados(List<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
        for (Usuario user : listaUsuarios) {
            model.addRow(new Object[]{user.getCodigo(),user.getNombre(),user.getApellido(),user.getTipo(),user.getCorreo()});
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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxItem;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidadUsuarios;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.ButtonGroup radioGroupSeleccionado;
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
