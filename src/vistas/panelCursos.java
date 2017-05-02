
package vistas;

import TablaModel.RendererTablaCurso;
import dao.DaoCurso;
import dao.DaoCursoRegistro;
import dao.DaoCursoRegistroTemporal;
import dao.DaoManager;
import dao.mysql.MysqlDaoManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.CursoRegistroTemporal;

public class panelCursos extends javax.swing.JPanel {

    private Curso curso;
    private List<Curso> listaCursos;
    
    private String nombreCurso;
    private String caracterValidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMÑOPQRSTUVWXYZ123456789";
    
    private DaoManager manager;
    private DaoCurso daoCurso;
    
    private DefaultTableModel model;
    private RendererTablaCurso renderer;
    
    private DaoCursoRegistro daoCursoRegistro;
    private DaoCursoRegistroTemporal daoCursoRegistroTemporal;
    private CursoRegistroTemporal cursoRegistroTemporal;
    
    public panelCursos() {
        initComponents();
            
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE DEL CURSO");
        
        tablaCursos.setRowHeight(25);
        tablaCursos.setModel(model);
        tablaCursos.removeColumn(tablaCursos.getColumnModel().getColumn(0));
        tablaCursos.getTableHeader().setReorderingAllowed(false);
        
        renderer = new RendererTablaCurso();
        tablaCursos.setDefaultRenderer(Object.class, renderer);
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException ex) {
            System.out.println("error");
        }
        
