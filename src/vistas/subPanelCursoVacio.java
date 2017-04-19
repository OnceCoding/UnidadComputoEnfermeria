
package vistas;

import javax.swing.JFrame;

public class subPanelCursoVacio extends javax.swing.JPanel {

    JFrame frame;
    
    public subPanelCursoVacio(JFrame frame) {
        initComponents();
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subPanelCurso3 = new javax.swing.JPanel();
        btnIniciarCurso = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        subPanelCurso3.setBackground(new java.awt.Color(34, 34, 34));

        btnIniciarCurso.setBackground(new java.awt.Color(34, 70, 135));
        btnIniciarCurso.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        btnIniciarCurso.setForeground(java.awt.Color.white);
        btnIniciarCurso.setText("INICIAR CURSO");
        btnIniciarCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarCurso.setFocusable(false);
        btnIniciarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarCursoActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("No se está dictando ningun Curso.");

        javax.swing.GroupLayout subPanelCurso3Layout = new javax.swing.GroupLayout(subPanelCurso3);
        subPanelCurso3.setLayout(subPanelCurso3Layout);
        subPanelCurso3Layout.setHorizontalGroup(
            subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelCurso3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarCurso)
                .addGap(18, 18, 18))
        );
        subPanelCurso3Layout.setVerticalGroup(
            subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelCurso3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(subPanelCurso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void btnIniciarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarCursoActionPerformed
        new frmNuevaSesionCurso().setVisible(true);
        frame.dispose();
    }//GEN-LAST:event_btnIniciarCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarCurso;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel subPanelCurso3;
    // End of variables declaration//GEN-END:variables
}
