package vistas;

import dao.DaoConfiguracion;
import dao.DaoManager;
import dao.DaoRegistro;
import dao.mysql.MysqlDaoManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.ConfiguracionSemestre;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class panelReportes extends javax.swing.JPanel {

    private ConfiguracionSemestre configuracionSemestre;
    private DaoManager manager;
    private DaoConfiguracion daoConfiguracion;
    private DaoRegistro daoRegistro;
    
    private JFileChooser elegir;
    private String ruta = "";
    
    public panelReportes() {
        
        initComponents();

        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
        }
        daoRegistro = manager.getDaoRegistro();
        mostrarDatosConfiguracionPorDefecto();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser4 = new com.toedter.calendar.JMonthChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        panelSubInicio = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        btnVerSemestre2 = new javax.swing.JButton();
        spinMesInicio1 = new com.toedter.calendar.JMonthChooser();
        spinMesFinal1 = new com.toedter.calendar.JMonthChooser();
        spinMesInicio2 = new com.toedter.calendar.JMonthChooser();
        jLabel27 = new javax.swing.JLabel();
        spinMesFinal2 = new com.toedter.calendar.JMonthChooser();
        year1 = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();
        year2 = new com.toedter.calendar.JYearChooser();
        jLabel2 = new javax.swing.JLabel();
        btnVerSemestre1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        lblRuta = new javax.swing.JLabel();
        btnDescargar = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("datos relevantes");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("usted podrá visualizar ");

        panelSubInicio.setBackground(new java.awt.Color(34, 34, 34));
        panelSubInicio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "REPORTES", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("I SEMESTRE");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Mes Inicio:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Mes Final:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("II SEMESTRE");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Mes Inicio:");

        btnVerSemestre2.setBackground(new java.awt.Color(34, 70, 135));
        btnVerSemestre2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnVerSemestre2.setForeground(java.awt.Color.white);
        btnVerSemestre2.setText("VER REPORTE");
        btnVerSemestre2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerSemestre2.setFocusable(false);
        btnVerSemestre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSemestre2ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Mes Final:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Año:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Año:");

        btnVerSemestre1.setBackground(new java.awt.Color(34, 70, 135));
        btnVerSemestre1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnVerSemestre1.setForeground(java.awt.Color.white);
        btnVerSemestre1.setText("VER REPORTE");
        btnVerSemestre1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerSemestre1.setFocusable(false);
        btnVerSemestre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSemestre1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSubInicioLayout = new javax.swing.GroupLayout(panelSubInicio);
        panelSubInicio.setLayout(panelSubInicioLayout);
        panelSubInicioLayout.setHorizontalGroup(
            panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubInicioLayout.createSequentialGroup()
                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelSubInicioLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSubInicioLayout.createSequentialGroup()
                                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(84, 84, 84))
                                    .addGroup(panelSubInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)))
                                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spinMesInicio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubInicioLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spinMesInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinMesFinal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(panelSubInicioLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerSemestre1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSubInicioLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSubInicioLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinMesFinal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnVerSemestre2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        panelSubInicioLayout.setVerticalGroup(
            panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubInicioLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(btnVerSemestre1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(spinMesFinal1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(year1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spinMesInicio1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerSemestre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11)
                .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubInicioLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(year2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spinMesFinal2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSubInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinMesInicio2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("por semestre.");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("En esta sección de REPORTES");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Seleccione el destino:");

        btnElegir.setBackground(new java.awt.Color(184, 207, 229));
        btnElegir.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnElegir.setForeground(java.awt.Color.white);
        btnElegir.setText("ELEGIR");
        btnElegir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnElegir.setFocusable(false);
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        lblRuta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRuta.setForeground(new java.awt.Color(184, 207, 229));
        lblRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRuta.setText("Carpeta Destino");

        btnDescargar.setBackground(new java.awt.Color(34, 70, 135));
        btnDescargar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDescargar.setForeground(java.awt.Color.white);
        btnDescargar.setText("DESCARGAR REPORTES");
        btnDescargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescargar.setFocusable(false);
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(184, 207, 229));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Nota:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(184, 207, 229));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Los reportes serán generados apartir de las");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(184, 207, 229));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("fechas del lado derecho.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addComponent(lblRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(panelSubInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(panelSubInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnElegir))
                        .addGap(5, 5, 5)
                        .addComponent(lblRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addGap(15, 15, 15)
                        .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnVerSemestre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSemestre2ActionPerformed
        Integer año = year2.getValue();
        Integer mesInicio = spinMesInicio2.getMonth() + 1;
        Integer mesFinal = spinMesFinal2.getMonth() + 1 ;

        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(frmPrincipal.class.getResource("/reportes/reporteSemestre1.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("Titulo","USO DE COMPUTADORAS - SEMESTRE II");
            parametros.put("mesInicio",convertirMes(mesInicio-1).toUpperCase());
            parametros.put("mesFin",convertirMes(mesFinal-1).toUpperCase());
            parametros.put("fechaActual",formatoFecha(LocalDate.now(),1));
            parametros.put("cursos",new JRBeanCollectionDataSource(daoRegistro.obtenerReporteCursoSemestre(año, mesInicio, mesFinal)));
            parametros.put("imagen",frmPrincipal.class.getResource("/imagenes/icono4.png").toString());
            
            JRBeanCollectionDataSource coleccion = new JRBeanCollectionDataSource(daoRegistro.obtenerReporteSemestre(año, mesInicio, mesFinal));
            JasperPrint jp = JasperFillManager.fillReport(jr,parametros,coleccion);

            JasperViewer jv = new JasperViewer(jp,false);
            jv.setTitle("REPORTE DE SEMESTRE II");
            jv.setVisible(true);
            

        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnVerSemestre2ActionPerformed

    private void btnVerSemestre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSemestre1ActionPerformed
        Integer año = year1.getValue();
        Integer mesInicio = spinMesInicio1.getMonth() + 1;
        Integer mesFinal = spinMesFinal1.getMonth() + 1 ;
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(frmPrincipal.class.getResource("/reportes/reporteSemestre1.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("Titulo","USO DE COMPUTADORAS - SEMESTRE I");
            parametros.put("mesInicio",convertirMes(mesInicio-1).toUpperCase());
            parametros.put("mesFin",convertirMes(mesFinal-1).toUpperCase());
            parametros.put("fechaActual",formatoFecha(LocalDate.now(),1));
            parametros.put("cursos",new JRBeanCollectionDataSource(daoRegistro.obtenerReporteCursoSemestre(año, mesInicio, mesFinal)));
            parametros.put("imagen",frmPrincipal.class.getResource("/imagenes/icono4.png").toString());
            
            JRBeanCollectionDataSource coleccion = new JRBeanCollectionDataSource(daoRegistro.obtenerReporteSemestre(año, mesInicio, mesFinal));
            JasperPrint jp = JasperFillManager.fillReport(jr,parametros,coleccion);

            JasperViewer jv = new JasperViewer(jp,false);
            jv.setTitle("REPORTE DE SEMESTRE I");
            jv.setVisible(true);
            
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnVerSemestre1ActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        
        Integer año = year1.getValue();
        Integer mesInicio = spinMesInicio1.getMonth() + 1;
        Integer mesFinal = spinMesFinal1.getMonth() + 1 ;
        
        Integer año2 = year2.getValue();
        Integer mesInicio2 = spinMesInicio2.getMonth() + 1;
        Integer mesFinal2 = spinMesFinal2.getMonth() + 1 ;
        
        if(!"".equals(ruta)){
            try {
                JasperReport jr = (JasperReport) JRLoader.loadObject(frmPrincipal.class.getResource("/reportes/reporteSemestre1.jasper"));
                Map parametros = new HashMap<>();
                parametros.put("Titulo","USO DE COMPUTADORAS - SEMESTRE I");
                parametros.put("mesInicio",convertirMes(mesInicio-1).toUpperCase());
                parametros.put("mesFin",convertirMes(mesFinal-1).toUpperCase());
                parametros.put("fechaActual",formatoFecha(LocalDate.now(),1));
                parametros.put("cursos",new JRBeanCollectionDataSource(daoRegistro.obtenerReporteCursoSemestre(año, mesInicio, mesFinal)));
                parametros.put("imagen",frmPrincipal.class.getResource("/imagenes/icono4.png").toString());
                
                JRBeanCollectionDataSource coleccion = new JRBeanCollectionDataSource(daoRegistro.obtenerReporteSemestre(año, mesInicio, mesFinal));
                JasperPrint jp = JasperFillManager.fillReport(jr,parametros,coleccion);

                OutputStream out = new FileOutputStream(new File(ruta+"\\semestreI-"+año+".pdf"));
                JasperExportManager.exportReportToPdfStream(jp, out);

                JasperReport jr2 = (JasperReport) JRLoader.loadObject(frmPrincipal.class.getResource("/reportes/reporteSemestre1.jasper"));
                Map parametros2 = new HashMap<>();
                parametros2.put("Titulo","USO DE COMPUTADORAS - SEMESTRE II");
                parametros2.put("mesInicio",convertirMes(mesInicio2-1).toUpperCase());
                parametros2.put("mesFin",convertirMes(mesFinal2-1).toUpperCase());
                parametros2.put("fechaActual",formatoFecha(LocalDate.now(),1));
                parametros2.put("cursos",new JRBeanCollectionDataSource(daoRegistro.obtenerReporteCursoSemestre(año2, mesInicio2, mesFinal2)));
                parametros2.put("imagen",frmPrincipal.class.getResource("/imagenes/icono4.png").toString());
                
                JRBeanCollectionDataSource coleccion2 = new JRBeanCollectionDataSource(daoRegistro.obtenerReporteSemestre(año2, mesInicio2, mesFinal2));
                JasperPrint jp2 = JasperFillManager.fillReport(jr2,parametros2,coleccion2);

                OutputStream out2 = new FileOutputStream(new File(ruta+"\\semestreII-"+año2+".pdf"));
                JasperExportManager.exportReportToPdfStream(jp2, out2);
                
                out2.close();
                out.close();
                
                DialogMensaje.Informacion(null,"Se descargaron los reportes con éxito");
                
            } catch (IOException | JRException ex) {
                DialogMensaje.Error(null,"Error al descargar los reportes");
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }else{
            DialogMensaje.Error(null,"Elija la ruta de destino.");
        }
    }//GEN-LAST:event_btnDescargarActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        elegir = new JFileChooser();
        elegir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int n = elegir.showSaveDialog(null);
        
        if(n == 0){
            ruta = elegir.getSelectedFile().getAbsolutePath();
            lblRuta.setText(ruta);
        }
    }//GEN-LAST:event_btnElegirActionPerformed

    public String formatoFecha(LocalDate fechaDate, int tipo){
        String fecha  = "";
        String delimitador = "";
        
        String dia = String.valueOf(fechaDate.getDayOfMonth());
        String mes = String.valueOf(fechaDate.getMonthValue());
        String año = String.valueOf(fechaDate.getYear());
        
        if(dia.trim().length() == 1){
            dia = "0"+dia;
        }
        
        if(mes.trim().length() == 1){
            mes = "0"+mes;
        }
        
        if(tipo == 1){
            delimitador = "-";
        }else{
            delimitador = "/";
        }
        
        return dia + delimitador + mes + delimitador+ año; 
    }
    
    public String convertirMes(int nroMes){
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
        return meses[nroMes];
    }
    
    public void mostrarDatosConfiguracionPorDefecto(){
        spinMesInicio1.setMonth(0);
        spinMesFinal1.setMonth(5);
        year1.setValue(LocalDate.now().getYear());
        
        spinMesInicio2.setMonth(6);
        spinMesFinal2.setMonth(11);
        year2.setValue(LocalDate.now().getYear());
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnVerSemestre1;
    private javax.swing.JButton btnVerSemestre2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JList<String> jList1;
    private com.toedter.calendar.JMonthChooser jMonthChooser4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblRuta;
    private javax.swing.JPanel panelSubInicio;
    private com.toedter.calendar.JMonthChooser spinMesFinal1;
    private com.toedter.calendar.JMonthChooser spinMesFinal2;
    private com.toedter.calendar.JMonthChooser spinMesInicio1;
    private com.toedter.calendar.JMonthChooser spinMesInicio2;
    private com.toedter.calendar.JYearChooser year1;
    private com.toedter.calendar.JYearChooser year2;
    // End of variables declaration//GEN-END:variables

}
