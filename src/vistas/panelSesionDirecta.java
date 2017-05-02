package vistas;

import com.toedter.calendar.JTextFieldDateEditor;
import dao.DaoComputadora;
import dao.DaoCurso;
import dao.DaoCursoRegistro;
import dao.DaoManager;
import dao.DaoRegistro;
import dao.DaoUsuario;
import dao.mysql.MysqlDaoManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner;
import modelo.Computadora;
import modelo.Curso;
import modelo.CursoRegistro;
import modelo.Registro;
import modelo.Usuario;




public class panelSesionDirecta extends javax.swing.JPanel {

    private DaoManager manager;
    private DaoComputadora daoComputadora;
    private String numerosValidos = "1234567890";
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private DaoRegistro daoRegistro;
    private DaoUsuario daoUsuario;
    private DaoCurso daoCurso;
    private DaoCursoRegistro daoCursoRegistro;
    
    public panelSesionDirecta() {
        initComponents();
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("error manager - Computadora");
        }

        ((JSpinner.DefaultEditor)spinUsuarioHoraInicio.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinUsuarioMinutosInicio.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinUsuarioHoraFin.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinUsuarioMinutosFin.getEditor()).getTextField().setEditable(false);
        
        ((JTextFieldDateEditor)dateFecha.getDateEditor()).setEditable(false);
        
        dateFecha.setDate(new Date());
        
        ((JSpinner.DefaultEditor)spinCursoHoraInicio.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinCursoMinutosInicio.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinCursoHoraFin.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spinCursoMinutosFin.getEditor()).getTextField().setEditable(false);
        
        ((JTextFieldDateEditor)dateFechaCurso.getDateEditor()).setEditable(false);
        
        dateFecha.setDate(new Date());
        dateFechaCurso.setDate(new Date());
        
