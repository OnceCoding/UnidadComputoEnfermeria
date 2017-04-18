
package vistas;

import dao.DaoManager;
import dao.DaoRegistroTemporal;
import dao.mysql.MysqlDaoManager;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.SesionesActivas;

public class subPanelUsuario extends javax.swing.JPanel {

    private JFrame frame;
    
    private DaoManager manager;
    private DaoRegistroTemporal daoRegistroTemporal;
    private List<SesionesActivas> listaSesionesActivas;
    
    private DefaultTableCellRenderer renderer;
    private DefaultTableModel model;
    /**
     * Creates new form subPanelUsuario
     */
    public subPanelUsuario() {
        initComponents();
        
        //--- Aqui esta el codigo que saque del panelInicio.java
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
        }
        
        model = new DefaultTableModel(){ 
            @Override
            public boolean isCellEditable(int row,int column){
              return false;
            }  
        };
        
        model.addColumn("id");
        model.addColumn("Codigo");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Equipo");
        model.addColumn("Hora Inicio");
       
        tablaUsuariosActivos.setModel(model);
        
        renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }          
        };
        
        tablaUsuariosActivos.removeColumn(tablaUsuariosActivos.getColumnModel().getColumn(0));
        
        tablaUsuariosActivos.setRowHeight(20);
        tablaUsuariosActivos.setDefaultRenderer(Object.class, renderer);
        
        actualizarNroEquiposDisponibles();
        actualizarNroSesionesActivas();
        mostrarSesionesActivas();
        //---fin
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelUsuarios3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuariosActivos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnModificar8 = new javax.swing.JButton();
        btnEliminar8 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtNroPCSelecionado3 = new javax.swing.JTextField();
        jSpinner9 = new javax.swing.JSpinner();
        jSpinner10 = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        btnNuevaSesion1 = new javax.swing.JButton();
        btnDetenerTodo1 = new javax.swing.JButton();
        btnDetenerSesion1 = new javax.swing.JButton();

        subPanelUsuarios3.setBackground(new java.awt.Color(34, 34, 34));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(165, 225));

        tablaUsuariosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaUsuariosActivos);

        jPanel11.setBackground(new java.awt.Color(34, 34, 34));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Sesión Seleccionada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        btnModificar8.setBackground(new java.awt.Color(34, 70, 135));
        btnModificar8.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnModificar8.setForeground(java.awt.Color.white);
        btnModificar8.setText("MODIFICAR");
        btnModificar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar8.setFocusable(false);

        btnEliminar8.setBackground(new java.awt.Color(34, 70, 135));
        btnEliminar8.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnEliminar8.setForeground(java.awt.Color.white);
        btnEliminar8.setText("ELIMINAR");
        btnEliminar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar8.setFocusable(false);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("HORA INICIO:");

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("N° DE PC:");

        txtNroPCSelecionado3.setBackground(new java.awt.Color(34, 34, 34));
        txtNroPCSelecionado3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroPCSelecionado3.setForeground(java.awt.Color.white);
        txtNroPCSelecionado3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroPCSelecionado3.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtNroPCSelecionado3.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText(":");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jButton4.setBackground(new java.awt.Color(184, 207, 229));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(java.awt.Color.white);
        jButton4.setText("ELEGIR");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnModificar8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNroPCSelecionado3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(3, 3, 3)
                                .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4))
                        .addGap(10, 10, 10)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroPCSelecionado3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnNuevaSesion1.setBackground(new java.awt.Color(34, 70, 135));
        btnNuevaSesion1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnNuevaSesion1.setForeground(java.awt.Color.white);
        btnNuevaSesion1.setText("NUEVA SESIÓN");
        btnNuevaSesion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaSesion1.setFocusable(false);
        btnNuevaSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSesion1ActionPerformed(evt);
            }
        });

        btnDetenerTodo1.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerTodo1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerTodo1.setForeground(java.awt.Color.white);
        btnDetenerTodo1.setText("DETENER TODO");
        btnDetenerTodo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerTodo1.setFocusable(false);

        btnDetenerSesion1.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerSesion1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerSesion1.setForeground(java.awt.Color.white);
        btnDetenerSesion1.setText("DETENER SESIÓN");
        btnDetenerSesion1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerSesion1.setFocusable(false);

        javax.swing.GroupLayout subPanelUsuarios3Layout = new javax.swing.GroupLayout(subPanelUsuarios3);
        subPanelUsuarios3.setLayout(subPanelUsuarios3Layout);
        subPanelUsuarios3Layout.setHorizontalGroup(
            subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelUsuarios3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subPanelUsuarios3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnNuevaSesion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subPanelUsuarios3Layout.createSequentialGroup()
                                .addComponent(btnDetenerSesion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetenerTodo1)))
                        .addGap(22, 22, 22)))
                .addContainerGap())
        );
        subPanelUsuarios3Layout.setVerticalGroup(
            subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelUsuarios3Layout.createSequentialGroup()
                .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelUsuarios3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnNuevaSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetenerSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetenerTodo1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subPanelUsuarios3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanelUsuarios3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanelUsuarios3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSesion1ActionPerformed
        dialogNuevaSesion dns = new dialogNuevaSesion(new java.awt.Frame(), true);
        dns.setVisible(true);
    }//GEN-LAST:event_btnNuevaSesion1ActionPerformed

    public void actualizarNroEquiposDisponibles(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        panelInicio.lblCantidadEquiposDisponibles.setText(daoRegistroTemporal.obtenerNroEquiposDisponibles());
    }
    
    public void actualizarNroSesionesActivas(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        panelInicio.lblCantidadSesiones.setText(daoRegistroTemporal.obtenerNroSesionesActivas());
    }
    
    public void mostrarSesionesActivas(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        listaSesionesActivas = new ArrayList<>();
        listaSesionesActivas = daoRegistroTemporal.obtenerSesionesActivas();
        listaSesionesActivas.forEach((sesion)->{
            model.addRow(new Object[]{
                sesion.getRegistroTemporal().getCodigo(),
                sesion.getUsuario().getCodigo(),
                sesion.getUsuario().getNombre(),
                sesion.getUsuario().getApellido(),
                sesion.getRegistroTemporal().getCodPC(),
                sesion.getRegistroTemporal().getHoraInicio()
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetenerSesion1;
    private javax.swing.JButton btnDetenerTodo1;
    private javax.swing.JButton btnEliminar8;
    private javax.swing.JButton btnModificar8;
    private javax.swing.JButton btnNuevaSesion1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JPanel subPanelUsuarios3;
    private javax.swing.JTable tablaUsuariosActivos;
    private javax.swing.JTextField txtNroPCSelecionado3;
    // End of variables declaration//GEN-END:variables
}
