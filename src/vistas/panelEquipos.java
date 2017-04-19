package vistas;

import dao.DaoComputadora;
import dao.DaoManager;
import dao.mysql.MysqlDaoManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import modelo.Computadora;

public class panelEquipos extends javax.swing.JPanel {

    private String codigo;
    private String estado;
    private String caracteresValidos = "1234567890";
    
    private final String estadoDisponible = "Disponible";
    private final String estadoNoDisponible = "No-Disponible";
    
    private DaoComputadora daoComputadora;
    private DaoManager manager;
    
    private DefaultTableModel model;
    private DefaultTableCellRenderer cellRenderer;
    
    private List<Computadora> listacomputadoras;
    private Computadora computadora = null;
    
    public panelEquipos() {
        initComponents();
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("error manager - Computadora");
        }
        
        actualizarCantidadcomputadoras();
        
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaEquipos.setDefaultRenderer(Object.class, cellRenderer);
        //tablaEquipos.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("codigo");
        model.addColumn("Estado");
        
        mostrarEquiposTabla();
        
        tablaEquipos.setModel(model);
        
        tablaEquipos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent event) {
                
                try{
                    int fila = tablaEquipos.getSelectedRow();
                    codigo = model.getValueAt(fila,0).toString();
                    lblNroCompuradoraSeleccionado.setText(codigo);
                }catch(Exception e){
                    
                }
                
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblCantidadEquipos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnModificar2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cbxEstadoSeleccionado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        lblNroCompuradoraSeleccionado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNroEquipo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cantidad de Equipos:");

        lblCantidadEquipos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadEquipos.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadEquipos.setText("##");

        tablaEquipos.setRequestFocusEnabled(false);
        tablaEquipos.setRowHeight(25);
        tablaEquipos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaEquipos);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sección EQUIPOS usted podrá agregar, modificar, eliminar y ver");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("datos relacionados con las computadoras que están registradas");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("en la unidad de cómputo.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(184, 207, 229));
        jLabel23.setText("Por favor, complete los campos correctamente.");

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

        jPanel6.setBackground(new java.awt.Color(34, 34, 34));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Equipo Selecionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

        btnModificar2.setBackground(new java.awt.Color(34, 70, 135));
        btnModificar2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnModificar2.setForeground(java.awt.Color.white);
        btnModificar2.setText("MODIFICAR");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar2.setFocusable(false);
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnEliminar2.setBackground(new java.awt.Color(34, 70, 135));
        btnEliminar2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnEliminar2.setForeground(java.awt.Color.white);
        btnEliminar2.setText("ELIMINAR");
        btnEliminar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar2.setFocusable(false);
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ESTADO");

        cbxEstadoSeleccionado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxEstadoSeleccionado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No-Disponible" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setText("Computadora N°");
        jLabel22.setToolTipText("");

        lblNroCompuradoraSeleccionado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNroCompuradoraSeleccionado.setForeground(java.awt.Color.white);
        lblNroCompuradoraSeleccionado.setText("##");
        lblNroCompuradoraSeleccionado.setToolTipText("");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxEstadoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel21)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel22)
                        .addGap(1, 1, 1)
                        .addComponent(lblNroCompuradoraSeleccionado)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNroCompuradoraSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstadoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("+ Nuevo Equipo");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NRO EQUIPO");

        txtNroEquipo.setBackground(new java.awt.Color(34, 34, 34));
        txtNroEquipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroEquipo.setForeground(java.awt.Color.white);
        txtNroEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNroEquipo.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ESTADO");

        cbxEstado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No-Disponible" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(135, 135, 135))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(26, 26, 26)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(txtNroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(148, 148, 148)))))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadEquipos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidadEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        codigo = txtNroEquipo.getText();

        if(validarCodigoSinEspacios(codigo)){
            
            if(validarCodigoPurosNumeros(codigo)){
                
                if(cbxEstado.getSelectedItem() == "Disponible"){
                    estado = estadoDisponible;
                }else{
                    estado = estadoNoDisponible;
                }
                
                daoComputadora = manager.getDaoComputadora();
                
                computadora = daoComputadora.obtener(codigo);
                
                if(computadora == null){
                    daoComputadora.insertar(new Computadora(codigo, estado));
                    txtNroEquipo.setText("");
                    eliminarDatosTabla();
                    mostrarEquiposTabla();
                    actualizarCantidadcomputadoras();
                }else{
                    JOptionPane.showMessageDialog(null,"Codigo Ya Existe","Codigo",JOptionPane.WARNING_MESSAGE);
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Solo Se Acepta Numeros","Codigo",JOptionPane.WARNING_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"El codigo no debe posser espacios es blanco","Codigo",JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        if(!"##".equals(lblNroCompuradoraSeleccionado.getText())){
            Object[] opciones = {"Eliminar","Cancelar"};
            int aceptar = JOptionPane.showOptionDialog
                (null,"¿Seguro que desea Eliminarlo?","Eliminar Equipo",
                        JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, opciones,opciones[0]);
            
            if(aceptar == 0){
                codigo = lblNroCompuradoraSeleccionado.getText();
                daoComputadora = manager.getDaoComputadora();
                daoComputadora.eliminar(new Computadora(codigo, null));
                eliminarDatosTabla();
                mostrarEquiposTabla();
                actualizarCantidadcomputadoras();
            }
        
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un Equipo de la Tabla","Equipo",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if(!"##".equals(lblNroCompuradoraSeleccionado.getText())){
            Object[] opciones = {"Modificar","Cancelar"};
            int aceptar = JOptionPane.showOptionDialog
                (null,"¿Seguro que desea Modificarlo?","Eliminar Equipo",
                        JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, opciones,opciones[0]);
            
            if(aceptar == 0){
                
                if(cbxEstadoSeleccionado.getSelectedItem() == estadoDisponible){
                    estado = estadoDisponible;
                }else{
                    estado = estadoNoDisponible;
                }
                
                codigo = lblNroCompuradoraSeleccionado.getText();
                daoComputadora = manager.getDaoComputadora();
                daoComputadora.actualizar(new Computadora(codigo,estado));
                eliminarDatosTabla();
                mostrarEquiposTabla();
                actualizarCantidadcomputadoras();
            }
        
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione un Equipo de la Tabla","Equipo",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    public boolean validarCodigoSinEspacios(String codigo){
        int i;
        for(i=0; i< codigo.length(); i++){
            if(codigo.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarCodigoPurosNumeros(String codigo){
        int i,j;
        boolean band = false;
        for(i=0; i< codigo.length(); i++){
            band =false;
            for(j=0; j<caracteresValidos.length(); j++){
                if(codigo.charAt(i) == caracteresValidos.charAt(j)){
                    band= true;
                }
            }
            
            if(band == false){
                return false;
            } 
        }
        return true;
    }
    
    public void mostrarEquiposTabla(){
        listacomputadoras = null;
        listacomputadoras = new ArrayList<>();
        daoComputadora = manager.getDaoComputadora();
        listacomputadoras = daoComputadora.obtenerTodos();
        
        eliminarDatosTabla();
        listacomputadoras.forEach((computadora) -> {
            model.addRow(new Object[]{computadora.getCodigo(),computadora.getEstado()});
        });
        
    }
    
    public void eliminarDatosTabla(){
        int i;
        int cant = model.getRowCount();
        for(i=0; i< cant; i++){
            model.removeRow(0);
        }
    }

    public void actualizarCantidadcomputadoras(){
        daoComputadora = manager.getDaoComputadora();
        lblCantidadEquipos.setText(daoComputadora.contadorNroComputadoras());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxEstadoSeleccionado;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidadEquipos;
    private javax.swing.JLabel lblNroCompuradoraSeleccionado;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txtNroEquipo;
    // End of variables declaration//GEN-END:variables
}
