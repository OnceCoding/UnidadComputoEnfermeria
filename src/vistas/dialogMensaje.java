
package vistas;

public class dialogMensaje extends javax.swing.JDialog {

    private int x, y;
    
    public dialogMensaje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barra = new javax.swing.JPanel();
        bttSalir = new javax.swing.JButton();
        bttIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));

        barra.setBackground(java.awt.Color.white);
        barra.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMouseDragged(evt);
            }
        });
        barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraMousePressed(evt);
            }
        });

        bttSalir.setBackground(java.awt.Color.white);
        bttSalir.setForeground(new java.awt.Color(153, 153, 153));
        bttSalir.setText("X");
        bttSalir.setBorder(null);
        bttSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttSalir.setFocusable(false);
        bttSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraLayout = new javax.swing.GroupLayout(barra);
        barra.setLayout(barraLayout);
        barraLayout.setHorizontalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        barraLayout.setVerticalGroup(
            barraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(bttSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        bttIngresar.setBackground(new java.awt.Color(34, 70, 135));
        bttIngresar.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        bttIngresar.setForeground(new java.awt.Color(255, 255, 255));
        bttIngresar.setText("INGRESAR");
        bttIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttIngresar.setFocusPainted(false);
        bttIngresar.setFocusable(false);
        bttIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(bttIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(bttIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSalirActionPerformed
        dispose();
    }//GEN-LAST:event_bttSalirActionPerformed

    private void barraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_barraMouseDragged

    private void barraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMousePressed
        this.x = evt.getX();
        this.y = evt.getY();
    }//GEN-LAST:event_barraMousePressed

    private void bttIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttIngresarActionPerformed
        
    }//GEN-LAST:event_bttIngresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barra;
    private javax.swing.JButton bttIngresar;
    private javax.swing.JButton bttSalir;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
