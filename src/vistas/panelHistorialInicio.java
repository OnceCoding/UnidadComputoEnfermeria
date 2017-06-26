package vistas;


import java.awt.BorderLayout;
import javax.swing.JPanel;


public class panelHistorialInicio extends javax.swing.JPanel {
 
    private JPanel panelContenido;
    
    
    public panelHistorialInicio(JPanel panelContenido) {
        initComponents();
        this.panelContenido = panelContenido;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSesiones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistroSesionCurso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(34, 34, 34));
        setPreferredSize(new java.awt.Dimension(1258, 515));

        panelSesiones.setBackground(new java.awt.Color(34, 34, 34));
        panelSesiones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        panelSesiones.setPreferredSize(new java.awt.Dimension(918, 450));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTROS DE SESIONES");

        btnRegistroSesionCurso.setBackground(new java.awt.Color(34, 70, 135));
        btnRegistroSesionCurso.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        btnRegistroSesionCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroSesionCurso.setText("CURSOS");
        btnRegistroSesionCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroSesionCurso.setFocusable(false);
        btnRegistroSesionCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroSesionCursoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(184, 207, 229));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Por favor, elija la categoría en la que desea consultar");

        btnUsuarios.setBackground(new java.awt.Color(34, 70, 135));
        btnUsuarios.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("USUARIOS");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFocusable(false);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSesionesLayout = new javax.swing.GroupLayout(panelSesiones);
        panelSesiones.setLayout(panelSesionesLayout);
        panelSesionesLayout.setHorizontalGroup(
            panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSesionesLayout.createSequentialGroup()
                .addGroup(panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSesionesLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSesionesLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSesionesLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnRegistroSesionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        panelSesionesLayout.setVerticalGroup(
            panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSesionesLayout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addGroup(panelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistroSesionCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Sección HISTORIAL DE REGISTROS, ");
        jLabel17.setToolTipText("");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("usted podrá ver los registros de las sesiones ");
        jLabel18.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("realizadas por los Usuarios y también");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText(" de los Cursos que se dictaron.");
        jLabel20.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelSesiones, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        //cambiarPanel(new panelHistorialUsuario());
        cambiarPanel(new subPanelHistorialUsuario());
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnRegistroSesionCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroSesionCursoActionPerformed
     
        //cambiarPanel(new panelHistorialCurso());
        cambiarPanel(new subPanelHistorialCurso());
    }//GEN-LAST:event_btnRegistroSesionCursoActionPerformed

    public void cambiarPanel(JPanel panelElegido){
        panelElegido.setSize(911, 474);
        panelElegido.setLocation(1, 2);
        panelSesiones.removeAll();
        panelSesiones.add(panelElegido,BorderLayout.CENTER);
        panelSesiones.revalidate();
        panelSesiones.repaint();
    }
    
    public boolean validarCodigoSinEspacios(String codigo){
        int i;
        for(i=0; i < codigo.length(); i++){
            if(codigo.charAt(i) == ' '){
                return false;
            }
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistroSesionCurso;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JSeparator jSeparator1;
    static javax.swing.JPanel panelSesiones;
    // End of variables declaration//GEN-END:variables
}
