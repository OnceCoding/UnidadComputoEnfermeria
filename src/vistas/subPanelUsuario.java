
package vistas;

import dao.DaoManager;
import dao.DaoRegistro;
import dao.DaoRegistroTemporal;
import dao.mysql.MysqlDaoManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Registro;
import modelo.RegistroTemporal;
import modelo.SesionesActivas;
import static vistas.panelInicio.subPanelUsuarioPrincipal;

public class subPanelUsuario extends javax.swing.JPanel {

    private JFrame frame;
    
    private DaoManager manager;
    private DaoRegistroTemporal daoRegistroTemporal;
    private DaoRegistro daoRegistro;
    private RegistroTemporal registroTemporal;
    private List<SesionesActivas> listaSesionesActivas;
    
    private DefaultTableCellRenderer renderer;
    private DefaultTableModel model;
    
    private String nroEquipoNuevo;
    /**
     * Creates new form subPanelUsuario
     */
    public subPanelUsuario(JFrame frame) {
        initComponents();
        this.frame = frame;
        //--- Aqui esta el codigo que saque del panelInicio.java
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
            System.out.println("Erro en el manager");
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
        tablaUsuariosActivos.getTableHeader().setReorderingAllowed(false);
        
        renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }          
        };
        
        //ocultar una columna en la tabla 
        tablaUsuariosActivos.removeColumn(tablaUsuariosActivos.getColumnModel().getColumn(0));
        
        tablaUsuariosActivos.setRowHeight(20);
        tablaUsuariosActivos.setDefaultRenderer(Object.class, renderer);
        
        actualizarNroEquiposDisponibles();
        actualizarNroSesionesActivas();
        mostrarSesionesActivas();
        //---fin
        
        tablaUsuariosActivos.getSelectionModel().addListSelectionListener((select)->{
            int fila = tablaUsuariosActivos.getSelectedRow();
            if(fila != -1){
                String nroPc = model.getValueAt(fila,4).toString();
                txtNroPc.setText(nroPc);
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelUsuarios3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuariosActivos = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtNroPc = new javax.swing.JTextField();
        btnElegirEquipo = new javax.swing.JButton();
        btnNuevaSesion = new javax.swing.JButton();
        btnDetenerTodo = new javax.swing.JButton();
        btnDetenerSesion = new javax.swing.JButton();

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

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("N° DE PC:");

        txtNroPc.setEditable(false);
        txtNroPc.setBackground(new java.awt.Color(34, 34, 34));
        txtNroPc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroPc.setForeground(java.awt.Color.white);
        txtNroPc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroPc.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        txtNroPc.setCaretColor(new java.awt.Color(255, 255, 255));

        btnElegirEquipo.setBackground(new java.awt.Color(184, 207, 229));
        btnElegirEquipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnElegirEquipo.setForeground(java.awt.Color.white);
        btnElegirEquipo.setText("ELEGIR");
        btnElegirEquipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnElegirEquipo.setFocusable(false);
        btnElegirEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel35)
                        .addGap(5, 5, 5)
                        .addComponent(txtNroPc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnElegirEquipo))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroPc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnElegirEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        btnNuevaSesion.setBackground(new java.awt.Color(34, 70, 135));
        btnNuevaSesion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnNuevaSesion.setForeground(java.awt.Color.white);
        btnNuevaSesion.setText("NUEVA SESIÓN");
        btnNuevaSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaSesion.setFocusable(false);
        btnNuevaSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaSesionActionPerformed(evt);
            }
        });

        btnDetenerTodo.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerTodo.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerTodo.setForeground(java.awt.Color.white);
        btnDetenerTodo.setText("DETENER TODO");
        btnDetenerTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerTodo.setFocusable(false);
        btnDetenerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerTodoActionPerformed(evt);
            }
        });

        btnDetenerSesion.setBackground(new java.awt.Color(34, 70, 135));
        btnDetenerSesion.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnDetenerSesion.setForeground(java.awt.Color.white);
        btnDetenerSesion.setText("DETENER SESIÓN");
        btnDetenerSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetenerSesion.setFocusable(false);
        btnDetenerSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerSesionActionPerformed(evt);
            }
        });

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
                            .addComponent(btnNuevaSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subPanelUsuarios3Layout.createSequentialGroup()
                                .addComponent(btnDetenerSesion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDetenerTodo)))))
                .addContainerGap())
        );
        subPanelUsuarios3Layout.setVerticalGroup(
            subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelUsuarios3Layout.createSequentialGroup()
                .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelUsuarios3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnNuevaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(subPanelUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDetenerSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetenerTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnNuevaSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSesionActionPerformed
        frame.dispose();
        System.out.println("Nueva sesion");
        new frmNuevaSesion().setVisible(true);
    }//GEN-LAST:event_btnNuevaSesionActionPerformed

    private void btnElegirEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirEquipoActionPerformed
        dialogElegirPc dep = new dialogElegirPc(frame, true);
        dep.setVisible(true);
        
        String nroEquipo = dep.getNroEquipo();
        if(nroEquipo != null){
            txtNroPc.setText(nroEquipo);
        }
        
    }//GEN-LAST:event_btnElegirEquipoActionPerformed

    private void btnDetenerSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerSesionActionPerformed

        int fila = tablaUsuariosActivos.getSelectedRow();

        if(fila < 0){
            DialogMensaje.Error(null,"Seleccione un registro de la Tabla");
        }
        else{
            int codigo = Integer.parseInt(model.getValueAt(fila,0).toString());
            int aceptar = DialogMensaje.Confirmacion(null,"Se detendrá la Sesión ,esta seguro ? ");
            
            if(aceptar == 0){  
                System.out.println("11111");
                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                System.out.println("holaaa");
                registroTemporal = daoRegistroTemporal.obtenerRegistroTemporal(codigo);
                        //System.out.println(registroTemporal.getCodigo());
                daoRegistro = manager.getDaoRegistro();
                daoRegistro.insertar(new Registro(null,registroTemporal.getCodUsuario(),
                        registroTemporal.getCodPC(),registroTemporal.getHoraInicio(),
                        Time.valueOf(LocalTime.now()),registroTemporal.getFecha()));

                daoRegistroTemporal.eliminar(codigo);

                limpiarTabla();
                mostrarSesionesActivas();
                actualizarNroEquiposDisponibles();
                actualizarNroSesionesActivas();
                
                int sesionesActivas = obtenerNroSesisonesActivas();
                System.out.println(sesionesActivas);
                if(sesionesActivas == 0){
                    cambiarPanel(new subPanelUsuarioVacio(frame));
                }
                
            }
        }
    }//GEN-LAST:event_btnDetenerSesionActionPerformed

    private void btnDetenerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerTodoActionPerformed
        
    
    int aceptar = DialogMensaje.Confirmacion(null,"Detener todas la sesiones , ¿ Seguro ?");
    
        if(aceptar == 0){

            int cant = model.getRowCount();
            int i;

            for(i=0; i<cant; i++){
                int fila = 0;
                int codigo = Integer.parseInt(model.getValueAt(fila,0).toString());

                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                registroTemporal = daoRegistroTemporal.obtenerRegistroTemporal(codigo);

                daoRegistro = manager.getDaoRegistro();
                daoRegistro.insertar(new Registro(null,registroTemporal.getCodUsuario(),
                        registroTemporal.getCodPC(),registroTemporal.getHoraInicio(),
                        Time.valueOf(LocalTime.now()),registroTemporal.getFecha()));

                daoRegistroTemporal.eliminar(codigo);

                model.removeRow(0);

            }

            mostrarSesionesActivas();
            actualizarNroEquiposDisponibles();
            actualizarNroSesionesActivas();
        
            cambiarPanel(new subPanelUsuarioVacio(frame));
            
            
        }
    }//GEN-LAST:event_btnDetenerTodoActionPerformed

    public void cambiarPanel(JPanel panelElegido){
        panelElegido.setSize(1209, 384);
        panelElegido.setLocation(6, 15);
        subPanelUsuarioPrincipal.removeAll();
        subPanelUsuarioPrincipal.add(panelElegido,BorderLayout.CENTER);
        subPanelUsuarioPrincipal.revalidate();
        subPanelUsuarioPrincipal.repaint();
    }
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila = tablaUsuariosActivos.getSelectedRow();
        if(fila != -1){
            
            int aceptar = DialogMensaje.Confirmacion(null,"¿ Seguro de eliminarlo ?");
            if(aceptar == 0){
                int codigo = Integer.valueOf(model.getValueAt(fila,0).toString());
                System.out.println(codigo);
                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                daoRegistroTemporal.eliminar(codigo);
                
                actualizarNroEquiposDisponibles();
                limpiarTabla();
                mostrarSesionesActivas();
                
                int sesionesActivas = obtenerNroSesisonesActivas();
                
                if(sesionesActivas == 0){
                    frame.dispose();
                    new frmPrincipal().setVisible(true);
                }
                
            }
            
        }else{
            DialogMensaje.Error(null,"Seleccione un registro de la tabla");
            
        }
   
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int fila = tablaUsuariosActivos.getSelectedRow();
        
        if(fila != -1){
            
            int aceptar = DialogMensaje.Confirmacion(null,"¿ Seguro de Modificarlo ?");
            if(aceptar == 0){
                int codigo = Integer.valueOf(model.getValueAt(fila,0).toString());
                String nroEquipo = txtNroPc.getText();
                daoRegistroTemporal = manager.getDaoRegistroTemporal();
                daoRegistroTemporal.actualizarEquipo(new RegistroTemporal(codigo, null, Integer.valueOf(nroEquipo), null, null, null));
            
                actualizarNroEquiposDisponibles();
                limpiarTabla();
                mostrarSesionesActivas();
                
            }
        }else{
            DialogMensaje.Error(null,"Seleccione un registro de la tabla");
            
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    public void actualizarNroEquiposDisponibles(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        panelInicio.lblCantidadEquiposDisponibles.setText(daoRegistroTemporal.obtenerNroEquiposDisponibles());
    }
    
    public void actualizarNroSesionesActivas(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        panelInicio.lblCantidadSesiones.setText(daoRegistroTemporal.obtenerNroSesionesActivas());
    }
    
    public Integer obtenerNroSesisonesActivas(){
        daoRegistroTemporal = manager.getDaoRegistroTemporal();
        return Integer.valueOf(daoRegistroTemporal.obtenerNroSesionesActivas());
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
    
    public void limpiarTabla(){
        int cant = model.getRowCount();
        int i;
        for(i=0;i<cant;i++){
            model.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetenerSesion;
    private javax.swing.JButton btnDetenerTodo;
    private javax.swing.JButton btnElegirEquipo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevaSesion;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel subPanelUsuarios3;
    private javax.swing.JTable tablaUsuariosActivos;
    private javax.swing.JTextField txtNroPc;
    // End of variables declaration//GEN-END:variables
}