        mostrarTodosLosCursos();
        actualizarLabelCantidadCursos();
        
        
        tablaCursos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            int fila = tablaCursos.getSelectedRow();
            if(fila != -1){
                nombreCurso = model.getValueAt(fila,1).toString();
                txtNombreCursoSeleccionado.setText(nombreCurso); 
            }
        });
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblCantidadCursos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCurso = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtNombreCursoSeleccionado = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNombreCursoModificacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cantidad de Cursos:");

        lblCantidadCursos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidadCursos.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadCursos.setText("##");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sección CURSOS usted podrá agregar, modificar, eliminar y ver");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("los cursos que se han llevado a cabo ");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("en la unidad de cómputo.");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("+ Nuevo Curso");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(184, 207, 229));
        jLabel23.setText("Por favor, complete los campos correctamente.");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRE DEL CURSO");

        txtNombreCurso.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreCurso.setForeground(java.awt.Color.white);
        txtNombreCurso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCurso.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

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

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white), "Curso Seleccionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.white)); // NOI18N

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

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NOMBRE");

        txtNombreCursoSeleccionado.setEditable(false);
        txtNombreCursoSeleccionado.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreCursoSeleccionado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreCursoSeleccionado.setForeground(java.awt.Color.white);
        txtNombreCursoSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCursoSeleccionado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NOMBRE NUEVO");

        txtNombreCursoModificacion.setBackground(new java.awt.Color(34, 34, 34));
        txtNombreCursoModificacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombreCursoModificacion.setForeground(java.awt.Color.white);
        txtNombreCursoModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreCursoModificacion.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreCursoSeleccionado)
                    .addComponent(txtNombreCursoModificacion)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCursoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCursoModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jScrollPane1.setViewportView(tablaCursos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(68, 68, 68))
                                    .addComponent(jLabel17))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(109, 109, 109)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCantidadCursos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(86, 86, 86)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidadCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
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
        
        nombreCurso = txtNombreCurso.getText().toUpperCase();

        if(validar(nombreCurso)){
            
            daoCurso = manager.getDaoCurso();
            
            curso = null;
            curso = daoCurso.obtenerPorNombre(nombreCurso);
            if(curso == null){
                daoCurso.insertar(new Curso(null, nombreCurso));
                txtNombreCurso.setText("");
                limpiarTabla();
                mostrarTodosLosCursos();
                actualizarLabelCantidadCursos(); 
            }else{
                DialogMensaje.Error(null,"Curso con el mismo nombre ya existe");
            }
        }else{
            DialogMensaje.Error(null,"Solo se acepta letras y numeros");
            //JOptionPane.showMessageDialog(null,"Escriba un Nombre Valido","Curso",JOptionPane.WARNING_MESSAGE);
        }
        
 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if(validar(txtNombreCursoSeleccionado.getText())){
            
            /*Object[] options = {"Eliminar","Cancelar"};
            int n = JOptionPane.showOptionDialog(null,"Seguro que desea eliminar el curso , se  eliminaran tambine todos su registros "+txtNombreCursoSeleccionado.getText()
                    ,"Eliminar Curso",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null, options,null);
            */
            
            int n = DialogMensaje.Confirmacion(null,"¿ Seguro que desea eliminar el Curso ? <br> Se eliminara tambien todos los registros de Sesiones. ");
            
            if(n == 0){
                
                daoCursoRegistroTemporal = manager.getDaoCursoRegistroTemporal();
                cursoRegistroTemporal = null;
                cursoRegistroTemporal = daoCursoRegistroTemporal.obtenerCursoActual();
                
                int fila = tablaCursos.getSelectedRow();
                int codigoCurso = Integer.parseInt(model.getValueAt(fila,0).toString());
                
                if(cursoRegistroTemporal != null){
                    if(cursoRegistroTemporal.getCodCurso() != codigoCurso){
                    
                        daoCursoRegistro = manager.getDaoCursoRegistro();
                        daoCursoRegistro.eliminarRegistrosDeUnCurso(codigoCurso);
                        
                        daoCurso = manager.getDaoCurso();
                        daoCurso.eliminar(codigoCurso);

                        limpiarTabla();
                        mostrarTodosLosCursos();
                        actualizarLabelCantidadCursos();
                        limpiarSeleccionados();

                    }else{
                        DialogMensaje.Error(null,"No se puede eliminar el curso <br> El curso se esta dictando en este momento");
                    }
                }else{

                    daoCursoRegistro = manager.getDaoCursoRegistro();
                    daoCursoRegistro.eliminarRegistrosDeUnCurso(codigoCurso);
                    
                    daoCurso = manager.getDaoCurso();
                    daoCurso.eliminar(codigoCurso);

                    limpiarTabla();
                    mostrarTodosLosCursos();
                    actualizarLabelCantidadCursos();
                    limpiarSeleccionados();
                }
            }

        }else{
            DialogMensaje.Error(null, "Seleccione un curso de la tabla");
            //JOptionPane.showMessageDialog(null,"Seleccione un curso de la Tabla");
        }
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        if(validar(txtNombreCursoSeleccionado.getText())){
            if(validar(txtNombreCursoModificacion.getText())){

                int n = DialogMensaje.Confirmacion(null,"¿ Seguro que desea modificar el nombre del curso ?");
                
                if(n == 0){
                    daoCurso = manager.getDaoCurso();
                    int fila = tablaCursos.getSelectedRow();
                    daoCurso.actualizar(new Curso(Integer.parseInt(model.getValueAt(fila, 0).toString()),txtNombreCursoModificacion.getText().toUpperCase()));
                    limpiarTabla();
                    mostrarTodosLosCursos();
                    actualizarLabelCantidadCursos();
                    limpiarSeleccionados();
                }
            }else{
                DialogMensaje.Error(null, "Solo se acepta letras y numeros");
            }
        }else{
            DialogMensaje.Error(null, "Seleccione un curso de la tabla");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    public void limpiarSeleccionados(){
        txtNombreCursoSeleccionado.setText("");
        txtNombreCursoModificacion.setText("");
    }
    
    public void actualizarLabelCantidadCursos(){
        daoCurso = manager.getDaoCurso();
        lblCantidadCursos.setText(daoCurso.obtenerContadorCursos());
    }
    
    public void mostrarTodosLosCursos(){
        listaCursos = null;
        listaCursos = new ArrayList<>();
        
        daoCurso = manager.getDaoCurso();
        listaCursos = daoCurso.obtenerTodos();
        
        listaCursos.forEach((cur)->{
            model.addRow(new String[]{cur.getCodigo().toString(),cur.getNombre()});
        });
        
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
    
    public void limpiarTabla(){
        int cant = tablaCursos.getRowCount();
        int i;
        
        for(i=0; i<cant; i++){
            model.removeRow(0);
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidadCursos;
    private javax.swing.JTable tablaCursos;
    private javax.swing.JTextField txtNombreCurso;
    private javax.swing.JTextField txtNombreCursoModificacion;
    private javax.swing.JTextField txtNombreCursoSeleccionado;
    // End of variables declaration//GEN-END:variables
}