        verTodosLosEquipos();
        cargarCursos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxEquipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spinUsuarioHoraInicio = new javax.swing.JSpinner();
        spinUsuarioMinutosInicio = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinUsuarioHoraFin = new javax.swing.JSpinner();
        spinUsuarioMinutosFin = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        btnRegistrarSesionUsuario = new javax.swing.JButton();
        cbxHoraInicio = new javax.swing.JComboBox<>();
        cbxHoraFin = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnRegistrarSesionCurso = new javax.swing.JButton();
        dateFechaCurso = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        spinCursoHoraFin = new javax.swing.JSpinner();
        spinCursoMinutosFin = new javax.swing.JSpinner();
        cbxHoraFinCurso = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        spinCursoHoraInicio = new javax.swing.JSpinner();
        spinCursoMinutosInicio = new javax.swing.JSpinner();
        cbxHoraInicioCurso = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbxCurso = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("En esta sección podra registrar una SESION");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("de manera directa para casos en que");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("no se haya guardado anteriormente.");

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "SESION DE USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CODIGO");

        txtCodigoUsuario.setBackground(new java.awt.Color(34, 34, 34));
        txtCodigoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("EQUIPO");

        cbxEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HORA INICIO");

        spinUsuarioHoraInicio.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinUsuarioMinutosInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HORA FIN");

        spinUsuarioHoraFin.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinUsuarioMinutosFin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FECHA");

        btnRegistrarSesionUsuario.setBackground(new java.awt.Color(34, 70, 135));
        btnRegistrarSesionUsuario.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnRegistrarSesionUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarSesionUsuario.setText("REGISTRAR SESION");
        btnRegistrarSesionUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarSesionUsuario.setFocusPainted(false);
        btnRegistrarSesionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSesionUsuarioActionPerformed(evt);
            }
        });

        cbxHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm"}));

        cbxHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm"}));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(jLabel1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(spinUsuarioHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(spinUsuarioMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(spinUsuarioHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(spinUsuarioMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbxHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnRegistrarSesionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinUsuarioHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinUsuarioMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinUsuarioHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinUsuarioMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRegistrarSesionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(34, 34, 34));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "SESION DE CURSO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        btnRegistrarSesionCurso.setBackground(new java.awt.Color(34, 70, 135));
        btnRegistrarSesionCurso.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnRegistrarSesionCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarSesionCurso.setText("REGISTRAR SESION");
        btnRegistrarSesionCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarSesionCurso.setFocusPainted(false);
        btnRegistrarSesionCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSesionCursoActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FECHA");

        spinCursoHoraFin.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinCursoMinutosFin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        cbxHoraFinCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm"}));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HORA FIN");

        spinCursoHoraInicio.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spinCursoMinutosInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        cbxHoraInicioCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "am", "pm"}));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("HORA INICIO");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("CURSO");

        cbxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(spinCursoHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(spinCursoHoraFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(spinCursoMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxHoraFinCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(spinCursoMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxHoraInicioCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(cbxCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarSesionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateFechaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinCursoHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinCursoMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHoraInicioCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinCursoHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinCursoMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxHoraFinCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFechaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarSesionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(184, 207, 229));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Nota:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(184, 207, 229));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Este registro de usuario y/o curso soló se realiza ");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(184, 207, 229));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("cuando se conoce el periodo de duración ");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(184, 207, 229));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("de la sesión.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(167, 167, 167)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel31)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel32)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarSesionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSesionUsuarioActionPerformed
        
        String codigo = txtCodigoUsuario.getText();
        Integer horaInicio = Integer.parseInt(spinUsuarioHoraInicio.getValue().toString());
        Integer minutoInicio = Integer.parseInt(spinUsuarioMinutosInicio.getValue().toString());
        Integer horaFin = Integer.parseInt(spinUsuarioHoraFin.getValue().toString());
        Integer minutoFin = Integer.parseInt(spinUsuarioMinutosFin.getValue().toString());
        Date fecha = dateFecha.getDate();
        Integer equipo = Integer.parseInt(cbxEquipo.getSelectedItem().toString());

        if(!codigo.equals("")){
            if(validarPurosNumeros(codigo)){
                if(fecha != null){

                    //vemos si existe el codigo del Usuario
                    daoUsuario = manager.getDaoUsuario();
                    Usuario usuario = daoUsuario.obtenerPorCodigoUsuario(codigo);
                    if(usuario != null){
                        //Hora Inicio
                        if(cbxHoraInicio.getSelectedIndex() == 0){
                            if(horaInicio == 12){
                                horaInicio = 0;
                            }
                        }else{
                            if(horaInicio != 12){
                                horaInicio = horaInicio + 12;
                            }
                        }
                        
                        //Hora Fin
                        if(cbxHoraFin.getSelectedIndex() == 0){
                            if(horaFin == 12){
                                horaFin = 0;
                            }
                        }else{
                            if(horaFin != 12){
                                horaFin = horaFin + 12;
                            }
                        }
                        
                        if((horaFin > horaInicio) || (horaFin.equals(horaInicio) && minutoFin >= minutoInicio)){
                            //convierto la fecha a Date SQL
                            String fechaString = formato.format(fecha);
                            LocalDate localDate = LocalDate.parse(fechaString);
                            java.sql.Date fechaSql = java.sql.Date.valueOf(localDate);

                            //convierto horas a Time SQL
                            Time timeInicio = Time.valueOf(LocalTime.of(horaInicio,minutoInicio));
                            Time timeFin = Time.valueOf(LocalTime.of(horaFin,minutoFin));

                            int aceptar = DialogMensaje.Confirmacion(null,"¿ Está seguro de registrar la sesión ?");
                            
                            if(aceptar == 0){
                                daoRegistro = manager.getDaoRegistro();
                                daoRegistro.insertar(new Registro(null,usuario.getId(),equipo, timeInicio, timeFin, fechaSql));
                                DialogMensaje.Informacion(null,"Sesión registrada");

                                txtCodigoUsuario.setText("");
                            }

                        }else{
                            DialogMensaje.Error(null,"Error en el orden de las horas");
                        }
                                   
                    }else{
                        DialogMensaje.Error(null,"El codigo no esta registrado");
                    }
                    
                }else{
                    DialogMensaje.Error(null,"Eliga la fecha correspondiente");
                }
            }else{
                DialogMensaje.Error(null,"Solo se aceptan dígitos en el campo Codigo");
            }   
        }else{
            DialogMensaje.Error(null,"Complete el campo Codigo");
        }
   
    }//GEN-LAST:event_btnRegistrarSesionUsuarioActionPerformed

    private void btnRegistrarSesionCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSesionCursoActionPerformed
        
        String nombreCurso = cbxCurso.getSelectedItem().toString();
        Integer horaInicio = Integer.parseInt(spinCursoHoraInicio.getValue().toString());
        Integer minutoInicio = Integer.parseInt(spinCursoMinutosInicio.getValue().toString());
        Integer horaFin = Integer.parseInt(spinCursoHoraFin.getValue().toString());
        Integer minutoFin = Integer.parseInt(spinCursoMinutosFin.getValue().toString());
        Date fecha = dateFechaCurso.getDate();
        
        if(fecha != null){
            //Hora Inicio
            if(cbxHoraInicioCurso.getSelectedIndex() == 0){
                if(horaInicio == 12){
                    horaInicio = 0;
                }
            }else{
                if(horaInicio != 12){
                    horaInicio = horaInicio + 12;
                }
            }

            //Hora Fin
            if(cbxHoraFinCurso.getSelectedIndex() == 0){
                if(horaFin == 12){
                    horaFin = 0;
                }
            }else{
                if(horaFin != 12){
                    horaFin = horaFin + 12;
                }
            }
            
            if((horaFin > horaInicio) || (horaFin.equals(horaInicio) && minutoFin >= minutoInicio)){
                //convierto la fecha a Date SQL
                String fechaString = formato.format(fecha);
                LocalDate localDate = LocalDate.parse(fechaString);
                java.sql.Date fechaSql = java.sql.Date.valueOf(localDate);

                //convierto horas a Time SQL
                Time timeInicio = Time.valueOf(LocalTime.of(horaInicio,minutoInicio));
                Time timeFin = Time.valueOf(LocalTime.of(horaFin,minutoFin));

                int aceptar = DialogMensaje.Confirmacion(null,"¿ Está seguro de registrar la sesión ?");

                if(aceptar == 0){
                    daoCurso = manager.getDaoCurso();
                    Curso curso = daoCurso.obtenerPorNombre(nombreCurso);
                    
                    daoCursoRegistro = manager.getDaoCursoRegistro();
                    daoCursoRegistro.registrarSesionCurso(new CursoRegistro(null,curso.getCodigo(), timeInicio, timeFin, fechaSql));
                    DialogMensaje.Informacion(null,"Sesion registrada");
                }

            }else{
                DialogMensaje.Error(null,"Error en el orden de las horas");
            }
            
            
        }else{
            DialogMensaje.Error(null,"Eliga la fecha correspondiente");
        }
        
        
        
    }//GEN-LAST:event_btnRegistrarSesionCursoActionPerformed

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
    
    public void verTodosLosEquipos(){
        daoComputadora = manager.getDaoComputadora();
        List<Computadora> listaEquipo = daoComputadora.obtenerTodos();
        listaEquipo.forEach((equipo)->{
            cbxEquipo.addItem(equipo.getCodigo().toString());
        });
    }
    
    public void cargarCursos(){
        daoCurso = manager.getDaoCurso();
        List<Curso> listaCursos = daoCurso.obtenerTodos();
        listaCursos.forEach((curso)->{
            cbxCurso.addItem(curso.getNombre());
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarSesionCurso;
    private javax.swing.JButton btnRegistrarSesionUsuario;
    private javax.swing.JComboBox<String> cbxCurso;
    private javax.swing.JComboBox<String> cbxEquipo;
    private javax.swing.JComboBox<String> cbxHoraFin;
    private javax.swing.JComboBox<String> cbxHoraFinCurso;
    private javax.swing.JComboBox<String> cbxHoraInicio;
    private javax.swing.JComboBox<String> cbxHoraInicioCurso;
    private com.toedter.calendar.JDateChooser dateFecha;
    private com.toedter.calendar.JDateChooser dateFechaCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner spinCursoHoraFin;
    private javax.swing.JSpinner spinCursoHoraInicio;
    private javax.swing.JSpinner spinCursoMinutosFin;
    private javax.swing.JSpinner spinCursoMinutosInicio;
    private javax.swing.JSpinner spinUsuarioHoraFin;
    private javax.swing.JSpinner spinUsuarioHoraInicio;
    private javax.swing.JSpinner spinUsuarioMinutosFin;
    private javax.swing.JSpinner spinUsuarioMinutosInicio;
    private javax.swing.JTextField txtCodigoUsuario;
    // End of variables declaration//GEN-END:variables
}
