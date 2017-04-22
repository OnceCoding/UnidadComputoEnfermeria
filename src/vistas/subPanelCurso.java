
package vistas;

import dao.DaoCurso;
import dao.DaoCursoRegistro;
import dao.DaoCursoRegistroTemporal;
import dao.DaoManager;
import dao.mysql.MysqlDaoManager;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import modelo.CursoRegistro;
import modelo.CursoRegistroTemporal;

public class subPanelCurso extends javax.swing.JPanel {

    private DaoManager manager;
    private DaoCursoRegistro daoCursoRegistro;
    private DaoCursoRegistroTemporal daoCursoRegistroTemporal;
    private DaoCurso daoCurso;
    
    private CursoRegistroTemporal cursoRegistroTemporal;
    
    private JFrame frame;
    
    
    public subPanelCurso(JFrame frame) {
        initComponents();
        
        this.frame = frame;
        
        try {
            manager = MysqlDaoManager.getMysqlDaoManager();
        } catch (SQLException e) {
        }
        
        daoCursoRegistroTemporal = manager.getDaoCursoRegistroTemporal();
        daoCurso = manager.getDaoCurso();
        txtCurso.setText(daoCurso.obtener(daoCursoRegistroTemporal.obtenerCursoActual().getCodCurso()).getNombre());
        
        ((JSpinner.DefaultEditor)spnHora.getEditor()).getTextField().setEditable(false);
        ((JSpinner.DefaultEditor)spnMinuto.getEditor()).getTextField().setEditable(false);
        
        int hora = 0;
        
        if(cbxTiempo.getSelectedIndex() == 0){
            hora = Integer.parseInt(spnHora.getValue().toString());

        }else{
            hora = Integer.parseInt(spnHora.getValue().toString()) + 12;
            if(hora == 12){
                hora = 0;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelCurso3 = new javax.swing.JPanel();
        txtCurso = new javax.swing.JLabel();
        spnHora = new javax.swing.JSpinner();
        spnMinuto = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        cbxTiempo = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnCerrarCurso = new javax.swing.JButton();

        subPanelCurso3.setBackground(new java.awt.Color(34, 34, 34));

        txtCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCurso.setForeground(new java.awt.Color(255, 255, 255));
        txtCurso.setText("No hay Curso en este momento");

        spnHora.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        spnMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(":");

        cbxTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

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

        btnCerrarCurso.setBackground(new java.awt.Color(34, 70, 135));
        btnCerrarCurso.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnCerrarCurso.setForeground(java.awt.Color.white);
        btnCerrarCurso.setText("CERRAR SESiON");
        btnCerrarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarCurso.setFocusable(false);
        btnCerrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelCurso3Layout = new javax.swing.GroupLayout(subPanelCurso3);
        subPanelCurso3.setLayout(subPanelCurso3Layout);
        subPanelCurso3Layout.setHorizontalGroup(
            subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelCurso3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subPanelCurso3Layout.createSequentialGroup()
                        .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel17)
                        .addGap(1, 1, 1)
                        .addComponent(spnMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarCurso)))
                .addContainerGap())
        );
        subPanelCurso3Layout.setVerticalGroup(
            subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelCurso3Layout.createSequentialGroup()
                .addComponent(txtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelCurso3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(subPanelCurso3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnMinuto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spnHora, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxTiempo)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanelCurso3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subPanelCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCursoActionPerformed
        daoCursoRegistro = manager.getDaoCursoRegistro();
        daoCursoRegistroTemporal = manager.getDaoCursoRegistroTemporal();
        
        cursoRegistroTemporal = daoCursoRegistroTemporal.obtenerCursoActual();
        daoCursoRegistro.registrarSesionCurso(new CursoRegistro(
                null, cursoRegistroTemporal.getCodCurso(), 
                cursoRegistroTemporal.getHoraInicio(),
                Time.valueOf(LocalTime.now()),
                cursoRegistroTemporal.getFecha()));
        
        daoCursoRegistroTemporal.cerrarSesionCursoActual();
        
        frame.dispose();
        new frmPrincipal().setVisible(true);
        
    }//GEN-LAST:event_btnCerrarCursoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        int aceptar = JOptionPane.showConfirmDialog(null, "Desea modificarlo ?", "Curso", JOptionPane.YES_NO_OPTION);
        
        if(aceptar == 0){
            System.out.println(spnHora.getValue() + " : "+ spnMinuto.getValue());
        }
        
        
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCurso;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxTiempo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JSpinner spnMinuto;
    private javax.swing.JPanel subPanelCurso3;
    private javax.swing.JLabel txtCurso;
    // End of variables declaration//GEN-END:variables
}
